/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

import java.awt.Color;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridConsts {

    public static final int GRID_PANE_VIEW = 1;
    public static final int GRID_PANE_FORM = 2;

    public static final int GRID_VIEW_TAB = 1;
    public static final int GRID_VIEW_OPTION_PICKER = 2;

    public static final int ROW_TYPE_DATA = 1;
    public static final int ROW_TYPE_SUM = 2;

    public static final int COL_TYPE_INT_1B = 101;
    public static final int COL_TYPE_INT_2B = 102;
    public static final int COL_TYPE_INT_4B = 103;
    public static final int COL_TYPE_INT_8B = 104;
    public static final int COL_TYPE_INT_RAW = 111;
    public static final int COL_TYPE_INT_CAL_MONTH = 121;
    public static final int COL_TYPE_INT_CAL_YEAR = 122;
    public static final int COL_TYPE_INT_ICON = 131;
    public static final int COL_TYPE_DEC_0D = 201;
    public static final int COL_TYPE_DEC_2D = 202;
    public static final int COL_TYPE_DEC_4D = 203;
    public static final int COL_TYPE_DEC_8D = 204;
    public static final int COL_TYPE_DEC_AMT = 211;
    public static final int COL_TYPE_DEC_AMT_UNIT = 212;
    public static final int COL_TYPE_DEC_EXC_RATE = 231;
    public static final int COL_TYPE_DEC_QTY = 241;
    public static final int COL_TYPE_DEC_PER_0D = 251;
    public static final int COL_TYPE_DEC_PER_2D = 252;
    public static final int COL_TYPE_DEC_PER_4D = 253;
    public static final int COL_TYPE_DEC_PER_8D = 254;
    public static final int COL_TYPE_DEC_PER_TAX = 255;
    public static final int COL_TYPE_DEC_PER_DISC = 256;
    public static final int COL_TYPE_BOOL_S = 301;
    public static final int COL_TYPE_BOOL_M = 302;
    public static final int COL_TYPE_BOOL_L = 303;
    public static final int COL_TYPE_TEXT = 401;
    public static final int COL_TYPE_TEXT_CODE_CO = 411;
    public static final int COL_TYPE_TEXT_CODE_BPR = 412;
    public static final int COL_TYPE_TEXT_CODE_CAT = 413;
    public static final int COL_TYPE_TEXT_CODE_ITM = 414;
    public static final int COL_TYPE_TEXT_CODE_UNT = 415;
    public static final int COL_TYPE_TEXT_CODE_CUR = 416;
    public static final int COL_TYPE_TEXT_CODE_ACC = 417;
    public static final int COL_TYPE_TEXT_NAME_CAT_S = 421;
    public static final int COL_TYPE_TEXT_NAME_CAT_M = 422;
    public static final int COL_TYPE_TEXT_NAME_CAT_L = 423;
    public static final int COL_TYPE_TEXT_NAME_BPR_S = 424;
    public static final int COL_TYPE_TEXT_NAME_BPR_L = 425;
    public static final int COL_TYPE_TEXT_NAME_ITM_S = 426;
    public static final int COL_TYPE_TEXT_NAME_ITM_L = 427;
    public static final int COL_TYPE_TEXT_NAME_USR = 428;
    public static final int COL_TYPE_TEXT_NAME_ACC = 429;
    public static final int COL_TYPE_TEXT_REG_PER = 431;
    public static final int COL_TYPE_TEXT_REG_NUM = 432;
    public static final int COL_TYPE_DATE = 501;
    public static final int COL_TYPE_DATE_DATETIME = 502;
    public static final int COL_TYPE_DATE_TIME = 503;

    public static final int REFRESH_MODE_RESET = 1;
    public static final int REFRESH_MODE_RELOAD = 2;

    public static final int FILTER_DELETED = 1;
    public static final int FILTER_DATE = 2;
    public static final int FILTER_DATE_TYPE = 3;
    public static final int FILTER_DATE_PERIOD = 4;
    public static final int FILTER_DATE_RANGE = 5;
    public static final int FILTER_YEAR = 6;
    public static final int FILTER_YEAR_MONTH = 7;

    public static final int DATE_TYPE_EVT = 1;
    public static final int DATE_TYPE_DOC = 2;

    public static final int ICON_NULL = 1;
    public static final int ICON_ANNUL = 2;
    public static final int ICON_CROSS = 3;
    public static final int ICON_OK = 4;
    public static final int ICON_DOC = 5;
    public static final int ICON_THUMBS_UP = 11;
    public static final int ICON_THUMBS_DOWN = 12;
    public static final int ICON_XML_PEND = 21;
    public static final int ICON_XML_ISSU = 22;
    public static final int ICON_XML_ANNUL = 23;
    public static final int ICON_XML_ANNUL_PDF = 26;
    public static final int ICON_XML_ANNUL_XML = 27;
    
    public static final int MAX_DECS = 8;

    public static final Color COLOR_FG_EDIT = new Color(0, 0, 255);
    public static final Color COLOR_FG_EDIT_NEG = new Color(255, 0, 0);
    public static final Color COLOR_FG_READ = new Color(0, 0, 0);
    public static final Color COLOR_FG_READ_NEG = new Color(255, 0, 0);
    public static final Color COLOR_BG_PLAIN_EDIT = new Color(255, 255, 255);
    public static final Color COLOR_BG_PLAIN_READ = new Color(255, 255, 255);
    public static final Color COLOR_BG_SELECT_EDIT = new Color(149, 179, 215);
    public static final Color COLOR_BG_SELECT_EDIT_FOCUS = new Color(184, 204, 228);
    public static final Color COLOR_BG_SELECT_READ = new Color(149, 179, 215);
    public static final Color COLOR_BG_SELECT_READ_FOCUS = new Color(184, 204, 228);

    public static final String COL_TITLE_NUM = "Folio";
    public static final String COL_TITLE_TYPE = "Tipo";
    public static final String COL_TITLE_CLASS = "Clase";
    public static final String COL_TITLE_STAT = "Estatus";
    public static final String COL_TITLE_CODE = "Código";
    public static final String COL_TITLE_NAME = "Nombre";
    public static final String COL_TITLE_DATE = "Fecha";
    public static final String COL_TITLE_DATE_STA = "Fecha inicial";
    public static final String COL_TITLE_DATE_END = "Fecha final";
    public static final String COL_TITLE_CAN_UPD = "Modificable";
    public static final String COL_TITLE_CAN_DIS = "Inhabilitable";
    public static final String COL_TITLE_CAN_DEL = "Eliminable";
    public static final String COL_TITLE_IS_AUD = "Auditado";
    public static final String COL_TITLE_IS_AVL = "Disponible";
    public static final String COL_TITLE_IS_DIS = "Inhabilitado";
    public static final String COL_TITLE_IS_DEL = "Eliminado";
    public static final String COL_TITLE_IS_SYS = "Sistema";
    public static final String COL_TITLE_USER_USR_ID = "Usr ID";
    public static final String COL_TITLE_USER_INS_ID = "Usr ID nvo";
    public static final String COL_TITLE_USER_UPD_ID = "Usr ID mod";
    public static final String COL_TITLE_USER_AUD_ID = "Usr ID aud";
    public static final String COL_TITLE_USER_AVL_ID = "Usr ID dis";
    public static final String COL_TITLE_USER_USR_TS = "Usr TS";
    public static final String COL_TITLE_USER_INS_TS = "Usr TS nvo";
    public static final String COL_TITLE_USER_UPD_TS = "Usr TS mod";
    public static final String COL_TITLE_USER_AUD_TS = "Usr TS aud";
    public static final String COL_TITLE_USER_AVL_TS = "Usr TS dis";
    public static final String COL_TITLE_USER_USR_NAME = "Usr";
    public static final String COL_TITLE_USER_INS_NAME = "Usr nvo";
    public static final String COL_TITLE_USER_UPD_NAME = "Usr mod";
    public static final String COL_TITLE_USER_AUD_NAME = "Usr aud";
    public static final String COL_TITLE_USER_AVL_NAME = "Usr dis";

    public static final String MSG_CONFIRM_REG_DIS = "¿Está seguro que desea inhabilitar los registros seleccionados?";
    public static final String MSG_CONFIRM_REG_DEL = "¿Está seguro que desea eliminar los registros seleccionados?";
    public static final String MSG_CONFIRM_RESET_SETTINGS = "¿Está seguro que desea limpiar las preferencias de la vista?";
    public static final String MSG_SELECT_ROW = "Se debe seleccionar un registro de la vista.";
    public static final String MSG_SELECT_ROWS = "Se debe seleccionar al menos un registro de la vista.";

    public static final String ERR_MSG_VAL_NOT_FOUND = "El valor buscado no fue encontrado.";
    public static final String ERR_MSG_ROW_TYPE_DATA = "El renglón no es de datos.";
    public static final String ERR_MSG_ROW_TYPE_SUM = "El renglón no es de suma.";
}
