<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/shop3-1.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 화면</title>
</head>
<body>
<!-- add(8.14:10h) -->
<div align="center" class="body">
<h2>상품 상세 화면</h2>
<table>
	<tr><td><img alt="" src="img/${item.pictureUrl }"></td>
		<td align="center">
			<table>
			<tr height="50">
				<td width="80">상품명</td>
				<td width="160">${item.itemName }</td>
			</tr>
			<tr height="50">
				<td width="80">가격</td>
				<td width="160">${item.price }</td>
			</tr>
			<tr height="50">
				<td width="80">비고</td>
				<td width="160">${item.description }</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240">
					<a href="index.html">■ 목록으로 돌아가기</a>
				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>