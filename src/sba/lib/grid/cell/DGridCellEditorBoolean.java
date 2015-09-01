/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellEditorBoolean extends AbstractCellEditor implements TableCellEditor {

    protected JCheckBox moCheckBox;
    
    public DGridCellEditorBoolean() {
        moCheckBox = new JCheckBox();
    }

    @Override
    public Object getCellEditorValue() {
        return moCheckBox.isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        moCheckBox.setSelected((Boolean) value);
        return moCheckBox;
    }
}
