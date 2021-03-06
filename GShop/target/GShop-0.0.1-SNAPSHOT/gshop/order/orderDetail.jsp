<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>GShop Home</title>
</head>

<body>

<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box">
				<h1>주문 상세</h1>

<c:if test="${ empty ORDER_DETAIL }">
	존재하지 않는 주문입니다.
</c:if>
<c:if test="${ !empty ORDER_DETAIL }">
<table class="table table-bordered">
	<tbody>
	<tr>
		<td width="100">주문번호</td>
		<td>${ ORDER_DETAIL.order_id }</td>
	</tr>
	<tr>
		<td>주문자</td>
		<td>${ ORDER_DETAIL.nickname }</td>
	</tr>
	<tr>
		<td>게임이름</td>
		<td>${ ORDER_DETAIL.game_name }</td>
	</tr>
	<tr>
		<td>주문금액</td>
		<td>${ ORDER_DETAIL.total_amount }원</td>
	</tr>
	<tr>
		<td>주문일자</td>
		<td>${ ORDER_DETAIL.order_date }</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="../order/list.html">[목록]</a>
		</td>
	</tr>
	</tbody>
</table>
</c:if>


				</div><!-- .box end -->
			</div><!-- .col-md-12 end -->
		</div><!-- .container end -->
	</div><!-- #content end -->
</div><!-- #all end -->
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>