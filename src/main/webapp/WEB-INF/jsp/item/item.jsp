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
    <form action="${ctx}/item/findBySql" id="listform" method="post">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left: 10px;">
                <li>
                    <a class="button border-main icon-plus-square-o" href="${ctx}/item/add">添加书籍</a>
                </li>
                <li>
                    <input type="text" placeholder="请输入书籍名称" name="bookName" class="input" value="${book.bookName}"
                           style="width: 250px;line-height: 17px;display: inline-block" />
                    <a href="javascript:void(0)" onclick="changeSearch()" class="button border-main icon-search">搜索</a>
                </li>
            </ul>
        </div>
    </form>
    <table class="table table-hover text-center">
        <tr>
            <th>书籍id</th>
            <th>书籍名称</th>
            <th>书籍简介</th>
            <th>书籍封面</th>
            <th>书籍标签</th>
            <th>书籍价格</th>
            <th>书籍等级</th>
            <th>书籍作者</th>
            <th>书籍阅读量</th>
            <th>书籍上架情况</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pages.datas}" var="data">
            <tr style="font-size: smaller">
                <td>${data.bookId}</td>
                <td>${data.bookName}</td>
                <td style="text-align: left">

                    <a href=# title="${data.bookIntro}" >详情</a>
                </td>
                <td><img src="${localPhot}/${data.categoryId}/${data.bookId}/420.jpg" alt="" height="280" width="210"></td>
                <td>${data.category.categoryName}</td>
                <td>${data.bookPrice}</td>
                <td>
                    <c:choose>

                        <c:when test="${data.bookFree eq '1'}">免费</c:when>
                        <c:otherwise>付费</c:otherwise>
                    </c:choose>

                </td>
                <td>${data.bookAuthor}</td>
                <td>${data.bookReadNums}</td>
                <td>
                    <c:choose>
                        <c:when test="${data.isDelete==1}">未上架</c:when>
                        <c:otherwise>已上架</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a class="button border-main" href="${ctx}/item/update?bookId=${data.bookId}"><span class="icon-edit">修改</span> </a>
                    <a class="button border-red" href="${ctx}/item/delete?bookId=${data.bookId}">
                       <span class="icon-trash-o">下架</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <!--分页开始-->
                    <pg:pager url="${ctx}/item/findBySql" maxIndexPages="5" items="${pages.total}" maxPageItems="5" export="currentPageNumber=pageNumber">
                        <pg:last>
                            共${pages.total}记录，共${pageNumber}页，
                        </pg:last>
                        当前第${currentPageNumber}页
                        <pg:first>
                            <a href="${pageUrl}">首页</a>
                        </pg:first>
                        <pg:prev>
                            <a href="${pageUrl}">上一页</a>
                        </pg:prev>
                        <pg:pages>
                            <c:choose>
                                <c:when test="${currentPageNumber eq pageNumber}">
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
                                <c:when test="${currentPageNumber eq pageNumber}">
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
<script>
    function changeSearch(){
        $("#listform").submit();
    }
</script>

</body>

</html>