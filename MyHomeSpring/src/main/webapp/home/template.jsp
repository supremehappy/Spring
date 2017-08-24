<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 집</title>
</head>
<body>
<h2 align="center">우리집에 오신것을 환영합니다.</h2>
<table border="1" cellpadding="10">
<tr>
	<td width="190" valign="top">
		<c:choose>
			<c:when test="${sessionScope.loginUser == null}">
				<jsp:include page="login.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="logout.jsp"/>
			</c:otherwise>
		</c:choose>
		<a href="../home/intro.html?BODY=intro.jsp">우리집 소개</a><br/>
		<a href="../home/bbsTemplate.html">게시판 글쓰기</a><br/>
		<a href="../read/read.html">게시판 글읽기</a><br/>
		<a href="">상품 등록</a><br/>
		<a href="../product/get.html">상품 목록</a><br/>
		<a href="../cart/show.html">장바구니</a><br/>
		<a href="../write/writeForm.html">이미지 게시글 및 답글 작성</a><br/>
		<a href="../write/writeList.html">이미지 게시판 보기</a>
	</td>
	<td width="650" valign="top">
		<c:choose>
			<c:when test="${BODY != null }">
				<jsp:include page="${BODY }"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="front.jsp"/>
			</c:otherwise>
		</c:choose>
	</td>
</tr>
</table>
</body>
</html>



















