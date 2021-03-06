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
	
					<h1>공지게시글 목록</h1>
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
							<c:forEach var="notice" items="${NOTICE_LIST }">
								<tr>
									<td>${notice.seq }</td>
									<c:choose>
										<c:when test="${notice.reg_date eq DATE }">
											<td>${notice.header_name } ]<a href="../notice/noticeDetail.html?SEQNO=${notice.seq }">
												 ${notice.post_title } <img alt="" src="../upload/new.png"> 
											</a></td>	
										</c:when>
										<c:otherwise>
											<td>${notice.header_name } ] <a href="../notice/noticeDetail.html?SEQNO=${notice.seq }">${notice.post_title }</a></td>	
										</c:otherwise>
									</c:choose>
									<td>${notice.admin_id }</td>
									<td>${notice.reg_date }</td>
									<td>${notice.view_count }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<c:forEach var="page" begin="1" end="${COUNT }">
						<a href="../notice/noticeList.html?PAGENO=${page }">${page }</a>
					</c:forEach>
					
					<c:choose>
						<c:when test="${not empty admin_key }">
							<div align="right">
								<a href="../login/loginCheck.html?PAGE=/notice/noticeInputForm.html" class="btn btn-info" role="button">write</a>
							</div>	
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					</c:choose>
					</div><!-- .box end -->
				</div><!-- .col-md-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
</body>
</html>