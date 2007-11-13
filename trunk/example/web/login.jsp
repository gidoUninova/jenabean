<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">
<stripes:layout-component name="contents">
<stripes:form action="/Login.action" method="post">
<stripes:errors/>
<label for="fScreenName">Screen name:</label>
<stripes:text name="screenName" id="fScreenName" class="text"/>

<label for="fPassword">Password:</label>
<stripes:password name="password" id="fPassword" class="text"/>
<label/>
<stripes:submit name="login" value="login"/> <stripes:link beanclass="action.JoinAction">create account...</stripes:link>	
</stripes:form>
</stripes:layout-component>
</stripes:layout-render>
