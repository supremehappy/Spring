<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


	<link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>
	
	<!-- styles -->
	<link href="../css/font-awesome.css" rel="stylesheet">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/animate.min.css" rel="stylesheet">
	<link href="../css/owl.carousel.css" rel="stylesheet">
	<link href="../css/owl.theme.css" rel="stylesheet">
	
	<!-- theme stylesheet -->
	<link href="../css/style.default.css" rel="stylesheet" id="theme-stylesheet">
	
	<!-- your stylesheet with modifications -->
	<link href="../css/custom.css" rel="stylesheet">
	
	<script src="../js/respond.min.js"></script>
	
	<link rel="shortcut icon" href="favicon.png">
	
	
	
	
    <!-- *** TOPBAR ***
 _________________________________________________________ -->
    <div id="top">
        <div class="container">
            <div class="col-md-12" data-animate="fadeInDown">
                <ul class="menu">
                
                <%-- <c:when test="${not empty user_key }">
					<c:if test="${!empty user_nickname }">
						<font color="red"><c:out value="${user_nickname}"></c:out>님, 환영합니다.</font>
					</c:if>
					<c:if test="${empty user_nickname }">
						<font color="red"><c:out value="${USER.nickname}"></c:out>님, 환영합니다.</font>
					</c:if>					
				</c:when> --%>
                
                
                	<c:choose>
						<c:when test="${not empty user_key }">
							<c:if test="${empty user_nickname}">	
								<li><font color="#4fbfa8"><a href="../userMyPage/userMyPage.html"><c:out value="${USER.nickname}"></c:out></a></font><font color="white"> 님 환영합니다</font></li>
							</c:if>
							<c:if test="${!empty user_nickname}">	
								<li><a href="../userMyPage/userMyPage.html"><font color="#4fbfa8"><c:out value="${user_nickname}"></c:out></font></a><font color="white"> 님 환영합니다</font></li>
							</c:if>	
						</c:when>
						<c:when test="${not empty admin_key }">
							<li><a href="../admin/adminPage.html"><font color="white"> [관리자]</font><font color="#4fbfa8"><c:out value="${admin_key}"></c:out></font></a><font color="white"> 님 환영합니다.</font> 
						</c:when>
						<c:otherwise>
							<li><a href="../login/loginForm.html">Login</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty user_key }">					
							<li><a href="../logout/logout.html">Logout</a>
							</li>
						</c:when>	
						<c:when test="${not empty admin_key }">
							<li><a href="../logout/logout.html">Logout</a>
							</li>
						</c:when>	
						<c:otherwise>
							<li><font color="red"><a href="../user/userInputForm.html">Register</a></font>
							</li>
						</c:otherwise>	
					</c:choose>
                </ul>
            </div>
        </div>

    </div>

    <!-- *** TOP BAR END *** -->


    <!-- *** NAVBAR ***
 _________________________________________________________ -->

    <div class="navbar navbar-default yamm" role="navigation" id="navbar">
        <div class="container">
            <div class="navbar-header">

                <a class="navbar-brand home" href="../mainPage/index.html" data-animate-hover="bounce">
                    <img src="../upload/logo.png" alt="GShop Logo" class="hidden-xs">
                    <img src="../upload/logo-small.png" alt="GShop Logo" class="visible-xs"><span class="sr-only">Obaju - go to homepage</span>
                </a>
                <div class="navbar-buttons">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <i class="fa fa-align-justify"></i>
                    </button>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
            <!--/.navbar-header -->

            <div class="navbar-collapse collapse" id="navigation">

                <ul class="nav navbar-nav navbar-left">
                    <li class="active" ><a href="../mainPage/index.html">Home</a>
                    </li>
                    <li><a href="../game/gameList.html">Game</a>
                    </li>
                    <li><a href="../community/list.html">Community</a>
                    </li>
                    <li><a href="../notice/noticeList.html">Notice</a>
                    </li>
					
                </ul>

            </div>
            <!--/.nav-collapse -->

            <div class="navbar-buttons">


                <div class="navbar-collapse collapse right" id="search-not-mobile">
                    <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                </div>

            </div>

            <div class="collapse clearfix" id="search">

                <form class="navbar-form" role="search" action="../game/gameList.html">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Game Search" name="SEARCH">
                        <span class="input-group-btn">

			<button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

		    </span>
                    </div>
                </form>

            </div>
            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
    </div>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->

