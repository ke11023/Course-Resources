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
<script type="text/javascript">
	function checkLogin() {

		var xmlHttp;

		var name = document.getElementById("name").value;
		if ((!isNaN(name))&&name!=null) {
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			} else {
				xmlHttp = new ActiveXObject("MicroSoft.XMLHTTP");//老版本的ie
			}
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					//var ss = xmlHttp.responseText;

					var dataObj = eval("(" + xmlHttp.responseText + ")");

					if (dataObj.exist == "false") {

						document.getElementById("tip").innerHTML = "<img src='images/ok.png'/>";
					} else {

						document.getElementById("tip").innerHTML = "<img src='images/no.png'/>";
					}
				}
			};
			xmlHttp
					.open("post", "Json_checkRegister.action?name=" + name,
							true);
			xmlHttp.send();
		}else document.getElementById("tip").innerHTML = "<img src='images/no.png'/>";
	}
</script>
</head>

<body>

	<p>
		<input type="text" id="name" name="name" onblur="checkLogin();"
			class="loginInput" autofocus="autofocus" required="required"
			autocomplete="off" placeholder="请输入电子邮箱" value="" /><font id="tip"></font>
	</p>
	<input type="password" id="pwd" name="pwd">
</body>
</html>
