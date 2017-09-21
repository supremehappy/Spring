<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">게시글 목록</h1>
	<div class="body">
		<div class="container">
			<h2>Hover Rows</h2>
			<p>The .table-hover class enables a hover state on table rows:</p>            
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th width="30">no</th>
						<th width="300">title</th>
						<th width="80">writer</th>
						<th width="90">date</th>
						<th width="30">count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="free" items="${FREE_LIST }">
					<tr>
						<td>${free.seq }</td>
						<td><a href="../read/freeDetail.html?SEQNO=${free.seq }">${free.post_title }</a></td>
						<td>${free.user_id }</td>
						<td>${free.reg_date }</td>
						<td>${free.view_count }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		
			<c:forEach var="page" begin="1" end="${COUNT }">
				<a href="../read/freeList.html?PAGENO=${page }">${page }</a>
			</c:forEach>
			  
			<div align="right">
				<a href="../login/loginCheck.html?PAGE=/write/freeInputForm.html" class="btn btn-info" role="button">write</a>
			</div>		  
		</div>		
	</div>
</body>
</html>