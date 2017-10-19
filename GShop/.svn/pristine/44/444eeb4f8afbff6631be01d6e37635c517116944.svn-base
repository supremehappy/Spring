<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GShop</title>
	<!-- fotorama.css & fotorama.js. -->
	<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->
	<style>
		table {
			font-size: 11px;
		}
	</style>
</head>

<body>
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="row" id="productMain">
						<div class="col-sm-12">
							<div id="mainImage">
								<img src="../upload/game/${GAME_ITEM.image2}" alt="" class="img-responsive">
							</div>
							<c:if test="${GAME_ITEM.discount_rate > 0}">
								<div class="ribbon sale">
									<div class="theribbon">- ${GAME_ITEM.discount_rate} %</div>
									<div class="ribbon-background"></div>
								</div>
							</c:if>
							<!-- /.ribbon -->
							<c:if test="${TODAY == GAME_ITEM.release_date}">
								<div class="ribbon new">
									<div class="theribbon">NEW</div>
									<div class="ribbon-background"></div>
								</div>
							</c:if>
							<!-- /.ribbon -->
						</div>
						<!-- 가격정보 -->
						<div class="col-sm-12">
							<div class="box">
								<h1 class="text-center">${GAME_ITEM.game_name}</h1>
								<p class="goToDescription"><a href="#details" class="scroll-to">Scroll to product details</a>
								</p>
								<c:if test="${GAME_ITEM.discount_rate > 0 }">
									<p class="price">
										<font color="gray" size="3">￦ <del><fmt:formatNumber value="${GAME_ITEM.price}" type="number"/></del></font><br>
										￦ <fmt:formatNumber groupingUsed="true" value="${GAME_ITEM.price - (GAME_ITEM.price * GAME_ITEM.discount_rate / 100)}"/>
									</p>
								</c:if>
								<c:if test="${GAME_ITEM.discount_rate == 0}">
									<p class="price">￦ <fmt:formatNumber value="${GAME_ITEM.price}" type="number"/></p>
								</c:if>
									
								<p class="text-center buttons">
									<c:choose>
										<c:when test="${AUTHORITY_USER}">
											<a href="../order/inputForm.html?GAME_ID=${GAME_ITEM.game_id}" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Purchase</a> 
										</c:when>
										<c:otherwise></c:otherwise>
									</c:choose>
									<c:if test="${AUTHORITY_USER}">
										<c:choose>
											<c:when test="${isFavorite}">
												<a href="#" onclick="deleteFavorite();" class="btn btn-primary"><i class="fa fa-heart"></i> Favorite</a>
											</c:when>
											<c:otherwise>
												<a href="#" onclick="insertFavorite();" class="btn btn-default"><i class="fa fa-heart"></i> Favorite</a>
											</c:otherwise>
										</c:choose>
									</c:if>
								</p>
							</div>
						</div><!-- .col-sm-12 end -->
		
						<!-- 이미지 썸네일 -->
						<div class="row" id="thumbs">
							<c:if test="${ !empty GAME_ITEM.image2}">
								<div class="col-xs-3">
									<a href="../upload/game/${GAME_ITEM.image2}" class="thumb">
										<img src="../upload/game/${GAME_ITEM.image2}" alt="" class="img-responsive">
									</a>
								</div>
							</c:if>
							<c:if test="${ !empty GAME_ITEM.image3}">
								<div class="col-xs-3">
									<a href="../upload/game/${GAME_ITEM.image3}" class="thumb">
										<img src="../upload/game/${GAME_ITEM.image3}" alt="" class="img-responsive">
									</a>
								</div>
							</c:if>
							<c:if test="${ !empty GAME_ITEM.image4}">
								<div class="col-xs-3">
									<a href="../upload/game/${GAME_ITEM.image4}" class="thumb">
										<img src="../upload/game/${GAME_ITEM.image4}" alt="" class="img-responsive">
									</a>
								</div>
							</c:if>
							<c:if test="${ !empty GAME_ITEM.image5}">
								<div class="col-xs-3">
									<a href="../upload/game/${GAME_ITEM.image5}" class="thumb">
										<img src="../upload/game/${GAME_ITEM.image5}" alt="" class="img-responsive">
									</a>
								</div>
							</c:if>
						</div><!-- #thumb end -->
		
						<!-- 게임 상세내용 -->
						<div class="box" id="details">
							<div class="row">
								<p>
								<h1 class="text-center">${GAME_ITEM.game_name}</h1>
								<hr>
								<div class="col-sm-4">
									<img src="../upload/game/${GAME_ITEM.image1}" width="270">
									<h4>GENRE</h4>
									<ul>
										<li>${GAME_ITEM.genre_name}
										</li>
									</ul>
									<h4>RELEASE DATE</h4>
									<ul>
										<li>${GAME_ITEM.release_date}
										</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h4>AGE RATING</h4>
									<ul>
										<li>${GAME_ITEM.grade_desc}
										</li>
									</ul>
									<h4>DEVELOPER</h4>
									<ul>
										<li>${GAME_ITEM.developer}</li>
									</ul>
									<h4>PUBLISHER</h4>
									<ul>
										<li>${GAME_ITEM.developer}</li>
									</ul>
								</div>
								<div class="col-sm-4">
									<h4>SYSTEM REQUIREMENTS</h4>
									<ul>
										<li>${GAME_ITEM.os_name}</li>
										<li>${GAME_ITEM.cpu}</li>
										<li>${GAME_ITEM.memory} GB RAM</li>
										<li>${GAME_ITEM.capacity} GB 사용 가능 공간</li>
										<li>${GAME_ITEM.vga}</li>
									<c:if test="${ ! empty GAME_ITEM.network}"><li>${GAME_ITEM.network}</li></c:if>
									</ul>
								</div>
							</div>
							<hr>
							<div class="social">
								<blockquote>
									<h4>ABOUT THIS GAME</h4>
									<p><em>${GAME_ITEM.comments}</em>
									</p>
								</blockquote>
							</div>
						</div><!-- #detail end -->
		
		
						<div style="width:100%; text-align:right;">
							<c:if test="${AUTHORITY_ADMIN}">
								<a href="#" onClick="goStatusModify()" class="btn btn-primary"><i class="fa fa-trash-o"></i> Delete</a>
								<a href="../game/updateForm.html?GAMEID=${GAME_ITEM.game_id}" class="btn btn-primary"><i class="fa fa-trash-o"></i> Modify</a>
							</c:if>
							<a href="#" onclick="location.href='../game/gameList.html?PAGENO=${PAGE_NO}'" class="btn btn-primary"><i class="fa fa-bars"></i> List</a>
						</div>
						<hr>
						<div class="box">
							<div class="row">
								<div>
									<c:import url="../bbs/bbsList.html?GAMEID=${GAME_ITEM.game_id}"/>
								</div>
							</div>
						</div>
					</div><!-- #productMain end -->
				</div>
			</div><!-- #container end -->
			<script>
				function insertFavorite() {/* 찜하기 등록 */
				    var ok = confirm("게임을 찜하시겠습니까?")
			        if (ok == true) {
						location.href="../game/favoriteGame.html?GAMEID=${GAME_ITEM.game_id}";
					} else {
						alert("취소 되었습니다.")
					}
				}
				function deleteFavorite() {/* 찜하기 삭제 */
				    var ok = confirm("찜하기를 취소하시겠습니까?")
			        if (ok == true) {
						location.href="../game/favoriteGame.html?GAMEID=${GAME_ITEM.game_id}";
					} else {
						alert("취소 되었습니다.")
					}
				}
			
				function goStatusModify() {/* 게임 삭제 */
				    var ok = confirm("상태를 변경 하시겠습니까?")
			        if (ok == true) {
						location.href="../game/modifyGameStatus.html?GAMEID=${GAME_ITEM.game_id}";
					} else {
						alert("취소 되었습니다.")
					}
				}
			</script>
		</div><!-- #content end -->
	</div><!-- #all end -->
<%@ include file="/gshop/footer.jsp" %>	
</body>
</html>
