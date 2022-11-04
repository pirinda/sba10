/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.text.DecimalFormat;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFieldInteger extends DGuiField {

    public Integer getValue();
    public Integer getDefaultValue();

    public void setIntegerSettings(final String name, final int guiType, final boolean mandatory);
    public void setIntegerFormat(DecimalFormat format);

    public void setGuiType(final int type);
    public void setMandatory(final boolean mandatory);
    public void setMinInteger(final int min);
    public void setMaxInteger(final int max);

    public int getMinInteger();
    public int getMaxInteger();
}
