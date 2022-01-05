<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.servletContext.contextPath}/">
	
	<link rel="stylesheet" href="<c:url value='/resources/assets/dist/css/bootstrap.rtl.min.css' />">
	<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/album-rtl/">
    <%-- <link rel="stylesheet" href="<c:url value='/resources/assets/dist/fontawesome/all.css' />"> --%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
	<script src="<c:url value='/resources/assets/dist/js/jquery.min.js' />"></script> 
	<script src="<c:url value='/resources/assets/dist/js/jquery-1.7.2.min.js' />"></script>   
	
	<!-- Favicons -->
	<link rel="apple-touch-icon" href="<c:url value='/resources/assets/img/favicons/apple-touch-icon.png' />" sizes="180x180">
	<link rel="icon" href="<c:url value='/resources/assets/img/favicons/favicon-32x32.png' />" sizes="32x32" type="image/png">
	<link rel="icon" href="<c:url value='/resources/assets/img/favicons/favicon-16x16.png' />" sizes="16x16" type="image/png">
	<link rel="manifest" href="<c:url value='/resources/assets/img/favicons/manifest.json' />">
	<link rel="mask-icon" href="<c:url value='/resources/assets/img/favicons/safari-pinned-tab.svg' />" color="#7952b3">
	<link rel="icon" href="<c:url value='/resources/assets/img/favicons/favicon.ico' />">
	<meta name="theme-color" content="#7952b3">
	
	<style>
		.my-cart {
			margin-right: 20px;
			font-size: 20px;
			color:#fff;
		}		
		.my-cart:hover {
			color: #6d98fa;	      
		}
	</style>
	
</head>
<body>

	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
	  <div class="container-fluid">	    
	    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      	<c:if test="${userType eq 'customer' or userType eq 'staff'}">	        
		        <li class="nav-item">	        	
		          	<a class="nav-link" href="cart/index.htm">
		          		<i class="fas fa-cart-plus my-cart"></i>
	          		</a>
		        </li>
	        </c:if>
        	<li class="nav-item">
            	<a class="nav-link" href="/PHONESTORE">Home</a>
        	</li>        	      
	        <c:if test="${userType eq 'staff'}">
	        	<li class="nav-item">
		          <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">Product</a>
					<ul class="dropdown-menu" aria-labelledby="dropdown01">
						<!-- <li><a class="dropdown-item" href="/PHONESTORE">Home</a></li> -->
						<li><a class="dropdown-item" href="product/add.htm">Create new product</a></li>
			        </ul>
		        </li>
	        	<li class="nav-item">
		          	<a class="nav-link" href="staff/index.htm">Staff</a>
		        </li>
		        <li class="nav-item">
		          	<a class="nav-link" href="bill/index.htm">Bill</a>
		        </li>
		        <li class="nav-item">
            		<a class="nav-link" href="feed/mail.htm">Mail</a>
	        	</li>
	        </c:if>	        	        
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-bs-toggle="dropdown" aria-expanded="false">Settings</a>
	          <ul class="dropdown-menu" aria-labelledby="dropdown02">	            
	            <c:if test="${userType ne 'customer' and userType ne 'staff'}">
		        	<li><a class="dropdown-item" href="signin/index.htm">Sign In</a></li>
		        	<li><a class="dropdown-item" href="signin/signup.htm">Create Account</a></li>
		        </c:if>
	            <c:if test="${userType eq 'customer' or userType eq 'staff'}">
		        	<li><a class="dropdown-item" href="signin/edit/${account.id}.htm">Update Account</a></li>
		        	<li><a class="dropdown-item" href="signin/delete/${account.id}.htm">Delete Account</a></li>
		        	<li><a class="dropdown-item" href="signin/signout/${account.id}.htm">Sign Out</a></li>
		        </c:if>	  
		        <%-- <c:if test="${userType eq 'staff'}">
		        	<li><a class="dropdown-item" href="signin/edit/${account.id}.htm">Update Account</a></li>
		        	<li><a class="dropdown-item" href="signin/delete/${account.id}.htm">Delete Account</a></li>
		        	<li><a class="dropdown-item" href="signin/signout/${account.id}.htm">Sign Out</a></li>
		        </c:if> --%>	            
	          </ul>
	        </li>
	      </ul>	      
	    </div>
	  </div>
	</nav>
	
	<script src="<c:url value='/resources/assets/dist/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>