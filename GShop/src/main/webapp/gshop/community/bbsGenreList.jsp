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
	<table width="100%" border="1">
		<tr>			
			<td>글번호</td>
			<td>글제목</td>
			<td>닉네임</td>
			<td>작성일</td>
		</tr>
		<c:if test="${ !empty BBS_LIST }">
		<c:forEach var="bbsGenre" items="${ BBS_LIST }">
		<tr>
			<td><a href="../community/detail.html?SEQ=${ bbsGenre.seq }">${ bbsGenre.seq }</a></td>
			<td><a href="../community/detail.html?SEQ=${ bbsGenre.seq }">${ bbsGenre.post_title }</a></td>
			<td>${ bbsGenre.nickname }</td>
			<td>${ bbsGenre.reg_date }</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>