<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중복 체크</title>
<script type="text/javascript">                     
	
    // 회원가입창의 닉네임 입력란의 값을 가져온다.
    function pValue(){    	
        document.getElementById("nicknameinput").value = opener.document.userInfo.nickname.value;    	
    }       
    
    // 사용하기 클릭 시 부모창으로 값 전달 
    function sendCheckValue(){
    	// 중복체크 결과인 nicknameCheck 값을 전달한다.
        opener.document.userInfo.nicknameUnCheck.value ="true";
        // 회원가입 화면의 nickname입력란에 값을 전달
        opener.document.userInfo.nickname.value = document.getElementById("nicknameinput").value;
        
        if (opener != null) {
            opener.chkForm2 = null;
            self.close();
        }    
    }
    
    function nicknameCheck(){      	
    	document.move.action="../user/nicknameOverlapCheck.html";
    	document.move.nickname.value=document.origin.nickname.value;    	
    	document.move.submit();
     	opener.document.getElementById("nickname2").value = document.origin.nicknameinput.value;
    }    
</script>
    
</head>
<body onload="pValue()">
<form  name="origin">
<div align="center"> 
    <br>
    <b><font size="4" color="gray">닉네임 중복체크</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
       <input type="text" name="nickname" id="nicknameinput">                        
       <input type="button" value="중복확인" onclick="nicknameCheck()">
        <div id="msg"></div>
      	<br>
      	<font size=3 color="red">${message}</font>
        <br>
        <br>
        <c:if test="${empty VVV}">
        	 <input id="useBtn" type="submit" value="사용하기" onclick="sendCheckValue()">
        </c:if>       
        <input id="cancelBtn" type="button" value="취소" onclick="window.close()">
    	</div>
	</div>   
</form>  
<form name="move" method="post">
	<input type="hidden" name="nickname">
</form>
</body>
</html>
