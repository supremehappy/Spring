<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/bbs/jsp_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
		<c:if test="${isFavorite}">
			alert("찜하기 등록 완료.")
			location.href="../game/gameDetail.html?GAMEID=${GAME_ID}"
		</c:if>
		<c:if test="${! isFavorite}">
			alert("찜하기 취소 완료.")
			location.href="../game/gameDetail.html?GAMEID=${GAME_ID}"
		</c:if>
	</script>
</body>
</html>