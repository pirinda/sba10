/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import java.util.Vector;
import javax.swing.table.TableCellRenderer;
import sba.lib.DLibRpnArgument;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridColumn {

    protected int mnColumnType;
    protected int mnColumnWidth;
    protected String msColumnTitle;
    protected String msFieldName;
    protected TableCellRenderer miCellRenderer;
    protected boolean mbApostropheOnCsvRequired;
    protected Vector<DLibRpnArgument> mvRpnArguments;

    public DGridColumn(int columnType, String fieldName, String columnTitle) {
        this(columnType, fieldName, columnTitle, DGridUtils.getColumnWidth(columnType), DGridUtils.getCellRenderer(columnType));
    }

    public DGridColumn(int columnType, String fieldName, String columnTitle, TableCellRenderer cellRenderer) {
        this(columnType, fieldName, columnTitle, DGridUtils.getColumnWidth(columnType), cellRenderer);
    }

    public DGridColumn(int columnType, String fieldName, String columnTitle, int columnWidth) {
        this(columnType, fieldName, columnTitle, columnWidth, DGridUtils.getCellRenderer(columnType));
    }

    public DGridColumn(int columnType, String fieldName, String columnTitle, int columnWidth, TableCellRenderer cellRenderer) {
        mnColumnType = columnType;
        mnColumnWidth = columnWidth;
        msColumnTitle = columnTitle;
        msFieldName = fieldName;
        miCellRenderer = cellRenderer;
        mbApostropheOnCsvRequired = false;
        mvRpnArguments = new Vector<DLibRpnArgument>();
    }

    public void setColumnType(int n) { mnColumnType = n; }
    public void setColumnWidth(int n) { mnColumnWidth = n; }
    public void setColumnTitle(String s) { msColumnTitle = s; }
    public void setFieldName(String s) { msFieldName = s; }
    public void setCellRenderer(TableCellRenderer i) { miCellRenderer = i; }
    public void setApostropheOnCsvRequired(boolean b) { mbApostropheOnCsvRequired = b; }

    public int getColumnType() { return mnColumnType; }
    public int getColumnWidth() { return mnColumnWidth; }
    public String getColumnTitle() { return msColumnTitle; }
    public String getFieldName() { return msFieldName; }
    public TableCellRenderer getCellRenderer() { return miCellRenderer; }
    public boolean isApostropheOnCsvRequired() { return mbApostropheOnCsvRequired; }

    public Vector<DLibRpnArgument> getRpnArguments() { return mvRpnArguments; }
}
