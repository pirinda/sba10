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
public class DXmlFilter extends DXmlElement {

    public static final String NAME = "Filter";
    public static final String ATT_FILTER_TYPE = "filterType";
    public static final String ATT_DATA_TYPE = "dataType";
    public static final String ATT_VALUE = "value";

    protected DXmlAttribute moType;
    protected DXmlAttribute moDataType;
    protected DXmlAttribute moValue;

    public DXmlFilter() {
        super(NAME);

        moType = new DXmlAttribute(ATT_FILTER_TYPE);
        moDataType = new DXmlAttribute(ATT_DATA_TYPE);
        moValue = new DXmlAttribute(ATT_VALUE);

        mvXmlAttributes.add(moType);
        mvXmlAttributes.add(moDataType);
        mvXmlAttributes.add(moValue);
    }
}
