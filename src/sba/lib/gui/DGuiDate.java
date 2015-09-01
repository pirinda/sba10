/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public class DGuiDate extends java.util.Date {

    private int mnGuiType;

    public DGuiDate(int guiType) {
        this(guiType, 0);
    }

    public DGuiDate(int guiType, long date) {
        super(date);
        mnGuiType = guiType;
    }

    public void setGuiType(int guiType) {
        mnGuiType = guiType;
    }

    public int getGuiType() {
        return mnGuiType;
    }
}
