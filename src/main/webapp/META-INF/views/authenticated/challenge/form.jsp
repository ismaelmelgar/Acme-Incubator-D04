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

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.label.title" path="title"/>
	<acme:form-textbox code="authenticated.challenge.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.challenge.label.description" path="description"/>
	<acme:form-textbox code="authenticated.challenge.label.rookieGoal" path="rookieGoal"/>
	<acme:form-textbox code="authenticated.challenge.label.rookieReward" path="rookieReward"/>
	<acme:form-textbox code="authenticated.challenge.label.averageGoal" path="averageGoal"/>
	<acme:form-textbox code="authenticated.challenge.label.averageReward" path="averageReward"/>
	<acme:form-textbox code="authenticated.challenge.label.expertGoal" path="expertGoal"/>
	<acme:form-textbox code="authenticated.challenge.label.expertReward" path="expertReward"/>
	

  	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>