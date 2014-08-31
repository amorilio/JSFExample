package com.tutorial;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

public class xmlReaderBean implements ActionListener{

	StringBuffer xmlString = new StringBuffer("");

	public class Echo extends DefaultHandler2 {
		int numOfTabs = 0;
        public Echo () {
        	System.out.println("Echo Constructor\n\n");
        }        
        public void startElement(	String namespaceURI,
        							String sName, // simple name
        							String qName, // qualified name
        							Attributes attrs) throws SAXException
        {
	        	String eName = sName; 	// element name
	        	for (int i= 0; i<numOfTabs; i++)
	        		xmlString.append("\t");
	        	if ("".equals(eName)) 
	        		eName = qName; 		// not namespace-aware
	        	xmlString.append("<"+eName);
	        	if (attrs != null) {
	        		for (int i = 0; i < attrs.getLength(); i++) {
	        			String aName = attrs.getLocalName(i); // Attr name
	        			if ("".equals(aName)) aName = attrs.getQName(i);
	        			xmlString.append(" ");
	        			xmlString.append(aName+"=\""+attrs.getValue(i)+"\"");
	        		}
	        	}
	        	xmlString.append(">");
	        	xmlString.append("\n");
	        	numOfTabs++;
        }
        
        public void endElement(	String namespaceURI,
        						String sName, // simple name
        						String qName // qualified name
        						) throws SAXException
        {
	        	numOfTabs--;
	        	for (int i= 0; i<numOfTabs; i++)
	        		xmlString.append("\t");
	        	String eName = sName; // element name
	        	if ("".equals(eName)) eName = qName; // not namespace-aware
	        		xmlString.append("</"+eName+">");
	        	xmlString.append("\n");
       	}
        
		public void characters (char buf [], int offset, int len) throws SAXException
		{	
		}
		public void processingInstruction (String target, String data) throws SAXException
		{
		}
	}
	
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		try {
			DefaultHandler2 handler = new Echo();
			SAXParser xmlParser = SAXParserFactory.newInstance().newSAXParser();
			xmlParser.parse("c:/Documents and Settings/ilia/Desktop/Settings.xml",handler);
			
			xmlContainerBean.xmlDataString.append(xmlString);
			
        	System.out.println(xmlString.toString());
		} catch (Exception e) {}
	}
	public String getXmlString() {
		return xmlString.toString();
	}
	public void setXmlString(String xmlString) {
		this.xmlString.append("\n"+xmlString);
	}
}
