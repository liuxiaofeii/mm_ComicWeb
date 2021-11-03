<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
<%@include file="/common/utop.jsp"%>
<!--导航条-->
<div class="width100" style="height: 45px;background: #000000;margin-top: 40px;position: relative;z-index: 100;">
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="javascript:void(0)" class="lastcontent">上一话</a>
            <a href="${ctx}/item/view?bookId=${content.bookId}" class="">目录</a>
            <a href="${ctx}/content/findBySql?contentNum=${content.contentNum+1}&&bookId=${content.bookId}&&categoryId=${categoryId}">下一话</a>
        </div>
    </div>
</div>
<!--轮动广告-->
<div class="width1200 center_yh hidden_yh" style="position: relative;z-index:80;">
    <div class="example2" style="width: 1200px;margin-left: 230px;">
        <ul>
            <c:if test="${msgcontent.length()>0}">
                <li>${msgcontent}</li>
            </c:if>
            <c:forEach items="${contentPhotos}" var="contentPhoto" varStatus="l">
            <li><img src="${localPhot}/${categoryId}/${contentPhoto.bookId}/${contentPhoto.contentNum}/${contentPhoto.contentNumId}.jpg" alt=""></li>
            </c:forEach>



        </ul>
    </div>
    <div class="buyFor">
        <a href="javascript:void(0)" class="mstBuy lastcontent">上一话</a>
        <a href="${ctx}/item/view?bookId=${content.bookId}" class="addCar">目录</a>
        <a href="${ctx}/content/findBySql?contentNum=${content.contentNum+1}&&bookId=${content.bookId}&&categoryId=${categoryId}" class="addCar nextcontent">下一话</a>
    </div>
    <script>
        $(".lastcontent").click(
            function (){
                if(${content.contentNum-1!=0}){
                    window.location.href="${ctx}/content/findBySql?contentNum=${content.contentNum-1}&&bookId=${content.bookId}&&categoryId=${categoryId}";
                }else{
                    window.alert("已经是第一话");
                }

            }
        );

    </script>
</div>
<!--推荐书籍-->


<!--付费书籍-->

<div>
    <%@include file="/common/ufooter.jsp"%>
</div>
</body>
</html>



















