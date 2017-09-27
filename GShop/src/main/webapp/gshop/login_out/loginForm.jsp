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
		
		<c:choose>
			<c:when test="${param.USER_UPLOAD !=null }">
				<h2>글 올리려면 로그인이 필요합니다.</h2>
				<div align="center">
					<h2>ID</h2>
					<form:input path="user_id"/>
					<font color="red"><form:errors path="user_id"/></font>
					<br>
					<h2>PW</h2>
					<form:password path="password"/>
					<font color="red"><form:errors path="password"/></font>
				</div>
				<div align="center">
					<input type="submit" class="btn btn-info" value="login">
					<a href="#" class="btn btn-info" role="button">join</a>
					<a href="#" class="btn btn-info" role="button">id 찾기</a>
					<a href="#" class="btn btn-info" role="button">pw 찾기</a>
				</div>
			</c:when>
			<c:when test="${param.ADMIN_UPLOAD !=null }">
				<h2>글 올릴 수 있는 권한이 없습니다.</h2>
				<div align="center">
					<h2>ID</h2>
					<form:input path="user_id"/>
					<font color="red"><form:errors path="user_id"/></font>
					<br>
					<h2>PW</h2>
					<form:password path="password"/>
					<font color="red"><form:errors path="password"/></font>
				</div>
				<div align="center">
					<input type="submit" class="btn btn-info" value="login">
					<a href="#" class="btn btn-info" role="button">join</a>
					<a href="#" class="btn btn-info" role="button">id 찾기</a>
					<a href="#" class="btn btn-info" role="button">pw 찾기</a>
				</div>
			</c:when>
			<c:otherwise>
				<div align="center">
					<h2>ID</h2>
					<form:input path="user_id"/>
					<font color="red"><form:errors path="user_id"/></font>
					<br>
					<h2>PW</h2>
					<form:password path="password"/>
					<font color="red"><form:errors path="password"/></font>
				</div>
				<div align="center">
					<input type="submit" class="btn btn-info" value="login">
					<a href="#" class="btn btn-info" role="button">join</a>
					<a href="#" class="btn btn-info" role="button">id 찾기</a>
					<a href="#" class="btn btn-info" role="button">pw 찾기</a>
				</div>
			</c:otherwise>
		</c:choose>
	</form:form>

</body>
</html>