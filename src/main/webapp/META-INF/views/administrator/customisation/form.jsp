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
	<acme:form-textarea code="administrator.customisation.label.spamWords" path="spamWords"/>
	<acme:form-textbox code="administrator.customisation.label.threshold" path="threshold"/>
	<acme:form-textarea code="administrator.customisation.label.activitySectors" path="activitySectors"/>


	<acme:form-submit test="${command == 'show' }"
		code="administrator.customisation.button.update"
		action="/administrator/customisation/update"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.customisation.button.update"
		action="/administrator/customisation/update"/>

  	<acme:form-return code="administrator.customisation.button.return"/>
</acme:form>