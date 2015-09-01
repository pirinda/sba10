/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import sba.lib.db.DDbRegistry;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiForm {

    public int getBeanFormType();
    public int getFormType();
    public int getFormSubtype();
    public int getFormStatus();
    public int getFormResult();
    public boolean canShowForm();

    public void setFormSettings(final DGuiClient client, final int beanFormType, final int formType, final int formSubtype, final String title);
    public void setFormVisible(final boolean visible);
    public void setFormEditable(final boolean editable);
    public void updateFormControlStatus();

    public void addAllListeners();
    public void removeAllListeners();
    public void reloadCatalogues();

    public void setRegistry(final DDbRegistry registry) throws Exception;
    public DDbRegistry getRegistry() throws Exception;
    public DGuiValidation validateForm();

    public boolean isFormDataEdited();

    public void setValue(final int type, final Object value);
    public Object getValue(final int type);
    public DGuiFields getFields();

    public void actionEdit();
    public void actionReadInfo();
    public void actionSave();
    public void actionCancel();
}
