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
<title>회원가입 화면</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

	<div align="center" calss="body">
			<h2>회원가입</h2>
			<form:form modelAttribute="user" method="post" action = "userEntry.html">
				<spring:hasBindErrors name="user">
					<font color="red">
						<c:forEach var="error" items="${errors.globalErrors }">
							<spring:message code="${error.code }" />
						</c:forEach>
					</font>
				</spring:hasBindErrors>
				
				<table>
					<tr height="40px">
						<td>사용자ID</td>
						<td><form:input path="id" maxlength="20" cssClass="id"/>
						<font color="red"><form:errors path="id"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>패스워드</td>
						<td>
							<form:password path="password" maxlength="20" cssCalss="password"/>
							<font color="red"><form:errors path="password"/></font>
						</td>
					</tr>					
				</table>
				
				<table>
					<tr>
						<td height="40px" align="center">
							<input type="submit" value="회원가입"/>
						</td>
						<td height="40px" align="center">
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</table>
			</form:form>
	</div>
</body>
</html>