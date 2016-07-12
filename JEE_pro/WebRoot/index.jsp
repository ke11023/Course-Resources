<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-gb" class="no-js">
<!--<![endif]-->

<head>
<title>elos - Multipurpose HTML5 Template</title>

<meta charset="utf-8">
<meta name="keywords" content="" />
<meta name="description" content="" />

<!-- Favicon -->
<link rel="shortcut icon" href="sta/images/favicon.ico">

<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Google fonts - witch you want to use - (rest you can just remove) -->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>

<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<!-- ######### CSS STYLES ######### -->

<link rel="stylesheet" href="sta/css/reset.css" type="text/css" />
<link rel="stylesheet" href="sta/css/style.css" type="text/css" />

<link rel="stylesheet"
	href="sta/css/font-awesome/css/font-awesome.min.css">

<!-- responsive devices styles -->
<link rel="stylesheet" media="screen"
	href="sta/css/responsive-leyouts.css" type="text/css" />

<!-- mega menu -->
<link href="sta/js/mainmenu/sticky.css" rel="stylesheet">
<link href="sta/js/mainmenu/bootstrap.css" rel="stylesheet">
<link href="sta/js/mainmenu/fhmm.css" rel="stylesheet">

<!-- cubeportfolio -->
<link rel="stylesheet" type="text/css"
	href="sta/js/cubeportfolio/cubeportfolio.min.css">

<!-- tabs -->
<link rel="stylesheet" type="text/css"
	href="sta/js/tabs/assets/css/responsive-tabs.css">
<link rel="stylesheet" type="text/css"
	href="sta/js/tabs/assets/css/responsive-tabs2.css">
<link rel="stylesheet" type="text/css"
	href="sta/js/tabs/assets/css/responsive-tabs3.css">

<!-- carousel -->
<link rel="stylesheet" href="sta/js/carousel/flexslider.css"
	type="text/css" media="screen" />
<link rel="stylesheet" type="sta/text/css" href="js/carousel/skin.css" />

<!-- accordion -->
<link rel="stylesheet" href="sta/js/accordion/accordion.css"
	type="text/css" media="all">


<!-- login&registerForm style -->
<link href="dist/css/loginReg.css" rel="stylesheet" type="text/css" />
</head>

<body>


	<div class="wrapper_boxed">

		<div class="site_wrapper">

			<header id="header">

				<!-- Top header bar -->
				<div id="topHeader">

					<div class="wrapper">

						<div class="top_nav">
							<div class="container">

								<div class="left">
								<ul>
									<li>精品课程网站</li>
								</ul>
								</div>
								<!-- end left links -->

								<c:if test="${student_id==null}">
									<div class="login">
									<ul>
										<li class="link"><a class="fancybox"
											href="#">登录</a></li>
										<!-- <li class="link"><a class="fancybox fancybox.ajax"
											href="register-frame.html">注册</a></li> -->
									</ul>
									
									</div>
								</c:if>
								<c:if test="${student_id!=null}">
									<div class="right">
									<ul>
										<li class="link"><a class="fancybox" 
										href="studentpage">欢迎，${studentname}</a></li>
										<li class="link"><a class="fancybox" 
										href="singout">登出</a></li>
											</ul>
									
									</div>
								</c:if>
									
								<!-- end right social links -->

							</div>
						</div>

					</div>

				</div>
				<!-- end top navigation -->


				<div id="trueHeader">

					<div class="wrapper">

						<div class="container">

							<!-- Logo -->
							<div class="logo">
								<a href="index.jsp" id="logo"></a>
							</div>

							<!-- Menu -->
							<div class="menu_main">

								<nav class="navbar navbar-default fhmm" role="navigation">
									<div class="navbar-header">
										<button type="button" data-toggle="collapse"
											data-target="#defaultmenu" class="navbar-toggle">
											Menu <i class="fa fa-bars tbars"></i>
										</button>
									</div>
									<!-- end navbar-header -->

									<div id="defaultmenu" class="navbar-collapse collapse">
										<ul class="nav navbar-nav">										

											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle">计算机学院</a>
												
												<ul class="dropdown-menu" role="menu">
													<c:forEach var="computer" items="${computer}">
														<li><a href="content?id=${computer.cid }">${computer.cname }</a></li>
													</c:forEach>
												</ul> <!-- end dropdown-menu --></li>
												

											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle">经管学院</a>
												<ul class="dropdown-menu" role="menu">
													<c:forEach var="economy" items="${economy}">
														<li><a href="content?id=${economy.cid }">${economy.cname }</a></li>
													</c:forEach>
												</ul> <!-- end dropdown-menu --></li>


											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle">电气学院</a>
												<ul class="dropdown-menu" role="menu">
													<c:forEach var="electric" items="${electric}">
														<li><a href="content?id=${electric.cid }">${electric.cname }</a></li>
													</c:forEach>
												</ul> <!-- end dropdown-menu --></li>


											<li class="dropdown"><a href="#" data-toggle="dropdown"
												class="dropdown-toggle">数理学院</a>
												<ul class="dropdown-menu" role="menu">
													<c:forEach var="math" items="${math}">
														<li><a href="content?id=${math.cid }">${math.cname }</a></li>
													</c:forEach>
												</ul> <!-- end dropdown-menu --></li>
									</div>
									<!-- end #navbar-collapse-1 -->

								</nav>

							</div>

						</div>
					</div>

				</div>

			</header>

			<div class="clearfix"></div>

			<!-- Contant
