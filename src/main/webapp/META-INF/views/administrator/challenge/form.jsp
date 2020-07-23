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
	<acme:form-textbox code="administrator.challenge.label.title" path="title"/>
	<acme:form-textbox code="administrator.challenge.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.challenge.label.description" path="description"/>
	<acme:form-textbox code="administrator.challenge.label.rookieGoal" path="rookieGoal"/>
	<acme:form-textbox code="administrator.challenge.label.rookieReward" path="rookieReward"/>
	<acme:form-textbox code="administrator.challenge.label.averageGoal" path="averageGoal"/>
	<acme:form-textbox code="administrator.challenge.label.averageReward" path="averageReward"/>
	<acme:form-textbox code="administrator.challenge.label.expertGoal" path="expertGoal"/>
	<acme:form-textbox code="administrator.challenge.label.expertReward" path="expertReward"/>
	
	<acme:form-submit test="${command == 'show' }"
		code="administrator.challenge.button.update"
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.challenge.button.delete"
		action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.challenge.button.create"
		action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.challenge.button.update"
		action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.challenge.button.delete"
		action="/administrator/challenge/delete"/>	

  	<acme:form-return code="administrator.challenge.button.return"/>
</acme:form>