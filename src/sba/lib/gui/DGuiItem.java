/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.util.Date;

/**
 *
 * @author Sergio Flores
 */
public class DGuiItem {

    protected int[] manPrimaryKey;
    protected int[] manForeignKey;
    protected String msItem;
    protected Object moComplement;
    protected String msCode;
    private boolean mbCodeVisible;
    protected Date mtDate;
    protected double mdValue;

    public DGuiItem(String item) {
        this(new int[0], item, null, null);
    }

    public DGuiItem(int[] pk, String item) {
        this(pk, item, null, null);
    }

    public DGuiItem(int[] pk, String item, int[] fk) {
        this(pk, item, fk, null);
    }

    public DGuiItem(int[] pk, String item, Object complement) {
        this(pk, item, null, complement);
    }

    public DGuiItem(int[] pk, String item, int[] fk, Object complement) {
        manPrimaryKey = pk;
        manForeignKey = fk;
        msItem = item;
        moComplement = complement;
        msCode = "";
        mbCodeVisible = true;
        mtDate = null;
        mdValue = 0;
    }

    public void setPrimaryKey(int[] pk) { manPrimaryKey = pk; }
    public void setForeignKey(int[] pk) { manForeignKey = pk; }
    public void setItem(String item) { msItem = item; }
    public void setComplement(Object complement) { moComplement = complement; }
    public void setCode(String code) { msCode = code; }
    public void setCodeVisible(boolean visible) { mbCodeVisible = visible; }
    public void setDate(Date t) { mtDate = t; }
    public void setValue(double d) { mdValue = d; }

    public int[] getPrimaryKey() { return manPrimaryKey; }
    public int[] getForeignKey() { return manForeignKey; }
    public String getItem() { return msItem; }
    public Object getComplement() { return moComplement; }
    public String getCode() { return msCode; }
    public boolean isCodeVisible() { return mbCodeVisible; }
    public Date getDate() { return mtDate; }
    public double getValue() { return mdValue; }

    @Override
    public String toString() {
        return msItem + (!msCode.isEmpty() && mbCodeVisible ? " (" + msCode + ")" : "");
    }
}
