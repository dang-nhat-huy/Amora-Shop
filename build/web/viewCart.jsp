<%-- 
    Document   : viewCart
    Created on : Feb 21, 2023, 1:39:13 PM
    Author     : long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/bootstrap-5.0.2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/base.css">
        <link rel="stylesheet" href="assets/css/home.css">
        <link rel="stylesheet" href="assets/css/products.css">
        <link rel="stylesheet" href="assets/css/cart.css">
        <link rel="icon" type="image/png" href="assets/images/LogoDoneEdited.png"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <script src="assets/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>

        <title>AmoraShop</title>
    </head>

    <body>

        <%--  <h1>----Inventory----</h1>
          <c:set var="cart" value="${sessionScope.CART.items}" />
          <c:set var="userProduct" value="${sessionScope.USER_PRODUCTS}" />
          <c:if test="${not empty cart}">
              <form action="RemoveCartServlet">
                  <table border="1">
                      <thead>
                          <tr>
                              <th>No.</th>
                              <th>Book Name</th>                         
                              <th>Quantity</th>
                              <th>Price</th>
                              <th>Total</th>
                              <th>Action</th>
                          </tr>
                      </thead>
                      <tbody>
                          <c:forEach var="item" items="${cart}" varStatus="counter">
                              <c:set var="productId" value="${item.key}" />
                              <c:set var="quantity" value="${item.value}" />
                              <c:forEach var="product" items="${userProduct}">
                                  <c:if test="${product.productID eq productId}">
                                      <tr>
                                          <td>
                                              ${counter.count}
                                              .</td>
                                          <td>
                                              ${product.name}
                                          </td>
                                          <td>
                                              ${quantity}
                                          </td>
                                          <td>
                                              ${product.price}
                                          </td>
                                          <td>
                                              ${product.price*quantity}
                                          </td>
                                          <td>
                                              <input type="submit" name="chkItem" 
                                                     value="${productId}" />
                                          </td>
                                      </tr>
                                  </c:if>

                            </c:forEach>
                        </c:forEach>
                        <tr>
                            <td colspan="5">
                                <a href="showProduct">Add More Books to Your Cart.</a>  
                            </td>

                        </tr>
                    </tbody>
                </table>
            </form>
            
            <form action="AuthorizePayment" method="POST">
                <input name="name" value="${product.name}" type="hidden">
                <input name="quantity" value="${quantity}" type="hidden">
                <input name="total" value="${product.price*quantity}" type="hidden">
                <input type="submit" value="Paypal">
            </form>
        <li>
            <a href="shipping-details.jsp" class="header-icon">Buy</a>           
        </li>
    </c:if>
    <c:if test="${empty cart}">
        <h2>
            No cart is existed!!!!! 
        </h2>
        <a href="ShowProductController">Click here to buy more</a>  
    </c:if>--%>
        <jsp:include page="components/header.jsp"/>

        <c:set var="cart" value="${sessionScope.CART.items}" />
        <c:set var="userProduct" value="${sessionScope.USER_PRODUCTS}" />
        <%
            float total = 0;
        %>
        <div class="body-container">

            <div class="bread-crumb-container">
                <div class="bread-crumbs">
                    <a href="homePage.html" class="main-page-link">Home</a>
                    <div class="slash">/</div>
                    <a href="#" class="main-page link">Cart</a>
                </div>
            </div>

            <div class="search-heading-page">
                <div class="cart-container">
                    <div class="header-text-container">
                        <div class="header-page-title">
                            Your Inventory
                        </div>
                        <div class="header-quantity-result">
                            There are products in your cart
                        </div>
                    </div>
                </div>
            </div>


            <div class="cart-content-container">
                <div class="cart-product-list row">
                    <c:if test="${not empty cart}">
                        <form action="RemoveCartServlet">

                            <c:forEach var="item" items="${cart}">
                                <c:set var="productId" value="${item.key}" />
                                <c:set var="quantity" value="${item.value}" />
                                <c:forEach var="product" items="${userProduct}">
                                    <c:if test="${product.productID eq productId}">
                                        <div class="cart-item row">
                                            <div class="product-image-container col-3">
                                                <img class="cart-item-img" src="${product.image}"
                                                     alt="${product.name}">
                                            </div>
                                            <div class="item-content col-9">
                                                <div class="item-name">
                                                    ${product.name}
                                                </div>
                                                <div class="item-price">
                                                    ${product.price}$
                                                </div>
                                                <div class="select-quantity-area">
                                                    <input type="button" value="-" class="quantity-btn">
                                                    <input type="text" id="quantity" name="quantity" value="${quantity}" class="quantity-selector">
                                                    <input type="button" value="+" class="quantity-btn">
                                                </div>
                                                <div class="product-item-action">
                                                    <button class="delete-item-btn" type="submit" name="chkItem" value="${productId}">
                                                        <img class="detete-item-icon" src="assets/font/close_black_24dp.svg" alt="Remove Item">
                                                    </button>

                                                    <div class="item-total-money">
                                                        ${product.price*quantity} $
                                                        <c:set var="total_all" value="${total_all + product.price*quantity}" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                                       
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </form>
                    </c:if>
                </div>

                <div class="order-info-container">

                    <div class="order-info">
                        Total price:
                        <div class="total-price">
                            ${total_all} $
                        </div>
                    </div>

                    <div class="order-actions">
                        <a class="button-57" href="ShowProductController" class="continues-buying-btn">
                            <span>Continues Buying</span>
                            <span>Continues Buying</span>
                        </a>
                        <a class="button-57" href="CheckoutController" class="checkout-btn">  
                            <span>Check Out</span>
                            <span>Check Out</span>
                        </a>
                    </div>

                </div>


            </div>
            <c:if test="${requestScope.error != null}">
                <div style="display: flex; justify-content: center; flex-direction: column; align-items: center">

                    <h3 class="text-danger">${error}</h3>
        
                    <a href="login.jsp">Click here to login</a>    
                </div>

            </c:if> 
        </div>


        <jsp:include page="components/footer.jsp"/>





    </body>
</html>
