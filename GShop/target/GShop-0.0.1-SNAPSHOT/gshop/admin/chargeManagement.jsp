<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<%
 request.setCharacterEncoding("UTF-8");
%>
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
						<h2>충전관리</h2>
						<p>The .table-hover class enables a hover state on table rows:</p>            
						
						<form method="post" action="../admin/chargeManagementSearch.html">
							<select class="form-control" id="sel1" name="search">
						        <option value="0">id</option>
						        <option value="1">cash amount</option>
							</select>
							
							<input type="text" class="form-control" id="usr" name="input">
							<button type="submit" class="btn btn-default">Submit</button>
							<a href="../admin/chargeManagement.html" class="btn btn-info" role="button">all</a>
						</form>			
						
						<br>
						
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="30">no</th>
									<th width="50">id</th>
									<th width="200">amount</th>
									<th width="90">charge date</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
									<c:when test="${not empty CHARGE_ALL }">
										<c:forEach var="charge" items="${CHARGE_ALL }">
											<tr>
												<td>${charge.charge_id }</td>
												<td>${charge.user_id }</td>
												<td>${charge.total_amount }</td>
												<td>${charge.charge_date }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty CHARGE_ID }">
										<c:forEach var="charge" items="${CHARGE_ID }">
											<tr>
												<td>${charge.charge_id }</td>
												<td>${charge.user_id }</td>
												<td>${charge.total_amount }</td>
												<td>${charge.charge_date }</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:when test="${not empty CHARGE_AMOUNT }">
										<c:forEach var="charge" items="${CHARGE_AMOUNT }">
											<tr>
												<td>${charge.charge_id }</td>
												<td>${charge.user_id }</td>
												<td>${charge.total_amount }</td>
												<td>${charge.charge_date }</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>	
							</tbody>
						</table>
						
						<c:choose>
							<c:when test="${not empty CHARGE_ALL }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/chargeManagement.html?PAGENO=${page }">${page }</a>
								</c:forEach>	
							</c:when>
							<c:when test="${not empty CHARGE_ID }">
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/chargeManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
								</c:forEach>
							</c:when>
							<c:when test="${not empty CHARGE_AMOUNT }" >
								<c:forEach var="page" begin="1" end="${COUNT }">
									<a href="../admin/chargeManagementSearch.html?INPUT=${input }&SEARCH=${search }&PAGENO=${page }">${page }</a>
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