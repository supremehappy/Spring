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
<title>MaPage</title>
</head>
<body>
<div id="all">
      <div id="content">
         <div class="container">
            <div class="col-md-12">
               <div class="box">
					<h3 align="center">ID 찾기 결과</h3>	
					
					<table class="table table-hover"  border="1" width="290" align="center">		
						<tr align="center"><td>		
						회원님의 ID는
						<c:if test="${!empty USER_IDSELECT}">			
							<br><font color="red" size="4">${USER_IDSELECT}</font>
							입니다.
						</c:if>
						<c:if test="${empty USER_IDSELECT}">
							가입되어있지 않습니다.<br>
							다시 확인해주세요.
						</c:if>				
						</td>	
						</tr>		
					</table>
				 </div><!-- .box end -->
            </div><!-- .col-md-12 end -->
         </div><!-- .container end -->
      </div><!-- #content end -->
   </div><!-- #all end -->

</body>
</html>