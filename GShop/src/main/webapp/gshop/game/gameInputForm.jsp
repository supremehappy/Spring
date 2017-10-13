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
	<script type="text/javascript">
		function validate(form) {
			var result = confirm("정말로 등록하시겠습니까?");
			if(result == false) return false;
		}
	</script>
	<form:form modelAttribute="game" action="../game/putGame.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
		<table border="1">
			<tr>
				<th>장르</th>
				<td><form:select path="genre_id" items="${GENRE_LIST}" itemValue="genre_id" itemLabel="genre_name" multiple="false"/></td>
			</tr>
			<tr>
				<th>게임명</th>
				<td><form:input path="game_name" size="40" /> <font color="red"><form:errors path="game_name"/></font></td>
			</tr>
			<tr>
				<th>개발사</th>
				<td><form:input path="developer" size="40"/> <font color="red"><form:errors path="developer"/></font></td>
			</tr>
			<tr>
				<th>배급사</th>
				<td><form:input path="publisher" size="40"/> <font color="red"><form:errors path="publisher"/></font></td>
			</tr>
			<tr>
				<th>출시일</th>
				<td><form:input path="release_date" size="40"/></td>
			</tr>
			<tr>
				<th>운영체제</th>
				<td><form:select path="os_id" items="${OS_LIST}" itemValue="os_id" itemLabel="os_name" multiple="false"/></td>
			</tr>
			<tr>
				<th>CPU</th>
				<td><form:input path="cpu" size="40"/></td>
			</tr>
			<tr>
				<th>메모리</th>
				<td><form:input path="memory" size="40"/></td>
			</tr>
			<tr>
				<th>저장용량</th>
				<td><form:input path="capacity" size="40"/></td>
			</tr>
			<tr>
				<th>그래픽카드</th>
				<td><form:input path="vga" size="40"/></td>
			</tr>
			<tr>
				<th>네트워크</th>
				<td><form:input path="network" size="40"/></td>
			</tr>
			<tr>
				<th>게임 가격</th>
				<td><form:input path="price" size="40"/></td>
			</tr>
			<tr>
				<th>할인율</th>
				<td><form:input path="discount_rate" size="40"/> %</td>
			</tr>
			<tr>
				<th>게임등급</th>
				<td><form:select path="grade" items="${GRADE_LIST}" itemValue="grade" itemLabel="grade_desc" multiple="false"/></td>
			</tr>
			<tr>
				<th rowspan="5">이미지</th>
				<td><input type="file" name="images" size="40"> <font color="red"><form:errors path="image1"/></font></td>
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
				<th>게임설명</th>
				<td><form:textarea rows="12" cols="40" path="comments"/> <font color="red"><form:errors path="comments"/></font></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"><input type="button" value="취소" onclick="history.go(-1)">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>