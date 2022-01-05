<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.80.0">
	<title>Sign In</title>
	<base href="${pageContext.servletContext.contextPath}/">	
	
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />">
	
	<!-- Custom styles for this template -->	
	<link rel="stylesheet" href="<c:url value='/resources/assets/dist/signin.css' />">
	
	<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		
		.goToHome:hover {
			color:  #2d6cfc;
			transition: 0.5s;
			font-weight: 600;
		}
	</style>	
	
</head>

<body class="text-center">

	<main class="form-signin">
		<form action="signin/index.htm" method="post">
			<!-- <img class="mb-4" src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
			<img class="mb-4" src="<c:url value='/resources/assets/brand/bootstrap-logo.svg' />" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Sign in</h1>
			
			<label for="inputPhone" class="visually-hidden">Phone</label>
			<input name="phone" type="text" id="inputPhone" class="form-control" placeholder="Enter your Phone" required autofocus>
			<label for="inputPassword" class="visually-hidden">Password</label>
			<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Enter your Password" required style="margin-top:5px">
			<label for="errorLogin" class="errorMessage">${message}</label>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">Remember me</label>
			</div>
			
			<button	class="w-100 btn btn-lg btn-primary btnSignin" type="submit">Sign In</button>
			
			<a href="/PHONESTORE" class="w-100 btn btn-lg goToHome" style="text-decoration:none;margin-top:20px">Go to Home</a>
			<!-- <button class="w-100 btn btn-lg btn-primary btnSignup" type="submit">Sign Up</button> -->
			<!-- <p class="mt-5 mb-3 text-muted">&copy; 2017 - 2021</p> -->
		</form>
	</main>

</body>
</html>
