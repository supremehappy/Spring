<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">�Խ��� �۾���</h3>
<form:form modelAttribute="bbs" action="../home/write.html"
	method="post">
<h4>�� ��:<form:input path="title" cssClass="title"/></h4>
<font color="red"><form:errors path="title"/></font>
<form:textarea path="content" rows="5" cols="80" 
		cssClass="content"></form:textarea>
<font color="red"><form:errors path="content"/></font>
<input type="submit" value="�� �ø���"/>
<input type="reset" value="�� ��"/>		
</form:form>
</body>
</html>




















