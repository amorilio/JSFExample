<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome Page</title>
	<f:loadBundle basename="com.tutorial.messages" var="msg"/>
</head>
<body>
	<f:view>
		<h:form>
			<h:outputLabel value="#{msg.welcome} #{loginBean.name}"> </h:outputLabel>
		</h:form>
	</f:view>
</body>
</html>