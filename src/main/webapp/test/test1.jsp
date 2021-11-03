<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/3/30
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<pg:pager items="1001" export="currentPageNumber=pageNumber">
    <pg:first><a href="${pageUrl}">首页</a></pg:first>
    <pg:prev><a href="${pageUrl}">前页</a></pg:prev>
    <pg:pages>
         <c:choose>
         <c:when test="${pageNumber eq currentPageNumber }">
         <span style="color: red; ">${pageNumber }</span>
         </c:when>
         <c:otherwise>
         <a href="${pageUrl }">${pageNumber}</a>
         </c:otherwise>
         </c:choose>
    </pg:pages>
    <pg:next><a href="${pageUrl}">下页</a></pg:next>
    <pg:last><a href="${pageUrl}">尾页</a></pg:last>
</pg:pager>
</body>
</html>
