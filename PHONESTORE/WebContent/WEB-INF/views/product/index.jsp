<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product</title>
	<base href="${pageContext.servletContext.contextPath}/">
	
	<style>		
		.flex-col {	
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}		
		.w-80 {
			width: 800px;
		}	
		.mt-8 {
			margin-top: 800px;
		}
		.w-20 {
			width: 200px;
		}
	</style>

</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="container mt-8">
		<p>${product.id}</p>
	</div>
	
</body>
</html>