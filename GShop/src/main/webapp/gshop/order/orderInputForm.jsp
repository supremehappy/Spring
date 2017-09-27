<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="orderDetail.title"/></title>
</head>

<body>
	<h4 align="center">구매 상세</h4>
	<table border="1">
		<tr>
			<td width="70">게임이름</td>
			<td width="250">게임가격</td>
			<td width="80">할인률</td>
			<td width="50">할인금액</td>
			<td width="80">결제금액</td>
			<td width="80">보유금액</td>
		</tr>
		<form action="modify-cart" method="post">
			<input type="hidden" name="CODE" value="${CART_LIST.codeList[cnt] }"/>
		<tr>
			<td>${ CART_LIST.codeList[cnt] }</td>
			<td>${ CART_LIST.nameList[cnt] }</td>
			<td>${ CART_LIST.priceList[cnt] }</td>
			<td><input type="text" size="3" name="NUMBER" value="${CART_LIST.numList[cnt] }"/></td>
			<td><input type="submit" value="수정" name="BTN"/><input type="submit" value="삭제" name="BTN"/></td>
		</tr>
		</form>
	</table>
</body>
</html>