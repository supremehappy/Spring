<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>		
<%@ include file="/gshop/header.jsp" %>
		
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GShop</title>
</head>

<body>
<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box">
				<h1>주문 목록</h1>
				
			<table class="table table-hover">
				<thead>
					<tr>
						<td width="100">주문번호</td>
						<td width="100">게임번호</td>
						<td width="300">게임이름</td>
						<td width="80">주문가격</td>
						<td width="90">주문일</td>
						<td width="80">주문자</td>
					</tr>
				</thead>
				<tbody>
				<c:if test="${ !empty ORDER_LIST }">
					<c:forEach var="order" items="${ ORDER_LIST }">
					<tr>
						<td><a href="../order/detail.html?ORDER_ID=${ order.order_id }">${ order.order_id }</a></td>
						<td>${ order.game_id }</td>
						<td>${ order.game_name }</td>
						<td>${ order.total_amount }</td>
						<td>${ order.order_date }</td>
						<td>${ order.nickname }</td>
					</tr>
				</c:forEach>
				</tbody>
				</c:if>
		</table>
		<br>
		<c:forEach var="page" begin="1" end="${ COUNT }">
			<a href="../order/list.html?PAGENO=${ page }">${ page }</a>
		</c:forEach>
		
				</div><!-- .box end -->
			</div><!-- .col-md-12 end -->
		</div><!-- .container end -->
	</div><!-- #content end -->
</div><!-- #all end -->
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>