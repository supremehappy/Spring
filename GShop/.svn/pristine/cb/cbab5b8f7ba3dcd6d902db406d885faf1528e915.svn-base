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
	<title>게시판 글쓰기</title>
</head>

<body>
<script type="text/javascript">
function validate(form){
	if(form.post_title.value =="") {
		alert("제목을 입력하세요."); 
		return false;
	}
	if(form.post_content.value =="") {
		alert("내용을 입력하세요."); 
		return false;
	}
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
				<h1>커뮤니티 게시글 작성</h1>
		
<form:form modelAttribute="bbsGenre" action="../community/insert.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
	<c:if test="${ ! empty BBS_DETAIL.group_id }">
		<form:hidden path="group_id" value="${ BBS_DETAIL.group_id }"/>
	</c:if>
	<c:if test="${ ! empty BBS_DETAIL.parent_id }">
		<form:hidden path="parent_id" value="${ BBS_DETAIL.parent_id }"/>
	</c:if>
	<form:hidden path="view_order" value="${ BBS_DETAIL.view_order }"/>
	<form:hidden path="post_pw" value="1234"/>
	<table class="table table-bordered">
		<tbody>
		<tr>
			<td>말머리</td>
			<td><form:select path="header_id" items="${ HEADER }" itemValue="header_id" itemLabel="header_name"/>
			</td>
		</tr>		
		<tr>
			<td>글제목</td>
			<c:choose>
			<c:when test="${ ! empty BBS_DETAIL.post_title }">
			<td><form:input path="post_title" value="${ BBS_DETAIL.post_title }"/></td>
			</c:when>
			<c:otherwise>
			<td><form:input path="post_title" size="40"/>
				<font color="red"><form:errors path="post_title"/></font>
			</td>
			</c:otherwise>
			</c:choose>
			
		</tr>	
		<tr>
			<td>닉네임</td>
			<td><form:input path="nickname" value="${ NICKNAME }" readOnly="true"/>
			</td>
		</tr>
		<tr>
			<td>이미지1</td>
			<td><input type="file" name="image" size="40"/></td>
		</tr>
		<tr>
			<td>이미지2</td>
			<td><input type="file" name="image" size="40"/></td>
		</tr>	
		<tr>
			<td>이미지3</td>
			<td><input type="file" name="image" size="40"/></td>
		</tr>	
		<tr>
			<td>이미지4</td>
			<td><input type="file" name="image" size="40"/></td>
		</tr>	
		<tr>
			<td>이미지5</td>
			<td><input type="file" name="image" size="40"/></td>
		</tr>		
		<tr>
			<td>글내용</td>
			<td><form:textarea cols="40" rows="8" path="post_content"/>
				<font color="red"><form:errors path="post_content"/></font>
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