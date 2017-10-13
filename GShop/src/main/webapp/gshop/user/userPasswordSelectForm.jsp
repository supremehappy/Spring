<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>비밀번호 찾기</title>
</head>
<body>
<form:form modelAttribute="user" action="../userMyPage/userPasswordSelectResult.html" method="post" >
	<h3 align="center">비밀번호 찾기</h3>	
	<table class="table table-hover" border="1" width="320" align="center">
	
		<tr><td>ID</td>
		<td><form:input path="user_id" size="30"/><br>
			<font color="red" size="2"><form:errors path="user_id"/></font>		
		</td>	
		</tr>
		
		<tr><td>이름</td>
		<td><form:input path="user_name" size="30"/><br>
			<font color="red" size="2"><form:errors path="user_name"/></font>		
		</td>	
		</tr>
		
		<tr>
		<td>E-Mail</td>
		<td><input type="email" name="email" size="30"/><br>
			<font color="red" size="2"><form:errors path="email"/></font>
		</tr>
	
		<tr align="center">
			<td colspan="2">
			<input type="submit" value="확인"/>					
			</td>
		</tr>
	</table>
</form:form>	
</body>
</html>