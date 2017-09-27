<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>		
		
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="orderList.title"/></title>
</head>

<body>
	<h1 align="center">상품 목록</h1>
	<table border="1">
		<tr>
			<td width="40">상품번호</td>
			<td width="300">상품명</td>
			<td width="80">상품가격</td>
			<td width="90">등록일</td>
			<td width="80">등록자</td>
			<td width="80">&nbsp;</td>
		</tr>
	<c:forEach var="product" items="${ PRODUCT_LIST }">
		<tr>
			<td>${ product.pid }</td>
			<td><a href="../read/readProductDetail.html?PID=${ product.pid }">${ product.name }</a></td>
			<td align="right"><fmt:formatNumber groupingUsed="true">${ product.price }</fmt:formatNumber>원</td>
			<td>${ product.p_date }</td>
			<td>${ product.id }</td>
			<td>
				<a href="#" onClick="window.open('add-cart?CODE=${ product.pid }','Cart_Result','width=400,height=150').focus()">장바구니에 담기</a>
			</td>
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