<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/mshop3-3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입완료</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

	<div align="center" class="body">
		<b>
			<font color="blue">사용자 등록이 완료되었습니다.</font>
		</b>
		
		<table>
			<tr height="40px">
				<td>사용자</td><td>${user.userId }</td>
			</tr>
			<tr height="40px">
				<td>패스워드</td><td>${user.password }</td>
			</tr>
			<tr height="40px">
				<td>이름</td><td>${user.userName }</td>
			</tr>
			<tr height="40px">
				<td>우편번호</td><td>${user.postCode }</td>
			</tr>
			<tr height="40px">
				<td>주소</td><td>${user.address }</td>
			</tr>
			<tr height="40px">
				<td>이메일</td><td>${user.email }</td>
			</tr>
			<tr height="40px">
				<td>직업</td><td>${user.job }</td>
			</tr>
			<tr height="40px">
				<td>생년월일</td><td>${user.birthday }</td>
			</tr>
		</table>
	</div>
</body>
</html>