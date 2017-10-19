<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function validate(form) {
			/* if(form.title.value == "") {
				alert("제목을 입력하세요"); return false
			}
			if(form.nick.value == "") {
				alert("닉네임을 입력하세요"); return false
			}
			if(form.password.value == "") {
				alert("암호를 입력하세요"); return false
			}
			if(form.imagename.value == "") {
				alert("이미지 파일을 선택하세요."); return false
			} */
			var result = confirm("정말로 등록하시겠습니까?");
			if(result == false) return false;
		}
	</script>
	<form:form modelAttribute="writing" action="../write/write.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
		<c:if test="${ ! empty writing.group_id }">
			<form:hidden path="group_id" value="${param.groupid}"/>
		</c:if>
		<c:if test="${ ! empty writing.parent_id }">
			<form:hidden path="parent_id" value="${param.parentid}"/>
		</c:if>
		<form:hidden path="order_no" value="${writing.order_no + 1}"/>
		<table border="1" width="100%">
			<tr>
				<td>글제목</td>
				<td><form:input path="title" size="40" value="${title}"/> <font color="red"><form:errors path="title"/></font></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><form:input path="writer_name" size="20"/> <font color="red"><form:errors path="writer_name"/></font></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email" size="40"/></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><form:password path="password" size="20"/><font color="red"><form:errors path="password"/></font></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="image" size="40"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><form:textarea rows="8" cols="40" path="content"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>