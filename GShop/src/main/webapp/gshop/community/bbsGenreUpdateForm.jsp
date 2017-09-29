<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>GShop Home</title>
</head>

<body>
<script type="text/javascript">
function validate(form){
	var result = confirm("정말로 등록하시겠습니까?");
 	if(result == false) {
 		return false;
 	}
}
</script>
<form:form modelAttribute="bbsGenre" action="../community/update.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
	<table border="1" width="100%">
		<tr>
			<td>글번호</td>
			<td><form:input path="seq" value="${ BBS_UPDATE.seq }" readOnly="true"/></td>
		</tr>
		<tr>
			<td>말머리</td>
			<td><form:select path="header_id" items="${ HEADER }" itemValue="header_id" itemLabel="header_name" selected="${ BBS_UPDATE.header_id }"/>
			${ BBS_UPDATE.header_id }
			</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><form:input path="post_title" value="${ BBS_UPDATE.post_title }" size="40"/>
			</td>
		</tr>	
		<tr>
			<td>비밀번호</td>
			<td><form:password path="post_pw" size="20"/>
				<font color="red"><form:errors path="post_pw"/></font>
			</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><form:input path="nickname" value="${ BBS_UPDATE.nickname }" readOnly="true"/>
			</td>
		</tr>
		<tr>
			<td>이미지1</td>
			<td>
				<input type="file" name="image" size="40"/>
				<img border="0" src="../upload/${ BBS_UPDATE.image1}"">
			</td>
		</tr>
		<tr>
			<td>이미지2</td>
			<td>
				<input type="file" name="image" size="40"/>
				<img border="0" src="../upload/${ BBS_UPDATE.image2}"">
			</td>
		</tr>	
		<tr>
			<td>이미지3</td>
			<td>
				<input type="file" name="image" size="40"/>
				<img border="0" src="../upload/${ BBS_UPDATE.image3}"">
			</td>
		</tr>	
		<tr>
			<td>이미지4</td>
			<td>
				<input type="file" name="image" size="40"/>
				<img border="0" src="../upload/${ BBS_UPDATE.image4}"">
			</td>
		</tr>	
		<tr>
			<td>이미지5</td>
			<td>
				<input type="file" name="image" size="40"/>
				<img border="0" src="../upload/${ BBS_UPDATE.image5}"">
			</td>
		</tr>		
		<tr>
			<td>글내용</td>
			<td>
				<form:textarea rows="8" cols="40" path="post_content" value="${BBS_UPDATE.post_content}"/>
				<font color="red"><form:errors path="post_content"/></font>
			</td>
		</tr>		
		<tr>
			<td colspan="2">
				<input type="submit" value="수 정"/>
				<input type="button" value="취 소" onclick="history.go(-1)">
			</td>
		</tr>	
	</table>
</form:form>
</body>
</html>