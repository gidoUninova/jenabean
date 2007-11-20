<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">
<stripes:layout-component name="contents">

<c:forEach items="${actionBean.posts}" var="row" varStatus="loop">
<div class="entry">
<h2><a href="?p=${row.id}">${row.title}</a></h2> 
<span>${row.createdAt} : </span>
${row.content}<br/>
- ${row.author.screenName} ${row.commentsCount} comments | Filed Under:
<c:forEach items="${row.tags}" var="tag" varStatus="loop">${tag.name}, </c:forEach>
<br/>

</div>
</c:forEach>

</stripes:layout-component>
</stripes:layout-render>
