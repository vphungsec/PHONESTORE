<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Happy Mobile</title>
    <base href="${pageContext.servletContext.contextPath}/">
    
    <script src="<c:url value='/resources/assets/dist/js/jquery.min.js' />"></script>
		
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      /* .mt-5 {
      	margin-top: 5px;
      } */
      
      .card-text {
      	margin: 0;
      }
      
      .item-name {
      	text-decoration: none;
      	font-weight: 600;
      	color: #2d6cfc;
      }	      	  
      
      .item-price {
      	text-decoration: none;
      	font-weight: 600;
      	color: red;
      }    
      
      .fa-gem, .item-name:hover, .item-price:hover {
      	color: #1c439c ;
      }	      	      
      
      .my-cart {
     		margin-right: 20px;
     		font-size: 20px;
     		color:#fff;
      }
      
      .my-cart:hover {
      	color: #6d98fa;	      
      }
      
      button i {
      	color: #9d9f9f;
      }
      
      .fa-plus {
      	color: #9d9f9f;
      }
      
      .fa-check {
      	color: green;
      }
    </style>
	
	<script>
		$(function() {			
			$(".click-add").click(function(){
				if ($(this).find('i').hasClass('fa-plus')) {
					$(this).find('i').removeClass('fa-plus').addClass('fa-check');	
				}
				else {
					$(this).find('i').removeClass('fa-check').addClass('fa-plus');	
				}
			});
		});		
	</script>
	    
</head>
<body>			
	<%@include file="/WEB-INF/views/include/header.jsp"%>      	
			
	<main>
	
	  <section class="py-3 text-center container">
	    <div class="row py-lg-5">
	      <div class="col-lg-10 col-md-8 mx-auto" style="margin:0">
	        <h1 class="fw-light">Happy Mobile</h1>
	        <p class="lead text-muted">
	        	Happy Mobile là doanh nghiệp bán lẻ tại Việt Nam với lĩnh vực kinh doanh chính là bán lẻ điện thoại di động, thiết bị số và điện tử tiêu dùng.
	        	Chúng tôi chuyên cung cấp những sản phẩm chất lượng, giá tốt, chính hãng, đa dạng mẫu mã.
	        	<br>Hãy mua ngay tại Happy Mobile với những ưu đãi hấp dẫn, thanh toán dễ dàng.
	        </p>
	        <p>
	          <a href="#" class="btn btn-primary my-2">Thích ${account.phone}</a>
	          <a href="#" class="btn btn-secondary my-2">Không thích</a>
	        </p>
	      </div>
	    </div>
	  </section>
	
	  <div class="album py-5 bg-light">
	    <div class="container">	
	    	
	    	<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
			
			<c:url value="/" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">	        	       
			
			  <c:forEach var="pd" items="${pagedListHolder.pageList}">
				<div class="col">
		         <div class="card shadow-sm">		            
			          <img src="<c:url value='/images/phone/${pd.image}' />" class="bd-placeholder-img card-img-top" alt="..." width="100%" height="150px">
			       <div class="card-body">
			         <p class="card-text"><a class="item-name" href="product/view/${pd.id}.htm?linkView">${pd.name }</a></p>
			         <p class="card-text">
			         	<a class="item-price"><i class="fas fa-gem"></i>
			         		<fmt:formatNumber type="currency" currencySymbol="VND " value="${pd.price}" />
			         	</a>			         
			         </p>
			         <div class="d-flex justify-content-between align-items-center">
			           <div class="btn-group mt-2">
			             <c:if test="${userType eq 'staff'}">
			             	<a href="product/edit/${pd.id}.htm?linkEdit">
			             		<button type="button" class="btn btn-sm btn-outline-secondary" style="margin-left:5px">
			             			<i class="far fa-edit"></i>
		             			</button>			             		
							</a>
			             	<a href="product/delete/${pd.id}.htm?linkDelete" style="margin-left:5px">
			             		<button type="button" class="btn btn-sm btn-outline-secondary">
			             			<i class="fas fa-trash-alt"></i>
		             			</button>			             		
							</a>							
			             </c:if>
			           </div>
			           <c:if test="${userType eq 'customer' or userType eq 'staff'}">
			           		<a href="cart/addcart/${pd.id}.htm?linkAddCart">
			           			<c:choose>
			           				<c:when test="${not empty cardList}">
			           					<c:set var="inCart" value="0" scope="page" />
			           					<c:forEach var="c" items="${cardList}">
											<c:if test="${pd.id == c.product.id}">
								     		   	<button type="button" class="btn btn-sm btn-outline-secondary click-add">
						   		   			 		<i class="fas fa-check"></i>
							    		   		</button>
							    		   		<c:set var="inCart" value="1" scope="page" />             		
											</c:if>									
										</c:forEach>
										<c:if test="${inCart eq 0}">
											<button type="button" class="btn btn-sm btn-outline-secondary click-add">
					   		   			 		<i class="fas fa-plus"></i>
						    		   		</button>
										</c:if>
			           				</c:when>
			           				<c:otherwise>
			           					<button type="button" class="btn btn-sm btn-outline-secondary click-add">
				   		   			 		<i class="fas fa-plus"></i>
					    		   		</button>
			           				</c:otherwise>
			           			</c:choose>									    							 	      		
						 	</a>													
			           </c:if>			           
			         </div>
			       </div>
			     </div>
				</div>
			  </c:forEach>
			  	               
			</div>
			
			<div class="py-5">
				<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}" />
			</div>
			
	    </div>
	  </div>
	
	</main>
	
	<footer class="text-muted py-5">
	  <div class="container">	    
	    <p class="mb-1">Phone: <a href="#" style="text-decoration: none"> 0972638459 </a></p>
	    <p class="mb-0">Address: <a href="#" style="text-decoration: none"> 112 Trần Văn Cao, Hoàng Mai, Hà Nội </a></p>
	  </div>
	</footer>
		      	  
	
</body>
	
</html>