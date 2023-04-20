<%-- 
    Document   : product-detail-user-page
    Created on : Feb 17, 2023, 5:08:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/bootstrap-5.0.2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="assets/bootstrap-5.0.2-dist/js/bootstrap.bundle.js">
        <link rel="stylesheet" href="assets/css/base.css">
        <link rel="stylesheet" href="assets/css/home.css">
        <link rel="stylesheet" href="assets/css/products.css">
        <link rel="icon" type="image/png" href="assets/images/LogoDoneEdited.png" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>AmoraShop</title>

    </head>
    <body>
        <jsp:include page="components/header.jsp" />
        <c:set var="productDetail" value="${sessionScope.PRODUCT_DETAIL}" />

        <div class="wrapper">         
            <div class="body-container">
                <div class="bread-crumb-container">
                    <div class="bread-crumbs">
                        <a href="home.html" class="main-page link">Home</a>
                        <div class="slash">/</div>
                        <a href="products.html" class="main-page link">Products</a>
                        <div class="slash">/</div>
                        <a href="#" class="main-page link">Product Details</a>
                    </div>
                </div>

                <div class="product-detail-container row">
                    <c:forEach items="${productDetail}" var="productDto">
                    <div class="product-wrap col-5">
                        <div class="product-img-wrap product-detail-wrap fix-height">
                            <img src="${productDto.image}" alt="${productDto.name}" class="product-img img-fluid">
                        </div>
                    </div>

                    <div class="product-detail-info-wrapper col-7">
                        
                        <div class="product-detail-name">
                            ${productDto.name}
                        </div>
                        <div class="product-detail-price">
                            ${productDto.price}$
                        </div>

                        <form class="buy-area" action="AddToCartServlet">
                            <div class="select-quantity-area">
                                <input type="button" value="-" class="quantity-btn">
                                <input type="text" id="quantity" name="quantity" value="1" class="quantity-selector">
                                <input type="button" value="+" class="quantity-btn">
                                <input type="hidden" value="${productDto.productID}" name="productID"/>
                            </div>
                            <button type="submit" class="add-to-cart-btn button-57">
                                <span>ADD TO CART</span>   
                                <span>ADD TO CART</span>   
                            </button>
                        </form>

                        <div class="product-detail-des">
                            <h3 class="product-detail-des-title">Description:</h3>
                            <p>
                                Capacity: ${productDto.capacity} ml<br><br>
                                ${productDto.description}
                            </p>
                        </div>
                            
                    </div>
                    </c:forEach>        
                </div>
            </div>        
        </div>

        <jsp:include page="components/footer.jsp" />
    </body>
</html>
