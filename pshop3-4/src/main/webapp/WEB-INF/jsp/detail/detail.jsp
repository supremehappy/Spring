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
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>

<div align="center" class="body">
<h2>상품 상세 화면</h2>
<table>
	<tr><td>작성자</td><td>${product.id }</td>
		<td align="center">
			<table>
			<tr height="50">
				<td width="80">상품명</td>
				<td width="160">${product.name }</td>
			</tr>
			<tr height="50">
				<td width="80">가격</td>
				<td width="160">${product.price }</td>
			</tr>			
			<tr height="50">
				<td width="80">내용</td>
				<td width="160">${product.content }</td>
			</tr>
			<tr height="50">
				<td colspan="2" align="center" width="230">
					<form action="../cart/cartAdd.html">
						<input type="hidden" name="product" value="${product.pid }"/>
							
							<table>
								<tr>
									<td>
										<select name="quantity">
											<option>1</option><option>2</option>
											<option>3</option><option>4</option>
											<option>5</option><option>6</option>
										</select>&nbsp; 개
									</td>
									<td>
										<input type="submit" value="카트에 담기"/>
									</td>
								</tr>							
							</table>
							
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240">
					<a href="../index/index.html">■ 목록으로 돌아가기</a>
				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>