<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">상품 목록</h3>
<table border="1">
	<tr>
		<td width="40">상품번호</td>
		<td width="100">상품이름</td>
		<td width="80">상품가격</td>
		<td width="100">등록일</td>
		<td width="100">&nbsp;</td>
	</tr>
	<c:forEach var="product" items="${PRODUCT_LIST }">
	<tr>
		<td>${product.pid }</td>
		<td>${product.name}</td>
		<td><fmt:formatNumber groupingUsed="true">
		${product.price}</fmt:formatNumber>원
		</td>
		<td>${product.p_date}</td>
		<td><a href="#" 
		onClick="window.open('../cart/addCart.html?CODE=${product.pid}','Cart_Result','width=400,height=250').focus()"
		>장바구니 담기</a></td>
	</tr>	
	</c:forEach>
</table>
</body>
</html>










