/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.sql.Statement;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import sba.lib.db.DDbDatabase;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiClient {

    public JFrame getFrame();
    public JTabbedPane getTabbedPane();
    public DDbDatabase getSysDatabase();
    public Statement getSysStatement();

    public DGuiSession getSession();
    public DGuiDatePicker getDatePicker();
    public DGuiDateRangePicker getDateRangePicker();
    public DGuiYearPicker getYearPicker();
    public DGuiYearMonthPicker getYearMonthPicker();
    public JFileChooser getFileChooser();
    public ImageIcon getImageIcon(final int icon);
    public DGuiUserGui readUserGui(final int[] key);
    public DGuiUserGui saveUserGui(final int[] key, final String gui);
    public HashMap<String, Object> createReportParams();
    public String getTableCompany();
    public String getTableUser();
    public String getAppName();
    public String getAppRelease();
    public String getAppCopyright();
    public String getAppProvider();

    public void showMsgBoxError(final String msg);
    public void showMsgBoxWarning(final String msg);
    public void showMsgBoxInformation(final String msg);
    public int showMsgBoxConfirm(final String msg);
}
