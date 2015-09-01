/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
public class DGridCellRendererBoolean extends DefaultTableCellRenderer {
    
    private ImageIcon moIconNull = new ImageIcon(getClass().getResource("/sba/lib/img/view_null.png"));
    private ImageIcon moIconTrue = new ImageIcon(getClass().getResource("/sba/lib/img/view_bool_true.gif"));
    private ImageIcon moIconFalse = new ImageIcon(getClass().getResource("/sba/lib/img/view_bool_false.gif"));
    private JLabel moLabel;
    private JCheckBox moCheckBox;
    
    public DGridCellRendererBoolean() {
        moLabel = new JLabel();
        moLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moLabel.setOpaque(true);

        moCheckBox = new JCheckBox();
        moCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        moCheckBox.setOpaque(true);
    }
    
    public void setLabel(JLabel o) { moLabel = o; }
    
    public JLabel getLabel() { return moLabel; }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        Component component = null;

        if (table.isCellEditable(row, col)) {
            moCheckBox.setSelected((Boolean) value);

            if (isSelected) {
                moCheckBox.setForeground(DGridConsts.COLOR_FG_EDIT);
                moCheckBox.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_EDIT_FOCUS : DGridConsts.COLOR_BG_SELECT_EDIT);
            }
            else {
                moCheckBox.setForeground(DGridConsts.COLOR_FG_EDIT);
                moCheckBox.setBackground(DGridConsts.COLOR_BG_PLAIN_EDIT);
            }

            component = moCheckBox;
        }
        else {
            ImageIcon icon = value == null ? moIconNull : moIconFalse;

            if (value != null) {
                try {
                    if (((Boolean) value)) {
                        icon = moIconTrue;
                    }
                }
                catch (Exception e) {
                    DLibUtils.showException(this, e);
                }
            }

            moLabel.setIcon(icon);
            moLabel.setAlignmentY(SwingConstants.CENTER);

            if (isSelected) {
                moLabel.setForeground(DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(hasFocus ? DGridConsts.COLOR_BG_SELECT_READ_FOCUS : DGridConsts.COLOR_BG_SELECT_READ);
            }
            else {
                moLabel.setForeground(DGridConsts.COLOR_FG_READ);
                moLabel.setBackground(DGridConsts.COLOR_BG_PLAIN_READ);
            }

            component = moLabel;
        }
        
        return component;
    }
}
