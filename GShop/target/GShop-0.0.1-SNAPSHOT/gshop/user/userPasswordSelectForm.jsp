<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>비밀번호 찾기</title>
</head>
<body>
<div id="all">
      <div id="content">
         <div class="container">
            <div class="col-md-12">
               <div class="box">
					<form:form modelAttribute="user" action="../userMyPage/userPasswordSelectResult.html" method="post" >
						<h3 align="center">비밀번호 찾기</h3>	
						<table class="table table-hover" border="1" width="320" align="center">
						
							<tr><td>ID</td>
							<td><form:input path="user_id" size="30"/><br>
								<font color="red" size="2"><form:errors path="user_id"/></font>		
							</td>	
							</tr>
							
							<tr><td>이름</td>
							<td><form:input path="user_name" size="30"/><br>
								<font color="red" size="2"><form:errors path="user_name"/></font>		
							</td>	
							</tr>
							
							<tr>
							<td>E-Mail</td>
							<td><input type="email" name="email" size="30"/><br>
								<font color="red" size="2"><form:errors path="email"/></font>
							</tr>
						
							<tr align="center">
								<td colspan="2">
								<input type="submit" value="확인"/>					
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