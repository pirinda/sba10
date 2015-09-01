/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.db;

import java.sql.SQLException;
import sba.lib.gui.DGuiSession;

/**
 *
 * @author Sergio Flores
 */
public abstract class DDbRegistrySysFly extends DDbRegistrySys {

    public DDbRegistrySysFly(int type) {
        super(type);
    }

    @Override
    public void setPrimaryKey(int[] pk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[] getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public abstract String getSqlTable();

    @Override
    public String getSqlWhere() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public abstract String getSqlWhere(int[] pk);

    @Override
    public void computePrimaryKey(DGuiSession session) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void read(DGuiSession session, int[] pk) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(DGuiSession session) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DDbRegistry clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
