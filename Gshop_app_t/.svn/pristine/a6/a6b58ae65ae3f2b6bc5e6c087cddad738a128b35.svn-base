<html>
	<div data-role="page">
		<%@ include file="/gshop/header.jsp" %>
		
		<div role="main" class="ui-content">
		<h2>notice list</h2>
		
			<table data-role="table" id="movie-table" data-mode="reflow" class="ui-responsive">
				<thead>
					<tr class="ui-bar-d">
						<th data-priority="2">no</th>
						<th>title</th>
						<th data-priority="3">writer</th>
						<th data-priority="1">date</th>
						<th data-priority="5">count</th>
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
			
		</div>
		
		<%@ include file="/gshop/footer.jsp" %>
	</div>
</html>