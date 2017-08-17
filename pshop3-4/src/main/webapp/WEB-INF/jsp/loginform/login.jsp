<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>            
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/mshop3-2.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

<div align="center" class="body">
	<form:form modelAttribute = "user" method="post" action="login.html">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors }" var="error">
					<spring:message code="${error.code }" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		
		<table>
			<tr height="40px">
				<td>유저ID</td>
				<td>
					<!-- path == name  -->
					<form:input path="id" cssClass="id"/>
					<font color="red"><form:errors path="id"/></font>
				</td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td>
					<form:password path="password" cssClass="password"/>
					<font color="red"><form:errors path="password"/></font>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center"><input type="submit" value="login"/></td>
				<td align="center"><input type="reset" value="cancle"/></td>
			</tr>
		</table>
	</form:form>
	
	<a href="../userentryform/userEntry.html">* 회원가입</a>
</div>
</body>
</html>