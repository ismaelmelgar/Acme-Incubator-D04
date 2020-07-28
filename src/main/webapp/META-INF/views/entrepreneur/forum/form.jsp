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
	<acme:form-textbox code="entrepreneur.forum.form.label.title" path="title"/>
	<acme:form-textbox code="entrepreneur.forum.form.label.ticker" path="investmentRound.ticker"/>

	<acme:form-submit code="entrepreneur.forum.form.buttom.message" action="/entrepreneur/message/list-mine?forumid=${id}"  method="get"/>
	<acme:form-return code="entrepreneur.forum.form.button.return"/>
</acme:form>