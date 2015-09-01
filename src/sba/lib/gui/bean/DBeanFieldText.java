/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import sba.lib.DLibConsts;
import sba.lib.DLibUtils;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiField;
import sba.lib.gui.DGuiFieldText;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldText extends JTextField implements DGuiFieldText {

    public static final int MAX_LENGTH = 256;

    protected String msFieldName;
    protected String msDefaultValue;
    protected int mnMinLength;
    protected int mnMaxLength;
    protected int mnTextCaseType;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected JButton moFieldButton;
    protected int mnTab;

    public DBeanFieldText() {
        msFieldName = "";
        msDefaultValue = "";
        mnMinLength = 1;
        mnMaxLength = MAX_LENGTH;
        mnTextCaseType = DGuiConsts.TEXT_CASE_UPPER;
        moNextField = null;
        moNextButton = null;
        moFormButton = null;
        moFieldButton = null;
        mnTab = -1;

        setPreferredSize(new Dimension(100, 23));

        addActionListener(new java.awt.event.ActionListener() {
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

            @Override
            public void keyReleased(KeyEvent evt) {
                processKeyReleased(evt);
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

        resetField();
    }

    /*
     * Class private methods:
     */

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

    private void processKeyReleased(KeyEvent evt) {
        if (getText().length() > mnMaxLength) {
            int pos = getCaretPosition();
            setText(getText().substring(0, mnMaxLength));
            setCaretPosition(pos < mnMaxLength ? pos : mnMaxLength);
        }
    }

    private void processFocusGained(FocusEvent evt) {
        selectAll();
    }

    private void processFocusLost(FocusEvent evt) {
        String text = DLibUtils.textTrim(getText());

        switch (mnTextCaseType) {
            case DGuiConsts.TEXT_CASE_UPPER:
                setText(text.toUpperCase());
                break;
            case DGuiConsts.TEXT_CASE_LOWER:
                setText(text.toLowerCase());
                break;
            default:
        }
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
        return DLibConsts.DATA_TYPE_TEXT;
    }

    @Override
    public int getGuiType() {
        return DGuiConsts.GUI_TYPE_TEXT;
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
        return mnMinLength > 0;
    }

    @Override
    public void setValue(final Object value) {
        setText((String) value);
        setCaretPosition(0);
    }

    @Override
    public void setDefaultValue(final Object value) {
        msDefaultValue = (String) value;
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
        setValue(msDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        String text = "";
        DGuiValidation validation = new DGuiValidation();

        processFocusLost(null);

        text = getText();

        if (text.length() < mnMinLength) {
            validation.setMessage("La longitud del campo '" + msFieldName + "' no puede ser menor que " + mnMinLength + ".");
        }
        else if (text.length() > mnMaxLength) {
            validation.setMessage("La longitud del campo '" + msFieldName + "' no puede ser mayor que " + mnMaxLength + ".");
        }

        if (!validation.isValid()) {
            validation.setComponent(this);
            validation.setTab(mnTab);
        }

        return validation;
    }

    /*
     * Implementation of DGuiFieldText
     */

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public String getDefaultValue() {
        return msDefaultValue;
    }

    @Override
    public void setTextSettings(final String name, final int max) {
        setFieldName(name);
        setMaxLength(max);
    }

    @Override
    public void setTextSettings(final String name, final int max, final int min) {
        setFieldName(name);
        setMaxLength(max);
        setMinLength(min);
    }

    @Override
    public void setMinLength(final int min) {
        mnMinLength = min;
    }

    @Override
    public void setMaxLength(final int max) {
        mnMaxLength = max;
    }

    @Override
    public void setTextCaseType(final int type) {
        mnTextCaseType = type;
    }

    @Override
    public int getMinLength() {
        return mnMinLength;
    }

    @Override
    public int getMaxLength() {
        return mnMaxLength;
    }

    @Override
    public int getTextCaseType() {
        return mnTextCaseType;
    }
}
