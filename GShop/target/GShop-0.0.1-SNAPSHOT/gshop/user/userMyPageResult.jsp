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
				<script type="text/javascript">
				function openDelete(){
					var result = confirm("정말로 탈퇴하시겠습니까?");
				 	if(result == false) {
				 		return false;
				 	}else{
				 		location.href="../userMyPage/deleteUser.html";
				 		alert("탈퇴 되었습니다.")
				 	}
				}
				</script>
				
				<h3 align="center">MyPage</h3>
					
					<table class="table table-hover">
						<tr><td align="center">
						<c:if test="${!empty USER.picture}">	
							<img src="../upload/${USER.picture}" width="170"/>
						</c:if>	
						<c:if test="${empty USER.picture}">	
							<img src="../upload/XXXXXXXXXXPANDAXXXXXXXX.jpg" width="170"/>
						</c:if>		
						</td></tr>
						<tr><td colspan="2" align="center">
						
				        <a href="../userMyPage/userSelect.html">수정</a>&emsp;        
						<a href="javascript:openDelete()">탈퇴</a>&emsp;
						<a href="../charge/chargeForm.html">충전</a>
						</td></tr>
					</table>
					
					
					<table class="table table-hover">	
						<tr><td>닉네임</td>
						<td align="center">${USER.nickname}</td>	
						</tr>
						
						<tr><td>이름</td>
						<td align="center">${USER.user_name}</td>	
						</tr>
						
						<tr><td>주문 내역</td>
						<td align="center"><a href="../order/list.html">${USER.bought_games}</a>&nbsp;개</td>		
						</tr>
						
						<tr><td>찜 리스트</td>	
						<td align="center">${USER.favorite_games}&nbsp;개</td>		
						</tr>
					</table>
					</div><!-- .box end -->
            </div><!-- .col-md-12 end -->
         </div><!-- .container end -->
      </div><!-- #content end -->
   </div><!-- #all end -->
</body>
</html>