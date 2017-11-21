/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package sba.lib.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sergio Flores
 */
public abstract class DXmlUtils {

    public static void writeXml(final String xml, final String filePath) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {
        BufferedWriter bw = null;

        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        bw.write(xml);
        bw.close();
    }

    public static String readXml(final String filePath) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {
        boolean firstLine = true;
        String line = "";
        String xml = "";
        BufferedReader br = null;

        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            else {
                if (firstLine) {
                    // skip odd characters at the begining, if any:
                    line = line.substring(line.indexOf("<"));
                    firstLine = false;
                }
                xml += line;
            }
        }

        br.close();

        return xml;
    }

    /**
     * Transforms XML with XSLT.
     * @param xml XML to transform.
     * @param xsltUrl XSLT's URL.
     * @return Transformed XML.
     * @throws Exception 
     */
    public static String transformXml(final String xml, final String xsltUrl) throws Exception {
        String xmlUtf8 = new String(xml.getBytes("UTF-8"));
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println(SXmlUtils.class.getName() + ":");
        System.out.println("XML : <" + xml + ">");
        System.out.println("XML : <" + xmlUtf8 + ">");
        System.out.println("XSLT URL : <" + xsltUrl + ">");
        */
        OutputStream outputStream = new ByteArrayOutputStream(xmlUtf8.length());
        
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("OutputStream instantiated!");
        */
        
        // load XSLT file from its URL:
        URL url = new URL(xsltUrl);
        
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("URL instantiated!");
        */
        
        // load XML:
        StreamSource streamSource = new StreamSource(new ByteArrayInputStream(xmlUtf8.getBytes("UTF-8")));
 
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("StreamSource instantiated!");
        */
        
        // create XSLT processor that will generate original string according to XSLT rules:
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(url.openStream()));
 
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("Transformer instantiated!");
        */
        
        // apply XSLT rules to XML, write result into output:
        transformer.transform(streamSource, new StreamResult(outputStream));
        
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("transformer.transform() invoked!");
        */
        
        /*  XXX added due to character set issue that breaks transformation of XML
        System.out.println("outputStream.toString(): <" + outputStream.toString() + ">");
        */
        
        return outputStream.toString();
    }
    
    public static Document parseDocument(final String xml) throws ParserConfigurationException, SAXException, IOException, Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    }

    public static boolean hasChildElement(final Node node, final String name) {
        boolean has = false;
        NodeList nodeList = node.getChildNodes();

        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().compareTo(name) == 0) {
                    has = true;
                    break;
                }
            }
        }

        return has;
    }

    public static NodeList extractElements(final Document document, final String name) throws Exception {
        NodeList nodeList = document.getElementsByTagName(name);

        if (nodeList == null) {
            throw new Exception("XML elements '" + name + "' not found!");
        }

        return nodeList;
    }

    public static Vector<Node> extractChildElements(final Node node, final String name) throws Exception {
        Vector<Node> children = new Vector<Node>();
        NodeList nodeList = node.getChildNodes();

        if (nodeList == null) {
            throw new Exception("XML children elements '" + name + "' not found!");
        }
        else {
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().compareTo(name) == 0) {
                    children.add(nodeList.item(i));
                }
            }

            if (children.isEmpty()) {
                throw new Exception("XML children elements '" + name + "' not found!");
            }
        }

        return children;
    }

    public static String extractAttributeValue(final NamedNodeMap namedNodeMap, final String name, final boolean mandatory) throws Exception {
        String value = "";
        Node node = namedNodeMap.getNamedItem(name);

        if (node == null) {
            if (mandatory) {
                throw new Exception("XML element attribute '" + name + "' not found!");
            }
        }
        else {
            value = node.getNodeValue();
        }

        return value;
    }
}
