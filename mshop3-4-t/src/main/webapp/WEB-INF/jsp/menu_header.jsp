<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<table class="header">
	<tr>
		<td width="160">
		<a href="../index/index.html">�� ������� ���ư���</a>
		</td>
		<td width="160">
		<a href="../checkout/checkout.html">�� ����Ϸ� ����</a>
		</td>
		<td width="160">
		<a href="../cart/cartConfirm.html">�� īƮ Ȯ���ϱ�</a>
		</td>
		<td width="160">
		<a href="../cart/cartClear.html">�� īƮ ����</a>
		</td>
		<td width="160">
		<c:choose>
			<c:when test="${not empty loginUser }">
				<font color="red">ȯ���մϴ�.<br/>
				<c:out value="${loginUser.userId }"></c:out>��
				<br/>
				<a href="../logout/logout.html">�� �α׾ƿ� �ϱ�</a>
				</font>
			</c:when>		
			<c:when test="${empty loginUser }">
				<font color="red">
					<a href="../loginform/login.html">�� �α��� �ϱ�</a>
				</font>
			</c:when>		
		</c:choose>
		</td>
	</tr>
	</table>
</div>







