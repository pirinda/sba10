/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.calc;

import java.util.ArrayList;
import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public class DCalcTotalFitter {

    protected double mdTotalToFit;
    protected int mnDecimals;
    protected ArrayList<DCalcTotalElement> maElements;

    public DCalcTotalFitter(double totalToFit, int decimals) {
        mdTotalToFit = totalToFit;
        mnDecimals = decimals;
        maElements = new ArrayList<DCalcTotalElement>();
    }

    public double getTotalToFit() {
        return mdTotalToFit;
    }

    public int getDecimals() {
        return mnDecimals;
    }

    public ArrayList<DCalcTotalElement> getElements() {
        return maElements;
    }

    public void fitElements() {
        double total = 0;
        DCalcTotalElement biggest = null;

        for (DCalcTotalElement element : maElements) {
            total += element.getValue();
            if (biggest == null || element.getValue() >= biggest.getValue()) {
                biggest = element;
            }
        }

        if (biggest != null && DLibUtils.round(mdTotalToFit - total, mnDecimals) != 0) {
            biggest.setNewValue(biggest.getValue() + DLibUtils.round(mdTotalToFit - total, mnDecimals));
        }
    }
}
