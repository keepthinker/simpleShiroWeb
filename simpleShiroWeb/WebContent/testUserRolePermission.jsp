<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<shiro:user><h1>there is a user logged in</h1></shiro:user>
	<shiro:guest><h2>I have never logged in this web site</h2></shiro:guest>
	<shiro:hasRole name="corporate"><h3>I am a corporate client</h3></shiro:hasRole>
	<shiro:hasPermission name="corporate:show"><h4>my permission is corporate:show(identical tag)))</h4></shiro:hasPermission>
</body>
</html>
