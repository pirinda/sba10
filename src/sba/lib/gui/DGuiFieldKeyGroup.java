/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.JComboBox;
import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public class DGuiFieldKeyGroup implements ItemListener {

    private DGuiClient miClient;
    private boolean mbAdjustingFieldKeys;
    private Vector<DGuiFieldKey> mvFieldKeys;
    private Vector<DFieldKeyConfig> mvFieldKeyConfigs;
    private Vector<Vector<DGuiItem>> mvItemVectors;

    /**
     * Creates new <code>DGuiFieldKeyGroup</code> object.
     * To use key groups objects:
     * <pre>
     * 1. Invoke <code>initGroup()</code> method, it clears all data.
     * 2. To add GUI combobox controls invoke <code>addFieldKey()</code> method.
     * 3. Invoke <code>populateCatalogues()</code> method.
     * </pre>
     * To use key groups objects:
     * <pre>
     * 1. To reset key group invoke <code>resetGroup()</code> method.
     * </pre>
     */
    public DGuiFieldKeyGroup(DGuiClient client) {
        miClient = client;
        mbAdjustingFieldKeys = false;
        mvFieldKeys = new Vector<DGuiFieldKey>();
        mvFieldKeyConfigs = new Vector<DFieldKeyConfig>();
        mvItemVectors = new Vector<Vector<DGuiItem>>();
    }

    @SuppressWarnings("unchecked")
    private void adjustFieldKeys(final ItemEvent event) {
        int[] key = null;
        DGuiItem item = null;
        DGuiFieldKey fieldKeyChild = null;
        Vector<DGuiItem> childItems = null;
        JComboBox comboBox = null;
        JComboBox comboBoxChild = null;

        for (int i = 0; i < mvFieldKeys.size() - 1; i++) {     // last field key does not have child field keys
            comboBox = (JComboBox) mvFieldKeys.get(i).getComponent();

            if (comboBox == event.getSource()) {
                for (int j = i + 1; j < mvFieldKeys.size(); j++) {
                    fieldKeyChild = mvFieldKeys.get(j);
                    fieldKeyChild.setEnabled(false);
                    comboBoxChild = (JComboBox) fieldKeyChild.getComponent();
                    comboBoxChild.removeAllItems();
                }

                if (comboBox.getSelectedIndex() > 0) {
                    childItems = mvItemVectors.get(i + 1);
                    fieldKeyChild = mvFieldKeys.get(i + 1);
                    fieldKeyChild.setEnabled(true);
                    comboBoxChild = (JComboBox) fieldKeyChild.getComponent();
                    comboBoxChild.addItem(childItems.get(0));

                    key = ((DGuiItem) comboBox.getSelectedItem()).getPrimaryKey();
                    for (int j = 1; j < childItems.size(); j++) {   // first item allready added
                        item = childItems.get(j);
                        if (DLibUtils.compareKeys(key, item.getForeignKey())) {
                            comboBoxChild.addItem(item);
                        }
                    }

                    comboBoxChild.setSelectedIndex(0);
                }

                break;
            }
        }
    }

    /**
     * Clears all data in key group.
     */
    public void initGroup() {
        for (DGuiFieldKey fieldKey : mvFieldKeys) {
            ((JComboBox) fieldKey.getComponent()).removeItemListener(this);
        }

        mvFieldKeys.clear();
        mvFieldKeyConfigs.clear();
        mvItemVectors.clear();
    }

    public void addFieldKey(DGuiFieldKey fieldKey, final int type, final int subtype, final DGuiParams params) {
        mvFieldKeys.add(fieldKey);
        mvFieldKeyConfigs.add(new DFieldKeyConfig(type, subtype, params));
        ((JComboBox) fieldKey.getComponent()).addItemListener(this);
    }

    public void populateCatalogues() {
        DGuiFieldKey fieldKey = null;
        DFieldKeyConfig fieldKeyConfig = null;
        JComboBox comboBox = null;
        Vector<DGuiItem> items = null;

        mbAdjustingFieldKeys = true;

        mvItemVectors.clear();

        for (int i = 0; i < mvFieldKeys.size(); i++) {
            fieldKey = mvFieldKeys.get(i);
            fieldKeyConfig = mvFieldKeyConfigs.get(i);
            comboBox = (JComboBox) fieldKey.getComponent();
            items = new Vector<DGuiItem>();

            miClient.getSession().populateCatalogue(comboBox, fieldKeyConfig.Type, fieldKeyConfig.Subtype, fieldKeyConfig.Params);

            for (int j = 0; j < comboBox.getItemCount(); j++) {
                items.add((DGuiItem) comboBox.getItemAt(j));
            }

            mvItemVectors.add(items);
        }

        mbAdjustingFieldKeys = false;
    }

    /**
     * Resets key group by deselecting all data.
     */
    public void resetGroup() {
        JComboBox comboBox = null;

        mbAdjustingFieldKeys = true;

        if (mvFieldKeys.size() > 0) {
            comboBox = (JComboBox) mvFieldKeys.get(0).getComponent();
            if (comboBox.getSelectedIndex() != 0) {
                comboBox.setSelectedIndex(0);
            }

            adjustFieldKeys(new ItemEvent(comboBox, 0, comboBox.getSelectedItem(), ItemEvent.SELECTED));
        }

        mbAdjustingFieldKeys = false;
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (!mbAdjustingFieldKeys && event.getStateChange() == ItemEvent.SELECTED) {
            mbAdjustingFieldKeys = true;
            adjustFieldKeys(event);
            mbAdjustingFieldKeys = false;
        }
    }

    private class DFieldKeyConfig {
        public int Type;
        public int Subtype;
        public DGuiParams Params;

        public DFieldKeyConfig(int type, int subtype, DGuiParams params) {
            Type = type;
            Subtype = subtype;
            Params = params;
        }
    }
}
