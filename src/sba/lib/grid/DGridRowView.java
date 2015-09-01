/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Sergio Flores
 */
public class DGridRowView implements DGridRow {

    protected int[] manRowPrimaryKey;
    protected String msRowCode;
    protected String msRowName;
    protected boolean mbRowSystem;

    protected int mnRowType;
    protected int[] manRowRegistryTypeKey;
    protected String msRowRegistryType;
    protected Date mtRowDate;

    protected boolean mbUpdatable;
    protected boolean mbDisableable;
    protected boolean mbDeletable;
    protected boolean mbDisabled;
    protected boolean mbDeleted;
    protected int mnFkUserId;
    protected int mnFkUserInsertId;
    protected int mnFkUserUpdateId;
    protected Date mtTsUser;
    protected Date mtTsUserInsert;
    protected Date mtTsUserUpdate;
    protected String msUser;
    protected String msUserInsert;
    protected String msUserUpdate;

    protected Vector<Object> mvValues;
    protected HashMap<Integer, Object> moComplementsMap;

    public DGridRowView(int[] pk, String code, String name) {
        manRowPrimaryKey = pk;
        msRowCode = code;
        msRowName = name;
        mbRowSystem = false;

        mnRowType = DGridConsts.ROW_TYPE_DATA;
        manRowRegistryTypeKey = null;
        msRowRegistryType = "";
        mtRowDate = null;

        mbUpdatable = true;
        mbDisableable = true;
        mbDeletable = true;
        mbDisabled = false;
        mbDeleted = false;
        mnFkUserId = 0;
        mnFkUserInsertId = 0;
        mnFkUserUpdateId = 0;
        mtTsUser = null;
        mtTsUserInsert = null;
        mtTsUserUpdate = null;
        msUser = "";
        msUserInsert = "";
        msUserUpdate = "";

        mvValues = new Vector<Object>();
        moComplementsMap = new HashMap<Integer, Object>();
    }

    /*
     * Public methods
     */

    public void setPrimaryKey(int[] key) { manRowPrimaryKey = key; }
    public void setRowCode(String s) { msRowCode = s; }
    public void setRowName(String s) { msRowName = s; }
    public void setRowSystem(boolean b) { mbRowSystem = b; }

    public void setRowType(int n) { mnRowType = n; }
    public void setRowRegistryTypeKey(int[] key) { manRowRegistryTypeKey = key; }
    public void setRowRegistryType(String s) { msRowRegistryType = s; }
    public void setRowDate(Date t) { mtRowDate = t; }

    public void setUpdatable(boolean b) { mbUpdatable = b; }
    public void setDisableable(boolean b) { mbDisableable = b; }
    public void setDeletable(boolean b) { mbDeletable = b; }
    public void setDisabled(boolean b) { mbDisabled = b; }
    public void setDeleted(boolean b) { mbDeleted = b; }
    public void setFkUserId(int n) { mnFkUserId = n; }
    public void setFkUserInsertId(int n) { mnFkUserInsertId = n; }
    public void setFkUserUpdateId(int n) { mnFkUserUpdateId = n; }
    public void setTsUser(Date t) { mtTsUser = t; }
    public void setTsUserInsert(Date t) { mtTsUserInsert = t; }
    public void setTsUserUpdate(Date t) { mtTsUserUpdate = t; }
    public void setUser(String s) { msUser = s; }
    public void setUserInsert(String s) { msUserInsert = s; }
    public void setUserUpdate(String s) { msUserUpdate = s; }

    public Vector<Object> getValues() { return mvValues; }
    public HashMap<Integer, Object> getComplementsMap() { return moComplementsMap; }

    /*
     * Overriden methods
     */

    @Override
    public int[] getRowPrimaryKey() {
        return manRowPrimaryKey;
    }

    @Override
    public String getRowCode() {
        return msRowCode;
    }

    @Override
    public String getRowName() {
        return msRowName;
    }

    @Override
    public boolean isRowSystem() {
        return mbRowSystem;
    }

    @Override
    public boolean isRowDeletable() {
        return isDeletable();
    }

    @Override
    public boolean isRowEdited() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRowEdited(final boolean edited) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getRowValueAt(final int col) {
        return mvValues.get(col);
    }

    @Override
    public void setRowValueAt(final Object value, final int col) {
        mvValues.setElementAt(value, col);
    }

    public int getRowType() {
        return mnRowType;
    }

    public int[] getRowRegistryTypeKey() {
        return manRowRegistryTypeKey;
    }

    public String getRowRegistryType() {
        return msRowRegistryType;
    }

    public Date getRowDate() {
        return mtRowDate;
    }

    public boolean isUpdatable() {
        return mbUpdatable;
    }

    public boolean isDisableable() {
        return mbDisableable;
    }

    public boolean isDeletable() {
        return mbDeletable;
    }

    public boolean isDisabled() {
        return mbDisabled;
    }

    public boolean isDeleted() {
        return mbDeleted;
    }

    public int getFkUserId() {
        return mnFkUserId;
    }

    public int getFkUserInsertId() {
        return mnFkUserInsertId;
    }

    public int getFkUserUpdateId() {
        return mnFkUserUpdateId;
    }

    public Date getTsUser() {
        return mtTsUser;
    }

    public Date getTsUserInsert() {
        return mtTsUserInsert;
    }

    public Date getTsUserUpdate() {
        return mtTsUserUpdate;
    }

    public String getUser() {
        return msUser;
    }

    public String getUserInsert() {
        return msUserInsert;
    }

    public String getUserUpdate() {
        return msUserUpdate;
    }
}
