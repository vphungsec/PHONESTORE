<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Update Product</title>
	<base href="${pageContext.servletContext.contextPath}/">
	
	<script src="<c:url value='/resources/assets/dist/js/jquery.min.js' />"></script>
	
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

	<script>
		$('document').ready(function () {
		    $("#file").change(function () {
		        if (this.files && this.files[0]) {
		            var reader = new FileReader();
		            reader.fileName = file.name;
		            reader.onload = function (e) {
		                $('#imgshow').attr('src', e.target.result);
		                $('#image').val(e.target.fileName);
		            }
		            reader.readAsDataURL(this.files[0]);
		        }
		    });
		});	
		
		function checkMaxLength (obj) {
	    	if (obj.value > obj.max)
	    		obj.value = obj.value.slice(0, obj.max.length - 1);	   
		};
		
		function isNumeric (evt) {
			var theEvent = evt || window.event;
			var key = theEvent.keyCode || theEvent.which;
			key = String.fromCharCode (key);
			/* var regex = /[0-9]|\./; */
			var regex = /[0-9]/;
			if ( !regex.test(key) ) {
				theEvent.returnValue = false;
				if(theEvent.preventDefault) theEvent.preventDefault();
			}
	  	};
	</script>
	
</head>
<body>	
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="container mt-8">
		<div class="flex-col">
								
			<h4 class="mb-3" >Create new product</h4>			
						
			<form:form action="product/add.htm" method="post" modelAttribute="product" enctype="multipart/form-data" class="flex-col">								 
				 
				<label for="error" class="form-label error cr"><b>${error}</b></label>				 				 
					
				<div class="mb-3 w-80">
				  <label for="name" class="form-label"><b>Name</b></label>
				  <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
				  <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter product name"/>
				</div>
				
				<div class="mb-3 w-80">
				  <label for="description" class="form-label"><b>Description</b></label>
				  <form:textarea path="description" class="form-control" id="description" rows="3"/>
				</div>
				
				<div class="mb-3 w-80">
				  <label for="price" class="form-label"><b>Price</b></label>
				  <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
				  <form:input path="price" class="form-control" id="price" onkeypress="return isNumeric(event)" oninput="checkMaxLength(this)" type="number" min="0" max="500000000" placeholder="Enter product price"/>
				</div>
				
				<div class="mb-3 w-80">
				  <label for="inventoryNum" class="form-label"><b>Number of new items</b></label>
				  <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
				  <form:input path="inventoryNum" class="form-control" id="inventoryNum" onkeypress="return isNumeric(event)" oninput="checkMaxLength(this)" type="number" min="1" max="5000" value="1" placeholder="Enter number of new items"/>
				</div>
				
				<div class="mb-3 w-80">    
					<label for="brand" class="form-label"><b>Brand</b></label>           
					<span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                <form:select path="brand.id" items="${brands}" itemValue="id" itemLabel="name" class="form-select" aria-label="Select Brand">
					</form:select>					
				</div>
				
				<div class="mb-3 w-80">
				  <label for="file" class="form-label"><b>Image</b></label>
				  <img id="imgshow" width="200px" height="200px" class="mb-2 ml-2"/>
				  <label class="cr">${uploadError}</label>
				  <form:input path="image" type="hidden" class="form-control" placeholder="Product Image" />
				  <input name="file" id="file" type="file" class="form-control" value="Choose product image"/>				  
				</div>		
				
				<div class="mb-3 w-80 flex-col">
                	<button name="btnSubmit" class="btn btn-primary w-20" type="submit">Save</button>
	            </div>				
			
			</form:form>
		</div>
	</div>	
	
	
</body>
</html>