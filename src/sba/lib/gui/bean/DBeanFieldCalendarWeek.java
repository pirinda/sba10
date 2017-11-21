/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.gui.bean;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Sergio Flores
 */
public class DBeanFieldCalendarWeek extends DBeanFieldCalendarMonth {
    
    public DBeanFieldCalendarWeek() {
        super();
        mnMaxInteger = 53;
        setModel(new SpinnerNumberModel(mnDefaultValue, mnMinInteger, mnMaxInteger, 1));
    }
}
