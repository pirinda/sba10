/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 *
 * @author Sergio Flores
 */
public class DGuiFields {

    protected JTabbedPane moTabbedPane;
    protected Vector<DGuiField> mvFields;

    public DGuiFields() {
        this(null);
    }

    public DGuiFields(JTabbedPane tabbedPane) {
        moTabbedPane = tabbedPane;
        mvFields = new Vector<DGuiField>();
    }

    public void setTabbedPane(JTabbedPane o) { moTabbedPane = o; }

    public JTabbedPane getTabbedPane() { return moTabbedPane; }
    public Vector<DGuiField> getFields() { return mvFields; }

    public void addField(DGuiField field) {
        addField(field, -1);
    }

    public void addField(DGuiField field, int tab) {
        int size = mvFields.size();
        
        if (tab != -1) {
            field.setTab(tab);
        }

        mvFields.add(field);

        if (size > 0) {
            mvFields.get(size - 1).setNextField(field);
        }
    }

    public void setFormButton(JButton button) {
        int size = mvFields.size();

        if (size > 0) {
            mvFields.get(size - 1).setFormButton(button);
        }
    }

    public void resetFields() {
        for (DGuiField field : mvFields) {
            field.resetField();
        }
    }

    public void setFieldsEnabled(final boolean enabled) {
        for (DGuiField field : mvFields) {
            field.setEnabled(enabled);
        }
    }

    public void setFieldsEditable(final boolean editable) {
        for (DGuiField field : mvFields) {
            field.setEditable(editable);
        }
    }

    public DGuiValidation validateFields() {
        DGuiValidation validation = new DGuiValidation();

        for (DGuiField field : mvFields) {
            if (field.isFocusable()) {
                validation = field.validateField();

                if (!validation.isValid()) {
                    validation.setTabbedPane(moTabbedPane);
                    break;
                }
            }
        }

        return validation;
    }
}
