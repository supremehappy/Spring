<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function validate(form){
	var result = confirm("정말로 삭제하시겠습니까?");
	if(result == false) return false;
}
</script>
<body>
	<h2>notice input from</h2>
	<div class="body">
		<div class="container">
			<form:form modelAttribute = "notice" action = "../write/noticeInputForm.html" method="post" enctype="multipart/form-data" commandName="notice">
				<h2>Bordered Table</h2>
				<p>The .table-bordered class adds borders to a table:</p>            
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td width="60"><h4>category</h4></td>
							<td>
								<form:select class="form-control" id="sel1" path="header_id" items="${HEADER_LIST }" itemName="header_name" />
								<%-- <form:select class="form-control" id="sel1" path="header_id">
									<form:option value="0">스포츠</form:option>
									<form:option value="1">레이싱</form:option>
									<form:option value="2">액션</form:option>
									<form:option value="3">전략</form:option>
									<form:option value="4">롤플레잉</form:option>
									<form:option value="5">캐주얼</form:option>
								</form:select> --%>
							</td>
						</tr>
						<tr>
							<td width="60"><h4>title</h4></td>
							<td>
								<form:input type="text" class="form-control" id="usr" path="post_title"/>
								<font color="red"><form:errors path="post_title"/></font>
							</td>
						</tr>
						<tr>
							<td width="60"><h4>image</h4></td>
							<td width="300">
								<div align="left">image</div>
								<div align="right"><input type="file" class="btn btn-info" value="upload" name="image" multiple="multiple"></div>
							</td>
						</tr>
						<tr>
							<td width="60"><h4>content</h4></td>
							<td><form:textarea class="form-control" rows="20" id="comment" path="post_content"/>
						</tr>
					</tbody>
				</table>
				<div align="center">
					<input type="submit" class="btn btn-info" value="upload">
					<input type="reset" class="btn btn-info" value="cancle">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>