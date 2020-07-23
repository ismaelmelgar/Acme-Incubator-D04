
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
	<acme:form-textbox code="administrator.inquirie.label.title" path="title"/>
	<jstl:if test = "${command != 'create' }">
		<acme:form-moment
			code="administrator.inquirie.label.creationMoment"
			path="creationMoment"
			readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.inquirie.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.inquirie.label.description" path="description"/>
	<acme:form-money code="administrator.inquirie.label.minMoney" path="minMoney"/>
	<acme:form-money code="administrator.inquirie.label.maxMoney" path="maxMoney"/>
	<acme:form-textbox code="administrator.inquirie.label.email" path="email"/>  

	<acme:form-submit test="${command == 'show' }"
		code="administrator.inquirie.button.update"
		action="/administrator/inquirie/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.inquirie.button.delete"
		action="/administrator/inquirie/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.inquirie.button.create"
		action="/administrator/inquirie/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.inquirie.button.update"
		action="/administrator/inquirie/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.inquirie.button.delete"
		action="/administrator/inquirie/delete"/>		
	
	<acme:form-return code="administrator.inquirie.form.button.return"/>
	
</acme:form>