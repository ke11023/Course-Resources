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
			<a href="../../index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
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
						<c:if test="${message_count!=0}">
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">${message_count}</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have ${message_count} notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<c:forEach var="mess" items="${message}">
										<li><a href="examineStudent"> <i class="fa fa-users text-aqua"></i>
												${mess.sid}注册了一个新账号
										</a></li>
										</c:forEach>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
					</c:if>
					<c:if test="${message_count==0}">
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i></a></li>
					</c:if>

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">${admin}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">
									<p>${admin}</p></li>

								<!-- Menu Footer-->
								<li class="user-footer">
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
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>批量导入</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="teacherinput"> <i class="fa fa-circle-o"></i>
									导入教师信息
							</a></li>
							<li><a href="studentinput"> <i class="fa fa-circle-o"></i>
									导入学生信息
							</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
							<span>课程管理</span> <span class="fa fa-angle-left pull-right"></span>
					</a>
						<ul class="treeview-menu">
							<li><a href="courseAction"><i class="fa fa-circle-o"></i>
									添加课程</a></li>
							<li><a href="course_info"><i class="fa fa-circle-o"></i>
									课程修改</a></li>
						</ul></li>
					<c:if test="${message_count!=0}">
						<li><a href="examineStudent"> <i class="fa fa-th"></i> <span>注册审批</span>
							<small class="label label-primary pull-right">${message_count}</small>
						</a></li>
					</c:if>
					<c:if test="${message_count==0}">
						<li><a href="examineStudent"> <i class="fa fa-th"></i> <span>注册审批</span>
							<small class="label label-primary pull-right"></small>
						</a></li>
					</c:if>
					<li class="treeview"><a href="#"> <i
							class="fa fa-pie-chart"></i> <span>信息管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="manager_info"><i class="fa fa-circle-o"></i>
									管理员信息管理</a></li>
							<li><a href="teacher_info"><i class="fa fa-circle-o"></i>
									教师信息管理</a></li>
							<li><a href="student_info"><i class="fa fa-circle-o"></i>
									学生信息管理</a></li>
						</ul></li>
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
					学生批量导入 <small>Input Student</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="home"><i class="fa fa-dashboard"></i>
							Home</a></li>
					<li class="active">studentInput</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<form role="form" action="studentInput" enctype ="multipart/form-data" method="post">
					<div class="form-group">
						<label for="exampleInputFile">File input</label> <input
							type="file" id="upload" name="upload" onchange="LimitAttach()">

						<p class="help-block">请上传学生信息表格</p>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary" id="submit">上传</button>
					</div>
				</form>
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
		if ("xls" != ext && "xlsx" !=ext) {
			alert("只能上传Excel文件");
			document.getElementById("submit").disabled = true;
		}
		else{
			document.getElementById("submit").disabled = false;
		}
	}
	</script>
</body>
</html>

