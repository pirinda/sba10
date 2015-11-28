/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.cell;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sba.lib.DLibConsts;
import sba.lib.DLibUtils;
import sba.lib.grid.DGridConsts;

/**
 *
 * @author Sergio Flores
 */
public class DGridCellRendererIcon extends DefaultTableCellRenderer {

    public static final ImageIcon moIconNull = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_null.png"));
    public static final ImageIcon moIconAnnul = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_annul.png"));
    public static final ImageIcon moIconCross = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_cross.png"));
    public static final ImageIcon moIconOk = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_ok.png"));
    public static final ImageIcon moIconDoc = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_doc.png"));
    public static final ImageIcon moIconThumbsUp = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_thum_up.png"));
    public static final ImageIcon moIconThumbsDown = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_thum_down.png"));
    public static final ImageIcon moIconXmlPending = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_xml_pend.png"));
    public static final ImageIcon moIconXmlIssued = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_xml_issu.png"));
    public static final ImageIcon moIconXmlAnnulled = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_xml_annul.png"));
    public static final ImageIcon moIconXmlAnnulledPdf = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_xml_annul_pdf.png"));
    public static final ImageIcon moIconXmlAnnulledXml = new ImageIcon(new Object().getClass().getResource("/sba/lib/img/view_xml_annul_xml.png"));

    private JLabel moLabel;

    public DGridCellRendererIcon() {
        moLabel = new JLabel();
        moLabel.setOpaque(true);
        moLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setLabel(JLabel o) { moLabel = o; }

    public JLabel getLabel() { return moLabel; }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        int icon = DLibConsts.UNDEFINED;

        try {
            icon = value == null ? DGridConsts.ICON_NULL : ((Number) value).intValue();
        }
        catch (java.lang.Exception e) {
            DLibUtils.showException(this, e);
        }

        switch (icon) {
            case DGridConsts.ICON_NULL:
                moLabel.setIcon(moIconNull);
                break;
            case DGridConsts.ICON_ANNUL:
                moLabel.setIcon(moIconAnnul);
                break;
            case DGridConsts.ICON_CROSS:
                moLabel.setIcon(moIconCross);
                break;
            case DGridConsts.ICON_OK:
                moLabel.setIcon(moIconOk);
                break;
            case DGridConsts.ICON_THUMBS_UP:
                moLabel.setIcon(moIconThumbsUp);
                break;
            case DGridConsts.ICON_THUMBS_DOWN:
                moLabel.setIcon(moIconThumbsDown);
                break;
            case DGridConsts.ICON_XML_PEND:
                moLabel.setIcon(moIconXmlPending);
                break;
            case DGridConsts.ICON_XML_ISSU:
                moLabel.setIcon(moIconXmlIssued);
                break;
            case DGridConsts.ICON_XML_ANNUL:
                moLabel.setIcon(moIconXmlAnnulled);
                break;
            case DGridConsts.ICON_XML_ANNUL_PDF:
                moLabel.setIcon(moIconXmlAnnulledPdf);
                break;
            case DGridConsts.ICON_XML_ANNUL_XML:
                moLabel.setIcon(moIconXmlAnnulledXml);
                break;
            default:
                moLabel.setIcon(moIconNull);
        }

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
