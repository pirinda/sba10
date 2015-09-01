/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellKeyValue {
    public int[] Key;
    public String Value;

    public DGridCellKeyValue() {
        Key = null;
        Value = "";
    }

    public DGridCellKeyValue(int[] key, String value) {
        Key = key;
        Value = value;
    }
}
