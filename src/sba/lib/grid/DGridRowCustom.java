/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridRowCustom implements DGridRow {

    protected int[] manRowPrimaryKey;
    protected String msRowCode;
    protected String msRowName;
    protected Boolean mbRowSystem;
    protected Boolean mbRowDeletable;
    protected Boolean mbRowJustEdited;

    public DGridRowCustom(int[] pk, String code, String name) {
        manRowPrimaryKey = pk;
        msRowCode = code;
        msRowName = name;
        mbRowSystem = false;
        mbRowDeletable = true;
        mbRowJustEdited = false;
    }

    /*
     * Public methods
     */

    public void setRowPrimaryKey(int[] key) { manRowPrimaryKey = key; }
    public void setRowCode(String s) { msRowCode = s; }
    public void setRowName(String s) { msRowName = s; }
    public void setRowSystem(boolean b) { mbRowSystem = b; }
    public void setRowDeletable(boolean b) { mbRowDeletable = b; }

    public boolean isCellEditable(int col) {
        return false;
    }

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
        return mbRowDeletable;
    }

    @Override
    public boolean isRowEdited() {
        return mbRowJustEdited;
    }

    @Override
    public void setRowEdited(boolean b) {
        mbRowJustEdited = b;
    }

    public abstract Object getRowValueAt(final int col);
    public abstract void setRowValueAt(final Object value, final int col);
}
