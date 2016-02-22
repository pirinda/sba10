/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JComboBox;
import sba.lib.DLibConsts;
import sba.lib.DLibTimeUtils;
import sba.lib.DLibUtils;
import sba.lib.db.DDbDatabase;
import sba.lib.db.DDbDatabaseMonitor;
import sba.lib.db.DDbRegistry;
import sba.lib.grid.DGridPaneView;

/**
 *
 * @author Sergio Flores
 */
public class DGuiSession implements DGuiController {

    protected DGuiClient miClient;
    protected DGuiUser miUser;
    protected DGuiSessionCustom miSessionCustom;
    protected Date mtSystemDate;
    protected Date mtWorkingDate;
    protected Date mtUserTs;
    protected DDbDatabase moDatabase;
    protected DDbDatabaseMonitor moDatabaseMonitor;
    protected Statement miStatement;
    protected DGuiConfigSystem miConfigSystem;
    protected DGuiConfigCompany miConfigCompany;
    protected DGuiConfigBranch miConfigBranch;
    protected DGuiConfigBranch miConfigBranchHq;
    protected DGuiEdsSignature miEdsSignature;
    protected ArrayList<DGuiEdsSignature> maEdsSignatures;
    protected DGuiModuleUtils miModuleUtils;
    protected Vector<DGuiModule> mvModules;

    public DGuiSession(DGuiClient client) {
        miClient = client;
        maEdsSignatures = new ArrayList<>();
        mvModules = new Vector<DGuiModule>();
        initSession();
    }

    private void stopMonitor() {
        if (moDatabaseMonitor != null && moDatabaseMonitor.isAlive()) {
            moDatabaseMonitor.stopThread();
        }
    }

