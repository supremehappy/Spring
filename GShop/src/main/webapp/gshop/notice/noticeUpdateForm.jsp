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
	if(form.post_pw.value == ""){
		alert("암호를 입력하세요."); return false;
	}
	
	var result = confirm("정말로 변경하시겠습니까?");
	if(result == false) return false;
}
</script>
<body>
<h2>notice update detail</h2>
	<div class="body">
		<div class="container">
			<form:form modelAttribute = "notice" action="../notice/noticeUpdateForm.html" method ="post" enctype="multipart/form-data" onSubmit="return validate(this)" commandName="notice">
				<h2>Bordered Table</h2>
				<p>The .table-bordered class adds borders to a table:</p>            
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td width="60"><h4>category</h4></td>
							<td>
							<form:select class="form-control" id="sel1" path="header_id" name = "header_id" items="${HEADER_LIST }" itemName="header_name" />
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
							<td><form:input type="text" class="form-control" id="id" path ="admin_id" value="${NOTICE_ITEM.admin_id }"  disabled="true"/></td>
						</tr>
						<tr>
							<td width="60"><h4>title</h4></td>
							<td><form:input type="text" class="form-control" id="usr" path="post_title" name="post_title" value="${NOTICE_ITEM.post_title }"/>
							<font color="red"><form:errors path="post_title"></form:errors></font></td>
						</tr>
						<tr>
							<td width="60"><h4>pw</h4></td>
							<td>
								<form:password class="form-control" path="post_pw" name="post_pw"/>
								<font color="red"><form:errors path="post_pw"/></font>
							</td>
						</tr>
						<tr>
							<td width="60"><h4>content</h4></td>
							<td><form:textarea class="form-control" rows="20" id="comment" path="post_content" name="post_content" value="${NOTICE_ITEM.post_content}"/>
							<font color="red"><form:errors path="post_content"></form:errors></font></td>
							
						</tr>
						<tr>
							<c:choose>
								
								<c:when test="${empty NOTICE_ITEM.image1 }">
									<td width="60"><h4>image</h4></td>
									<td width="300">
										<div align="left">image</div>
										<div align="right"><input type="file" class="btn btn-info" value="upload" name="image" multiple="multiple"></div>
									</td>
								</c:when>
								<c:otherwise>
									<td width="60"><h4>image</h4></td>
									<td>
										<c:if test="${!empty NOTICE_ITEM.image1 }">
										<img class="img-thumbnail" alt="" width ="200" height="150" src="../upload/${NOTICE_ITEM.image1 }">
										</c:if>
										<c:if test="${!empty NOTICE_ITEM.image2 }">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image2 }">
										</c:if>
										<c:if test="${!empty NOTICE_ITEM.image3 }">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image3 }">
										</c:if>
										<c:if test="${!empty NOTICE_ITEM.image4 }">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image4 }">
										</c:if>
										<c:if test="${!empty NOTICE_ITEM.image5 }">
											<img class="img-thumbnail" alt="" width ="200" height="150" src="${pageContext.request.contextPath }/upload/${NOTICE_ITEM.image5 }">
										</c:if>
										<div align="left">image</div>
										<div align="right"><input type="file" class="btn btn-info" value="upload" name="image" multiple="multiple"></div>
									</td>	
								</c:otherwise>
							</c:choose>						
						</tr>
					</tbody>
				</table>
				
				<input type="hidden" name="view_count" value="${NOTICE_ITEM.view_count }">
				<input type="hidden" name="SEQNO" value="${NOTICE_ITEM.seq }">
				
				<div align="center">
					<input type="submit" class="btn btn-info" value="upload">
					<input type="reset" class="btn btn-info" value="cancle" onClick="javascript:history.go(-1)">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>