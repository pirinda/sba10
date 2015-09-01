/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JTextField;
import sba.lib.DLibConsts;
import sba.lib.DLibUtils;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiField;
import sba.lib.gui.DGuiFieldInteger;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldInteger extends JTextField implements DGuiFieldInteger {

    protected String msFieldName;
    protected int mnGuiType;
    protected DecimalFormat moDecimalFormat;
    protected int mnDefaultValue;
    protected int mnMinInteger;
    protected int mnMaxInteger;
    protected boolean mbMandatory;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected JButton moFieldButton;
    protected int mnTab;

    public DBeanFieldInteger() {
        msFieldName = "";
        mnGuiType = DLibConsts.UNDEFINED;
        moDecimalFormat = null;
        mnDefaultValue = 0;
        mnMinInteger = 0;
        mnMaxInteger = Integer.MAX_VALUE;
        mbMandatory = true;
        moNextField = null;
        moNextButton = null;
        moFormButton = null;
        moFieldButton = null;
        mnTab = -1;

        setPreferredSize(new Dimension(100, 23));
        setHorizontalAlignment(JTextField.TRAILING);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                processKeyPressed(evt);
            }
        });

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                processFocusGained(evt);
            }
            @Override
            public void focusLost(FocusEvent evt) {
                processFocusLost(evt);
            }
        });

        resetGuiType();
        resetField();
    }

    /*
     * Class private methods:
     */

    private void resetGuiType() {
        mnGuiType = DGuiConsts.GUI_TYPE_INT;
        moDecimalFormat = DLibUtils.DecimalFormatInteger;
    }

    private void processActionPerformed(ActionEvent evt) {
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

    private void processKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (moFieldButton != null && moFieldButton.isEnabled()) {
                moFieldButton.doClick();
            }
        }
    }

    private void processFocusGained(FocusEvent evt) {
        if (DLibUtils.parseInt(getText()) == 0) {
            setText("");
        }
        else {
            selectAll();
        }
    }

    private void processFocusLost(FocusEvent evt) {
        setText(moDecimalFormat.format(DLibUtils.parseInt(getText())));
    }

    /*
     * Class public methods:
     */

    public void setFieldButton(final JButton button) {
        moFieldButton = button;
        setToolTipText(button == null ? null : DGuiConsts.MSG_GUI_TTT_PICK_OPTION);
    }

    public JButton getFieldButton() {
        return moFieldButton;
    }

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
        return mnGuiType;
    }

    @Override
    public String getFieldName() {
        return msFieldName;
    }

    @Override
    public JTextField getComponent() {
        return this;
    }

    @Override
    public boolean isMandatory() {
        return mbMandatory;
    }

    @Override
    public void setValue(final Object value) {
        setText(moDecimalFormat.format((Integer) value));
        setCaretPosition(0);
    }

    @Override
    public void setDefaultValue(final Object value) {
        mnDefaultValue = (Integer) value;
    }

    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setEditable(final boolean editable) {
        super.setEditable(editable);
        super.setFocusable(editable);
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
        return super.isEditable();
    }

    @Override
    public boolean isFocusable() {
        return super.isEnabled()&& super.isEditable() && super.isFocusable();
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
            processActionPerformed(null);
        }
    }

    @Override
    public void resetField() {
        setValue(mnDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        int n = 0;
        DGuiValidation validation = new DGuiValidation();

        processFocusLost(null);

        n = getValue();

        if (mbMandatory && n == 0) {
            validation.setMessage("Se debe especificar un valor entero para el campo '" + msFieldName + "'.");
        }
        else if (n < mnMinInteger) {
            validation.setMessage("El valor del campo '" + msFieldName + "' no puede ser menor que " + moDecimalFormat.format(mnMinInteger) + ".");
        }
        else if (n > mnMaxInteger) {
            validation.setMessage("El valor del campo '" + msFieldName + "' no puede ser mayor que " + moDecimalFormat.format(mnMaxInteger) + ".");
        }

        if (!validation.isValid()) {
            validation.setComponent(this);
            validation.setTab(mnTab);
        }

        return validation;
    }

    /*
     * Implementation of DGuiFieldInteger:
     */

    @Override
    public Integer getValue() {
        return DLibUtils.parseInt(getText());
    }

    @Override
    public Integer getDefaultValue() {
        return mnDefaultValue;
    }

    @Override
    public void setIntegerSettings(final String name, final int guiType, final boolean mandatory) {
        setFieldName(name);
        setGuiType(guiType);
        setMandatory(mandatory);
    }

    @Override
    public void setGuiType(final int type) {
        mnGuiType = type;

        switch (type) {
            case DGuiConsts.GUI_TYPE_INT:
                moDecimalFormat = DLibUtils.DecimalFormatInteger;
                break;
            case DGuiConsts.GUI_TYPE_INT_RAW:
                moDecimalFormat = DLibUtils.DecimalFormatIntegerRaw;
                break;
            case DGuiConsts.GUI_TYPE_INT_CAL_MONTH:
                moDecimalFormat = DLibUtils.DecimalFormatCalendarMonth;
                break;
            case DGuiConsts.GUI_TYPE_INT_CAL_YEAR:
                moDecimalFormat = DLibUtils.DecimalFormatCalendarYear;
                break;
            default:
                resetGuiType();
        }
    }

    @Override
    public void setMandatory(final boolean isMandatory) {
        mbMandatory = isMandatory;
    }

    @Override
    public void setMinInteger(final int min) {
        mnMinInteger = min;
    }

    @Override
    public void setMaxInteger(final int max) {
        mnMaxInteger = max;
    }

    @Override
    public int getMinInteger() {
        return mnMinInteger;
    }

    @Override
    public int getMaxInteger() {
        return mnMaxInteger;
    }
}
