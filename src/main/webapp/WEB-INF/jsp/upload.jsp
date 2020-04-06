<%--
  Created by IntelliJ IDEA.
  User: Samson
  Date: 2020/4/5
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Upload</title>
    <link rel="stylesheet" href="${ctx}/assets/layui/css/layui.css">
</head>
<body>
<div class="layui-upload">
    <button type="button" class="layui-btn" id="uploadSingle">上传图片</button>
    <div class="layui-upload-list">
        <img class="layui-upload-img" src="" id="demo1">
        <p id="demoText"></p>
    </div>
</div>
<script src="${ctx}/assets/layui/layui.js"></script>
<script type="text/javascript">
    layui.use('upload', function () {
        var $ = layui.$,
            layer = layui.layer,
            upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadSingle',
            url: '${ctx}/layui/upload/single/',
            before: function (obj) {
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('style', 'width: 60%; height: 60%')
                    $('#demo1').attr('src', result)
                })
            },
            done: function (res) {
                if (res.code > 0) {
                    return layer.msg('上传失败')
                }
            },
            error: function () {
                //请求异常回调
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败x</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
</script>
</body>
</html>
