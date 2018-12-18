
function putErrorMessage(msg) {
	$("#errorMessageContent").html(msg);
	$('#errorMessage').modal('show');
}


var jsonProduct = {};
var jsonProductCart = {};

function putData(data) {

	if(data==null) {
		putErrorMessage("No data received");
		return false;
	}
	var arr = data["data"];
	if(arr==null) {
		putErrorMessage("No data received");
		return false;
	}

	var len = arr.length;
	if(len<1) {
		putErrorMessage("No products received");
		return false;
	}


	jsonProduct = {};
	$("#productData").html("");

	for(var i=0; i<len; i++) {
		var jd = arr[i];
		var pId = jd["id"];
		jsonProduct[pId] = jd;
		
		addProductData(pId);
	}
}


function addProductData(pId) {
	var td;
	var tb = $("#productData");
	var jd = jsonProduct[pId];

	// Id
	var tr = $("<tr>").attr("id","productData_"+pId);
	var chk = $("<input>").attr("type","checkbox").attr("style","cursor:pointer")
	.attr("onclick", "checkItem(this,"+pId+")");
	td = $("<td>").append(chk);
	$(tr).append(td);


	// Product Id
	td = $("<td>").html(pId);
	$(tr).append(td);
	// Product Name
	td = $("<td>").html(jd["productName"]);
	$(tr).append(td);
	// Product Description
	td = $("<td>").html(jd["productDescription"]);
	$(tr).append(td);
	// Product Price
	td = $("<td>").html(jd["productPrice"]);
	$(tr).append(td);
	// Vendor Name
	td = $("<td>").html(jd["vendorId"]["vendorName"]);
	$(tr).append(td);
	// Location
	td = $("<td>").html(jd["branchId"]["location"]);
	$(tr).append(td);
	// Offer Detail
	td = $("<td>").html(jd["offerDetail"]);
	$(tr).append(td);
	// Content
	var select = $("<select>").attr("id","selectedProduct_"+pId+"_count");
	for(var s=1; s<=10; s++) {
		$(select).append($("<option>").attr("value", s).html(s));
	}
	$(select).val("1");
	td = $("<td>").append(select);
	$(tr).append(td);

	$(tb).append(tr);
}


function putProductInCart(pId) {

	var tb = $("#selectedData");

	var td;
	var tr = $("<tr>").attr("id","selectedProduct_"+pId);
	var jd = jsonProductCart[pId];

	// Id
	var chk = $("<input>").attr("type","button").val("Remove")
	.attr("style","font-size: 10px; padding: 2px 5px;").addClass("btn btn-danger")
	.attr("onclick", "removeItemFromCart("+pId+")");
	td = $("<td>").append(chk);
	$(tr).append(td);

	jsonProduct[pId] = jd;

	// Product Id
	td = $("<td>").html(pId);
	$(tr).append(td);
	// Product Name
	td = $("<td>").html(jd["productName"]);
	$(tr).append(td);
	// Product Description
	td = $("<td>").html(jd["productDescription"]);
	$(tr).append(td);
	// Product Price
	td = $("<td>").html(jd["productPrice"]);
	$(tr).append(td);
	// Vendor Name
	td = $("<td>").html(jd["vendorId"]["vendorName"]);
	$(tr).append(td);
	// Location
	td = $("<td>").html(jd["branchId"]["location"]);
	$(tr).append(td);
	// Offer Detail
	td = $("<td>").html(jd["offerDetail"]);
	$(tr).append(td);
	// Content
	td = $("<td>").html(byIdVal("selectedProduct_"+pId+"_count")).attr("id","productNumber_"+pId+"_count");
	$(tr).append(td);

	$(tb).append(tr);
}


function checkItem(elem, pId) {
	setTimeout(function() {
		if(elem.checked) {
			if(jsonProductCart[pId]==undefined || jsonProductCart[pId]==null) {
				var jd = jsonProduct[pId];
				// Cart Total
				var cartTotal = parseFloat($("#cartTotal").html());
				var price = jd["productPrice"];
				var count = byIdVal("selectedProduct_"+pId+"_count");
				var total = parseFloat((price * count) + cartTotal).toFixed(2);
				$("#cartTotal").html(total);
				// Add To Object
				jsonProductCart[pId] = jd;
				putProductInCart(pId);
				// Remove from product list
				byId("productData_"+pId).remove();
			}
			else {
				byId("productData_"+pId).remove();
			}
		}
		else {
			delete jsonProductCart[pId];
		}
	},100)
}


