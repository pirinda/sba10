/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFieldText extends DGuiField {

    public String getValue();
    public String getDefaultValue();

    public void setTextSettings(final String name, final int max);
    public void setTextSettings(final String name, final int max, final int min);

    public void setMinLength(final int min);
    public void setMaxLength(final int max);
    public void setTextCaseType(final int type);

    public int getMinLength();
    public int getMaxLength();
    public int getTextCaseType();
}
