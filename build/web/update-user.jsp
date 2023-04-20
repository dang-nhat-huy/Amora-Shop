<%-- 
    Document   : update-user
    Created on : Feb 11, 2023, 11:21:50 AM
    Author     : thaiq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Update User</title>
        <link href="hien-css/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Update User</h3></div>
                                    <div class="card-body">
                                        <form action="UpdateUserController" method="POST" enctype="multipart/form-data">
                                            <input class="form-control" type="hidden" name="password"
                                                   value="${us.password}"/>

                                            <input class="form-control" type="hidden" name="email"
                                                   value="${us.email}"/>

                                            <input class="form-control" type="hidden" name="userID"
                                                   value="${us.userID}"/><br/>

                                            <div class="col-md-12"> Image
                                                Choose a file: <input type="file" name="image" class="form-control" placeholder="image" value="">
                                            </div>

                                            <img  width="100px" class="mt-5"  src="${us.image}"/>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputIDName" type="text"  name="fullName" value="${us.fullName}" required="" placeholder="Enter your ID name"/>
                                                        <label for="inputIDName">Full Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputName" type="text" name="address" value="${us.address}" required="" />
                                                        <label for="inputName">Address</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        Gender: <input id="inputStatus" type="radio"  name="gender" value="MALE" checked="checked"/>MALE
                                                        <input type="radio" name="gender" value="FEMALE">FEMALE
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputRole" type="text" name="phoneNumber" value="${us.phoneNumber}" required="" />
                                                        <label for="inputRole">Phone</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        Status: <input type="radio" name="status" value="ACTIVE" checked="checked">ACTIVE 
                                                        <input type="radio" name="status" value="INACTIVE"  >INACTIVE
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <select name="roleID">

                                                            <c:forEach items="${roleU}" var="D">
                                                                <option value="${D.role_id}">${D.role_name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <input class="btn btn-primary w-100" type="submit" value="Update">
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="http://localhost:8080/AmoraShop/ShowUserController">Comeback</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Aroma &copy; Aroma Update User</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>

