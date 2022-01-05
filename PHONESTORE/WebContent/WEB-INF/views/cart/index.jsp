<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Cart</title>
	<base href="${pageContext.servletContext.contextPath}/">		
	
	<style>		
		.flex-col {	
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
		.flex-row {
			display: flex;
			flex-direction: row;
			align-items: center;
			justify-content: center;
		}		
		.account {
			float: left;
			margin-bottom: 20px;
		}
		.account-lb {
			margin: 10px 5px 10px 0px;
		}		
		input {
			width: 140px;
		}	
		.null-data {
			text-align: center;
			color: blue;
			font-weight: 600;
		}
		.fa-trash-alt {
			color: #9fa2a2;
		}
		.fa-trash-alt:hover {
			color: blue;
			font-size: 20px;
		}
		.mt-5 {
			margin-top: 50px;
		}
		.mt-3 {
			margin-top: 30px;
		}
	</style>
	
	<script>
		function updateFinalPrice (obj) {
	    	if (obj.value > obj.max)
	    		obj.value = obj.value.slice(0, obj.max.length - 1);
	    	$('#fnprice').html(dotSeparateNumber(obj.value));
	    	
	    	$(this).find('input').focus().blur(function (e) {
		          var row = $(this).closest('tr'); // Remember row
		          $(this).parent('td').text(obj.value);
		          row.find('#fnprice').text(obj.value); // Calculate and put in the amount cell
		     });
		};
		    
	  	function isNumeric (evt) {
			var theEvent = evt || window.event;
			var key = theEvent.keyCode || theEvent.which;
			key = String.fromCharCode (key);
			var regex = /[0-9]|\./;
			if ( !regex.test(key) ) {
				theEvent.returnValue = false;
				if(theEvent.preventDefault) theEvent.preventDefault();
			}
	  	};
	  	
	  	function dotSeparateNumber(obj){
	  	    while (/(\d+)(\d{3})/.test(obj.toString())){
	  	      obj = obj.toString().replace(/(\d+)(\d{3})/, '$1'+'.'+'$2');
	  	    }
	  	    return obj;
		};
				
	</script>		
	
</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container py-5 mt-5">
				
		
		<%-- <h1>Cart</h1>
		<p>${userType}</p>
		<p>${account.id}</p>
		<p>${account.phone}</p>
		<p>${cartid}</p> --%>
		
		<div class="flex-col">
			<h3><b>Products in your cart</b></h3>
		</div>
		
		<div class="account flex-col">
			<label><b>Account Info:</b></label>		
			
			<c:if test="${not empty userType and userType eq 'customer'}">
				<div class="flex-row">
					<label class="account-lb"><b>Full Name: </b></label>
					<label> ${customer.fName} ${customer.lName}</label>
				</div>
				<div class="flex-row">
					<label class="account-lb"><b>Phone: </b></label>
					<label> ${customer.phone}</label>
				</div>
			</c:if>
			
			<c:if test="${not empty userType and userType eq 'staff'}">
				<div class="flex-row">
					<label class="account-lb"><b>Full Name: </b></label>
					<label> ${staff.fName} ${staff.lName}</label>
				</div>
				<div class="flex-row">
					<label class="account-lb"><b>Phone: </b></label>
					<label> ${staff.phone}</label>
				</div>
			</c:if>
		</div>				
		
		<table class="table table-hover">
		  <thead>
			<tr class="table-primary">
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Price</th>
		      <th scope="col">Sale</th>
		      <th scope="col">Amount (MAX 100)</th>
		      <th scope="col">Final Price</th>
		      <th scope="col">Del</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:choose>
		    	<c:when test="${not empty cardList}">
		    		<c:set var="count" value="0" scope="page" />
			    	<c:forEach var="c" items="${cardList}">
			    		<c:set var="count" value="${count + 1}" scope="page" />
			    		<tr class="table-info">
							<th scope="row">${count}</th>
							<td>${c.product.name}</td>
							
							<c:set var="price" value="${c.product.price}" scope="page" />
							<td class="price">${c.product.price}</td>
							
							<c:set var="sale" value="0" scope="page" />
							<c:forEach var="s" items="${sales}">
								<c:if test="${c.product.id == s.product.id}">
									<td>${s.downPercent}%</td>
									<c:set var="sale" value="${s.downPercent}" scope="page" />
								</c:if>
							</c:forEach>
							<c:if test="${sale eq 0}">
								<td></td>
							</c:if>
							
							<td><input id="amount" onkeypress="return isNumeric(event)" oninput="updateFinalPrice(this)" type="number" min="1" max="100" value="1"/></td>
							<c:set var="amount" value="${document.getElementById('amount').value}" scope="page" />		
							
							<c:set var="fnprice" value="${price - (price*sale)/100}" scope="page" />										
							<td id="fnprice">
								<fmt:formatNumber type="currency" currencySymbol="VND " value="${fnprice}" />							
							</td>
							<td>
								<a href="cart/deletecart/${c.id}.htm?linkDeleteCart">
									<i class="fas fa-trash-alt"></i>
								</a>								
							</td>
					    </tr>
			    	</c:forEach>
			    </c:when>
			    <c:otherwise>
			    	<tr class="table-warning">
						<td colspan="7" class="null-data">&nbsp;You have chosen no product</td>
					</tr>
			    </c:otherwise>
		    </c:choose>		    
		  </tbody>
		</table>
		
	</div>
		
</body>
</html>