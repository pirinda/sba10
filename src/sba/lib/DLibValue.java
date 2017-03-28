/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

import java.util.ArrayList;

/**
 * Allows control of an individual value to be prorated.
 * @author Sergio Flores
 */
public class DLibValue {
    
    private final Object moKey;
    private final double mdValueSource;
    private double mdValueProrated;
    
    public DLibValue(Object key, double valueSource) {
        moKey = key;
        mdValueSource = valueSource;
        mdValueProrated = 0;
    }
    
    public void setValueProrated(double valueProrated) { mdValueProrated = valueProrated; }
    
    public Object getKey() { return moKey; }
    public double getValueSource() { return mdValueSource; }
    public double getValueProrated() { return mdValueProrated; }
    
    /**
     * Prorate value into array of values with decimals constraint.
     * @param value Value to be prorated into array of values.
     * @param values Values that need to be assigned with a prorated value.
     * @param decimals Constraint of number of decimals of proration.
     */
    public static void prorateValue(double value, ArrayList<DLibValue> values, int decimals) {
        double sourceTotal = 0;
        
        // sum source values and reset prorated values:
        
        for (DLibValue v : values) {
            sourceTotal += v.getValueSource();
            v.setValueProrated(0);
        }
        
        if (sourceTotal > 0) {
            // prorate values:
            
            double prorate = 0;
            double prorateTotal = 0;
            DLibValue valueGreater = null;

            for (DLibValue v : values) {
                prorate = DLibUtils.round(value * (v.getValueSource() / sourceTotal), decimals);
                v.setValueProrated(prorate);
                
                prorateTotal = DLibUtils.round(prorateTotal + prorate, decimals);

                if (valueGreater == null || v.getValueSource() > valueGreater.getValueSource()) {
                    valueGreater = v;
                }
            }
            
            // adjust proration, if necesary:
            
            double difference = DLibUtils.round(prorateTotal - value, decimals);
            
            if (difference != 0 && valueGreater != null) {
                valueGreater.setValueProrated(DLibUtils.round(valueGreater.getValueProrated() - difference, decimals));
            }
        }
    }
    
    @Override
    public String toString() {
        return "# " + moKey.toString() + ", <" + mdValueSource + ">: <" + mdValueProrated + ">";
    }
}
