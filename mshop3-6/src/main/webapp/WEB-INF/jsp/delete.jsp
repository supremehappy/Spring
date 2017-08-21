<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="itemDelete.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/mshop3-5.css"/>
</head>
<body>
<form:form modelAttribute="item" action="delete.html" method ="post" enctype="multipart/form-data">
	<form:hidden path="itemId"/>
	<div align="center" class="body">
		<h2><font color="green">
			<spring:message code="itemDelete.title"/>
		</font></h2>
		
		<table>
			<tr height="40px">
				<td>상품이름</td>
				<td>
					<form:input path="itemName" cssClass="itemName" maxlength="20"/>
				</td>
			</tr>
			<tr height="40px">
				<td>상품가격</td>
				<td>
					<form:input path="price" cssClass="price" maxlength="10"/>
				</td>
			</tr>
			<tr height="40px">
				<td>파일</td>
				<td>
					<img alt="" src="${pageContext.request.contextPath }/upload/${imageName}" height="120" width="250">
				</td>
			</tr>
			<tr height="40px">
				<td>상품설명</td>
				<td>
					<form:input path="description" cssClass="description"/>
				</td>
			</tr>
		</table><br>
		
		<input type="submit" value="삭제"/>
		<input type="reset" value="취소"/>
		
		<a href="index.html">돌아가기</a>
	</div>
</form:form>
</body>
</html>