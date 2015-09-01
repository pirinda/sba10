/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

/**
 *
 * @author Sergio Flores
 */
public interface DGridPaneFormOwner {

    public void notifyRowNew(final int gridType, final int gridSubtype, final int row, DGridRow gridRow);
    public void notifyRowEdit(final int gridType, final int gridSubtype, final int row, DGridRow gridRow);
    public void notifyRowDelete(final int gridType, final int gridSubtype, final int row, DGridRow gridRow);
}
