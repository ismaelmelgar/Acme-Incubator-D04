
<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.technologyRecord.label.title" path="title"/>
	<acme:form-textbox code="authenticated.technologyRecord.label.sector" path="sector"/>
	<acme:form-textbox code="authenticated.technologyRecord.label.inventor" path="inventor"/>
	<acme:form-textarea code="authenticated.technologyRecord.label.description" path="description"/>
	<acme:form-textbox code="authenticated.technologyRecord.label.web" path="web"/>
	<acme:form-textbox code="authenticated.technologyRecord.label.email" path="email"/>
	<acme:form-checkbox code="authenticated.technologyRecord.label.indication" path="indication"/>
	<acme:form-textbox code="authenticated.technologyRecord.label.star" path="star"/>
	
	<acme:form-return code="authenticated.technologyRecord.form.button.return"/>
</acme:form>