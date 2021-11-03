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
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<div class="panel admin-panel">

    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">用户维护</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/user/exadd" method="post" class="form-x">
            <input type="hidden" name="userId" value="${user.userId}" />
            <input type="hidden" name="isDelete" value="${user.isDelete}" />
            <div class="form-group">
                <div class="label"><label>用户登录名：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="userName" data-validate="required:请输入书籍名称" value="${user.userName}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label"><label>用户真实姓名：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="realName" data-validate="required:请输入用户真实姓名" value="${user.realName}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label"><label>密码：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="password" data-validate="required:请输入密码"  value="${user.password}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>手机号码：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="phone" data-validate="required:请输入手机号码"  value="${user.phone}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"><label>邮箱：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="email" data-validate="required:请输入邮箱地址"  value="${user.email}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"><label>所在地址：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="address" data-validate="required:请输入所在地址"  value="${user.address}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">


        </div>



            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>