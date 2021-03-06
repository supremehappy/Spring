<html>
	<div data-role="page">
		<%@ include file="/gshop/header.jsp" %>
		
		<div role="main" class="ui-content">
		<h2>notice list</h2>
		
		<c:forEach var="notice" items="${NOTICE_LIST }">
			<div class="ui-body ui-body-a ui-corner-all">
				
					<fieldset class="ui-grid-b">
						<div class="ui-block-a">${notice.seq }</div>
						<div class="ui-block-b">${notice.reg_date }</div>
					</fieldset>
					
					<fieldset class="ui-grid-b">
						<div class="ui-block-a">
							<c:choose>
									<c:when test="${notice.reg_date eq DATE }">
										${notice.header_name } ] <a href="../notice/noticeDetail.html?SEQNO=${notice.seq }">${notice.post_title } <img alt="" src="../upload/new.png"></a>
									</c:when>
									<c:otherwise>
										${notice.header_name } ] <a href="../notice/noticeDetail.html?SEQNO=${notice.seq }">${notice.post_title } </a>
									</c:otherwise>
								</c:choose>
						</div>
						<div class="ui-block-b">${notice.admin_id }</div>
						<div class="ui-block-b">${notice.view_count }</div>
					</fieldset>
				
			</div>
		</c:forEach>
			
			
			<c:forEach var="page" begin="1" end="${COUNT }">
				<a href="../notice/noticeList.html?PAGENO=${page }">${page }</a>
			</c:forEach>
		
			<div>
				<%@ include file="/gshop/footer.jsp" %>
			</div>
		</div>
	</div>
</html>