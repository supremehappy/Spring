<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>계산 화면</h2><font color="red"><b>받을 곳</b></font>
<table>
	<tr><td>사용자ID</td><td>${loginUser.userId }</td></tr>
	<tr><td>이 름</td><td>${loginUser.userName }</td></tr>
	<tr><td>우편번호</td><td>${loginUser.postCode }</td></tr>
	<tr><td>주 소</td><td>${loginUser.address }</td></tr>
	<tr><td>이메일</td><td>${loginUser.email }</td></tr>
</table><br/><br/>
<font color="red">쇼핑 목록</font>
<table border="1">
<tr><th width="200">상품이름</th><th width="150">가 격</th>
<th width="90">갯 수</th><th width="150">소 계</th></tr>
<c:forEach var="itemSet" items="${itemList }">
	<tr>
		<td align="left">${itemSet.item.itemName }</td>
		<td align="right">${itemSet.item.price }원</td>
		<td align="right">${itemSet.quantity }개</td>
		<td align="right">
		${itemSet.quantity * itemSet.item.price }원</td>
	</tr>
</c:forEach>
</table><br/>
<b>합 계 총 액 : ${totalAmount }원</b><br/><br/>
<form action="../end/end.html">
	<input type="submit" value="확 정" name="btn1"/>
</form>
<a href="../index/index.html">■ 목록으로 돌아가기</a>
</div>
</body>
</html>










