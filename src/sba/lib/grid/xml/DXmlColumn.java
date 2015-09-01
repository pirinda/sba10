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
public abstract class DXmlColumn extends DXmlElement {

    public static final String NAME = "Column";
    public static final String ATT_COLUMN_TYPE = "columnType";
    public static final String ATT_COLUMN_TITLE = "columnTitle";
    public static final String ATT_COLUMN_WIDTH = "columnWidth";
    public static final String ATT_FIELD_NAME = "fieldName";

    protected DXmlAttribute moColumnType;
    protected DXmlAttribute moColumnTitle;
    protected DXmlAttribute moColumnWidth;
    protected DXmlAttribute moFieldName;

    public DXmlColumn() {
        super(NAME);

        moColumnType = new DXmlAttribute(ATT_COLUMN_TYPE);
        moColumnTitle = new DXmlAttribute(ATT_COLUMN_TITLE);
        moColumnWidth = new DXmlAttribute(ATT_COLUMN_WIDTH);
        moFieldName = new DXmlAttribute(ATT_FIELD_NAME);

        mvXmlAttributes.add(moColumnType);
        mvXmlAttributes.add(moColumnTitle);
        mvXmlAttributes.add(moColumnWidth);
        mvXmlAttributes.add(moFieldName);
    }
}
