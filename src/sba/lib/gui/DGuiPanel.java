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
public interface DGuiPanel {

    public int getPanelStatus();

    public void setPanelSettings(final DGuiClient client);
    public void setPanelEditable(final boolean editable);
    public void addAllListeners();
    public void removeAllListeners();
    public void reloadCatalogues();

    public void setRegistry(final DDbRegistry registry) throws Exception;
    public DDbRegistry getRegistry() throws Exception;
    public DGuiValidation validatePanel();
    public DGuiField getFieldFirst();
    public DGuiField getFieldLast();
    public DGuiFields getFields();

    public void setValue(final int type, final Object value);
    public Object getValue(final int type);
}