======================================= -->
			<div class="page_title2">
				<div class="container">

					<div class="title">
						<h1>Home</h1>
					</div>

					<div class="pagenation">
						&nbsp;Home
					</div>

				</div>
			</div>
			<!-- content end!!! -->

			<div class="clearfix margin_top7"></div>

			<div class="clearfix"></div>

			<a href="#" class="scrollup">Scroll</a>
			<!-- end scroll to top of the page-->


	

		</div>
	</div>



		<!-- loginForm -->
	<div class="cd-user-modal">
		<div class="cd-user-modal-container">
			<ul class="cd-switcher">
				<li><a href="#0">用户登录</a></li>
				<li><a href="#0">注册新用户</a></li>
			</ul>

			<div id="cd-login">
				<form class="cd-form" action="student_login" method="post">
					<!-- 登录表单 -->
					<p class="fieldset">
						<label class="image-replace cd-username" for="signin-username">用户名</label>
						<input class="full-width has-padding has-border"
							name="Login_name" type="text" placeholder="输入用户名">
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">密码</label>
						<input class="full-width has-padding has-border"
							name="Login_pwd" type="password" placeholder="输入密码">
					</p>

					<p class="fieldset">
						<input type="checkbox" id="remember-me" checked> <label
							for="remember-me">记住登录状态</label>
					</p>

					<p class="fieldset">
						<input class="full-width2" type="submit" value="登 录">
					</p>
				</form>
			</div>

			<div id="cd-signup">
				<form class="cd-form" action="regist" method="post">
					<!-- 注册表单 -->
					<p class="fieldset">
					<label class="image-replace cd-username" for="signup-username">用户名</label>
					<input class="full-width has-padding has-border" onblur="checkLogin();"
						name="name" id="name" type="text" placeholder="输入用户名">
					</p><font id="result"></font>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signup-password">密码</label>
						<input class="full-width has-padding has-border"
							name="pwd" type="password" placeholder="输入密码">
					</p>

					<p class="fieldset">
						<input type="checkbox" id="accept-terms"> <label
							for="accept-terms">我已阅读并同意 <a href="">用户协议</a></label>
					</p>

					<p class="fieldset">
						<input class="full-width2" type="submit" id="submit" value="注册新用户" disabled="disabled">
					</p>
				</form>
			</div>
			<a href="" class="cd-close-form">关闭</a>
		</div>
	</div>

	<!-- ######### JS FILES ######### -->
	<!-- get jQuery from the google apis -->
	<script type="text/javascript" src="sta/js/universal/jquery.js"></script>

	<!-- style switcher 切换-->
	<script src="sta/js/style-switcher/jquery-1.js"></script>
	<script src="sta/js/style-switcher/styleselector.js"></script>

	<!-- SLIDER REVOLUTION 4.x SCRIPTS  滑块-->
	<script type="text/javascript"
		src="sta/js/revolutionslider/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
	<script type="text/javascript"
		src="sta/js/revolutionslider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

	<!-- mega menu 下拉框-->
	<script src="sta/js/mainmenu/bootstrap.min.js"></script>
	<script src="sta/js/mainmenu/fhmm.js"></script>



	<!-- scroll up -->
	<script src="sta/js/scrolltotop/totop.js" type="text/javascript"></script>

	<!-- tabs -->
	<script src="sta/js/tabs/assets/js/responsive-tabs.min.js"
		type="text/javascript"></script>


	<!-- accordion 折叠面板-->
	<script type="text/javascript" src="sta/js/accordion/custom.js"></script>

	<!-- sticky menu 导航栏固定-->
	<script type="text/javascript" src="sta/js/mainmenu/sticky.js"></script>
	<script type="text/javascript"
		src="sta/js/mainmenu/modernizr.custom.75180.js"></script>

	<!-- progress bar 进度条-->
	<script src="sta/js/progressbar/progress.js" type="text/javascript"
		charset="utf-8"></script>

	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-374977-27' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>


	<script type="text/javascript">
		// Menu drop down effect
		$('.dropdown-toggle').dropdownHover().dropdown();
		$(document).on('click', '.fhmm .dropdown-menu', function(e) {
			e.stopPropagation();
		});
	</script>
	
	
	
 	<!-- login&registerForm js -->
    <script src="dist/js/loginReg.js"></script>
    
    
</body>
</html>
