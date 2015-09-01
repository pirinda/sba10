/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DGridFilterYear.java
 *
 * Created on 4/09/2011, 11:56:10 PM
 */

package sba.lib.grid;

import javax.swing.JPanel;
import sba.lib.DLibTimeUtils;
import sba.lib.DLibUtils;
import sba.lib.gui.DGuiClient;
import sba.lib.gui.DGuiConsts;
import sba.lib.gui.DGuiYearPicker;

/**
 *
 * @author Sergio Flores
 */
public class DGridFilterYear extends JPanel implements DGridFilter {

    protected DGuiClient miClient;
    protected DGridPaneView moPaneView;
    protected DGuiYearPicker moYearPicker;
    protected int[] manPeriod;

    /** Creates new form DGridFilterYear */
    public DGridFilterYear(DGuiClient client, DGridPaneView paneView) {
        miClient = client;
        moPaneView = paneView;
        initComponents();
        initComponentsCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfPeriod = new javax.swing.JTextField();
        jbPeriod = new javax.swing.JButton();
        jbCurrentPeriod = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(0, 5, 0));

        jtfPeriod.setEditable(false);
        jtfPeriod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfPeriod.setText("2001");
        jtfPeriod.setToolTipText("Período");
        jtfPeriod.setFocusable(false);
        jtfPeriod.setPreferredSize(new java.awt.Dimension(45, 23));
        add(jtfPeriod);

        jbPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cal_cal.gif"))); // NOI18N
        jbPeriod.setToolTipText("Seleccionar período");
        jbPeriod.setPreferredSize(new java.awt.Dimension(23, 23));
        jbPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPeriodActionPerformed(evt);
            }
        });
        add(jbPeriod);

        jbCurrentPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sba/lib/img/cal_date_year.gif"))); // NOI18N
        jbCurrentPeriod.setToolTipText("Período actual");
        jbCurrentPeriod.setPreferredSize(new java.awt.Dimension(23, 23));
        jbCurrentPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCurrentPeriodActionPerformed(evt);
            }
        });
        add(jbCurrentPeriod);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPeriodActionPerformed
        moYearPicker.resetPicker();
        moYearPicker.setOption(manPeriod);
        moYearPicker.setVisible(true);

        if (moYearPicker.getPickerResult() == DGuiConsts.FORM_RESULT_OK) {
            setPeriod(moYearPicker.getOption());
            moPaneView.putFilter(DGridConsts.FILTER_YEAR, manPeriod);
        }
    }//GEN-LAST:event_jbPeriodActionPerformed

    private void jbCurrentPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCurrentPeriodActionPerformed
        setPeriod(DLibTimeUtils.digestYear(miClient.getSession().getWorkingDate()));
        moPaneView.putFilter(DGridConsts.FILTER_YEAR, manPeriod);
    }//GEN-LAST:event_jbCurrentPeriodActionPerformed

    private void initComponentsCustom() {
        moYearPicker = new DGuiYearPicker(miClient);
        setPeriod(null);
    }

    private void renderPeriod() {
        if (manPeriod == null) {
            jtfPeriod.setText("");
        }
        else {
            jtfPeriod.setText(DLibUtils.DecimalFormatCalendarYear.format(manPeriod[0]));
        }
    }

    private void setPeriod(final int[] period) {
        manPeriod = period;
        renderPeriod();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCurrentPeriod;
    private javax.swing.JButton jbPeriod;
    private javax.swing.JTextField jtfPeriod;
    // End of variables declaration//GEN-END:variables

    /**
     * @param value Year as int[] of length 1 (year).
     */
    @Override
    public void initFilter(final Object value) {
        setPeriod((int[]) value);
        moPaneView.getFiltersMap().put(DGridConsts.FILTER_YEAR, manPeriod);
    }
}
