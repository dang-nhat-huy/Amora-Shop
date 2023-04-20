<%-- 
    Document   : homePage
    Created on : Feb 6, 2023, 3:39:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assets/bootstrap-5.0.2-dist/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/base.css">
        <link rel="stylesheet" href="assets/css/home.css">
        <link rel="stylesheet" href="assets/css/slider.css">
        <link rel="icon" type="image/png" href="assets/images/LogoDoneEdited.png"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <script src="assets/bootstrap-5.0.2-dist/js/bootstrap.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>

        <title>AmoraShop</title>
    </head>

    <body>
        <div id="wrapper">

            <jsp:include page="components/header.jsp" />          

            <div class="body-container">

                <div id="banner">
                    <img class="mySlides home-banner" src="assets/images/happyNewYearWhiteTheme.jpg" alt="Happy Cat Year 2023">
                    <img class="mySlides home-banner" src="assets/images/threePerfumeBottleBlackTheme.png" alt="Beautiful man likely perfume">
                    <img class="mySlides home-banner" src="assets/images/twoPefumeWomanTheme.png" alt="Beautiful woman likely perfume">
                    <button class="button-navigation-banner prev-banner-button" onclick="plusDivs(-1)">&#10094;</button>
                    <button class="button-navigation-banner next-banner-button" onclick="plusDivs(1)">&#10095;</button>
                </div>

                <!--          New Products Section         -->
                <div class="new-product row">
                    <h2 class="new-product-title">New Products</h2>
                    <div class="owl-carou-container">
                        <div class="owl-carousel owl-theme">

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/SensualRomance.png" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Sensual Romance
                                </div>
                                <div class="product-price">
                                    $50
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/ElegantBloomGucci.png" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Elegant Bloom
                                </div>
                                <div class="product-price">
                                    $60
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/FreshOcean.png" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Fresh Ocean
                                </div>
                                <div class="product-price">
                                    $70
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/CitrusBliss.png" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Citrus Bliss
                                </div>
                                <div class="product-price">
                                    $80
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/WoodyMystique.png" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Woody Mystique
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/accquaDiGio.jpg" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Acqua Di Gio Eau De Toilette
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/euphoriaEssenceEau.jpg" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Euphoria Essence Eau De Toilette
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/valentinoValentina.jpg" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Valentino Valentina Oud Assoluto Eau De Parfum
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/lavieEstBellePink.jpg" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    La Vie Est Belle Soleil Cristal Eau De Parfum
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                            <div class="item">
                                <div class="product-img-wrap">
                                    <img src="assets/images/initioGreatnessParfum.jpg" alt="" class="product-img img-fluid" />
                                </div>
                                <div class="product-name">
                                    Initio Oud For Greatness Eau De Parfum
                                </div>
                                <div class="product-price">
                                    $90
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <!--            Top Brand Section           -->
                <div class="top-pf-brand-container row">

                    <div class="top-pf-brands-block col-sm-4 col-md-4">
                        <a href="" class="top-pf-iblock img-fluid">
                            <img class="img-fluid" src="assets/images/DolceGrabrana-home-page.jpg" alt="Dolce & Gabbana">
                        </a>
                        <div class="top-pf-brand-caption">
                            <div class="top-pf-name">Dolce & Gabbana</div>
                            <a href="#" class="button-57">
                                <span class="text">See More</span>
                                <span>See More</span>
                            </a>
                        </div>
                    </div>

                    <div class="top-pf-brands-block col-sm-4 col-md-4">
                        <a href="" class="top-pf-iblock img-fluid">
                            <img class="img-fluid" src="assets/images/prada-home-page.jpg" alt="Prada">
                        </a>
                        <div class="top-pf-brand-caption">
                            <div class="top-pf-name">Prada</div>
                            <a href="#" class="button-57">
                                <span class="text">See More</span>
                                <span>See More</span>
                            </a>
                        </div>
                    </div>

                    <div class="top-pf-brands-block col-sm-4 col-md-4">
                        <a href="" class="top-pf-iblock img-fluid">
                            <img class="img-fluid" src="assets/images/chanel-home-page.jpg" alt="Chanel">
                        </a>
                        <div class="top-pf-brand-caption">
                            <div class="top-pf-name">Chanel</div>
                            <a href="#" class="button-57">
                                <span class="text">See More</span>
                                <span>See More</span>
                            </a>
                        </div>
                    </div>

                </div>
                <div class="about-us processing-section">
                    <div class="processing-text">About-us section</div>
                    <img src="assets/images/working-on-it.jpg" alt="" class="processing-img">
                    <div class="processing-text">Working-on-it</div>
                </div>
            </div>

            <jsp:include page="components/footer.jsp" />

        </div>
        <script src="assets/js/script.js"></script>
    </body>

</html>