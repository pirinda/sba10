/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFieldKey extends DGuiField {

    public int[] getValue();
    public int[] getDefaultValue();

    public void setKeySettings(final DGuiClient client, final String name, final boolean mandatory);

    public void setMandatory(final boolean mandatory);

    public DGuiItem getSelectedItem();
}
