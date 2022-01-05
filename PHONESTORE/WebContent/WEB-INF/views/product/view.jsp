<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product Info</title>
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
			margin-top: 80px;
		}
		.mb-2 {
			margin-bottom: 20px;
		}
		.ml-2 {
			margin-left: 20px;
		}
		.w-20 {
			width: 200px;
		}
		.cr {
			color: red;
		}
	</style>	
	
</head>
<body>	
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="container mt-8">
		<div class="flex-col">
								
			<h4 class="mb-3" >Product Details</h4>			
						
			<form>				 				 
					
				<div class="mb-3 w-80">
				  <label for="name" class="form-label"><b>Name</b></label>
				  <input name="name" type="text" class="form-control" id="name" value="${product.name}" disabled />
				</div>
				
				<div class="mb-3 w-80">
				  <label for="description" class="form-label"><b>Description</b></label>
				  <textarea name="description" class="form-control" id="description" rows="3" disabled >${product.description}</textarea>
				</div>
				
				<div class="mb-3 w-80">
				  <label for="price" class="form-label"><b>Price</b></label>
				  <input name="price" type="text" class="form-control" id="price" value="${product.price}" disabled />
				</div>								
				
				<div class="mb-3 w-80">    
					<label for="inventoryNum" class="form-label"><b>Remaining Amount</b></label>           
	               	<input name="inventoryNum" type="text" class="form-control" id="inventoryNum" value="${product.inventoryNum}" disabled />
				</div>
				
				<div class="mb-3 w-80">    
					<label for="brandName" class="form-label"><b>Brand</b></label>           
	               	<input name="brandName" type="text" class="form-control" id="brandName" value="${product.brand.name}" disabled />
				</div>
				
				<div class="mb-3 w-80">
				  <label for="file" class="form-label"><b>Image</b></label>
				  <img id="imgshow" src="<c:url value='/images/phone/${product.image}' />" width="300px" height="300px" class="mb-2 ml-2"/>				  				 
				</div>	
				
			</form>
		</div>
	</div>	
		
	
</body>
</html>