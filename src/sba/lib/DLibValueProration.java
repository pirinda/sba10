/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

import java.util.ArrayList;

/**
 *
 * @author Sergio Flores
 */
public class DLibValueProration {
    private final ArrayList<DLibValue> maValues;
    
    public DLibValueProration() {
        maValues = new ArrayList<>();
    }
    
    /**
     * Adds new value to array of values.
     * @param value Value to be added.
     * @throws Exception if value's key already exists in array of values.
     */
    public void addValue(DLibValue value) throws Exception {
        DLibValue v = getValue(value.getKey());
        
        if (v != null) {
            throw new Exception(DLibConsts.ERR_MSG_UTILS_KEY_EXISTS);
        }
        
        maValues.add(value);
    }
    
    /**
     * Prorates value into array of values with decimals constraint.
     * @param value Value to be prorated into array of values.
     * @param decimals Constraint of number of decimals of proration.
     */
    public void prorateValue(double value, int decimals) {
        double sourceTotal = 0;
        
        // sum source values and reset prorated values:
        
        for (DLibValue v : maValues) {
            sourceTotal += v.getValueSource();
            v.setValueProrated(0);
        }
        
        if (sourceTotal > 0) {
            // prorate values:
            
            double prorate = 0;
            double prorateTotal = 0;
            DLibValue valueGreater = null;

            for (DLibValue v : maValues) {
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
    
    /**
     * Gets size of array of values.
     * @return Size of array of values.
     */
    public int getValuesSize() {
        return maValues.size();
    }
    
    /**
     * Gets value by key from array of values.
     * @param key Key of desired value.
     * @return Desired value, if any, otherwise <code>null</code>.
     */
    public DLibValue getValue(int[] key) {
        DLibValue value = null;
        
        for (DLibValue v : maValues) {
            if (DLibUtils.compareKeys(key, v.getKey())) {
                value = v;
                break;
            }
        }
        
        return value;
    }
    
    /**
     * Clears array of values.
     */
    public void clearValues() {
        maValues.clear();
    }
}
