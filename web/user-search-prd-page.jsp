<%-- 
    Document   : user-search-prd-page
    Created on : Feb 20, 2023, 11:02:47 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <link rel="icon" type="image/png" href="assets/images/LogoDoneEdited.png"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <script src="assets/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>

        <title>AmoraShop</title>
    </head>
    <body>

        <jsp:include page="components/header.jsp" />

        <c:set var="searchNameProductResult" value="${requestScope.productListByName}" />

        <div class="wrapper">

            <div class="search-name-body-container">
                <div class="search-product-container">
                    <div class="search-heading-page">
                        <div class="header-text-container">
                            <div class="header-page-title">
                                Search Products
                            </div>
                            <div class="search-quantity-result">                                    
                                <c:if test = "${not empty searchNameProductResult}"><!-- Check if list existed-->
                                    ${requestScope.totalProducts}
                                    products have been found!! 
                                </c:if>
                            </div>
                        </div>
                        <c:if test="${not empty searchNameProductResult}">
                            <div class="search-form-container">
                                <form class="search-by-name-wrapper" action="SearchProductController" method="GET">                                
                                    <input type="text" class="search-product-name" name="prdName" value="${param.prdName}">
                                    <input class="search-submit-btn" type="image" src="assets/font/search_black_24dp.svg"
                                           alt="Search">
                                </form>
                            </div>
                        </c:if>
                    </div>

                    <c:if test="${not empty searchNameProductResult}">
                        <div class="product-list-show-by-name">
                            <div class="searched-content">
                                Search result for "${param.prdName}"
                            </div>
                            <div class="list-content row">

                                <c:forEach items="${productListByName}" var="product">

                                    <div style="align-items: center" class="product-items col-md-3">
                                        <a href="ShowProductDetailUserController?product_id=${product.productID}">
                                            <div class="product-img-wrap">
                                                <img class="product-img img-fluid" src="${product.image}" alt="${product.name}" >
                                            </div>
                                        </a>                                        
                                        <div class="product-name">
                                            ${product.name}
                                        </div>
                                        <div class="product-price">
                                            ${product.price}$
                                        </div>
                                    </div>

                                </c:forEach>

                            </div>
                        </div>
                        <nav aria-label="..." class="pagination-container">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a <c:if test="${page!=1}">
                                            href="SearchProductController?prdName=${param.prdName}&page=${page-1}"
                                        </c:if> class="page-link" aria-label="Next">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </li>

                                <c:forEach begin="1" end="${totalPage}" var="i">
                                    <li class="page-item ${i==page?"active":""}"><a class="page-link" href="SearchProductController?prdName=${param.prdName}&page=${i}">${i}</a></li>
                                    </c:forEach>    

                                <li class="page-item">
                                    <a <c:if test="${page!=totalPage}">
                                            href="SearchProductController?prdName=${param.prdName}&page=${page+1}"
                                        </c:if> class="page-link" aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </li>

                            </ul>
                        </nav>

                    </c:if>

                    <c:if test="${empty searchNameProductResult}"> <!-- Check list not existed -> show default search-->
                        <div class="search-form-container-noval">
                            <form class="search-by-name-wrapper-noval" action="SearchProductController">
                                <input type="text" class="search-product-name" name="prdName">
                                <input class="search-submit-btn" type="image" src="assets/font/search_white_24dp.svg"
                                       alt="Search">
                            </form>                         
                        </div>
                        <c:if test="${not empty requestScope.SearchErrorNote}">
                            <div class="search-error-note">
                                Sorry, we couldn't find any results for your search term<br>
                                Please check spelling, use more general words and try again!
                            </div>    
                        </c:if>
                    </c:if>


                </div>
            </div>
        </div>
    </div>




    <jsp:include page="components/footer.jsp" />
    <script src="assets/js/SortProduct.js"></script>

</body>
</html>
