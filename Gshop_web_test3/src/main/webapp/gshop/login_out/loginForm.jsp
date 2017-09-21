<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@ include file="/gshop/header.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<form:form action="../login/loginResult.html" method="post" commandName="login" modelAttribute="login">
	  <div class="input-group">
	    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	    <form:input id="id" type="text" class="form-control" path="userId" cssClass="userId" placeholder="Id"/>
	    <font color="red"><form:errors path="userId"/></font>
	    <%-- <form:input id="id" type="text" class="form-control" path="userId" cssClass="userId" placeholder="Id" size="20"/>
	    <font color="red"><form:errors path="userId"/></font> --%>
	  </div>
	  <div class="input-group">
	    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	    <form:input id="password" type="password" class="form-control" path="password" cssClass="password" placeholder="Password"/>
	    <font color="red"><form:errors path="password"/></font>
	    <%-- <form:input id="password" type="password" class="form-control" path="password" cssClass="password" placeholder="Password" size="20"/>
	    <font color="red"><form:errors path="password"/></font> --%>
	  </div>
	  <div align="center">
		  <input type="submit" class="btn btn-info" value="login">
		  <a href="#" class="btn btn-info" role="button">join</a>
		  <a href="#" class="btn btn-info" role="button">id 찾기</a>
		  <a href="#" class="btn btn-info" role="button">pw 찾기</a>
	  </div>
	</form:form>
</body>
</html>