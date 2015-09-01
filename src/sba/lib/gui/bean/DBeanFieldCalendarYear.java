/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import sba.lib.DLibConsts;
import sba.lib.DLibTimeConsts;
import sba.lib.DLibUtils;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiField;
import sba.lib.gui.DGuiFieldCalendar;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldCalendarYear extends JSpinner implements DGuiFieldCalendar {

    protected String msFieldName;
    protected int mnDefaultValue;
    protected int mnMinInteger;
    protected int mnMaxInteger;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected int mnTab;

    public DBeanFieldCalendarYear() {
        msFieldName = "";
        mnDefaultValue = DLibTimeConsts.YEAR_MIN;
        mnMinInteger = DLibTimeConsts.YEAR_MIN;
        mnMaxInteger = DLibTimeConsts.YEAR_MAX;
        moNextField = null;
        moNextButton = null;
        moFormButton = null;
        mnTab = -1;

        setModel(new SpinnerNumberModel(mnDefaultValue, mnMinInteger, mnMaxInteger, 1));
        setEditor(new JSpinner.NumberEditor(this, DLibUtils.DecimalFormatCalendarYear.toPattern()));

        setPreferredSize(new Dimension(75, 23));

        ((JSpinner.DefaultEditor) getEditor()).getTextField().addKeyListener(new KeyAdapter() {
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
        return DLibConsts.DATA_TYPE_INT;
    }

    @Override
    public int getGuiType() {
        return DGuiConsts.GUI_TYPE_INT_CAL_YEAR;
    }

    @Override
    public String getFieldName() {
        return msFieldName;
    }

    @Override
    public JSpinner getComponent() {
        return this;
    }

    @Override
    public boolean isMandatory() {
        return true;
    }

    @Override
    public void setValue(Object value) {
        super.setValue((Integer) value);
    }

    @Override
    public void setDefaultValue(Object value) {
        mnDefaultValue = (Integer) value;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setEditable(boolean editable) {
        super.setEnabled(editable);
    }

    @Override
    public void setNextField(DGuiField field) {
        moNextField = field;
    }

    @Override
    public void setNextButton(final JButton button) {
        moNextButton = button;
    }

    @Override
    public void setFormButton(JButton button) {
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
            ((JSpinner.DefaultEditor) getEditor()).getTextField().requestFocus();
        }
        else {
            processKeyPressed(new KeyEvent(this, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED));
        }
    }

    @Override
    public void resetField() {
        setValue(mnDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        int n = getValue();
        DGuiValidation validation = new DGuiValidation();

        if (n == 0) {
            validation.setMessage("Se debe especificar un año para el campo '" + msFieldName + "'.");
            validation.setComponent(this);
            validation.setTab(mnTab);
        }

        return validation;
    }

    /*
     * Implementation of DGuiFieldCalendar:
     */

    @Override
    public Integer getValue() {
        return (Integer) super.getValue();
    }

    @Override
    public Integer getDefaultValue() {
        return mnDefaultValue;
    }

    @Override
    public void setCalendarSettings(final String name) {
        msFieldName = name;
    }
}
