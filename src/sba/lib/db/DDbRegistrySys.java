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
public abstract class DDbRegistrySys extends DDbRegistry {

    protected int mnSortingPos;
    protected boolean mbDeleted;
    protected int mnFkUserId;
    protected Date mtTsUser;

    public DDbRegistrySys(int type) {
        super(type);
        initBaseRegistry();
    }

    /*
     * Initialization methods:
     */

    @Override
    protected void initBaseRegistry() {
        super.initBaseRegistry();

        mnSortingPos = 0;
        mbDeleted = false;
        mnFkUserId = 0;
        mtTsUser = null;
    }

    /*
     * Setter/getter methods:
     */

    public void setSortingPos(int n) { mnSortingPos = n; }
    public void setDeleted(boolean b) { mbDeleted = b; }
    public void setFkUserId(int n) { mnFkUserId = n; }
    public void setTsUser(Date t) { mtTsUser = t; }

    public int getSortingPos() { return mnSortingPos; }
    public boolean isDeleted() { return mbDeleted; }
    public int getFkUserId() { return mnFkUserId; }
    public Date getTsUser() { return mtTsUser; }

    /*
     * Overriden methods:
     */

    @Override
    public boolean canDelete(final DGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        return true;
    }

    @Override
    public void delete(final DGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        mnQueryResultId = DDbConsts.SAVE_ERROR;

        mbDeleted = !mbDeleted;
        mnFkUserId = session.getUser().getPkUserId();

        msSql = "UPDATE " + getSqlTable() + " SET " +
                "b_del = " + (mbDeleted ? 1 : 0) + ", " +
                "fk_usr = " + mnFkUserId + ", " +
                "ts_usr = NOW() " +
                getSqlWhere();

        session.getStatement().execute(msSql);
        mnQueryResultId = DDbConsts.SAVE_OK;
    }
}
