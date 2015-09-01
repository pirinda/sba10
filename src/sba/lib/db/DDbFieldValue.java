/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.db;

/**
 *
 * @author Sergio Flores
 */
public class DDbFieldValue {

    protected Object moValue;
    private int mnFkUserId;

    public DDbFieldValue(Object value, int userId) {
        moValue = value;
        mnFkUserId = userId;
    }

    public void setValue(Object Value) {
        this.moValue = Value;
    }

    public void setFkUserId(int FkUserId) {
        this.mnFkUserId = FkUserId;
    }

    public Object getValue() {
        return moValue;
    }

    public int getFkUserId() {
        return mnFkUserId;
    }
}
