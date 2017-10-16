<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GShop</title>
</head>

<body>
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="box">
						<h1>Game</h1>
						<p>In our Ladies department we offer wide selection of the best products we have found and carefully selected worldwide.</p>
						
						<hr>
						
						<c:if test="${ empty GAME_LIST}">
							<table class="table table-hover">
								<tr><td align="center">등록된 게임이 없습니다.</td></tr>
							</table>
						</c:if>
						
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Title</th>
									<th>Price</th>
								</tr>
							</thead>
							<c:forEach var="game" items="${GAME_LIST}">
								<tr>
									<th rowspan="2" width="231">
								    	<%-- <a href="../bbs/bbsDoList.html?GAMEID=${game.game_id}&PAGENO=${PAGE_NO}"><img src="../upload/game/${game.image1}" alt="${game.image1}" width="231px"></a> --%>
								    	<a href="../game/gameDetail.html?GAMEID=${game.game_id}&PAGENO=${PAGE_NO}"><img src="../upload/game/${game.image1}" alt="${game.image1}" width="231px"></a>
							    	</th>
									 <th style="vertical-align: middle">
									 	<%-- <a href="../bbs/bbsDoList.html?GAMEID=${game.game_id}&PAGENO=${PAGE_NO}">${game.game_name}</a> --%>
									 	<a href="../game/gameDetail.html?GAMEID=${game.game_id}&PAGENO=${PAGE_NO}">${game.game_name}</a>
								 	</th>
									<td rowspan="2" align="right" style="padding-right: 10px; vertical-align: middle; max-width: 150px">
										<c:if test="${game.discount_rate > 0}">
											<span class="label label-danger">- ${game.discount_rate}%</span><br><br>
											<font color="#999999" size="2"><span style="text-decoration:line-through"> 
							    			 	<fmt:formatNumber groupingUsed="true" value="${game.price}"/>
						    			 	</span> 원</font><br>
								    		<fmt:formatNumber groupingUsed="true" value="${game.price - (game.price * game.discount_rate / 100)}"/> 원
						    			</c:if>
						    			<c:if test="${game.discount_rate == 0}">
									    	<font color="#999999" size="2"><fmt:formatNumber groupingUsed="true" >${game.price}</fmt:formatNumber> 원</font>
								    	</c:if>
									</td>
								</tr>
								<tr>
									<td><font size="2"><img src="../upload/game/os/${game.os_name}.png" height="12px" alt="${game.os_name}"><br>${game.genre_name}</font></td>
								</tr>
							</c:forEach>
						</table>
						
						
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
									<%-- <c:if test="${CURRENT_PAGE == pageNo}"><!-- 현재 표시된 페이지와 페이지 번호가 같은 경우 -->
										<li class="active">
									</c:if>
									<li><a href="../game/gameList.html?PAGENO=${pageNo}">${pageNo}</a>
										</li><!-- 페이지 번호 클릭시 이동 처리 -->
									<c:if test="${CURRENT_PAGE == pageNo}">
										</li>
									</c:if> --%>
								</c:forEach>
								<li>
									<!-- 다음 페이지 버튼 출력 -->
									<c:if test="${endPage < COUNT}">
										<a href="../game/gameList.html?PAGENO=${startPage + 10}">&raquo;</a><!-- 다음 페이지 링크가 나오는 경우는 시작 페이지보다 10이 많은 경우 -->
									</c:if>
								</li>
							</ul>
						</div>
				
				
						<%-- <div style="width:100%; text-align:center;">
							<!-- 10페이지 이상의 페이징 처리 -->
							<c:set var="startPage" value="${CURRENT_PAGE - (CURRENT_PAGE % 10 == 0 ? 10 : (CURRENT_PAGE % 10)) + 1}"/>
							<c:set var="endPage" value="${startPage + 9}"/><!-- 10페이지 이상일 경우 '1~10'까지 페이지를 표시 -->
							<c:if test="${endPage > COUNT}"><!-- 마지막 페이지가 페이지 수보다 '1~남은 페이지 수' 표시 -->
								<c:set var="endPage" value="${COUNT}"/>
							</c:if>
							<!-- 이전 페이지 버튼 출력 -->
							<c:if test="${startPage > 10}">
								<a href="../game/gameList.html?PAGENO=${startPage - 10}">&laquo;</a><!-- 이전 페이지 링크가 나오는 경우는 시작 페이지보다 10이 적은 경우 -->
							</c:if>
							<!-- 페이지 갯수 출력 -->
							<c:forEach var="pageNo" begin="${startPage}" end="${endPage}">
								<c:if test="${CURRENT_PAGE == pageNo}"><!-- 현재 표시된 페이지와 페이지 번호가 같은 경우 -->
									<font size="3"><b>
								</c:if>
								<a href="../game/gameList.html?PAGENO=${pageNo}">[${pageNo}]</a><!-- 페이지 번호 클릭시 이동 처리 -->
								<c:if test="${CURRENT_PAGE == pageNo}">
									</b></font>
								</c:if>
							</c:forEach>
							<!-- 다음 페이지 버튼 출력 -->
							<c:if test="${endPage < COUNT}">
								<a href="../game/gameList.html?PAGENO=${startPage + 10}">[다음]</a><!-- 다음 페이지 링크가 나오는 경우는 시작 페이지보다 10이 많은 경우 -->
							</c:if>
						</div> --%>
						<div style="width:100%; text-align:right;">
							<c:if test="${AUTHORITY}">
								<a href="../game/gameInputForm.html" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> 게임 등록</a>
							</c:if>
						</div>
					</div><!-- .box end -->
				</div><!-- .col-md-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>