    private void prepareDatabase() {
        try {
            moDatabaseMonitor = new DDbDatabaseMonitor(moDatabase);
            moDatabaseMonitor.startThread();

            miStatement = moDatabase.getConnection().createStatement();
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
    }

    public void initSession() {
        stopMonitor();

        miUser = null;
        miSessionCustom = null;
        mtSystemDate = null;
        mtWorkingDate = null;
        mtUserTs = null;
        moDatabase = null;
        moDatabaseMonitor = null;
        miStatement = null;
        miConfigSystem = null;
        miConfigCompany = null;
        miConfigBranch = null;
        miConfigBranchHq = null;
        miEdsSignature = null;
        miModuleUtils = null;
        mvModules.clear();
    }

    public void setClient(DGuiClient o) { miClient = o; }
    public void setUser(DGuiUser o) { miUser = o; }
    public void setSessionCustom(DGuiSessionCustom o) { miSessionCustom = o; }
    public void setSystemDate(Date t) { mtSystemDate = t; }
    public void setWorkingDate(Date t) { mtWorkingDate = t; }
    public void setUserTs(Date t) { mtUserTs = t; }
    public void setDatabase(DDbDatabase o) { moDatabase = o; prepareDatabase(); }
    public void setStatement(Statement i) { miStatement = i; }
    public void setConfigSystem(DGuiConfigSystem i) { miConfigSystem = i; }
    public void setConfigCompany(DGuiConfigCompany i) { miConfigCompany = i; }
    public void setConfigBranch(DGuiConfigBranch i) { miConfigBranch = i; }
    public void setConfigBranchHq(DGuiConfigBranch i) { miConfigBranchHq = i; }
    public void setEdsSignature(DGuiEdsSignature i) { miEdsSignature = i; }
    public void setModuleUtils(DGuiModuleUtils i) { miModuleUtils = i; }

    public DGuiClient getClient() { return miClient; }
    public DGuiUser getUser() { return miUser; }
    public DGuiSessionCustom getSessionCustom() { return miSessionCustom; }
    public Date getSystemDate() { return mtSystemDate; }
    public Date getWorkingDate() { return mtWorkingDate; }
    public Date getUserTs() { return mtUserTs; }
    public DDbDatabase getDatabase() { return moDatabase; }
    public Statement getStatement() { return miStatement; }
    public DGuiConfigSystem getConfigSystem() { return miConfigSystem; }
    public DGuiConfigCompany getConfigCompany() { return miConfigCompany; }
    public DGuiConfigBranch getConfigBranch() { return miConfigBranch; }
    public DGuiConfigBranch getConfigBranchHq() { return miConfigBranchHq; }
    public DGuiEdsSignature getEdsSignature() { return miEdsSignature; }
    public ArrayList<DGuiEdsSignature> getEdsSignatures() { return maEdsSignatures; }
    public DGuiModuleUtils getModuleUtils() { return miModuleUtils; }
    public Vector<DGuiModule> getModules() { return mvModules; }

    public int getSystemYear() { return DLibTimeUtils.digestYear(mtSystemDate)[0]; }
    public int getWorkingYear() { return DLibTimeUtils.digestYear(mtWorkingDate)[0]; }

    /**
     * Gets signature by key.
     * @param key Signature key.
     */
    public DGuiEdsSignature getEdsSignature(final int[] key) {
        DGuiEdsSignature signature = null;
        
        for (DGuiEdsSignature es : maEdsSignatures) {
            if (DLibUtils.compareKeys(key, es.getKey())) {
                signature = es;
                break;
            }
        }
        
        return signature;
    }

    /**
     * Gets module by module type.
     * @param type Module type. Constants defined in DModConsts (MOD_...).
     */
    public DGuiModule getModule(final int type) {
        return getModule(type, DLibConsts.UNDEFINED);
    }

    /**
     * Gets module by module type and subtype.
     * @param type Module type. Constants defined in DModConsts (MOD_...).
     * @param type Module subtype. Constants defined in DModSysConsts (CS_MOD_...).
     */
    public DGuiModule getModule(final int type, final int subtype) {
        DGuiModule module = null;

        for (DGuiModule mod : mvModules) {
            if (type == mod.getModuleType() && (subtype == mod.getModuleSubtype() || subtype == DLibConsts.UNDEFINED)) {
                module = mod;
                break;
            }
        }

        return module;
    }

    /**
     * Gets module by GUI type and subtype (i.e. registry, view, form, etc.).
     */
    public DGuiModule getModuleByGuiType(final int type, final int subtype) {
        DGuiModule module = null;
        int moduleType = miModuleUtils.getModuleTypeByType(type);
        int moduleSubtype = miModuleUtils.getModuleSubtypeBySubtype(type, subtype);

        for (DGuiModule mod : mvModules) {
            if (moduleType == mod.getModuleType() && (moduleSubtype == mod.getModuleSubtype() || moduleSubtype == DLibConsts.UNDEFINED)) {
                module = mod;
                break;
            }
        }

        return module;
    }

    public void notifySuscriptors(final int suscriptor) {
        int count = miClient.getTabbedPane().getTabCount();

        try {
            DGuiUtils.setCursorWait(miClient);

            for (int index = 0; index < count; index++) {
                ((DGridPaneView) miClient.getTabbedPane().getComponentAt(index)).triggerSuscription(suscriptor);
            }
        }
        catch (Exception e) {
            DLibUtils.printException(this, e);
        }
        finally {
            DGuiUtils.setCursorDefault(miClient);
        }
    }

    @Override
    public DDbRegistry getRegistry(final int type, final DGuiParams params) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).getRegistry(type, params);
    }

    @Override
    public void populateCatalogue(JComboBox comboBox, final int type, final int subtype, final DGuiParams params) {
        getModuleByGuiType(type, subtype).populateCatalogue(comboBox, type, subtype, params);
    }

    @Override
    public void showView(final int type, final int subtype, final DGuiParams params) {
        getModuleByGuiType(type, subtype).showView(type, subtype, params);
    }

    @Override
    public void showOptionPicker(final int type, final int subtype, final DGuiParams params, final DGuiField field) {
        getModuleByGuiType(type, subtype).showOptionPicker(type, subtype, params, field);
    }

    @Override
    public void showForm(final int type, final int subtype, final DGuiParams params) {
        getModuleByGuiType(type, subtype).showForm(type, subtype, params);
    }

    @Override
    public void printReport(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap) {
        getModuleByGuiType(type, subtype).printReport(type, subtype, params, paramsMap);
    }

    @Override
    public void printReportNow(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap, final boolean withPrintDialog) {
        getModuleByGuiType(type, subtype).printReportNow(type, subtype, params, paramsMap, withPrintDialog);
    }

    @Override
    public Vector<DGuiItem> readItems(final int type, final int subtype, final DGuiParams params) {
        return getModuleByGuiType(type, subtype).readItems(type, subtype, params);
    }

    /**
     * Reads database registry (reading verbose mode).
     * @param type Registry type.
     * @param pk Registry primary key.
     */
    @Override
    public DDbRegistry readRegistry(final int type, final int[] pk) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).readRegistry(type, pk);
    }

    /**
     * Reads database registry.
     * @param type Registry type.
     * @param pk Registry primary key.
     * @param mode Reading mode. Constants defined in DDbConsts (MODE_VERBOSE, MODE_STEALTH).
     */
    @Override
    public DDbRegistry readRegistry(final int type, final int[] pk, final int mode) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).readRegistry(type, pk, mode);
    }

    @Override
    public int saveRegistry(final DDbRegistry registry) {
        return getModuleByGuiType(registry.getRegistryType(), DLibConsts.UNDEFINED).saveRegistry(registry);
    }

    @Override
    public int disableRegistry(final int type, final int[] pk) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).disableRegistry(type, pk);
    }

    @Override
    public int deleteRegistry(final int type, final int[] pk) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).deleteRegistry(type, pk);
    }

    @Override
    public Object readField(final int type, final int[] pk, final int field) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).readField(type, pk, field);
    }

    @Override
    public int saveField(final int type, final int[] pk, final int field, final Object value) {
        return getModuleByGuiType(type, DLibConsts.UNDEFINED).saveField(type, pk, field, value);
    }

    @Override
    public void finalize() throws Throwable {
        stopMonitor();
    }
}
