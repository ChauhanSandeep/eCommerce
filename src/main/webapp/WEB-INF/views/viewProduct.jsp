<%@include file="/WEB-INF/views/template/header.jsp" %>


  <div class="container-wrapper">
  <div class="container">
  <br/><br/><br/>	
  	<div class="page-header">
  		<h1>Product Details</h1>
  		<p class="lead">Here is the detailed information of the product</p>
  	</div>
  	
  	
  	<div class="container" ng-app="cartApp">
  		<div class="row">
  			<div class="col-md-5">
  				<!-- <img alt="image" src="#" style="width:100% height:300px"> -->
  				<img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image" style="width:100% height:300px"/>
  			</div>
  			
  			<div class="col-md-5">
  				<h3><strong>Product Name : </strong>${product.productName }</h3>
  				<p><Strong>Description : </Strong>${product.productDescription }</p>
  				<p><strong>Manufacturer : </strong>${product.productManufacturer}</p>
  				<p><strong>Category : </strong>${product.productCategory}</p>
  				<p><strong>Condition : </strong>${product.productCondition}</p>
  				<p><strong>Price : </strong>${product.productPrice}</p>
  				<br/>
  				
  				<c:set var="role" scope="page" value="${param.role}" />
  				<c:set var="url" scope="page" value="/product/productList" />
  				
  				<c:if test="${role=='admin'}">
  					<c:set var="url" scope="page" value="/admin/productInventory" />
  				</c:if> 
  				
  				<p ng-controller="cartCtrl">
  					<a href='<c:url value="${url}" />' class="btn btn-default">Back</a>
  					<a href="#" class="btn btn-warning btn-large"
                           ng-click="addToCart('${product.productId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span>Order
                            Now</a>
  				</p>
  			</div>
  		</div>
  	
  	</div>
  	
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>