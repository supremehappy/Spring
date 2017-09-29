<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>charge from</title>
</head>
<script type="text/javascript">
function validate(form){
	var result = confirm("정말로 충전하시겠습니까?");
	if(result == false) return false;
	else alert("충전되었습니다.");
	location.href="";
}
</script>
<body>
	<div class="body" align="center">
		<h2> 충전 하기</h2>
		<form:form onSubmit="return validate(this)">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h5 align="right">보유 중인 금액</h5><br>
					${유저 보유 금액 }
				</div>
				<div class="col-sm-4"></div>
			</div>
				
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					충전금액 
					<form:select path="${total_amount }">
						<form:option value="1000">\1,000</form:option>
						<form:option value="5000">\5,000</form:option>
						<form:option value="10000">\10,000</form:option>
						<form:option value="30000">\30,000</form:option>
						<form:option value="50000">\50,000</form:option>
						<form:option value="100000">\100,000</form:option>
						<form:option value="150000">\150,000</form:option>
						<form:option value="300000">\300,000</form:option>
					</form:select>
				</div>
				<div class="col-sm-4"></div>
			</div>
			
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					충전 후 금액
					<br>
					<h4 align="right">${유저 보유 금액 }</h4> 
				</div>
				<div class="col-sm-4"></div>
			</div>
			<div align="center">
					<input type="submit" class="btn btn-info" value="charge">
					<a href="" class="btn btn-info" role="button">charge List</a>
				</div>
		</form:form>
	</div>
</body>
</html>