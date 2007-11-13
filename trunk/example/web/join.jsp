<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">
<stripes:layout-component name="contents">

<stripes:form action="/Join.action" method="post">
<stripes:errors/>
<label for="fScreenName">Screen name:</label>
<stripes:text name="screenName" id="fScreenName" class="text"/>
<label for="fEmail">Email:</label>
<stripes:text name="email" id="fEmail" class="text"/>

<label for="fPassword">Password:</label>
<stripes:password name="password" id="fPassword" class="text"/>
<label for="fVerify">Verify:</label>
<stripes:password name="verify" id="fVerify" class="text"/>
<stripes:submit name="join" value="join"/>		
</stripes:form>

</stripes:layout-component>
</stripes:layout-render>
