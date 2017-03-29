/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

/**
 * Allows control of an individual base value to be used in prorations.
 * @author Sergio Flores
 */
public class DLibValue {
    
    private final int[] mnaKey;
    private final double mdValueBase;
    private double mdValueProrated;
    
    public DLibValue(int[] key, double valueBase) {
        mnaKey = key;
        mdValueBase = valueBase;
        mdValueProrated = 0;
    }
    
    public void setValueProrated(double valueProrated) { mdValueProrated = valueProrated; }
    
    public int[] getKey() { return mnaKey; }
    public double getValueBase() { return mdValueBase; }
    public double getValueProrated() { return mdValueProrated; }
    
    @Override
    public String toString() {
        return "# " + DLibUtils.textKey(mnaKey) + ", <" + mdValueBase + ">: <" + mdValueProrated + ">";
    }
}