function removeItemFromCart(pId) {
	setTimeout(function() {
		var jd = jsonProductCart[pId];
		// Cart Total
		var cartTotal = parseFloat($("#cartTotal").html());
		var price = jd["productPrice"];
		var count = parseInt($("#productNumber_"+pId+"_count").html());
		var total = parseFloat(cartTotal - (price * count)).toFixed(2);
		$("#cartTotal").html(total);
		// Remove Object
		byId("selectedProduct_"+pId).remove();
		delete jsonProductCart[pId];
		// Remove Entry from Cart
		if(jsonProduct[pId]!=undefined && jsonProduct[pId]!=null) {
			var productDataRow = byId("productData_"+pId);
			if(productDataRow==undefined || productDataRow==null) {
				addProductData(pId);
			}
		}
	},100)
}



function login() {
	var username = byIdVal("loginUsername");
	var password = byIdVal("loginPassword");
	var loginData = {'username': username,'pwd': password};
	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/vip/customer/login',
		data :  loginData,
        dataType: "json",
		success : function(responseJSON) {
			var msg = 	"<div style='color:green' >";
			msg+= "<div>Login Successful</div>";
			msg+= "<div style='padding-top:20px'>Welcome, <b>"
				+responseJSON["data"]["firstName"]+" "+responseJSON["data"]["lastName"]+"</b></div>";
			msg+= "</div>";
			putErrorMessage(msg);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >Invalid Username and Password</div>";
			putErrorMessage(msg);
    		
		}
	});
}



function search() {
	var searchBox = byIdVal("searchBox");
	var searchType = byIdVal("searchType");

	if(searchType=="")
		searchType = "price";

	var searchData = {'filter': searchType,'productName': searchBox};

	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/vip/products/search',
		data :  searchData,
        dataType: "json",
		success : function(responseJSON) {
			putData(responseJSON);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});
}



function searchFrequentlyBought() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/vip/cart/frequentlyBought',
        dataType: "json",
		success : function(responseJSON) {
			putData(responseJSON);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});
}



function searchLatestCartProducts() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/vip/cart/latestCartProducts',
        dataType: "json",
		success : function(responseJSON) {
			putData(responseJSON);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred! Try creating a Cart First.</div>";
			putErrorMessage(msg);
    		
		}
	});
}



function searchProductsOnOffers() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/vip/products/productsOnOffers',
        dataType: "json",
		success : function(responseJSON) {
			putData(responseJSON);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});
}


function searchFavouriteProducts() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/vip/favouritelist/getFavouriteProducts',
        dataType: "json",
		success : function(responseJSON) {
			putData(responseJSON);
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});
}


function generateCart() {
	var productKeys = Object.keys(jsonProductCart);
	var size = productKeys.length;
	if(size==0) {
		var msg = 	"<div style='color:red' >No product selected</div>";
		putErrorMessage(msg);
		return false;
	}

	var product_array = [];
	for(var i=0; i<size; i++) {
		product_array[i] = {"product_id" : productKeys[i], "product_count":$("#productNumber_"+productKeys[i]+"_count").html()}
	}

	var dataObj = {"data": {"display_name":"test_cart", "product_data": product_array} };
	var data = {"data": JSON.stringify(dataObj)}

	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/vip/cart/addAll',
	    data: data,
		success : function(responseJSON) {
	    	putErrorMessage("Cart created successfully");
	    	$("#selectedData").html("");
	    	jsonProductCart = {};
	    	$("#cartTotal").html("0.00");
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});

}


function addToFavourite() {
	var productKeys = Object.keys(jsonProductCart);
	var size = productKeys.length;
	if(size==0) {
		var msg = 	"<div style='color:red' >No product selected</div>";
		putErrorMessage(msg);
		return false;
	}

	var product_array = [];
	for(var i=0; i<size; i++) {
		product_array[i] = {"product_id" : productKeys[i]}
	}

	var product_data = {"product_data": product_array};
	var dataObj = {"data": product_data}
	var data = {"data": JSON.stringify(dataObj)}

	$.ajax({
		type : 'POST',
		url : 'http://localhost:8080/vip/favouritelist/addAll',
	    data: data,
		success : function(responseJSON) {
	    	putErrorMessage("Added products to the favourite list");
	    	$("#selectedData").html("");
	    	jsonProductCart = {};
	    	$("#cartTotal").html("0.00");
		},
		error : function(responseJSON, textStatus, errorThrown) {
			var msg = 	"<div style='color:red' >An Error Occurred</div>";
			putErrorMessage(msg);
    		
		}
	});}

