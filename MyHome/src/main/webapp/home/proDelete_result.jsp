<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ empty param.id }">
<script type="text/javascript">
	alert("삭제 되었습니다."); 
	location.href="pro-list";
</script>
</c:if>
<c:if test="${ ! empty param.id }">
<script type="text/javascript">
	alert("암호가 일치하지 않습니다."); 
	location.href="pro-read?id="+${param.id};
</script>
</c:if>
</body>
</html>