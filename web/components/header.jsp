<%-- 
    Document   : header
    Created on : Feb 13, 2023, 1:08:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header">
    <div class="header-nav-up">
        <div class="ivisible-bar"></div>
        <div class="wrap-logo">
            <img class="header-logo" src="assets/images/HomeLogo.png" alt="AmoraShop">
        </div>
        <ul class="utility-list">
            <li class="utility-item">
                <a href="login.jsp" class="header-icon"><img src="assets/font/account_circle_black_24dp.svg" alt=""></a>
            </li>
            <li class="utility-item js-search-btn">
                <a href="user-search-prd-page.jsp" class="header-icon"><img src="assets/font/search_black_24dp.svg" alt=""></a>
            </li>
            <li class="utility-item">
                <a class="header-icon"><img src="assets/font/shopping_bag_black_24dp.svg" alt=""></a>
                <a class="btn btn-outline-dark" href="ViewCartController">
                ${sessionScope.CART.items.size()}    
                </a>
            </li>
        </ul>
    </div>
    <div class="header-nav-down">
        <ul class="main-menu-list">
            <div id="underline"></div>
            <a class="header-nav-link" href="/AmoraShop/homePage.jsp">
                <li class="main-menu-item">Home</li>
            </a>
            <form action="ShowProductController" method="POST">
                <a class="header-nav-link" href="/AmoraShop/products-user-page.jsp">
                    <input type="submit" class="main-menu-item" value="Shop">
                </a>
            </form>
            <a class="header-nav-link" href="#">
                <li class="main-menu-item">Brand</li>
            </a>
            <a class="header-nav-link" href="#">
                <li class="main-menu-item">New Arrivals</li>
            </a>
            <a class="header-nav-link" href="#">
                <li class="main-menu-item">Sale</li>
            </a>
        </ul>
    </div>
<!--    <div class="search-box-container js-modal">
        <div class="search-box js-modal-container">
            <div class="search-box-header">
                <div class="search-title">
                    SEARCH PRODUCT
                </div>

                <div class="search-box-exit js-modal-close">
                    <img src="assets/font/close_black_24dp.svg" style="width: 100%;" alt="Close">
                </div>
            </div>
            <div class="search-wrapper">
                <input class="search-input-real-time" type="text" placeholder="Search..."/>
                <img class="search-submit-button" src="assets/font/search_black_24dp.svg" alt="Search">
            </div>
        </div>
    </div>
     Hiện Search Modal 
    <script>
        const searchBtns = document.querySelectorAll('.js-search-btn');
        const modal = document.querySelector('.js-modal');
        const modalContainer = document.querySelector('.js-modal-container');
        const modalClose = document.querySelector('.js-modal-close');

        function showSearchModal() {
            modal.classList.add('open');
        }
        function hideSearchModal() {
            modal.classList.remove('open');
        }

        for (const buyBtn of searchBtns) {
            buyBtn.addEventListener('click', showSearchModal);
        }

        modalClose.addEventListener('click', hideSearchModal);

        modal.addEventListener('click', hideSearchModal);

        modalContainer.addEventListener('click', function (event) {
            event.stopPropagation();
        });
    </script>-->
</header>
