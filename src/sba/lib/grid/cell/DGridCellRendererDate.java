/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class DGridCellRendererDate extends DefaultTableCellRenderer {
    
    private SimpleDateFormat moSimpleDateFormat;
    private JLabel moLabel;
    
    public DGridCellRendererDate(SimpleDateFormat simpleDateFormat) {
        moSimpleDateFormat = simpleDateFormat;
        moLabel = new JLabel();
        moLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moLabel.setOpaque(true);
    }
    
    public void setSimpleDateFormat(SimpleDateFormat o) { moSimpleDateFormat = o; }
    public void setLabel(JLabel o) { moLabel = o; }
    
    public SimpleDateFormat getSimpleDateFormat() { return moSimpleDateFormat; }
    public JLabel getLabel() { return moLabel; }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        Date tDate = null;
        String sDate = "";
        
        try {
            if (value != null) {
                tDate = (Date) value;
                sDate = moSimpleDateFormat.format(tDate);
            }
        }
        catch (Exception e) {
            DLibUtils.showException(this, e);
        }
        
        moLabel.setText(sDate);

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
