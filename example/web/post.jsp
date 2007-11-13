<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">
<stripes:layout-component name="contents">

<stripes:form action="/Post.action" method="post">
<stripes:errors/>
<label>Title:</label>
<stripes:text name="post.title" class="text" size="60"/>
<label>Content:</label>
<stripes:textarea name="post.content" class="text" rows="15" cols="60" />
<label></label>
<stripes:submit name="post" value="post" />		
</stripes:form>

</stripes:layout-component>
</stripes:layout-render>
