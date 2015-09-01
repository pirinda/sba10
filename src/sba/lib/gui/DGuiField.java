/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author Sergio Flores
 */
public abstract interface DGuiField {

    public void setFieldName(final String name);

    public int getDataType();
    public int getGuiType();
    public String getFieldName();
    public JComponent getComponent();
    public boolean isMandatory();

    public void setValue(final Object value);
    public void setDefaultValue(final Object value);

    public Object getValue();
    public Object getDefaultValue();

    public void setEnabled(final boolean enabled);
    public void setEditable(final boolean editable);
    public void setNextField(final DGuiField field);
    public void setNextButton(final JButton button);
    public void setFormButton(final JButton button);
    public void setTab(int tab);

    public boolean isEnabled();
    public boolean isEditable();
    public boolean isFocusable();
    public DGuiField getNextField();
    public JButton getNextButton();
    public JButton getFormButton();
    public int getTab();

    public void processFocus();
    public void resetField();
    public DGuiValidation validateField();
}
