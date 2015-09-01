/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.xml;

import java.util.Vector;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sba.lib.DLibUtils;
import sba.lib.grid.DGridConsts;
import sba.lib.xml.DXmlDocument;
import sba.lib.xml.DXmlUtils;

/**
 *
 * @author Sergio Flores
 */
public class DXmlGridXml extends DXmlDocument {

    public static final String NAME = "Grid";

    private int mnGridPaneType;

    /**
     * @param gridPaneType Constant defined in lib.grid.DGridConsts
     */
    public DXmlGridXml(int gridPaneType) {
        super(NAME);

        mnGridPaneType = gridPaneType;
    }

    public void setGridPaneType(int n) { mnGridPaneType = n; }

    public int getGridPaneType() { return mnGridPaneType; }

    @Override
    public void processXml(String xml) throws Exception {
        Document document = null;
        NodeList nodeList = null;
        Vector<Node> childNodes = null;
        Vector<Node> grandChildNodes = null;
        NamedNodeMap namedNodeMap = null;

        clear();

        document = DXmlUtils.parseDocument(xml);
        nodeList = DXmlUtils.extractElements(document, DXmlGridXml.NAME);

        // Columns:

        childNodes = DXmlUtils.extractChildElements(nodeList.item(0), DXmlColumn.NAME);
        for (Node child : childNodes) {
            DXmlColumn column = mnGridPaneType == DGridConsts.GRID_PANE_VIEW ? new DXmlColumnView() : new DXmlColumnForm();
            namedNodeMap = child.getAttributes();

            column.getAttribute(DXmlColumn.ATT_COLUMN_TYPE).setValue(DLibUtils.parseInt(namedNodeMap.getNamedItem(DXmlColumn.ATT_COLUMN_TYPE).getNodeValue()));
            column.getAttribute(DXmlColumn.ATT_COLUMN_TITLE).setValue(namedNodeMap.getNamedItem(DXmlColumn.ATT_COLUMN_TITLE).getNodeValue());
            column.getAttribute(DXmlColumn.ATT_COLUMN_WIDTH).setValue(DLibUtils.parseInt(namedNodeMap.getNamedItem(DXmlColumn.ATT_COLUMN_WIDTH).getNodeValue()));
            column.getAttribute(DXmlColumn.ATT_FIELD_NAME).setValue(namedNodeMap.getNamedItem(DXmlColumn.ATT_FIELD_NAME).getNodeValue());

            if (mnGridPaneType == DGridConsts.GRID_PANE_VIEW) {
                ((DXmlColumnView) column).getAttribute(DXmlColumnView.ATT_IS_SUM_APPLYING).setValue(namedNodeMap.getNamedItem(DXmlColumnView.ATT_IS_SUM_APPLYING).getNodeValue().compareTo("" + true) == 0);
            }
            else {
                ((DXmlColumnForm) column).getAttribute(DXmlColumnForm.ATT_IS_EDITABLE).setValue(namedNodeMap.getNamedItem(DXmlColumnForm.ATT_IS_EDITABLE).getNodeValue().compareTo("" + true) == 0);
            }

            if (DXmlUtils.hasChildElement(child, DXmlRpnArgument.NAME)) {
                grandChildNodes = DXmlUtils.extractChildElements(child, DXmlRpnArgument.NAME);
                for (Node grandChild : grandChildNodes) {
                    DXmlRpnArgument rpnArgument = new DXmlRpnArgument();
                    namedNodeMap = grandChild.getAttributes();

                    rpnArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT_TYPE).setValue(namedNodeMap.getNamedItem(DXmlRpnArgument.ATT_ARGUMENT_TYPE).getNodeValue());
                    rpnArgument.getAttribute(DXmlRpnArgument.ATT_ARGUMENT).setValue(namedNodeMap.getNamedItem(DXmlRpnArgument.ATT_ARGUMENT).getNodeValue());

                    column.getXmlElements().add(rpnArgument);
                }
            }

            mvXmlElements.add(column);
        }

        // Sort keys:

        childNodes = DXmlUtils.extractChildElements(nodeList.item(0), DXmlSortKey.NAME);
        for (Node node : childNodes) {
            DXmlSortKey sortKey = new DXmlSortKey();
            namedNodeMap = node.getAttributes();

            sortKey.getAttribute(DXmlSortKey.ATT_COLUMN).setValue(DLibUtils.parseInt(namedNodeMap.getNamedItem(DXmlSortKey.ATT_COLUMN).getNodeValue()));
            sortKey.getAttribute(DXmlSortKey.ATT_SORT_ORDER).setValue(namedNodeMap.getNamedItem(DXmlSortKey.ATT_SORT_ORDER).getNodeValue());

            mvXmlElements.add(sortKey);
        }
    }
}
