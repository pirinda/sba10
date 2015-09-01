/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

/**
 *
 * @author Sergio Flores
 */
public class DGuiReport {

    protected String msFileName;
    protected String msReportTitle;

    public DGuiReport(String fileName, String reportTitle) {
        msFileName = fileName;
        msReportTitle = reportTitle;
    }

    public void setFileName(String s) { msFileName = s; }
    public void setReportTitle(String s) { msReportTitle = s; }

    public String getFileName() { return msFileName; }
    public String getReportTitle() { return msReportTitle; }
}
