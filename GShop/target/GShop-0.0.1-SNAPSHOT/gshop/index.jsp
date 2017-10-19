<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">	
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->
	
	<title>GShop Home</title>
</head>
<body>
	<div id="all">
		<div id="content">
			<div class="container">
			
	            <div class="col-md-12">
					<h2>Weekly New</h2>
	            		<div id="main-slider">
	            			<c:forEach var="img" items="${NEW}">
	            				<div class="item">
		            				<a href="../game/gameDetail.html?GAMEID=${img.game_id }">
										<img src="${pageContext.request.contextPath }/upload/game/${img.image2}" alt="" class="img-responsive">
									</a>
								</div>
	            			</c:forEach>
						</div><!-- /#main-slider -->
					</div><!-- .col-md-12 end -->
				</div><!-- .container end -->
			
				
				<div id="hot">
					<div class="box">
						<div class="container">
							<div class="col-md-12">
								<h2>Sale this week</h2>
							</div>
						</div>
					</div>
				<div class="container">
					<div class="product-slider">
						<c:forEach var="img" items="${SALE}">
							<div class="item">
								<div class="product">
									<div class="flip-container">
										<div class="flipper">
											<div class="front">
												<a href="../game/gameDetail.html?GAMEID=${img.game_id }">
													<img src="${pageContext.request.contextPath }/upload/game/${img.image1}" alt="${img.game_name }" class="img-responsive">
												</a>
											</div>
											<div class="back">
												<a href="../game/gameDetail.html?GAMEID=${img.game_id }">
													<img src="${pageContext.request.contextPath }/upload/game/${img.image2}" alt="${img.game_name }" class="img-responsive">
												</a>
											</div>
										</div>
									</div>
									<a href="../game/gameDetail.html?GAMEID=${img.game_id }" class="invisible">
									    <img src="${pageContext.request.contextPath }/upload/game/${img.image2}" alt="${img.game_name }" class="img-responsive">
									</a>
									<div class="text">
										<h3><a href="../game/gameDetail.html?GAMEID=${img.game_id }">${img.game_name}</a></h3>
										<c:if test="${img.discount_rate > 0}">
											<p class="price"><del>￦ <fmt:formatNumber groupingUsed="true" value="${img.price}"/></del> ￦ <fmt:formatNumber groupingUsed="true" value="${img.price - (img.price * img.discount_rate / 100)}"/></p>
										</c:if>
										<c:if test="${img.discount_rate == 0}">
											<p class="price">￦ <fmt:formatNumber groupingUsed="true" value="${img.price}"/></p>
										</c:if>
									</div>
									<!-- /.text -->
									
									<c:if test="${img.discount_rate > 0}">
										<div class="ribbon sale">
											<div class="theribbon">- ${img.discount_rate} %</div>
											<div class="ribbon-background"></div>
										</div>
									</c:if>
									<!-- /.ribbon -->
									
									<c:if test="${img.release_date == TODAY}">
		                                <div class="ribbon new">
		                                    <div class="theribbon">NEW</div>
		                                    <div class="ribbon-background"></div>
		                                </div>
									</c:if>
								</div>
								<!-- /.product -->
							</div>
						</c:forEach>
					</div>
				</div>
				
				</div>
				
				<div id="hot">
					<div class="box">
						<div class="container">
							<div class="col-md-12">
								<h2>Most Popular Games</h2>
							</div>
						</div>
					</div>
					<div class="container">
						<div class="product-slider">
							<c:forEach var="img" items="${BEST}">
							<div class="item">
								<div class="product">
									<div class="flip-container">
										<div class="flipper">
											<div class="front">
												<a href="../game/gameDetail.html?GAMEID=${img.game_id }">
													<img src="${pageContext.request.contextPath }/upload/game/${img.image1}" alt="${img.game_name }" class="img-responsive">
												</a>
											</div>
											<div class="back">
												<a href="../game/gameDetail.html?GAMEID=${img.game_id }">
													<img src="${pageContext.request.contextPath }/upload/game/${img.image2}" alt="${img.game_name }" class="img-responsive">
												</a>
											</div>
										</div>
									</div>
									<a href="../game/gameDetail.html?GAMEID=${img.game_id }" class="invisible">
									    <img src="${pageContext.request.contextPath }/upload/game/${img.image2}" alt="${img.game_name }" class="img-responsive">
									</a>
									<div class="text">
										<h3><a href="../game/gameDetail.html?GAMEID=${img.game_id }">${img.game_name}</a></h3>
										<c:if test="${img.discount_rate > 0}">
											<p class="price"><del>￦ <fmt:formatNumber groupingUsed="true" value="${img.price}"/></del> ￦ <fmt:formatNumber groupingUsed="true" value="${img.price - (img.price * img.discount_rate / 100)}"/></p>
										</c:if>
										<c:if test="${img.discount_rate == 0}">
											<p class="price">￦ <fmt:formatNumber groupingUsed="true" value="${img.price}"/></p>
										</c:if>
									</div>
									<!-- /.text -->
									
									<c:if test="${img.discount_rate > 0}">
										<div class="ribbon sale">
											<div class="theribbon">- ${img.discount_rate} %</div>
											<div class="ribbon-background"></div>
										</div>
									</c:if>
									<!-- /.ribbon -->
									
									<c:if test="${img.release_date == TODAY}">
		                                <div class="ribbon new">
		                                    <div class="theribbon">NEW</div>
		                                    <div class="ribbon-background"></div>
		                                </div>
									</c:if>
								</div>
								<!-- /.product -->
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			
		</div><!-- #content end -->
	</div><!-- #all end -->
<%@ include file="/gshop/footer.jsp" %>	

</body>
</html>