<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/mshop3-2.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

	<div ailgn="center" class="body">
		<h2>login success</h2>
		Hi, ${loginUser.id }!
	</div>
	
	<a href ="../index/index.html">* 목록으로 돌아가기</a>
	<a href ="../checkout/checkout.html">* 계산하러 가기</a>
</body>
</html>
