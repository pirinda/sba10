/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import sba.lib.gui.DGuiClient;

/**
 *
 * @author Sergio Flores
 */
public interface DGridPane {

    public DGuiClient getClient();
    public int getGridPaneType();
    public int getGridType();
    public int getGridSubtype();
    public int getGridMode();
    public int getGridSubmode();
    public DGridModel getModel();
    public JTable getTable();
    public JScrollPane getScrollPane();

    public void clearGrid();
    public void clearGridRows();
    public void renderGrid();
    public void renderGridRows();
    public void initSortKeys();
    public void initSortKeysDescending();
    public void putFilter(final int filterType, final Object filterValue);

    public void setGridRow(final DGridRow gridRow, final int row);
    public void setGridColumn(final DGridColumn gridColumn, final int col);
    public DGridRow getGridRow(final int row);
    public DGridColumn getGridColumn(final int col);
    public void addGridRow(final DGridRow gridRow);
    public void addGridColumn(final DGridColumn gridColumn);
    public void insertGridRow(final DGridRow gridRow, final int row);
    public void insertGridColumn(final DGridColumn gridColumn, final int col);
    public DGridRow removeGridRow(final int row);
    public DGridColumn removeGridColumn(final int col);
    public void setSelectedGridColumn(final int col);
    public void setSelectedGridRow(final int row);
    public DGridRow getSelectedGridRow();
    public void setRowValueAtFieldName(final Object value, final int row, final String fieldName);
    public Object getRowValueAtFieldName(final int row, final String fieldName);
}
