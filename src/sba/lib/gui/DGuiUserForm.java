/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public class DGuiUserForm {

    protected int mnUserId;
    protected int mnFormType;
    protected int mnFormSubtype;

    public DGuiUserForm(int userId, int formType, int formSubtype) {
        mnUserId = userId;
        mnFormType = formType;
        mnFormSubtype = formSubtype;
    }

    public void setUserId(int n) {
        mnUserId = n;
    }

    public void setFormType(int n) {
        mnFormType = n;
    }

    public void setFormSubtype(int n) {
        mnFormSubtype = n;
    }

    public int getUserId() {
        return mnUserId;
    }

    public int getFormType() {
        return mnFormType;
    }

    public int getFormSubtype() {
        return mnFormSubtype;
    }

    @Override
    public int hashCode() {
        return mnFormType + (mnFormSubtype * 1000000) + (mnUserId * 100000000);
    }
}
