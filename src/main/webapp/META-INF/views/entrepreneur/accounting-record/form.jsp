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
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.title" path="title"/>
	<acme:form-moment code="entrepreneur.accounting-record.form.label.creation" path="creation"/>
	<acme:form-moment code="entrepreneur.accounting-record.form.label.body" path="body"/>
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.investmentRound" path="investmentRound.ticker"/>
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.bookkeeper" path="bookkeeper.identity.fullName"/>
	<acme:form-checkbox code="entrepreneur.accounting-record.form.label.status" path="status"/>
	
	<acme:form-return code="entrepreneur.accounting-record.form.button.return"/>
</acme:form>