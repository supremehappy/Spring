<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/bbs/jsp_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr><th align="right"><b>Total Page : ${COUNT}</b></th></tr>
		<tr><th align="right">Game ID : ${GAME_ID}</th></tr>
		<tr><th align="right"><b>Page No : ${PAGE_NO}</b></th></tr>
		<tr><th align="right">Current Page : ${CURRENT_PAGE}</th></tr>
		<tr><th align="right">Header : ${HEADER_NAME}</th></tr>
	</table>
	<table id="p_table" border="1" width="100%">
		<tr>
			<th>No.</th>
			<th>
				<select onchange="goURL(this.value)">
						<option value="default">${HEADER_NAME}</option>
						<option value="default">------</option>
						<option value="../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=1&HEADER=0">전체</option>
						<c:forEach var="headerList" items="${HEADER_LIST}">
							<option value="../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=1&HEADER=${headerList.header_id}">${headerList.header_name}</option>
						</c:forEach>
				</select>
			</th>
			<th width="40%">제목</th>
			<th>이미지</th>
			<!-- <th>작성자</th> -->
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${ empty BBS_LIST}">
			<tr>
				<td colspan="6" align="center">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${ !empty BBS_LIST}">
			<c:forEach var="bbs" items="${BBS_LIST}">
				<tr>
					<td>${bbs.seq}</td>
					<td>${bbs.header_name}</td>
					<td><a href="../bbs/bbsDetail.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}&SEQ=${bbs.seq}">${bbs.post_title}</a>
						<c:if test="${bbs.reg_date == TODAY}"><img src="../gshop/bbs/image/new.png" alt="새글"></c:if>
					</td>
					<td><img src="../gshop/userPic/${bbs.picture}" width="50px" height="50px" alt="프로필 사진"> ${bbs.nickname}</td>
					<td>${bbs.reg_date}</td>
					<td>${bbs.view_count}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="center">
					<!-- 10페이지 이상의 페이징 처리 -->
					<c:set var="startPage" value="${CURRENT_PAGE - (CURRENT_PAGE % 10 == 0 ? 10 : (CURRENT_PAGE % 10)) + 1}"/>
					<c:set var="endPage" value="${startPage + 9}"/><!-- 10페이지 이상일 경우 '1~10'까지 페이지를 표시 -->
					<c:if test="${endPage > COUNT}"><!-- 마지막 페이지가 페이지 수보다 '1~남은 페이지 수' 표시 -->
						<c:set var="endPage" value="${COUNT}"/>
					</c:if>
					<!-- 이전 페이지 버튼 출력 -->
					<c:if test="${startPage > 10}">
						<a href="../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=${startPage - 10}&HEADER=${HEADER_ID}">[이전]</a><!-- 이전 페이지 링크가 나오는 경우는 시작 페이지보다 10이 적은 경우 -->
					</c:if>
					<!-- 페이지 갯수 출력 -->
					<c:forEach var="pageNo" begin="${startPage}" end="${endPage}">
						<c:if test="${CURRENT_PAGE == pageNo}"><!-- 현재 표시된 페이지와 페이지 번호가 같은 경우 -->
							<font size="3"><b>
						</c:if>
						<a href="../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=${pageNo}&HEADER=${HEADER_ID}">[${pageNo}]</a><!-- 페이지 번호 클릭시 이동 처리 -->
						<c:if test="${CURRENT_PAGE == pageNo}">
							</b></font>
						</c:if>
					</c:forEach>
					<!-- 다음 페이지 버튼 출력 -->
					<c:if test="${endPage < COUNT}">
						<a href="../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=${startPage + 10}&HEADER=${HEADER_ID}">[다음]</a><!-- 다음 페이지 링크가 나오는 경우는 시작 페이지보다 10이 많은 경우 -->
					</c:if>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="글쓰기" onClick="location.href='../bbs/bbsInputForm.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}'">
			</td>
		</tr>
	</table>
	${currentPage}
	<script type="text/javascript">
		function goURL(values) {
			if (values != "default") {
				location.href = values;	
			}
		}
	</script>
</body>
</html>