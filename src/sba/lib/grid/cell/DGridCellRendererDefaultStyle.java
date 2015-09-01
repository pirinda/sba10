/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellRendererDefaultStyle extends DefaultTableCellRenderer {
    
    private JLabel moLabel;
    private Font moFontPlain;
    private Font moFontBold;
    private Font moFontItalic;
    
    public DGridCellRendererDefaultStyle() {
        moLabel = new JLabel();
        moLabel.setOpaque(true);
        
        moFontPlain = moLabel.getFont();
        moFontBold = moLabel.getFont().deriveFont(Font.BOLD);
        moFontItalic = moLabel.getFont().deriveFont(Font.ITALIC);
    }
    
    public void setLabel(JLabel o) { moLabel = o; }
    
    public JLabel getLabel() { return moLabel; }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        /*
        int style = ((STableModel) table.getModel()).getTableRow(row).getStyle();

        moLabel.setText(value != null ? value.toString() : "");

        switch (style) {
            case SGridConst.STYLE_BOLD:
                moLabel.setFont(moFontBold);
                break;
            case SGridConst.STYLE_ITALIC:
                moLabel.setFont(moFontItalic);
                break;
            default:
                moLabel.setFont(moFontPlain);
                break;
        }

        if (isSelected) {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(SGridConst.COLOR_FGND_EDIT);
                moLabel.setBackground(hasFocus ? SGridConst.COLOR_BGND_SELECT_EDIT_FOCUS : SGridConst.COLOR_BGND_SELECT_EDIT);
            }
            else {
                moLabel.setForeground(style == SGridConst.STYLE_ITALIC ? Color.BLUE.darker() : SGridConst.COLOR_FGND_READ);
                moLabel.setBackground(hasFocus ? SGridConst.COLOR_BGND_SELECT_READ_FOCUS : SGridConst.COLOR_BGND_SELECT_READ);
            }
        }
        else {
            if (table.isCellEditable(row, col)) {
                moLabel.setForeground(SGridConst.COLOR_FGND_EDIT);
                moLabel.setBackground(SGridConst.COLOR_BGND_PLAIN_EDIT);
            }
            else {
                moLabel.setForeground(style == SGridConst.STYLE_ITALIC ? Color.BLUE.darker() : SGridConst.COLOR_FGND_READ);
                moLabel.setBackground(SGridConst.COLOR_BGND_PLAIN_READ);
            }
        }
        
        */
        return moLabel;
    }
}
