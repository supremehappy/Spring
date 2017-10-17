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
<div class="body">
	<div class="container">
	
<form:form modelAttribute="order" action="../order/insert.html" method="post" onSubmit="return validate(this)">
	<form:hidden path="game_id" value="${GAME_ID}"/>
	<form:hidden path="user_id" value="${USER_ID}"/>
	<h4 align="center">구매 상세</h4>
	<table class="table table-bordered">
		<tbody>
		<tr>
			<td>게임이름</td>
			<td><form:input path="game_name" value="${GAME_NAME}" readOnly="true"/></td>
		</tr>		
		<tr>
			<td>게임가격</td>
			<td><form:input path="price" value="${PRICE}" readOnly="true"/>원</td>
		</tr>	
		<tr>
			<td>할인율</td>
			<td><form:input path="discount_rate" value="${DISCOUNT_RATE}" readOnly="true"/>%</td>
		</tr>
		<tr>
			<td>결제금액</td>
			<td><form:input path="total_amount" value="${TOTAL_AMOUNT}" readOnly="true"/>원</td>
		</tr>
		<tr>
			<td>보유금액</td>
			<td><form:input path="cash_balance" value="${CASH_BALANCE}" readOnly="true"/></td>
		</tr>
		</tbody>
	</table>
	<div align="center">
	<c:choose>
	<c:when test="${TOTAL_AMOUNT <= CASH_BALANCE}">
		<c:if test="${ CHECK == 0 }">
			<input type="submit" class="btn btn-info" value="등 록"/>
		</c:if>	
		<c:if test="${ CHECK == 1 }">
			<input type="button" class="btn btn-info" value="등 록" onClick="goAlert()"/>
		</c:if>		
	</c:when>
	<c:otherwise>
		<input type="button" class="btn btn-info" value="등 록" onClick="goCharge()"/>
	</c:otherwise>
	</c:choose>
	
		
	</div>
</form:form>
<script type="text/javascript">
function goCharge() {
    var ok = confirm("충전 하시겠습니까?")
     if (ok == true) {
      location.href="../charge/chargeForm.html"
   } else {
      alert("취소 되었습니다.")
   }
}
function goAlert() {
    var ok = alert("이미 구매한 게임입니다.")
}
</script>
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>