/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.xml;

import sba.lib.xml.DXmlAttribute;
import sba.lib.xml.DXmlElement;

/**
 *
 * @author Sergio Flores
 */
public class DXmlSortKey extends DXmlElement {

    public static final String NAME = "SortKey";
    public static final String ATT_COLUMN = "column";
    public static final String ATT_SORT_ORDER = "sortOrder";

    protected DXmlAttribute moColumn;
    protected DXmlAttribute moSortOrder;

    public DXmlSortKey() {
        super(NAME);

        moColumn = new DXmlAttribute(ATT_COLUMN);
        moSortOrder = new DXmlAttribute(ATT_SORT_ORDER);

        mvXmlAttributes.add(moColumn);
        mvXmlAttributes.add(moSortOrder);
    }
}
