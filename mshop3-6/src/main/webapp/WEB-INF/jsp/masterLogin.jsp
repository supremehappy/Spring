<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인 화면</title>
<link rel="stylesheet" type="text/css" href="../css/mshop3-5.css"/>
</head>
<body>
	<div align="center" class="body">
		<h2>관리자 로그인 화면</h2>
		<c:if test="${not empty param.login_error }">
			<font color="red">${SPRING_SECURITY_LAST_EXCEPTION.message }<!-- 예외객체 --></font>
		</c:if>
		
		<form action="j_spring_security_check" method="post">
			<table>
				<tr height="40px">
					<td>유저 ID</td>
					<td><input type="text" class="userId" name="j_username" size="20"/></td>
				</tr>
				<tr height="40px">
					<td>패스워드</td>
					<td><input type="password" class="password" name="j_password" size="20"/></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><input type="submit" value="로그인"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>