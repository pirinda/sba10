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
public class DXmlRpnArgument extends DXmlElement {

    public static final String NAME = "RpnArgument";
    public static final String ATT_ARGUMENT_TYPE = "argumentType";
    public static final String ATT_ARGUMENT = "argument";

    protected DXmlAttribute moArgumentType;
    protected DXmlAttribute moArgument;

    public DXmlRpnArgument() {
        super(NAME);

        moArgumentType = new DXmlAttribute(ATT_ARGUMENT_TYPE);
        moArgument = new DXmlAttribute(ATT_ARGUMENT);

        mvXmlAttributes.add(moArgumentType);
        mvXmlAttributes.add(moArgument);
    }
}
