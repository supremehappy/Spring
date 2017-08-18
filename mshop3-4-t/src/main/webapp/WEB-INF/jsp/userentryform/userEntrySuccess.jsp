<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" 
	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form" %>	
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입 완료 화면</title>
<link rel="stylesheet" type="text/css" href="css/mshop3-3.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

<div align="center" class="body">
<b><font color="red">사용자 등록이 완료되었습니다.</font></b>
<table>
	<tr height="40px">
		<td>사용자ID</td><td>${user.userId }</td>
	</tr>
	<tr height="40px">
		<td>패스워드</td><td>${user.password }</td>
	</tr>
	<tr height="40px">
		<td>이 름</td><td>${user.userName }</td>
	</tr>
	<tr height="40px">
		<td>우편번호</td><td>${user.postCode }</td>
	</tr>
	<tr height="40px">
		<td>주 소</td><td>${user.address }</td>
	</tr>
	<tr height="40px">
		<td>이메일</td><td>${user.email }</td>
	</tr>
	<tr height="40px">
		<td>직 업</td><td>${user.job }</td>
	</tr>
	<tr height="40px">
		<td>생년월일</td><td>${user.birthday }</td>
	</tr>
</table>
</div>
</body>
</html>














