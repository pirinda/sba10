/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

/**
 *
 * @author Sergio Flores
 */
public class DGuiValidation {

    protected boolean mbValid;
    protected String msMessage;
    protected JComponent moComponent;
    protected JTabbedPane moTabbedPane;
    protected int mnTab;

    public DGuiValidation() {
        mbValid = true;
        msMessage = "";
        moComponent = null;
        moTabbedPane = null;
        mnTab = -1;
    }

    public void setValid(boolean valid) { mbValid = valid; }
    public void setMessage(String message) { msMessage = message; mbValid = msMessage.length() == 0; }
    public void setComponent(JComponent component) { moComponent = component; }
    public void setTabbedPane(JTabbedPane tabbedPane) { moTabbedPane = tabbedPane; }
    public void setTab(int tab) { mnTab = tab; }

    public boolean isValid() { return mbValid; }
    public String getMessage() { return msMessage; }
    public JComponent getComponent() { return moComponent; }
    public JTabbedPane getTabbedPane() { return moTabbedPane; }
    public int getTab() { return mnTab; }
}
