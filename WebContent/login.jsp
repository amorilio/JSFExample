<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@taglib
	uri="http://java.sun.com/jsf/core" prefix="f"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="refresh" content="2000">
	<title>JSF Demo</title>
	<f:loadBundle basename="com.tutorial.messages" var="msg"/>
</head>

<body>
<f:view>
	<h:form>		
		<h:panelGrid border="1" columns="2">
			<h:outputText value="#{msg.name}"></h:outputText>
			<h:inputText value="#{loginBean.name}"></h:inputText>
			<h:outputText value="#{msg.password}"></h:outputText>
			<h:inputSecret value="#{loginBean.password}">
				<f:validator validatorId="com.tutorial.validatePassword"></f:validator >
			</h:inputSecret>
		</h:panelGrid>
		<h:commandButton value="Login" action="login"></h:commandButton>		
		<br>
		<h:inputTextarea value="#{logBean.logBean}" style="height: 179px; width: 614px; background-color: #00FFFF">			
		</h:inputTextarea>
		<br>
		<h:commandButton value="Read">
			<f:actionListener type="com.tutorial.xmlReaderBean" />
		</h:commandButton><br>
		<h:inputTextarea value="#{xmlContainerBean.xmlDataString}" style="height: 258px; width: 615px; border-top-style: solid">
		</h:inputTextarea>
	</h:form>
</f:view>
</body>
</html>