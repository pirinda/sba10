/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sba.lib.DLibUtils;
import sba.lib.grid.DGridConsts;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellRenderereKey extends DefaultTableCellRenderer {
    protected JLabel moLabel;
    protected Vector<DGridCellKeyValue> mvKeyValues;

    public DGridCellRenderereKey(Vector<DGridCellKeyValue> keyValues) {
        mvKeyValues = new Vector<DGridCellKeyValue>();
        mvKeyValues.addAll(keyValues);
        moLabel = new JLabel();
        moLabel.setOpaque(true);
    }

    public void setLabel(JLabel o) { moLabel = o; }

    public JLabel getLabel() { return moLabel; }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String labelValue = "?";

        if (value != null) {
            for (DGridCellKeyValue keyValue : mvKeyValues) {
                if (DLibUtils.compareKeys((int[]) value, keyValue.Key)) {
                    labelValue = keyValue.Value;
                    break;
                }
            }
        }

        moLabel.setText(labelValue);

        if (isSelected) {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_EDIT_FOCUS : DGridConsts.COLOR_BG_SELECT_EDIT);
            }
            else {
                moLabel.setForeground(DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_READ_FOCUS : DGridConsts.COLOR_BG_SELECT_READ);
            }
        }
        else {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_EDIT);
            }
            else {
                moLabel.setForeground(DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_READ);
            }
        }

        return moLabel;
    }
}
