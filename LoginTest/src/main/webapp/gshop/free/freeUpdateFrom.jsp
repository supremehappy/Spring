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
	var result = confirm("정말로 변경하시겠습니까?");
	if(result == false) return false;
}
</script>
<body>
	<h2>free update detail</h2>
	<div class="body">
		<div class="container">
			<form:form modelAttribute = "bbs_free" action="../write/freeUpdateFrom.html" method ="post" enctype="multipart/form-data" onSubmit="return validate(this)">
				<h2>Bordered Table</h2>
				<p>The .table-bordered class adds borders to a table:</p>            
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td width="60"><h4>category</h4></td>
							<td>
								<form:select class="form-control" id="sel1" path="header_id" items="${HEADER_LIST }" itemName="header_name" >
									<form:options value="header_id" items="${SELECTED_HEADER }" selected="selected"></form:options>
								</form:select>
								
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
							<td width="60"><h4>wirter</h4></td>
							<td><form:input type="text" class="form-control" id="id" path ="user_id" value="${FREE_ITEM.user_id }" /></td>
						</tr>
						<tr>
							<td width="60"><h4>title</h4></td>
							<td><form:input type="text" class="form-control" id="usr" path="post_title" value="${FREE_ITEM.post_title }"/></td>
						</tr>
						<tr>
							<td width="60"><h4>content</h4></td>
							<td><form:textarea class="form-control" rows="20" id="comment" path="post_content" value="${FREE_ITEM.post_content }"/></td>
						</tr>
						<tr>
							<c:choose>
								<c:when test="${empty FREE_ITEM.image1 }">
									<td width="60"><h4>image</h4></td>
									<td width="300">
										<div align="left">image</div>
										<div align="right"><input type="file" class="btn btn-info" value="upload" name="image" multiple="multiple"></div>
									</td>
								</c:when>
								<c:otherwise>
									<td width="60"><h4>image</h4></td>
									<td>
										<c:if test="${!empty FREE_ITEM.image1}">
										<img class="img-thumbnail" alt="" width ="200" height="150" src="../image/${FREE_ITEM.image1 }">
										</c:if>
										<c:if test="${!empty FREE_ITEM.image2}">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/image/${FREE_ITEM.image2 }">
										</c:if>
										<c:if test="${!empty FREE_ITEM.image3}">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/image/${FREE_ITEM.image3 }">
										</c:if>
										<c:if test="${!empty FREE_ITEM.image4}">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/image/${FREE_ITEM.image4 }">
										</c:if>
										<c:if test="${!empty FREE_ITEM.image5}">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/image/${FREE_ITEM.image5 }">
										</c:if>
										<br>
										<div align="left">image</div>
										<div align="right"><input type="file" class="btn btn-info" value="upload" name="image" multiple="multiple"></div>
										<%-- <c:forEach var = "image" items="${ }">
											
										</c:forEach> --%>
									</td>	
								</c:otherwise>
							</c:choose>						
						</tr>
					</tbody>
				</table>
				
				<input type="hidden" name="view_count" value="${FREE_ITEM.view_count }">
				<input type="hidden" name="SEQNO" value="${FREE_ITEM.seq }">
				
				<div align="center">
					<input type="submit" class="btn btn-info" value="upload">
					<input type="reset" class="btn btn-info" value="cancle" onClick="javascript:history.go(-1)">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>