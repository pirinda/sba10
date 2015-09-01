/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sergio Flores
 */
public class DGridModel extends AbstractTableModel {

    protected Vector<DGridRow> mvGridRows;
    protected Vector<DGridColumn> mvGridColumns;
    
    public DGridModel() {
        mvGridRows = new Vector<DGridRow>();
        mvGridColumns = new Vector<DGridColumn>();
    }

    public Vector<DGridRow> getGridRows() { return mvGridRows; }
    public Vector<DGridColumn> getGridColumns() { return mvGridColumns; }

    @Override
    public int getRowCount() {
        return mvGridRows.size();
    }
    
    @Override
    public int getColumnCount() {
        return mvGridColumns.size();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        return mvGridRows.get(row).getRowValueAt(col);
    }
    
    @Override
    public String getColumnName(int col) {
        return mvGridColumns.get(col).getColumnTitle();
    }
    
    @Override
    public Class<?> getColumnClass(int col) {
        return DGridUtils.getDataTypeClass(mvGridColumns.get(col).getColumnType());
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        boolean isCellEditable = false;

        if (mvGridColumns.get(col) instanceof DGridColumnForm) {
            if (mvGridRows.get(row) instanceof DGridRowCustom) {
                isCellEditable = ((DGridRowCustom) mvGridRows.get(row)).isCellEditable(col);
            }
            else {
                isCellEditable = ((DGridColumnForm) mvGridColumns.get(col)).isEditable();
            }
        }

        return isCellEditable;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        mvGridRows.get(row).setRowValueAt(value, col);
    }
    
    public void clearGrid() {
        mvGridRows.removeAllElements();
        mvGridColumns.removeAllElements();
    }
    
    public void clearGridRows() {
        mvGridRows.removeAllElements();
    }
    
    public void renderGrid() {
        fireTableStructureChanged();
        fireTableDataChanged();
    }
    
    public void renderGridRows() {
        fireTableDataChanged();
    }

    public String[] getColumnNames() {
        String[] names = new String[mvGridColumns.size()];

        for (int i = 0; i < names.length; i++) {
            names[i] = mvGridColumns.get(i).getColumnTitle();
        }

        return names;
    }

    public int getColumnIndexAtFieldName(final String fieldName) {
        int index = -1;

        for (int i = 0; i < mvGridColumns.size(); i++) {
            if (fieldName.compareTo(mvGridColumns.get(i).getFieldName()) == 0) {
                index = i;
                break;
            }
        }

        return index;
    }

    public Object getValueAtFieldName(final int row, final String fieldName) {
        Object value = null;
        int index = getColumnIndexAtFieldName(fieldName);

        if (index != -1) {
            value = mvGridRows.get(row).getRowValueAt(index);
        }

        return value;
    }

    public void setValueAtFieldName(final Object value, final int row, final String fieldName) {
        int col = getColumnIndexAtFieldName(fieldName);

        if (col != -1) {
            mvGridRows.get(row).setRowValueAt(value, col);
        }
    }
}
