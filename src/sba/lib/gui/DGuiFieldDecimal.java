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
public interface DGuiFieldDecimal extends DGuiField {

    public Double getValue();
    public Double getDefaultValue();

    public void setDecimalSettings(final String name, final int guiType, final boolean mandatory);
    public void setDecimalFormat(DecimalFormat format);

    public void setGuiType(final int type);
    public void setMandatory(final boolean mandatory);
    public void setMinDouble(final double min);
    public void setMaxDouble(final double max);

    public double getMinDouble();
    public double getMaxDouble();
}
