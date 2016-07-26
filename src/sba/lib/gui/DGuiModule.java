/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sba.lib.DLibConsts;
import sba.lib.DLibUtils;
import sba.lib.db.DDbConsts;
import sba.lib.db.DDbRegistry;
import sba.lib.grid.DGridConsts;
import sba.lib.grid.DGridPaneView;
import sba.lib.grid.DGridTabComponent;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGuiModule implements DGuiController {

    private static final int ACTION_SAVE = 1;
    private static final int ACTION_DISABLE = 2;
    private static final int ACTION_DELETE = 3;

    protected DGuiClient miClient;
    protected int mnModuleType;
    protected int mnModuleSubtype;
    protected JMenu[] maMenus;
    protected DDbRegistry moLastRegistry;
    protected HashMap<Integer, DGuiForm> moUserFormsMap;
    protected ImageIcon moModuleIcon;

    public DGuiModule(DGuiClient client, int type, int subtype) {
        miClient = client;
        mnModuleType = type;
        mnModuleSubtype = subtype;
        maMenus = null;
        moLastRegistry = null;
        moUserFormsMap = null;
        moModuleIcon = null;
    }

    /*
     * Private methods
     */

    private void startTransaction() throws SQLException, Exception {
        miClient.getSession().getStatement().execute("START TRANSACTION");
    }

    private void commitTransaction() throws SQLException, Exception {
        miClient.getSession().getStatement().execute("COMMIT");
    }

    private void rollbackTransaction() throws SQLException, Exception {
        miClient.getSession().getStatement().execute("ROLLBACK");
    }

    private int computeAction(final DDbRegistry registry, final int action) {
        int result = DLibConsts.UNDEFINED;

        try {
            DGuiUtils.setCursorWait(miClient);
            startTransaction();

            switch (action) {
                case ACTION_SAVE:
                    if (registry.canSave(miClient.getSession())) {
                        registry.save(miClient.getSession());
                    }
                    else {
                        throw new Exception(DDbConsts.MSG_REG_DENIED_UPDATE +
                                (registry.getQueryResult().length() == 0 ? "" : "\n" + registry.getQueryResult()));
                    }
                    break;
                case ACTION_DISABLE:
                    if (registry.canDisable(miClient.getSession())) {
                        registry.disable(miClient.getSession());
                    }
                    else {
                        throw new Exception(DDbConsts.MSG_REG_DENIED_DISABLE +
                                (registry.getQueryResult().length() == 0 ? "" : "\n" + registry.getQueryResult()));
                    }
                    break;
                case ACTION_DELETE:
                    if (registry.canDelete(miClient.getSession())) {
                        registry.delete(miClient.getSession());
                    }
                    else {
                        throw new Exception(DDbConsts.MSG_REG_DENIED_DELETE +
                                (registry.getQueryResult().length() == 0 ? "" : "\n" + registry.getQueryResult()));
                    }
                    break;
                default:
                    throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
            }

            result = registry.getQueryResultId();

            if (registry.getPostSaveTarget() != null && registry.getPostSaveMethod() != null) {
                DLibUtils.invoke(registry.getPostSaveTarget(), registry.getPostSaveMethod(), registry.getPostSaveMethodArgs());
            }
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, registry.getSql());
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            try {
                if (result == DDbConsts.SAVE_OK) {
                    commitTransaction();
                }
                else {
                    rollbackTransaction();
                }
            }
            catch (Exception e) {
                DLibUtils.showException(this, e);
            }

            DGuiUtils.setCursorDefault(miClient);
        }

        return result;
    }

    /*
     * Public methods
     */

    public void setUserFormsMap(HashMap<Integer, DGuiForm> o) { moUserFormsMap = o; }

    public int getModuleType() { return mnModuleType; }
    public int getModuleSubtype() { return mnModuleSubtype; }
    public DDbRegistry getLastRegistry() { return moLastRegistry; }
    public HashMap<Integer, DGuiForm> getUserFormsMap() { return moUserFormsMap; }
    public ImageIcon getModuleIcon() { return moModuleIcon; }

    public abstract JMenu[] getMenus();
    public abstract DDbRegistry getRegistry(final int type, final DGuiParams params);
    public abstract DGuiCatalogueSettings getCatalogueSettings(final int type, final int subtype, final DGuiParams params);
    public abstract DGridPaneView getView(final int type, final int subtype, final DGuiParams params);
    public abstract DGuiOptionPicker getOptionPicker(final int type, final int subtype, final DGuiParams params);
    public abstract DGuiForm getForm(final int type, final int subtype, final DGuiParams params);
    public abstract DGuiReport getReport(final int type, final int subtype, final DGuiParams params);

    @Override
    @SuppressWarnings("unchecked")
    public void populateCatalogue(JComboBox comboBox, final int type, final int subtype, final DGuiParams params) {
        Vector<DGuiItem> items = readItems(type, subtype, params);

        comboBox.removeAllItems();
        for (DGuiItem item : items) {
            comboBox.addItem(item);
        }
    }

    @Override
    public void showView(final int type, final int subtype, final DGuiParams params) {
        int count = 0;
        int index = 0;
        int mode = params == null ? DLibConsts.UNDEFINED : params.getType();
        int submode = params == null ? DLibConsts.UNDEFINED : params.getSubtype();
        boolean exists = false;
        DGridPaneView paneView = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            count = miClient.getTabbedPane().getTabCount();
            for (index = 0; index < count; index++) {
                if (miClient.getTabbedPane().getComponentAt(index) instanceof DGridPaneView) {
                    paneView = (DGridPaneView) miClient.getTabbedPane().getComponentAt(index);
                    if (type == paneView.getGridType() && subtype == paneView.getGridSubtype() &&
                            mode == paneView.getGridMode() && submode == paneView.getGridSubmode()) {
                        exists = true;
                        break;
                    }
                }
            }

            if (exists) {
                miClient.getTabbedPane().setSelectedIndex(index);
            }
            else {
                paneView = getView(type, subtype, params);
                paneView.populateGrid(DGridConsts.REFRESH_MODE_RESET);
                miClient.getTabbedPane().addTab(paneView.getTitle(), paneView);
                miClient.getTabbedPane().setTabComponentAt(count, new DGridTabComponent(miClient, moModuleIcon));
                miClient.getTabbedPane().setSelectedIndex(count);
                miClient.getTabbedPane().getComponentAt(count).requestFocus();
            }
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }
    }

    @Override
    public void showOptionPicker(final int type, final int subtype, final DGuiParams params, final DGuiField field) {
        DGuiOptionPicker picker = getOptionPicker(type, subtype, params);

        picker.resetPicker();
        picker.setOption(field.getValue());
        picker.setPickerVisible(true);

        if (picker.getPickerResult() == DGuiConsts.FORM_RESULT_OK) {
            field.setValue(picker.getOption());
            field.getComponent().requestFocus();
        }
    }

    @Override
    public void showForm(final int type, final int subtype, final DGuiParams params) {
        DGuiForm form = null;
        DDbRegistry registry = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            form = getForm(type, subtype, params);
            registry = getRegistry(type, params);
            moLastRegistry = null;

            if (params == null) {
                registry.setFormAction(DGuiConsts.FORM_ACTION_NEW);
            }
            else {
                if (params.getKey() == null) {
                    registry.setFormAction(DGuiConsts.FORM_ACTION_NEW);
                }
                else {
                    registry.read(miClient.getSession(), params.getKey());

                    if (!params.isCopy()) {
                        registry.setFormAction(DGuiConsts.FORM_ACTION_EDIT);
                    }
                    else {
                        registry.setFormAction(DGuiConsts.FORM_ACTION_NEW);
                        registry.setRegistryNew(true);
                    }
                }
            }

            form.setRegistry(registry);

            if (form.canShowForm()) {
                if (params != null) {
                    for (Integer key : params.getParamsMap().keySet()) {
                        form.setValue(key, params.getParamsMap().get(key));
                    }
                }
            }

            DGuiUtils.setCursorDefault(miClient);

            form.setFormVisible(true);

            if (form.getFormResult() == DGuiConsts.FORM_RESULT_OK) {
                registry = form.getRegistry();

                if (miClient.getSession().saveRegistry(registry) != DDbConsts.SAVE_OK) {
                    moLastRegistry = null;
                }
                else {
                    moLastRegistry = registry.clone();
                    moLastRegistry.setRegistryEdited(true);
                    miClient.getSession().notifySuscriptors(moLastRegistry.getRegistryType());
                }
            }
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, registry.getSql());
        }
        catch (IllegalAccessException e) {
            DLibUtils.showException(this, e);
        }
         catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }
    }

    @Override
    public void printReport(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap) {
        File file = null;
        DGuiReport report = null;
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            report = getReport(type, subtype, params);
            file = new File(report.getFileName());
            jasperReport = (JasperReport) JRLoader.loadObject(file);
            jasperPrint = JasperFillManager.fillReport(jasperReport, paramsMap, miClient.getSession().getStatement().getConnection());
            jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle(report.getReportTitle());
            jasperViewer.setVisible(true);
        }
        catch (JRException e) {
            DLibUtils.showException(this, e);
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }
    }

    @Override
    public void printReportNow(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap, final boolean withPrintDialog) {
        File file = null;
        DGuiReport report = null;
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            report = getReport(type, subtype, params);
            file = new File(report.getFileName());
            jasperReport = (JasperReport) JRLoader.loadObject(file);
            jasperPrint = JasperFillManager.fillReport(jasperReport, paramsMap, miClient.getSession().getStatement().getConnection());
            JasperPrintManager.printReport(jasperPrint, withPrintDialog);
        }
        catch (JRException e) {
            DLibUtils.showException(this, e);
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }
    }

    @Override
    public Vector<DGuiItem> readItems(final int type, final int subtype, final DGuiParams params) {
        int i = 0;
        int[] key = null;
        ResultSet resultSet = null;
        DGuiItem item = null;
        Vector<DGuiItem> items = null;
        DGuiCatalogueSettings settings = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            items = new Vector<DGuiItem>();
            settings = getCatalogueSettings(type, subtype, params);

            if (settings.isSelectionItemApplying()) {
                items.add(new DGuiItem("- " + settings.getCatalogueName() + " -"));
            }

            resultSet = miClient.getSession().getStatement().executeQuery(settings.getSql());
            while (resultSet.next()) {
                key = new int[settings.getPrimaryKeyLength()];
                for (i = 1; i <= settings.getPrimaryKeyLength(); i++) {
                    key[i - 1] = resultSet.getInt(DDbConsts.FIELD_ID + i);
                }

                item = new DGuiItem(key, resultSet.getString(DDbConsts.FIELD_ITEM));

                if (settings.getForeignKeyLength() > 0) {
                    key = new int[settings.getForeignKeyLength()];
                    for (i = 1; i <= settings.getForeignKeyLength(); i++) {
                        key[i - 1] = resultSet.getInt(DDbConsts.FIELD_FK + i);
                    }

                    item.setForeignKey(key);
                }

                if (settings.isComplementApplying()) {
                    switch (settings.getComplementDataType()) {
                        case DLibConsts.DATA_TYPE_INT:
                            item.setComplement(resultSet.getInt(DDbConsts.FIELD_COMP));
                            break;
                        case DLibConsts.DATA_TYPE_DEC:
                            item.setComplement(resultSet.getDouble(DDbConsts.FIELD_COMP));
                            break;
                        case DLibConsts.DATA_TYPE_BOOL:
                            item.setComplement(resultSet.getBoolean(DDbConsts.FIELD_COMP));
                            break;
                        case DLibConsts.DATA_TYPE_TEXT:
                            item.setComplement(resultSet.getString(DDbConsts.FIELD_COMP));
                            break;
                        case DLibConsts.DATA_TYPE_DATE:
                            item.setComplement(resultSet.getDate(DDbConsts.FIELD_COMP));
                            break;
                        default:
                            throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                    }
                }

                if (settings.isCodeApplying()) {
                    item.setCode(resultSet.getString(DDbConsts.FIELD_CODE));
                }

                item.setCodeVisible(settings.isCodeVisible());

                if (settings.isDateApplying()) {
                    item.setDate(resultSet.getDate(DDbConsts.FIELD_DATE));
                }

                if (settings.isValueApplying()) {
                    item.setValue(resultSet.getDouble(DDbConsts.FIELD_VALUE));
                }

                items.add(item);
            }
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, settings.getSql());
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }

        return items;
    }

    /**
     * Reads database registry (reading verbose mode).
     * @param type Registry type.
     * @param pk Registry primary key.
     */
    @Override
    public DDbRegistry readRegistry(final int type, final int[] pk) {
        return readRegistry(type, pk, DDbConsts.MODE_VERBOSE);
    }

    /**
     * Reads database registry.
     * @param type Registry type.
     * @param pk Registry primary key.
     * @param mode Reading mode. Constants defined in DDbConsts (MODE_VERBOSE, MODE_STEALTH).
     */
    @Override
    public DDbRegistry readRegistry(final int type, final int[] pk, final int mode) {
        DDbRegistry registry = null;

        try {
            DGuiUtils.setCursorWait(miClient);

            registry = getRegistry(type, null);
            registry.read(miClient.getSession(), pk);
            if (registry.getQueryResultId() != DDbConsts.READ_OK) {
                throw new Exception(DDbConsts.ERR_MSG_REG_NOT_FOUND);
            }
        }
        catch (SQLException e) {
            if (mode == DDbConsts.MODE_VERBOSE) {
                DLibUtils.showException(this, e);
            }
            else {
                DLibUtils.printException(this, e);
            }

            DLibUtils.printSqlQuery(this, registry.getSql());
        }
        catch (Exception e) {
            if (mode == DDbConsts.MODE_VERBOSE) {
                DLibUtils.showException(this, e);
            }
            else {
                DLibUtils.printException(this, e);
            }
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }

        return registry;
    }

    @Override
    public int saveRegistry(final DDbRegistry registry) {
        return computeAction(registry, ACTION_SAVE);
    }

    @Override
    public int disableRegistry(final int type, final int[] pk) {
        int result = DLibConsts.UNDEFINED;
        DDbRegistry registry = readRegistry(type, pk);

        if (registry.getQueryResultId() == DDbConsts.READ_OK) {
            result = computeAction(registry, ACTION_DISABLE);
        }

        return result;
    }

    @Override
    public int deleteRegistry(final int type, final int[] pk) {
        int result = DLibConsts.UNDEFINED;
        DDbRegistry registry = readRegistry(type, pk);

        if (registry.getQueryResultId() == DDbConsts.READ_OK) {
            result = computeAction(registry, ACTION_DELETE);
        }

        return result;
    }

    @Override
    public Object readField(final int type, final int[] pk, final int field) {
        Object value = null;
        DDbRegistry registry = null;

        try {
            registry = getRegistry(type, null);
            value = registry.readField(miClient.getSession().getStatement(), pk, field);
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, registry.getSql());
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }

        return value;
    }

    @Override
    public int saveField(final int type, final int[] pk, final int field, final Object value) {
        int result = DLibConsts.UNDEFINED;
        DDbRegistry registry = null;

        try {
            registry = getRegistry(type, null);
            registry.saveField(miClient.getSession().getStatement(), pk, field, value);
            result = DDbConsts.SAVE_OK;
        }
        catch (SQLException e) {
            result = DDbConsts.SAVE_ERROR;
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, registry.getSql());
        }
        catch (Exception e) {
            result = DDbConsts.SAVE_ERROR;
            DLibUtils.showException(this, e);
        }

        return result;
    }
}
