<%@include file="/WEB-INF/views/template/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script type="text/javascript">
function getCartData(){
	 var data='<div class="mdl-spinner mdl-js-spinner is-active"></div>';
	   fetch('https://jsonplaceholder.typicode.com/posts')
	  .then(function(response) {
	  			return response.json()
	  		}
	  	)
	  .then(function(json) {
	  		console.log(json);
			data="<tr><th>Product</th><th>Unit Price</th><th>Quantity</th><th>Price</th><th>Action</th></tr>"
			//JSONdata=JSON.parse(json);
				JSONdata=json;
			for(i=0;i<JSONdata.length;i++){
					data=data+"<tr><td>"+JSONdata[i].userId+"</td><td>"+JSONdata[i].id+"</td>"+"<td>"+JSONdata[i].id+"</td><td><button onClick=deleteData("+JSONdata[i].id +")>delete</button</td></tr>";
				
			}
			data=data+"<tr><th></th><th></th><th>Grand Total</th><th>grandTotal</th><th></th></tr>"
			setTimeout(function(){
				document.getElementById("data").innerHTML=data;
			},1000)
	
		}
	  ).catch(function(error){
	  	data="<h1>errro</h1>";
	  })
	 document.getElementById("data").innerHTML=data;
}

function deleteData(id){
	console.log(id)
}
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
			<table id="data"></table>
		<a href='<spring:url value="/productList"></spring:url>'>Continue Shopping</a>
		</section>
	</div>

</div>		
<script>
	getCartData();
</script>				

<%@include file="/WEB-INF/views/template/footer.jsp"%>