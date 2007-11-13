<%@ include file="../header.jsp" %>
<stripes:layout-definition>
  <html>
    <head>
      <title>Layout Example</title>
      <link rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/style/default.css"/>
      <stripes:layout-component name="html-head"/>
    </head>
    <body>
      <div id="header">
      <c:choose>
      <c:when test="${not empty login}">
      logged in as ${login.screenName} | 
      <stripes:link beanclass="action.PostAction">new post</stripes:link> |
      <stripes:link beanclass="action.LogoutAction">logout</stripes:link>
      </c:when>
      <c:when test="${empty login}">
      <stripes:link beanclass="action.LoginAction">sign in</stripes:link>
      </c:when>
      </c:choose>
      </div>
      <div id="content">
          <stripes:layout-component name="contents"/>
      </div>
    </body>
  </html>
</stripes:layout-definition>

