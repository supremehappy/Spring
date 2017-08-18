<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="itemAdd.title"/></title>
<link rel="stylesheet" type="text/css" href="../css/mshop3-5.css"/>
</head>
<body>
<script type="text/javascript">
function sendForm(){
	document.form.submit();
}
</script>

<form:form modelAttribute="item" action="register.html" enctype="multipart/form-data" method="post" name="form">
	<div align="center" class="body">
	<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
	
	<table>
		<tr height="40px">
			<td>상품번호</td>
			<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td>
			<td><font color="red"><form:errors path="itemId"/></font></td>
		</tr>
		<tr height="40px">
			<td>상품이름</td>
			<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td>
			<td><font color="red"><form:errors path="itemName"/></font></td>
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
			<td><form:input path="description" cssClass="description"/></td>
			<td><font color="red"><form:errors path="description"/></font></td>
		</tr>
	</table>
	<table>
		<tr><td>
		<input type="submit" value="submit"/>
		<input type="button" value="등 록" onClick="sendForm()"/>
		<input type="reset" value="취소"/><br>
		</td></tr>
	</table>
	</div>
</form:form>
</body>
</html>