
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
	<acme:form-textbox code="bookkeeper.investmentRound.label.ticker" path="ticker" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.creation" path="creationMoment" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.round" path="round" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.title" path="title" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.description" path="description" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.amountMoney" path="amountMoney" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.moreInfo" path="moreInfo" />
	<acme:form-textbox code="bookkeeper.investmentRound.label.entrepreneur" path="entrepreneur.identity.fullName" />

	<acme:form-submit test="${numAR > 0}" code="bookkeeper.investmentRound.form.button.accountingRecord"
		action="/bookkeeper/accounting-record/list?investmentRoundId=${id}" method="get" />
	<acme:form-return code="bookkeeper.investmentRound.button.return" />
</acme:form>