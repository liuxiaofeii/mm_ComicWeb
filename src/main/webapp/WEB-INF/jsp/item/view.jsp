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
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="#" class="c_66">书籍列表</a>
    ><a href="#" class="c_66">详情</a>
</div>
<div class="width1198 center_yh" style="height: 420px;">
    <div class="left_yh" style="width: 350px;height: 420px;">
        <input type="hidden" id="bookId" value="${obj.bookId}">
        <div id="preview">
            <div>
                <img src="${localPhot}/${obj.categoryId}/${obj.bookId}/420.jpg" alt="" height="350" width="350">
            </div>

        </div>
    </div>
    <div class="left_yh" style="width: 486px;height: 420px;margin-left: 42px;">
        <h3 class="font20 font100">${obj.bookName}</h3>

        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">简介：</font>
            <font class="red font20">
                ${obj.bookIntro}
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">作者：</font>
            <font class="red font20">
                ${obj.bookAuthor}
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">类别：</font>
            <font class="red font20">
                ${obj.bookLabel}
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font class="red font20">
                <c:choose>
                    <c:when test="${obj.bookFree=='1'}">
                        免费阅读
                    </c:when>
                    <c:otherwise>
                        付费购买
                    </c:otherwise>
                </c:choose>
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">阅读量：</font>
            <font class="red font20">
                ${obj.bookReadNums}
            </font>
        </p>
        <c:choose>
            <c:when test="${obj.bookFree=='1'}">
<%--                <p>--%>
<%--                    <a href="${ctx}/item/read?bookId=${obj.bookId}" class="mstBuy">开始阅读</a>--%>
<%--                </p>--%>
                <div class="buyFor">
                    <a href="${ctx}/sc/exadd?bookId=${obj.bookId}" class="mstBuy">收藏</a>
                    <a href="${ctx}/content/findBySql?bookId=${obj.bookId}&&categoryId=${obj.categoryId}" class="addCar">开始阅读</a>
                </div>
                <div>

                    <ul>
                        <c:forEach items="${contents}" var="content" varStatus="l">
                            <li class="zhangjie">
                            <c:choose>
                                <c:when test="${content.bookId lt 10}">
                                    <a style="color: #000000" href="${ctx}/content/findBySql?contentNum=${content.contentNum}&&bookId=${content.bookId}&&categoryId=${obj.categoryId}">第0${content.contentNum}话</a>
                                </c:when>
                                <c:otherwise>
                                    <a style="color: #000000" href="${ctx}/content/findBySql?contentNum=${content.contentNum}&&bookId=${content.bookId}&&categoryId=${obj.categoryId}">第${content.contentNum}话</a>
                                </c:otherwise>
                            </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </c:when>
            <c:otherwise>
                <p class="font16 c_66" style="margin-top:25px;">
                    <font style="margin-right: 20px;">价格：</font>
                    <font class="red font20">
                        ￥${obj.bookPrice}
                    </font>
                </p>
                <p class="font16 c_66 likeColor" style="margin-top: 25px;">
                    <font style="margin-right: 20px;">数量：</font>
                    <a href="javascript:void(0)" id="min_s">-</a>
                    <input type="text" value="1" readonly id="t_a">
                    <a href="javascript:void(0)" id="add_s">+</a>
                    <font class="font14 c_99" style="margin-left: 20px;">库存100</font>
                    <script>
                        var tr = $("#t_a").val();
                        $("#min_s").click(function () {
                            tr--;
                            if(tr<1){
                                $("#t_a").val(1);
                                tr = 1;
                            }else{
                                $("#t_a").val(tr);
                            }
                        });
                        $("#add_s").click(function () {
                            tr++;
                            $("#t_a").val(tr);
                        });
                    </script>
                </p>
                <div class="buyFor">
                    <a href="${ctx}/sc/exadd?bookId=${obj.bookId}" class="mstBuy">收藏</a>
                    <a href="javascript:void(0)" class="addCar">加入购物车</a>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<div class="width1200 hidden_yh center_yh" style="margin-top: 40px;">
    <div class="right_yh" style="width: 1200px;">

    </div>
</div>

<script>
    $("#spXqpj a").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });
    $("#spXqpj a").eq(0).click(function () {
        $("#spDetail").css({display:"block"}).siblings().css({display:"none"});
    });
    $("#spXqpj a").eq(1).click(function () {
        $("#spPj").css({display:"block"}).siblings().css({display:"none"});
    });

    $(function () {
    $(".addCar").click(function () {

        var id = $("#bookId").val();
        var num = $("#t_a").val();
        $.ajax({
            type:"POST",
            url:"${ctx}/car/exadd?bookId="+id+"&purchaseNum="+num,
            success:function (result) {

                var re = eval('('+result+')');
                // window.alert("abc "+re.res)
                if(re.res == 0){
                    alert("请登录");
                    window.location.href="${ctx}/login/uLogin";
                }else {
                    window.location.href="${ctx}/car/findBySql";
                }
            }
        });
    });
});
</script>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















