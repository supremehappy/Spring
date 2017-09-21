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
	<c:when test="${sessionScope.loginUser !=null }">
		<h3 align="center"> success </h3>
		<h3>${sessionScope.loginUser }, hi</h3>
		 
		<form action="../logout/main.html" method="get">
			<input type="submit" class="btn btn-info" value="logout">
		</form>
		<a href="../gshop/main.jsp" class="btn btn-info" role="button">home</a>
	</c:when>
	
	<c:when test="${sessionScope.loginAdmin !=null }">
		<h3 align="center"> success </h3>
		<h3>${sessionScope.loginAdmin }, hi admin</h3>
		
		<form action="../logout/main.html" method="get">
			<input type="submit" class="btn btn-info" value="logout">
		</form>
		<a href="../gshop/main.jsp" class="btn btn-info" role="button">home</a>
	</c:when>
		
	<c:otherwise>	
		<h3 align="center"> fail </h3>
	</c:otherwise>
</c:choose>
</body>
</html>