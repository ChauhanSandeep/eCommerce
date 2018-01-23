<%@include file="/WEB-INF/views/template/header.jsp" %>


  <div class="container-wrapper">
  <div class="container">
  <br/><br/><br/>	
  	<div class="page-header">
  		<h1>Product Inventory Page</h1>
  		<p class="lead">This is the product inventory page</p>
  	</div>
  	
  	<table class="table table-striped">
  		<thead>
  			<tr class="bg-success">
  				<th>Photo Thumb</th>
  				<th>Product Name</th>
  				<th>Category</th>
  				<th>Condition</th>
  				<th>Price</th>
  				<th>More</th>
  			</tr>
  			<c:forEach items="${products }" var="product">
  			<tr>
  				<td><img alt="image" src="#"></td>
  				<td>${product.productName }</td>
  				<td>${product.productCategory }</td>
  				<td>${product.productCondition }</td>
  				<td>${product.productPrice }</td>
  				<td><a href="<spring:url value="/productList/viewProduct/${product.productId }"/>">
  				<span class="glyphicon glyphicon-info-sign"></span></a>
  				<a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId }"/>">
  				<span class="glyphicon glyphicon-remove"></span></a>
  				</td>
  			</tr>
  			</c:forEach>
  		</thead>
  	</table>
  	
  	<a href="<spring:url value="/admin/productInventory/addProduct" />" class="btn btn-primary">Add Product</a>

<%@include file="/WEB-INF/views/template/footer.jsp" %>