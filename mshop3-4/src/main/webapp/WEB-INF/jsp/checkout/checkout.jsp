<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/jsp/jsp_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>계산화면</h2><font color="red"><b>받을 곳</b></font>
	<table>
		<tr><td>사용자ID</td><td>${loginUser.userId }</td></tr>
		<tr><td>이름</td><td>${loginUser.userName }</td></tr>
		<tr><td>우편번호</td><td>${loginUser.postCode }</td></tr>
		<tr><td>주소</td><td>${loginUser.address }</td></tr>
		<tr><td>이메일</td><td>${loginUser.email }</td></tr>
	</table><br><br>
	
	<font color="red">쇼핑 목록</font>
	<table border="1">
		<tr>
			<th width="200">상품이름</th><th width="150">가격</th>
			<th width="90">갯수</th><th width="150">소계</th>
		</tr>
		
		<c:forEach var = "itemSet" items="${itemList }">
			<tr>
				<td align="left">${itemSet.item.itemName }</td>
				<td align="right">${itemSet.item.price }</td>
				<td align="right">${itemSet.quantity }</td>
				<td align="right">${itemSet.quantity*itemSet.item.price }</td>			
			</tr>
		</c:forEach>
	</table><br>
	<b>합계총액 :  ${totalAmount }</tr></b><br><br>
	<form action="../end/end.html">
		<input type="submit" value="확정" name="btn1"/>
	</form>
	<a href="../index/index.html">* 목록으로 돌아가기<a>
</div>
</body>
</html>
