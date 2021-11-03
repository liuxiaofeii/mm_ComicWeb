<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
    <%@include file="/common/utop.jsp"%>
<!--导航条-->
<div class="width100" style="height: 45px;background: #000000;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/item/payComic">纸质漫画</a>
            <a href="${ctx}/item/freeComic">电子漫画</a>
        </div>
    </div>
</div>

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>><a href="#" class="c_66">书籍列表</a>
</div>
<div class="width1198 center_yh" style="height: 35px;background: #f0f0f0; border: 1px solid #ddd;margin-top:25px;">
<%--    <a href="${ctx}/item/booklist?categoryIdTwo=${obj.categoryIdTwo}" class="mR">默认</a>--%>
<%--    <a href="${ctx}/item/booklist?price=1&categoryIdTwo=${obj.categoryIdTwo}" class="mR">--%>
<%--        价格--%>
<%--        <img src="${ctx}/resource/user/images/gg.png" alt="">--%>
<%--    </a>--%>
<%--    <a href="${ctx}/item/booklist?gmNum=1&categoryIdTwo=${obj.categoryIdTwo}" class="mR">--%>
<%--        销量--%>
<%--        <img src="${ctx}/resource/user/images/gg.png" alt="">--%>
<%--    </a>--%>

</div>
<!--商品列表-->
<div class="width1200 center_yh hidden_yh" style="margin-top: 25px;">
    <ul class="listSs">
        <c:forEach items="${pagers.datas}" var="data" varStatus="l">
            <li>
                <a href="${ctx}/item/view?bookId=${data.bookId}" class="bjK">
                    <img src="${localPhot}/${data.categoryId}/${data.bookId}/420.jpg" alt="">
                </a>
                <h3 class="spName">${data.bookName}</h3>
                <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                    <c:if test="${data.bookFree!=1}">
                    <font class="left_yh red font14">￥${data.bookPrice}</font>
<%--                    <c:if test="${data.zk!=null}">--%>
<%--                        <font class="right_yh font14">--%>
<%--                            ${data.zk}--%>
<%--                            <span style="color: red">折</span>--%>
<%--                        </font>--%>
<%--                    </c:if>--%>
                    </c:if>
                </p>
                <div class="wCa">
                    <a href="${ctx}/sc/exadd?bookId=${data.bookId}" class="fav">
                        <div class="wCa1">
                            <b><img src="${ctx}/resource/user/images/star.png" alt=""></b>
                            <font>收藏</font>
                        </div>
                    </a>
                    <c:choose>
                        <c:when test="${data.bookFree==1}">
                            <div class="wCa2" onclick="addcar('${data.bookId}')">
                                <b><img src="${ctx}/resource/user/images/read.png" alt=""></b>
                                <font>免费阅读</font>
                            </div>
                        </c:when>
                        <c:otherwise>
                        <div class="wCa2" onclick="addcar('${data.bookId}')">
                            <b><img src="${ctx}/resource/user/images/sar.png" alt=""></b>
                            <font>加入购物车</font>
                        </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<div id="navs">
    <div class="pagelist">
        <!--分页开始-->
        <pg:pager url="${ctx}/item/payComic" maxIndexPages="5" items="${pagers.total}" maxPageItems="15" export="curPage=pageNumber">
<%--            <pg:param name="categoryIdTwo" value="${obj.categoryIdTwo}"/>--%>
<%--            <pg:param name="price" value="${obj.bookPrice}"/>--%>
<%--            <pg:param name="gmNum" value="${obj.scNum}"/>--%>
<%--            <pg:param name="condition" value="${condition}"/>--%>
<%--            <pg:param name="categoryId" value="${categoryId}"/>--%>
            <pg:last>
                共${pagers.total}记录，共${pageNumber}页，
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
</div>
<script>
    function addcar(id) {
        window.alert("addcar内部")
        $.ajax({
            type:"POST",
            url:"${ctx}/car/exadd?bookId="+id+"&num=1",
            success:function (result) {
                window.alert("re内部")
                var re = result;
                if(re.res == 0){
                    alert("请登录");
                    window.location.href="${ctx}/login/uLogin";
                }else {
                    window.location.href="${ctx}/car/findBySql";
                }
            }
        });
    }
</script>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















