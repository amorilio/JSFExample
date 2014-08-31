package com.tutorial;

public class xmlContainerBean {
	static StringBuffer xmlDataString = new StringBuffer(); 
	public xmlContainerBean()
	{
		super();
	}
	public String getXmlDataString() {
		return xmlDataString.toString();
	}
	public void setXmlDataString(String xmlDataString) {
		xmlContainerBean.xmlDataString.append(xmlDataString);
	}
}
