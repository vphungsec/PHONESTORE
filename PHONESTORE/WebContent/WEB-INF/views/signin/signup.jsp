<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>	
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Sign Up</title>
	<base href="${pageContext.servletContext.contextPath}/">
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">	
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	
	<script>
	$( function() {
	  $( "#datepicker" ).datepicker({
	    changeMonth: true,
	    changeYear: true,
	    dateFormat: "dd/mm/yy",
	    yearRange: "-81:-05"
	  });
	});
	</script>
  
  <style>
	
	.goToHome {
		color: #5685f0;
		text-decoration: none;
	}
	
	.goToHome:hover {
		color: #2d6cfc;
		transition: 0.3s;		
		font-weight: 600;
	}
	  
  </style>

</head>
<body>
	<div class="container-fluid vh-50" style="margin-top:20px">
		<div class="" style="margin-top:0px">
			<div class="rounded d-flex justify-content-center">
	            <div class="col-md-4 col-sm-12 shadow-lg p-4 bg-light">
					<div class="text-center">
	                    <h3 class="text-primary">Create Account</h3>
					</div>
	                <div class="p-4">
	                    <form:form action="signin/signup.htm" method="post" modelAttribute="customer">
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-textarea-t text-white"></i></span>
	                            <form:input path="fName" type="text" class="form-control" placeholder="First & Middle Name"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-textarea-t text-white"></i></span>
	                            <form:input path="lName" type="text" class="form-control" placeholder="Last Name"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-calendar3 text-white"></i></span>
	                            <form:input path="birthday" id="datepicker" type="text" class="form-control" placeholder="Birthday"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-gender-male text-white"></i></span>
	                            <form:select path="gen" items="${genders}" itemValue="id" itemLabel="gen" class="form-select" aria-label="Select Gen">
								</form:select>
								<span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>	                        
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-house text-white"></i></span>
	                            <form:input path="address" type="text" class="form-control" placeholder="Address"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-phone text-white"></i></span>
	                            <form:input path="phone" type="text" class="form-control" placeholder="Phone"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-key-fill text-white"></i></span>
	                            <form:input path="password" type="password" class="form-control" placeholder="Password"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3">
	                            <span class="input-group-text bg-primary"><i
	                                    class="bi bi-key-fill text-white"></i></span>
	                            <input name="re_password" type="password" class="form-control" placeholder="Re-Password"/>
	                            <span style="background-color:#f8f9fa;border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
	                        </div>
	                        <div class="input-group mb-3" style="display:flex;align-items:center;justify-content:center"> 	                            
	                            <span style="color:red"><i>${errMsg}</i></span>
	                        </div>	                        
	                        <div class="d-grid col-12 mx-auto">
	                            <button class="btn btn-primary" type="submit"><span></span>Sign Up</button>
	                        </div>
	                        <p class="text-center mt-3">Already have an account?
	                            <span class="text-primary">
	                            	<a href="signin/index.htm">Sign in</a>
	                            </span>
	                        </p>
	                        <p class="text-center mt-3">
	                            <span class="text-primary">
	                            	<a href="/PHONESTORE" class="goToHome">Go To Home</a>
	                            </span>
	                        </p>
	                    </form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>