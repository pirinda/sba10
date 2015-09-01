/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DGridPaneForm.java
 *
 * Created on 14/06/2011, 09:25:19 AM
 */

package sba.lib.grid;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import sba.lib.DLibConsts;
import sba.lib.DLibRpnArgument;
import sba.lib.DLibUtils;
import sba.lib.db.DDbConsts;
import sba.lib.db.DDbRegistry;
import sba.lib.grid.xml.DXmlColumnForm;
import sba.lib.grid.xml.DXmlGridXml;
import sba.lib.grid.xml.DXmlRpnArgument;
import sba.lib.grid.xml.DXmlSortKey;
import sba.lib.gui.DGuiClient;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiForm;
import sba.lib.gui.DGuiParams;
import sba.lib.gui.DGuiUserGui;
import sba.lib.gui.DGuiUtils;
import sba.lib.gui.bean.DBeanOptionPicker;
import sba.lib.xml.DXmlElement;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridPaneForm extends JPanel implements DGridPane, TableModelListener {

    protected DGuiClient miClient;
    protected int mnGridType;
    protected int mnGridSubtype;
    protected int mnGridMode;
    protected int mnGridSubmode;
    protected boolean mbIsOptionPicker;
    protected String msName;
    protected DGuiParams moPaneParams;
    protected DGuiParams moFormParams;

    protected DGridModel moModel;
    protected DGridSeeker moSeeker;
    protected List<RowSorter.SortKey> miSortKeysList;
    protected DGuiForm miForm;
    protected DGridPaneFormOwner miPaneFormOwner;
    protected DBeanOptionPicker moOptionPickerOwner;
    protected Vector<DGridRow> mvDeletedRows;

    protected int[] manUserGuiKey;
    protected DGuiUserGui miUserGui;

    /** Creates new form DGridPaneForm */
    public DGridPaneForm(DGuiClient client, int gridType, int gridSubtype, String name) {
        this(client, gridType, gridSubtype, false, name, null);
    }

    /** Creates new form DGridPaneForm */
    public DGridPaneForm(DGuiClient client, int gridType, int gridSubtype, String name, DGuiParams params) {
        this(client, gridType, gridSubtype, false, name, params);
    }

    /** Creates new form DGridPaneForm */
    public DGridPaneForm(DGuiClient client, int gridType, int gridSubtype, boolean isOptionPicker, String name) {
        this(client, gridType, gridSubtype, isOptionPicker, name, null);
    }

    /** Creates new form DGridPaneForm */
    public DGridPaneForm(DGuiClient client, int gridType, int gridSubtype, boolean isOptionPicker, String name, DGuiParams params) {
        miClient = client;
        mnGridType = gridType;
        mnGridSubtype = gridSubtype;
        mnGridMode = params == null ? DLibConsts.UNDEFINED : params.getType();
        mnGridSubmode = params == null ? DLibConsts.UNDEFINED : params.getSubtype();
        mbIsOptionPicker = isOptionPicker;
        msName = name;
        moPaneParams = params;
        moFormParams = null;

        initComponents();
        initComponentsCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jpCommands = new javax.swing.JPanel();
        jpCommandsSys = new javax.swing.JPanel();
        jpCommandsSysLeft = new javax.swing.JPanel();
        jbRowNew = new javax.swing.JButton();
        jbRowEdit = new javax.swing.JButton();
        jbRowDelete = new javax.swing.JButton();
        jpCommandsSysCenter = new javax.swing.JPanel();
        jpCommandsSysRight = new javax.swing.JPanel();
        jbGridSaveCsv = new javax.swing.JButton();
        jbGridClearSettings = new javax.swing.JButton();
        jspScrollPane = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setLayout(new java.awt.BorderLayout());

        jpCommands.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        jpCommands.setLayout(new java.awt.BorderLayout());

        jpCommandsSys.setLayout(new java.awt.BorderLayout());

        jpCommandsSysLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jbRowNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_new.gif"))); // NOI18N
        jbRowNew.setToolTipText("Nuevo (Ctrl+N)");
        jbRowNew.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowNewActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowNew);

        jbRowEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_edit.gif"))); // NOI18N
        jbRowEdit.setToolTipText("Modificar (Ctrl+M)");
        jbRowEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowEditActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowEdit);

        jbRowDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_delete.gif"))); // NOI18N
        jbRowDelete.setToolTipText("Eliminar (Ctrl+E)");
        jbRowDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowDeleteActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowDelete);

        jpCommandsSys.add(jpCommandsSysLeft, java.awt.BorderLayout.WEST);

        jpCommandsSysCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jpCommandsSys.add(jpCommandsSysCenter, java.awt.BorderLayout.CENTER);

        jpCommandsSysRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jbGridSaveCsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_save.gif"))); // NOI18N
        jbGridSaveCsv.setToolTipText("Guardar como CSV (Ctrl+G)");
        jbGridSaveCsv.setPreferredSize(new java.awt.Dimension(23, 23));
        jbGridSaveCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGridSaveCsvActionPerformed(evt);
            }
        });
        jpCommandsSysRight.add(jbGridSaveCsv);

        jbGridClearSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reset.gif"))); // NOI18N
        jbGridClearSettings.setToolTipText("Limpiar preferencias (Ctrl+L)");
        jbGridClearSettings.setPreferredSize(new java.awt.Dimension(23, 23));
        jbGridClearSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGridClearSettingsActionPerformed(evt);
            }
        });
        jpCommandsSysRight.add(jbGridClearSettings);

        jpCommandsSys.add(jpCommandsSysRight, java.awt.BorderLayout.EAST);

        jpCommands.add(jpCommandsSys, java.awt.BorderLayout.PAGE_START);

        add(jpCommands, java.awt.BorderLayout.NORTH);

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jspScrollPane.setViewportView(jtTable);

        add(jspScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jbRowNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowNewActionPerformed
        actionRowNew();
    }//GEN-LAST:event_jbRowNewActionPerformed

    private void jbRowEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowEditActionPerformed
        actionRowEdit();
    }//GEN-LAST:event_jbRowEditActionPerformed

    private void jbRowDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowDeleteActionPerformed
        actionRowDelete();
    }//GEN-LAST:event_jbRowDeleteActionPerformed

    private void jbGridSaveCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridSaveCsvActionPerformed
        actionGridSaveCsv();
    }//GEN-LAST:event_jbGridSaveCsvActionPerformed

    private void jbGridClearSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridClearSettingsActionPerformed
        actionGridClearSettings();
    }//GEN-LAST:event_jbGridClearSettingsActionPerformed

    private void initComponentsCustom() {
        moModel = new DGridModel();
        moSeeker = new DGridSeeker(miClient.getFrame());
        miSortKeysList = new ArrayList<RowSorter.SortKey>();
        miForm = null;
        miPaneFormOwner = null;
        mvDeletedRows = new Vector<DGridRow>();

        jbRowNew.setEnabled(true);
        jbRowEdit.setEnabled(true);
        jbRowDelete.setEnabled(true);
        jbGridSaveCsv.setEnabled(true);
        jbGridClearSettings.setEnabled(true);

        manUserGuiKey = new int[] { miClient.getSession().getUser().getPkUserId(), DGuiConsts.GUI_COMP_FORM, mnGridType, mnGridSubtype, mnGridMode, mnGridSubmode };
        miUserGui = miClient.readUserGui(manUserGuiKey);

        moModel.addTableModelListener(this);

        DGuiUtils.createActionMap(this, this, "actionRowNew", "rowNew", KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowEdit", "rowEdit", KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowDelete", "rowDelete", KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridSaveCsv", "gridSaveCsv", KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridClearSettings", "gridClearSettings", KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK);

        initGrid();
    }

    protected void computeUserGui() {
        DXmlGridXml gridXml = new DXmlGridXml(DGridConsts.GRID_PANE_FORM);

        miSortKeysList.clear();

        try {
            gridXml.processXml(miUserGui.getGui());
            for (DXmlElement element : gridXml.getXmlElements()) {
                if (element instanceof DXmlColumnForm) {
                    // Columns:

                    DXmlColumnForm xmlColumn = (DXmlColumnForm) element;
                    DGridColumnForm gridColumn = new DGridColumnForm(
                            (Integer) xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_TYPE).getValue(),
                            (String) xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_TITLE).getValue(),
                            (Integer) xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_WIDTH).getValue());
                    gridColumn.setEditable((Boolean) xmlColumn.getAttribute(DXmlColumnForm.ATT_IS_EDITABLE).getValue());

                    moModel.getGridColumns().add(gridColumn);
                }
                else if (element instanceof DXmlSortKey) {
                    // Sort keys:

                    DXmlSortKey xmlSortKey = (DXmlSortKey) element;
                    RowSorter.SortKey sortKey = null;
                    SortOrder sortOrder = null;
                    String sortOrderValue = (String) xmlSortKey.getAttribute(DXmlSortKey.ATT_SORT_ORDER).getValue();

                    if (sortOrderValue.compareTo(SortOrder.ASCENDING.toString()) == 0) {
                        sortOrder = SortOrder.ASCENDING;
                    }
                    else if (sortOrderValue.compareTo(SortOrder.DESCENDING.toString()) == 0) {
                        sortOrder = SortOrder.DESCENDING;
                    }
                    else {
                        sortOrder = SortOrder.UNSORTED;
                    }

                    sortKey = new RowSorter.SortKey(
                            (Integer) xmlSortKey.getAttribute(DXmlSortKey.ATT_COLUMN).getValue(),
                            sortOrder);

                    miSortKeysList.add(sortKey);
                }
            }
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
    }

    protected void preserveUserGui() {
        if (jtTable != null && jtTable.getRowSorter() != null) {
            String xml = "";
            DXmlGridXml gridXml = new DXmlGridXml(DGridConsts.GRID_PANE_FORM);
            @SuppressWarnings("unchecked")
            List<RowSorter.SortKey> sortKeys = (List<RowSorter.SortKey>) jtTable.getRowSorter().getSortKeys();

            // Columns:

            for (int i = 0; i < jtTable.getColumnCount(); i++) {
                DXmlColumnForm xmlColumn = new DXmlColumnForm();
                DGridColumnForm gridColumn = (DGridColumnForm) (moModel.getGridColumns().get(jtTable.convertColumnIndexToModel(i)));

                xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_TYPE).setValue(gridColumn.getColumnType());
                xmlColumn.getAttribute(DXmlColumnForm.ATT_FIELD_NAME).setValue(gridColumn.getFieldName());
                xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_TITLE).setValue(gridColumn.getColumnTitle());
                xmlColumn.getAttribute(DXmlColumnForm.ATT_COLUMN_WIDTH).setValue(jtTable.getColumnModel().getColumn(i).getWidth());
                xmlColumn.getAttribute(DXmlColumnForm.ATT_IS_EDITABLE).setValue(gridColumn.isEditable());

                for (DLibRpnArgument argument : gridColumn.getRpnArguments()) {
                    DXmlRpnArgument xmlArgument = new DXmlRpnArgument();
                    xmlArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT_TYPE).setValue(argument.getArgumentType());
                    xmlArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT).setValue(argument.getArgument());
                    xmlColumn.getXmlElements().add(xmlArgument);
                }

                gridXml.getXmlElements().add(xmlColumn);
            }

            // Sort keys:

            if (sortKeys.isEmpty()) {
                sortKeys = new ArrayList<RowSorter.SortKey>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));    // just in case there are not sort keys
            }
            else {
                for (RowSorter.SortKey sortKey : sortKeys) {
                    DXmlSortKey xmlSortKey = new DXmlSortKey();
                    xmlSortKey.getAttribute(DXmlSortKey.ATT_COLUMN).setValue(jtTable.convertColumnIndexToView(sortKey.getColumn()));
                    xmlSortKey.getAttribute(DXmlSortKey.ATT_SORT_ORDER).setValue(sortKey.getSortOrder().toString());
                    gridXml.getXmlElements().add(xmlSortKey);
                }
            }

            xml = gridXml.getXmlString();
            miUserGui = miClient.saveUserGui(manUserGuiKey, xml);
        }
    }

    protected void resetGrid() {
        moModel.clearGrid();
        if (jtTable != null) {
            jtTable.invalidate();
            validate();
        }

        mvDeletedRows.clear();
    }

    protected void resetGridRows() {
        moModel.clearGridRows();
        if (jtTable != null) {
            jtTable.invalidate();
            validate();
        }

        mvDeletedRows.clear();
    }

    protected void createGridForm(ListSelectionListener listSelectionListener_n) {
        DGridColumnForm column = null;

        // Create columns in table model:

        clearGrid();

        if (miUserGui != null) {
            computeUserGui();       // customized columns added into moModel and sort keys into miSortKeysList
        }
        else {
            initSortKeys();
            createGridColumns();    // default columns added into moModel
        }

        // Create table:

        jtTable = new JTable(moModel);
        jtTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jtTable.setColumnSelectionAllowed(false);
        jtTable.setRowSorter(new TableRowSorter<AbstractTableModel>(moModel));
        jtTable.setTableHeader(new DGridHeader(jtTable.getColumnModel(), moModel.getColumnNames()));
        jtTable.getTableHeader().setReorderingAllowed(false);

        if (listSelectionListener_n != null) {
            jtTable.getSelectionModel().addListSelectionListener(listSelectionListener_n);
        }

        jtTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (mbIsOptionPicker) {
                        if (moOptionPickerOwner != null) {
                            moOptionPickerOwner.actionOk();
                        }
                        else if (miPaneFormOwner != null && miPaneFormOwner instanceof DGuiForm) {
                            ((DGuiForm) miPaneFormOwner).actionSave();
                        }
                    }
                    else {
                        actionMouseClicked();
                    }
                }
            }
        });

        jtTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (mbIsOptionPicker && evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    evt.consume();
                    if (moOptionPickerOwner != null) {
                        moOptionPickerOwner.actionOk();
                    }
                    else if (miPaneFormOwner != null && miPaneFormOwner instanceof DGuiForm) {
                        ((DGuiForm) miPaneFormOwner).actionSave();
                    }
                }
                else {
                    moSeeker.handleKeyPressedEvent(evt, getSeekerLocation());
                    if (moSeeker.isSeekRequested()) {
                        DGridUtils.seekValue(DGridPaneForm.this, moSeeker.getText());
                    }
                }
            }
        });

        for (int i = 0; i < moModel.getColumnCount(); i++) {
            column = (DGridColumnForm) moModel.getGridColumns().get(i);

            jtTable.getColumnModel().getColumn(i).setPreferredWidth(column.getColumnWidth());

            if (column.getCellRenderer() != null) {
                jtTable.getColumnModel().getColumn(i).setCellRenderer(column.getCellRenderer());
            }
            else {
                jtTable.getColumnModel().getColumn(i).setCellRenderer(DGridUtils.getCellRenderer(column.getColumnType()));
            }

            if (column.getCellEditor() != null) {
                jtTable.getColumnModel().getColumn(i).setCellEditor(column.getCellEditor());
            }
        }

        jspScrollPane.setViewportView(jtTable);
    }

    protected Point getSeekerLocation() {
        Point point = jspScrollPane.getLocationOnScreen();

        point.y += jtTable.getTableHeader().getHeight();

        return point;
    }

    public void actionMouseClicked() {
        actionRowEdit();
    }

    public void actionRowNew() {
        if (jbRowNew.isEnabled()) {
            int row = 0;
            DGridRow gridRow = null;
            DDbRegistry registry = null;

            try {
                registry = miClient.getSession().getRegistry(mnGridType);
                registry.setFormAction(DGuiConsts.FORM_ACTION_NEW);

                if (moFormParams != null) {
                    for (Integer key : moFormParams.getParamsMap().keySet()) {
                        miForm.setValue(key, moFormParams.getParamsMap().get(key));
                    }
                    moFormParams = null;
                }

                miForm.setRegistry(registry);

                miForm.setFormVisible(true);

                if (miForm.getFormResult() == DGuiConsts.FORM_RESULT_OK) {
                    gridRow = (DGridRow) miForm.getRegistry();
                    moModel.getGridRows().add(gridRow);
                    moModel.renderGridRows();

                    row = moModel.getRowCount() - 1;
                    setSelectedGridRow(row);

                    if (miPaneFormOwner != null) {
                        miPaneFormOwner.notifyRowNew(mnGridType, mnGridSubtype, row, gridRow);
                    }
                }
            }
            catch (Exception e) {
                DLibUtils.showException(this, e);
            }
        }
    }

    public void actionRowEdit() {
        if (jbRowEdit.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(DGridConsts.MSG_SELECT_ROW);
            }
            else {
                DDbRegistry registry = null;
                DGridRow gridRow = getSelectedGridRow();
                int row = jtTable.getSelectedRow();

                try {
                    if (gridRow.isRowSystem()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_IS_SYSTEM);
                    }
                    else {
                        registry = (DDbRegistry) gridRow;
                        registry.setFormAction(DGuiConsts.FORM_ACTION_EDIT);

                        if (moFormParams != null) {
                            for (Integer key : moFormParams.getParamsMap().keySet()) {
                                miForm.setValue(key, moFormParams.getParamsMap().get(key));
                            }
                            moFormParams = null;
                        }

                        miForm.setRegistry(registry);

                        miForm.setFormVisible(true);

                        if (miForm.getFormResult() == DGuiConsts.FORM_RESULT_OK) {
                            gridRow = (DGridRow) miForm.getRegistry();
                            moModel.getGridRows().setElementAt(gridRow, jtTable.convertRowIndexToModel(jtTable.getSelectedRow()));
                            moModel.renderGridRows();

                            setSelectedGridRow(row);

                            if (miPaneFormOwner != null) {
                                miPaneFormOwner.notifyRowEdit(mnGridType, mnGridSubtype, row, gridRow);
                            }
                        }
                    }
                }
                catch (Exception e) {
                    DLibUtils.showException(this, e);
                }
            }
        }
    }

    public void actionRowDelete() {
        if (jbRowDelete.isEnabled()) {
            if (jtTable.getSelectedRowCount() == 0) {
                miClient.showMsgBoxInformation(DGridConsts.MSG_SELECT_ROWS);
            }
            else if (miClient.showMsgBoxConfirm(DGridConsts.MSG_CONFIRM_REG_DEL) == JOptionPane.YES_OPTION) {
                DGridRow gridRow = null;
                DGridRow[] gridRows = getSelectedGridRows();
                int[] rows = jtTable.getSelectedRows();

                for (int i = 0; i < gridRows.length; i++) {
                    gridRow = gridRows[i];

                    if (gridRow.isRowSystem()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_IS_SYSTEM);
                    }
                    else if (!gridRow.isRowDeletable()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_NON_DELETABLE);
                    }
                    else {
                        moModel.getGridRows().remove(moModel.getGridRows().indexOf(gridRow));
                        moModel.renderGridRows();

                        setSelectedGridRow(rows[i] < moModel.getRowCount() ? rows[i] : moModel.getRowCount() - 1);

                        mvDeletedRows.add(gridRow);
                        if (miPaneFormOwner != null) {
                            miPaneFormOwner.notifyRowDelete(mnGridType, mnGridSubtype, rows[i], gridRow);
                        }
                    }
                }
            }
        }
    }

    public void actionGridSaveCsv() {
        if (jbGridSaveCsv.isEnabled()) {
            DGridUtils.saveCsv(this, msName);
        }
    }

    public void actionGridClearSettings() {
        if (jbGridClearSettings.isEnabled()) {
            if (miClient.showMsgBoxConfirm(DGridConsts.MSG_CONFIRM_RESET_SETTINGS) == JOptionPane.YES_OPTION) {
                Vector<DGridRow> rows = new Vector<DGridRow>();

                for (DGridRow gridRow : moModel.mvGridRows) {
                    rows.add(gridRow);
                }

                miUserGui = null;
                populateGrid(rows);
            }
        }
    }

    public void actionGridSeekValue() {
        if (jtTable.getRowCount() > 0) {
            moSeeker.openSeeker(getSeekerLocation());
            if (moSeeker.isSeekRequested()) {
                DGridUtils.seekValue(this, moSeeker.getText());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbGridClearSettings;
    private javax.swing.JButton jbGridSaveCsv;
    protected javax.swing.JButton jbRowDelete;
    protected javax.swing.JButton jbRowEdit;
    protected javax.swing.JButton jbRowNew;
    private javax.swing.JPanel jpCommands;
    private javax.swing.JPanel jpCommandsSys;
    private javax.swing.JPanel jpCommandsSysCenter;
    private javax.swing.JPanel jpCommandsSysLeft;
    private javax.swing.JPanel jpCommandsSysRight;
    protected javax.swing.JScrollPane jspScrollPane;
    protected javax.swing.JTable jtTable;
    // End of variables declaration//GEN-END:variables

    /*
     * Abstract methods
     */

    public abstract void initGrid();
    public abstract void createGridColumns();

    /*
     * Public methods
     */

    public void setForm(DGuiForm form) {
        miForm = form;
    }

    public void setFormParams(DGuiParams params) {
        moFormParams = params;
    }

    public void setPaneFormOwner(DGridPaneFormOwner owner) {
        miPaneFormOwner = owner;
    }

    public void setOptionPickerOwner(DBeanOptionPicker optionPicker) {
        moOptionPickerOwner = optionPicker;
    }

    public void populateGrid(final Vector<DGridRow> gridRows) {
        populateGrid(gridRows, null);
    }

    public void populateGrid(final Vector<DGridRow> gridRows, ListSelectionListener listSelectionListener_n) {
        try {
            createGridForm(listSelectionListener_n);

            for (DGridRow gridRow : gridRows) {
                moModel.getGridRows().add(gridRow);
            }

            moModel.renderGridRows();
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            jtTable.getRowSorter().setSortKeys(miSortKeysList);
            setSelectedGridRow(0);
        }
    }

    public void clearSortKeys() {
        miSortKeysList = new ArrayList<RowSorter.SortKey>();
        jtTable.getRowSorter().setSortKeys(miSortKeysList);
    }

    public void resetSortKeys() {
        initSortKeys();
        jtTable.getRowSorter().setSortKeys(miSortKeysList);
    }

    public void paneViewClosed() {
        preserveUserGui();
    }

    public void setRowButtonsEnabled(boolean enabled) {
        jbRowNew.setEnabled(enabled);
        jbRowEdit.setEnabled(enabled);
        jbRowDelete.setEnabled(enabled);
    }

    public void setRowButtonsEnabled(boolean newEnabled, boolean editEnabled, boolean deleteEnabled) {
        jbRowNew.setEnabled(newEnabled);
        jbRowEdit.setEnabled(editEnabled);
        jbRowDelete.setEnabled(deleteEnabled);
    }

    public void setSelectedGridRowInterval(final int row0, final int row1) {
        int value = 0;

        if (row0 >= 0 && row0 < jtTable.getRowCount() && row1 >= 0 && row1 < jtTable.getRowCount() && row0 <= row1) {
            jtTable.setRowSelectionInterval(row0, row1);

            value = row0 * jtTable.getRowHeight();
            if (value < jspScrollPane.getVerticalScrollBar().getValue() || value > jspScrollPane.getVerticalScrollBar().getValue() + jspScrollPane.getVerticalScrollBar().getVisibleAmount()) {
                jspScrollPane.getVerticalScrollBar().setValue(value);
            }
        }
    }

    public DGridRow[] getSelectedGridRows() {
        int[] rows = jtTable.getSelectedRows();
        DGridRow[] gridRows = null;

        if (rows != null) {
            gridRows = new DGridRow[rows.length];

            for (int i = 0; i < rows.length; i++) {
                gridRows[i] = moModel.getGridRows().get(jtTable.convertRowIndexToModel(rows[i]));
            }
        }

        return gridRows;
    }

    public Vector<DGridRow> getDeletedRows() {
        return mvDeletedRows;
    }

    public JPanel getPanelCommandsSys() {
        return jpCommandsSys;
    }

    public JPanel getPanelCommandsSys(int guiPanel) {
        JPanel panel = null;

        switch(guiPanel) {
            case DGuiConsts.PANEL_LEFT:
                panel = jpCommandsSysLeft;
                break;
            case DGuiConsts.PANEL_CENTER:
                panel = jpCommandsSysCenter;
                break;
            case DGuiConsts.PANEL_RIGHT:
                panel = jpCommandsSysRight;
                break;
            default:
        }

        return panel;
    }

    public void removePanelCommands() {
        remove(jpCommands);
    }

    /*
     * Overriden methods
     */

    @Override
    public DGuiClient getClient() {
        return miClient;
    }

    @Override
    public int getGridPaneType() {
        return DGridConsts.GRID_PANE_FORM;
    }

    @Override
    public int getGridType() {
        return mnGridType;
    }

    @Override
    public int getGridSubtype() {
        return mnGridSubtype;
    }

    @Override
    public int getGridMode() {
        return DLibConsts.UNDEFINED;
    }

    @Override
    public int getGridSubmode() {
        return DLibConsts.UNDEFINED;
    }

    @Override
    public DGridModel getModel() {
        return moModel;
    }

    @Override
    public JTable getTable() {
        return jtTable;
    }

    @Override
    public JScrollPane getScrollPane() {
        return jspScrollPane;
    }

    @Override
    public void clearGrid() {
        resetGrid();
        renderGrid();
    }

    @Override
    public void clearGridRows() {
        resetGridRows();
        renderGridRows();
    }

    @Override
    public void renderGrid() {
        moModel.renderGrid();
    }

    @Override
    public void renderGridRows() {
        moModel.renderGridRows();
    }

    @Override
    public void initSortKeys() {
        miSortKeysList.clear();
        miSortKeysList.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    }

    @Override
    public void putFilter(final int filterType, final Object filterValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setGridRow(final DGridRow gridRow, final int row) {
        moModel.getGridRows().setElementAt(gridRow, jtTable.convertRowIndexToModel(row));
    }

    @Override
    public void setGridColumn(final DGridColumn gridColumn, final int col) {
        moModel.getGridColumns().setElementAt(gridColumn, jtTable.convertColumnIndexToModel(col));
    }

    @Override
    public DGridRow getGridRow(final int row) {
        return moModel.getGridRows().get(jtTable.convertRowIndexToModel(row));
    }

    @Override
    public DGridColumn getGridColumn(final int col) {
        return moModel.getGridColumns().get(jtTable.convertColumnIndexToModel(col));
    }

    @Override
    public void addGridRow(final DGridRow gridRow) {
        moModel.getGridRows().add(gridRow);
    }

    @Override
    public void addGridColumn(final DGridColumn gridColumn) {
        moModel.getGridColumns().add(gridColumn);
    }

    @Override
    public void insertGridRow(final DGridRow gridRow, final int row) {
        moModel.getGridRows().insertElementAt(gridRow, jtTable.convertRowIndexToModel(row));
    }

    @Override
    public void insertGridColumn(final DGridColumn gridColumn, final int col) {
        moModel.getGridColumns().insertElementAt(gridColumn, jtTable.convertColumnIndexToModel(col));
    }

    @Override
    public DGridRow removeGridRow(final int row) {
        return moModel.getGridRows().remove(jtTable.convertRowIndexToModel(row));
    }

    @Override
    public DGridColumn removeGridColumn(final int col) {
        return moModel.getGridColumns().remove(jtTable.convertColumnIndexToModel(col));
    }

    @Override
    public void setSelectedGridColumn(final int col) {
        if (col >= 0 && col < jtTable.getColumnCount()) {
            jtTable.setColumnSelectionInterval(col, col);
        }
    }

    @Override
    public void setSelectedGridRow(final int row) {
        int value = 0;

        if (row >= 0 && row < jtTable.getRowCount()) {
            jtTable.setRowSelectionInterval(row, row);
            jtTable.invalidate();
            validate();

            value = row * jtTable.getRowHeight();
            if (value < jspScrollPane.getVerticalScrollBar().getValue() || value > jspScrollPane.getVerticalScrollBar().getValue()) {
                jspScrollPane.getVerticalScrollBar().setValue(value);
            }
        }
    }

    @Override
    public DGridRow getSelectedGridRow() {
        return jtTable.getSelectedRow() == -1 ? null : moModel.getGridRows().get(jtTable.convertRowIndexToModel(jtTable.getSelectedRow()));
    }

    @Override
    public void setRowValueAtFieldName(final Object value, final int row, final String fieldName) {
        int modelColumnIndex = moModel.getColumnIndexAtFieldName(fieldName);

        if (modelColumnIndex != -1) {
            moModel.setValueAt(value, row, modelColumnIndex);
            jtTable.setValueAt(value, row, jtTable.convertColumnIndexToView(modelColumnIndex));
        }
    }

    @Override
    public Object getRowValueAtFieldName(final int row, final String fieldName) {
        return moModel.getValueAtFieldName(row, fieldName);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getSource() == moModel) {
            jbGridSaveCsv.setEnabled(moModel.getRowCount() > 0);
        }
    }
}
