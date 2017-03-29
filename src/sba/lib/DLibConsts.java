/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib;

/**
 *
 * @author Sergio Flores
 */
public abstract class DLibConsts {

    public static final int UNDEFINED = 0;

    public static final int DATA_TYPE_INT = 1;
    public static final int DATA_TYPE_DEC = 2;
    public static final int DATA_TYPE_BOOL = 3;
    public static final int DATA_TYPE_TEXT = 4;
    public static final int DATA_TYPE_DATE = 5;
    public static final int DATA_TYPE_KEY = 6;

    public static final int LEN_NUM = 6;
    public static final int LEN_REF_NUM = 9;

    public static final String LAN_ISO639_EN = "en";    // english
    public static final String LAN_ISO639_ES = "es";    // español

    public static final String MSG_IN = "en";   // preposition
    public static final String MSG_PROCESS_FINISHED = "El proceso ha finalizado.";

    public static final String ERR_MSG_UNKNOWN = "Desconocido(a)";
    public static final String ERR_MSG_OPTION_UNKNOWN = "Opción desconocida.";
    public static final String ERR_MSG_WRONG_TYPE = "Tipo de dato incompatible.";
    public static final String ERR_MSG_ARGS_MANY = "Demasiados argumentos.";
    public static final String ERR_MSG_RPN_ARGS_FEW = "Insuficientes argumentos para RPN.";
    public static final String ERR_MSG_RPN_ARGS_MANY = "Demasiados argumentos para RPN.";
    
    public static final String ERR_MSG_UTILS_KEY_EXISTS = "¡La clave ya existe!";
    public static final String ERR_MSG_UTILS_QTY_INVALID = "¡La cantidad es inválida!";
}
