<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<div data-role="page">
		<%@ include file="/gshop/header.jsp" %>
		
		<div role="main" class="ui-content">
		<h1>커뮤니티 게시글 목록</h1>
		
		<c:forEach var="bbsGenre" items="${ BBS_LIST }">
			<div class="ui-body ui-body-a ui-corner-all">
				
					<fieldset class="ui-grid-b">
						<div class="ui-block-a"><a href="../community/detail.html?SEQ=${ bbsGenre.seq }">${bbsGenre.seq }</a></div>
						<div class="ui-block-b">${ bbsGenre.reg_date }</div>
					</fieldset>
					
					<fieldset class="ui-grid-b">
						<div class="ui-block-a">${bbsGenre.nickname  }</div>
						<div class="ui-block-b">${bbsGenre.view_count }</div>
					</fieldset>
					<fieldset class="ui-grid-b">
						<div class="ui-block-solo">
							<c:choose>
									<c:when test="${notice.reg_date eq DATE }">
										${bbsGenre.header_name } ] <a href="../community/detail.html?SEQ=${ bbsGenre.seq }">${bbsGenre.post_title } <img alt="" src="../upload/new.png"></a>
									</c:when>
									<c:otherwise>
										${bbsGenre.header_name } ] <a href="../community/detail.html?SEQ=${ bbsGenre.seq }">${bbsGenre.post_title } </a>
									</c:otherwise>
								</c:choose>
						</div>
					</fieldset>
				
			</div>
		</c:forEach>

		<br>
		<c:forEach var="page" begin="1" end="${ COUNT }">
			<a href="../community/list.html?PAGENO=${ page }">${ page }</a>
		</c:forEach>
			
		</div>
		
		<%@ include file="/gshop/footer.jsp" %>
	</div>
</html>
