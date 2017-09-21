<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
</head>
<body>
	<div class= "body">
		<div class="jumbotron text-center">
		  <h1>My First Bootstrap Page</h1>
		  <p>Resize this responsive page to see the effect!</p> 
		</div>
	
		<div class="container">
		  <div class="row">
		    <div class="col-sm-4">
		      <h3>Column 1</h3>
		      <p>Lorem ipsum dolor..</p>
		      <p>Ut enim ad..</p>
		    </div>
		    <div class="col-sm-4">
		      <h3>Column 2</h3>
		      <p>Lorem ipsum dolor..</p>
		      <p>Ut enim ad..</p>
		    </div>
		    <div class="col-sm-4">
		      <h3>Column 3</h3> 
		      <p>Lorem ipsum dolor..</p>
		      <p>Ut enim ad..</p>
		    </div>
		  </div>
		</div>
		<a href="../login/loginForm.html" class="btn btn-info" role="button">login</a>
		
		<div>
			<c:choose>
				<c:when test="${sessionScope.loginUser == null }">
					<jsp:include page="../gshop/login_out/loginForm.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../gshop/login_out/logout.jsp"/>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<c:choose>
				<c:when test="${sessionScope.loginAdmin == null }">
					<jsp:include page="../gshop/login_out/loginForm.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../gshop/login_out/logout.jsp"/>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<c:choose>
				<c:when test="${BODY !=null }">
					<jsp:include page="${BODY} "/>
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>