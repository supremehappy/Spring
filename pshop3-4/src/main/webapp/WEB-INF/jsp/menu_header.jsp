<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<table class="header">
	<tr>
		<td width="160">
			<a href="../index/index.html">■ 목록으로 돌아가기</a>
		</td>
		<td width="160">
			<a href="../checkout/checkout.html">■ 계산하러 가기</a>
		</td>
		<td width="160">
			<a href="../cart/cartConfirm.html">■ 카트 확인하기</a>
		</td>
		<td width="160">
			<a href="../cart/cartClear.html">■ 카트 비우기</a>
		</td>
		<td width="160">
		<c:choose>
			<c:when test="${not empty loginUser }">
				<font color="red">환영합니다.<br/>
				<c:out value="${loginUser.userId }">님</c:out>
				</font>
			</c:when>		
			<c:when test="${empty loginUser }">
				<font color="red">
					<a href="../loginform/login.html">■ 로그인 하기</a>
				</font>
			</c:when>		
		</c:choose>
		</td>
	</tr>
	</table>
</div>