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
<script type="text/javascript">
function openDelete(){
	var result = confirm("정말로 탈퇴하시겠습니까?");
 	if(result == false) {
 		return false;
 	}else{
 		location.href="../userMyPage/deleteUser.html";
 		alert("탈퇴 되었습니다.")
 	}
}
</script>

<h3 align="center">MyPage</h3>
	
	<table class="table table-hover">
		<tr><td align="center">
		<c:if test="${!empty USER.picture}">	
			<img src="../upload/${USER.picture}" width="170"/>
		</c:if>	
		<c:if test="${empty USER.picture}">	
			<img src="../upload/XXXXXXXXXXPANDAXXXXXXXX.jpg" width="170"/>
		</c:if>		
		</td></tr>
		<tr><td colspan="2" align="center">
		
        <a href="../userMyPage/userSelect.html">수정</a>&emsp;        
		<a href="javascript:openDelete()">탈퇴</a>&emsp;
		<a href="../charge/chargeForm.html">충전</a>
		</td></tr>
	</table>
	
	
	<table class="table table-hover">	
		<tr><td>닉네임</td>
		<td align="center">${USER.nickname}</td>	
		</tr>
		
		<tr><td>이름</td>
		<td align="center">${USER.user_name}</td>	
		</tr>
		
		<tr><td>구매 내역</td>
		<td align="center">${USER.favorite_games}&nbsp;개</td>		
		</tr>
		
		<tr><td>찜 리스트</td>	
		<td align="center">${USER.bought_games}&nbsp;개</td>		
		</tr>
	</table>

</body>
</html>