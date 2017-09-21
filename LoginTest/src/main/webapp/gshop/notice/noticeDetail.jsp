<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>notice detail</h2>
	<div class="body">
		<div class="container">
			<h2>Bordered Table</h2>
			<p>The .table-bordered class adds borders to a table:</p>            
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td width="60"><h4>wirter</h4></td>
						<td>${NOTICE_ITEM.user_id }</td>
					</tr>
					<tr>
						<td width="60"><h4>title</h4></td>
						<td>${NOTICE_ITEM.post_title }</td>
					</tr>
					<tr>
						<td width="60"><h4>content</h4></td>
						<td>${NOTICE_ITEM.post_content }</td>
					</tr>
				</tbody>
			</table>
			<div align="center">
				<a href="../read/noticeList.html" class="btn btn-info" role="button">list</a>
				<a href="#" class="btn btn-info" role="button">update</a>
				<a href="#" class="btn btn-info" role="button">delete</a>
			</div>
		</div>
	</div>
</body>
</html>