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
						<h2>회원관리</h2>
						<p>The .table-hover class enables a hover state on table rows:</p>            
						
						<form action="../admin/memberManagementSearch.html" method="post">
							<select class="form-control" id="sel1" name="search">
						        <option value="0">id</option>
						        <option value="1">nickname</option>
						        <option value="2">email</option>
							</select>
							
							<input type="text" class="form-control" id="usr" name="input">
							
							<button type="submit" class="btn btn-default">Submit</button>
							<a href="../admin/memberManagement.html" class="btn btn-info" role="button">all</a>
						</form>
									
						<br>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th>id</th>
									<th>nickname</th>
									<th>email</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty USER_ALL }">
										<c:forEach var="user" items="${USER_ALL }">
											<tr>
												<td><a href="../admin/userMyPage.html?USER=${user.user_id }&NICK=${user.nickname}">${user.user_id }</a></td>
												<td>${user.nickname }</td>
												<td>${user.email }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty USER_ID1 }">
										<c:forEach var="user" items="${USER_ID1 }">
											<tr>
												<td><a href="../admin/userMyPage.html?USER=${user.user_id }&NICK=${user.nickname}">${user.user_id }</a></td>
												<td>${user.nickname }</td>
												<td>${user.email }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty USER_NICKNAME }">
										<c:forEach var="user" items="${USER_NICKNAME }">
											<tr>
												<td><a href="../admin/userMyPage.html?USER=${user.user_id }&NICK=${user.nickname}">${user.user_id }</a></td>
												<td>${user.nickname }</td>
												<td>${user.email }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty USER_EMAIL }">
										<c:forEach var="user" items="${USER_EMAIL }">
											<tr>
												<td>${user.user_id }</td>
												<td>${user.nickname }</td>
												<td>${user.email }</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>					
							</tbody>
						</table>
						
						<c:choose>
							<c:when test="${not empty USER_ALL }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/memberManagement.html?PAGENO=${page }">${page }</a>
								</c:forEach>	
							</c:when>
							<c:when test="${not empty USER_ID1 }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/memberManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty USER_NICKNAME }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/memberManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty USER_EMAIL }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/memberManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
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