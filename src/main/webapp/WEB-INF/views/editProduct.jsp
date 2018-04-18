<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<br /> <br /> <br />
		<div class="page-header">
			<h1>Edit Product</h1>
			<p class="lead">Please udpate the product information</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath }/admin/product/editProduct"
			method="post" commandName="product" enctype="multipart/form-data">
			
			<form:hidden path="productId" value="${product.productId }"/>
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input path="productName" id="name" class="form-control" value="${product.productName }"/>
			</div>

			<%-- <div class="form-group">
				<label for="category">Category</label> 
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" vaue="instrument" />Instrument</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" vaue="record"  />Record</label> 
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" vaue="accessory" />Accessory</label>
			</div> --%>

			<div class="form-group">
				<label for="category">Category</label><br />
				<form:radiobutton path="productCategory" value="instrument"
					label="Instrument" />
				<form:radiobutton path="productCategory" value="record"
					label="Record" />
				<form:radiobutton path="productCategory" value="accessory"
					label="Accessory" />
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="productDescription" id="description"
					class="form-control" value="${product.productDescription }"/>
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<form:input path="productPrice" id="price" class="form-control" value="${product.productPrice }"/>
			</div>

			<%-- <div class="form-group">
				<label for="condition">Condition</label>
				
				<label class="checkbox-inline"><form:radiobutton
						path="productCondition" id="condition" vaue="new" />New</label>
				<label class="checkbox-inline"><form:radiobutton
						path="productCondition" id="condition" vaue="used" />Used</label>
			</div> --%>

			<div class="form-group">
				<label for="condition">Condition</label><br />
				<form:radiobutton path="productCondition" value="new" label="New" />
				<form:radiobutton path="productCondition" value="used" label="Used" />
			</div>

			<%-- <div class="form-group">
				<label for="status">Status</label>
				<label class="checkbox-inline"><form:radiobutton
						path="productStatus" id="status" vaue="active" />Active</label>
				<label class="checkbox-inline"><form:radiobutton
						path="productStatus" id="status" vaue="inactive" />Inactive</label>
			</div> --%>
			<div class="form-group">
				<label for="status">Status</label><br />
				<form:radiobutton path="productStatus" value="active" label="Active" />
				<form:radiobutton path="productStatus" value="inactive"
					label="Inactive" />
			</div>

			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<form:input path="unitInStock" id="unitInStock" class="form-control" value="${product.unitInStock }"/>
			</div>

			<div class="form-group">
				<label for="Manufacturer">Manufacturer</label>
				<form:input path="productManufacturer" id="manufacturer"
					class="form-control" value="${product.productManufacturer }"/>
			</div>
			
			<div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>
        
			<br />
			<br />
			<input type="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory" />"
				class="btn btn-default">Cancel</a>

		</form:form>



		<%@include file="/WEB-INF/views/template/footer.jsp"%>