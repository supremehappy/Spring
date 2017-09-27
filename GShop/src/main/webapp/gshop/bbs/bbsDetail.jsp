<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/bbs/jsp_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${ empty BBS_ITEM}">
		존재하지 않는 게시글입니다.
	</c:if>
	<c:if test="${! empty BBS_ITEM }">
		<table width="100%">
			<tr><th align="right"><b>Total Page : ${COUNT}</b></th></tr>
			<tr><th align="right">Game ID : ${GAME_ID}</th></tr>
			<tr><th align="right"><b>Page No : ${PAGE_NO}</b></th></tr>
			<tr><th align="right">Current Page : ${CURRENT_PAGE}</th></tr>
			<tr><th align="right">Header : ${HEADER_NAME}</th></tr>
			<tr><th align="right">Count : ${BBS_ITEM.view_count}</th></tr>
			<tr><th align="right">Group ID : ${BBS_ITEM.group_id}</th></tr>
			<tr><th align="right">Parent ID : ${BBS_ITEM.parent_id}</th></tr>
			<tr><th align="right">View Order : ${BBS_ITEM.view_order}</th></tr>
		</table>
		<table border="1" width="100%">
			<tr>
				<th>글번호</th>
				<td>${BBS_ITEM.seq}</td>
				<th>조회수</th>
				<td>${BBS_ITEM.view_count}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><img src="../gshop/userPic/${BBS_ITEM.picture}" width="50px" height="50px" alt="프로필 사진"> ${BBS_ITEM.nickname}</td><th>작성일</th><td>${BBS_ITEM.reg_date}</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td colspan="3">[${BBS_ITEM.header_name}] ${BBS_ITEM.post_title}
					<c:if test="${BBS_ITEM.reg_date == TODAY}"><img src="../gshop/bbs/image/new.png" alt="새글"></c:if>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td colspan="4">
					<c:if test="${!empty BBS_ITEM.image1}"><a href="../gshop/bbs/image/${BBS_ITEM.image1}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image1}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
					<c:if test="${!empty BBS_ITEM.image2}"><a href="../gshop/bbs/image/${BBS_ITEM.image2}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image2}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
					<c:if test="${!empty BBS_ITEM.image3}"><a href="../gshop/bbs/image/${BBS_ITEM.image3}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image3}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
					<c:if test="${!empty BBS_ITEM.image4}"><a href="../gshop/bbs/image/${BBS_ITEM.image4}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image4}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
					<c:if test="${!empty BBS_ITEM.image5}"><a href="../gshop/bbs/image/${BBS_ITEM.image5}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image5}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td colspan="3">${BBS_ITEM.post_content}</td>
			</tr>
			<tr><td colspan="2" align="left">
					<input type="button" value="목록" onClick="location.href='../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}'">
					<input type="button" value="답글" onClick="goReply()">
				</td>
				<td colspan="2" align="right">
					<c:if test="${AUTHORITY}">
						<input type="button" value="삭제" onClick="goDelete()">
						<input type="button" value="수정" onClick="goModify()">
						<%-- <input type="button" value="수정" onClick="location.href='../bbs/bbsList.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}'"> --%>
					</c:if>
				</td>
			</tr>
		</table>
		
	</c:if>
	<script type="text/javascript">
		function goReply() {
			document.move.action="../bbs/bbsInputForm.html";
			document.move.submit();
		}
		function goModify() {
			document.move.action="../bbs/updateForm.html";
			document.move.submit();
		}
		function goDelete() {
		    var ok = confirm("삭제 하시겠습니까?")
	        if (ok == true) {
				location.href="../bbs/deleteBbs.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}"
			} else {
				alert("취소 되었습니다.")
			}
		}
	</script>
	
	<form name="move" method="get">
		<input type="hidden" name="SEQ" value="${BBS_ITEM.seq}">
		<input type="hidden" name="GROUPID" value="${BBS_ITEM.group_id}"/>
		<input type="hidden" name="PARENTID" value="${BBS_ITEM.seq}"/>
		<input type="hidden" name="GAMEID" value="${GAME_ID}">
		<input type="hidden" name="HEADER" value="${HEADER_ID}">
	</form>
</body>
</html>