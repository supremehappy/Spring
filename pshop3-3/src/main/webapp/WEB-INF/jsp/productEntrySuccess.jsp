<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="body">
		<b>
			<font color="blue">사용자 등록이 완료되었습니다.</font>
		</b>
		
		<table>
			<tr height="40px">
				<td>작성자</td><td>${product.id }</td>
			</tr>
			<tr height="40px">
				<td>상품명</td><td>${product.name }</td>
			</tr>
			<tr height="40px">
				<td>가격</td><td>${product.price }</td>
			</tr>
			<tr height="40px">
				<td>내용</td><td>${product.content }</td>
			</tr>			
		</table>
	</div>
</body>
</html>