<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 게시판</title>
</head>
<body>
	<script type="text/javascript">
		function validate(form) {
			var result = confirm("정말로 등록하시겠습니까?");
			//textarea 자동줄바꿈
			var str = document.getElementById("comments").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			document.getElementById("comments").value = str;
			if(result == false) return false;
		}
		//글자수 제한 체크 
		function len_chk(){  
			  var frm = document.insertFrm.test; 
			    
			  if(frm.value.length > 1500){  
			       alert("글자수는 영문1500, 한글750자로 제한됩니다.!");  
			       frm.value = frm.value.substring(0,1500);  
			       frm.focus();  
			  } 
			} 
	</script>
	<div id="all">

        <div id="content">
            <div class="container">
            	<div class="box">
            		<h1>Modify Game</h1>
            	
					<form:form modelAttribute="game" action="../game/putGame.html" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="genre_id">Genre <font color="red">*</font></label>
									<form:select path="genre_id" items="${GENRE_LIST}" itemValue="genre_id" itemLabel="genre_name" multiple="false" class="form-control" id="genre_id"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="game_name">Title <font color="red">*</font></label>
									<form:input path="game_name" size="40" maxlength="50" class="form-control"/>
									<font color="red"><form:errors path="game_name"/></font>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="game_name">Developer <font color="red">*</font></label>
									<form:input path="developer" size="40" maxlength="50" class="form-control"/>
									<font color="red"><form:errors path="developer"/></font>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="publisher">Publisher <font color="red">*</font></label>
									<form:input path="publisher" size="40" maxlength="50" class="form-control"/>
									<font color="red"><form:errors path="publisher"/></font>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="release_date">Release Date</label>
									<form:input path="release_date" size="40" maxlength="50" class="form-control"/>
									<font color="red"><form:errors path="release_date"/></font>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="os_id">OS</label>
									<form:select path="os_id" items="${OS_LIST}" itemValue="os_id" itemLabel="os_name" multiple="false" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="cpu">CPU</label>
									<form:input path="cpu" size="40" maxlength="50" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="memory">Memory</label>
									<form:input path="memory" size="40" maxlength="50" class="form-control" placeholder="GB RAM" value=""/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="capacity">Storage</label>
									<form:input path="capacity" size="40" maxlength="50" class="form-control" placeholder="GB" value=""/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="vga">Graphics</label>
									<form:input path="vga" size="40" maxlength="50" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="network">Network</label>
									<form:input path="network" size="40" maxlength="50" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="price">Price</label>
									<form:input path="price" size="40" maxlength="50" class="form-control" placeholder="￦" value=""/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="discount_rate">Discount Rate</label>
									<form:input path="discount_rate" size="40" maxlength="50" class="form-control" placeholder="%"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="grade">Grade</label>
									<form:select path="grade" items="${GRADE_LIST}" itemValue="grade" itemLabel="grade_desc" multiple="false" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="image">Image <font color="red">*</font></label><p>
									<c:if test ="${! empty game.image1 }"><span>현재 파일 : ${game.image1}</span></c:if>
									<input type="file" name="image" size="40" class="form-control"><p>
									<c:if test ="${! empty game.image2 }"><span>현재 파일 : ${game.image2}</span></c:if>
									<input type="file" name="image" size="40" class="form-control"><p>
									<c:if test ="${! empty game.image3 }"><span>현재 파일 : ${game.image3}</span></c:if>
									<input type="file" name="image" size="40" class="form-control"><p>
									<c:if test ="${! empty game.image4 }"><span>현재 파일 : ${game.image4}</span></c:if>
									<input type="file" name="image" size="40" class="form-control"><p>
									<c:if test ="${! empty game.image5 }"><span>현재 파일 : ${game.image5}</span></c:if>
									<input type="file" name="image" size="40" class="form-control">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="comments">About This Game <font color="red">*</font></label>
									<form:textarea id="comments" rows="12" cols="40" path="comments" onKeyup="len_chk()" class="form-control"/>
								</div>
							</div>
							<div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-pencil"></i> Register</button>
                                    <button type="button" class="btn btn-default" onClick="location.href='../game/gameDetail.html?GAMEID=${game.game_id}'"><i class="fa fa-envelope-o"></i> Cancel</button>
                                </div>
							<!-- <input type="submit" value="등록">
							<input type="button" value="Cancel" onclick="history.go(-1)"> -->
						</div><!-- .row end -->
						<%-- <table border="1">
							<tr>
								<th>장르</th>
								<td><form:select path="genre_id" items="${GENRE_LIST}" itemValue="genre_id" itemLabel="genre_name" multiple="false"/></td>
							</tr>
							<tr>
								<th>게임명</th>
								<td><form:input path="game_name" size="40" maxlength="50"/> <font color="red"><form:errors path="game_name"/></font></td>
							</tr>
							<tr>
								<th>개발사</th>
								<td><form:input path="developer" size="40" maxlength="50"/> <font color="red"><form:errors path="developer"/></font></td>
							</tr>
							<tr>
								<th>배급사</th>
								<td><form:input path="publisher" size="40" maxlength="50"/> <font color="red"><form:errors path="publisher"/></font></td>
							</tr>
							<tr>
								<th>출시일</th>
								<td><form:input path="release_date" size="40" maxlength="8"/></td>
							</tr>
							<tr>
								<th>운영체제</th>
								<td><form:select path="os_id" items="${OS_LIST}" itemValue="os_id" itemLabel="os_name" multiple="false"/></td>
							</tr>
							<tr>
								<th>CPU</th>
								<td><form:input path="cpu" size="40" maxlength="50"/></td>
							</tr>
							<tr>
								<th>메모리</th>
								<td><form:input path="memory" size="40" maxlength="2"/> GB RAM</td>
							</tr>
							<tr>
								<th>저장공간</th>
								<td><form:input path="capacity" size="40" maxlength="3"/> GB</td>
							</tr>
							<tr>
								<th>그래픽카드</th>
								<td><form:input path="vga" size="40" maxlength="50"/></td>
							</tr>
							<tr>
								<th>네트워크</th>
								<td><form:input path="network" size="40" maxlength="30"/></td>
							</tr>
							<tr>
								<th>게임 가격</th>
								<td><form:input path="price" size="40" maxlength="8"/> 원</td>
							</tr>
							<tr>
								<th>할인율</th>
								<td><form:input path="discount_rate" size="40" maxlength="3"/> %</td>
							</tr>
							<tr>
								<th>게임등급</th>
								<td><form:select path="grade" items="${GRADE_LIST}" itemValue="grade" itemLabel="grade_desc" multiple="false"/></td>
							</tr>
							<tr>
								<th rowspan="5">이미지</th>
								<td><input type="file" name="image" size="40"> <font color="red"><form:errors path="image1"/></font></td>
							</tr>
							<tr>
								<td><input type="file" name="image" size="40"></td>
							</tr>
							<tr>
								<td><input type="file" name="image" size="40"></td>
							</tr>
							<tr>
								<td><input type="file" name="image" size="40"></td>
							</tr>
							<tr>
								<td><input type="file" name="image" size="40"></td>
							</tr>
							<tr>
								<th>게임설명</th>
								<td><form:textarea id="comments" rows="12" cols="40" path="comments" onKeyup="len_chk()"/> <font color="red"><form:errors path="comments"/></font></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="등록"><input type="button" value="취소" onclick="history.go(-1)">
								</td>
							</tr>
						</table> --%>
					</form:form>
					
					
					
				</div><!-- .box end -->
			</div><!-- .container end -->
		</div><!-- #content end -->
	</div><!-- #all end -->
</body>
</html>