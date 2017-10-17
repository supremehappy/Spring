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
						<h2>구매정보</h2>
						<p>The .table-hover class enables a hover state on table rows:</p>            
						
						<form action="../admin/purchaseManagementSearch.html" method="post">
							<select class="form-control" id="sel1" name="search">
						        <option value="0">id</option>
						        <option value="1">game name</option>
						        <option value="2">price</option>
							</select>
						
						<input type="text" class="form-control" id="usr" name="input">
						
						<button type="submit" class="btn btn-default">Submit</button>
						<a href="../admin/purchaseManagement.html" class="btn btn-info" role="button">all</a>
						</form>
									
						<br>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="30">no</th>
									<th width="50">id</th>
									<th width="200">game name</th>
									<th width="90">price</th>
									<th width="90">purchase date</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty ORDER_ALL }">
										<c:forEach var="order" items="${ORDER_ALL }">
											<tr>
												<td>${order.order_id }</td>
												<td>${order.user_id }</td>
												<td>${order.game_name }</td>
												<td>${order.total_amount }</td>
												<td>${order.order_date }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty ORDER_ID }">
										<c:forEach var="order" items="${ORDER_ID }">
											<tr>
												<td>${order.order_id }</td>
												<td>${order.user_id }</td>
												<td>${order.game_name }</td>
												<td>${order.total_amount }</td>
												<td>${order.order_date }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty ORDER_GAMENAME }">
										<c:forEach var="order" items="${ORDER_GAMENAME }">
											<tr>
												<td>${order.order_id }</td>
												<td>${order.user_id }</td>
												<td>${order.game_name }</td>
												<td>${order.total_amount }</td>
												<td>${order.order_date }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty ORDER_AMOUNT }">
										<c:forEach var="order" items="${ORDER_AMOUNT }">
											<tr>
												<td>${order.order_id }</td>
												<td>${order.user_id }</td>
												<td>${order.game_name }</td>
												<td>${order.total_amount }</td>
												<td>${order.order_date }</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>						
							</tbody>
						</table>
						<c:choose>
							<c:when test="${not empty ORDER_ALL }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/purchaseManagement.html?PAGENO=${page }">${page }</a>
								</c:forEach>				
							</c:when>
							<c:when test="${not empty ORDER_ID }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/purchaseManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty ORDER_GAMENAME }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/purchaseManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty ORDER_AMOUNT }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/purchaseManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
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
</body>
</html>