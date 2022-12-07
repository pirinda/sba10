/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.awt.Component;
import java.util.HashMap;

/**
 *
 * @author Sergio Flores
 */
public class DGuiComponentGui {

    protected DGuiSession moSession;
    protected Component moComponentGui;
    protected HashMap<Integer, Integer> moUserPrivilegesMap; // map of <privilege, level access>
    
    public DGuiComponentGui(DGuiSession session, Component component) {
        moSession = session;
        moComponentGui = component;
        moUserPrivilegesMap = new HashMap<>();
    }
    
    public Component getComponentGui() { return  moComponentGui; }
    public HashMap<Integer, Integer> getUserPrivilegesMap() { return moUserPrivilegesMap; }
}
