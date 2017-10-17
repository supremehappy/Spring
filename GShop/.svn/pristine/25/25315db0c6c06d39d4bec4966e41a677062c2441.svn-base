<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="box">
						<h2>게임관리</h2>
						<p>The .table-hover class enables a hover state on table rows:</p>            
						
						<form action="../admin/gameManagementSearch.html" method="post">
							<select class="form-control" id="sel1" name="search">
					        
					        	<option value="1">category</option>
						        <option value="0">game name</option>
						        <option value="2">discount rate</option>
							</select>
						
							<input type="text" class="form-control" id="usr" name="input">
							
							<button type="submit" class="btn btn-default">Submit</button>
							<a href="../admin/gameManagement.html" class="btn btn-info" role="button">all</a>
						</form>
						
						<br>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="30">no</th>
									<th width="50">category</th>
									<th width="200">game name</th>
									<th width="50">discount rate</th>
									<th>controll</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty GAME_ALL }">
										<c:forEach var="game" items="${GAME_ALL }">
											<tr>
												<td>${game.game_id }</td>
												<td>${game.genre_name }</td>
												<td><a href="../game/gameDetail.html?GAMEID=${game.game_id }">${game.game_name }</a></td>
												<td>${game.discount_rate }</td>
												<td>
													<a href="../game/updateForm.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">modify</a>
													<a href="../game/modifyGameStatus.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">delete</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty GAME_GAMENAME }">
										<c:forEach var="game" items="${GAME_GAMENAME }">
											<tr>
												<td>${game.game_id }</td>
												<td>${game.genre_name }</td>
												<td><a href="../game/gameDetail.html?GAMEID=${game.game_id }">${game.game_name }</a></td>
												<td>${game.discount_rate }</td>
												<td>
													<a href="../game/updateForm.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">modify</a>
													<a href="../game/modifyGameStatus.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">delete</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty GAME_CATEGORY }">
										<c:forEach var="game" items="${GAME_CATEGORY }">
											<tr>
												<td>${game.game_id }</td>
												<td>${game.genre_name }</td>
												<td><a href="../game/gameDetail.html?GAMEID=${game.game_id }">${game.game_name }</a></td>
												<td>${game.discount_rate }</td>
												<td>
													<a href="../game/updateForm.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">modify</a>
													<a href="../game/modifyGameStatus.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">delete</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty GAME_DISCOUNTRATE }">
										<c:forEach var="game" items="${GAME_DISCOUNTRATE }">
											<tr>
												<td>${game.game_id }</td>
												<td>${game.genre_name }</td>
												<td><a href="../game/gameDetail.html?GAMEID=${game.game_id }">${game.game_name }</a></td>
												<td>${game.discount_rate }</td>
												<td>
													<a href="../game/updateForm.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">modify</a>
													<a href="../game/modifyGameStatus.html?GAMEID=${game.game_id }" class="btn btn-info" role="button">delete</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</tbody>
						</table>
						
						<c:choose>
							<c:when test="${not empty GAME_ALL }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/gameManagement.html?PAGENO=${page }">${page }</a>
								</c:forEach>	
							</c:when>
							<c:when test="${not empty GAME_GAMENAME }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/gameManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty GAME_CATEGORY }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/gameManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty GAME_DISCOUNTRATE }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/gameManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
						</c:choose>
						
						
						<div align="right">
							<a href="../admin/adminPage.html" class="btn btn-info" role="button">adminPage</a>
						</div>
					
					</div><!-- .box end -->
				</div><!-- .col-md-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->

	<div class="body">
		<div class="container">
			
		</div>		
	</div>
</body>
</html>