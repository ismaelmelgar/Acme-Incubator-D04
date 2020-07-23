<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<%--------------------Anonymous--------------------%>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.melgar" action="https://www.youtube.com" />
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.minuesa" action="https://www.hobbyconsolas.com" />
			<!--  Bulletins -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.bulletin.uno.melgarBulletin.list" action="/anonymous/melgarBulletin/list" />
			<acme:menu-suboption code="master.menu.bulletin.uno.melgarBulletin.form" action="/anonymous/melgarBulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.bulletin.dos.minuesaBulletin.list" action="/anonymous/minuesaBulletin/list" />
			<acme:menu-suboption code="master.menu.bulletin.dos.minuesaBulletin.form" action="/anonymous/minuesaBulletin/create" />
			<!--  Notices -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.notices.list" action="/anonymous/notice/list" />
			<!--  Technology Records -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.technologyRecords.list" action="/anonymous/technology-record/list" />
			<!--  Tool Records -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.toolRecords.list" action="/anonymous/tool-record/list" />
		</acme:menu-option>

		<%--------------------Authenticated--------------------%>
		<acme:menu-option code="master.menu.anonymous" access="isAuthenticated()">
			<!--  Notices -->
			<acme:menu-suboption code="master.menu.notices.list" action="/authenticated/notice/list" />
			<!--  Technology Records -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.technologyRecords.list" action="/authenticated/technology-record/list" />
			<!--  Tool Records -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.toolRecords.list" action="/authenticated/tool-record/list" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<!--  Inquires -->
			<acme:menu-suboption code="master.menu.inquiries.list" action="/authenticated/inquirie/list" />
			<!--  Overtures -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.overtures.list" action="/authenticated/overture/list" />
			<!--  Challenges -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.challenges.list" action="/authenticated/challenge/list" />
		</acme:menu-option>

		<%--------------------Administrator--------------------%>
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list" />
			<acme:menu-separator />
			<!--  Notices -->
			<acme:menu-suboption code="master.menu.notices.list" action="/administrator/notice/list" />
			<acme:menu-suboption code="master.menu.administrator.notices.create" action="/administrator/notice/create" />
			<!--  Customisation -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.customisation.list" action="/administrator/customisation/list" />
			<!--  Inquirie -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.inquiries.list" action="/administrator/inquirie/list" />
			<acme:menu-suboption code="master.menu.administrator.inquiries.create" action="/administrator/inquirie/create" />
			<!--  Challenge -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.challenges.list" action="/administrator/challenge/list" />
			<acme:menu-suboption code="master.menu.administrator.challenges.create" action="/administrator/challenge/create" />
			<!--  Technology Record -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.technologyRecords.list" action="/administrator/technology-record/list" />
			<acme:menu-suboption code="master.menu.administrator.technologyRecords.create" action="/administrator/technology-record/create" />
			<!--  Tool Record -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.toolRecords.list" action="/administrator/tool-record/list" />
			<acme:menu-suboption code="master.menu.administrator.toolRecords.create" action="/administrator/tool-record/create" />
			<!--  Overture -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.overtures.list" action="/administrator/overture/list" />
			<acme:menu-suboption code="master.menu.administrator.overtures.create" action="/administrator/overture/create" />
			<!--  Shutdown -->
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
		</acme:menu-option>

		<%--------------------Provider--------------------%>
		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>

		<%--------------------Consumer--------------------%>
		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>

