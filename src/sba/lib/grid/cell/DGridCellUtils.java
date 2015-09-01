/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.util.Vector;
import javax.swing.JComboBox;
import sba.lib.gui.DGuiItem;

/**
 *
 * @author Sergio Flores
 */
public abstract class DGridCellUtils {

    /**
     * @param comboBox JComboBox populated with DGuiItem items.
     * @return Vector of DGridCellKeyValue objects for DGridCellRendererKey.
     */
    public static Vector<DGridCellKeyValue> createKeyValues(JComboBox comboBox) {
        DGuiItem item = null;
        Vector<DGridCellKeyValue> keyValues = new Vector<DGridCellKeyValue>();

        keyValues.add(new DGridCellKeyValue(null, "?"));

        for (int i = 1; i < comboBox.getItemCount(); i++) {
            item = (DGuiItem) comboBox.getItemAt(i);
            keyValues.add(new DGridCellKeyValue(item.getPrimaryKey(), item.getItem()));
        }

        return keyValues;
    }
}
