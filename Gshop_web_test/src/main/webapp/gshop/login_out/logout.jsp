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
<form action="../logout/main.html" method="get">
	<c:choose>
		<c:when test="${sessionScope.loginUser!=null }">
			안녕하세요? ${sessionScope.loginUser }님~<br/>
		</c:when>	
		
		<c:when test="${sessionScope.loginAdmin!=null }">
			안녕하세요? ${sessionScope.loginAdmin }님~<br/>
		</c:when>
	</c:choose>

<input type="submit" class="btn btn-info" value="logout">
</form>
</body>
</html>