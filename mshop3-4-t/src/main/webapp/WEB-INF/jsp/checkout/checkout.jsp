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
	<h2>��� ȭ��</h2><font color="red"><b>���� ��</b></font>
<table>
	<tr><td>�����ID</td><td>${loginUser.userId }</td></tr>
	<tr><td>�� ��</td><td>${loginUser.userName }</td></tr>
	<tr><td>�����ȣ</td><td>${loginUser.postCode }</td></tr>
	<tr><td>�� ��</td><td>${loginUser.address }</td></tr>
	<tr><td>�̸���</td><td>${loginUser.email }</td></tr>
</table><br/><br/>
<font color="red">���� ���</font>
<table border="1">
<tr><th width="200">��ǰ�̸�</th><th width="150">�� ��</th>
<th width="90">�� ��</th><th width="150">�� ��</th></tr>
<c:forEach var="itemSet" items="${itemList }">
	<tr>
		<td align="left">${itemSet.item.itemName }</td>
		<td align="right">${itemSet.item.price }��</td>
		<td align="right">${itemSet.quantity }��</td>
		<td align="right">
		${itemSet.quantity * itemSet.item.price }��</td>
	</tr>
</c:forEach>
</table><br/>
<b>�� �� �� �� : ${totalAmount }��</b><br/><br/>
<form action="../end/end.html">
	<input type="submit" value="Ȯ ��" name="btn1"/>
</form>
<a href="../index/index.html">�� ������� ���ư���</a>
</div>
</body>
</html>










