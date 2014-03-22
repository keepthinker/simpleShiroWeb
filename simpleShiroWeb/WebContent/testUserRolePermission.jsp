<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<h1>首页</h1>

<shiro:guest>
    <p>身份：游客</p>
    <a href="<c:url value="login.jsp"/>">登录</a>
    <a href="<c:url value="/register"/>">注册</a>
</shiro:guest>

<shiro:user>
    <p>身份：<shiro:principal/></p>
    <a href="<c:url value="/logout"/>">退出</a>
</shiro:user>
<shiro:hasPermission name="corporate:print">i am corporate</shiro:hasPermission>
<shiro:principal/>
<shiro:lacksPermission name="corporate:print">i am not corporate</shiro:lacksPermission>

</body>
</html>