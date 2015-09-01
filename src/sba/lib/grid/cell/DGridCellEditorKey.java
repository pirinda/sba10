/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import sba.lib.gui.DGuiItem;
import sba.lib.gui.DGuiUtils;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellEditorKey extends AbstractCellEditor implements TableCellEditor {

    protected JComboBox moComboBox;

    public DGridCellEditorKey(JComboBox comboBox) {
        moComboBox = comboBox;
    }

    @Override
    public Object getCellEditorValue() {
        return ((DGuiItem) moComboBox.getSelectedItem()).getPrimaryKey();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        DGuiUtils.locateItem(moComboBox, (int[]) value);
        return moComboBox;
    }
}
