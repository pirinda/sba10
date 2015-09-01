/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.awt.Font;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiCompoundField {

    public void setCompoundFieldSettings(final DGuiClient client);
    public void setCompoundText(final String text);
    public DGuiField getField();
    public String getCompoundText();

    public void setCompoundFont(final Font font);
    public void setEnabled(final boolean enabled);
    public void setEditable(final boolean editable);
    public boolean isEnabled();
    public boolean isEditable();
}
