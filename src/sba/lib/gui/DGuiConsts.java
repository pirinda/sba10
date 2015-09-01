/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public class DGuiConsts {

    public static final int TEXT_CASE_UPPER = 1;
    public static final int TEXT_CASE_LOWER = 2;

    public static final int PANEL_LEFT = 1;
    public static final int PANEL_CENTER = 2;
    public static final int PANEL_RIGHT = 3;

    public static final int GUI_COMP_APP = 1;
    public static final int GUI_COMP_VIEW_TAB = 2;
    public static final int GUI_COMP_VIEW_OPTION_PICKER = 3;
    public static final int GUI_COMP_FORM = 4;

    public static final int GUI_TYPE_INT = 101;
    public static final int GUI_TYPE_INT_RAW = 102;
    public static final int GUI_TYPE_INT_CAL_MONTH = 111;
    public static final int GUI_TYPE_INT_CAL_YEAR = 112;
    public static final int GUI_TYPE_DEC = 201;            // 8 dec
    public static final int GUI_TYPE_DEC_AMT = 211;        // 2 dec
    public static final int GUI_TYPE_DEC_AMT_UNIT = 212;   // 8 dec
    public static final int GUI_TYPE_DEC_EXC_RATE = 221;   // 4 dec
    public static final int GUI_TYPE_DEC_QTY = 231;        // 4 dec
    public static final int GUI_TYPE_DEC_PER = 241;        // 8 dec %
    public static final int GUI_TYPE_DEC_PER_TAX = 242;    // 4 dec %
    public static final int GUI_TYPE_DEC_PER_DISC = 243;   // 4 dec %
    public static final int GUI_TYPE_BOOL = 301;
    public static final int GUI_TYPE_TEXT = 401;
    public static final int GUI_TYPE_DATE = 501;
    public static final int GUI_TYPE_DATE_DATETIME = 502;
    public static final int GUI_TYPE_DATE_TIME = 503;
    public static final int GUI_TYPE_KEY = 601;

    public static final int GUI_DATE_DATE = 1;
    public static final int GUI_DATE_MONTH = 2;
    public static final int GUI_DATE_YEAR = 3;

    public static final int DATE_PICKER_DATE = 1;
    public static final int DATE_PICKER_DATE_PERIOD = 2;
    public static final int DATE_PICKER_DATE_RANGE = 3;
    public static final int DATE_PICKER_YEAR = 4;
    public static final int DATE_PICKER_YEAR_MONTH = 5;

    public static final int BEAN_FORM_EDIT = 1;
    public static final int BEAN_FORM_EDIT_READ = 2;

    public static final int FORM_STATUS_EDIT = 1;
    public static final int FORM_STATUS_READ = 2;

    public static final int FORM_RESULT_OK = 1;
    public static final int FORM_RESULT_CANCEL = 2;

    public static final int FORM_ACTION_NEW = 1;
    public static final int FORM_ACTION_EDIT = 2;

    public static final int PARAM_KEY = 1;
    public static final int PARAM_YEAR = 6;
    public static final int PARAM_DATE = 7;
    public static final int PARAM_DATE_STA = 8;
    public static final int PARAM_DATE_END = 9;
    public static final int PARAM_BPR = 11;
    public static final int PARAM_BPR_TP = 12;
    public static final int PARAM_BPR_CL = 13;
    public static final int PARAM_SYS_MOV_TP = 21;
    public static final int PARAM_DPS = 31;
    public static final int PARAM_DPS_TP = 32;
    public static final int PARAM_DPS_CL = 33;
    public static final int PARAM_DPS_CT = 34;
    public static final int PARAM_REQ_DOC = 41;
    public static final int PARAM_REQ_PAY = 42;
    public static final int PARAM_REQ_STK = 43;
    public static final int PARAM_ITEM = 51;
    public static final int PARAM_ROWS = 101;

    public static final String TXT_BTN_FIND = "Buscar";
    public static final String TXT_BTN_SAVE = "Guardar";
    public static final String TXT_BTN_OK = "Aceptar";
    public static final String TXT_BTN_CANCEL = "Cancelar";
    public static final String TXT_BTN_CLOSE = "Cerrar";
    public static final String TXT_BTN_EDIT = "Modificar";
    public static final String TXT_BTN_SELECT = "Seleccionar";

    public static final String TXT_LBL_CODE = "Código";
    public static final String TXT_LBL_NAME = "Nombre";
    public static final String TXT_LBL_UNIT = "Unidad";
    public static final String TXT_LBL_NUM = "Número";

    public static final String MSG_BOX_INFORMATION = "Información";
    public static final String MSG_BOX_WARNING = "Advertencia";
    public static final String MSG_BOX_ERROR = "Error";
    public static final String MSG_BOX_CONFIRM = "Confirmar";

    public static final String MSG_FILE_SAVED = "El siguiente archivo ha sido guardado:\n";
    public static final String MSG_PROC_WAIT = "El proceso puede demorar varios minutos.";
    public static final String MSG_CHG_PERMANENT = "El cambio es permanente, y no se podrá revertir.";

    public static final String MSG_OPTION_DBL_CLICK = "Hacer doble click para elegir una opción";

    public static final String MSG_CNF_FIELD_VAL_ = "¿Está seguro(a) que el valor del campo ";
    public static final String MSG_CNF_FIELD_VAL_DIF = " sea distinto a ";
    public static final String MSG_CNF_FIELD_VAL_DIF_FIELD = " sea distinto al del campo ";
    public static final String MSG_CNF_FIELD_VAL_UNDEF = " no haya sido especificado?";
    public static final String MSG_CNF_PRT = "¿Desea imprimir el registro?";
    public static final String MSG_CNF_PROC = "¿Desea procesar el registro?";
    public static final String MSG_CNF_FILE_OPEN = "¿Desea abrir el archivo?";
    public static final String MSG_CNF_CONT = "¿Está seguro(a) que desea continuar?";
    public static final String MSG_CNF_CONT_OMIT_VAL = "¿Está seguro(a) que desea omitir la validación y continuar?";
    public static final String MSG_CNF_FORM_CLS = "¿Está seguro(a) que desea cerrar la forma de captura?";
    public static final String MSG_GUI_SELECT_OPTION = "Se debe seleccionar una opción.";
    public static final String MSG_GUI_TTT_PICK_DATE = "(F5 para elegir fecha)";
    public static final String MSG_GUI_TTT_PICK_OPTION = "(F5 para elegir opción)";

    public static final String ERR_MSG_FIELD_DIF = "Se debe especificar un valor distinto para el campo ";
    public static final String ERR_MSG_FIELD_REQ = "Se debe especificar un valor para el campo ";
    public static final String ERR_MSG_FIELD_REQ_NOT = "No se debe especificar un valor para el campo ";
    public static final String ERR_MSG_FIELD_REQ_EQUAL = "El valor de los siguientes campos debe ser igual: ";
    public static final String ERR_MSG_FIELD_VAL_ = "El valor del campo ";
    public static final String ERR_MSG_FIELD_VAL_EQUAL = " debe ser igual a ";
    public static final String ERR_MSG_FIELD_VAL_LESS = " debe ser menor a ";
    public static final String ERR_MSG_FIELD_VAL_LESS_EQUAL = " debe ser menor o igual a ";
    public static final String ERR_MSG_FIELD_VAL_GREAT = " debe ser mayor a ";
    public static final String ERR_MSG_FIELD_VAL_GREAT_EQUAL = " debe ser mayor o igual a ";
    public static final String ERR_MSG_FIELD_DATE_ = "La fecha del campo ";
    public static final String ERR_MSG_FIELD_DATE_EQUAL = " debe ser igual a ";
    public static final String ERR_MSG_FIELD_DATE_LESS = " debe ser anterior a ";
    public static final String ERR_MSG_FIELD_DATE_LESS_EQUAL = " debe ser anterior o igual a ";
    public static final String ERR_MSG_FIELD_DATE_GREAT = " debe ser posterior a ";
    public static final String ERR_MSG_FIELD_DATE_GREAT_EQUAL = " debe ser posterior o igual a ";
    public static final String ERR_MSG_FIELD_DATE_YEAR = " debe pertenecer al ejercicio ";
    public static final String ERR_MSG_FIELD_DATE_YEAR_SAME = " debe pertenecer al mismo ejercicio.";
    public static final String ERR_MSG_FORM_EXIST_REG = "La forma de captura sólo es para registros existentes.";
    public static final String ERR_MSG_UNDEF_REG = "Aún no se ha especificado un registro.";
    public static final String ERR_MSG_UNDEF_OPTION = "Aún no se ha especificado una opción.";
}
