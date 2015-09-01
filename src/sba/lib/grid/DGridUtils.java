/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import sba.lib.DLibConsts;
import sba.lib.DLibRpnArgument;
import sba.lib.DLibRpnArgumentType;
import sba.lib.DLibRpnOperator;
import sba.lib.DLibTimeUtils;
import sba.lib.DLibUtils;
import sba.lib.grid.cell.DGridCellRendererBoolean;
import sba.lib.grid.cell.DGridCellRendererDate;
import sba.lib.grid.cell.DGridCellRendererDefault;
import sba.lib.grid.cell.DGridCellRendererIcon;
import sba.lib.grid.cell.DGridCellRendererNumber;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiDate;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridUtils {

    public static final DGridCellRendererNumber CellRendererInteger = new DGridCellRendererNumber(DLibUtils.DecimalFormatInteger);
    public static final DGridCellRendererNumber CellRendererIntegerRaw = new DGridCellRendererNumber(DLibUtils.DecimalFormatIntegerRaw);
    public static final DGridCellRendererNumber CellRendererCalendarYear = new DGridCellRendererNumber(DLibUtils.DecimalFormatCalendarYear);
    public static final DGridCellRendererNumber CellRendererCalendarMonth = new DGridCellRendererNumber(DLibUtils.DecimalFormatCalendarMonth);
    public static final DGridCellRendererNumber CellRendererValue0D = new DGridCellRendererNumber(DLibUtils.DecimalFormatValue0D);
    public static final DGridCellRendererNumber CellRendererValue2D = new DGridCellRendererNumber(DLibUtils.DecimalFormatValue2D);
    public static final DGridCellRendererNumber CellRendererValue4D = new DGridCellRendererNumber(DLibUtils.DecimalFormatValue4D);
    public static final DGridCellRendererNumber CellRendererValue8D = new DGridCellRendererNumber(DLibUtils.DecimalFormatValue8D);
    public static final DGridCellRendererNumber CellRendererPercentage0D = new DGridCellRendererNumber(DLibUtils.DecimalFormatPercentage0D);
    public static final DGridCellRendererNumber CellRendererPercentage2D = new DGridCellRendererNumber(DLibUtils.DecimalFormatPercentage2D);
    public static final DGridCellRendererNumber CellRendererPercentage4D = new DGridCellRendererNumber(DLibUtils.DecimalFormatPercentage4D);
    public static final DGridCellRendererNumber CellRendererPercentage8D = new DGridCellRendererNumber(DLibUtils.DecimalFormatPercentage8D);
    public static final DGridCellRendererDefault CellRendererString = new DGridCellRendererDefault();
    public static final DGridCellRendererBoolean CellRendererBoolean = new DGridCellRendererBoolean();
    public static final DGridCellRendererDate CellRendererDate = new DGridCellRendererDate(DLibUtils.DateFormatDate);
    public static final DGridCellRendererDate CellRendererDatetime = new DGridCellRendererDate(DLibUtils.DateFormatDatetime);
    public static final DGridCellRendererDate CellRendererTime = new DGridCellRendererDate(DLibUtils.DateFormatTime);
    public static final DGridCellRendererIcon CellRendererIcon = new DGridCellRendererIcon();

    public static DGridCellRendererNumber getCellRendererNumber() {
        return CellRendererValue8D;
    }

    public static DGridCellRendererNumber getCellRendererNumberAmount() {
        return CellRendererValue2D;
    }

    public static DGridCellRendererNumber getCellRendererNumberAmountUnitary() {
        return CellRendererValue8D;
    }

    public static DGridCellRendererNumber getCellRendererNumberExchangeRate() {
        return CellRendererValue4D;
    }

    public static DGridCellRendererNumber getCellRendererNumberQuantity() {
        return CellRendererValue4D;
    }

    public static DGridCellRendererNumber getCellRendererNumberPercentage() {
        return CellRendererPercentage8D;
    }

    public static DGridCellRendererNumber getCellRendererNumberPercentageTax() {
        return CellRendererPercentage4D;
    }

    public static DGridCellRendererNumber getCellRendererNumberPercentageDiscount() {
        return CellRendererPercentage4D;
    }

    public static int getColumnWidth(final int columnType) {
        int width = 0;

        switch (columnType) {
            case DGridConsts.COL_TYPE_INT_1B:
                width = 25;
                break;
            case DGridConsts.COL_TYPE_INT_2B:
                width = 50;
                break;
            case DGridConsts.COL_TYPE_INT_4B:
                width = 75;
                break;
            case DGridConsts.COL_TYPE_INT_8B:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_INT_RAW:
                width = 75;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_MONTH:
                width = 30;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_YEAR:
                width = 40;
                break;
            case DGridConsts.COL_TYPE_INT_ICON:
                width = 16;
                break;
            case DGridConsts.COL_TYPE_DEC_0D:
                width = 60;
                break;
            case DGridConsts.COL_TYPE_DEC_2D:
                width = 80;
                break;
            case DGridConsts.COL_TYPE_DEC_4D:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_DEC_8D:
                width = 120;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT_UNIT:
                width = 120;
                break;
            case DGridConsts.COL_TYPE_DEC_EXC_RATE:
                width = 80;
                break;
            case DGridConsts.COL_TYPE_DEC_QTY:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_0D:
                width = 60;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_2D:
                width = 80;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_4D:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_8D:
                width = 120;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_TAX:
                width = 80;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_DISC:
                width = 80;
                break;
            case DGridConsts.COL_TYPE_BOOL_S:
                width = 50;
                break;
            case DGridConsts.COL_TYPE_BOOL_M:
                width = 75;
                break;
            case DGridConsts.COL_TYPE_BOOL_L:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_CO:
                width = 35;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_BPR:
                width = 50;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_CAT:
                width = 50;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_ITM:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_UNT:
                width = 35;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_CUR:
                width = 35;
                break;
            case DGridConsts.COL_TYPE_TEXT_CODE_ACC:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_S:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_M:
                width = 200;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_L:
                width = 300;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_S:
                width = 150;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_L:
                width = 300;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_S:
                width = 150;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_L:
                width = 300;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_USR:
                width = 100;
                break;
            case DGridConsts.COL_TYPE_TEXT_NAME_ACC:
                width = 200;
                break;
            case DGridConsts.COL_TYPE_TEXT_REG_PER:
                width = 50;
                break;
            case DGridConsts.COL_TYPE_TEXT_REG_NUM:
                width = 85;
                break;
            case DGridConsts.COL_TYPE_DATE:
                width = 65;
                break;
            case DGridConsts.COL_TYPE_DATE_DATETIME:
                width = 110;
                break;
            case DGridConsts.COL_TYPE_DATE_TIME:
                width = 45;
                break;
            default:
                DLibUtils.showException(DGridUtils.class.getName(), new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN));
        }

        return width;
    }

    public static DefaultTableCellRenderer getCellRenderer(final int columnType) {
        DefaultTableCellRenderer renderer = null;

        switch (columnType) {
            case DGridConsts.COL_TYPE_INT_1B:
            case DGridConsts.COL_TYPE_INT_2B:
            case DGridConsts.COL_TYPE_INT_4B:
            case DGridConsts.COL_TYPE_INT_8B:
                renderer = CellRendererInteger;
                break;
            case DGridConsts.COL_TYPE_INT_RAW:
                renderer = CellRendererIntegerRaw;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_MONTH:
                renderer = CellRendererCalendarMonth;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_YEAR:
                renderer = CellRendererCalendarYear;
                break;
            case DGridConsts.COL_TYPE_INT_ICON:
                renderer = CellRendererIcon;
                break;
            case DGridConsts.COL_TYPE_DEC_0D:
                renderer = CellRendererValue0D;
                break;
            case DGridConsts.COL_TYPE_DEC_2D:
                renderer = CellRendererValue2D;
                break;
            case DGridConsts.COL_TYPE_DEC_4D:
                renderer = CellRendererValue4D;
                break;
            case DGridConsts.COL_TYPE_DEC_8D:
                renderer = CellRendererValue8D;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT:
                renderer = CellRendererValue2D;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT_UNIT:
                renderer = CellRendererValue8D;
                break;
            case DGridConsts.COL_TYPE_DEC_EXC_RATE:
                renderer = CellRendererValue4D;
                break;
            case DGridConsts.COL_TYPE_DEC_QTY:
                renderer = CellRendererValue4D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_0D:
                renderer = CellRendererPercentage0D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_2D:
                renderer = CellRendererPercentage2D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_4D:
                renderer = CellRendererPercentage4D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_8D:
                renderer = CellRendererPercentage8D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_TAX:
                renderer = CellRendererPercentage4D;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_DISC:
                renderer = CellRendererPercentage4D;
                break;
            case DGridConsts.COL_TYPE_BOOL_S:
            case DGridConsts.COL_TYPE_BOOL_M:
            case DGridConsts.COL_TYPE_BOOL_L:
                renderer = CellRendererBoolean;
                break;
            case DGridConsts.COL_TYPE_TEXT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CO:
            case DGridConsts.COL_TYPE_TEXT_CODE_BPR:
            case DGridConsts.COL_TYPE_TEXT_CODE_CAT:
            case DGridConsts.COL_TYPE_TEXT_CODE_ITM:
            case DGridConsts.COL_TYPE_TEXT_CODE_UNT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CUR:
            case DGridConsts.COL_TYPE_TEXT_CODE_ACC:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_M:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_USR:
            case DGridConsts.COL_TYPE_TEXT_NAME_ACC:
            case DGridConsts.COL_TYPE_TEXT_REG_PER:
            case DGridConsts.COL_TYPE_TEXT_REG_NUM:
                renderer = CellRendererString;
                break;
            case DGridConsts.COL_TYPE_DATE:
                renderer = CellRendererDate;
                break;
            case DGridConsts.COL_TYPE_DATE_DATETIME:
                renderer = CellRendererDatetime;
                break;
            case DGridConsts.COL_TYPE_DATE_TIME:
                renderer = CellRendererTime;
                break;
            default:
                DLibUtils.showException(DGridUtils.class.getName(), new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN));
        }

        return renderer;
    }

    public static int getDataType(final int columnType) {
        int type = DLibConsts.UNDEFINED;

        switch (columnType) {
            case DGridConsts.COL_TYPE_INT_1B:
            case DGridConsts.COL_TYPE_INT_2B:
            case DGridConsts.COL_TYPE_INT_4B:
            case DGridConsts.COL_TYPE_INT_8B:
            case DGridConsts.COL_TYPE_INT_RAW:
            case DGridConsts.COL_TYPE_INT_CAL_MONTH:
            case DGridConsts.COL_TYPE_INT_CAL_YEAR:
            case DGridConsts.COL_TYPE_INT_ICON:
                type = DLibConsts.DATA_TYPE_INT;
                break;
            case DGridConsts.COL_TYPE_DEC_0D:
            case DGridConsts.COL_TYPE_DEC_2D:
            case DGridConsts.COL_TYPE_DEC_4D:
            case DGridConsts.COL_TYPE_DEC_8D:
            case DGridConsts.COL_TYPE_DEC_AMT:
            case DGridConsts.COL_TYPE_DEC_AMT_UNIT:
            case DGridConsts.COL_TYPE_DEC_EXC_RATE:
            case DGridConsts.COL_TYPE_DEC_QTY:
            case DGridConsts.COL_TYPE_DEC_PER_0D:
            case DGridConsts.COL_TYPE_DEC_PER_2D:
            case DGridConsts.COL_TYPE_DEC_PER_4D:
            case DGridConsts.COL_TYPE_DEC_PER_8D:
            case DGridConsts.COL_TYPE_DEC_PER_TAX:
            case DGridConsts.COL_TYPE_DEC_PER_DISC:
                type = DLibConsts.DATA_TYPE_DEC;
                break;
            case DGridConsts.COL_TYPE_BOOL_S:
            case DGridConsts.COL_TYPE_BOOL_M:
            case DGridConsts.COL_TYPE_BOOL_L:
                type = DLibConsts.DATA_TYPE_BOOL;
                break;
            case DGridConsts.COL_TYPE_TEXT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CO:
            case DGridConsts.COL_TYPE_TEXT_CODE_BPR:
            case DGridConsts.COL_TYPE_TEXT_CODE_CAT:
            case DGridConsts.COL_TYPE_TEXT_CODE_ITM:
            case DGridConsts.COL_TYPE_TEXT_CODE_UNT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CUR:
            case DGridConsts.COL_TYPE_TEXT_CODE_ACC:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_M:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_USR:
            case DGridConsts.COL_TYPE_TEXT_NAME_ACC:
            case DGridConsts.COL_TYPE_TEXT_REG_PER:
            case DGridConsts.COL_TYPE_TEXT_REG_NUM:
                type = DLibConsts.DATA_TYPE_TEXT;
                break;
            case DGridConsts.COL_TYPE_DATE:
            case DGridConsts.COL_TYPE_DATE_DATETIME:
            case DGridConsts.COL_TYPE_DATE_TIME:
                type = DLibConsts.DATA_TYPE_DATE;
                break;
            default:
                DLibUtils.showException(DGridUtils.class.getName(), new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN));
        }

        return type;
    }

    public static int getGuiType(final int columnType) {
        int type = DLibConsts.UNDEFINED;

        switch (columnType) {
            case DGridConsts.COL_TYPE_INT_1B:
            case DGridConsts.COL_TYPE_INT_2B:
            case DGridConsts.COL_TYPE_INT_4B:
            case DGridConsts.COL_TYPE_INT_8B:
                type = DGuiConsts.GUI_TYPE_INT;
                break;
            case DGridConsts.COL_TYPE_INT_RAW:
                type = DGuiConsts.GUI_TYPE_INT_RAW;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_MONTH:
                type = DGuiConsts.GUI_TYPE_INT_CAL_MONTH;
                break;
            case DGridConsts.COL_TYPE_INT_CAL_YEAR:
                type = DGuiConsts.GUI_TYPE_INT_CAL_YEAR;
                break;
            case DGridConsts.COL_TYPE_INT_ICON:
                type = DGuiConsts.GUI_TYPE_INT;
                break;
            case DGridConsts.COL_TYPE_DEC_0D:
            case DGridConsts.COL_TYPE_DEC_2D:
            case DGridConsts.COL_TYPE_DEC_4D:
            case DGridConsts.COL_TYPE_DEC_8D:
                type = DGuiConsts.GUI_TYPE_DEC;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT:
                type = DGuiConsts.GUI_TYPE_DEC_AMT;
                break;
            case DGridConsts.COL_TYPE_DEC_AMT_UNIT:
                type = DGuiConsts.GUI_TYPE_DEC_AMT_UNIT;
                break;
            case DGridConsts.COL_TYPE_DEC_EXC_RATE:
                type = DGuiConsts.GUI_TYPE_DEC_EXC_RATE;
                break;
            case DGridConsts.COL_TYPE_DEC_QTY:
                type = DGuiConsts.GUI_TYPE_DEC_QTY;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_0D:
            case DGridConsts.COL_TYPE_DEC_PER_2D:
            case DGridConsts.COL_TYPE_DEC_PER_4D:
            case DGridConsts.COL_TYPE_DEC_PER_8D:
                type = DGuiConsts.GUI_TYPE_DEC_PER;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_TAX:
                type = DGuiConsts.GUI_TYPE_DEC_PER_TAX;
                break;
            case DGridConsts.COL_TYPE_DEC_PER_DISC:
                type = DGuiConsts.GUI_TYPE_DEC_PER_DISC;
                break;
            case DGridConsts.COL_TYPE_BOOL_S:
            case DGridConsts.COL_TYPE_BOOL_M:
            case DGridConsts.COL_TYPE_BOOL_L:
                type = DGuiConsts.GUI_TYPE_BOOL;
                break;
            case DGridConsts.COL_TYPE_TEXT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CO:
            case DGridConsts.COL_TYPE_TEXT_CODE_BPR:
            case DGridConsts.COL_TYPE_TEXT_CODE_CAT:
            case DGridConsts.COL_TYPE_TEXT_CODE_ITM:
            case DGridConsts.COL_TYPE_TEXT_CODE_UNT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CUR:
            case DGridConsts.COL_TYPE_TEXT_CODE_ACC:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_M:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_USR:
            case DGridConsts.COL_TYPE_TEXT_NAME_ACC:
            case DGridConsts.COL_TYPE_TEXT_REG_PER:
            case DGridConsts.COL_TYPE_TEXT_REG_NUM:
                type = DGuiConsts.GUI_TYPE_TEXT;
                break;
            case DGridConsts.COL_TYPE_DATE:
                type = DGuiConsts.GUI_TYPE_DATE;
                break;
            case DGridConsts.COL_TYPE_DATE_DATETIME:
                type = DGuiConsts.GUI_TYPE_DATE_DATETIME;
                break;
            case DGridConsts.COL_TYPE_DATE_TIME:
                type = DGuiConsts.GUI_TYPE_DATE_TIME;
                break;
            default:
                DLibUtils.showException(DGridUtils.class.getName(), new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN));
        }

        return type;
    }

    public static Class<?> getDataTypeClass(final int columnType) {
        Class<?> typeClass = null;

        switch (columnType) {
            case DGridConsts.COL_TYPE_INT_1B:
            case DGridConsts.COL_TYPE_INT_2B:
            case DGridConsts.COL_TYPE_INT_4B:
                typeClass = Integer.class;
                break;
            case DGridConsts.COL_TYPE_INT_8B:
                typeClass = Long.class;
                break;
            case DGridConsts.COL_TYPE_INT_RAW:
            case DGridConsts.COL_TYPE_INT_CAL_MONTH:
            case DGridConsts.COL_TYPE_INT_CAL_YEAR:
            case DGridConsts.COL_TYPE_INT_ICON:
                typeClass = Integer.class;
                break;
            case DGridConsts.COL_TYPE_DEC_0D:
            case DGridConsts.COL_TYPE_DEC_2D:
            case DGridConsts.COL_TYPE_DEC_4D:
            case DGridConsts.COL_TYPE_DEC_8D:
            case DGridConsts.COL_TYPE_DEC_AMT:
            case DGridConsts.COL_TYPE_DEC_AMT_UNIT:
            case DGridConsts.COL_TYPE_DEC_EXC_RATE:
            case DGridConsts.COL_TYPE_DEC_QTY:
            case DGridConsts.COL_TYPE_DEC_PER_0D:
            case DGridConsts.COL_TYPE_DEC_PER_2D:
            case DGridConsts.COL_TYPE_DEC_PER_4D:
            case DGridConsts.COL_TYPE_DEC_PER_8D:
            case DGridConsts.COL_TYPE_DEC_PER_TAX:
            case DGridConsts.COL_TYPE_DEC_PER_DISC:
                typeClass = Double.class;
                break;
            case DGridConsts.COL_TYPE_BOOL_S:
            case DGridConsts.COL_TYPE_BOOL_M:
            case DGridConsts.COL_TYPE_BOOL_L:
                typeClass = Boolean.class;
                break;
            case DGridConsts.COL_TYPE_TEXT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CO:
            case DGridConsts.COL_TYPE_TEXT_CODE_BPR:
            case DGridConsts.COL_TYPE_TEXT_CODE_CAT:
            case DGridConsts.COL_TYPE_TEXT_CODE_ITM:
            case DGridConsts.COL_TYPE_TEXT_CODE_UNT:
            case DGridConsts.COL_TYPE_TEXT_CODE_CUR:
            case DGridConsts.COL_TYPE_TEXT_CODE_ACC:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_M:
            case DGridConsts.COL_TYPE_TEXT_NAME_CAT_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_BPR_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_S:
            case DGridConsts.COL_TYPE_TEXT_NAME_ITM_L:
            case DGridConsts.COL_TYPE_TEXT_NAME_USR:
            case DGridConsts.COL_TYPE_TEXT_NAME_ACC:
            case DGridConsts.COL_TYPE_TEXT_REG_PER:
            case DGridConsts.COL_TYPE_TEXT_REG_NUM:
                typeClass = String.class;
                break;
            case DGridConsts.COL_TYPE_DATE:
            case DGridConsts.COL_TYPE_DATE_DATETIME:
            case DGridConsts.COL_TYPE_DATE_TIME:
                typeClass = Date.class;
                break;
            default:
                DLibUtils.showException(DGridUtils.class.getName(), new Exception(DLibConsts.ERR_MSG_OPTION_UNKNOWN));
        }

        return typeClass;
    }

    private static int seek(final DGridPane gridPane, final int col, final SortOrder sortOrder, final int rowFirst, final int rowLast, final double value) {
        int rowMiddle;
        double valueComparison;

        rowMiddle = rowFirst + ((rowLast - rowFirst) / 2);
        valueComparison = value - ((Number) gridPane.getTable().getValueAt(rowMiddle, col)).doubleValue();

        if (valueComparison == 0) {
            return rowMiddle;
        }

        switch (sortOrder) {
            case ASCENDING:
                if (valueComparison < 0) {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                else {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                break;
            case DESCENDING:
                if (valueComparison < 0) {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                else {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                break;
            default:
        }

        return -1;
    }

    private static int seek(final DGridPane gridPane, final int col, final SortOrder sortOrder, final int rowFirst, final int rowLast, final String value) {
        int rowMiddle;
        int valueComparison;

        rowMiddle = rowFirst + ((rowLast - rowFirst) / 2);
        valueComparison = value.compareToIgnoreCase(
        (((java.lang.String) gridPane.getTable().getValueAt(rowMiddle, col)).length() > value.length() ?
        ((java.lang.String) gridPane.getTable().getValueAt(rowMiddle, col)).substring(0, value.length()) :
        (java.lang.String) gridPane.getTable().getValueAt(rowMiddle, col)));

        if (valueComparison == 0) {
            return rowMiddle;
        }

        switch (sortOrder) {
            case ASCENDING:
                if (valueComparison < 0) {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                else {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                break;
            case DESCENDING:
                if (valueComparison < 0) {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                else {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                break;
            default:
        }

        return -1;
    }

    private static int seek(final DGridPane gridPane, final int col, final SortOrder sortOrder, final int rowFirst, final int rowLast, final Date value) {
        int rowMiddle;
        int valueComparison;

        rowMiddle = rowFirst + ((rowLast - rowFirst) / 2);
        valueComparison = value.compareTo((java.util.Date) gridPane.getTable().getValueAt(rowMiddle, col));

        if (valueComparison == 0) {
            return rowMiddle;
        }

        switch (sortOrder) {
            case ASCENDING:
                if (valueComparison < 0) {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                else {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                break;
            case DESCENDING:
                if (valueComparison < 0) {
                    if (rowLast >= (rowMiddle + 1)) {
                        return seek(gridPane, col, sortOrder, rowMiddle + 1, rowLast, value);
                    }
                }
                else {
                    if ((rowMiddle - 1) >= rowFirst) {
                        return seek(gridPane, col, sortOrder, rowFirst, rowMiddle - 1, value);
                    }
                }
                break;
            default:
        }

        return -1;
    }

    public static void seekValue(DGridPane gridPane, String valueToSeek) {
        int col = 0;
        int colType = DLibConsts.UNDEFINED;
        int row = -1;
        int rows = rows = gridPane.getTable().getRowCount();
        double valueAsDouble = 0d;
        Date valueAsDate = null;
        SortOrder sortOrder = null;

        if (gridPane.getTable().getRowSorter().getSortKeys().isEmpty()) {
            col = gridPane.getTable().convertColumnIndexToView(0);
            sortOrder = SortOrder.ASCENDING;
        }
        else {
            col = gridPane.getTable().convertColumnIndexToView(((RowSorter.SortKey) gridPane.getTable().getRowSorter().getSortKeys().get(0)).getColumn());
            sortOrder = ((RowSorter.SortKey) gridPane.getTable().getRowSorter().getSortKeys().get(0)).getSortOrder();
        }

        if (rows > 0) {
            if (col >= 0 && col < gridPane.getTable().getColumnCount()) {
                colType = gridPane.getModel().getGridColumns().get(gridPane.getTable().convertColumnIndexToModel(col)).getColumnType();

                switch (DGridUtils.getDataType(colType)) {
                    case DLibConsts.DATA_TYPE_BOOL:
                    case DLibConsts.DATA_TYPE_INT:
                    case DLibConsts.DATA_TYPE_DEC:
                        valueAsDouble = DLibUtils.parseDouble(valueToSeek);
                        row = seek(gridPane, col, sortOrder, 0, rows - 1, valueAsDouble);
                        break;

                    case DLibConsts.DATA_TYPE_TEXT:
                        row = seek(gridPane, col, sortOrder, 0, rows - 1, DLibUtils.textTrim(valueToSeek));
                        break;

                    case DLibConsts.DATA_TYPE_DATE:
                        SimpleDateFormat dateFormat = null;

                        switch (colType) {
                            case DGridConsts.COL_TYPE_DATE:
                                dateFormat = DLibUtils.DateFormatDate;
                                break;
                            case DGridConsts.COL_TYPE_DATE_DATETIME:
                                dateFormat = DLibUtils.DateFormatDatetime;
                                break;
                            case DGridConsts.COL_TYPE_DATE_TIME:
                                dateFormat = DLibUtils.DateFormatTime;
                                break;
                            default:
                        }

                        try {
                            valueAsDate = dateFormat.parse(valueToSeek);
                            row = seek(gridPane, col, sortOrder, 0, rows - 1, valueAsDate);
                        }
                        catch (java.text.ParseException e) {
                            DLibUtils.showException(DGridUtils.class.getName(), e);
                        }
                        break;

                    default:
                        break;
                }

                if (row == -1) {
                    gridPane.getClient().showMsgBoxWarning(DGridConsts.ERR_MSG_VAL_NOT_FOUND + "\n(" + valueToSeek + ")");
                }
                else {
                    // Go back to first occurrence of value:

                    switch (DGridUtils.getDataType(colType)) {
                        case DLibConsts.DATA_TYPE_BOOL:
                        case DLibConsts.DATA_TYPE_INT:
                        case DLibConsts.DATA_TYPE_DEC:
                            while (row > 0 && valueAsDouble == ((Number) gridPane.getTable().getValueAt(row - 1, col)).doubleValue()) {
                                row--;
                            }
                            break;

                        case DLibConsts.DATA_TYPE_TEXT:
                            while (row > 0 && valueToSeek.compareToIgnoreCase(
                            (((String) gridPane.getTable().getValueAt(row - 1, col)).length() > valueToSeek.length() ?
                            ((String) gridPane.getTable().getValueAt(row - 1, col)).substring(0, valueToSeek.length()) :
                            (String) gridPane.getTable().getValueAt(row - 1, col))) == 0) {
                                row--;
                            }
                            break;

                        case DLibConsts.DATA_TYPE_DATE:
                            while (row > 0 && valueAsDate.compareTo((Date) gridPane.getTable().getValueAt(row - 1, col)) == 0) {
                                row--;
                            }
                            break;

                        default:
                    }

                    // Scroll to value:

                    gridPane.setSelectedGridRow(row);
                    gridPane.getTable().requestFocus();
                }
            }
        }
    }

    public static void saveCsv(DGridPane gridPane, java.lang.String title) {
        int col = 0;
        int colType = 0;
        int colModel = 0;
        int rowModel = 0;
        int row = 0;
        String buffer = "";

        gridPane.getClient().getFileChooser().setSelectedFile(new File(title + " " + DLibUtils.FileDateFormatDatetime.format(new Date()) + ".csv"));
        if (gridPane.getClient().getFileChooser().showSaveDialog(gridPane.getClient().getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(gridPane.getClient().getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

                for (col = 0; col < gridPane.getTable().getColumnCount(); col++) {
                    colModel = gridPane.getTable().convertColumnIndexToModel(col);
                    buffer += (buffer.length() == 0 ? "" : ",") + "\"" + DLibUtils.textToAscii(gridPane.getModel().getGridColumns().get(colModel).getColumnTitle()) + "\"";
                }
                bw.write(buffer);

                for (row = 0; row < gridPane.getTable().getRowCount(); row++) {
                    buffer = "";

                    for (col = 0; col < gridPane.getTable().getColumnCount(); col++) {
                        buffer += (col == 0 ? "" : ",");
                        rowModel = gridPane.getTable().convertRowIndexToModel(row);
                        colModel = gridPane.getTable().convertColumnIndexToModel(col);

                        if (gridPane.getModel().getValueAt(rowModel, colModel) != null) {
                            colType = gridPane.getModel().getGridColumns().get(colModel).getColumnType();

                            switch (DGridUtils.getDataType(colType)) {
                                case DLibConsts.DATA_TYPE_BOOL:
                                    buffer += (((Boolean) gridPane.getModel().getValueAt(rowModel, colModel)).booleanValue() ? "1" : "0");
                                    break;
                                case DLibConsts.DATA_TYPE_INT:
                                    buffer += ((Number) gridPane.getModel().getValueAt(rowModel, colModel)).longValue();
                                    break;
                                case DLibConsts.DATA_TYPE_DEC:
                                    buffer += ((Number) gridPane.getModel().getValueAt(rowModel, colModel)).doubleValue();
                                    break;
                                case DLibConsts.DATA_TYPE_TEXT:
                                    buffer += "\"" + (!gridPane.getModel().getGridColumns().get(colModel).isApostropheOnCsvRequired() ? "" : "'") + DLibUtils.textToAscii(((String) gridPane.getModel().getValueAt(rowModel, colModel)).replaceAll("\"", "\"\"")) + "\"";
                                    break;
                                case DLibConsts.DATA_TYPE_DATE:
                                    switch (colType) {
                                        case DGridConsts.COL_TYPE_DATE:
                                            buffer += DLibUtils.CsvFormatDate.format((Date) gridPane.getModel().getValueAt(rowModel, colModel));
                                            break;
                                        case DGridConsts.COL_TYPE_DATE_DATETIME:
                                            buffer += DLibUtils.CsvFormatDatetime.format((Date) gridPane.getModel().getValueAt(rowModel, colModel));
                                            break;
                                        case DGridConsts.COL_TYPE_DATE_TIME:
                                            buffer += DLibUtils.CsvFormatTime.format((Date) gridPane.getModel().getValueAt(rowModel, colModel));
                                            break;
                                        default:
                                    }
                                    break;
                                default:
                                    buffer += "\"?\"";
                            }
                        }
                    }
                    bw.write("\n");
                    bw.write(DLibUtils.textToAscii(buffer));
                }

                bw.flush();
                bw.close();

                if (gridPane.getClient().showMsgBoxConfirm(DGuiConsts.MSG_FILE_SAVED + file.getPath() + "\n" + DGuiConsts.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    DLibUtils.launchFile(file.getPath());
                }
            }
            catch (Exception e) {
                DLibUtils.showException(DGridUtils.class.getName(), e);
            }
        }
    }

    public static void computeRpn(DGridModel gridModel) {
        int col = 0;
        int row = 0;
        double a = 0;
        double b = 0;
        double value = 0;
        Deque<Object> stack = new ArrayDeque<Object>();
        Vector<DLibRpnArgument> arguments = null;
        DLibRpnOperator operator = null;

        try {
            for (col = 0; col < gridModel.getColumnCount(); col++) {
                arguments = gridModel.getGridColumns().get(col).getRpnArguments();

                if (arguments.size() > 0) {
                    for (row = 0; row < gridModel.getRowCount(); row++) {
                        for (DLibRpnArgument argument : arguments) {
                            if (argument.getArgumentType() == DLibRpnArgumentType.OPERAND) {
                                stack.addFirst(gridModel.getValueAtFieldName(row, (String) argument.getArgument()));
                            }
                            else if (argument.getArgumentType() == DLibRpnArgumentType.OPERATOR) {
                                if (stack.size() < 2) {
                                    throw new Exception(DLibConsts.ERR_MSG_RPN_ARGS_FEW);
                                }
                                else {
                                    b = stack.getFirst() instanceof Boolean ? (((Boolean) stack.pollFirst()) ? 1d : 0d) : ((Number) stack.pollFirst()).doubleValue();
                                    a = stack.getFirst() instanceof Boolean ? (((Boolean) stack.pollFirst()) ? 1d : 0d) : ((Number) stack.pollFirst()).doubleValue();
                                    operator = (DLibRpnOperator) argument.getArgument();

                                    switch (operator) {
                                        case ADDITION:
                                            stack.addFirst(a + b);
                                            break;
                                        case SUBTRACTION:
                                            stack.addFirst(a - b);
                                            break;
                                        case MULTIPLICATION:
                                            stack.addFirst(a * b);
                                            break;
                                        case DIVISION:
                                            stack.addFirst(b == 0d ? 0d : a / b);
                                            break;
                                        default:
                                    }
                                }
                            }
                        }

                        if (stack.size() == 1) {
                            value = ((Number) stack.pollFirst()).doubleValue();
                        }
                        else if (stack.size() < 1) {
                            throw new Exception(DLibConsts.ERR_MSG_RPN_ARGS_FEW);
                        }
                        else if (stack.size() > 1) {
                            throw new Exception(DLibConsts.ERR_MSG_RPN_ARGS_MANY);
                        }

                        gridModel.setValueAt(value, row, col);
                    }
                }
            }
        }
        catch (Exception e) {
            DLibUtils.showException(DGridUtils.class.getName(), e);
        }
    }

    public static String getSqlFilterDate(final String fieldName, final DGuiDate guiDate) {
        String sql = "";
        int[] date = null;

        switch (guiDate.getGuiType()) {
            case DGuiConsts.GUI_DATE_DATE:
                sql = fieldName + " = '" + DLibUtils.DbmsDateFormatDate.format(guiDate) + "' ";
                break;
            case DGuiConsts.GUI_DATE_MONTH:
                date = DLibTimeUtils.digestMonth(guiDate);
                sql = "(YEAR(" + fieldName + ") = " + date[0] + " AND MONTH(" + fieldName + ") = " + date[1] + ") ";
                break;
            case DGuiConsts.GUI_DATE_YEAR:
                date = DLibTimeUtils.digestYear(guiDate);
                sql = "YEAR(" + fieldName + ") = " + date[0] + " ";
                break;
            default:
        }

        return sql;
    }

    public static String getSqlFilterDateRange(final String fieldName, final Date[] range) {
        return fieldName + " BETWEEN '" + DLibUtils.DbmsDateFormatDate.format(range[0]) + "' AND '" + DLibUtils.DbmsDateFormatDate.format(range[1]) + "' ";
    }

    public static String getSqlFilterKey(final String[] fieldNames, final int[] key) {
        String sql = "";

        if (fieldNames.length == key.length) {
            for (int i = 0; i < fieldNames.length; i++) {
                if (key[i] != DLibConsts.UNDEFINED) {
                    sql += (sql.length() == 0 ? "" : "AND ") + fieldNames[i] + " = " + key[i] + " ";
                }
            }
        }

        return sql;
    }

    public static JButton createButton(final ImageIcon icon, final String toolTip, final ActionListener listener) {
        JButton button = new JButton(icon);

        button.setPreferredSize(new Dimension(23, 23));
        button.setToolTipText(toolTip);
        button.addActionListener(listener);

        return button;
    }

    public static JTextField createTextField(final String toolTip) {
        return createTextField(toolTip, new Dimension(100, 23));
    }

    public static JTextField createTextField(final String toolTip, final Dimension dimension) {
        JTextField textField = new JTextField();

        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setPreferredSize(dimension);
        textField.setToolTipText(toolTip);

        return textField;
    }
}
