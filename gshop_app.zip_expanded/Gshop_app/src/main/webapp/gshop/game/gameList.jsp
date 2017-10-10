<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/gshop/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h2> game </h2>
	
	<div class="ui-grid-a">
		<div class="ui-bar ui-bar-a">
			<div class="fotorama">
			
			</div>	
		</div>
	</div><!-- /grid-a -->
	
	<br>
	
	<div class="ui-grid-a">
		<div class="ui-body ui-body-a ui-corner-all">
				content
			</div>
	</div><!-- /grid-a -->
	
	<table data-role="table" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b" data-column-btn-text="Columns to display..." data-column-popup-theme="a">
		<thead>
			<tr class="ui-bar-d">
				<th data-priority="2">Rank</th>
				<th>Movie Title</th>
				<th data-priority="3">Year</th>
				<th data-priority="1"><abbr title="Rotten Tomato Rating">Rating</abbr></th>
				<th data-priority="5">Reviews</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>1</th>
				<td><a href="http://en.wikipedia.org/wiki/Citizen_Kane" data-rel="external">Citizen Kane</a></td>
				<td>1941</td>
				<td>100%</td>
				<td>74</td>
			</tr>
			<tr>
				<th>2</th>
				<td><a href="http://en.wikipedia.org/wiki/Casablanca_(film)" data-rel="external">Casablanca</a></td>
				<td>1942</td>
				<td>97%</td>
				<td>64</td>
			</tr>
			<tr>
				<th>3</th>
				<td><a href="http://en.wikipedia.org/wiki/The_Godfather" data-rel="external">The Godfather</a></td>
				<td>1972</td>
				<td>97%</td>
				<td>87</td>
			</tr>
		</tbody>
	</table>

</body>
<%@ include file="/gshop/footer.jsp" %>
</html>