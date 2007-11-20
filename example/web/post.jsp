<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">

<stripes:layout-component name="html-head">
<!-- tinyMCE -->
<script language="javascript" type="text/javascript" src="../tiny_mce/tiny_mce.js"></script>
<script language="javascript" type="text/javascript">
	// Notice: The simple theme does not use all options some of them are limited to the advanced theme
	tinyMCE.init({
		mode : "textareas",
		theme : "simple"
	});
</script>
<!-- /tinyMCE -->
</stripes:layout-component>

<stripes:layout-component name="contents">
<stripes:form action="/Post.action" method="post">
<stripes:errors/>
<label>Title:</label>
<stripes:text name="post.title" class="text" size="60"/><br/>
<label>Content:</label>
<stripes:textarea name="post.content" class="text" rows="15" cols="60" /><br/>
<stripes:submit name="post" value="post" />
<stripes:submit name="addTag" value="add tag" />

<c:forEach items="${actionBean.tags}" var="tag" varStatus="loop">${tag.name} |
  <stripes:hidden name="tags[${loop.index}].name" value="tag.name"/>
  <c:set var="newIndex" value="${loop.index + 1}" scope="page"/> 
</c:forEach>
<stripes:text name="tags[${newIndex}]" class="text" size="15"/>

<stripes:hidden name="post.id"/>
</stripes:form>

</stripes:layout-component>
</stripes:layout-render>