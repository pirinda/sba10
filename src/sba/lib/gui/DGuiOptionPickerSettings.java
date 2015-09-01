/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.gui;

import java.util.ArrayList;
import sba.lib.DLibConsts;
import sba.lib.grid.DGridColumnForm;

/**
 *
 * @author Sergio Flores
 */
public final class DGuiOptionPickerSettings {

    private String msTitle;
    private String msSql;
    private ArrayList<DGridColumnForm> maGridColumns;   // array size defines number of option picker values in SQL query
    private int mnPrimaryKeyLength;
    private boolean mbMainOptionApplying;
    private int mnMainOptionDataType;

    /**
     * @param title Option picker dialog's title.
     * @param sql SQL query.
     * @param gridColumns Option picker columns. Each column value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_PICK</code> + col_number (column number starts from 1).
     */
    public DGuiOptionPickerSettings(String title, String sql, ArrayList<DGridColumnForm> gridColumns) {
        this(title, sql, gridColumns, 0, DLibConsts.UNDEFINED);
    }

    /**
     * @param title Option picker dialog's title.
     * @param sql SQL query.
     * @param gridColumns Option picker columns. Each column value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_PICK</code> + col_number (column number starts from 1).
     * @param pkLength Length of each option's primary key. If no PK is needed, <code>pkLength</code> can be 0. Each primary key value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_ID</code> + pk_number (PK number starts from 1).
     */
    public DGuiOptionPickerSettings(String title, String sql, ArrayList<DGridColumnForm> gridColumns, int pkLength) {
        this(title, sql, gridColumns, pkLength, DLibConsts.UNDEFINED);
    }

    /**
     * @param title Option picker dialog's title.
     * @param sql SQL query.
     * @param gridColumns Option picker columns. Each column value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_PICK</code> + col_number (column number starts from 1).
     * @param pkLength Length of each option's primary key. If no PK is needed, <code>pkLength</code> can be 0. Each primary key value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_ID</code> + pk_number (PK number starts from 1).
     * @param mainOptionDataType Data type of each option's main option. Constants defined in <code>sa.lib.DLibConsts</code> (DATA_TYPE...). Value will be found in query by text: <code>sa.lib.db.DDbConsts.FIELD_VALUE</code>.
     */
    public DGuiOptionPickerSettings(String title, String sql, ArrayList<DGridColumnForm> gridColumns, int pkLength, int mainOptionDataType) {
        msTitle = title;
        msSql = sql;
        maGridColumns = new ArrayList<DGridColumnForm>();
        maGridColumns.addAll(gridColumns);
        mnPrimaryKeyLength = pkLength;
        mbMainOptionApplying = mainOptionDataType != DLibConsts.UNDEFINED;
        mnMainOptionDataType = mainOptionDataType;
    }

    public String getTitle() { return msTitle; }
    public String getSql() { return msSql; }
    public ArrayList<DGridColumnForm> getGridColumns() { return maGridColumns; }
    public int getPrimaryKeyLength() { return mnPrimaryKeyLength; }
    public boolean isMainOptionApplying() { return mbMainOptionApplying; }
    public int getMainOptionDataType() { return mnMainOptionDataType; }
}
