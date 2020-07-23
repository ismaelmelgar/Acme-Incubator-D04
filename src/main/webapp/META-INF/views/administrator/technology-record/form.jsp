
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
	<acme:form-textbox code="administrator.technologyRecord.label.title" path="title"/>
	<acme:form-textbox code="administrator.technologyRecord.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.technologyRecord.label.inventor" path="inventor"/>
	<acme:form-textarea code="administrator.technologyRecord.label.description" path="description"/>
	<acme:form-textbox code="administrator.technologyRecord.label.web" path="web"/>
	<acme:form-textbox code="administrator.technologyRecord.label.email" path="email"/>
	<acme:form-checkbox code="administrator.technologyRecord.label.indication" path="indication"/>
	<acme:form-textbox code="administrator.technologyRecord.label.star" path="star"/>
	
	<acme:form-submit test="${command == 'show' }"
		code="administrator.technologyRecord.button.update"
		action="/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.technologyRecord.button.delete"
		action="/administrator/technology-record/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.technologyRecord.button.create"
		action="/administrator/technology-record/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.technologyRecord.button.update"
		action="/administrator/technology-record/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.technologyRecord.button.delete"
		action="/administrator/technology-record/delete"/>	
	
	<acme:form-return code="administrator.technologyRecord.button.return"/>
</acme:form>