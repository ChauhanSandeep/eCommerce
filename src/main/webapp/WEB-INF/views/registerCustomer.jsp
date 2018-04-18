<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<br /> <br /> <br />
		<div class="page-header">
			<h1>Register Customer</h1>
			<p class="lead">Please fill in your information</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath }/register"
			method="post" commandName="customer" >
			
			<h3>Basic information</h3>
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input path="customerName" id="customerName" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="email">Email:</label>
				<form:input path="customerEmail" id="email" class="form-control" />
			</div>

			<div class="form-group">
				<label for="phone">Phone#:</label>
				<form:input path="customerPhone" id="phone" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="username">Username:</label>
				<form:input path="username" id="username" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="password">Password:</label>
				<form:password path="password" id="password" class="form-control" />
			</div>
			
			<h3>Billing Address</h3>
			<div class="form-group">
				<label for="billingStreet">Billing Street:</label>
				<form:input path="billingAddress.streetName" id="billingStreet" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="billingApartmentNumber">Billing Appartment Number:</label>
				<form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="billingCity">Billing City:</label>
				<form:input path="billingAddress.city" id="billingCity" class="form-control" />
			</div>
			
<%-- 			<div class="form-group">
				<label for="billingState">Billing State:</label>
				<form:input path="billingAddress.state" id="billingState" class="form-control" />
			</div> --%>
			
			<div class="form-group">
				<label for="country">Country:</label>
				<form:input path="billingAddress.country" id="billingCountry" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="billingZip">Zip Code:</label>
				<form:input path="billingAddress.zipCode" id="billingZip" class="form-control" />
			</div>
			
			<h3>Shipping Address</h3>
			<div class="form-group">
				<label for="shippingStreet">Shipping Street:</label>
				<form:input path="shippingAddress.streetName" id="shippingStreet" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingApartmentNumber">Shipping Appartment Number:</label>
				<form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingCity">Shipping City:</label>
				<form:input path="shippingAddress.city" id="shippingCity" class="form-control" />
			</div>
			
<%-- 			<div class="form-group">
				<label for="shippingState">Shipping State:</label>
				<form:input path="shippingAddress.state" id="shippingState" class="form-control" />
			</div> --%>
			
			<div class="form-group">
				<label for="country">Country:</label>
				<form:input path="shippingAddress.country" id="shippingCountry" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingZip">Zip Code:</label>
				<form:input path="shippingAddress.zipCode" id="shippingZip" class="form-control" />
			</div>
			
        
			<br />
			<br />
			<input type="submit" class="btn btn-default">
			<a href="<c:url value="/" />"
				class="btn btn-default">Cancel</a>

		</form:form>



		<%@include file="/WEB-INF/views/template/footer.jsp"%>