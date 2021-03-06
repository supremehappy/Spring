<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function validate(){
	var result = confirm("정말로 삭제하시겠습니까?");
	if(result == false) return false;
}
</script>
<body>
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="box">
					<h1>notice detail</h1>
					<p>The .table-bordered class adds borders to a table:</p>            
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td width="60"><h4>wirter</h4></td>
								<td>${NOTICE_ITEM.admin_id }</td>
							</tr>
							<tr>
								<td width="60"><h4>title</h4></td>
								<td>${NOTICE_ITEM.post_title }</td>
							</tr>
							<tr>
								<td width="60"><h4>content</h4></td>
								<td>${NOTICE_ITEM.post_content }</td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${empty NOTICE_ITEM.image1 }">
										
									</c:when>
									<c:otherwise>
										<td width="60"><h4>image</h4></td>
										<td>
											<c:if test="${!empty NOTICE_ITEM.image1 }">
												<img class="img-thumbnail" alt="" width ="200" height="150" src="../upload/${NOTICE_ITEM.image1 }">
											</c:if>
											<c:if test="${!empty NOTICE_ITEM.image2 }">
												<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image2 }">
											</c:if>
											<c:if test="${!empty NOTICE_ITEM.image3 }">
												<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image3 }">
											</c:if>
											<c:if test="${!empty NOTICE_ITEM.image4 }">
												<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image4 }">
											</c:if>
											<c:if test="${!empty NOTICE_ITEM.image5 }">
												<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image5 }">
											</c:if>
											
										</td>	
									</c:otherwise>
								</c:choose>						
							</tr>
						</tbody>
					</table>
					
					<c:choose>
						<c:when test="${not empty admin_key }">
							<div align="center">
								<a href="../notice/noticeList.html" class="btn btn-info" role="button">list</a>
								<a href="../notice/noticeUpdate.html?SEQNO=${NOTICE_ITEM.seq}" class="btn btn-info" role="button">update</a>
								<a href="../notice/noticeDelete.html?SEQNO=${NOTICE_ITEM.seq}" class="btn btn-info" role="button" onClick="javascript:validate()">delete</a>
							</div>	
						</c:when>
						<c:otherwise>
							<div align="center">
								<a href="../notice/noticeList.html" class="btn btn-info" role="button">list</a>
							</div>
						</c:otherwise>
					</c:choose>
					</div><!-- .box end -->
				</div><!-- .col-md-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
</body>
</html>