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
		alert("삭제 되었습니다.")
		location.href="../bbs/bbsDetail.html?GAMEID=${GAME_ID}&SEQ=${SEQ}&HEADER=${HEADER_ID}&PAGENO=${PAGE_NO}"
					   
	</script>
</body>
</html>