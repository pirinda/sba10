/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.gui.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sba.lib.xml.DXmlAttribute;
import sba.lib.xml.DXmlDocument;
import sba.lib.xml.DXmlUtils;

/**
 *
 * @author Sergio Flores
 */
public class DUtilConfigXml extends DXmlDocument {

    public static final String CONFIG = "Params";
    public static final String ATT_DB_HOST = "db_host";
    public static final String ATT_DB_PORT = "db_port";
    public static final String ATT_DB_NAME = "db_name";
    public static final String ATT_USR_NAME = "usr_name";
    public static final String ATT_USR_PSWD = "usr_pswd";
    public static final String ATT_TERMINAL = "terminal";
    public static final String ATT_TIME_ZONE = "time_zone";

    protected DXmlAttribute moAttributeDbHost;
    protected DXmlAttribute moAttributeDbPort;
    protected DXmlAttribute moAttributeDbName;
    protected DXmlAttribute moAttributeUserName;
    protected DXmlAttribute moAttributeUserPassword;
    protected DXmlAttribute moAttributeTerminal;
    protected DXmlAttribute moAttributeTimeZone;

    public DUtilConfigXml() {
        super(CONFIG);

        moAttributeDbHost = new DXmlAttribute(ATT_DB_HOST);
        moAttributeDbPort = new DXmlAttribute(ATT_DB_PORT);
        moAttributeDbName = new DXmlAttribute(ATT_DB_NAME);
        moAttributeUserName = new DXmlAttribute(ATT_USR_NAME);
        moAttributeUserPassword = new DXmlAttribute(ATT_USR_PSWD);
        moAttributeTerminal = new DXmlAttribute(ATT_TERMINAL);
        moAttributeTimeZone = new DXmlAttribute(ATT_TIME_ZONE);

        mvXmlAttributes.add(moAttributeDbHost);
        mvXmlAttributes.add(moAttributeDbPort);
        mvXmlAttributes.add(moAttributeDbName);
        mvXmlAttributes.add(moAttributeUserName);
        mvXmlAttributes.add(moAttributeUserPassword);
        mvXmlAttributes.add(moAttributeTerminal);
        mvXmlAttributes.add(moAttributeTimeZone);
    }

    @Override
    public void processXml(String xml) throws Exception {
        Document document = null;
        Node node = null;
        NodeList nodeList = null;
        NamedNodeMap namedNodeMap = null;

        document = DXmlUtils.parseDocument(xml);
        nodeList = DXmlUtils.extractElements(document, DUtilConfigXml.CONFIG);
        node = nodeList.item(0);
        namedNodeMap = node.getAttributes();

        moAttributeDbHost.setValue(namedNodeMap.getNamedItem(ATT_DB_HOST).getNodeValue());
        moAttributeDbPort.setValue(namedNodeMap.getNamedItem(ATT_DB_PORT).getNodeValue());
        moAttributeDbName.setValue(namedNodeMap.getNamedItem(ATT_DB_NAME).getNodeValue());
        moAttributeUserName.setValue(namedNodeMap.getNamedItem(ATT_USR_NAME).getNodeValue());
        moAttributeUserPassword.setValue(namedNodeMap.getNamedItem(ATT_USR_PSWD).getNodeValue());
        moAttributeTerminal.setValue(namedNodeMap.getNamedItem(ATT_TERMINAL).getNodeValue());
        moAttributeTimeZone.setValue(namedNodeMap.getNamedItem(ATT_TIME_ZONE).getNodeValue());
    }
}
