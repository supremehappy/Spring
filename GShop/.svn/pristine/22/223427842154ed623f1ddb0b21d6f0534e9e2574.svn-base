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

<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box">
				<h1>커뮤니티 게시글 수정</h1>

<form:form modelAttribute="bbsGenre" action="../community/update.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
	<form:hidden path="post_pw" value="1234"/>
	<table class="table table-bordered">
		<tbody>
		<tr>
			<td>글번호</td>
			<td><form:input path="seq" value="${ BBS_UPDATE.seq }" readOnly="true"/></td>
		</tr>
		<tr>
			<td>말머리</td>
			<td>
				<form:select path="header_id" items="${ HEADER }" itemValue="header_id" itemLabel="header_name" selected="${ BBS_UPDATE.header_id }"/>
			</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><form:input path="post_title" value="${ BBS_UPDATE.post_title }" size="40"/>
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
				<textarea rows="8" cols="40" name="POST_CONTENT">${BBS_UPDATE.post_content}</textarea>
			</td>
		</tr>	
		</tbody>	
	</table>
	<div align="center">
		<input type="submit" class="btn btn-info" value="등 록"/>
		<input type="button" class="btn btn-info" value="취 소" onclick="history.go(-1)"/>
	</div>	
</form:form>

				</div><!-- .box end -->
			</div><!-- .col-md-12 end -->
		</div><!-- .container end -->
	</div><!-- #content end -->
</div><!-- #all end -->
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>