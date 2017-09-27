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
<title>회원 가입 페이지</title>
</head>
<body>
<script type="text/javascript">

	function openIdChk(){		
    	window.name = "parentForm";    	
    	window.open("../user/userOverlap.html",
            "chkForm", "width=480, height=250");  
	}
		
	function openNicknameChk(){		
    	window.name = "parentForm2";    	
    	window.open("../user/nicknameOverlap.html",
            "chkForm2", "width=480, height=250");  
	}	
		
	$(document).ready(function() {		  
		  var clareCalendar = {
				  
				  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
				  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
				  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
				  nextText: '다음 달', // next 아이콘의 툴팁.
				  prevText: '이전 달', // prev 아이콘의 툴팁.
				  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가.				  
				  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
				  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
				  currentText: '오늘 날짜' , // 오늘 날짜로 이동하는 버튼 패널
				  closeText: '닫기',  // 닫기 버튼 패널
				  dateFormat: "yymmdd", // 텍스트 필드에 입력되는 날짜 형식.
				  showAnim: "slide", //애니메이션을 적용한다.
				  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
				  dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], // 요일의 한글 형식.
				  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식.	  
		  };
		  $("#datepicker").datepicker(clareCalendar);		 
	});
	
</script>
<h3 align="center">회원 가입</h3>
<form:form modelAttribute="user" action="../user/userInput.html" method="post"
	enctype="multipart/form-data" name="userInfo" >
	
	<table border="1" width="450" align="center">	
		<tr><td>ID</td>
		<td><form:input path="user_id" id ="user_id2" size="30"/>				
			<input type="button" value="중복확인" onclick="openIdChk()">
			<input type="hidden" name="user_idUnCheck" value="false"><br>
            <font color="red" size="2"><form:errors path="user_id"/>${message3}</font> 
            
		</td>		
		</tr>
		
		<tr><td>Password</td>
		<td><form:password path="password" size="30"/><br>
			<font color="red" size="2"><form:errors path="password"/></font>
		</td>
		</tr>
		
		<tr><td>Password 확인</td>
		<td><form:password path="password2" size="30"/>		<br>	
			<font color="red" size="2"><form:errors path="password2"/>${message2}</font>
		</td>
		</tr>
		
		<tr><td>닉네임</td>		
		<td><form:input path="nickname" id ="nickname2" size="30"/>				
			<input type="button" value="중복확인" onclick="openNicknameChk()">
			<input type="hidden" name="nicknameUnCheck" value="false"><br>
            <font color="red" size="2"><form:errors path="nickname"/>${message4}</font>
		</td>		
		</tr>
		
		<tr><td>이름</td>
		<td><form:input path="user_name" size="30"/><br>
			<font color="red" size="2"><form:errors path="user_name"/></font>
		</td>	
		</tr>
		
		<tr><td>E-Mail</td>
		<td><input type="email" name="email" size="30">
		</td>		
		</tr>
		
		<tr><td>Phone</td>
		<td><form:input path="phone" size="30"/><br>
			<font color="red" size="2"><form:errors path="phone"/></font>
		</td>					
		</tr>
		
		<tr><td>주소</td>
		<td><input type="text" name="address" size="30"></td>		
		</tr>
		
		<tr><td>선호 장르</td>
		<td>
		<input type="checkbox" name="genre_arr" value="0">스포츠 &nbsp;
		<input type="checkbox" name="genre_arr" value="1">레이싱&emsp;&nbsp;
		<input type="checkbox" name="genre_arr" value="2">액션
		<br/>
		<input type="checkbox" name="genre_arr" value="3">전략&emsp;&nbsp;&nbsp;
		<input type="checkbox" name="genre_arr" value="4">롤플레잉&nbsp;
		<input type="checkbox" name="genre_arr" value="5">캐주얼
		</td>			
		</tr>
		
		<tr><td>생년월일</td>
		<td><form:input path="birthday" id="datepicker" size="25"/>	<br>		
			<font color="red" size="2"><form:errors path="birthday"/></font>
		</td>
		
		
		<tr><td>성별</td>
		<td>
			<input type="radio" name="gender" value="0" checked>여
			<input type="radio" name="gender" value="1">남
		</tr>
		
		<tr><td>프로필 사진</td>
		<td><input type="file" name="picture" size="30"/></td>
		</tr>		
		
		<tr><td>자기소개</td>
		<td><form:textarea cols="42" rows="8" path="introduce"/>		
		</tr>
		
		<tr align="center">
			<td colspan="2">
			<input type="submit" value="등 록"/>
			<input type="reset" value="취 소" onClick="location.href='../gshop/template.jsp'"/>
			</td>
		</tr>	
	</table>
</form:form>
</body>
</html>