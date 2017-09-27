<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>GShop Home</title>
</head>

<body>
<c:if test="${ empty BBS_DETAIL }">
	존재하지 않는 게시글입니다.
</c:if>
<c:if test="${ !empty BBS_DETAIL }">
<table width="100%" border="1">
	<tr>
		<td>글제목</td>
		<td>[${ BBS_DETAIL.header_name }] ${ BBS_DETAIL.post_title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${ BBS_DETAIL.nickname }</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${ BBS_DETAIL.view_count + 1 }</td>
	</tr>
	<tr>
		<td colspan="2" align="left">
			<img alt="" width="30" height="30" border="0" src="../upload/${ BBS_DETAIL.image1}""><br>
			<img alt="" width="30" height="30" border="0" src="../upload/${ BBS_DETAIL.image2}""><br>
			<img alt="" width="30" height="30" border="0" src="../upload/${ BBS_DETAIL.image3}""><br>
			<img alt="" width="30" height="30" border="0" src="../upload/${ BBS_DETAIL.image4}""><br>
			<img alt="" width="30" height="30" border="0" src="../upload/${ BBS_DETAIL.image5}""><br>
			${ BBS_DETAIL.post_content }
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:goReply()">[답글]</a>
			<a href="javascript:goModify()">[수정]</a>
			<a href="javascript:goDelete()">[삭제]</a>
			<a href="../community/list.html">[목록]</a>
		</td>
	</tr>
</table>
</c:if>
<script type="text/javascript">
function goReply(){
	document.move.action="../community/input.html";
	document.move.submit();
}
function goModify(){
	document.move.action="../community/update.html";
	document.move.submit();
}
function goDelete(){
	document.move.action="../community/delete.html";
	document.move.submit();
}
</script>
<form name="move" method="post">
	<input type="hidden" name="seq" value="${ BBS_DETAIL.seq }"/>
	<input type="hidden" name="parentid" value="${ BBS_DETAIL.seq }"/>
	<input type="hidden" name="groupid" value="${ BBS_DETAIL.group_id }"/>
</form>
</body>
</html>