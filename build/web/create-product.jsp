<%-- 
    Document   : create-product
    Created on : Feb 11, 2023, 1:05:20 PM
    Author     : thaiq
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <form class="form-horizontal" action="CreateProductController" method="POST" enctype="multipart/form-data">             <fieldset>

                <!-- Form Name -->
                <legend style="padding: 30px 20px; font-size: 24px; font-weight: 800; color: darkcyan;">PRODUCT INSERT</legend>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_name"> NAME</label>  
                    <div class="col-md-4">
                        <input id="product_name" name="newproductname" value="${products.name}"  class="form-control input-md" type="text" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="available_quantity">QUANTITY</label>  
                    <div class="col-md-4">
                        <input id="available_quantity" name="newquantity" value="${products.quantity}"   class="form-control input-md" required="" type="number">

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label" for="available_quantity">STATUS</label>  
                    <div class="col-md-4">
                        <input type="radio" name="newstatus" value="Available"  checked="checked">Available 
                        <input type="radio" name="newstatus" value="Unavailable" >Unavailable
                    </div>
                </div>

                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                    <div class="col-md-4">                     
                        <textarea class="form-control" id="product_description" name="newdescription" value="${products.description}" ></textarea>
                    </div>
                </div>


                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_weight">CAPACITY</label>  
                    <div class="col-md-4">
                        <input id="product_weight" name="newcapacity" class="form-control input-md" required="" value="${products.capacity}"  type="number">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="percentage_discount">CHOOSE BRAND:</label>
                    <div class="col-md-4">
                        <select name="newbrand" id="newbrand">
                            <option value="Chanel">Chanel</option>
                            <option value="Gucci">Gucci</option>
                            <option value="Dior">Dior</option>
                            <option value="YSL">YSL</option>
                            <option value="Hermes">Hermes</option>
                            <option value="Burberry">Burberry</option>
                        </select>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="percentage_discount">PRICE</label>  
                    <div class="col-md-4">
                        <input id="percentage_discount" name="newprice" value="${products.price}"  class="form-control input-md" required="" type="number">

                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_categorie"> CATEGORY</label>
                    <div class="col-md-4">
                        <input type="radio" name="newcategoryid" value="1" checked="checked">MALE 
                        <input type="radio" name="newcategoryid" value="2">FEMALE
                    </div>
                </div>


                <!-- File Button -->           
                <div class="form-group">
                    <label class="col-md-4 control-label">IMAGE</label>
                    <div class="col-md-4">
                        Choose a file: <input type="file" name="newimage" class="form-control" placeholder="image" value="">
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <input type="submit" onclick="createProduct()" value="Create" /> 
                    </div>
                </div>

            </fieldset>
        </form>
    </body>
    <script>
        function createProduct() {
            let name = document.querySelector('#product_name').value;
            let quantity = document.querySelector('#available_quantity').value;
            let capacity = document.querySelector('#product_weight').value;
            let price = document.querySelector('#percentage_discount').value;
            if (name === "" || quantity === "" || capacity === "" || price === "") {
                alert('All input must be filled');
                return;
            }
            if (parseInt(quantity) < 0) {
                alert('Quantity must be greater than or equal to 0');
                return;
            }
            if (parseInt(capacity) < 0) {
                alert('Capacity must be greater than or equal to 0');
                return;
            }
            if (parseInt(price) < 0) {
                alert('Price must be greater than or equal to 0');
                return;
            }
        }
    </script>

</html>
