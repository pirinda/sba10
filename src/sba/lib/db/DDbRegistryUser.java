/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.db;

import java.sql.SQLException;
import java.util.Date;
import sba.lib.gui.DGuiSession;

/**
 *
 * @author Sergio Flores
 */
public abstract class DDbRegistryUser extends DDbRegistry {

    protected boolean mbUpdatable;
    protected boolean mbDisableable;
    protected boolean mbDeletable;
    protected boolean mbDisabled;
    protected boolean mbDeleted;
    protected boolean mbSystem;
    protected int mnFkUserInsertId;
    protected int mnFkUserUpdateId;
    protected Date mtTsUserInsert;
    protected Date mtTsUserUpdate;

    public DDbRegistryUser(int type) {
        super(type);
        initBaseRegistry();
    }

    /*
     * Initialization methods:
     */

    @Override
    protected void initBaseRegistry() {
        super.initBaseRegistry();

        mbUpdatable = true;
        mbDisableable = true;
        mbDeletable = true;
        mbDisabled = false;
        mbDeleted = false;
        mbSystem = false;
        mnFkUserInsertId = 0;
        mnFkUserUpdateId = 0;
        mtTsUserInsert = null;
        mtTsUserUpdate = null;
    }

    /*
     * Setter/getter methods:
     */

    public void setUpdatable(boolean b) { mbUpdatable = b; }
    public void setDisableable(boolean b) { mbDisableable = b; }
    public void setDeletable(boolean b) { mbDeletable = b; }
    public void setDisabled(boolean b) { mbDisabled = b; }
    public void setDeleted(boolean b) { mbDeleted = b; }
    public void setSystem(boolean b) { mbSystem = b; }
    public void setFkUserInsertId(int n) { mnFkUserInsertId = n; }
    public void setFkUserUpdateId(int n) { mnFkUserUpdateId = n; }
    public void setTsUserInsert(Date t) { mtTsUserInsert = t; }
    public void setTsUserUpdate(Date t) { mtTsUserUpdate = t; }

    public boolean isUpdatable() { return mbUpdatable; }
    public boolean isDisableable() { return mbDisableable; }
    public boolean isDeletable() { return mbDeletable; }
    public boolean isDisabled() { return mbDisabled; }
    public boolean isDeleted() { return mbDeleted; }
    public boolean isSystem() { return mbSystem; }
    public int getFkUserInsertId() { return mnFkUserInsertId; }
    public int getFkUserUpdateId() { return mnFkUserUpdateId; }
    public Date getTsUserInsert() { return mtTsUserInsert; }
    public Date getTsUserUpdate() { return mtTsUserUpdate; }

    /*
     * Overriden methods:
     */

    @Override
    public boolean canSave(final DGuiSession session) throws SQLException, Exception {
        boolean can = true;

        initQueryMembers();

        if (mbSystem) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_IS_SYSTEM;
        }
        else if (!mbRegistryNew && !mbUpdatable) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_NON_UPDATABLE;
        }

        return can;
    }

    @Override
    public boolean canDisable(final DGuiSession session) throws SQLException, Exception {
        boolean can = true;

        initQueryMembers();

        if (mbSystem) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_IS_SYSTEM;
        }
        else if (!mbDisableable) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_NON_DISABLEABLE;
        }

        return can;
    }

    @Override
    public boolean canDelete(final DGuiSession session) throws SQLException, Exception {
        boolean can = true;

        initQueryMembers();

        if (mbSystem) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_IS_SYSTEM;
        }
        else if (!mbDeletable) {
            can = false;
            msQueryResult = DDbConsts.ERR_MSG_REG_NON_DELETABLE;
        }

        return can;
    }

    @Override
    public void disable(final DGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        mnQueryResultId = DDbConsts.SAVE_ERROR;

        mbDisabled = !mbDisabled;
        mnFkUserUpdateId = session.getUser().getPkUserId();

        msSql = "UPDATE " + getSqlTable() + " SET " +
                "b_dis = " + (mbDisabled ? 1 : 0) + ", " +
                "fk_usr_upd = " + mnFkUserUpdateId + ", " +
                "ts_usr_upd = NOW() " +
                getSqlWhere();

        session.getStatement().execute(msSql);
        mnQueryResultId = DDbConsts.SAVE_OK;
    }

    @Override
    public void delete(final DGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        mnQueryResultId = DDbConsts.SAVE_ERROR;

        mbDeleted = !mbDeleted;
        mnFkUserUpdateId = session.getUser().getPkUserId();

        msSql = "UPDATE " + getSqlTable() + " SET " +
                "b_del = " + (mbDeleted ? 1 : 0) + ", " +
                "fk_usr_upd = " + mnFkUserUpdateId + ", " +
                "ts_usr_upd = NOW() " +
                getSqlWhere();

        session.getStatement().execute(msSql);
        mnQueryResultId = DDbConsts.SAVE_OK;
    }
}
