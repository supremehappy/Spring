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
	<h2>notice detail</h2>
	<div class="body">
		<div class="container">
		<form onSubmit="return validate(this)">
			<h2>Bordered Table</h2>
			<p>The .table-bordered class adds borders to a table:</p>            
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td width="60"><h4>wirter</h4></td>
						<td>${FREE_ITEM.user_id }</td>
					</tr>
					<tr>
						<td width="60"><h4>title</h4></td>
						<td>${FREE_ITEM.post_title }</td>
					</tr>
					<tr>
						<td width="60"><h4>content</h4></td>
						<td>${FREE_ITEM.post_content }</td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${empty FREE_ITEM.image1 }">
								
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
								</td>	
							</c:otherwise>
						</c:choose>						
					</tr>
				</tbody>
			</table>
			
			<input type="hidden" name="view_count" value="${FREE_ITEM.view_count }">
			
			<c:choose>
				<c:when test="${not empty user_key }">
					<div align="center">
						<a href="../read/freeList.html" class="btn btn-info" role="button">list</a>
						<a href="../write/freeUpdate.html?SEQNO=${FREE_ITEM.seq}" class="btn btn-info" role="button">update</a>
						<a href="../write/freeDelete.html?SEQNO=${FREE_ITEM.seq}" class="btn btn-info" role="button">delete</a>
					</div>	
				</c:when>
				<c:when test="${not empty admin_key }">
					<div align="center">
						<a href="../read/freeList.html" class="btn btn-info" role="button">list</a>
						<a href="../write/freeUpdate.html?SEQNO=${FREE_ITEM.seq}" class="btn btn-info" role="button">update</a>
						<a href="../write/freeDelete.html?SEQNO=${FREE_ITEM.seq}" class="btn btn-info" role="button">delete</a>
					</div>	
				</c:when>
				<c:otherwise>
					<div align="center">
						<a href="../read/freeList.html" class="btn btn-info" role="button">list</a>
					</div>
				</c:otherwise>
			</c:choose>
			</form>
		</div>
	</div>
</body>
</html>