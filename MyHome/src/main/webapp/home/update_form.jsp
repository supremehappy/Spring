<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.title.value == ""){
		alert("제목을 입력하세요."); return false;
	}
	if(form.name.value == ""){
		alert("닉네임을 입력하세요."); return false;
	}
	if(form.password.value == ""){
		alert("암호를 입력하세요."); return false;
	}
	if(form.email.value == ""){
		alert("이메일을 입력하세요."); return false;
	}
	var result = confirm("정말로 변경하시겠습니까?");
	if(result == false) return false;
}
</script>
<form action="update.do" method="post" enctype="multipart/form-data"
	onSubmit="return validate(this)">
<input type="hidden" name="id" value="${writing.writing_id }"/>
<table width="100%" border="1">
	<tr><td>글제목</td><td><input type="text" name="title" size="20"
	value="${writing.title }"/></td></tr>
	<tr><td>닉네임</td><td><input type="text" name="name" size="20"
	value="${writing.writer_name }"/></td></tr>
	<tr><td>이메일</td><td><input type="text" name="email" size="30"
	value="${writing.email }"/></td></tr>
	<tr><td>암 호</td><td><input type="password" name="password"
	size="20"/></td></tr>
	<tr><td>이미지</td><td><input type="file" name="image_name"/><br/>
	<img alt="" width="350" height="300" border="0"
	src="uploadfiles/${writing.image_name }"/></td></tr>
	<tr><td>글내용</td><td><textarea rows="8" cols="40"
	name="content">${writing.content }</textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="수 정"/>
	<input type="button" value="취 소" 
	onClick="javascript:history.go(-1)"/>
</table>
</form>
</body>
</html>














