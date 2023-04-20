<%-- 
    Document   : products-user-page
    Created on : Feb 13, 2023, 5:54:22 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


        <div class="body-container">
            <div class="bread-crumb-container">
                <div class="bread-crumbs">
                    <a href="homePage.jsp" class="main-page link">Home</a>
                    <div class="slash">/</div>
                    <a href="ShowProductController" class="main-page link">Products</a>
                </div>
            </div>
            <div id="banner">
                <img class="mySlides products-banner" src="assets/images/happyNewYearWhiteTheme.jpg" alt="Happy Cat Year 2023">
            </div>

            <div class="products-body row">
                <div class="left-nav-container col-2">
                    <div id="tree" class="left-nav-filter">
                        <ul>
                            <li>
                                <label for="node-1">Brands</label>
                                <input type="checkbox" id="node-1" />
                                <ul>
                                    <li>
                                        <a class="category-item" for="node-1-1" href="SearchProductByBrandController?brand=Chanel">Chanel</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-1-2" href="SearchProductByBrandController?brand=Dior">Dior</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-1-2" href="SearchProductByBrandController?brand=Lancôme">Lancôme</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-1-2" href="SearchProductByBrandController?brand=Guerlain">Guerlain</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-1-2"href="SearchProductByBrandController?brand=Thierry Mugler">Thierry Mugler</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <label for="node-2">For Man</label>
                                <input type="checkbox" id="node-2" />
                                <ul>
                                    <li>
                                        <a class="category-item" for="node-2-1" href="SearchProductByBrandAndCategoryController?brand=Chanel&categoryID=1">Chanel</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-2-2" href="SearchProductByBrandAndCategoryController?brand=Dior&categoryID=1">Dior</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-2-2" href="SearchProductByBrandAndCategoryController?brand=Lancôme&categoryID=1">Lancôme</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-2-2" href="SearchProductByBrandAndCategoryController?brand=Guerlain&categoryID=1">Guerlain</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-2-2" href="SearchProductByBrandAndCategoryController?brand=Thierry Mugler&categoryID=1">Thierry Mugler</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <label for="node-3">For Woman</label>
                                <input type="checkbox" id="node-3" />
                                <ul>
                                    <li>
                                        <a class="category-item" for="node-3-1" href="SearchProductByBrandAndCategoryController?brand=Chanel&categoryID=2">Chanel</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-3-2" href="SearchProductByBrandAndCategoryController?brand=Dior&categoryID=2">Dior</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-3-2" href="SearchProductByBrandAndCategoryController?brand=Lancôme&categoryID=2">Lancôme</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-3-2" href="SearchProductByBrandAndCategoryController?brand=Guerlain&categoryID=2">Guerlain</a>
                                    </li>
                                    <li>
                                        <a class="category-item" for="node-3-2" href="SearchProductByBrandAndCategoryController?brand=Thierry Mugler&categoryID=2">Thierry Mugler</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="right-product-list col-10">
                    <div class="product-list-header">
                        <h2 class="category-title">All products</h2>
                        <div class="category-sort-cotainer">
                            <select id="sort-by" class="category-sort-options">
                                <option value="price-asc">Ascending Price</option>
                                <option value="price-des">Descending Price</option>
                                <option value="name-a-z">Name: A - Z</option>
                                <option value="name-z-a">Name: Z - A</option>
                            </select>
                        </div>
                    </div>

                    <div class="product-list-container row">

                        <!--Testing area-->

                        <c:forEach items="${products}" var="product">

                            <div class="product-items col-3">
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

                    <nav aria-label="..." class="pagination-container">
                        <ul class="pagination">
                            <li class="page-item">
                                <a <c:if test="${page!=1}">
                                        href="ShowProductController?page=${page-1}"
                                    </c:if> class="page-link" aria-label="Next">
                                    <span aria-hidden="true">«</span>
                                </a>
                            </li>

                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="ShowProductController?page=${i}">${i}</a></li>
                                </c:forEach>    

                            <li class="page-item">
                                <a <c:if test="${page!=totalPage}">
                                        href="ShowProductController?page=${page+1}"
                                    </c:if> class="page-link" aria-label="Next">
                                    <span aria-hidden="true">»</span>
                                </a>
                            </li>
                        </ul>
                    </nav>

                </div>
            </div>
        </div>

        <jsp:include page="components/footer.jsp" />
        <script src="assets/js/SortProduct.js"></script>

    </body>
</html>
