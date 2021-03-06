<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/main.css" />" />

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


<title>怡诚-用户登录</title>
</head>
<body>
	<div class="container center">
		<div class="row">
		</div>
		<div class="row col-xs-4"></div>
		<div class="row col-xs-5">
			<form id="loginForm" action="Login" method="post">
				<div class="input-group input-item">
					<h3>怡诚-用户登录</h3>
				</div>
				<div class="input-group input-item">
					<span class="input-group-addon">用户名</span> <input type="text"
						class="form-control" id="name" name="name" placeholder="用户名"
						aria-describedby="basic-addon2" />
				</div>
				<div class="input-group input-item">
					<span class="input-group-addon">密码</span> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="密码" aria-describedby="basic-addon2" />
				</div>
				<div class="input-group input-item">
					<label for="userType">选择身份:</label>
					<input type="radio" name="userType" value="0" checked="checked" /> 打样开发员
					<input type="radio" name="userType" value="1" /> 报价员
					<input type="radio" name="userType" value="2" /> 采购员
					<input type="radio" name="userType" value="3" /> 总经理
				</div>
				<div class="input-item">
					<div class="row">
						<a id="login" class="btn btn-lg login btn-success" href="#"> 登
						录 </a>
					</div>

				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">

	var $nameInput;
	var $passwordInput;
	var $loginBtn;
	var $loginForm;

	$(function() {
		$nameInput = $("#name");
		$passwordInput = $("#password");
		$loginLink = $("#login");
		$loginForm = $("#loginForm");
		
		$loginLink.click(function(e) {
			console.log("log");
			var name = $nameInput.val();
			var password = $passwordInput.val();
			console.log("name: " + name);
			console.log("password: " + password);
			if(checkParameters(name, password)) {
				name = name.trim();
				password = password.trim();
				$loginForm.submit();	
			}
		}); 

		$passwordInput.keyup(function(e){
			if(e.keyCode == 13) {
				$loginLink.trigger("click");
			}
		});


	});

	function checkParameters(name, password) {
		if(name == undefined || name.trim() == "") {
			alert("用户名不能为空");
			return false;
		}
		if(password == undefined || password == "") {
			alert("密码不能为空!");
			return false;
		}
		return true;
	}
</script>
</body>
</html>