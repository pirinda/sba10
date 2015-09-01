/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package sba.lib.xml;

import sba.lib.DLibUtils;

/**
 *
 * @author Sergio Flores
 */
public class DXmlAttribute implements java.io.Serializable {

    protected String msName;
    protected Object moValue;

    public DXmlAttribute(String name) {
        this(name, null);
    }

    public DXmlAttribute(String name, Object value) {
        msName = name;
        moValue = value;
    }

    public void setName(String s) { msName = s; }
    public void setValue(Object o) { moValue = o; }

    public String getName() { return msName; }
    public Object getValue() { return moValue; }

    public String getXmlString() {
        return msName + "=\"" + DLibUtils.textToXml(moValue.toString()) + "\"";
    }
}
