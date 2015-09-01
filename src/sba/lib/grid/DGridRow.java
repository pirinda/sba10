/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

/**
 *
 * @author Sergio Flores
 */
public interface DGridRow {

    public int[] getRowPrimaryKey();
    public String getRowCode();
    public String getRowName();
    public boolean isRowSystem();
    public boolean isRowDeletable();
    public boolean isRowEdited();
    public void setRowEdited(final boolean edited);
    public Object getRowValueAt(final int col);
    public void setRowValueAt(final Object value, final int col);
}
