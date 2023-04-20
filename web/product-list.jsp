<%-- 
    Document   : UserList
    Created on : Feb 6, 2023, 5:47:09 PM
    Author     : thaiq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Product Manager</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="hien-css/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="homePage.jsp">Aroma</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <!--            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" action="ShowUserController" method="GET">
                            <div class="input-group">
                                <input class="form-control" name="name" type="text" placeholder="Search..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                                <button class="btn btn-primary" id="btnNavbarSearch" type="submit" value="search"><i class="fas fa-search"></i></button>
                            </div>
                        </form>-->
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="http://localhost:8080/AmoraShop/LogoutController">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Amora System</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAuthentication" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Manager
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseAuthentication" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="http://localhost:8080/AmoraShop/ShowUserController">User Manager</a>
                                    <a class="nav-link" href="http://localhost:8080/AmoraShop/ShowProductAdminController">Product Manager</a>
                                </nav>
                            </div>


                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as: </div>
                        ADMIN ${sessionScope.LOGIN_USER.fullName}
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">

                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="admin.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Product Manager</li>
                        </ol>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                PRODUCT MANAGER
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Quantity</th>
                                            <th>Status</th>
                                            <th>Description</th>
                                            <th>Capacity</th>
                                            <th>Brand</th>  
                                            <th>Price</th>  
                                            <th>Category</th>
                                            <th>Image</th>
                                            <th>Setting</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach items="${requestScope.PRODUCT}" var="product">
                                            <tr>
                                                <td>${product.name}</td>
                                                <td>${product.quantity}</td>
                                                <td>${product.status}</td>
                                                <td>${product.description}</td>
                                                <td>${product.capacity} ml</td>
                                                <td>${product.brand}</td>
                                                <td>${product.price}</td>
                                                <td>
                                                    <c:if test="${product.categoryID == 1}">MAN</c:if>
                                                    <c:if test="${product.categoryID == 2}">WOMAN</c:if>
                                                    </td>
                                                    <td>
                                                        <img style="width: 30px; height: 30px;" src="${product.image}" />
                                                </td>

                                                <td>
                                                    <!--update-->
                                                    <c:url var="update" value="MainController">
                                                        <c:param name="action" value="Detail"></c:param>
                                                        <c:param name="productID" value="${product.productID}"></c:param>

                                                    </c:url>
                                                    <a href="${update}">Update</a> 

                                                    <!--delete-->
                                                    <c:url var="delete" value="MainController" >                                                       
                                                        <c:param name="action" value="Delete"></c:param>
                                                        <c:param name="productID" value="${product.productID}"></c:param>
                                                    </c:url>
                                                    <a href="${delete}" onclick="return confirm('Are you sure you want to delete?')">delete</a> 
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <a href="create-product.jsp">Add new product</a>
                </main>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="hien-css/js/scripts.js"></script>
        <script src="hien-css/js/datatables-simple-demo.js"></script>
        <script src="hien-css/assets/demo/chart-area-demo.js"></script>
        <script src="hien-css/assets/demo/chart-bar-demo.js"></script>
        <script src="hien-css/assets/demo/chart-pie-demo.js"></script>
        <script src="hien-css/assets/demo/datatables-demo.js"></script>

    </body>

</html>