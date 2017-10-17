<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중복 체크</title>
<script type="text/javascript">                     
	
    // 회원가입창의 아이디 입력란의 값을 가져온다.
    function pValue(){    	
        document.getElementById("idinput").value = opener.document.userInfo.user_id.value;    	
    }       
    
    // 사용하기 클릭 시 부모창으로 값 전달 
    function sendCheckValue(){ 
    	// 중복체크 결과인 idCheck 값을 전달한다.
        opener.document.userInfo.user_idUnCheck.value ="true";
        // 회원가입 화면의 ID입력란에 값을 전달
        opener.document.userInfo.user_id.value = document.getElementById("idinput").value;
        
        if (opener != null) {
            opener.chkForm = null;
            self.close();
        }    
    }
    
    function idCheck(){      	
    	document.move.action="../user/userOverlapCheck.html";
    	document.move.user_id.value=document.origin.user_id.value;    	
    	document.move.submit();
     	opener.document.getElementById("user_id2").value = document.origin.idinput.value;
    }    
</script>
    
</head>
<body onload="pValue()">
<form  name="origin">
<div align="center"> 
    <br>
    <b><font size="4" color="gray">ID 중복체크</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
       <input type="text" name="user_id" id="idinput">                        
       <input type="button" value="중복확인" onclick="idCheck()">
        <div id="msg"></div>
      	<br>
      	<font size=3 color="red">${message}</font>
        <br>
        <br>        
        <input id="useBtn" type="submit" value="사용하기" onclick="sendCheckValue()">
        <input id="cancelBtn" type="button" value="취소" onclick="window.close()">
    	</div>
	</div>   
</form>  
<form name="move" method="post">
	<input type="hidden" name="user_id">
</form>
</body>
</html>
