<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">	
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->
	
	<title>GShop Home</title>
</head>
<h2>Weekly New</h2>
<body>
<div class="new">
	<div class="fotorama" data-arrows="true" data-width="100%"
		data-ratio="965/643" data-allow-fullscreen="true"
		data-nav="thumbs" data-autoplay="true">
<c:forEach var="img" items="${NEW}">
	     	<img src="${img.image2}">
	     	<a href="#" ><img src="${img.image2}"></a>
	     </c:forEach>
 </div>
</div>
<div class="sale">
	<div class="fotorama" data-arrows="true" data-width="100%"
		data-ratio="965/643" data-allow-fullscreen="true"
		data-nav="thumbs" data-autoplay="true">
	     
	     <c:forEach var="img" items="${SALE}">
	     	<img src="${img.image2}">
	     	<a href="#" ><img src="${img.image2}"></a>
	     </c:forEach>
	     
 		 
</div>
</div>
<div class="hot">
	<div class="fotorama" data-arrows="true" data-width="100%"
		data-ratio="965/643" data-allow-fullscreen="true"
		data-nav="thumbs" data-autoplay="true">
	     <c:forEach var="img" items="${BEST}">
	     	<img src="${img.image2}">
	     	<a href="#" ><img src="${img.image2}"></a>
	     	</c:forEach>
</div>
</div>
</body>
</html>