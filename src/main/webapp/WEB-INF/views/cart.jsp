 <%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container" >
					<h1>Cart</h1>
					<p>All the products selected in your Shopping Cart.</p>
				</div>
			</div>
		</section>

		<section class="container" ng-app="cartApp" ng-controller="cartCtrl">
		
		<div  ng-init="initCartId('${cartId}')"></div>
			<div>
				<a class="btn btn-danger btn-lg pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign">  Clear Cart</span></a>
			</div>
			 <p ng-bind="name"></p>
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr ng-repeat = "item in cart.cartItems">
					<td>{{item.product.productName}}</td>
					<td>{{item.product.productPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrice}}</td>
					
					<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
					<span class="glyphicon glyphicon-remove">remove</a></td>
					
					<!-- <td>action</td>
					<td>remove button</td> -->
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{calGrandTotal()}}</th>
					<th></th>
				</tr>
			</table>
			
			<a type="button" class="btn btn-primary" href='<spring:url value="/product/productList"></spring:url>'>Continue Shopping</a>
			<br/><br/>
			
		</section>
	</div>

</div>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>