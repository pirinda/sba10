/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.grid.xml;

import sba.lib.xml.DXmlAttribute;

/**
 *
 * @author Sergio Flores
 */
public class DXmlColumnForm extends DXmlColumn {

    public static final String ATT_IS_EDITABLE = "isEditable";

    protected DXmlAttribute moIsEditable;

    public DXmlColumnForm() {
        moIsEditable = new DXmlAttribute(ATT_IS_EDITABLE);

        mvXmlAttributes.add(moIsEditable);
    }
}
