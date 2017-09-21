<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="../login/main.html" method="post">
	  <div class="input-group">
	    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	    <input id="id" type="text" class="form-control" name="user_id" placeholder="Id" size="20">
	  </div>
	  <div class="input-group">
	    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	    <input id="password" type="password" class="form-control" name="password" placeholder="Password" size="20">
	  </div>
	  <div align="center">
		  <input type="submit" class="btn btn-info" value="login">
		  <a href="#" class="btn btn-info" role="button">join</a>
		  <a href="#" class="btn btn-info" role="button">id 찾기</a>
		  <a href="#" class="btn btn-info" role="button">pw 찾기</a>
	  </div>
	</form>
</body>
</html>