<!--  <%@include file="/WEB-INF/views/template/header.jsp"%>
<script type="text/javascript">
alert("test");
</script>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					<p>All the products selected in your Shopping Cart.</p>
				</div>
			</div>
		</section>

		<section class="container">
			<div>
				<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign">Clear Cart</span></a>
			</div>
			
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr>
					<td>productName</td>
					<td>productPrice</td>
					<td>quantity</td>
					<td>totalPrice</td>
					<td>action</td>
					<td>remove button</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>grandTotal</th>
					<th></th>
				</tr>
			</table>
			
			<a href='<spring:url value="/productList"></spring:url>'>Continue Shopping</a>
		</section>
	</div>

</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>-->