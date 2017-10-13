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

<h3 align="center">ID 찾기 결과</h3>	
	
	<table class="table table-hover"  border="1" width="290" align="center">		
		<tr align="center"><td>		
		회원님의 ID는
		<c:if test="${!empty USER_IDSELECT}">			
			<br><font color="red" size="4">${USER_IDSELECT}</font>
			입니다.
		</c:if>
		<c:if test="${empty USER_IDSELECT}">
			가입되어있지 않습니다.<br>
			다시 확인해주세요.
		</c:if>				
		</td>	
		</tr>		
	</table>

</body>
</html>