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
import sba.lib.gui.DGuiFieldDecimal;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldDecimal extends JTextField implements DGuiFieldDecimal {

    protected String msFieldName;
    protected int mnGuiType;
    protected DecimalFormat moDecimalFormat;
    protected double mdDefaultValue;
    protected double mdMinDouble;
    protected double mdMaxDouble;
    protected boolean mbMandatory;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected JButton moFieldButton;
    protected int mnTab;

    public DBeanFieldDecimal() {
        msFieldName = "";
        mnGuiType = DLibConsts.UNDEFINED;
        moDecimalFormat = null;
        mdDefaultValue = 0;
        mdMinDouble = 0;
        mdMaxDouble = Double.MAX_VALUE;
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
        mnGuiType = DGuiConsts.GUI_TYPE_DEC;
        moDecimalFormat = DLibUtils.getDecimalFormat();
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
        if (DLibUtils.parseDouble(getText()) == 0) {
            setText("");
        }
        else {
            selectAll();
        }
    }

    private void processFocusLost(FocusEvent evt) {
        setText(moDecimalFormat.format(DLibUtils.parseDouble(getText()) / moDecimalFormat.getMultiplier()));
    }

    /*
     * Class public methods:
     */

    public boolean isPercentage() {
        return mnGuiType == DGuiConsts.GUI_TYPE_DEC_PER || mnGuiType == DGuiConsts.GUI_TYPE_DEC_PER_DISC || mnGuiType == DGuiConsts.GUI_TYPE_DEC_PER_TAX;
    }

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
        return DLibConsts.DATA_TYPE_DEC;
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
        setText(moDecimalFormat.format(DLibUtils.round((Double) value, moDecimalFormat.getMaximumFractionDigits() + (int) Math.log10(moDecimalFormat.getMultiplier()))));
        setCaretPosition(0);
    }

    @Override
    public void setDefaultValue(final Object value) {
        mdDefaultValue = (Double) value;
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
        setValue(mdDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        double d = 0;
        DGuiValidation validation = new DGuiValidation();

        processFocusLost(null);

        d = getValue();

        if (mbMandatory && d == 0) {
            validation.setMessage("Se debe especificar un valor decimal para el campo '" + msFieldName + "'.");
        }
        else if (d < mdMinDouble) {
            validation.setMessage("El valor del campo '" + msFieldName + "' no puede ser menor que " + moDecimalFormat.format(mdMinDouble) + ".");
        }
        else if (d > mdMaxDouble) {
            validation.setMessage("El valor del campo '" + msFieldName + "' no puede ser mayor que " + moDecimalFormat.format(mdMaxDouble) + ".");
        }

        if (!validation.isValid()) {
            validation.setComponent(this);
            validation.setTab(mnTab);
        }

        return validation;
    }

    /*
     * Implementation of DGuiFieldDecimal:
     */

    @Override
    public Double getValue() {
        return DLibUtils.parseDouble(getText()) / moDecimalFormat.getMultiplier();
    }

    @Override
    public Double getDefaultValue() {
        return mdDefaultValue;
    }

    @Override
    public void setDecimalSettings(final String name, final int guiType, final boolean mandatory) {
        setFieldName(name);
        setGuiType(guiType);
        setMandatory(mandatory);
    }

    @Override
    public void setDecimalFormat(final DecimalFormat format) {
        moDecimalFormat = format;
    }

    @Override
    public void setGuiType(final int type) {
        mnGuiType = type;

        switch (type) {
            case DGuiConsts.GUI_TYPE_DEC:
                moDecimalFormat = DLibUtils.getDecimalFormat();
                break;
            case DGuiConsts.GUI_TYPE_DEC_AMT:
                moDecimalFormat = DLibUtils.getDecimalFormatAmount();
                break;
            case DGuiConsts.GUI_TYPE_DEC_AMT_UNIT:
                moDecimalFormat = DLibUtils.getDecimalFormatAmountUnitary();
                break;
            case DGuiConsts.GUI_TYPE_DEC_EXC_RATE:
                moDecimalFormat = DLibUtils.getDecimalFormatExchangeRate();
                break;
            case DGuiConsts.GUI_TYPE_DEC_QTY:
                moDecimalFormat = DLibUtils.getDecimalFormatQuantity();
                break;
            case DGuiConsts.GUI_TYPE_DEC_PER:
                moDecimalFormat = DLibUtils.getDecimalFormatPercentage();
                break;
            case DGuiConsts.GUI_TYPE_DEC_PER_TAX:
                moDecimalFormat = DLibUtils.getDecimalFormatPercentageTax();
                break;
            case DGuiConsts.GUI_TYPE_DEC_PER_DISC:
                moDecimalFormat = DLibUtils.getDecimalFormatPercentageDiscount();
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
    public void setMinDouble(final double min) {
        mdMinDouble = min;
    }

    @Override
    public void setMaxDouble(final double max) {
        mdMaxDouble = max;
    }

    @Override
    public double getMinDouble() {
        return mdMinDouble;
    }

    @Override
    public double getMaxDouble() {
        return mdMaxDouble;
    }
}
