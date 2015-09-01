/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.util.HashMap;
import java.util.Vector;
import javax.swing.JComboBox;
import sba.lib.db.DDbRegistry;

/**
 *
 * @author Sergio Flores
 */
public interface DGuiController {

    public DDbRegistry getRegistry(final int type);
    public void populateCatalogue(JComboBox comboBox, final int type, final int subtype, final DGuiParams params);
    public void showView(final int type, final int subtype, final DGuiParams params);
    public void showOptionPicker(final int type, final int subtype, final DGuiParams params, final DGuiField field);
    public void showForm(final int type, final int subtype, final DGuiParams params);
    public void printReport(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap);
    public void printReportNow(final int type, final int subtype, final DGuiParams params, final HashMap<String, Object> paramsMap, final boolean withPrintDialog);
    public Vector<DGuiItem> readItems(final int type, final int subtype, final DGuiParams params);
    public DDbRegistry readRegistry(final int type, final int[] pk);
    public DDbRegistry readRegistry(final int type, final int[] pk, final int mode);
    public int saveRegistry(final DDbRegistry registry);
    public int disableRegistry(final int type, final int[] pk);
    public int deleteRegistry(final int type, final int[] pk);
    public Object readField(final int type, final int[] pk, final int field);
    public int saveField(final int type, final int[] pk, final int field, final Object value);
}
