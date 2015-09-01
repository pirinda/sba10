/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sba.lib.grid.DGridConsts;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellRendererDefaultColor extends DefaultTableCellRenderer {

    private Color moColor;
    private JLabel moLabel;
    
    public DGridCellRendererDefaultColor(Color color) {
        moColor = color;
        moLabel = new JLabel();
        moLabel.setOpaque(true);
    }
    
    public void setColor(Color o) { moColor = o; }
    public void setLabel(JLabel o) { moLabel = o; }
    
    public Color getColor() { return moColor; }
    public JLabel getLabel() { return moLabel; }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        moLabel.setText(value != null ? value.toString() : "");

        if (isSelected) {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_EDIT_FOCUS : DGridConsts.COLOR_BG_SELECT_EDIT);
            }
            else {
                moLabel.setForeground(moColor);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_READ_FOCUS : DGridConsts.COLOR_BG_SELECT_READ);
            }
        }
        else {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_EDIT);
            }
            else {
                moLabel.setForeground(moColor);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_READ);
            }
        }

        return moLabel;
    }
}
