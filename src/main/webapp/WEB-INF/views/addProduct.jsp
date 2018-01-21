<%@include file="/WEB-INF/views/template/header.jsp" %>


  <div class="container-wrapper">
  <div class="container">
  <br/><br/><br/>	
  	<div class="page-header">
  		<h1>Add Product</h1>
  		<p class="lead">Fill the below information to add the product</p>
  	</div>
  	
  	<form:form action="#" method="post" commandName="product">
  	<div class="form-group">
  		<label for="name">Name:</label>
  		<form:input path="productName" id="name" class="form-control"/>
  	</div>
  	
  	</form:form>
  	
  	

<%@include file="/WEB-INF/views/template/footer.jsp" %>