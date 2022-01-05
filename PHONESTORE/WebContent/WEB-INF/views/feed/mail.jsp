<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<base href="${pageContext.servletContext.contextPath}/">
	
	<style>
		.mt-8 {
			margin-top: 80px;
		}
	</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	
	
	<div class="container mt-8">
		
		<form:form class="row g-3" action="feed/mail.htm" modelAttribute="mailObject" method="POST">
		  
		  <c:if test=" ${not empty masseage}">
			<div class="row mb-3" style="border: 1px ">${error}</div>
		  </c:if>
					
		  <div class="col-md-6">
		    <label for="senderName" class="form-label">Your Name</label>
		    <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
		    <form:input path="senderName" id="senderName" type="text" class="form-control" />
		  </div>
		 
		  <div class="col-md-6">
		    <label for="recipientMail" class="form-label">Receiver's Email</label>
		    <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
		    <form:input path="recipientMail" id="recipientMail" type="email" class="form-control" />
		  </div>
		  
		  <div class="col-12">
		    <label for="subject" class="form-label">Subject</label>
		    <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
		    <form:input path="subject" id="subject" type="text" class="form-control" placeholder="About ..." />
		  </div>
		  
		  <div class="col-12">
		    <label for="messageBody" class="form-label">Message</label>
		    <span style="border:none;color:red;padding:10px 0 0 5px"><i>${nullMsg}</i></span>
		    <div class="col-sm-10">
				<form:textarea path="messageBody" id="messageBody" cssClass="form-control" placeholder="Enter message"></form:textarea>
			</div>
		  </div>	  		  
		  
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">Sign in</button>
		  </div>
		
		</form:form>
	
	</div>
	
</body>
</html>