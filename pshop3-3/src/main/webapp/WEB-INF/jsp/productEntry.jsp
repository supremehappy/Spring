<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pshop3-3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품등록 화면</title>
</head>
<body>
<body>
	<div align="center" calss="body">
			<h2>상품등록</h2>
			<form:form modelAttribute="product" method="post" action = "productEntry.html">
				<spring:hasBindErrors name="product">
					<font color="red">
						<c:forEach var="error" items="${errors.globalErrors }">
							<spring:message code="${error.code }" />
						</c:forEach>
					</font>
				</spring:hasBindErrors>
				
				<table>
					<tr height="40px">
						<td>글번호</td>
						<td>
							<form:input path="pid" maxlength="10" cssClass="pid"/>
							<font color="red"><form:errors path="pid"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>그룹번호</td>
						<td>
							<form:input path="group_id" maxlength="10" cssClass="group_id"/>
							<font color="red"><form:errors path="group_id"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>부모번호</td>
						<td>
							<form:input path="parent_id" maxlength="10" cssClass="parent_id"/>
							<font color="red"><form:errors path="parent_id"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>정렬번호</td>
						<td>
							<form:input path="order_no" maxlength="10" cssClass="order_no"/>
							<font color="red"><form:errors path="order_no"/></font>
						</td>
					</tr>				
					<tr height="40px">
						<td>작성자ID</td>
						<td><form:input path="id" maxlength="20" cssClass="id"/>
						<font color="red"><form:errors path="id"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>상품명</td>
						<td>
							<form:input path="name" maxlength="20" cssClass="name"/>
							<font color="red"><form:errors path="name"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>가격</td>
						<td>
							<form:input path="price" maxlength="20" cssClass="price"/>
							<font color="red"><form:errors path="price"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>내용</td>
						<td>
							<form:input path="content" maxlength="50" cssClass="content"/>
							<font color="red"><form:errors path="content"/></font>
						</td>
					</tr>
					<tr height="40px">
						<td>등록일</td>
						<td>
							<form:input path="p_date" maxlength="50" cssClass="p_date"/>
							<font color="red"><form:errors path="p_date"/></font>
						</td>
					</tr>
										
				</table>
				
				<table>
					<tr>
						<td height="40px" align="center">
							<input type="submit" value="상품등록"/>
						</td>
						<td height="40px" align="center">
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</table>
			</form:form>
	</div>
</body>
</body>
</html>