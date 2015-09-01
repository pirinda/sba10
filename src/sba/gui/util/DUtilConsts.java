/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.gui.util;

import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public abstract class DUtilConsts {

    public static final int BPR_CO_ID = 1;
    public static final int BPR_BRA_ID = 1;
    public static final int BRA_ADD_ID = 1;
    public static final int BRA_BNK_ID = 1;
    public static final int BRA_CSH_ID = 1;
    public static final int BRA_WAH_ID = 1;
    public static final int LOT_ID = 1;

    public static final int USR_NA_ID = 1;
    public static final int USR_ADM_ID = 2;
    public static final int USR_SUP_ID = 3;

    public static final int EMT = 1;
    public static final int EMT_PEND = 2;

    public static final int PAY = 1;
    public static final int PAY_PEND = 2;

    public static final int REC = 1;
    public static final int REC_PEND = 2;

    public static final int PROC = 1;
    public static final int PROC_PEND = 2;

    public static final int SUPP = 1;
    public static final int SUPP_PEND = 2;

    public static final int BAL = 1;
    public static final int BAL_CY = 2;

    public static final int AMT = 1;
    public static final int AMT_CY = 2;

    public static final int QRY_SUM = 1;    // query as summary
    public static final int QRY_DET = 2;    // query as detail

    public static final int PRC_Y = 101;    // prices? yes!
    public static final int PRC_N = 102;    // prices? no!

    public static final int PER_CUR = 1;
    public static final int PER_ENT_CSH = 2;
    public static final int PER_ENT_WAH = 3;
    public static final int PER_BPR = 4;
    public static final int PER_BPR_BRA = 5;
    public static final int PER_ITM = 6;
    public static final int PER_DOC = 7;
    public static final int PER_REF = 8;
    public static final int PER_LOT = 9;
    public static final int PER_SNR = 10;
    public static final int PER_IMP_DEC = 11;
    public static final int PER_FIND_CODE = 21;
    public static final int PER_FIND_NAME = 22;
    public static final int PER_FIND_EXTRA = 23;

    public static final int NUM_SNG = 1;
    public static final int NUM_PLR = 2;

    public static final int LEV_READ = 1;
    public static final int LEV_CAPTURE = 2;
    public static final int LEV_AUTHOR = 3;
    public static final int LEV_EDITOR = 4;
    public static final int LEV_MANAGER = 5;

    public static final int DECS_AMT = DLibUtils.getDecimalFormatAmount().getMaximumFractionDigits();

    public static final String FILE_NAME_CFG = "sba.xml";
    public static final String ALL = "(TODOS)";
    public static final String NON_APPLYING = "(N/A)";
    public static final String OPEN_BALANCE = "(SALDO INICIAL)";
    public static final String PAY_ADVANCE = "(ANTICIPO)";
    public static final String HEADQUARTERS_BRA = "MATRIZ";
    public static final String HEADQUARTERS_ADD = "OFICIAL";
    public static final String ACTION_KEY = "[F9]";

    public static final String TXT_FISCAL_ID = "RFC";
    public static final String TXT_FISCAL_YEAR = "Ejercicio";
    public static final String TXT_CURRENCY = "Moneda";
    public static final String TXT_MONEY_IN = "Ingreso";
    public static final String TXT_MONEY_OUT = "Egreso";
    public static final String TXT_PAY_IN = "Cobro";
    public static final String TXT_PAY_OUT = "Pago";
    public static final String TXT_AMOUNT = "Monto";
    public static final String TXT_TRANSF = "Traspaso";
    public static final String TXT_MIN = "Mínimo";
    public static final String TXT_MAX = "Máximo";
    public static final String TXT_DOC = "Documento";
    public static final String TXT_SAVE = "Guardar";
    public static final String TXT_SAVE_MOVE = "Guardar y avanzar";
    public static final String TXT_CLEAR = "Limpiar";
    public static final String TXT_CREATE = "Crear";
    public static final String TXT_FILTER = "Filtrar";
    public static final String TXT_PROCESS = "Procesar";
    public static final String TXT_FIND = "Buscar";
    public static final String TXT_SELECT = "Seleccionar";
    public static final String TXT_PRINT = "Imprimir";
    public static final String TXT_SIGN = "Timbrar";
    public static final String TXT_SIGN_VER = "Verificar timbrado";
    public static final String TXT_CANCEL = "Cancelar";
    public static final String TXT_CANCEL_VER = "Verificar cancelación";
    public static final String TXT_SEND = "Enviar";
    public static final String TXT_EXPORT = "Exportar";
    public static final String TXT_IMPORT = "Importar";
    public static final String TXT_COMPANY = "Empresa";
    public static final String TXT_BRANCH = "Sucursal";
    public static final String TXT_BRANCH_CSH = "Cuenta de dinero";
    public static final String TXT_BRANCH_CSH_PLR = "Cuentas de dinero";
    public static final String TXT_BRANCH_WAH = "Almacén de bienes";
    public static final String TXT_BRANCH_WAH_PLR = "Almacenes de bienes";
    public static final String TXT_BANK = "Cuenta bancaria";
    public static final String TXT_BANK_PLR = "Cuentas bancarias";
    public static final String TXT_ITEM = "Ítem";
    public static final String TXT_ITEM_EXP = "Ítem gasto/producto";
    public static final String TXT_UNIT = "Unidad";
    public static final String TXT_LOT = "Lote";
    public static final String TXT_LOG = "Bitácora";
    public static final String TXT_TP = "Tipo";
    public static final String TXT_ST = "Status";

    public static final String TTT_DOC_ST_PREV = "Enviar el documento al estado anterior";
    public static final String TTT_DOC_ST_NEXT = "Enviar el documento al estado siguiente";
    
    public static final String FILE_EXT_PDF = "pdf";
    public static final String FILE_EXT_XML = "xml";

    public static final String ERR_MSG_SYS_DATE = "No fue posible obtener la fecha del sistema.";
    public static final String ERR_MSG_ACC_MOV = "El registro tiene movimientos contables.";
    public static final String ERR_MSG_USR_SES_BRA = "No se ha definido la sucursal actual en la sesión del usuario actual.";
    public static final String ERR_MSG_USR_SES_BRA_CSH = "No se ha definido la cuenta de dinero actual en la sesión del usuario actual.";
    public static final String ERR_MSG_USR_SES_BRA_WAH = "No se ha definido el almacén de bienes actual en la sesión del usuario actual.";
    public static final String ERR_MSG_USR_SES_BRA_DPS_SER = "No se ha definido la serie de documentos actual en la sesión del usuario actual.";
    public static final String ERR_MSG_DPS_SER_NOT_ASIGNED = "La serie de documentos del documento no se ha asignado para el usuario actual.";
    public static final String ERR_MSG_DPS_SER_NON_AVA = "No se han asignado series de documentos para el usuario actual para el tipo de documento seleccionado.";
    public static final String ERR_MSG_DPS_SER_NON_DEF = "No se ha seleccionado una serie de documentos para el nuevo documento.";
    public static final String ERR_MSG_DPS_SER_MUL_AVA = "Se han asignado múltiples series de documentos para el usuario actual para el tipo de documento seleccionado.";
    public static final String ERR_MSG_DPS_SER_NUM_NON_AVA = "No se han asignado folios para la serie de documentos del nuevo documento.";
    public static final String ERR_MSG_DPS_SER_NUM_MUL_AVA = "Se han asignado múltiples folios para la serie de documentos del nuevo documento.";
    public static final String ERR_MSG_DPS_SER_NUM_MIN = "El folio es menor al rango de folios para la serie de documentos del documento.";
    public static final String ERR_MSG_DPS_SER_NUM_MAX = "El folio es mayor al rango de folios para la serie de documentos del documento.";
    public static final String ERR_MSG_DOC_NO_ROWS = "Se deben capturar partidas para el documento.";
    public static final String ERR_MSG_DOC_PER_CLO = "El período de la fecha del documento está cerrado.";
}
