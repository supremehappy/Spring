<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3 align="center">게시판 글쓰기</h3>

<form:form modelAttribute = "bbs" action="../home/write.html" method="post">
	<h4>
		글 제 목 : <form:input path="title" cssClass="title"/>  
	</h4>
		<font color="red"><form:errors path="title"></form:errors></font>
	<form:textarea path="content" rows="5" cols="80" cssClass="content"/>
	<font color="red"><form:errors path="content"></form:errors></font>
	
	<input type="submit" value="글올리기"/>
	<input type="reset" value="취 소"/>	
</form:form>

 </body>
</html>









