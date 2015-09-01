/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import sba.lib.DLibConsts;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiField;
import sba.lib.gui.DGuiFieldBoolean;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldBoolean extends JCheckBox implements DGuiFieldBoolean {

    protected String msFieldName;
    protected boolean mbDefaultValue;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected int mnTab;

    public DBeanFieldBoolean() {
        msFieldName = "";
        mbDefaultValue = false;
        moNextField = null;
        moNextButton = null;
        moFormButton = null;
        mnTab = -1;

        setPreferredSize(new Dimension(100, 23));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                processKeyPressed(evt);
            }
        });

        resetField();
    }

    /*
     * Class private methods:
     */

    private void processKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (moNextButton != null && moNextButton.isEnabled()) {
                moNextButton.requestFocus();
            }
            else if (moNextField != null) {
                moNextField.processFocus();
            }
            else if (moFormButton != null && moFormButton.isEnabled()) {
                moFormButton.requestFocus();
            }
        }
    }

    /*
     * Class public methods:
     */

    /*
     * Implemented and overrided methods:
     */

    @Override
    public void setFieldName(final String name) {
        msFieldName = name;
    }

    @Override
    public int getDataType() {
        return DLibConsts.DATA_TYPE_BOOL;
    }

    @Override
    public int getGuiType() {
        return DGuiConsts.GUI_TYPE_BOOL;
    }

    @Override
    public String getFieldName() {
        return msFieldName;
    }

    @Override
    public JCheckBox getComponent() {
        return this;
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public void setValue(final Object value) {
        setSelected((Boolean) value);
    }

    @Override
    public void setDefaultValue(final Object value) {
        mbDefaultValue = (Boolean) value;
    }

    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setEditable(final boolean editable) {
        super.setEnabled(editable);
    }

    @Override
    public void setNextField(final DGuiField field) {
        moNextField = field;
    }

    @Override
    public void setNextButton(final JButton button) {
        moNextButton = button;
    }

    @Override
    public void setFormButton(final JButton button) {
        moFormButton = button;
    }

    @Override
    public void setTab(int tab) {
        mnTab = tab;
    }

    @Override
    public int getTab() {
        return mnTab;
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public boolean isEditable() {
        return super.isEnabled();
    }

    @Override
    public boolean isFocusable() {
        return super.isEnabled() && super.isFocusable();
    }

    @Override
    public DGuiField getNextField() {
        return moNextField;
    }

    @Override
    public JButton getNextButton() {
        return moNextButton;
    }

    @Override
    public JButton getFormButton() {
        return moFormButton;
    }

    @Override
    public void processFocus() {
        if (isFocusable()) {
            requestFocus();
        }
        else {
            processKeyPressed(new KeyEvent(this, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED));
        }
    }

    @Override
    public void resetField() {
        setValue(mbDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        DGuiValidation validation = new DGuiValidation();

        return validation;
    }

    /*
     * Implementation of DGuiFieldBoolean:
     */

    @Override
    public Boolean getValue() {
        return isSelected();
    }

    @Override
    public Boolean getDefaultValue() {
        return mbDefaultValue;
    }

    @Override
    public void setBooleanSettings(final String name, final boolean defaultValue) {
        setFieldName(name);
        setDefaultValue(defaultValue);
    }
}
