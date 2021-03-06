<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	
			<c:if test="${! ISADMIN && ISLOGIN}">
				<div style="width:100%; text-align:right; margin-bottom: 15px">
					<a href="#" onclick="location.href='../bbs/bbsInputForm.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}'" class="btn btn-primary"><i class="fa fa-pencil"></i> Write</a>
				</div>
			</c:if>
	
	<table class="table">
		<tr>
			<th width="60px">No.</th>
			<th width="80px">
				<select onchange="goURL(this.value)">
						<option value="default">${HEADER_NAME}</option>
						<option value="default">------</option>
						<option value="../game/gameDetail.html?GAMEID=${GAME_ID}&PAGENO=1&HEADER=-1">전체</option>
						<c:forEach var="headerList" items="${HEADER_LIST}">
							<option value="../game/gameDetail.html?GAMEID=${GAME_ID}&PAGENO=1&HEADER=${headerList.header_id}">${headerList.header_name}</option>
						</c:forEach>
				</select>
			</th>
			<th>제목</th>
			<th width="200px">작성자</th>
			<th width="100px">등록일</th>
			<th width="60px">조회수</th>
		</tr>
		<c:if test="${ empty BBS_LIST}">
			<tr>
				<td colspan="6" align="center">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${ !empty BBS_LIST}">
			<c:forEach var="bbs" items="${BBS_LIST}">
				<tr>
					<td align="center">${bbs.seq}</td>
					<td align="center">${bbs.header_name}</td>
					<td><a href="../bbs/bbsDetail.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}&SEQ=${bbs.seq}">${bbs.post_title}</a>
						<c:choose>
							<c:when test="${bbs.reply_count > 0}">
								[${bbs.reply_count}]
							</c:when>
							<c:otherwise>
								[0]
							</c:otherwise>
						</c:choose>
						<%-- <c:if test="${bbs.reply_count > 0}">[${bbs.reply_count}]</c:if> --%> 
						<c:if test="${bbs.reg_date == TODAY}"> <span class="label label-info">New</span></c:if>
					</td>
					<td align="center">
						<c:if test="${! empty bbs.picture }"><img src="../upload/${bbs.picture}" width="50px" height="50px" alt="프로필 사진"></c:if>
						<c:if test="${empty bbs.picture }"><img src="../upload/profile.png" width="50px" height="50px" alt="프로필 사진"></c:if>
						 ${bbs.nickname}
					</td>
					<td align="center">${bbs.reg_date}</td>
					<td align="center">${bbs.view_count}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="pages">
		<ul class="pagination">
			<!-- 10페이지 이상의 페이징 처리 -->
			<c:set var="startPage" value="${CURRENT_PAGE - (CURRENT_PAGE % 10 == 0 ? 10 : (CURRENT_PAGE % 10)) + 1}"/>
			<c:set var="endPage" value="${startPage + 9}"/><!-- 10페이지 이상일 경우 '1~10'까지 페이지를 표시 -->
			<c:if test="${endPage > COUNT}"><!-- 마지막 페이지가 페이지 수보다 '1~남은 페이지 수' 표시 -->
				<c:set var="endPage" value="${COUNT}"/>
			</c:if>
			<li>
				<!-- 이전 페이지 버튼 출력 -->
				<c:if test="${startPage > 10}">
					<a href="../game/gameList.html?PAGENO=${startPage - 10}">&laquo;</a><!-- 이전 페이지 링크가 나오는 경우는 시작 페이지보다 10이 적은 경우 -->
				</c:if>
			</li>
			<c:forEach var="pageNo" begin="${startPage}" end="${endPage}">
			<li <c:if test="${CURRENT_PAGE == pageNo}">class="active"</c:if>>								
				<a href="../game/gameList.html?PAGENO=${pageNo}">${pageNo}</a>
			</li>
			</c:forEach>
			<li>
				<!-- 다음 페이지 버튼 출력 -->
				<c:if test="${endPage < COUNT}">
					<a href="../game/gameList.html?PAGENO=${startPage + 10}">&raquo;</a><!-- 다음 페이지 링크가 나오는 경우는 시작 페이지보다 10이 많은 경우 -->
				</c:if>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
		function goURL(values) {
			if (values != "default") {
				location.href = values;	
			}
		}
	</script>
</body>
</html>
