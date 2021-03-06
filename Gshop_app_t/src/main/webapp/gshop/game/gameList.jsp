<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<div data-role="page">
		<%@ include file="/gshop/header.jsp" %>
		
		<div role="main" class="ui-content">
		<h2>Game</h2>
		<!-- 
			fotorama
			<div class="ui-grid-a">
			    <div class="ui-bar ui-bar-a">
					<div class="fotorama">
						fotorama(http://fotorama.io/)
					</div>	
				</div>
			</div>
			 -->
			<br>
			<c:if test="${ empty GAME_LIST}">
				<table class="table">
					<tr>
						<td>등록된 게임이 없습니다.</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${ ! empty GAME_LIST }">
				<c:forEach var="game" items="${GAME_LIST}">
					<div class="ui-body ui-body-a ui-corner-all">
						<a href="../game/gameDetail.html?GAMEID=${game.game_id}">
							<table class="table" width="100%" border="0">
								<tr>
									<td><img src="../upload/game/${game.image1}" alt="${game.image1}" width="100%"></td>
								</tr>
								<tr>
									<th>${game.game_name}</th>
								</tr>
								<tr>
									<td>
										<c:if test="${game.discount_rate > 0}">
											${game.discount_rate}% 할인<br>
											<span style="text-decoration:line-through"> 
												￦ <fmt:formatNumber groupingUsed="true" value="${game.price}"/>
											</span> → 
											￦ <fmt:formatNumber groupingUsed="true" value="${game.price - (game.price * game.discount_rate / 100)}"/>
										</c:if>
										<c:if test="${game.discount_rate == 0}">
											<fmt:formatNumber groupingUsed="true" value="${game.price}"></fmt:formatNumber> 원
										</c:if>
									</td>
								</tr>
								<tr>
									<td><img src="../upload/game/os/${game.os_name}.png" width="20px" alt="${game.os_name}"> ${game.genre_name}</td>
								</tr>
							</table>
						</a>
					</div>
					<br>
				</c:forEach>
			</c:if>
			<!-- 페이징 처리 
			___________________________________________________ -->
			<div class="pages">
				<ul class="pagination">
					<!-- 10페이지 이상의 페이징 처리 -->
					<c:set var="startPage" value="${CURRENT_PAGE - (CURRENT_PAGE % 10 == 0 ? 10 : (CURRENT_PAGE % 10)) + 1}"/>
					<c:set var="endPage" value="${startPage + 9}"/><!-- 10페이지 이상일 경우 '1~10'까지 페이지를 표시 -->
					<c:if test="${endPage > COUNT}"><!-- 마지막 페이지가 페이지 수보다 '1~남은 페이지 수' 표시 -->
						<c:set var="endPage" value="${COUNT}"/>
					</c:if>
					<li>
						<!-- 이전 페이지 버튼 출력 -->
						<c:if test="${startPage > 10}">
							<a href="../game/gameList.html?PAGENO=${startPage - 10}">&laquo;</a><!-- 이전 페이지 링크가 나오는 경우는 시작 페이지보다 10이 적은 경우 -->
						</c:if>
					</li>
					<c:forEach var="pageNo" begin="${startPage}" end="${endPage}">
					<li <c:if test="${CURRENT_PAGE == pageNo}">class="active"</c:if>>								
						<a href="../game/gameList.html?PAGENO=${pageNo}">${pageNo}</a>
					</li>
					</c:forEach>
					<li>
						<!-- 다음 페이지 버튼 출력 -->
						<c:if test="${endPage < COUNT}">
							<a href="../game/gameList.html?PAGENO=${startPage + 10}">&raquo;</a><!-- 다음 페이지 링크가 나오는 경우는 시작 페이지보다 10이 많은 경우 -->
						</c:if>
					</li>
				</ul>
			</div>
		</div>
		
		<%@ include file="/gshop/footer.jsp" %>
	</div>
</html>