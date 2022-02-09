/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.db;

/**
 *
 * @author Sergio Flores
 */
public abstract class DDbConsts {

    public static final int DBMS_MYSQL = 1;
    public static final int DBMS_SQL_SERVER_2000 = 11;
    public static final int DBMS_SQL_SERVER_2005 = 12;

    public static final int CONNECTION_OK = 11;
    public static final int CONNECTION_ERROR = 12;

    public static final int READ_OK = 21;
    public static final int READ_ERROR = 22;

    public static final int SAVE_OK = 31;
    public static final int SAVE_ERROR = 32;

    public static final int MODE_VERBOSE = 1;
    public static final int MODE_STEALTH = 2;

    public static final int ACTION_READ = 1;
    public static final int ACTION_SAVE = 2;
    public static final int ACTION_DELETE = 3;
    public static final int ACTION_ANNUL = 4;
    public static final int ACTION_STAMP = 9;

    public static final String FIELD_ID = "f_id_";
    public static final String FIELD_FK = "f_fk_";
    public static final String FIELD_TYPE_ID = "f_id_type_";
    public static final String FIELD_TYPE = "f_type";
    public static final String FIELD_CODE = "f_code";
    public static final String FIELD_NAME = "f_name";
    public static final String FIELD_DATE = "f_date";
    public static final String FIELD_VALUE = "f_value"; // e.g. read field
    public static final String FIELD_ITEM = "f_item";   // e.g. read item for DGuiItem
    public static final String FIELD_COMP = "f_comp";   // e.g. read complement for DGuiItem
    public static final String FIELD_PICK = "f_pick_";  // e.g. read n fields for option pickers
    public static final String FIELD_CAN_UPD = "b_can_upd";
    public static final String FIELD_CAN_DIS = "b_can_dis";
    public static final String FIELD_CAN_DEL = "b_can_del";
    public static final String FIELD_IS_AUD = "b_aud";
    public static final String FIELD_IS_AVL = "b_avl";
    public static final String FIELD_IS_DIS = "b_dis";
    public static final String FIELD_IS_DEL = "b_del";
    public static final String FIELD_IS_SYS = "b_sys";
    public static final String FIELD_USER_USR_ID = "fk_usr";
    public static final String FIELD_USER_INS_ID = "fk_usr_ins";
    public static final String FIELD_USER_UPD_ID = "fk_usr_upd";
    public static final String FIELD_USER_AUD_ID = "fk_usr_aud";
    public static final String FIELD_USER_USR_TS = "ts_usr";
    public static final String FIELD_USER_INS_TS = "ts_usr_ins";
    public static final String FIELD_USER_UPD_TS = "ts_usr_upd";
    public static final String FIELD_USER_AUD_TS = "ts_usr_aud";
    public static final String FIELD_USER_USR_NAME = "f_usr";
    public static final String FIELD_USER_INS_NAME = "f_usr_ins";
    public static final String FIELD_USER_UPD_NAME = "f_usr_upd";
    public static final String FIELD_USER_AUD_NAME = "f_usr_aud";

    public static final String MSG_REG_ = "El registro '";
    public static final String MSG_REG_IS_AUDITED = "' está auditado y no se puede alterar.";
    public static final String MSG_REG_IS_DISABLED = "' está inhabilitado y no se puede alterar.";
    public static final String MSG_REG_IS_DELETED = "' está eliminado y no se puede alterar.";
    public static final String MSG_REG_IS_SYSTEM = "' es un registro de sistema y no se puede alterar.";
    public static final String MSG_REG_NON_UPDATABLE = "' es un registro que no se puede modificar.";
    public static final String MSG_REG_NON_DISABLEABLE = "' es un registro que no se puede inhabilitar.";
    public static final String MSG_REG_NON_DELETABLE = "' es un registro que no se puede eliminar.";
    public static final String MSG_REG_DENIED_UPDATE = "El registro no se puede modificar. La acción ha sido denegada.";
    public static final String MSG_REG_DENIED_DISABLE = "El registro no se puede inhabilitar. La acción ha sido denegada.";
    public static final String MSG_REG_DENIED_DELETE = "El registro no se puede eliminar. La acción ha sido denegada.";

    public static final String ERR_MSG_REG_NOT_FOUND = "El registro no fue encontrado.";
    public static final String ERR_MSG_REG_IS_SYSTEM = "El registro es de sistema.";
    public static final String ERR_MSG_REG_NON_UPDATABLE = "El registro no es modificable.";
    public static final String ERR_MSG_REG_NON_DISABLEABLE = "El registro no es inhabilitable.";
    public static final String ERR_MSG_REG_NON_DELETABLE = "El registro no es eliminable.";
    public static final String ERR_MSG_REG_ALLREADY_EXISTS = "El registro ya existe.";
    public static final String ERR_MSG_UNIQUE_CODE = "Ya existen otros registros con el mismo código.";
    public static final String ERR_MSG_UNIQUE_NAME = "Ya existen otros registros con el mismo nombre.";
    public static final String ERR_MSG_UNIQUE_FIELD = "Ya existen otros registros con el mismo valor para el campo: ";
    public static final String ERR_MSG_DB_CLOSED = "La conexión a la base de datos está cerrada.";
    public static final String ERR_MSG_DB_CONNECTION = "No se pudo establecer una conexión a la base de datos.";
}
