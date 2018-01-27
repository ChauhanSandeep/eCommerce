<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<br /> <br /> <br />
		<div class="page-header">
			<h1>Add Product</h1>
			<p class="lead">Fill the below information to add the product</p>
		</div>

		<form:form
			action="${pageContext.request.contextPath }/admin/productInventory/addProduct"
			method="post" commandName="product" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Name:</label><form:errors path="productName" cssStyle="color:#ff0000;"></form:errors>
				<form:input path="productName" id="name" class="form-control" />
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
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="price">Price</label><form:errors path="productPrice" cssStyle="color:#ff0000;"></form:errors>
				<form:input path="productPrice" id="price" class="form-control" />
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
				<label for="unitInStock">Unit In Stock</label><form:errors path="productPrice" cssStyle="color:#ff0000;"></form:errors>
				<form:input path="unitInStock" id="unitInStock" class="form-control" />
			</div>

			<div class="form-group">
				<label for="Manufacturer">Manufacturer</label>
				<form:input path="productManufacturer" id="manufacturer"
					class="form-control" />
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