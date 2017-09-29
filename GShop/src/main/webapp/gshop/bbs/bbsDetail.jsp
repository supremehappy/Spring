<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.0.min.js" ></script>
	
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
				<td><img src="../gshop/user/upload/${BBS_ITEM.picture}" width="50px" height="50px" alt="프로필 사진"> ${BBS_ITEM.nickname}</td><th>작성일</th><td>${BBS_ITEM.reg_date}</td>
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
					</c:if>
				</td>
			</tr>
		</table>
		<br>
		
		<!-- ---------------------- 댓글 처리 ---------------------- -->
		<c:if test="${ empty REPLY_LIST }">
			<table border="1" width="100%">
				<tr><td align="center" colspan="4">등록된 댓글이 없습니다.</td></tr>
			</table>
		</c:if>
		<c:if test="${ ! empty REPLY_LIST }">
			<table border="1" width="100%">
				<c:forEach var="reply" items="${REPLY_LIST}">
					<script type="text/javascript">
						/* 페이지 로드 시 대댓글 입력창 숨김 */
						$(document).ready(function(){
							$('.input_rr_${reply.re_seq}').hide();
						});
						
						/* textarea 자동 늘림 */
						$("textarea.rr_area").on('keydown keyup', function () {
							  $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
						});
						
						/* 버튼 클릭 시 대댓글 입력창 숨김/펼치기 */
						$(function() {
							$('.show_rr_${reply.re_seq}').click(function() {
								if($(this).val() == '댓글 달기') {
									$('.input_rr_${reply.re_seq}').show();
									$(this).val('취소')
								} else {
									$('.rr_area').val('');
								    $('.input_rr_${reply.re_seq}').hide();
									$(this).val('댓글 달기')
								}
							});
						});
					</script>
					<tr>
						<td rowspan="2" width="100px" height="100px"><img src="../gshop/user/upload/${reply.picture}" width="100px" height="100px" alt="프로필 사진"></td>
						<td rowspan="2" width="100px" height="100px"><b>${reply.nickname}</b></td>
						<td height="30px">${reply.re_reg}</td>
						<td>
							<c:if test="${reply.user_id == LOGINID}">
								수정/삭제
							</c:if>
						</td>
					</tr>
					<tr>
						<td>${reply.re_comment}</td>
						<td width="100px"><input type="button" class="show_rr_${reply.re_seq}" style="padding:3px" value="댓글 달기"></td>
					</tr>
					<tr class="input_rr_${reply.re_seq}">
						<td colspan="3" align="center"><textarea placeholder="댓글을 입력하세요." class="rr_area" style="width: 99%"></textarea></td>
						<td width="100px"><input type="submit" value="등록"><br></td>
					</tr>
					
					<%-- <form:form modelAttribute="bbsReply" action="../bbs/insertReReply.html" method="post" onSubmit="return validate(this)">
						<form:hidden path="seq" value="${reply.seq}"/>
						<form:hidden path="re_seq" value="${reply.re_seq}"/>
						<form:hidden path="re_group" value="${reply.re_group}"/>
						<form:hidden path="re_parent" value="${reply.re_seq}"/>
						<form:hidden path="re_view" value="${reply.re_view + 1}"/>
						<tr class="input_rr_${reply.re_seq}">
							<td colspan="3" align="center"><form:textarea path="re_comment" placeholder="댓글을 입력하세요." class="rr_area" style="width: 99%"></form:textarea></td>
							<td width="100px"><input type="submit" value="등록"><br></td>
						</tr>
					</form:form> --%>
				</c:forEach>
				<form:form modelAttribute="bbsReply" action="../bbs/insertReply.html?GAMEID=${GAME_ID}" method="post" onSubmit="return validate(this)">
					<form:hidden path="seq" value="${BBS_ITEM.seq}"/>
					<tr>
						<td colspan="3" align="center"><form:textarea path="re_comment" placeholder="댓글을 입력하세요." style="width: 99%"></form:textarea></td>
						<td width="100px"><input type="submit" value="등록"><br></td>
					</tr>
				</form:form>
			</table>
		</c:if>
		<%-- <jsp:include page="../bbsReply/bbsReplyList.html?SEQID=${BBS_ITEM.seq}"></jsp:include> --%>
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