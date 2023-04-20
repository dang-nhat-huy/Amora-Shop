<%-- 
    Document   : footer
    Created on : Feb 13, 2023, 1:19:28 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer class="footer">
    <div class="footer-top row">

        <div class="footer-inner-block col-3">
            <h4 class="footer-inner-title">Introduction</h4>
            <div class="footer-container">
                <div class="inner-footer-text">
                    <!-- Một cửa hàng nước hoa giúp bạn sống lại cùng những kí ức đã bị lãng quên bằng hương thơm -->
                    Amora Shop, a perfume store that will bring to life again a forgotten memory by fragrance!
                </div>
                <div class="footer-shop-logo-container">
                    <img class="footer-shop-logo" src="assets/images/LogoDoneEdited.png" alt="AmoraShop logo">
                </div>
            </div>
        </div>

        <div class="footer-inner-block col-5">
            <h4 class="footer-inner-title">Information</h4>
            <div class="footer-container">
                <div class="inner-footer-text">
                    <i class="ti-headphone-alt"></i>
                    Phone: 08369xxxxx
                </div>
                <div class="inner-footer-text">
                    Gmail: hongducnguyenho0@gmail.com
                </div>
                <div class="inner-footer-text">
                    Address: FPT University 
                    Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh 700000, Việt Nam
                </div>
            </div>

        </div>

        <div style="background-color: rgba(0,0,0,0.2)" class="col-4">
            <div id="map"></div>
        </div>

    </div>
    <div class="copyright">
        Copyright © 2023 Amora Shop. Powered by SWP391 FPT University
    </div>
    <style>
        #map {
            height: 300px;
            width: 100%;
        }
    </style>
    <script>
        function initMap() {
            var myLatLng = {lat: 10.84142, lng: 106.81004};

            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 15,
                center: myLatLng
            });

            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                title: 'My Location'
            });
        }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDc7PnOq3Hxzq6dxeUVaY8WGLHIePl0swY&callback=initMap"></script>
</footer>