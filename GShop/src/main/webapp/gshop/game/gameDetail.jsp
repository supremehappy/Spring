<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="gameDetail.title"/></title>
</head>

<body>
	<h2 align="center">상품 상세</h2>
	[상품번호] : ${ PRODUCT_ITEM.pid }<br/>
	[상품명] : ${ PRODUCT_ITEM.name }<br/>
	[가격] : ${ PRODUCT_ITEM.price }<br/>
	[등록자] : ${ PRODUCT_ITEM.id },[등록일] : ${ PRODUCT_ITEM.p_date }<br/>
	======================================================<br/>
	${ PRODUCT_ITEM.content }
</body>
</html>