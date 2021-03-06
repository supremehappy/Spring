<html>
<div data-role="page">
	<%@ include file="/gshop/header.jsp"%>

	<div role="main" class="ui-content">

		<br>
		<h2>new</h2>
		<!-- fotorama part 1 -->
		<div class="ui-grid-a">
			<div class="ui-bar ui-bar-a">
				<div class="fotorama" data-arrows="true" data-width="100%"
					data-ratio="965/643" data-allow-fullscreen="true" data-nav="thumbs"
					data-autoplay="true">
					<c:forEach var="img" items="${NEW}">
						<a href="#">12312<img src="${pageContext.request.contextPath }/upload/game/${img.image2}"></a>
					</c:forEach>
				</div>
			</div>
		</div>

		<br>
		<h2>sale</h2>
		<!-- fotorama part 1 -->
		<div class="ui-grid-a">
			<div class="ui-bar ui-bar-a">
					<div class="fotorama" data-arrows="true" data-width="100%"
		data-ratio="965/643" data-allow-fullscreen="true"
		data-nav="thumbs" data-autoplay="true">
	     
	     <c:forEach var="img" items="${SALE}">
	     	<a href="#" ><img src="${pageContext.request.contextPath }/upload/game/${img.image2}"></a>
	     </c:forEach>
				</div>
			</div>
		</div>

		<br>
		<h2>hot</h2>
		<!-- fotorama part 2 -->
		<div class="ui-grid-a">
			<div class="ui-bar ui-bar-a">
				<div class="fotorama" data-arrows="true" data-width="100%"
		data-ratio="965/643" data-allow-fullscreen="true"
		data-nav="thumbs" data-autoplay="true">
	     <c:forEach var="img" items="${BEST}">
	     	<a href="#" ><img src="${pageContext.request.contextPath }/upload/game/${img.image2}"></a>
	     	</c:forEach>
				</div>
			</div>
		</div>

	</div>

	<%@ include file="/gshop/footer.jsp"%>
</div>
</html>