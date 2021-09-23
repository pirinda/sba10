/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid;

/**
 *
 * @author Sergio Flores
 */
public class DGridFilterValue {
    
    protected int mnFilterType;
    protected int mnDataType;
    protected Object moValue;
    
    public DGridFilterValue(int filterType, int dataType, Object value) {
        mnFilterType = filterType;
        mnDataType = dataType;
        moValue = value;
    }

    public void setFilterType(int n) { mnFilterType = n; }
    public void setDataType(int n) { mnDataType = n; }
    public void setValue(Object o) { moValue = o; }

    public int getFilterType() { return mnFilterType; }
    public int getDataType() { return mnDataType; }
    public Object getValue() { return moValue; }
}
