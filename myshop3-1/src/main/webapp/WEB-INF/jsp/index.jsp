<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/myshop3-1.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
	<h2>상품 목록 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품 ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach items="${productList }" var="list">
			<tr class="record">
				<td align="center">${list.pid }</td>
				<td align="center"><a href="detail.html?pid=${list.pid }">${list.name }</a></td>
				<td align="center">${list.price }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>