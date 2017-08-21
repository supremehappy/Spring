<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="productEdit.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/mshop3-5.css"/>
</head>
<body>

<form:form modelAttribute="product" action="modify.html" enctype="multipart/form-data" method="post">
	<form:hidden path="pid"/>
	<form:hidden path="pictureUrl"/>
	
	<div align="center" class="body">
	<h2><font color="green"><spring:message code="productEdit.title"/></font></h2>
	
	<table>
		<tr height="40px">
			<td>상품이름</td>
			<td><form:input path="name" cssClass="name" maxlength="20"/></td>
			<td><font color="red"><form:errors path="name"/></font></td>
		</tr>
		<tr height="40px">
			<td>상품가격</td>
			<td><form:input path="price" cssClass="price" maxlength="10"/>&nbsp; 원</td>
			<td><font color="red"><form:errors path="price"/></font></td>
		</tr>
		<tr height="40px">
			<td>파일</td>
			<td><input type="file" name="picture"/></td>
			<td></td>
		</tr>
		<tr height="40px">
			<td>상품설명</td>
			<td><form:textarea path="content" cssClass="content"/></td>
			<td><font color="red"><form:errors path="content"/></font></td>
		</tr>
	</table>
	<table>
		<tr><td>
		<input type="submit" value="변경"/>
		<input type="reset" value="취소"/><br>
		</td></tr>
	</table>
	<a href="index.html">* 돌아가기</a>
	</div>
</form:form>
</body>
</html>