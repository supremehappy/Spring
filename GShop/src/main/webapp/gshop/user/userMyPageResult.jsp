<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>MaPage</title>
</head>
<body>

<h3 align="center">MyPage</h3>
	
	<table border="1" align="left" style="margin-left:50px">
		<tr><td><img src="../gshop/user/upload/${USER.picture_name}"  width="170"/></td></tr>
		<tr><td colspan="2" align="center">
        <a href="#">수정</a>&emsp;
		<a href="#">탈퇴</a>&emsp;
		<a href="#">충전</a>
		</td></tr>
	</table>
	
	<table border="1" width="250" align="center">	
		<tr><td>닉네임</td>
		<td>${USER.nickname}</td>	
		</tr>
		
		<tr><td>이름</td>
		<td>${USER.user_name}</td>	
		</tr>
		
		<tr><td colspan="2">구매 내역</td>		
		</tr>
		
		<tr><td colspan="2">찜 리스트</td>		
		</tr>
	</table>

</body>
</html>