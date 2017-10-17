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
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="box">
						
						<div class="new">
							<h5>new game</h5>
							<div class="fotorama" data-arrows="true" data-width="100%" data-ratio="965/643" data-allow-fullscreen="true" data-nav="thumbs" data-autoplay="true">
								<c:forEach var="img" items="${NEW}">
									<a href="../game/gameDetail.html?GAMEID=${img.game_id }" ><img src="${pageContext.request.contextPath }/upload/${img.image2}" alt="${img.game_name }"></a>
								</c:forEach>
							</div>
						</div>
						
						<br>
						
						<div class="sale">
							<h5>sale game</h5>
							<div class="fotorama" data-arrows="true" data-width="100%" data-ratio="965/643" data-allow-fullscreen="true" data-nav="thumbs" data-autoplay="true">
								<c:forEach var="img" items="${SALE}">
									<a href="../game/gameDetail.html?GAMEID=${img.game_id }" ><img src="${pageContext.request.contextPath }/upload/${img.image2}" alt="${img.game_name }"></a>
								</c:forEach>
							</div>
						</div>
						
						<br>
						
						<div class="hot">
							<h5>hot game</h5>
							<div class="fotorama" data-arrows="true" data-width="100%" data-ratio="965/643" data-allow-fullscreen="true" data-nav="thumbs" data-autoplay="true">
								<c:forEach var="img" items="${BEST}">
									<a href="../game/gameDetail.html?GAMEID=${img.game_id }" ><img src="${pageContext.request.contextPath }/upload/${img.image2}" alt="${img.game_name }"></a>
								</c:forEach>
							</div>
						</div>
	
					</div><!-- .box end -->
				</div><!-- .col-md-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
	
	

</body>
</html>