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
public class DXmlElement implements java.io.Serializable {

    protected String msName;
    protected Vector<DXmlAttribute> mvXmlAttributes;
    protected Vector<DXmlElement> mvXmlElements;

    public DXmlElement(String name) {
        msName = name;
        mvXmlAttributes = new Vector<DXmlAttribute>();
        mvXmlElements = new Vector<DXmlElement>();
    }

    public void setName(String s) { msName = s; }

    public String getName() { return msName; }

    public Vector<DXmlAttribute> getXmlAttributes() { return mvXmlAttributes; }
    public Vector<DXmlElement> getXmlElements() { return mvXmlElements; }

    public void clear() {
        mvXmlAttributes.clear();
        mvXmlElements.clear();
    }

    public String getXmlString() {
        String aux = "";
        String xml = "<" + msName;

        for (DXmlAttribute attribute : mvXmlAttributes) {
            aux = attribute.getXmlString();
            xml += aux.length() == 0 ? "" : " " + aux;
        }

        if (mvXmlElements.isEmpty()) {
            xml += "/>";
        }
        else {
            xml += ">";

            for (DXmlElement element : mvXmlElements) {
                aux = element.getXmlString();
                xml += aux.length() == 0 ? "" : "\n" + aux;
            }

            xml += "\n</" + msName + ">";
        }

        return xml;
    }

    public DXmlAttribute getAttribute(final String name) {
        DXmlAttribute attribute = null;

        for (DXmlAttribute attributeAux : mvXmlAttributes) {
            if (name.compareTo(attributeAux.getName()) == 0) {
                attribute = attributeAux;
                break;
            }
        }

        return attribute;
    }

    public Vector<DXmlElement> getElements(final String name) {
        Vector<DXmlElement> elements = new Vector<DXmlElement>();

        for (DXmlElement element : mvXmlElements) {
            if (name.compareTo(element.getName()) == 0) {
                elements.add(element);
            }
        }

        return elements;
    }
}
