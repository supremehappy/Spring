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

<h3 align="center">비밀번호  찾기 결과</h3>	
	
	<table class="table table-hover" border="1" width="290" align="center">		
		<c:if test="${empty PASSWORD_SELECT}">	
			<tr align="center"><td>					
				정보를 잘못입력하셨습니다.<br>
				다시 확인해 주세요.							
			</td>	
			</tr>
		</c:if>	
		
		<c:if test="${!empty PASSWORD_SELECT}">			
			<tr align="center"><td>					
			회원님의 비밀번호는
			<br><font color="red" size="4">${PASSWORD_SELECT}</font> 입니다.						
			</td>	
			</tr>
		</c:if>		
	</table>

</body>
</html>