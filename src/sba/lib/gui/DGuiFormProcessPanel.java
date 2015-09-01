/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import sba.lib.grid.DGridPaneForm;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFormProcessPanel {

    public void setValue(final int type, final Object value);
    public Object getValue(final int type);

    public void giveFocus();
    public DGridPaneForm[] getFormGrids();
    public DGuiValidation validatePanel();
}
