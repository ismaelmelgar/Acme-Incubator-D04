<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="anonymous.notice.list.label.creation" path="creation" width="15%"/>
	<acme:list-column code="anonymous.notice.list.label.deadline" path="deadline" width="15%"/>
	<acme:list-column code="anonymous.notice.list.label.title" path="title" width="70%"/>

</acme:list>