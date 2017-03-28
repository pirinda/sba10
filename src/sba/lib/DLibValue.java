/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

/**
 * Allows control of an individual value to be prorated.
 * @author Sergio Flores
 */
public class DLibValue {
    
    private final int[] mnaKey;
    private final double mdValueSource;
    private double mdValueProrated;
    
    public DLibValue(int[] key, double valueSource) {
        mnaKey = key;
        mdValueSource = valueSource;
        mdValueProrated = 0;
    }
    
    public void setValueProrated(double valueProrated) { mdValueProrated = valueProrated; }
    
    public int[] getKey() { return mnaKey; }
    public double getValueSource() { return mdValueSource; }
    public double getValueProrated() { return mdValueProrated; }
    
    @Override
    public String toString() {
        return "# " + DLibUtils.textKey(mnaKey) + ", <" + mdValueSource + ">: <" + mdValueProrated + ">";
    }
}
