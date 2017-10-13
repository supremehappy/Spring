<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">충전관리</h1>
	<div class="body">
		<div class="container">
			<h2>Hover Rows</h2>
			<p>The .table-hover class enables a hover state on table rows:</p>            
			
			<form method="post" action="../admin/chargeManagementSearch.html">
				<select class="form-control" id="sel1" name="search">
			        <option value="0">id</option>
			        <option value="1">cash amount</option>
				</select>
				
				<input type="text" class="form-control" id="usr" name="input">
				<a href="../admin/chargeManagement.html" class="btn btn-info" role="button">all</a>
				
				<button type="submit" class="btn btn-default">Submit</button>
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
			
			<c:forEach var="page" begin="1" end="${COUNT }">
				<a href="../admin/chargeManagement.html?PAGENO=${page }">${page }</a>
			</c:forEach>
			
			<div align="right">
				<a href="../admin/adminPage.html" class="btn btn-info" role="button">adminPage</a>
			</div>
		</div>		
	</div>
</body>
</html>