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
								/* if(form.title.value == "") {
									alert("제목을 입력하세요"); return false
								}
								if(form.nick.value == "") {
									alert("닉네임을 입력하세요"); return false
								}
								if(form.password.value == "") {
									alert("암호를 입력하세요"); return false
								}
								if(form.imagename.value == "") {
									alert("이미지 파일을 선택하세요."); return false
								} */
								var result = confirm("정말로 등록하시겠습니까?");
								if(result == false) return false;
							}
						</script>
						<form:form modelAttribute="bbs" action="../bbs/putBbs.html?GAMEID=${GAME_ID}" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
							<c:if test="${ ! empty bbs.group_id }">
								<form:hidden path="group_id" value="${param.GROUPID}"/>
							</c:if>
							<c:if test="${ ! empty bbs.parent_id }">
								<form:hidden path="parent_id" value="${param.PARENTID}"/>
							</c:if>
							<form:hidden path="view_order" value="${bbs.view_order + 1}"/>
							<table border="1" width="100%">
								<tr>
									<th>말머리</th>
									<td><form:select path="header_id" items="${HEADER_LIST}" itemValue="header_id" itemLabel="header_name" multiple="false"/></td>
								</tr>
								<tr>
									<th>글제목</th>
									<td><form:input path="post_title" size="40" value="${TITLE}"/> <font color="red"><form:errors path="post_title"/></font></td>
								</tr>
								<tr>
									<th>닉네임</th>
									<td>${NICKNAME}</td>
								</tr>
								<tr>
									<th rowspan="5">이미지</th>
									<td><input type="file" name="images" size="40"></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40"></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40"></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40"></td>
								</tr>
								<tr>
									<td><input type="file" name="images" size="40"></td>
								</tr>
								<tr>
									<th>글내용</th>
									<td><form:textarea rows="8" cols="40" path="post_content"/> <font color="red"><form:errors path="post_content"/></font></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="등록"><input type="button" value="취소" onclick="history.go(-1)">
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