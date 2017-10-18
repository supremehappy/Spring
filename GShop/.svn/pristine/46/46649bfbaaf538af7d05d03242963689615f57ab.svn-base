<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 게시판</title>
</head>
<body>
	<div id="all">
		<div id="content">
			<div class="container">
				<div class="col-md-12">
					<div class="box">
						<script type="text/javascript">
							function validate(form) {
								var result = confirm("정말로 등록하시겠습니까?");
								if(result == false) return false;
							}
						</script>
						<form:form modelAttribute="bbs" action="../bbs/updateBbs.html?GAMEID=${GAME_ID}&SEQ=${bbs.seq}" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
							<table border="1" width="100%">
								<tr>
									<th>말머리</th>
									<td><form:select path="header_id" items="${HEADER_LIST}" itemValue="header_id" itemLabel="header_name" multiple="false" selected="${HEADER_ID}"/></td>
								</tr>
								<tr>
									<th>글제목</th>
									<td><form:input path="post_title" size="40" value="${bbs.post_title}"/> <font color="red"><form:errors path="post_title"/></font></td>
								</tr>
								<tr>
									<th>닉네임</th>
									<td>${NICKNAME}</td>
								</tr>
								<tr>
									<th rowspan="5">이미지,[${bbs.image1 }]</th>
									<td><input type="file" name="images" size="40">
									<input type="hidden" name="image1" value="${bbs.image1}"/>
									</td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40">
									<input type="hidden" name="image2" value="${bbs.image2}"/></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40">
									<input type="hidden" name="image3" value="${bbs.image3}"/></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40">
									<input type="hidden" name="image4" value="${bbs.image4}"/></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40">
									<input type="hidden" name="image5" value="${bbs.image5}"/></td>
								</tr>
								<tr>
									<th>글내용</th>
									<td><form:textarea rows="8" cols="40" path="post_content" value="${bbs.post_content}"/><font color="red"><form:errors path="post_content"/></font></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="수정"><input type="button" value="취소" onclick="history.go(-1)">
									</td>
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