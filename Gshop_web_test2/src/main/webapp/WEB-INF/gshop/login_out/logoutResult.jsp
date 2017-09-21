<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser == null}">
		<h1>로그아웃 되었습니다. 또 방문해 주세요~</h1>
		
		<a href="../gshop/main.jsp" class="btn btn-info" role="button">home</a>
	</c:when>
	
	<c:when test="${sessionScope.loginAdmin == null }">
		<h1>로그아웃 되었습니다. 또 방문해 주세요~</h1>
		
		<a href="../gshop/main.jsp" class="btn btn-info" role="button">home</a>
	</c:when>
	
	<c:otherwise>
		<h1>로그아웃에 문제가 발생했습니다. 관리자에 문의해 주세요~</h1>
	</c:otherwise>
</c:choose>
</body>
</html>