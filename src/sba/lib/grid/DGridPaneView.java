/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DGridPaneView.java
 *
 * Created on 14/06/2011, 09:25:19 AM
 */

package sba.lib.grid;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import sba.gui.util.DUtilConsts;
import sba.lib.DLibConsts;
import sba.lib.DLibRpnArgument;
import sba.lib.DLibRpnArgumentType;
import sba.lib.DLibRpnUtils;
import sba.lib.DLibUtils;
import sba.lib.db.DDbConsts;
import sba.lib.grid.xml.DXmlColumnView;
import sba.lib.grid.xml.DXmlGridXml;
import sba.lib.grid.xml.DXmlRpnArgument;
import sba.lib.grid.xml.DXmlSortKey;
import sba.lib.gui.DGuiClient;
import sba.lib.gui.DGuiComponentGui;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiParams;
import sba.lib.gui.DGuiUserGui;
import sba.lib.gui.DGuiUtils;
import sba.lib.xml.DXmlElement;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridPaneView extends JPanel implements DGridPane, ListSelectionListener {

    private ImageIcon moIconReset = new ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reset.gif"));
    private ImageIcon moIconResetUpd = new ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reset_upd.gif"));
    private ImageIcon moIconReload = new ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reload.gif"));
    private ImageIcon moIconReloadUpd = new ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reload_upd.gif"));

    protected DGuiClient miClient;
    protected int mnGridType;
    protected int mnGridSubtype;
    protected int mnGridMode;
    protected int mnGridSubmode;
    protected int mnGridViewType;
    protected int mnModuleType;
    protected int mnModuleSubtype;
    protected String msTitle;
    protected String msSql;
    protected DGuiParams moPaneParams;
    protected DGuiParams moFormParams;

    protected DGridModel moModel;
    protected DGridSeeker moSeeker;
    protected DGridPaneSettings moPaneSettings;
    protected HashSet<Integer> moSuscriptionsSet;
    protected List<RowSorter.SortKey> miSortKeysList;
    protected HashMap<Integer, Object> moFiltersMap;
    protected HashMap<Integer, Integer> moColumnComplementsMap;

    protected int mnListSelectionModel;
    protected int mnRenderAttempts;
    protected int[] manUserGuiKey;
    protected DGuiUserGui miUserGui;

    protected int mnPrivilegeView;
    protected int mnUserLevelAccess;
    protected boolean mbClearSettingsNeeded;
    protected boolean mbReloadNeeded;
    protected boolean mbApplyNew;
    protected boolean mbApplyCopy;
    protected boolean mbApplyEdit;
    protected boolean mbApplyDisable;
    protected boolean mbApplyDelete;
    protected ArrayList<DGuiComponentGui> maComponentGuis;

    /** Creates new form DGridPaneView */
    public DGridPaneView(DGuiClient client, int viewType, int gridType, int gridSubtype, String title) {
        this(client, viewType, gridType, gridSubtype, title, DLibConsts.UNDEFINED, null);
    }

    /** Creates new form DGridPaneView */
    public DGridPaneView(DGuiClient client, int viewType, int gridType, int gridSubtype, String title, DGuiParams params) {
        this(client, viewType, gridType, gridSubtype, title, DLibConsts.UNDEFINED, params);
    }

    /** Creates new form DGridPaneView */
    public DGridPaneView(DGuiClient client, int viewType, int gridType, int gridSubtype, String title, int privilegeView) {
        this(client, viewType, gridType, gridSubtype, title, privilegeView, null);
    }

    /** Creates new form DGridPaneView */
    public DGridPaneView(DGuiClient client, int viewType, int gridType, int gridSubtype, String title, int privilegeView, DGuiParams params) {
        miClient = client;
        mnGridType = gridType;
        mnGridSubtype = gridSubtype;
        mnGridMode = params == null ? DLibConsts.UNDEFINED : params.getType();
        mnGridSubmode = params == null ? DLibConsts.UNDEFINED : params.getSubtype();
        mnGridViewType = viewType;
        mnModuleType = miClient.getSession().getModuleUtils().getModuleTypeByType(gridType);
        mnModuleSubtype = miClient.getSession().getModuleUtils().getModuleSubtypeBySubtype(gridType, gridSubtype);
        msTitle = title;
        msSql = "";
        moPaneParams = params;
        moFormParams = null;
        mnRenderAttempts = 0;

        mnPrivilegeView = privilegeView;
        mnUserLevelAccess = miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView);

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
        jbRowCopy = new javax.swing.JButton();
        jbRowEdit = new javax.swing.JButton();
        jbRowDisable = new javax.swing.JButton();
        jbRowDelete = new javax.swing.JButton();
        jpCommandsSysCenter = new javax.swing.JPanel();
        jtbFilterDeleted = new javax.swing.JToggleButton();
        jpCommandsSysRight = new javax.swing.JPanel();
        jbGridSaveCsv = new javax.swing.JButton();
        jbGridClearSettings = new javax.swing.JButton();
        jbGridReload = new javax.swing.JButton();
        jpCommandsCustom = new javax.swing.JPanel();
        jpCommandsCustomLeft = new javax.swing.JPanel();
        jpCommandsCustomCenter = new javax.swing.JPanel();
        jpCommandsCustomRight = new javax.swing.JPanel();
        jspScrollPane = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();
        jpStatus = new javax.swing.JPanel();
        jpStatusLeft = new javax.swing.JPanel();
        jtfRows = new javax.swing.JTextField();
        jpStatusCenter = new javax.swing.JPanel();
        jtfGridSearch = new javax.swing.JTextField();
        jbGridSearchNext = new javax.swing.JButton();
        jpStatusRight = new javax.swing.JPanel();
        jtbAutoReload = new javax.swing.JToggleButton();

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

        jbRowCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_copy.gif"))); // NOI18N
        jbRowCopy.setToolTipText("Duplicar (Ctrl+D)");
        jbRowCopy.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowCopyActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowCopy);

        jbRowEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_edit.gif"))); // NOI18N
        jbRowEdit.setToolTipText("Modificar (Ctrl+M)");
        jbRowEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowEditActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowEdit);

        jbRowDisable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_std_disable.gif"))); // NOI18N
        jbRowDisable.setToolTipText("Inhabilitar (Ctrl+I)");
        jbRowDisable.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRowDisable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRowDisableActionPerformed(evt);
            }
        });
        jpCommandsSysLeft.add(jbRowDisable);

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

        jtbFilterDeleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/swi_filter_off.gif"))); // NOI18N
        jtbFilterDeleted.setToolTipText("Filtrar eliminados");
        jtbFilterDeleted.setPreferredSize(new java.awt.Dimension(23, 23));
        jtbFilterDeleted.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/swi_filter_on.gif"))); // NOI18N
        jtbFilterDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbFilterDeletedActionPerformed(evt);
            }
        });
        jpCommandsSysCenter.add(jtbFilterDeleted);

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

        jbGridReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_reload.gif"))); // NOI18N
        jbGridReload.setToolTipText("Refrescar (Ctrl+R)");
        jbGridReload.setPreferredSize(new java.awt.Dimension(23, 23));
        jbGridReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGridReloadActionPerformed(evt);
            }
        });
        jpCommandsSysRight.add(jbGridReload);

        jpCommandsSys.add(jpCommandsSysRight, java.awt.BorderLayout.EAST);

        jpCommands.add(jpCommandsSys, java.awt.BorderLayout.PAGE_START);

        jpCommandsCustom.setLayout(new java.awt.BorderLayout());

        jpCommandsCustomLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jpCommandsCustom.add(jpCommandsCustomLeft, java.awt.BorderLayout.WEST);

        jpCommandsCustomCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jpCommandsCustom.add(jpCommandsCustomCenter, java.awt.BorderLayout.CENTER);

        jpCommandsCustomRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jpCommandsCustom.add(jpCommandsCustomRight, java.awt.BorderLayout.EAST);

        jpCommands.add(jpCommandsCustom, java.awt.BorderLayout.CENTER);

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

        jpStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jpStatus.setLayout(new java.awt.BorderLayout());

        jpStatusLeft.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfRows.setEditable(false);
        jtfRows.setText("000,000/000,000");
        jtfRows.setToolTipText("Renglón actual");
        jtfRows.setFocusable(false);
        jtfRows.setPreferredSize(new java.awt.Dimension(100, 23));
        jpStatusLeft.add(jtfRows);

        jpStatus.add(jpStatusLeft, java.awt.BorderLayout.WEST);

        jpStatusCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfGridSearch.setToolTipText("Buscar (Ctrl+B)");
        jtfGridSearch.setPreferredSize(new java.awt.Dimension(100, 23));
        jtfGridSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGridSearchActionPerformed(evt);
            }
        });
        jpStatusCenter.add(jtfGridSearch);

        jbGridSearchNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cmd_grid_next.gif"))); // NOI18N
        jbGridSearchNext.setToolTipText("Siguiente (F3)");
        jbGridSearchNext.setPreferredSize(new java.awt.Dimension(23, 23));
        jbGridSearchNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGridSearchNextActionPerformed(evt);
            }
        });
        jpStatusCenter.add(jbGridSearchNext);

        jpStatus.add(jpStatusCenter, java.awt.BorderLayout.CENTER);

        jpStatusRight.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtbAutoReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/swi_action_off.gif"))); // NOI18N
        jtbAutoReload.setToolTipText("Refrescar automáticamente");
        jtbAutoReload.setPreferredSize(new java.awt.Dimension(23, 23));
        jtbAutoReload.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/swi_action_on.gif"))); // NOI18N
        jtbAutoReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAutoReloadActionPerformed(evt);
            }
        });
        jpStatusRight.add(jtbAutoReload);

        jpStatus.add(jpStatusRight, java.awt.BorderLayout.EAST);

        add(jpStatus, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jbRowNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowNewActionPerformed
        actionRowNew();
    }//GEN-LAST:event_jbRowNewActionPerformed

    private void jbRowEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowEditActionPerformed
        actionRowEdit();
    }//GEN-LAST:event_jbRowEditActionPerformed

    private void jbRowCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowCopyActionPerformed
        actionRowCopy();
    }//GEN-LAST:event_jbRowCopyActionPerformed

    private void jbRowDisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowDisableActionPerformed
        actionRowDisable();
    }//GEN-LAST:event_jbRowDisableActionPerformed

    private void jbRowDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRowDeleteActionPerformed
        actionRowDelete();
    }//GEN-LAST:event_jbRowDeleteActionPerformed

    private void jbGridSaveCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridSaveCsvActionPerformed
        actionGridSaveCsv();
    }//GEN-LAST:event_jbGridSaveCsvActionPerformed

    private void jbGridClearSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridClearSettingsActionPerformed
        actionGridClearSettings();
    }//GEN-LAST:event_jbGridClearSettingsActionPerformed

    private void jbGridReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridReloadActionPerformed
        actionGridReload();
    }//GEN-LAST:event_jbGridReloadActionPerformed

    private void jtbFilterDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbFilterDeletedActionPerformed
        actionToggleFilterDeleted();
    }//GEN-LAST:event_jtbFilterDeletedActionPerformed

    private void jtbAutoReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAutoReloadActionPerformed
        actionToggleAutoReload();
    }//GEN-LAST:event_jtbAutoReloadActionPerformed

    private void jtfGridSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGridSearchActionPerformed
        actionGridSearchValue();
    }//GEN-LAST:event_jtfGridSearchActionPerformed

    private void jbGridSearchNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGridSearchNextActionPerformed
        actionGridSearchNextValue();
    }//GEN-LAST:event_jbGridSearchNextActionPerformed

    private void initComponentsCustom() {
        moModel = new DGridModel();
        moSeeker = new DGridSeeker(miClient.getFrame());
        moPaneSettings = null;
        moSuscriptionsSet = new HashSet<>();
        miSortKeysList = new ArrayList<>();
        moFiltersMap = new HashMap<>();
        moColumnComplementsMap = new HashMap<>();

        mbClearSettingsNeeded = false;
        mbReloadNeeded = false;

        mbApplyNew = false;
        mbApplyCopy = false;
        mbApplyEdit = false;
        mbApplyDisable = false;
        mbApplyDelete = false;
        maComponentGuis = new ArrayList<>();

        defineSuscriptions();

        switch (mnGridViewType) {
            case DGridConsts.GRID_VIEW_TAB:
                mnListSelectionModel = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
                manUserGuiKey = new int[] { miClient.getSession().getUser().getPkUserId(), DGuiConsts.GUI_COMP_VIEW_TAB, mnGridType, mnGridSubtype, mnGridMode, mnGridSubmode };

                jbRowNew.setEnabled(true);
                jbRowEdit.setEnabled(true);
                jbRowCopy.setEnabled(true);
                jbRowDisable.setEnabled(true);
                jbRowDelete.setEnabled(true);
                jbGridSaveCsv.setEnabled(true);
                jbGridClearSettings.setEnabled(true);
                jbGridReload.setEnabled(true);
                jtbFilterDeleted.setEnabled(true);
                jtbAutoReload.setEnabled(true);

                jtbFilterDeleted.setSelected(true);
                jtbAutoReload.setSelected(true);

                moFiltersMap.put(DGridConsts.FILTER_DELETED, true);
                break;

            case DGridConsts.GRID_VIEW_OPTION_PICKER:
                mnListSelectionModel = ListSelectionModel.SINGLE_SELECTION;
                manUserGuiKey = new int[] { miClient.getSession().getUser().getPkUserId(), DGuiConsts.GUI_COMP_VIEW_OPTION_PICKER, mnGridType, mnGridSubtype, mnGridMode, mnGridSubmode };

                jbRowNew.setEnabled(true);
                jbRowEdit.setEnabled(true);
                jbRowCopy.setEnabled(true);
                jbRowDisable.setEnabled(false);
                jbRowDelete.setEnabled(false);
                jbGridSaveCsv.setEnabled(true);
                jbGridClearSettings.setEnabled(true);
                jbGridReload.setEnabled(true);
                jtbFilterDeleted.setEnabled(false);
                jtbAutoReload.setEnabled(false);
                break;

            default:
                miClient.showMsgBoxError(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }

        miUserGui = miClient.readUserGui(manUserGuiKey);

        DGuiUtils.createActionMap(this, this, "actionRowNew", "rowNew", KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowEdit", "rowEdit", KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowCopy", "rowCopy", KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowDisable", "rowDisable", KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionRowDelete", "rowDelete", KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridSaveCsv", "gridSaveCsv", KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridClearSettings", "gridClearSettings", KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridReload", "gridReload", KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridSeekValue", "gridSeekValue", KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "grabFocusToSearch", "focusToSearch", KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK);
        DGuiUtils.createActionMap(this, this, "actionGridSearchNextValue", "gridSearchNextValue", KeyEvent.VK_F3, 0);
    }

    // This method differs from SA-Lib.
//    protected void computeUserGuiFilters(final DXmlGridXml gridXml_n) {
//        DXmlGridXml gridXml = gridXml_n;
//
//        try {
//            if (gridXml == null) {
//                gridXml = new DXmlGridXml(DGridConsts.GRID_PANE_VIEW);
//                gridXml.processXml(miUserGui.getGui());
//            }
//
//            for (DXmlElement element : gridXml.getXmlElements()) {
//                if (element instanceof DXmlFilter) {
//                    // Filters:
//
//                    DXmlFilter xmlFilter = (DXmlFilter) element;
//                    DGridFilterValue filterValue = new DGridFilterValue(
//                             (Integer) xmlFilter.getAttribute(DXmlFilter.ATT_FILTER_TYPE).getValue(),
//                             (Integer) xmlFilter.getAttribute(DXmlFilter.ATT_DATA_TYPE).getValue(),
//                             xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).getValue());
//
//                    switch ((Integer) xmlFilter.getAttribute(DXmlFilter.ATT_DATA_TYPE).getValue()) {
//                        case DGridConsts.FILTER_DATA_TYPE_DATE:
//                        case DGridConsts.FILTER_DATA_TYPE_DATE_ARRAY:
//                        case DGridConsts.FILTER_DATA_TYPE_GUIDATE:
//                        case DGridConsts.FILTER_DATA_TYPE_GUIDATE_ARRAY:
//                            break;
//
//                        case DGridConsts.FILTER_DATA_TYPE_INT_ARRAY:
//                            filterValue.setValue(DLibUtils.textExplodeAsIntArray((String) xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).getValue(), "-"));
//                            moFiltersMap.put(filterValue.getFilterType(), filterValue);
//                            break;
//
//                        case DGridConsts.FILTER_DATA_TYPE_BOOL:
//                            filterValue.setValue(Boolean.parseBoolean(xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).getValue().toString()));
//                            moFiltersMap.put(filterValue.getFilterType(), filterValue);
//
//                            if (filterValue.getFilterType() == DGridConsts.FILTER_DELETED) {
//                                jtbFilterDeleted.setSelected(Boolean.parseBoolean(xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).getValue().toString()));
//                            }
//                            break;
//
//                        default:
//                            miClient.showMsgBoxError(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
//                    }
//                }
//            }
//        }
//        catch (Exception e) {
//            DLibUtils.showException(this, e);
//        }
//    }

    protected void computeUserGui() {
        boolean found = false;
        ArrayList<DGridColumnView> defaultGridColumns = null;
        DXmlGridXml gridXml = new DXmlGridXml(DGridConsts.GRID_PANE_VIEW);

        miSortKeysList.clear();
        mbClearSettingsNeeded = false;

        try {
            gridXml.processXml(miUserGui.getGui());
            
            //jtbAutoReload.setSelected((Boolean) gridXml.getAttribute(DXmlGridXml.ATT_AUTO_RELOAD).getValue());

            for (DXmlElement element : gridXml.getXmlElements()) {
                if (element instanceof DXmlColumnView) {
                    // Columns:

                    DXmlColumnView xmlColumn = (DXmlColumnView) element;
                    DGridColumnView gridColumn = new DGridColumnView(
                            (Integer) xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_TYPE).getValue(),
                            (String) xmlColumn.getAttribute(DXmlColumnView.ATT_FIELD_NAME).getValue(),
                            (String) xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_TITLE).getValue(),
                            (Integer) xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_WIDTH).getValue());
                    gridColumn.setSumApplying((Boolean) xmlColumn.getAttribute(DXmlColumnView.ATT_IS_SUM_APPLYING).getValue());

                    if (!xmlColumn.getXmlElements().isEmpty()) {
                        for (DXmlElement child : xmlColumn.getXmlElements()) {
                            if (child.getName().compareTo(DXmlRpnArgument.NAME) == 0) {
                                DXmlRpnArgument xmlRpnArgument = (DXmlRpnArgument) child;
                                DLibRpnArgument rpnArgument = null;
                                switch (DLibRpnUtils.getArgumentType((String) xmlRpnArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT_TYPE).getValue())) {
                                    case OPERAND:
                                        rpnArgument = new DLibRpnArgument(
                                                (String) xmlRpnArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT).getValue(),
                                                DLibRpnArgumentType.OPERAND);
                                        break;
                                    case OPERATOR:
                                        rpnArgument = new DLibRpnArgument(
                                                DLibRpnUtils.getOperator((String) xmlRpnArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT).getValue()),
                                                DLibRpnArgumentType.OPERATOR);
                                        break;
                                    default:
                                }
                                if (rpnArgument != null) {
                                    gridColumn.getRpnArguments().add(rpnArgument);
                                }
                            }
                        }
                    }

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
            DLibUtils.printException(this, e);
            miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_PREFS_VIEW);
            miUserGui = null;   // reset grid's user preferences
            populateGrid(DGridConsts.REFRESH_MODE_RESET);
        }

        // Check if customized columns are equivalent to default columns:

