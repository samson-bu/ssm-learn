<%--
  Created by IntelliJ IDEA.
  User: Samson
  Date: 2020/4/5
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Hello Layui</title>
    <link rel="stylesheet" href="${ctx}/assets/layui/css/layui.css">
</head>
<body>
<button type="button" class="layui-btn">一个标准的按钮</button>
<button type="button" class="layui-btn layui-btn-normal">一个百搭的按钮</button>

<script src="${ctx}/assets/layui/layui.js"></script>
</body>
</html>
