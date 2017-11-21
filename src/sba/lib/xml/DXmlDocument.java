/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package sba.lib.xml;

import java.util.Vector;

/**
 *
 * @author Sergio Flores
 */
public abstract class DXmlDocument extends DXmlElement {

    protected boolean mbAddDefaultHeader;
    protected String msCustomHeader;
    protected Vector<DXmlElement> mvXmlElements;

    public DXmlDocument(String name) {
        this(name, true);
    }

    public DXmlDocument(String name, boolean addDefaultHeader) {
        super(name);
        mbAddDefaultHeader = addDefaultHeader;
        msCustomHeader = "";
        mvXmlElements = new Vector<DXmlElement>();
    }

    public void setCustomHeader(String s) { msCustomHeader = s; }

    public String getCustomHeader() { return msCustomHeader; }
    public Vector<DXmlElement> getXmlElements() { return mvXmlElements; }

    public abstract void processXml(final String xml) throws Exception;

    @Override
    public void clear() {
        super.clear();
        mvXmlElements.clear();
    }

    @Override
    public String getXmlString() {
        String aux = "";
        String xml = "";

        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\n";

        if (mbAddDefaultHeader) {
            xml += "<!-- Copyright 2010-2015 Sergio Abraham Flores Gutiérrez. All rights reserved. -->\n";
        }

        xml += "<" + msName + (!mbAddDefaultHeader ? "" : " xmlns=\"http://www.mysba.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
        xml += msCustomHeader.isEmpty() ? "" : " " + msCustomHeader;

        for (DXmlAttribute attribute : mvXmlAttributes) {
            aux = attribute.getXmlString();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        for (DXmlElement element : mvXmlElements) {
            aux = element.getXmlString();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }
}
