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
        <strong><span class="icon-pencil-square-o">书籍维护</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/item/exUpdate" method="post" class="form-x">
            <input type="hidden" name="bookId" value="${book.bookId}" />
            <input type="hidden" name="isDelete" value="${book.isDelete}" />
            <div class="form-group">
                <div class="label"><label>书籍名称：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookName" data-validate="required:请输入书籍名称" value="${book.bookName}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label"><label>书籍作者：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookAuthor" data-validate="required:请输入书籍名称" value="${book.bookAuthor}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label"><label>书籍价格：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookPrice" data-validate="required:请输入书籍价格(元)"  value="${book.bookPrice}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>书籍类别：</label></div>
                <div class="field">
                    <select name="categoryId" class="input w50">
                        <c:forEach items="${types}" var="data" varStatus="l">
                            <option value="${data.categoryId}">${data.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="label"><label>封面：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookPhoto" value="${book.bookPhoto}"/>
<%--                    这里以后有时间改成ftp上传--%>
                </div>
            </div>

            <div class="form-group">
                <div class="label"><label>书籍等级：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookFree" data-validate="required:书籍等级" value="${book.bookFree=='1'?"免费":"付费"}"/>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label"><label>书籍阅读量：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bookReadNums" data-validate="required:书籍阅读量" value="${book.bookReadNums}"/>
                    <div class="tips"></div>
                </div>

            </div><div class="form-group">


        </div>

            <div class="form-group">
                <div class="label"><label>书籍简介：</label></div>
                <div class="field">
                    <script type="text/plain" id="remark_txt_1" name="bookIntro" style="width: 100%;height: 300px;">${book.bookIntro}</script>
                    <script type="text/javascript">
                        var editor = UE.getEditor('remark_txt_1');
                        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
                        UE.Editor.prototype.getActionUrl = function (action) {
                            if(action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo'){
                                return '${ctx}/ueditor/saveFile';
                            }else{
                                return this._bkGetActionUrl.call(this,action);
                            }
                        }
                    </script>
                    <div class="tips"></div>
                </div>
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