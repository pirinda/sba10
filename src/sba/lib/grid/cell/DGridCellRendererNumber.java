/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import sba.lib.DLibUtils;
import sba.lib.grid.DGridConsts;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellRendererNumber extends DefaultTableCellRenderer {
    
    private NumberFormat moNumberFormat;
    private JLabel moLabel;
    
    public DGridCellRendererNumber(NumberFormat numberFormat) {
        moNumberFormat = numberFormat;
        moLabel = new JLabel();
        moLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        moLabel.setOpaque(true);
    }
    
    public void setNumberFormat(NumberFormat o) { moNumberFormat = o; }
    public void setLabel(JLabel o) { moLabel = o; }
    
    public NumberFormat getNumberFormat() { return moNumberFormat; }
    public JLabel getLabel() { return moLabel; }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        double dNumber = 0;
        String sNumber = "";
        
        if (value == null) {
            sNumber = table.isCellEditable(row, col) ? "0" : "";
            value = new Integer(0);
        }
        else {
            try {
                dNumber = ((Number) value).doubleValue();
                sNumber = moNumberFormat.format(dNumber);
            }
            catch (Exception e) {
                DLibUtils.showException(this, e);
            }
        }
        
        moLabel.setText(sNumber);
        
        if (isSelected) {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(dNumber < 0 ? DGridConsts.COLOR_FG_EDIT_NEG : DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_EDIT_FOCUS : DGridConsts.COLOR_BG_SELECT_EDIT);
            }
            else {
                moLabel.setForeground(dNumber < 0 ? DGridConsts.COLOR_FG_READ_NEG : DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_READ_FOCUS : DGridConsts.COLOR_BG_SELECT_READ);
            }
        }
        else {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(dNumber < 0 ? DGridConsts.COLOR_FG_EDIT_NEG : DGridConsts.COLOR_FG_EDIT);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_EDIT);
            }
            else {
                moLabel.setForeground(dNumber < 0 ? DGridConsts.COLOR_FG_READ_NEG : DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_READ);
            }
        }
        
        return moLabel;
    }
}