//        defaultGridColumns = createGridColumns();
//
//        if (defaultGridColumns.size() != moModel.getGridColumns().size()) {
//            mbClearSettingsNeeded = true;
//        }
//        else {
//            for (int i = 0; i < defaultGridColumns.size(); i++) {
//                found = false;
//                for (int j = 0; j < moModel.getGridColumns().size(); j++) {
//                    if (defaultGridColumns.get(i).getFieldName().compareTo(moModel.getGridColumns().get(j).getFieldName()) == 0 &&
//                            defaultGridColumns.get(i).getColumnType() == moModel.getGridColumns().get(j).getColumnType() &&
//                            defaultGridColumns.get(i).getColumnTitle().compareTo(moModel.getGridColumns().get(j).getColumnTitle()) == 0 &&
//                            defaultGridColumns.get(i).isSumApplying() == ((SGridColumnView) moModel.getGridColumns().get(j)).isSumApplying()) {
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    mbClearSettingsNeeded = true;
//                    break;
//                }
//            }
//        }

        if (mbClearSettingsNeeded) {
            jbGridClearSettings.setIcon(moIconResetUpd);
        }
    }

    protected void preserveUserGui() {
        if (jtTable != null && jtTable.getRowSorter() != null) {
            String xml = "";
            DXmlGridXml gridXml = new DXmlGridXml(DGridConsts.GRID_PANE_VIEW);
            @SuppressWarnings("unchecked")
            List<RowSorter.SortKey> sortKeys = (List<RowSorter.SortKey>) jtTable.getRowSorter().getSortKeys();

            // Grid attributes:

//            gridXml.getAttribute(DXmlGridXml.ATT_AUTO_RELOAD).setValue(jtbAutoReload.isSelected());

            // Columns:

            for (int i = 0; i < jtTable.getColumnCount(); i++) {
                DXmlColumnView xmlColumn = new DXmlColumnView();
                DGridColumnView gridColumn = (DGridColumnView) (moModel.getGridColumns().get(jtTable.convertColumnIndexToModel(i)));

                xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_TYPE).setValue(gridColumn.getColumnType());
                xmlColumn.getAttribute(DXmlColumnView.ATT_FIELD_NAME).setValue(gridColumn.getFieldName());
                xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_TITLE).setValue(gridColumn.getColumnTitle());
                xmlColumn.getAttribute(DXmlColumnView.ATT_COLUMN_WIDTH).setValue(jtTable.getColumnModel().getColumn(i).getWidth());
                xmlColumn.getAttribute(DXmlColumnView.ATT_IS_SUM_APPLYING).setValue(gridColumn.isSumApplying());
//                xmlColumn.getAttribute(DXmlColumnView.ATT_CELL_RENDERER).setValue(DLibConsts.UNDEFINED);

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
                sortKeys = new ArrayList<>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));    // just in case there are not sort keys
            }
            
            for (RowSorter.SortKey sortKey : sortKeys) {
                DXmlSortKey xmlSortKey = new DXmlSortKey();
                xmlSortKey.getAttribute(DXmlSortKey.ATT_COLUMN).setValue(jtTable.convertColumnIndexToView(sortKey.getColumn()));
                xmlSortKey.getAttribute(DXmlSortKey.ATT_SORT_ORDER).setValue(sortKey.getSortOrder().toString());
                gridXml.getXmlElements().add(xmlSortKey);
            }

            /* Filter user preferences temporarily disabled (Sergio Flores, 2013-12-05):
            // Filters:

            if (!moFiltersMap.isEmpty()) {
                 DGridFilterValue filterValue = null;

                for (int i = 0; i < moFiltersMap.size(); i++) {
                    filterValue = (DGridFilterValue) moFiltersMap.values().toArray()[i];

                    if (filterValue.getValue() != null) {
                        DXmlFilter xmlFilter = new DXmlFilter();
                        xmlFilter.getAttribute(DXmlFilter.ATT_FILTER_TYPE).setValue(filterValue.getFilterType());

                        switch (filterValue.getDataType()) {
                            case DGridConsts.FILTER_DATA_TYPE_DATE:
                            case DGridConsts.FILTER_DATA_TYPE_DATE_ARRAY:
                            case DGridConsts.FILTER_DATA_TYPE_GUIDATE:
                            case DGridConsts.FILTER_DATA_TYPE_GUIDATE_ARRAY:
                                break;
                            case DGridConsts.FILTER_DATA_TYPE_INT_ARRAY:
                                xmlFilter.getAttribute(DXmlFilter.ATT_DATA_TYPE).setValue(DGridConsts.FILTER_DATA_TYPE_INT_ARRAY);
                                xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).setValue(DLibUtils.textKey((int[]) filterValue.getValue()));
                                gridXml.getXmlElements().add(xmlFilter);
                                break;
                            case DGridConsts.FILTER_DATA_TYPE_BOOL:
                                xmlFilter.getAttribute(DXmlFilter.ATT_DATA_TYPE).setValue(DGridConsts.FILTER_DATA_TYPE_BOOL);
                                xmlFilter.getAttribute(DXmlFilter.ATT_VALUE).setValue(filterValue.getValue());
                                gridXml.getXmlElements().add(xmlFilter);
                                break;
                            default:
                                miClient.showMsgBoxError(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                        }
                    }
                }
            }
            */

            xml = gridXml.getXmlString();
            miUserGui = miClient.saveUserGui(manUserGuiKey, xml);
        }
    }

    protected void refreshGridWithRefresh() {
        preserveUserGui();
        populateGrid(DGridConsts.REFRESH_MODE_RESET);
    }

    protected void refreshGridWithReload() {
        preserveUserGui();
        populateGrid(DGridConsts.REFRESH_MODE_RELOAD);
    }

    protected void resetGrid() {
        moModel.clearGrid();
        if (jtTable != null) {
            jtTable.invalidate();
            validate();
        }
    }

    protected void resetGridRows() {
        moModel.clearGridRows();
        if (jtTable != null) {
            jtTable.invalidate();
            validate();
        }
    }

    protected void createGridView() {
        DGridColumnView column = null;

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
        jtTable.setSelectionMode(mnListSelectionModel);
        jtTable.setColumnSelectionAllowed(false);
        jtTable.setRowSorter(new TableRowSorter<AbstractTableModel>(moModel));
        jtTable.setTableHeader(new DGridHeader(jtTable.getColumnModel(), moModel.getColumnNames()));
        jtTable.getSelectionModel().addListSelectionListener(this);

        jtTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    actionMouseClicked();
                }
            }
        });

        jtTable.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                moSeeker.handleKeyPressedEvent(evt, getSeekerLocation());
                if (moSeeker.isSeekRequested()) {
                    DGridUtils.seekValue(DGridPaneView.this, moSeeker.getText());
                }
            }
        });

        for (int i = 0; i < moModel.getColumnCount(); i++) {
            column = (DGridColumnView) moModel.getGridColumns().get(i);

            jtTable.getColumnModel().getColumn(i).setPreferredWidth(column.getColumnWidth());

            if (column.getCellRenderer() != null) {
                jtTable.getColumnModel().getColumn(i).setCellRenderer(column.getCellRenderer());
            }
            else {
                jtTable.getColumnModel().getColumn(i).setCellRenderer(DGridUtils.getCellRenderer(column.getColumnType()));
            }
        }

        jtfRows.setText("0/0");
        jbGridSaveCsv.setEnabled(false);

        jspScrollPane.setViewportView(jtTable);
    }

    protected void readGridData() {
        int i = 0;
        int col = 0;
        int row = 0;
        int dataType = DLibConsts.UNDEFINED;
        int[] key = null;
        int sumInt = 0;
        long sumLng = 0;
        double sumDbl = 0;
        boolean rpnApplying = false;
        boolean sumApplying = false;
        boolean dataAvailable = false;
        boolean[] colsWithRpn = null;
        boolean[] colsWithSum = null;
        Class colClass = null;
        ResultSet resultSet = null;
        DGridColumnView gridColumnView = null;
        DGridRowView gridRowView = null;

        try {
            createGridView();
            prepareSqlQuery();

            colsWithRpn = new boolean[moModel.getColumnCount()];
            for (col = 0; col < moModel.getColumnCount(); col++) {
                if (!moModel.getGridColumns().get(col).getRpnArguments().isEmpty()) {
                    dataType = DGridUtils.getDataType(moModel.getGridColumns().get(col).getColumnType());
                    if (dataType != DLibConsts.DATA_TYPE_INT && dataType != DLibConsts.DATA_TYPE_DEC) {
                        throw new Exception(DLibConsts.ERR_MSG_WRONG_TYPE);
                    }
                    else {
                        rpnApplying = true;
                        colsWithRpn[col] = true;
                    }
                }
            }

            colsWithSum = new boolean[moModel.getColumnCount()];
            for (col = 0; col < moModel.getColumnCount(); col++) {
                if (((DGridColumnView) moModel.getGridColumns().get(col)).isSumApplying()) {
                    dataType = DGridUtils.getDataType(moModel.getGridColumns().get(col).getColumnType());
                    if (dataType != DLibConsts.DATA_TYPE_INT && dataType != DLibConsts.DATA_TYPE_DEC) {
                        throw new Exception(DLibConsts.ERR_MSG_WRONG_TYPE);
                    }
                    else {
                        sumApplying = true;
                        colsWithSum[col] = true;
                    }
                }
            }

            resultSet = miClient.getSession().getStatement().executeQuery(msSql);
            while (resultSet.next()) {
                key = new int[moPaneSettings.getPrimaryKeyLength()];
                for (i = 0; i < moPaneSettings.getPrimaryKeyLength(); i++) {
                    key[i] = resultSet.getInt(DDbConsts.FIELD_ID + (i + 1));
                }

                gridRowView = new DGridRowView(key, resultSet.getString(DDbConsts.FIELD_CODE), resultSet.getString(DDbConsts.FIELD_NAME));

                if (moPaneSettings.getTypeKeyLength() == 0) {
                    key = null;
                }
                else {
                    key = new int[moPaneSettings.getTypeKeyLength()];
                    for (i = 0; i < moPaneSettings.getTypeKeyLength(); i++) {
                        key[i] = resultSet.getInt(DDbConsts.FIELD_TYPE_ID + (i + 1));
                    }

                    gridRowView.setRowRegistryTypeKey(key);
                    gridRowView.setRowRegistryType(resultSet.getString(DDbConsts.FIELD_TYPE));
                }

                if (moPaneSettings.isDateApplying()) {
                    gridRowView.setRowDate(resultSet.getDate(DDbConsts.FIELD_DATE));
                }

                if (moPaneSettings.isUpdatableApplying()) {
                    gridRowView.setUpdatable(resultSet.getBoolean(DDbConsts.FIELD_CAN_UPD));
                }

                if (moPaneSettings.isDisableableApplying()) {
                    gridRowView.setDisableable(resultSet.getBoolean(DDbConsts.FIELD_CAN_DIS));
                    gridRowView.setDisabled(resultSet.getBoolean(DDbConsts.FIELD_IS_DIS));
                }

                if (moPaneSettings.isDeletableApplying()) {
                    gridRowView.setDeletable(resultSet.getBoolean(DDbConsts.FIELD_CAN_DEL));
                    gridRowView.setDeleted(resultSet.getBoolean(DDbConsts.FIELD_IS_DEL));
                }

                if (moPaneSettings.isDisabledApplying()) {
                    gridRowView.setDisabled(resultSet.getBoolean(DDbConsts.FIELD_IS_DIS));
                }

                if (moPaneSettings.isDeletedApplying()) {
                    gridRowView.setDeleted(resultSet.getBoolean(DDbConsts.FIELD_IS_DEL));
                }

                if (moPaneSettings.isSystemApplying()) {
                    gridRowView.setRowSystem(resultSet.getBoolean(DDbConsts.FIELD_IS_SYS));
                }

                if (moPaneSettings.isUserApplying()) {
                    gridRowView.setFkUserId(resultSet.getInt(DDbConsts.FIELD_USER_USR_ID));
                    gridRowView.setTsUser(resultSet.getDate(DDbConsts.FIELD_USER_USR_TS));
                    gridRowView.setUser(resultSet.getString(DDbConsts.FIELD_USER_USR_NAME));
                }

                if (moPaneSettings.isUserInsertApplying()) {
                    gridRowView.setFkUserInsertId(resultSet.getInt(DDbConsts.FIELD_USER_INS_ID));
                    gridRowView.setTsUserInsert(resultSet.getDate(DDbConsts.FIELD_USER_INS_TS));
                    gridRowView.setUserInsert(resultSet.getString(DDbConsts.FIELD_USER_INS_NAME));
                }

                if (moPaneSettings.isUserUpdateApplying()) {
                    gridRowView.setFkUserUpdateId(resultSet.getInt(DDbConsts.FIELD_USER_UPD_ID));
                    gridRowView.setTsUserUpdate(resultSet.getDate(DDbConsts.FIELD_USER_UPD_TS));
                    gridRowView.setUserUpdate(resultSet.getString(DDbConsts.FIELD_USER_UPD_NAME));
                }

                // Read grid row values:

                for (col = 0; col < moModel.getColumnCount(); col++) {
                    gridColumnView = (DGridColumnView) moModel.getGridColumns().get(col);

                    if (colsWithRpn[col]) {
                        gridRowView.getValues().add((double) 0);
                    }
                    else {
                        colClass = DGridUtils.getDataTypeClass(gridColumnView.getColumnType());

                        if (colClass == Long.class) {
                            gridRowView.getValues().add(resultSet.getLong(gridColumnView.getFieldName()));
                        }
                        else if (colClass == Integer.class) {
                            gridRowView.getValues().add(resultSet.getInt(gridColumnView.getFieldName()));
                        }
                        else if (colClass == Double.class) {
                            gridRowView.getValues().add(resultSet.getDouble(gridColumnView.getFieldName()));
                        }
                        else if (colClass == Float.class) {
                            gridRowView.getValues().add(resultSet.getFloat(gridColumnView.getFieldName()));
                        }
                        else if (colClass == Boolean.class) {
                            gridRowView.getValues().add(resultSet.getBoolean(gridColumnView.getFieldName()));
                        }
                        else if (colClass == String.class) {
                            gridRowView.getValues().add(resultSet.getString(gridColumnView.getFieldName()));
                        }
                        else if (colClass == Date.class) {
                            switch (gridColumnView.getColumnType()) {
                                case DGridConsts.COL_TYPE_DATE:
                                    gridRowView.getValues().add(resultSet.getDate(gridColumnView.getFieldName()));
                                    break;
                                case DGridConsts.COL_TYPE_DATE_DATETIME:
                                    gridRowView.getValues().add(resultSet.getTimestamp(gridColumnView.getFieldName()));
                                    break;
                                case DGridConsts.COL_TYPE_DATE_TIME:
                                    gridRowView.getValues().add(resultSet.getTime(gridColumnView.getFieldName()));
                                    break;
                                default:
                                    throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                            }
                        }
                        else {
                            throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                        }
                    }
                }

                // Read aswell grid row complements if any:

                if (moColumnComplementsMap.size() > 0) {
                    for (Integer complementKey : moColumnComplementsMap.keySet()) {

                        colClass = DGridUtils.getDataTypeClass(moColumnComplementsMap.get(complementKey));

                        if (colClass == Long.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getLong(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == Integer.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getInt(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == Double.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getDouble(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == Float.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getFloat(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == Boolean.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getBoolean(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == String.class) {
                            gridRowView.getComplementsMap().put(complementKey, resultSet.getString(DDbConsts.FIELD_COMP + complementKey));
                        }
                        else if (colClass == Date.class) {
                            switch (moColumnComplementsMap.get(complementKey)) {
                                case DGridConsts.COL_TYPE_DATE:
                                    gridRowView.getComplementsMap().put(complementKey, resultSet.getDate(DDbConsts.FIELD_COMP + complementKey));
                                    break;
                                case DGridConsts.COL_TYPE_DATE_DATETIME:
                                    gridRowView.getComplementsMap().put(complementKey, resultSet.getTimestamp(DDbConsts.FIELD_COMP + complementKey));
                                    break;
                                case DGridConsts.COL_TYPE_DATE_TIME:
                                    gridRowView.getComplementsMap().put(complementKey, resultSet.getTime(DDbConsts.FIELD_COMP + complementKey));
                                    break;
                                default:
                                    throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                            }
                        }
                        else {
                            throw new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN);
                        }
                    }
                }

                moModel.getGridRows().add(gridRowView);
                dataAvailable = true;
            }

            if (rpnApplying) {
                DGridUtils.computeRpn(moModel);
            }

            if (sumApplying && dataAvailable) {
                gridRowView = new DGridRowView(null, "", "");
                gridRowView.setRowType(DGridConsts.ROW_TYPE_SUM);

                for (col = 0; col < moModel.getColumnCount(); col++) {
                    if (!colsWithSum[col]) {
                        gridRowView.getValues().add(null);
                    }
                    else {
                        switch (DGridUtils.getDataType(moModel.getGridColumns().get(col).getColumnType())) {
                            case DLibConsts.DATA_TYPE_INT:
                                if (DGridUtils.getDataTypeClass(moModel.getGridColumns().get(col).getColumnType()) == Long.class) {
                                    sumLng = 0;
                                    for (row = 0; row < moModel.getRowCount(); row++) {
                                        sumLng += ((Number) moModel.getValueAt(row, col)).longValue();
                                    }
                                    gridRowView.getValues().add(sumLng);
                                }
                                else {
                                    sumInt = 0;
                                    for (row = 0; row < moModel.getRowCount(); row++) {
                                        sumInt += ((Number) moModel.getValueAt(row, col)).intValue();
                                    }
                                    gridRowView.getValues().add(sumInt);
                                }
                                break;
                            case DLibConsts.DATA_TYPE_DEC:
                                sumDbl = 0;
                                for (row = 0; row < moModel.getRowCount(); row++) {
                                    sumDbl += ((Number) moModel.getValueAt(row, col)).doubleValue();
                                }
                                gridRowView.getValues().add(sumDbl);
                                break;
                            default:
                        }
                    }
                }

                moModel.getGridRows().add(gridRowView);
            }
            
            mnRenderAttempts = 0; // clear count, data already read
        }
        catch (SQLException e) {
            DLibUtils.showException(this, e);
            DLibUtils.printSqlQuery(this, msSql);
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        finally {
            try {
                jtTable.getRowSorter().setSortKeys(miSortKeysList);
            }
            catch (Exception e) {
                DLibUtils.printException(this, e);
                miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_PREFS_VIEW);
                miUserGui = null;   // reset grid's user preferences
                populateGrid(DGridConsts.REFRESH_MODE_RESET);
            }

            if (dataAvailable) {
                jbGridSaveCsv.setEnabled(true);
                setSelectedGridRow(0);
            }
        }
    }

    protected Point getSeekerLocation() {
        Point point = jspScrollPane.getLocationOnScreen();

        point.y += jtTable.getTableHeader().getHeight();

        return point;
    }

    protected void applyUserPrivileges() {
        if (mnPrivilegeView != DLibConsts.UNDEFINED) {
            for (DGuiComponentGui c : maComponentGuis) {
                c.getComponentGui().setEnabled(mnUserLevelAccess >= c.getUserPrivilegesMap().get(mnPrivilegeView));
            }
        }

        jbRowNew.setEnabled(mbApplyNew && (mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView) >= DUtilConsts.LEV_CAPTURE));
        jbRowCopy.setEnabled(mbApplyCopy && (mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView) >= DUtilConsts.LEV_CAPTURE));
        jbRowEdit.setEnabled(mbApplyEdit && (mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView) >= DUtilConsts.LEV_AUTHOR));
        jbRowDisable.setEnabled(mbApplyDisable && (mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView) >= DUtilConsts.LEV_MANAGER));
        jbRowDelete.setEnabled(mbApplyDelete && (mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().getPrivilegeLevel(mnPrivilegeView) >= DUtilConsts.LEV_MANAGER));
    }

    public void actionMouseClicked() {
        actionRowEdit();
    }

    public void actionRowNew() {
        if (jbRowNew.isEnabled()) {
            miClient.getSession().getModule(mnModuleType, mnModuleSubtype).showForm(mnGridType, mnGridSubtype, moFormParams);
            moFormParams = null;
        }
    }

    public void actionRowCopy() {
        if (jbRowCopy.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(DGridConsts.MSG_SELECT_ROW);
            }
            else {
                DGridRowView gridRow = (DGridRowView) getSelectedGridRow();
                DGuiParams params = null;

                if (gridRow.getRowType() != DGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else {
                    params = new DGuiParams(getSelectedGridRow().getRowPrimaryKey(), true);
                    miClient.getSession().getModule(mnModuleType, mnModuleSubtype).showForm(mnGridType, mnGridSubtype, params);
                }
            }
        }
    }

    public void actionRowEdit() {
        actionRowEdit(false);
    }

    public void actionRowEdit(boolean showSystemRegistries) {
        if (jbRowEdit.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(DGridConsts.MSG_SELECT_ROW);
            }
            else {
                DGridRowView gridRow = (DGridRowView) getSelectedGridRow();
                DGuiParams params = null;

                if (gridRow.getRowType() != DGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (!showSystemRegistries && gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_NON_UPDATABLE);
                }
//                else if (moPaneSettings.isUserInsertApplying() && mnUserLevelAccess == DUtilConsts.LEV_AUTHOR && gridRow.getFkUserInsertId() != miClient.getSession().getUser().getPkUserId()) {
//                    miClient.showMsgBoxWarning(DDbConsts.MSG_REG_DENIED_RIGHT);
//                }
                else {
                    params = moFormParams != null ? moFormParams : new DGuiParams();
                    params.setKey(gridRow.getRowPrimaryKey());

                    miClient.getSession().getModule(mnModuleType, mnModuleSubtype).showForm(mnGridType, mnGridSubtype, params);
                    moFormParams = null;
                }
            }
        }
    }

    public void actionRowDisable() {
        if (jbRowDisable.isEnabled()) {
            if (jtTable.getSelectedRowCount() == 0) {
                miClient.showMsgBoxInformation(DGridConsts.MSG_SELECT_ROWS);
            }
            else if (miClient.showMsgBoxConfirm(DGridConsts.MSG_CONFIRM_REG_DIS) == JOptionPane.YES_OPTION) {
                boolean updates = false;
                DGridRow[] gridRows = getSelectedGridRows();

                for (DGridRow gridRow : gridRows) {
                    if (((DGridRowView) gridRow).getRowType() != DGridConsts.ROW_TYPE_DATA) {
                        miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_ROW_TYPE_DATA);
                    }
                    else if (((DGridRowView) gridRow).isRowSystem()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_IS_SYSTEM);
                    }
                    else if (!((DGridRowView) gridRow).isDisableable()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_NON_DISABLEABLE);
                    }
                    else {
                        if (miClient.getSession().getModule(mnModuleType, mnModuleSubtype).disableRegistry(mnGridType, gridRow.getRowPrimaryKey()) == DDbConsts.SAVE_OK) {
                            updates = true;
                        }
                    }
                }

                if (updates) {
                    miClient.getSession().notifySuscriptors(mnGridType);
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
                boolean updates = false;
                DGridRow[] gridRows = getSelectedGridRows();

                for (DGridRow gridRow : gridRows) {
                    if (((DGridRowView) gridRow).getRowType() != DGridConsts.ROW_TYPE_DATA) {
                        miClient.showMsgBoxWarning(DGridConsts.ERR_MSG_ROW_TYPE_DATA);
                    }
                    else if (((DGridRowView) gridRow).isRowSystem()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_IS_SYSTEM);
                    }
                    else if (!((DGridRowView) gridRow).isDeletable()) {
                        miClient.showMsgBoxWarning(DDbConsts.MSG_REG_ + gridRow.getRowName() + DDbConsts.MSG_REG_NON_DELETABLE);
                    }
                    else {
                        if (miClient.getSession().getModule(mnModuleType, mnModuleSubtype).deleteRegistry(mnGridType, gridRow.getRowPrimaryKey()) == DDbConsts.SAVE_OK) {
                            updates = true;
                        }
                    }
                }

                if (updates) {
                    miClient.getSession().notifySuscriptors(mnGridType);
                }
            }
        }
    }

    public void actionGridSaveCsv() {
        if (jbGridSaveCsv.isEnabled()) {
            DGridUtils.saveCsv(this, msTitle);
        }
    }

    public void actionGridClearSettings() {
        if (jbGridClearSettings.isEnabled()) {
            if (miClient.showMsgBoxConfirm(DGridConsts.MSG_CONFIRM_RESET_SETTINGS) == JOptionPane.YES_OPTION) {
                miUserGui = null;
                populateGrid(DGridConsts.REFRESH_MODE_RESET);

                if (mbClearSettingsNeeded) {
                    mbClearSettingsNeeded = false;
                    jbGridClearSettings.setIcon(moIconReset);
                }
            }
        }
    }

    public void actionGridReload() {
        if (jbGridReload.isEnabled()) {
            refreshGridWithRefresh();
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

    public void grabFocusToSearch() {
        jtfGridSearch.requestFocusInWindow();
    }

    public void actionGridSearchValue() {
        String text = jtfGridSearch.getText().trim(); // just a simple trim
        
        if (!text.isEmpty() && jtTable.getRowCount() > 0) {
            DGridUtils.searchValue(this, text, true);
            jbGridSearchNext.requestFocusInWindow();
        }
    }

    public void actionGridSearchNextValue() {
        String text = jtfGridSearch.getText().trim(); // just a simple trim
        
        if (!text.isEmpty() && jtTable.getRowCount() > 0) {
            DGridUtils.searchValue(this, text, false);
        }
    }

    public void actionToggleFilterDeleted() {
        if (jtbFilterDeleted.isEnabled()) {
            moFiltersMap.put(DGridConsts.FILTER_DELETED, jtbFilterDeleted.isSelected());
            refreshGridWithRefresh();
        }
    }

    public void actionToggleAutoReload() {
        if (jtbAutoReload.isEnabled()) {
            // By now this method has not any code
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbGridClearSettings;
    private javax.swing.JButton jbGridReload;
    private javax.swing.JButton jbGridSaveCsv;
    private javax.swing.JButton jbGridSearchNext;
    protected javax.swing.JButton jbRowCopy;
    protected javax.swing.JButton jbRowDelete;
    protected javax.swing.JButton jbRowDisable;
    protected javax.swing.JButton jbRowEdit;
    protected javax.swing.JButton jbRowNew;
    private javax.swing.JPanel jpCommands;
    private javax.swing.JPanel jpCommandsCustom;
    private javax.swing.JPanel jpCommandsCustomCenter;
    private javax.swing.JPanel jpCommandsCustomLeft;
    private javax.swing.JPanel jpCommandsCustomRight;
    private javax.swing.JPanel jpCommandsSys;
    private javax.swing.JPanel jpCommandsSysCenter;
    private javax.swing.JPanel jpCommandsSysLeft;
    private javax.swing.JPanel jpCommandsSysRight;
    private javax.swing.JPanel jpStatus;
    private javax.swing.JPanel jpStatusCenter;
    private javax.swing.JPanel jpStatusLeft;
    private javax.swing.JPanel jpStatusRight;
    protected javax.swing.JScrollPane jspScrollPane;
    protected javax.swing.JTable jtTable;
    protected javax.swing.JToggleButton jtbAutoReload;
    protected javax.swing.JToggleButton jtbFilterDeleted;
    private javax.swing.JTextField jtfGridSearch;
    private javax.swing.JTextField jtfRows;
    // End of variables declaration//GEN-END:variables

    /*
     * Abstract methods
     */

    public abstract void prepareSqlQuery();
    public abstract void createGridColumns();
    public abstract void defineSuscriptions();

    /*
     * Public methods
     */

    public void setFormParams(DGuiParams params) { moFormParams = params; }
    public void setApplyNew(boolean b) { mbApplyNew = b; }
    public void setApplyCopy(boolean b) { mbApplyCopy = b; }
    public void setApplyEdit(boolean b) { mbApplyEdit = b; }
    public void setApplyDisable(boolean b) { mbApplyDisable = b; }
    public void setApplyDelete(boolean b) { mbApplyDelete = b; }

    public int getGridViewType() { return mnGridViewType; }
    public String getTitle() { return msTitle; }
    public String getSql() { return msSql; }
    public HashMap<Integer, Integer> getColumnComplementsMap() { return moColumnComplementsMap; }
    public HashMap<Integer, Object> getFiltersMap() { return moFiltersMap; }

    public int getPrivilegeView() { return mnPrivilegeView; }
    public int getUserLevelAccess() { return mnUserLevelAccess; }
    public boolean getApplyNew() { return  mbApplyNew; }
    public boolean getApplyCopy() { return  mbApplyCopy; }
    public boolean getApplyEdit() { return  mbApplyEdit; }
    public boolean getApplyDisable() { return  mbApplyDisable; }
    public boolean getApplyDelete() { return  mbApplyDelete; }
    public ArrayList<DGuiComponentGui> getComponentGuis() { return maComponentGuis; }

    public Object getFilterValue(int typeFilter) {
        Object obj = null;

        if (!moFiltersMap.isEmpty()) {
            obj = moFiltersMap.get(typeFilter);
        }

        if (obj != null) {
            obj = moFiltersMap.get(typeFilter);
        }

        return obj;
    }

    public boolean hasUserPrivilegeView() {
        return mnPrivilegeView == DLibConsts.UNDEFINED || miClient.getSession().getUser().hasPrivilege(mnPrivilegeView);
    }

    public void populateGrid(final int refreshMode) {
        int index = -1;
        int posVer = 0;
        int posHor = 0;

        if (refreshMode == DGridConsts.REFRESH_MODE_RELOAD && jtTable != null) {
            index = jtTable.getSelectedRow();
            posVer = jspScrollPane.getVerticalScrollBar().getValue();
            posHor = jspScrollPane.getHorizontalScrollBar().getValue();
        }

        if (mnRenderAttempts++ > 1) {
            miClient.showMsgBoxWarning("Se alcanzó el número máximo de intentos para mostrar esta vista.");
            return;
        }
        
        readGridData();

        if (refreshMode == DGridConsts.REFRESH_MODE_RELOAD) {
            jspScrollPane.validate();
            jspScrollPane.getVerticalScrollBar().setValue(
                    posVer < jspScrollPane.getVerticalScrollBar().getMaximum() ? posVer : jspScrollPane.getVerticalScrollBar().getMaximum());
            jspScrollPane.getHorizontalScrollBar().setValue(
                    posHor < jspScrollPane.getHorizontalScrollBar().getMaximum() ? posHor : jspScrollPane.getHorizontalScrollBar().getMaximum());

            if (index != -1) {
                if (index > jtTable.getRowCount()) {
                    index = jtTable.getRowCount() - 1;
                }

                setSelectedGridRow(index);
            }
        }

        if (mbReloadNeeded) {
            mbReloadNeeded = false;
            jbGridReload.setIcon(moIconReload);
        }
    }

    public void triggerSuscription(final int suscription) {
        if (moSuscriptionsSet.contains(suscription)) {
            if (jtbAutoReload.isSelected()) {
                refreshGridWithReload();
            }
            else {
                mbReloadNeeded = true;
                jbGridReload.setIcon(moIconReloadUpd);
            }
        }
    }

    public void paneViewClosed() {
        preserveUserGui();
    }

    public void setRowButtonsEnabled(boolean enabled) {
        setRowButtonsEnabled(enabled, enabled, enabled, enabled, enabled);
    }

    public void setRowButtonsEnabled(boolean newEnabled, boolean editEnabled, boolean copyEnabled, boolean disableEnabled, boolean deleteEnabled) {
        mbApplyNew = newEnabled;
        mbApplyCopy = copyEnabled;
        mbApplyEdit = editEnabled;
        mbApplyDisable = disableEnabled;
        mbApplyDelete = deleteEnabled;

        applyUserPrivileges();
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

    public JPanel getPanelCommandsSys(final int guiPanel) {
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

    public JPanel getPanelCommandsCustom(final int guiPanel) {
        JPanel panel = null;

        switch(guiPanel) {
            case DGuiConsts.PANEL_LEFT:
                panel = jpCommandsCustomLeft;
                break;
            case DGuiConsts.PANEL_CENTER:
                panel = jpCommandsCustomCenter;
                break;
            case DGuiConsts.PANEL_RIGHT:
                panel = jpCommandsCustomRight;
                break;
            default:
        }

        return panel;
    }

    public JPanel getPanelStatus(final int guiPanel) {
        JPanel panel = null;

        switch(guiPanel) {
            case DGuiConsts.PANEL_LEFT:
                panel = jpStatusLeft;
                break;
            case DGuiConsts.PANEL_CENTER:
                panel = jpStatusCenter;
                break;
            case DGuiConsts.PANEL_RIGHT:
                panel = jpStatusRight;
                break;
            default:
        }

        return panel;
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
        return DGridConsts.GRID_PANE_VIEW;
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
        return mnGridMode;
    }

    @Override
    public int getGridSubmode() {
        return mnGridSubmode;
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
    public void initSortKeysDescending() {
        miSortKeysList.clear();
        miSortKeysList.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
    }

    @Override
    public void putFilter(final int filterType, final Object filterValue) {
        moFiltersMap.put(filterType, filterValue);
        refreshGridWithRefresh();
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

            value = row * jtTable.getRowHeight();
            if (value < jspScrollPane.getVerticalScrollBar().getValue() || value > jspScrollPane.getVerticalScrollBar().getValue() + jspScrollPane.getVerticalScrollBar().getVisibleAmount()) {
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
    public void valueChanged(ListSelectionEvent e) {
        jtfRows.setText(DLibUtils.DecimalFormatInteger.format(jtTable.getSelectedRow() + 1) + "/" + DLibUtils.DecimalFormatInteger.format(jtTable.getRowCount()));
    }
}
