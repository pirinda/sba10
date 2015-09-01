/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Sergio Flores
 */
public class DGridColumnView extends DGridColumn {

    protected boolean mbSumApplying;

    public DGridColumnView(int columnType, String fieldName, String columnTitle) {
        this(columnType, fieldName, columnTitle, DGridUtils.getColumnWidth(columnType), DGridUtils.getCellRenderer(columnType));
    }

    public DGridColumnView(int columnType, String fieldName, String columnTitle, TableCellRenderer tableCellRenderer) {
        this(columnType, fieldName, columnTitle, DGridUtils.getColumnWidth(columnType), tableCellRenderer);
    }

    public DGridColumnView(int columnType, String fieldName, String columnTitle, int columnWidth) {
        this(columnType, fieldName, columnTitle, columnWidth, DGridUtils.getCellRenderer(columnType));
    }

    public DGridColumnView(int columnType, String fieldName, String columnTitle, int columnWidth, TableCellRenderer cellRenderer) {
        super(columnType, fieldName, columnTitle, columnWidth, cellRenderer);

        mbSumApplying = false;
    }

    public void setSumApplying(boolean b) { mbSumApplying = b; }

    public boolean isSumApplying() { return mbSumApplying; }
}
