<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/gshop/header.jsp" %>
<body>

	<form:form modelAttribute="login" action="../login/loginResult.html" commandName="login">

		<div align="center">
			<br>
			<c:choose>
				<c:when test="${not empty message }">
					<p><font color="red">${message }</font></p>
					<br>
				</c:when>
			</c:choose>
			
			<h2>ID</h2>
			<form:input path="user_id"/>
			<font color="red"><form:errors path="user_id"/></font>
			<br>
			<h2>PW</h2>
			<form:password path="password"/>
			<font color="red"><form:errors path="password"/></font>
		</div>
		<br>
		<div align="center">
			<input type="submit" class="btn btn-info" value="login">
			<a href="../user/userInputForm.html" class="btn btn-info" role="button">join</a>
			<a href="../userMyPage/selectUser_id.html" class="btn btn-info" role="button">id 찾기</a>
			<a href="../userMyPage/selectPassword.html" class="btn btn-info" role="button">pw 찾기</a>
		</div>

	</form:form>

</body>
</html>