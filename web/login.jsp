<%-- 
    Document   : login
    Created on : Feb 1, 2023, 5:06:01 PM
    Author     : thaiq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css"/>-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!--<<script src="../node_modules/bootstrap/dist/js/bootstrap.bundle.js"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/home.css"/>
        <link rel="stylesheet" href="assets/css/base.css"/>
        <link rel="icon" type="image/png" href="assets/images/LogoDoneEdited.png"/>
        <title>AmoraShop</title>
    </head>
    <body>
        <div class="wrapper">
            
            <jsp:include page="components/header.jsp" /> 
            <c:if test="${sessionScope.LOGIN_USER.roleID == 1}">
                <c:redirect url="http://localhost:8080/AmoraShop/ShowUserController"></c:redirect>
            </c:if>
            <c:if test="${sessionScope.LOGIN_USER != null}">
                <c:redirect url="user.jsp"></c:redirect>
                
            </c:if>
     <div class="login-signup-container row">
                <div class="login-signup-block col-6 ">
                    <div class="img-container">
                        <img src="assets/images/LogoDoneEdited.png" alt="" class="login-page-logo">
                    </div>
                </div>
                <div class="login-signup-block col-6 ">
                    <form action="LoginController" method="POST" class="login-signup-wrapper">
                        <div class="login-signup-title">
                            Login
                            <div class="slash-decor"></div>
                        </div>
                        <h3 class="check-error-pass">${requestScope.status}</h3>
                        <h3 class="check-error-pass" style="color: red">${requestScope.ERROR}</h3>
                        <h3 class="check-error-pass" style="color: green">${requestScope.successfully}</h3>
                        <input type="email" name="email" id="user-email" class="user-login-signup-input" placeholder="Email"/>
                        <input type="password" name="password" id="user-email-password" class="user-login-signup-input" placeholder="Password"/>

                        <!-- Submit button -->
                        <div class="action-bottom row">
                            <button type="submit" name="login" class="button-57 col-3">
                                <span>Sign in</span>
                                <span>Sign in</span>
                            </button>

                            <div class="action-other-box col-4">
                                <a href="forgot-password.jsp" class="forgot-password-link">Forgot password?</a>
                                <div class="divider d-flex align-items-center"></div>
                                <a href="register.jsp">Sign Up!</a>
                            </div>
                        </div>

                        <div class="divider d-flex align-items-center my-4">
                            <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                        </div>

                        <!--                        <a class="btn btn-primary btn-lg btn-block" style="background-color: #4585f4"
                                                   href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/AmoraShop/LoginGoogleController&response_type=code&client_id=591003804845-5tufd24ql7v462gen0vp1n0lhov8v369.apps.googleusercontent.com&approval_prompt=force"
                                                   role="button">
                                                    <i class="fab fa-facebook-f me-2"></i>Continue with Google
                                                </a>-->
                        <a class="btn btn-primary btn-lg btn-block" style="background-color: #4285f4" 
                           href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/AmoraShop/LoginGoogleController&response_type=code&client_id=591003804845-5tufd24ql7v462gen0vp1n0lhov8v369.apps.googleusercontent.com&approval_prompt=force"
                           role="button">
                            Continue with Google
                            <img class="action-login-google-icon" src="assets/font/Google__G__Logo.svg" alt="Google logo">
                        </a>
                    </form>
                </div>
            </div>

            <jsp:include page="components/footer.jsp" />


        </div>
    </body>

</html>