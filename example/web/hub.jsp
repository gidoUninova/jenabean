<%@ include file="header.jsp" %>
<stripes:layout-render name="/layout/default.jsp">
<stripes:layout-component name="contents">


<c:forEach items="${actionBean.posts}" var="row" varStatus="loop">
<div class="entry">
<h2>${row.title}</h2> 
<span>${row.createdAt} - ${row.author.screenName}</span> 
${row.content} 
<br/>
</div>
</c:forEach>

</stripes:layout-component>
</stripes:layout-render>
