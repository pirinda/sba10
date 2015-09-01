/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import sba.lib.db.DDbRegistry;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiFormOwner {

    public boolean validateRegistryNew(final DDbRegistry registry);
    public boolean validateRegistryEdit(final DDbRegistry registry);
}
