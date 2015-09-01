/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFieldCalendar extends DGuiField {

    public Integer getValue();
    public Integer getDefaultValue();

    public void setCalendarSettings(final String name);
}
