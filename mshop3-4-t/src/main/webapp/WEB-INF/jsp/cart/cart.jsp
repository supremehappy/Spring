<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>īƮ Ȯ��</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
	<h2>īƮ Ȯ��</h2>
	<div class="cart">
	<table style="font-size:10pt;">
		<tr>
			<td colspan="2"><font color="green">
			īƮ�� ���� ��ǰ�� ����ֽ��ϴ�.</font></td>		
		</tr>
		<c:forEach var="itemSet" items="${cart.itemList }">
		<tr>
			<td>${itemSet.item.itemName }</td>
			<td>${itemSet.quantity }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	${message }<br/><br/>
	<a href="../index/index.html">�������� ���ư���</a><br/>
	<a href="../checkout/checkout.html">�����Ϸ� ����</a>
</div>
</body>
</html>







