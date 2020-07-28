<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="investor.message.form.label.title" path="title" width="20%"/>
	<acme:list-column code="investor.message.form.label.creation" path="creation" width="60%"/>
</acme:list>