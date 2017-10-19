<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ include file="/gshop/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>GShop Home</title>
</head>

<body>

<div id="all">
	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box">
				<h1>커뮤니티 게시글 상세</h1>
				
<c:if test="${ empty BBS_DETAIL }">
	존재하지 않는 게시글입니다.
</c:if>
<c:if test="${ !empty BBS_DETAIL }">
<table class="table table-bordered">
	<tbody>
	<tr>
		<td width="150">글번호</td>
		<td>${ BBS_DETAIL.seq }</td>
	</tr>
	<tr>
		<td>말머리</td>
		<td>${ BBS_DETAIL.header_name }</td>
	</tr>
	<tr>
		<td>글제목</td>
		<td>${ BBS_DETAIL.post_title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${ BBS_DETAIL.nickname }</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${ BBS_DETAIL.view_count }</td>
	</tr>
	<tr>
		<td colspan="2" align="left">
		<c:if test="${ !empty BBS_DETAIL.image1}">
			<img border="0" src="../upload/${ BBS_DETAIL.image1}"><br>
		</c:if>
		<c:if test="${ !empty BBS_DETAIL.image2}">
			<img border="0" src="../upload/${ BBS_DETAIL.image2}"><br>
		</c:if>
		<c:if test="${ !empty BBS_DETAIL.image3}">
			<img border="0" src="../upload/${ BBS_DETAIL.image3}"><br>
		</c:if>
		<c:if test="${ !empty BBS_DETAIL.image4}">
			<img border="0" src="../upload/${ BBS_DETAIL.image4}"><br>
		</c:if>
		<c:if test="${ !empty BBS_DETAIL.image5}">
			<img border="0" src="../upload/${ BBS_DETAIL.image5}"><br>
		</c:if>	
			${ BBS_DETAIL.post_content }
		</td>
	</tr>
	</tbody>
</table>
<div style="width:100%; text-align:center; margin-bottom: 15px">
	<c:if test="${ !empty USER_ID }">
	<a href="javascript:goReply()">[답글]</a>
	</c:if>
	<c:if test="${ NICKNAME == BBS_DETAIL.nickname }">
	<a href="javascript:goUpdate()">[수정]</a>
	</c:if>
	<c:if test="${ NICKNAME == BBS_DETAIL.nickname }">
	<a href="javascript:goDelete()">[삭제]</a>
	</c:if>
	<a href="../community/list.html">[목록]</a>
</div>
</c:if>

<script type="text/javascript">
function goReply(){
	document.move.action="../community/replyForm.html";
	document.move.submit();
}
function goUpdate(){
	document.move.action="../community/updateForm.html";
	document.move.submit();
}
function goDelete(){
	var ok = confirm("삭제하시겠습니까?")
    if (ok == true) {
    	document.move.action="../community/delete.html";
    	document.move.submit();
	} else {
		alert("취소되었습니다.")
	}
}
</script>
<form name="move" method="post">
	<input type="hidden" name="SEQ" value="${ BBS_DETAIL.seq }"/>
	<input type="hidden" name="PARENT_ID" value="${ BBS_DETAIL.seq }"/>
	<input type="hidden" name="GROUP_ID" value="${ BBS_DETAIL.group_id }"/>
	<input type="hidden" name="VIEW_ORDER" value="${ BBS_DETAIL.view_order }"/>
	<input type="hidden" name="TITLE" value=" ㄴ ${ BBS_DETAIL.post_title }"/>
</form>


<c:if test="${ empty REPLY_LIST }">
	<tr>등록된 댓글이 없습니다.</tr>
</c:if>
<c:if test="${ !empty REPLY_LIST }">
	<c:forEach var="replyGenre" items="${ REPLY_LIST }">
	
		<script type="text/javascript">
							/* 페이지 로드 시 대댓글 입력창, 수정창 숨김 */
							$(document).ready(function(){
								$('.input_rr_${replyGenre.re_seq}').hide();
							});
							
							$(document).ready(function(){
								$('.replyUpdateForm_${replyGenre.re_seq}').hide();
							});
							
							/* 버튼 클릭 시 대댓글 입력창 숨김/펼치기 */
							$(function() {
								$('.show_rr_${replyGenre.re_seq}').click(function() {
									if($(this).val() == '댓 글') {
										$('.input_rr_${replyGenre.re_seq}').show();
										$(this).val('취소')
									} else {
										$('.rr_area').val('');
									    $('.input_rr_${replyGenre.re_seq}').hide();
										$(this).val('댓 글')
									}
								});
							});
	
							/* 수정 버튼 클릭 시 수정창 펼치기/숨김 */
							$(function() {
								$('.updateBtn_${replyGenre.re_seq}').click(function() {
									if($(this).val() == '수정') {
										$('.replyContent_${replyGenre.re_seq}').hide();
										$('.replyUpdateForm_${replyGenre.re_seq}').show();
										$(this).val('수정 취소')
									} else {
										$('.replyUpdateForm_${replyGenre.re_seq}').hide();
										$('.replyContent_${replyGenre.re_seq}').show();
										$(this).val('수정')
									}
								});
							});
							
							/* textarea 자동 늘림 */
							$("textarea.rr_area").on('keydown keyup', function () {
								  $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
							});
							
							
	</script>

	<div id="comments"  class="input_rr_${replyGenre.re_seq}">
<table border="1" >
		<tr class="replyContent_${replyGenre.re_seq}">
			<td>${ replyGenre.re_seq }</td>
			<td>${ replyGenre.nickname }</td>
			<td>${ replyGenre.re_reg }</td>
			<td width="100px">
				<input type="button" class="updateBtn_${replyGenre.re_seq}" style="padding:3px" value="수정">
				<a href="#" onclick="goReplyUpdate(${replyGenre.re_seq})">수정</a>
			</td>
			<td>
				<a href="#" onclick="goReplyDelete(${replyGenre.re_seq})">삭제</a>
			</td>
		</tr>
		<tr class="replyContents_${replyGenre.re_seq}">
			<td colspan="4">${replyGenre.re_comment}</td>
			<td width="100px">
				<input type="button" class="show_rr_${replyGenre.re_seq}" style="padding:3px" value="댓 글">
			</td>
		</tr>		

		<form:form modelAttribute="replyGenre" action="../community/insertComment.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
			<form:hidden path="seq" value="${ BBS_DETAIL.seq }"/>
			<form:hidden path="re_seq" value="${ replyGenre.re_seq }"/>
			<form:hidden path="re_group" value="${ replyGenre.re_group }"/>
			<form:hidden path="re_parent" value="${ replyGenre.re_parent }"/>
			<form:hidden path="re_view" value="${ replyGenre.re_view }"/>
			<form:hidden path="user_id" value="${ USER_ID }"/>
			<form:hidden path="nickname" value="${ NICKNAME }"/>
		<tr>
			<td colspan="4" align="center">
			<form:textarea path="re_comment" placeholder="수정내용을 입력" class="rr_area" style="width: 99%"></form:textarea>
			</td>
			<td><input type="submit" class="btn btn-info" value="댓 글"/></td>					
		</tr>

		</form:form>



						
		<tr class="replyUpdateForm_${replyGenre.re_seq}">
			<form:form modelAttribute="replyGenre" action="../bbs/updateBbsReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&HEADER=${HEADER_ID}&PAGENO=${PAGE_NO}" method="post" onSubmit="return validate(this)">
				<form:hidden path="seq" value="${replyGenre.seq}"/>
				<form:hidden path="re_seq" value="${replyGenre.re_seq}"/>
				<form:hidden path="re_parent" value="${replyGenre.re_parent}"/>
				<td colspan="2" align="center"><form:textarea path="re_comment" placeholder="수정할 내용을 입력하세요." class="rr_area" style="width: 99%" value="${replyGenre.re_comment}"/></td>
				<td width="100px"><input type="submit" value="수정 완료"></td>
			</form:form>
		</tr>
		
		
								<script>
								function goReplyDelete(number) {/* 댓글 삭제 */
								    var ok = confirm("삭제 하시겠습니까?")
							        if (ok == true) {
										location.href="../community/deleteComment.html?SEQ=${ replyGenre.seq }&RE_SEQ="+number
									} else {
										alert("취소 되었습니다.")
									}
								}
								
								function goReplyUpdate(number) {/* 댓글 수정 */
								    var ok = confirm("수정 하시겠습니까?")
							        if (ok == true) {
							        	location.href="../community/updateComment.html?SEQ=${ replyGenre.seq }&RE_SEQ="+number
									} else {
										alert("취소 되었습니다.")
									}
								}
							</script>
							
							
	</table>
	</div>
	</c:forEach>
</c:if>

<form:form modelAttribute="replyGenre" action="../community/insertComment.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
	<form:hidden path="seq" value="${ BBS_DETAIL.seq }"/>
	<form:hidden path="user_id" value="${ USER_ID }"/>
	<form:hidden path="nickname" value="${ NICKNAME }"/>
	<table class="table table-bordered">
	
	
	
		<tr>			
			<td>
				<form:textarea cols="100" rows="3" path="re_comment"/>
			</td>
			<td><input type="submit" class="btn btn-info" value="댓 글"/></td>
		</tr>
	</table>
</form:form>

				</div><!-- .box end -->
			</div><!-- .col-md-12 end -->
		</div><!-- .container end -->
	</div><!-- #content end -->
</div><!-- #all end -->
</body>
</html>
<%@ include file="/gshop/footer.jsp" %>