<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>
<link rel="stylesheet" type="text/css" href="dist/css/loginReg.css" />
<!-- jQuery 2.2.0 -->
<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>


<script src="dist/js/loginReg.js"></script>
</head>
<body>
	<nav class="main_nav">
	<ul>
		<li><a class="cd-signin" href="#0">登录</a></li>
		<li><a class="cd-signup" href="#0">注册</a></li>
	</ul>
	</nav>

	<div class="cd-user-modal">
		<div class="cd-user-modal-container">
			<ul class="cd-switcher">
				<li><a href="#0">用户登录</a></li>
				<li><a href="#0">注册新用户</a></li>
			</ul>

			<div id="cd-login">
				<form class="cd-form" action="manager_login">
					<!-- 登录表单 -->
					<p class="fieldset">
						<label class="image-replace cd-username" for="signin-username">用户名</label>
						<input class="full-width has-padding has-border"
							id="signin-username" type="text" placeholder="输入用户名">
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">密码</label>
						<input class="full-width has-padding has-border"
							id="signin-password" type="text" placeholder="输入密码">
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
				<form class="cd-form">
					<!-- 注册表单 -->
					<p class="fieldset">
					<label class="image-replace cd-username" for="signup-username">用户名</label>
					<input class="full-width has-padding has-border" onblur="checkLogin();"
						id="name" type="text" placeholder="输入用户名">
					</p><font id="result"></font>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signup-password">密码</label>
						<input class="full-width has-padding has-border"
							id="signup-password" type="text" placeholder="输入密码">
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

</body>
</html>
