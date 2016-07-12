<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="teacher" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b>LTE</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Notifications: style can be found in dropdown.less -->

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">${username}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">
									<p>${username}</p></li>

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="InfoManager?id=${teacher}"
											class="btn btn-default btn-flat">Manager</a>
									</div>
									<div class="pull-right">
										<a href="login.html" class="btn btn-default btn-flat">Sign
											out</a>
									</div>
								</li>
							</ul></li>

					</ul>
				</div>
			</nav>
		</header>

		<!-- =============================================== -->

		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<!-- <div class="user-panel">
					<div class="pull-left image">
						<img src="。。/dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>课程资源管理</p>
						<a href="#"><i class="fa fa-circle text-success"></i></a>
					</div>
				</div> -->

				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li><a href="resourceUpload"> <i class="fa fa-dashboard"></i>
							<span>资源上传</span>
					</a></li>

					<li><a href="homework"> <i class="fa fa-files-o"></i><span>作业发布</span>
					</a></li>

					<li><a href="resourceInfo"> <i class="fa fa-th"></i> <span>资源管理</span>
					</a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					资源上传 <small>Resource Upload</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="teacher"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">ResourceUpload</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="box box-info" style="width:800px;">
					<div class="box-header with-border">
						<h3 class="box-title">Course</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<form role="form" action="upLoad" enctype="multipart/form-data" method="post">
							<!-- select -->
							<div class="form-group">
								<label>课程编号</label> <select class="form-control" name="cid">
									<c:forEach var="info" items="${info}">
										<option>${info.cid}</option>
									</c:forEach>
								</select>
							</div>
							<!-- text input -->
							<div class="form-group">
								<label>资源名称</label> <input type="text" class="form-control"
									name="rname" placeholder="请输入资源名称">
							</div>
							<div class="form-group">
								<label>资源类型</label> <select class="form-control" name="rtype">
									<option>教学大纲</option>
									<option>教学进度表</option>
									<option>实验进度表</option>
									<option>课件</option>
									<option>实验指导</option>
									<option>讲义</option>
								</select>
							</div>

							<!-- textarea -->
							<div class="form-group">
								<label>资源简介</label>
								<textarea class="form-control" name="cbrief" rows="4"
									placeholder="请对资源进行介绍"></textarea>
							</div>

							<div class="form-group">
								<label for="exampleInputFile">Resource Upload</label> <input
									type="file" id="upload" name="upload" onchange="LimitAttach()">

								<p class="help-block">请添加课程资源文件</p>
							</div>

							<div class="box-footer">
								<button type="submit" class="btn btn-primary" id="submit">上传</button>
							</div>

						</form>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>

				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab"></div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.0 -->
	<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="dist/js/demo.js"></script>
	<script type="text/javascript">
	$(function(){
		document.getElementById("submit").disabled = true;
	});
	
	/*判断上传文件是否为Excel文件
	*/
	function LimitAttach() {
		var file=document.getElementById("upload").value;
		//var form1=document.getElementById("form1");
		var ext = file.slice(file.lastIndexOf(".")+1).toLowerCase();
		if ("doc" != ext && "docx" !=ext && "txt" !=ext && "ppt" !=ext && "pptx" !=ext) {
			alert("只能上传word,txt或ppt文件");
			document.getElementById("submit").disabled = true;
		}
		else{
			document.getElementById("submit").disabled = false;
		}
	}
	</script>
</body>
</html>

