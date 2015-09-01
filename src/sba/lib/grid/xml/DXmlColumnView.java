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
public class DXmlColumnView extends DXmlColumn {

    public static final String ATT_IS_SUM_APPLYING = "isSumApplying";

    protected DXmlAttribute moIsSumApplying;

    public DXmlColumnView() {
        moIsSumApplying = new DXmlAttribute(ATT_IS_SUM_APPLYING);

        mvXmlAttributes.add(moIsSumApplying);
    }
}
