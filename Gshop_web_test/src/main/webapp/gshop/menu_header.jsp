<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<table class="header">
	<tr>
		<td width="160">
			<a href="#">■ 목록으로 돌아가기</a>
		</td>
		<td width="160">
			<a href="#">■ 계산하러 가기</a>
		</td>
		<td width="160">
			<a href="#">■ 카트 확인하기</a>
		</td>
		<td width="160">
			<a href="#">■ 카트 비우기</a>
		</td>
		<td width="160">
		<c:choose>
			<c:when test="${not empty loginUser }">
				<font color="red">환영합니다.<br/>
				<c:out value="${sessionScope.loginUser }">님</c:out>
				<br>
				<a href="../gshop/login_out/logout.jsp">* 로그아웃하기</a>
				</font>
			</c:when>
			<c:when test="${not empty loginAdmin }">
				<font color="red">환영합니다.<br/>
				<c:out value="${sessionScope.loginAdmin }">님</c:out>
				<br>
				<a href="../gshop/login_out/logout.jsp">* 로그아웃하기</a>
				</font>
			</c:when>			
			<c:when test="${empty loginUser }">
				<font color="red">
					<a href="../gshop/login_out/loginForm.jsp">■ 로그인 하기</a>
				</font>
			</c:when>		
		</c:choose>
		</td>
	</tr>
	</table>
</div>