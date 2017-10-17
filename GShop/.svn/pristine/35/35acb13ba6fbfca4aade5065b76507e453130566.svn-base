<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>charge list</title>
</head>
<body>
<div id="all">
      <div id="content">
         <div class="container">
            <div class="col-md-13">
               <div class="box">
					<div class="body" align="center">
						<h2> 충전 내역</h2>
						<br>
						<h2>Hover Rows</h2>
						<p>The .table-hover class enables a hover state on table rows:</p>            
						<table class="table table-hover">
							<thead>
								<tr>
									<th>no</th>
									<th>charge cash</th>
									<th>date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="charge" items="${CHARGE_LIST }">
									<tr>
										<td>${charge.charge_id }</td>
										<td>${charge.total_amount }</td>
										<td>${charge.charge_date }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<c:forEach var="page" begin="1" end="${COUNT }">
								<a href="../charge/chargeList.html?PAGENO=${page }&ID=${user_key}">${page }</a>
						</c:forEach>
							
							<div align="right">
								<input type="button" value="list" onClick="javascript:history.go(-1)"/>
							</div>
					</div>
				</div><!-- .box end -->
            </div><!-- .col-md-12 end -->
         </div><!-- .container end -->
      </div><!-- #content end -->
   </div><!-- #all end -->
</body>
</html>