<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.UPLOAD != null }">
		<h2>글을 올리시려면, 로그인해야 합니다.</h2>
		<form action="login" method="post">
		아이디 : <input type="text" name="ID" size="12"/><br/>
		패스워드 : <input type="password" name="PWD" size="12"/><br/>
		<input type="submit" value="로그인"/>
		</form>
	</c:when>
	<c:otherwise>
		<form action="login" method="post">
		아이디 : <input type="text" name="ID" size="12"/><br/>
		패스워드 : <input type="password" name="PWD" size="12"/><br/>
		<input type="submit" value="로그인"/>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>











