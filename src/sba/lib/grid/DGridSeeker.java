/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestTableSeekerEditor.java
 *
 * Created on 14/06/2011, 05:09:37 PM
 */

package sba.lib.grid;

import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;

/**
 *
 * @author Sergio Flores
 */
public class DGridSeeker extends JDialog {

    protected boolean mbSeekRequested;
    protected volatile boolean mbFormClosing;
    protected DGridSeekerTimer moSeekerTimer;

    /** Creates new form TestTableSeekerEditor */
    public DGridSeeker(java.awt.Frame parent) {
        super(parent, true);
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

        jtfText = new javax.swing.JTextField();

        setLocationByPlatform(true);
        setResizable(false);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jtfText.setText("TEXT");
        jtfText.setPreferredSize(new java.awt.Dimension(150, 23));
        jtfText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTextFocusLost(evt);
            }
        });
        jtfText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTextKeyPressed(evt);
            }
        });
        getContentPane().add(jtfText);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-150)/2, (screenSize.height-23)/2, 150, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTextFocusLost
        if (!mbFormClosing) {
            closeSeeker();
        }
    }//GEN-LAST:event_jtfTextFocusLost

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        moSeekerTimer = new DGridSeekerTimer(this);
        moSeekerTimer.startThread();
    }//GEN-LAST:event_formWindowActivated

    private void jtfTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTextKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                mbSeekRequested = true;
                closeSeeker();
                break;
            case KeyEvent.VK_ESCAPE:
                closeSeeker();
                break;
            default:
                moSeekerTimer.resetTimer();
        }
    }//GEN-LAST:event_jtfTextKeyPressed

    private void initComponentsCustom() {
        mbSeekRequested = false;
        mbFormClosing = false;
        moSeekerTimer = null;

        jtfText.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jtfText;
    // End of variables declaration//GEN-END:variables

    public void closeSeeker() {
        if (!mbFormClosing) {
            mbFormClosing = true;
            moSeekerTimer.stopThread();
            setVisible(false);
        }
    }

    public void openSeeker(Point seekerLocation) {
        initComponentsCustom();

        setLocation(seekerLocation);
        setVisible(true);
    }

    public void handleKeyPressedEvent(KeyEvent event, Point seekerLocation) {
        initComponentsCustom();

        if (event.isActionKey()) {
        }
        else if (event.isControlDown()) {
        }
        else if (event.isAltGraphDown()) {    // is actually processed as a double Control Down!
        }
        else if (event.isAltDown()) {
        }
        else if (event.isMetaDown()) {
        }
        else if (event.isShiftDown() && event.getKeyCode() == KeyEvent.VK_SHIFT) {
        }
        else {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_TAB:
                case KeyEvent.VK_ESCAPE:
                case KeyEvent.VK_ENTER:
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_BACK_SPACE:
                    break;
                default:
                    jtfText.setText("" + event.getKeyChar());
                    setLocation(seekerLocation);
                    setVisible(true);
            }
        }
    }

    public boolean isSeekRequested() {
        return mbSeekRequested;
    }

    public String getText() {
        return jtfText.getText();
    }
}
