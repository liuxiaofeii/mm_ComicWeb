<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a class="button border-main icon-plus-square-o" href="${ctx}/category/add">新增类目</a>
            </li>
        </ul>
        <ul class="search" style="padding-left: 10px;">
            <li>
                ${mesg}
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>类别名称</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${pages.datas}" var="data" varStatus="l">
        <tr>
            <td>${data.categoryId}</td>
            <td>${data.categoryName}</td>
            <td>
                <div class="button-group">
                    <a class="button border-red" href="${ctx}/category/delete?categoryId=${data.categoryId}"><span class="icon-trash-o">删除</span> </a>
                </div>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <!--分页开始-->
                    <pg:pager url="${ctx}/category/findBySql" maxIndexPages="5" items="${pages.total}" maxPageItems="5" export="curPage=pageNumber">
                        <pg:last>
                            共${pages.total}记录，共${pageNumber}页，
                        </pg:last>
                        当前第${curPage}页
                        <pg:first>
                            <a href="${pageUrl}">首页</a>
                        </pg:first>
                        <pg:prev>
                            <a href="${pageUrl}">上一页</a>
                        </pg:prev>
                        <pg:pages>
                            <c:choose>
                                <c:when test="${curPage eq pageNumber}">
                                    <font color="red">[${pageNumber}]</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">${pageNumber}</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:pages>
                        <pg:next>
                            <a href="${pageUrl}">下一页</a>
                        </pg:next>
                        <pg:last>
                            <c:choose>
                                <c:when test="${curPage eq pageNumber}">
                                    <font color="red">尾页</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageUrl}">尾页</a>
                                </c:otherwise>
                            </c:choose>
                        </pg:last>
                    </pg:pager>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>