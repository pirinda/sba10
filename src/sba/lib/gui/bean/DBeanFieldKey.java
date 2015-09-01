/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui.bean;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import sba.lib.DLibConsts;
import sba.lib.gui.DGuiClient;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiField;
import sba.lib.gui.DGuiFieldKey;
import sba.lib.gui.DGuiItem;
import sba.lib.gui.DGuiUtils;
import sba.lib.gui.DGuiValidation;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldKey extends JComboBox implements DGuiFieldKey {

    protected String msFieldName;
    protected int[] manDefaultValue;
    protected boolean mbMandatory;
    protected DGuiField moNextField;
    protected JButton moNextButton;
    protected JButton moFormButton;
    protected JButton moFieldButton;
    protected int mnTab;
    protected DGuiClient miClient;

    @SuppressWarnings("unchecked")
    public DBeanFieldKey() {
        msFieldName = "";
        manDefaultValue = null;
        mbMandatory = true;
        moNextField = null;
        moNextButton = null;
        moFormButton = null;
        moFieldButton = null;
        mnTab = -1;
        miClient = null;

        setPreferredSize(new Dimension(100, 23));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                processKeyPressed(evt);
            }
        });

        removeAllItems();
        addItem(new DGuiItem(""));

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
        else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (moFieldButton != null && moFieldButton.isEnabled()) {
                moFieldButton.doClick();
            }
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
        return DLibConsts.DATA_TYPE_KEY;
    }

    @Override
    public int getGuiType() {
        return DGuiConsts.GUI_TYPE_KEY;
    }

    @Override
    public String getFieldName() {
        return msFieldName;
    }

    @Override
    public JComboBox getComponent() {
        return this;
    }

    @Override
    public boolean isMandatory() {
        return mbMandatory;
    }

    @Override
    public void setValue(final Object value) {
        DGuiUtils.locateItem(this, (int[]) value);
    }

    @Override
    public void setDefaultValue(final Object value) {
        manDefaultValue = (int[]) value;
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
        return false;
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
            this.requestFocus();
        }
        else {
            processKeyPressed(new KeyEvent(this, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED));
        }
    }

    @Override
    public void resetField() {
        setValue(manDefaultValue);
    }

    @Override
    public DGuiValidation validateField() {
        DGuiValidation validation = new DGuiValidation();

        if (mbMandatory && this.getSelectedIndex() <= 0) {
            validation.setMessage("Se debe especificar un valor para el campo '" + msFieldName + "'.");
            validation.setComponent(this);
            validation.setTab(mnTab);
        }

        return validation;
    }

    /*
     * Implementation of DGuiFieldKey:
     */

    @Override
    public int[] getValue() {
        return ((DGuiItem) this.getSelectedItem()).getPrimaryKey();
    }

    @Override
    public int[] getDefaultValue() {
        return manDefaultValue;
    }

    @Override
    public void setKeySettings(final DGuiClient client, final String name, final boolean mandatory) {
        miClient = client;
        setFieldName(name);
        setMandatory(mandatory);
    }

    @Override
    public void setMandatory(final boolean isMandatory) {
        mbMandatory = isMandatory;
    }

    @Override
    public DGuiItem getSelectedItem() {
        Object item = super.getSelectedItem();
        return (DGuiItem) (item == null || item instanceof DGuiItem ? item : null);
    }
}
