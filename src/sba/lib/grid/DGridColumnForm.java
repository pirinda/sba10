/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Sergio Flores
 */
public class DGridColumnForm extends DGridColumn {

    protected boolean mbEditable;
    protected TableCellEditor miCellEditor;

    public DGridColumnForm(int columnType, String columnTitle) {
        this(columnType, columnTitle, DGridUtils.getColumnWidth(columnType), DGridUtils.getCellRenderer(columnType), null);
    }

    public DGridColumnForm(int columnType, String columnTitle, TableCellRenderer cellRenderer) {
        this(columnType, columnTitle, DGridUtils.getColumnWidth(columnType), cellRenderer, null);
    }

    public DGridColumnForm(int columnType, String columnTitle, TableCellEditor cellEditor) {
        this(columnType, columnTitle, DGridUtils.getColumnWidth(columnType), DGridUtils.getCellRenderer(columnType), cellEditor);
    }

    public DGridColumnForm(int columnType, String columnTitle, TableCellRenderer cellRenderer, TableCellEditor cellEditor) {
        this(columnType, columnTitle, DGridUtils.getColumnWidth(columnType), cellRenderer, cellEditor);
    }

    public DGridColumnForm(int columnType, String columnTitle, int columnWidth) {
        this(columnType, columnTitle, columnWidth, DGridUtils.getCellRenderer(columnType), null);
    }

    public DGridColumnForm(int columnType, String columnTitle, int columnWidth, TableCellRenderer cellRenderer) {
        this(columnType, columnTitle, columnWidth, cellRenderer, null);
    }

    public DGridColumnForm(int columnType, String columnTitle, int columnWidth, TableCellEditor cellEditor) {
        this(columnType, columnTitle, columnWidth, DGridUtils.getCellRenderer(columnType), cellEditor);
    }

    public DGridColumnForm(int columnType, String columnTitle, int columnWidth, TableCellRenderer cellRenderer, TableCellEditor cellEditor) {
        super(columnType, "", columnTitle, columnWidth, cellRenderer);

        mbEditable = cellEditor != null;
        miCellEditor = cellEditor;
    }

    public void setEditable(boolean b) { mbEditable = b; }
    public void setCellEditor(DefaultCellEditor o) { miCellEditor = o; }

    public boolean isEditable() { return mbEditable; }
    public TableCellEditor getCellEditor() { return miCellEditor; }
}
