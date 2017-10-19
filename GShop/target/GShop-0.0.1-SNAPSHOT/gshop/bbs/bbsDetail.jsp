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
	<div id="all">

		<div id="content">
			<div class="container">
				<div class="col-sm-12">
					<div class="col-sm-12" id="blog-post">
						<div class="box">
							<c:if test="${ empty BBS_ITEM}">
								존재하지 않는 게시글입니다.
							</c:if>
							<c:if test="${! empty BBS_ITEM }">
								<h1>${BBS_ITEM.post_title}</h1>
								<p class="author-date">By 
									<a href="#">
										<c:if test="${! empty BBS_ITEM.picture }"><img src="../upload/${BBS_ITEM.picture}" width="50px" height="50px" alt="프로필 사진"></c:if>
										<c:if test="${empty BBS_ITEM.picture }"><img src="../upload/profile.png" width="50px" height="50px" alt="프로필 사진"></c:if>
										 ${BBS_ITEM.nickname}
									</a> | ${BBS_ITEM.reg_date}
									<c:if test="${BBS_ITEM.reg_date == TODAY}"> <span class="label label-info">New</span> </c:if> | [${BBS_ITEM.header_name}] | ${BBS_ITEM.view_count}
									<c:if test="${AUTHORITY}"> | 
										<a href="#" onclick="goDelete()">Delete</a> | <a href="#" onclick="goModify()">Modify</a>
									</c:if>
								</p>
								<c:if test="${!empty BBS_ITEM.image1 or !empty BBS_ITEM.image2 or !empty BBS_ITEM.image3 or !empty BBS_ITEM.image4 or !empty BBS_ITEM.image5}">
									<table class="table">
										<tr>
											<td>
												<c:if test="${!empty BBS_ITEM.image1}"><a href="../gshop/bbs/image/${BBS_ITEM.image1}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image1}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
												<c:if test="${!empty BBS_ITEM.image2}"><a href="../gshop/bbs/image/${BBS_ITEM.image2}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image2}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
												<c:if test="${!empty BBS_ITEM.image3}"><a href="../gshop/bbs/image/${BBS_ITEM.image3}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image3}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
												<c:if test="${!empty BBS_ITEM.image4}"><a href="../gshop/bbs/image/${BBS_ITEM.image4}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image4}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
												<c:if test="${!empty BBS_ITEM.image5}"><a href="../gshop/bbs/image/${BBS_ITEM.image5}" target="_blank"><img src="../gshop/bbs/image/${BBS_ITEM.image5}" width="100px" alt="${BBS_ITEM.post_title}"></a></c:if>
											</td>
										</tr>
									</table>
								</c:if>
								<hr>
								<div id="post-content">
	                            	<p>${BBS_ITEM.post_content}</p>
	                           	</div>
	                           	<p>
	                           		<a href="#" onClick="location.href='../game/gameDetail.html?GAMEID=${GAME_ID}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}'" class="btn btn-primary"><i class="fa fa-bars"></i> List</a>
	                           		<c:if test="${! ISADMIN && ISLOGIN}">
	                           			<a href="#" onClick="goReply()" class="btn btn-primary"><i class="fa fa-pencil"></i> Reply</a>
	                           		</c:if>
	                           	</p>
								<br>
								
							</c:if>
								
							<!-- ---------------------- 댓글 처리 ---------------------- -->
							
							<c:if test="${ empty REPLY_LIST }">
									<p class="text-center">등록된 댓글이 없습니다.</p>
							</c:if>
							<c:if test="${ ! empty REPLY_LIST }">
	                            <h4>${REPLY_COUNT} comments</h4>
								<c:forEach var="reply" items="${REPLY_LIST}">
									<script type="text/javascript">
											/* 페이지 로드 시 대댓글 입력창, 수정창 숨김 */
											$(document).ready(function(){
												$('.input_rr_${reply.re_seq}').hide();
											});
											
											$(document).ready(function(){
												$('.rUpdateForm_${reply.re_seq}').hide();
											});
											
											/* 버튼 클릭 시 대댓글 입력창 숨김/펼치기 */
											$(function() {
												$('.show_rr_${reply.re_seq}').click(function() {
													if($('.rrForm').val() == 'close') {
														$('.input_rr_${reply.re_seq}').show();
														$('.rrForm').val('open')
													} else {
														$('.rr_area').val('');	
													    $('.input_rr_${reply.re_seq}').hide();
														$('.rrForm').val('close')
													}
												});
											});
					
											/* 수정 버튼 클릭 시 수정창 펼치기/숨김 */
											$(function() {
												$('.modify_${reply.re_seq}').click(function() {
													if($('.replyFormStatus_${reply.re_seq}').val() == 'close') {
														$('.replyContent_${reply.re_seq}').hide();
														$('.rUpdateForm_${reply.re_seq}').show();
														$('.replyFormStatus_${reply.re_seq}').val('open')
													} else {
														$('.rUpdateForm_${reply.re_seq}').hide();
														$('.replyContent_${reply.re_seq}').show();
														$('.replyFormStatus_${reply.re_seq}').val('close')
													}
												});
											});
											
											/* textarea 자동 늘림 */
											$("textarea.rr_area").on('keydown keyup', function () {
												  $(this).height(1).height( $(this).prop('scrollHeight')+12 );	
											});
											
											
										</script>
										<div id="comments">
			
			
				                            <div class="row comment" style="margin-left:${reply.re_depth * 40}px;">
				                                <div class="col-sm-3 col-md-2 text-center-xs">
				                                    <p>
				                                    <c:if test="${! empty reply.picture }"><img src="../upload/${reply.picture}" class="img-responsive img-circle" alt="${reply.picture}"></c:if>
													<c:if test="${empty reply.picture }"><img src="../upload/profile.png" class="img-responsive img-circle" alt="프로필 사진"></c:if>
				                                    </p>
				                                </div>
				                                <div class="col-sm-9 col-md-10">
				                                    <h5>${reply.nickname}</h5>
				                                    <p class="posted_${reply.re_seq}"><i class="fa fa-clock-o"></i> ${reply.re_reg}
					                                    <c:if test="${reply.user_id == LOGINID || ISADMIN}"> |
						                                    <a class="modify_${reply.re_seq}"> Modify</a> |
						                                    <a onClick="goReplyDelete(${reply.re_seq})"> Delete</a>
				                                    	</c:if>
			                                    	</p>
													<input type="hidden" class="replyFormStatus_${reply.re_seq}" value="close"/>
													<!-- 댓글 내용 -->
				                                    <p class="replyContent_${reply.re_seq}">${reply.re_comment}</p>
				                                    <!-- 댓글 수정 폼 -->
				                                    <div class="rUpdateForm_${reply.re_seq}">
														<p>
															<form:form modelAttribute="bbsReply" action="../bbs/updateBbsReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&HEADER=${HEADER_ID}&PAGENO=${PAGE_NO}" method="post" onSubmit="return validate(this)">
																<div class="row">
																	<div class="col-sm-12">
																		<div class="form-group">
																			<form:hidden path="seq" value="${reply.seq}"/>
																			<form:hidden path="re_seq" value="${reply.re_seq}"/>
																			<form:hidden path="re_parent" value="${reply.re_parent}"/>
																			<textarea name="re_comment" placeholder="수정할 내용을 입력하세요." class="form-control rr_area" style="width: 99%">${reply.re_comment}</textarea>
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-sm-12 text-right">
																		<button class="btn btn-primary"><i class="fa fa-pencil"></i> Modify</button>
																	</div>
																</div>
															</form:form>
														</p>
													</div>
													<c:if test="${! ISADMIN && ISLOGIN}">
					                                    <p class="reply show_rr_${reply.re_seq}"><a><i class="fa fa-reply"></i> Reply</a>
					                                    <input type="hidden" value="close" class="rrForm">
					                                    </p>
				                                    </c:if>
				                                </div>
				                                <!-- 대댓글 달기 -->
				                                
												<form:form modelAttribute="bbsReply" action="../bbs/insertReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&HEADER=${HEADER_ID}&PAGENO=${PAGE_NO}" method="post" onSubmit="return validate(this)">
													<div class="input_rr_${reply.re_seq}">
														<div class="row">
															<div class="col-sm-12">
																<div class="form-group">
																	<form:hidden path="seq" value="${reply.seq}"/>
																	<form:hidden path="re_seq" value="${reply.re_seq}"/>
																	<form:hidden path="re_group" value="${reply.re_group}"/>
																	<form:hidden path="re_parent" value="${reply.re_seq}"/>
																	<form:hidden path="re_view" value="${reply.re_view}"/>
																	<form:hidden path="re_depth" value="${reply.re_depth + 1}"/>
																	<form:textarea path="re_comment" placeholder="댓글을 입력하세요." class="form-control rr_area"/>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-sm-12 text-right">
																<button class="btn btn-primary" ><i class="fa fa-comment-o"></i> Write</button>
															</div>
														</div>
													</div>
												</form:form>
												
			                                </div>
			                            </div>
		                            
								</c:forEach>
							</c:if>
							<script>
								function goReplyDelete(number) {/* 댓글 삭제 */
								    var ok = confirm("삭제 하시겠습니까?")
							        if (ok == true) {
										location.href="../bbs/deleteBbsReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}&RESEQ="+number;
									} else {
										alert("취소 되었습니다.")
									}
								}
								
								function goReplyModify() {/* 댓글 수정 */
								    var ok = confirm("수정 하시겠습니까?")
							        if (ok == true) {
										location.href="../bbs/updateBbsReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&PAGENO=${PAGE_NO}&HEADER=${HEADER_ID}"
									} else {
										alert("취소 되었습니다.")
									}
								}
							</script>
							<!-- 댓글 달기 -->
							<c:if test="${! ISADMIN && ISLOGIN}">
								<div style="width:100%; text-align:right; margin-bottom: 15px">
									<div id="comment-form">
										<h4>Leave comment</h4>
										<form:form modelAttribute="bbsReply" action="../bbs/insertReply.html?GAMEID=${GAME_ID}&SEQ=${BBS_ITEM.seq}&HEADER=${HEADER_ID}&PAGENO=${PAGE_NO}" method="post" onSubmit="return validate(this)">
											<div class="row">
												<div class="col-sm-12">
													<div class="form-group">
														<label for="comment">Comment <span class="required">*</span>
														</label>
														<form:hidden path="seq" value="${BBS_ITEM.seq}"/>
														<form:textarea class="form-control rr_area" path="re_comment" placeholder="댓글을 입력하세요." rows="4"></form:textarea>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12 text-center">
										        	<button class="btn btn-primary"><i class="fa fa-comment-o"></i> Post comment</button>
									        	</div>
								        	</div>
							        	</form:form>
						        	</div><!-- #comment-form end -->
								</div>
							</c:if>
							
				        	
						</div><!-- .box end -->
					</div><!-- #blog-post end -->
				</div><!-- .col-sm-12 end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
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
		<input type="hidden" name="RESEQ" value="${reply.seq}">
	</form>
<%@ include file="/gshop/footer.jsp" %>	
</body>
</html>