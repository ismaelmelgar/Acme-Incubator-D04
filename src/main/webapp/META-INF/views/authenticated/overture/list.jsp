<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.overture.form.label.title" path="title"  width="10%"/>
	<acme:list-column code="authenticated.overture.form.label.description" path="description"  width="30%"/>
</acme:list>