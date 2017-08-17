<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

<div align="center" class="body">
	<h2>카트확인</h2>
	<div class="cart">
		<table style="font-size:10pt">
			<tr>
				<td colspan="2">
					<font color="green"> 카트에 다음 상품이 들어있습니다.</font>
				</td>
			</tr>
			<c:forEach var="itemSet" items="${cart.itemList }">
				<tr>
					<td>${itemSet.item.itemName }</td>
					<td>${itemSet.quantity }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	${message }<br><br>
	<a href="../index/index.html">* 목록으로 돌아가기</a>
	<a href="../checkout/checkout.html">* 계산하러가기</a>
</div>
</body>
</html>