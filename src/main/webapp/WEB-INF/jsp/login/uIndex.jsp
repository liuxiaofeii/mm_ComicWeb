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
        <!--列表导航-->
        <div class="left_yh Selected" style="width: 230px;height: 45px;" id="hiddenShow">
            <!--头部的图标-->
            <img src="${ctx}/resource/user/images/cd.png" class="left_yh" style="margin-left: 24px;" alt="">
            <span class="block_yh left_yh fff" style="height: 45px;line-height: 44px;margin-left: 10px;">分类</span>
            <!--导航展开部分-->
            <div class="downSlide">
                <c:forEach items="${types}" var="data" varStatus="l">
                    <div class="n1Nav">
                        <a href="${ctx}/item/booklist?categoryId=${data.categoryId}">
                            <font>
                                ${data.categoryName}
                            </font>
                        </a>
                        <img src="${ctx}/resource/user/images/jt.png" alt="">
<%--                        <div class="n2Nav">--%>
<%--                            <div class="n3Nav">--%>
<%--                                <h3>${data.categoryName}</h3>--%>
<%--                                <c:forEach items="${data.childrens}" var="child" varStatus="ll">--%>
<%--                                    <a href="${ctx}/item/shoplist?categoryId=${data.categoryId}">${child.name}</a>--%>
<%--                                </c:forEach>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/item/payComic">纸质漫画</a>
            <a href="${ctx}/item/freeComic">电子漫画</a>
        </div>
    </div>
</div>
<!--轮动广告-->
<div class="width1200 center_yh hidden_yh" style="position: relative;z-index:80;">
    <div class="example2" style="width: 1200px;height: 490px;overflow: hidden;margin-left: 230px;">
        <ul>
            <li><img src="${ctx}/resource/images/c4.png" alt=""></li>
            <li><img src="${ctx}/resource/images/c3.png" alt=""></li>
            <li><img src="${ctx}/resource/images/c.png" alt=""></li>
            <li><img src="${ctx}/resource/images/c2.png" alt=""></li>
        </ul>
    </div>
    <script>
        $(function () {
            $(".example2").luara({width:"966",height:"490",interval:4500,selected:"seleted",deriction:"left"});
        });
    </script>
</div>
<!--免费书籍-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #000000; margin-top: 20px;">
        <font class="left_yh font20">电子漫画</font>
    </div>
    <div class="width100 hidden_yh" style="height: 600px;">
        <div class="normalPic">
            <c:forEach items="${hotBook}" var="data" varStatus="l">
                <a href="${ctx}/item/view?bookId=${data.bookId}">
                    <h3 class="yihang c_33 font18 font100" style="padding-left: 10px;padding-right: 10px;">${data.bookName}</h3>
                    <p class="red font14" style="padding-left: 10px;"></p>
                    <img src="${localPhot}/${data.categoryId}/${data.bookId}/420.jpg" width="180" height="210" alt="" style="margin:0 auto">
                </a>
            </c:forEach>
        </div>
    </div>
</div>

<!--付费书籍-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #000000; margin-top: 100px;">
        <font class="left_yh font20">纸质漫画</font>
    </div>
    <div class="width100 hidden_yh" style="height: 600px;">
        <div class="normalPic">
            <c:forEach items="${payBook}" var="data" varStatus="l">
                <a href="${ctx}/item/view?bookId=${data.bookId}">
                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.bookName}</h3>
                    <p class="red font18" style="padding-left: 10px;color: red">${data.bookPrice}元</p>
                    <img src="${localPhot}/${data.categoryId}/${data.bookId}/420.jpg" width="180" height="210" alt="" style="margin:0 auto">
                </a>
            </c:forEach>
        </div>
    </div>
</div>
    <div>
    <%@include file="/common/ufooter.jsp"%>
    </div>
</body>
</html>



















