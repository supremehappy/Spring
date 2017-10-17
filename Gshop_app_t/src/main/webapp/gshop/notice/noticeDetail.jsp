<html>
	<div data-role="page">
		<%@ include file="/gshop/header.jsp" %>
		
		<div role="main" class="ui-content">
		<h2>notice list</h2>
		
			<table data-role="table" id="movie-table" data-mode="columntoggle" class="ui-responsive">

				<tbody>
					<tr>
						<td width="60px">game header</td>
						<td>${NOTICE_ITEM.header_name }</td>
					</tr>
					<tr>
						<td width="60px">writer</td>
						<td>${NOTICE_ITEM.admin_id }</td>
					</tr>
					<tr>
						<td width="60px">title</td>
						<td>${NOTICE_ITEM.post_title }</td>
					</tr>
					<tr>
						<td width="60px">content</td>
						<td>${NOTICE_ITEM.post_content }</td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${empty NOTICE_ITEM.image1 }">
								
							</c:when>
							<c:otherwise>
								<td width="60">image</td>
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
			
			<div align="center">
				<a href="../notice/noticeList.html" class="ui-btn ui-shadow">list</a>
			</div>
			
		</div>
		
		<%@ include file="/gshop/footer.jsp" %>
	</div>
</html>