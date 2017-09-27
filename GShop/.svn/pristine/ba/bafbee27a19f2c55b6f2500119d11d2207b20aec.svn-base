<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="gameList.title"/></title>
</head>

<body>
	<h1 align="center">게임 목록</h1>
	<table border="1">
		<tr>
			<td width="40">게임번호</td>
			<td width="300">게임이름</td>
			<td width="80">게임가격</td>
			<td width="80">&nbsp;</td>
		</tr>
	<c:forEach var="game" items="${ GAME_LIST }">
		<tr>
			<td>${ game.game_id }</td>
			<td><a href="../read/readProductDetail.html?PID=${ game.game_id }">${ game.game_name }</a></td>
			<td align="right"><fmt:formatNumber groupingUsed="true">${ game.price }</fmt:formatNumber>원</td>
		</tr>
	</c:forEach>
	</table>
		<c:forEach var="page" begin="1" end="${ COUNT }">
		<a href="../read/readProduct.html?PAGENO=${ page }">${ page }</a>
	</c:forEach>
	
<%-- 	<c:if test="${ !product.firstPage}">
		<a href="product-list?FIRST_PID=${ product.pidList[0] }">이전 페이지</a>
	</c:if>
	<c:forEach var="page" begin="1" end="${ product.pageNum}">
		<a href="product-list?PAGE_NO=${ page }">${ page }</a>
	</c:forEach>
	<c:if test="${ !PRODUCT_LIST.lastPage}">
		<a href="product-list?LAST_PID=${ PRODUCT_LIST.pidList[PRODUCT_LIST.listSize -1] }">다음 페이지</a>
	</c:if> --%>
</body>
</html>