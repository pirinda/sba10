/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiOptionPicker {

    public void setPickerSettings(final DGuiClient client, final int pickerType, final int pickerSubtype, final DGuiOptionPickerSettings settings);
    public void resetPicker();
    public void setPickerVisible(final boolean visible);
    public void setOption(final Object option);
    public Object getOption();
    public DGuiValidation validatePicker();
    public int getPickerType();
    public int getPickerSubtype();
    public int getPickerResult();
    public void actionOk();
    public void actionCancel();
}
