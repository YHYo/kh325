<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/views/common/headerLight.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>기념품 상품 리스트 페이지</title>
    <!-- SEO Meta Tags-->
    <meta name="description" content="Finder - Directory &amp; Listings Bootstrap Template">
    <meta name="keywords" content="bootstrap, business, directory, listings, e-commerce, car dealer, city guide, real estate, job board, user account, multipurpose, ui kit, html5, css3, javascript, gallery, slider, touch">
    <meta name="author" content="Createx Studio">
    <!-- Viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon and Touch Icons-->
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">
    <link rel="mask-icon" color="#5bbad5" href="safari-pinned-tab.svg">
    <meta name="msapplication-TileColor" content="#766df4">
    <meta name="theme-color" content="#ffffff">
    <!-- Page loading styles-->
    <style>
        .page-loading {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 100%;
            -webkit-transition: all .4s .2s ease-in-out;
            transition: all .4s .2s ease-in-out;
            background-color: #1f1b2d;
            opacity: 0;
            visibility: hidden;
            z-index: 9999;
        }
        
        .page-loading.active {
            opacity: 1;
            visibility: visible;
        }
        
        .page-loading-inner {
            position: absolute;
            top: 50%;
            left: 0;
            width: 100%;
            text-align: center;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            -webkit-transition: opacity .2s ease-in-out;
            transition: opacity .2s ease-in-out;
            opacity: 0;
        }
        
        .page-loading.active>.page-loading-inner {
            opacity: 1;
        }
        
        .page-loading-inner>span {
            display: block;
            font-size: 1rem;
            font-weight: normal;
            color: #fff;
            ;
        }
        
        .page-spinner {
            display: inline-block;
            width: 2.75rem;
            height: 2.75rem;
            margin-bottom: .75rem;
            vertical-align: text-bottom;
            border: .15em solid #9691a4;
            border-right-color: transparent;
            border-radius: 50%;
            -webkit-animation: spinner .75s linear infinite;
            animation: spinner .75s linear infinite;
        }
        
        @-webkit-keyframes spinner {
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        
        @keyframes spinner {
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
    </style>
    <!-- Page loading scripts-->
    <script>
        (function() {
            window.onload = function() {
                var preloader = document.querySelector('.page-loading');
                preloader.classList.remove('active');
                setTimeout(function() {
                    preloader.remove();
                }, 2000);
            };
        })();
    </script>
    <!-- Vendor Styles-->
    <link rel="stylesheet" media="screen" href="vendor/simplebar/dist/simplebar.min.css" />
    <link rel="stylesheet" media="screen" href="vendor/tiny-slider/dist/tiny-slider.css" />
    <link rel="stylesheet" media="screen" href="vendor/nouislider/dist/nouislider.min.css" />
    <!-- Main Theme Styles + Bootstrap-->
    <link rel="stylesheet" media="screen" href="css/theme.min.css">
</head>
<!-- Body-->

<body class="bg-dark fixed-bottom-btn">
    <!-- Page loading spinner-->
    <div class="page-loading active">
        <div class="page-loading-inner">
            <div class="page-spinner"></div><span>Loading...</span>
        </div>
    </div>
    <main class="page-wrapper">
        <!-- Sign In Modal-->
        <div class="modal fade" id="signin-modal" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered p-2 my-0 mx-auto" style="max-width: 950px;">
                <div class="modal-content bg-dark border-light">
                    <div class="modal-body px-0 py-2 py-sm-0">
                        <button class="btn-close btn-close-white position-absolute top-0 end-0 mt-3 me-3" type="button" data-bs-dismiss="modal"></button>
                        <div class="row mx-0 align-items-center">
                            <div class="col-md-6 border-end-md border-light p-4 p-sm-5">
                                <h2 class="h3 text-light mb-4 mb-sm-5">Hey there!<br>Welcome back.</h2><img class="d-block mx-auto" src="img/signin-modal/signin-dark.svg" width="344" alt="Illustartion">
                                <div class="text-light mt-4 mt-sm-5"><span class="opacity-60">Don't have an account? </span><a class="text-light" href="#signup-modal" data-bs-toggle="modal" data-bs-dismiss="modal">Sign up here</a></div>
                            </div>
                            <div class="col-md-6 px-4 pt-2 pb-4 px-sm-5 pb-sm-5 pt-md-5"><a class="btn btn-outline-info w-100 mb-3" href="#"><i class="fi-google fs-lg me-1"></i>Sign in with Google</a><a class="btn btn-outline-info w-100 mb-3" href="#"><i class="fi-facebook fs-lg me-1"></i>Sign in with Facebook</a>
                                <div class="d-flex align-items-center py-3 mb-3">
                                    <hr class="hr-light w-100">
                                    <div class="text-light opacity-70 px-3">Or</div>
                                    <hr class="hr-light w-100">
                                </div>
                                <form class="needs-validation" novalidate>
                                    <div class="mb-4">
                                        <label class="form-label text-light mb-2" for="signin-email">Email address</label>
                                        <input class="form-control form-control-light" type="email" id="signin-email" placeholder="Enter your email" required>
                                    </div>
                                    <div class="mb-4">
                                        <div class="d-flex align-items-center justify-content-between mb-2">
                                            <label class="form-label text-light mb-0" for="signin-password">Password</label><a class="fs-sm text-light" href="#">Forgot password?</a>
                                        </div>
                                        <div class="password-toggle">
                                            <input class="form-control form-control-light" type="password" id="signin-password" placeholder="Enter password" required>
                                            <label class="password-toggle-btn" aria-label="Show/hide password">
                          <input class="password-toggle-check" type="checkbox"><span class="password-toggle-indicator"></span>
                        </label>
                                        </div>
                                    </div>
                                    <button class="btn btn-primary btn-lg w-100" type="submit">Sign in         </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign Up Modal-->
        <div class="modal fade" id="signup-modal" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered p-2 my-0 mx-auto" style="max-width: 950px;">
                <div class="modal-content bg-dark border-light">
                    <div class="modal-body px-0 py-2 py-sm-0">
                        <button class="btn-close btn-close-white position-absolute top-0 end-0 mt-3 me-3" type="button" data-bs-dismiss="modal"></button>
                        <div class="row mx-0 align-items-center">
                            <div class="col-md-6 border-end-md border-light p-4 p-sm-5">
                                <h2 class="h3 text-light mb-4 mb-sm-5">Join Finder.<br>Get premium benefits:</h2>
                                <ul class="list-unstyled mb-4 mb-sm-5">
                                    <li class="d-flex mb-2"><i class="fi-check-circle text-primary mt-1 me-2"></i><span class="text-light">Add and promote your listings</span></li>
                                    <li class="d-flex mb-2"><i class="fi-check-circle text-primary mt-1 me-2"></i><span class="text-light">Easily manage your wishlist</span></li>
                                    <li class="d-flex mb-0"><i class="fi-check-circle text-primary mt-1 me-2"></i><span class="text-light">Leave reviews</span></li>
                                </ul><img class="d-block mx-auto" src="img/signin-modal/signup-dark.svg" width="344" alt="Illustartion">
                                <div class="text-light mt-sm-4 pt-md-3"><span class="opacity-60">Already have an account? </span><a class="text-light" href="#signin-modal" data-bs-toggle="modal" data-bs-dismiss="modal">Sign in</a></div>
                            </div>
                            <div class="col-md-6 px-4 pt-2 pb-4 px-sm-5 pb-sm-5 pt-md-5"><a class="btn btn-outline-info w-100 mb-3" href="#"><i class="fi-google fs-lg me-1"></i>Sign in with Google</a><a class="btn btn-outline-info w-100 mb-3" href="#"><i class="fi-facebook fs-lg me-1"></i>Sign in with Facebook</a>
                                <div class="d-flex align-items-center py-3 mb-3">
                                    <hr class="hr-light w-100">
                                    <div class="text-light opacity-70 px-3">Or</div>
                                    <hr class="hr-light w-100">
                                </div>
                                <form class="needs-validation" novalidate>
                                    <div class="mb-4">
                                        <label class="form-label text-light" for="signup-name">Full name</label>
                                        <input class="form-control form-control-light" type="text" id="signup-name" placeholder="Enter your full name" required>
                                    </div>
                                    <div class="mb-4">
                                        <label class="form-label text-light" for="signup-email">Email address</label>
                                        <input class="form-control form-control-light" type="email" id="signup-email" placeholder="Enter your email" required>
                                    </div>
                                    <div class="mb-4">
                                        <label class="form-label text-light" for="signup-password">Password <span class='fs-sm opacity-50'>min. 8 char</span></label>
                                        <div class="password-toggle">
                                            <input class="form-control form-control-light" type="password" id="signup-password" minlength="8" required>
                                            <label class="password-toggle-btn" aria-label="Show/hide password">
                          <input class="password-toggle-check" type="checkbox"><span class="password-toggle-indicator"></span>
                        </label>
                                        </div>
                                    </div>
                                    <div class="mb-4">
                                        <label class="form-label text-light" for="signup-password-confirm">Confirm password</label>
                                        <div class="password-toggle">
                                            <input class="form-control form-control-light" type="password" id="signup-password-confirm" minlength="8" required>
                                            <label class="password-toggle-btn" aria-label="Show/hide password">
                          <input class="password-toggle-check" type="checkbox"><span class="password-toggle-indicator"></span>
                        </label>
                                        </div>
                                    </div>
                                    <div class="form-check form-check-light mb-4">
                                        <input class="form-check-input" type="checkbox" id="agree-to-terms" required>
                                        <label class="form-check-label" for="agree-to-terms"><span class='opacity-70'>By joining, I agree to the</span> <a href='#' class='text-light'>Terms of use</a> <span class='opacity-70'>and</span> <a href='#' class='text-light'>Privacy policy</a></label>
                                    </div>
                                    <button class="btn btn-primary btn-lg w-100" type="submit">Sign up         </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Navbar-->
        <header class="navbar navbar-expand-lg navbar-dark fixed-top" data-scroll-header>
            <div class="container">
                <a class="navbar-brand me-3 me-xl-4" href="car-finder-home.html"><img class="d-block" src="img/logo/logo-light.svg" width="116" alt="Finder"></a>
                <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <a class="btn btn-link btn-light btn-sm d-none d-lg-block order-lg-3" href="#signin-modal" data-bs-toggle="modal"><i class="fi-user me-2"></i>Sign in</a>
                <a class="btn btn-primary btn-sm ms-2 order-lg-3" href="car-finder-sell-car.html"><i class="fi-plus me-2"></i>Sell car</a>
                <div class="collapse navbar-collapse order-lg-2" id="navbarNav">
                    <ul class="navbar-nav navbar-nav-scroll" style="max-height: 35rem;">
                        <!-- Demos switcher-->
                        <li class="nav-item dropdown me-lg-2"><a class="nav-link dropdown-toggle align-items-center pe-lg-4" href="#" data-bs-toggle="dropdown" role="button" aria-expanded="false"><i class="fi-layers me-2"></i>Demos<span class="d-none d-lg-block position-absolute top-50 end-0 translate-middle-y border-end border-light" style="width: 1px; height: 30px;"></span></a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="real-estate-home-v1.html"><i class="fi-building fs-base me-2"></i>Real Estate Demo</a></li>
                                <li class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="car-finder-home.html"><i class="fi-car fs-base me-2"></i>Car Finder Demo</a></li>
                                <li class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="job-board-home-v1.html"><i class="fi-briefcase fs-base me-2"></i>Job Board Demo</a></li>
                                <li class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="city-guide-home-v1.html"><i class="fi-map-pin fs-base me-2"></i>City Guide Demo</a></li>
                                <li class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="index.html"><i class="fi-home fs-base me-2"></i>Main Page</a></li>
                                <li><a class="dropdown-item" href="components/typography.html"><i class="fi-list fs-base me-2"></i>Components</a></li>
                                <li><a class="dropdown-item" href="docs/dev-setup.html"><i class="fi-file fs-base me-2"></i>Documentation</a></li>
                            </ul>
                        </li>
                        <!-- Menu items-->
                        <li class="nav-item"><a class="nav-link" href="car-finder-home.html">Home</a></li>
                        <li class="nav-item dropdown active"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Catalog</a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="car-finder-catalog-list.html">List View</a></li>
                                <li><a class="dropdown-item" href="car-finder-catalog-grid.html">Grid View</a></li>
                                <li><a class="dropdown-item" href="car-finder-single.html">Car Single Page</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Account</a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="car-finder-account-info.html">Personal Info</a></li>
                                <li><a class="dropdown-item" href="car-finder-account-security.html">Password &amp; Security</a></li>
                                <li><a class="dropdown-item" href="car-finder-account-cars.html">My Cars</a></li>
                                <li><a class="dropdown-item" href="car-finder-account-wishlist.html">Wishlist</a></li>
                                <li><a class="dropdown-item" href="car-finder-account-reviews.html">Reviews</a></li>
                                <li><a class="dropdown-item" href="car-finder-account-notifications.html">Notifications</a></li>
                                <li><a class="dropdown-item" href="signin-dark.html">Sign In</a></li>
                                <li><a class="dropdown-item" href="signup-dark.html">Sign Up</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Vendor</a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="car-finder-sell-car.html">Sell Car</a></li>
                                <li><a class="dropdown-item" href="car-finder-promotion.html">Ad Promotion Page</a></li>
                                <li><a class="dropdown-item" href="car-finder-vendor.html">Vendor Page</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Pages</a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="car-finder-about.html">About</a></li>
                                <li class="dropdown"><a class="dropdown-item dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Blog</a>
                                    <ul class="dropdown-menu dropdown-menu-dark">
                                        <li><a class="dropdown-item" href="car-finder-blog.html">Blog Grid</a></li>
                                        <li><a class="dropdown-item" href="car-finder-blog-single.html">Single Post</a></li>
                                    </ul>
                                </li>
                                <li><a class="dropdown-item" href="car-finder-contacts.html">Contacts</a></li>
                                <li><a class="dropdown-item" href="car-finder-help-center.html">Help Center</a></li>
                                <li><a class="dropdown-item" href="car-finder-404.html">404 Not Found</a></li>
                            </ul>
                        </li>
                        <li class="nav-item d-lg-none"><a class="nav-link" href="#signin-modal" data-bs-toggle="modal"><i class="fi-user me-2"></i>Sign in</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <!-- Page content-->
        <!-- Page container-->
        <div class="container mt-5 mb-md-4 py-5">
            <div class="row py-md-1">

                <!-- Catalog grid view-->
                <!-- Page title-->
                <div class="d-flex align-items-center justify-content-between pb-3 mb-2 mt-5 pt-5" style="padding: 19%;">
                    <h1 class="text-light me-3 mt-1 mb-0">상품 목록</h1>
                    <!-- <div class="text-light">
                        <i class="fi-car fs-lg me-2"></i>
                        <span class="align-middle me-5">249 offers</span>
                    </div> -->
                </div>

                <div class="col-lg-9" style="padding-left: 20%;">
                    <!-- Breadcrumb-->
                    <nav class="mb-3 pt-md-2 pt-lg-1" aria-label="Breadcrumb">
                        <ol class="breadcrumb breadcrumb-light">
                            <li class="breadcrumb-item"><a href="car-finder-home.html">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">상품 목록</li>
                        </ol>
                    </nav>
                    <!-- Sorting + View-->
                    <div class="d-sm-flex align-items-center justify-content-between pb-4 mb-2">
                        <div class="d-flex align-items-center me-sm-4">
                            <label class="fs-sm text-light me-2 pe-1 mt-1 text-nowrap" for="sorting1">
                                <!-- <i class="fi-checkbox-checked mt-n1 me-2"></i> -->
                                카테고리 선택
                            </label>

                            <div class="d-none d-md-block border-end border-light m-lg-4" style="height: 1.25rem;"></div>
                            <select name="categories" onchange="if(this.value)location.href(this.value);" class="form-select form-select-light form-select-sm me-sm-4">
                                <option value="11.souvenirProductsListAll.html"> 전체</option>
                                <option value="http://www.naver.com">유아/DIY</option>
                                <option value="11.souvenirProductsListOffice.html">사무/문구</option>
                                <option value=""><a herf="11.souvenirProductsListBeauty">뷰티/미용</a></option>
                                <option value=""><a herf="11.souvenirProductsListFashion">패션/잡화</a></option>
                                <option value=""><a herf="11.souvenirProductsListLife">생활/데코</a></option>
                                <option value=""><a herf="11.souvenirProductsListElect">전자/IT</a></option>
                                </select>
                            <!-- <div class="d-none d-sm-block fw-bold text-light opacity-70 text-nowrap ps-md-4">
                                <i class="fi-switch-horizontal me-2"></i><span class="align-middle">Compare (0)</span>
                            </div> -->
                        </div>
                        <!-- <div class="d-none d-sm-flex">
                            <a class="nav-link nav-link-light px-2" href="car-finder-catalog-list.html" data-bs-toggle="tooltip" title="List view">
                                <i class="fi-list"></i></a>
                                
                                <a class="nav-link nav-link-light px-2 active" href="car-finder-catalog-grid.html"
                                data-bs-toggle="tooltip" title="Grid view"><i class="fi-grid"></i></a>
                            </div> -->
                    </div>
                    <div class="row">

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">

                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="12.souvenirProductsDetail2.html"></a>
                                    <div class="position-absolute start-0 top-0 pt-3 ps-3">
                                        <!-- <span class="d-table badge bg-info">Used</span> -->
                                    </div>
                                    <!-- <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                        <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                    </div> -->
                                    <div class="tns-carousel-inner">
                                        <img src="img/naim/10.souvir.best2.png" alt="Image">
                                        <img src="img/naim/10.souvir.best22.png" alt="Image">
                                    </div>
                                </div>

                                <!-- 상품 박스 설명 시작 -->
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare1"> -->
                                            <!-- <label class="form-check-label fs-sm" for="compare1">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="12.souvenirProductsDetail2.html" style="color: #A08DB4;">일월오봉도 한지조명</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">110,000원</div>
                                    <div class="fs-sm text-light opacity-70">
                                    </div>
                                </div>
                                <!-- 상품 박스 설명 끝 -->

                                <!-- 상품 박스 하단 버튼 시작 -->
                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="02.myPageCart.html" class="nav-link-light">장바구니</a></span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="12.souvenirProductsDetail2.html" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            <!-- <div class="col">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-petrol d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">Diesel</span></div>
                                            </div> -->
                                        </div>
                                    </div>
                                </div>
                                <!-- 상품 박스 하단 버튼 끝 -->

                            </div>
                        </div>

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">
                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="12.souvenirProductsDetail3.html"></a>
                                    <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info mb-1">Used</span><span class="d-table badge bg-success" data-bs-toggle="popover" data-bs-placement="bottom" data-bs-trigger="hover" data-bs-html="true" data-bs-content="&lt;div class=&quot;d-flex&quot;&gt;&lt;i class=&quot;fi-award mt-1 me-2&quot;&gt;&lt;/i&gt;&lt;div&gt;This car is checked and&lt;br&gt;certified by Finder.&lt;/div&gt;&lt;/div&gt;">Certified</span></div> -->
                                    <!-- <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                        <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                    </div> -->
                                    <div class="tns-carousel-inner">
                                        <img src="img/naim/10.souvir.best3.png" alt="Image">
                                        <img src="img/naim/10.souvir.best3.png" alt="Image"></div>
                                </div>

                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare2">
                                            <label class="form-check-label fs-sm" for="compare2">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="12.souvenirProductsDetail3.html" style="color: #A08DB4;">일월오봉도 부채</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">6,500원</div>
                                    <!-- <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>San Francisco</div> -->
                                </div>


                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <span class="fs-xs text-light">
                                                        <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                        <a href="02.myPageCart.html" class="nav-link-light">장바구니</a>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="12.souvenirProductsDetail2.html" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            <!-- <div class="col">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-petrol d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">Hybrid</span></div>
                                            </div> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">
                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="12.souvenirProductsDetail3.html"></a>
                                    <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info mb-1">Used</span><span class="d-table badge bg-success" data-bs-toggle="popover" data-bs-placement="bottom" data-bs-trigger="hover" data-bs-html="true" data-bs-content="&lt;div class=&quot;d-flex&quot;&gt;&lt;i class=&quot;fi-award mt-1 me-2&quot;&gt;&lt;/i&gt;&lt;div&gt;This car is checked and&lt;br&gt;certified by Finder.&lt;/div&gt;&lt;/div&gt;">Certified</span></div> -->
                                    <!-- <div class="content-overlay end-0 top-0 pt-3 pe-3">
                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
            </div> -->
                                    <div class="tns-carousel-inner">
                                        <img src="img/naim/10.souvir.best3.png" alt="Image">
                                        <img src="img/naim/10.souvir.best3.png" alt="Image"></div>
                                </div>

                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare2">
                    <label class="form-check-label fs-sm" for="compare2">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="12.souvenirProductsDetail3.html" style="color: #A08DB4;">일월오봉도 부채</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">6,500원</div>
                                    <!-- <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>San Francisco</div> -->
                                </div>


                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <span class="fs-xs text-light">
                                <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                <a href="02.myPageCart.html" class="nav-link-light">장바구니</a>
                            </span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="12.souvenirProductsDetail2.html" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            <!-- <div class="col">
                        <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-petrol d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">Hybrid</span></div>
                    </div> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">

                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="12.souvenirProductsDetail2.html"></a>
                                    <div class="position-absolute start-0 top-0 pt-3 ps-3">
                                        <!-- <span class="d-table badge bg-info">Used</span> -->
                                    </div>
                                    <!-- <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                                                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                                            </div> -->
                                    <div class="tns-carousel-inner">
                                        <img src="img/naim/10.souvir.best2.png" alt="Image">
                                        <img src="img/naim/10.souvir.best22.png" alt="Image">
                                    </div>
                                </div>

                                <!-- 상품 박스 설명 시작 -->
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare1"> -->
                                            <!-- <label class="form-check-label fs-sm" for="compare1">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="12.souvenirProductsDetail2.html" style="color: #A08DB4;">일월오봉도 한지조명</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">110,000원</div>
                                    <div class="fs-sm text-light opacity-70">
                                    </div>
                                </div>
                                <!-- 상품 박스 설명 끝 -->

                                <!-- 상품 박스 하단 버튼 시작 -->
                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="02.myPageCart.html" class="nav-link-light">장바구니</a></span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="12.souvenirProductsDetail2.html" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <!-- 상품 박스 하단 버튼 끝 -->

                            </div>
                        </div>
                    </div>
                    <!-- Sorting + Pagination-->
                    <div class="d-flex align-items-center justify-content-between py-2">

                        <nav aria-label="Pagination">
                            <ul class="pagination pagination-light mb-0">
                                <li class="page-item d-sm-none text-nowrap"><span class="page-link page-link-static">1 / 5</span></li>
                                <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                                </li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                                <li class="page-item d-none d-sm-block">...</li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                                <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i class="fi-chevron-right"></i></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Footer-->
    <footer class="footer bg-faded-light">
        <div class="border-bottom border-light py-4">
            <div class="container d-sm-flex align-items-center justify-content-between">
                <a class="d-inline-block" href="real-estate-home-v1.html"><img src="img/logo/logo-light.svg" width="116" alt="logo"></a>
                <div class="d-flex pt-3 pt-sm-0">
                    <div class="dropdown ms-n3">
                        <button class="btn btn-light btn-link btn-sm dropdown-toggle fw-normal py-2" type="button" data-bs-toggle="dropdown"><i class="fi-globe me-2"></i>Eng</button>
                        <div class="dropdown-menu dropdown-menu-dark w-100"><a class="dropdown-item" href="#">Deutsch</a><a class="dropdown-item" href="#">Français</a><a class="dropdown-item" href="#">Español</a></div>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-light btn-link btn-sm dropdown-toggle fw-normal py-2 pe-0" type="button" data-bs-toggle="dropdown">
                            <i class="fi-map-pin me-2"></i>New York</button>
                        <div class="dropdown-menu dropdown-menu-dark dropdown-menu-sm-end" style="min-width: 7.5rem;"><a class="dropdown-item" href="#">Chicago</a><a class="dropdown-item" href="#">Dallas</a><a class="dropdown-item" href="#">Los Angeles</a><a class="dropdown-item" href="#">San Diego</a></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pt-4 pb-3 pt-lg-5 pb-lg-4">
            <div class="row pt-2 pt-lg-0">
                <div class="col-lg-3 pb-2 mb-4">
                    <h3 class="h5 text-light mb-2">Subscribe to our newsletter</h3>
                    <p class="fs-sm text-light opacity-70">Don’t miss any relevant offers!</p>
                    <form class="form-group form-group-light w-100">
                        <div class="input-group input-group-sm"><span class="input-group-text"> <i class="fi-mail"></i></span>
                            <input class="form-control" type="text" placeholder="Your email">
                        </div>
                        <button class="btn btn-primary btn-icon btn-sm" type="button"><i class="fi-send"></i></button>
                    </form>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6 offset-xl-1 mb-2 mb-sm-4">
                    <h3 class="fs-base text-light">Buying &amp; Selling</h3>
                    <ul class="list-unstyled fs-sm">
                        <li><a class="nav-link-light" href="#">Find a car</a></li>
                        <li><a class="nav-link-light" href="#">Sell your car</a></li>
                        <li><a class="nav-link-light" href="#">Car dealers</a></li>
                        <li><a class="nav-link-light" href="#">Compare cars</a></li>
                        <li><a class="nav-link-light" href="#">Online car appraisal</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6 mb-2 mb-sm-4">
                    <h3 class="fs-base text-light">About</h3>
                    <ul class="list-unstyled fs-sm">
                        <li><a class="nav-link-light" href="#">About Finder</a></li>
                        <li><a class="nav-link-light" href="#">Contact us</a></li>
                        <li><a class="nav-link-light" href="#">FAQs &amp; support</a></li>
                        <li><a class="nav-link-light" href="#">Mobile app</a></li>
                        <li><a class="nav-link-light" href="#">Blog</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6 mb-2 mb-sm-4">
                    <h3 class="fs-base text-light">Profile</h3>
                    <ul class="list-unstyled fs-sm">
                        <li><a class="nav-link-light" href="#">My account</a></li>
                        <li><a class="nav-link-light" href="#">Wishlist</a></li>
                        <li><a class="nav-link-light" href="#">My listings</a></li>
                        <li><a class="nav-link-light" href="#">Add listing</a></li>
                    </ul>
                </div>
                <div class="col-xl-2 col-lg-3 col-sm-6 col-md-3 mb-2 mb-sm-4"><a class="d-flex align-items-center text-decoration-none mb-2" href="tel:4065550120"><i class="fi-device-mobile me-2"></i><span class="text-light">(406) 555-0120</span></a><a class="d-flex align-items-center text-decoration-none mb-2"
                        href="mailto:example@email.com"><i class="fi-mail me-2"></i><span class="text-light">example@email.com</span></a>
                    <div class="d-flex flex-wrap pt-4"><a class="btn btn-icon btn-translucent-light btn-xs rounded-circle mb-2 me-2" href="#"><i class="fi-facebook"></i></a><a class="btn btn-icon btn-translucent-light btn-xs rounded-circle mb-2 me-2" href="#"><i class="fi-twitter"></i></a>
                        <a class="btn btn-icon btn-translucent-light btn-xs rounded-circle mb-2 me-2" href="#"><i class="fi-telegram"></i></a><a class="btn btn-icon btn-translucent-light btn-xs rounded-circle mb-2" href="#"><i class="fi-messenger"></i></a></div>
                </div>
            </div>
        </div>
        <div class="container d-lg-flex align-items-center justify-content-between fs-sm pb-3">
            <div class="d-flex flex-wrap justify-content-center order-lg-2 mb-3"><a class="nav-link nav-link-light fw-normal" href="#">Terms of use</a><a class="nav-link nav-link-light fw-normal" href="#">Privacy policy</a><a class="nav-link nav-link-light fw-normal" href="#">Accessibility statement</a><a class="nav-link nav-link-light fw-normal pe-0"
                    href="#">Interest based ads</a></div>
            <p class="text-center text-lg-start order-lg-1 mb-lg-0"><span class="text-light opacity-50">&copy; All rights reserved. Made by </span><a class="nav-link-light fw-bold" href="https://createx.studio/" target="_blank" rel="noopener">Createx Studio</a></p>
        </div>
    </footer>
    <%@include file="/views/common/footer.jsp"%>
    <!-- Filters sidebar toggle button (mobile)-->
    <button class="btn btn-primary btn-sm w-100 rounded-0 fixed-bottom d-lg-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#filters-sidebar"><i class="fi-filter me-2"></i>Filters</button>
    <!-- Back to top button--><a class="btn-scroll-top" href="#top" data-scroll><span class="btn-scroll-top-tooltip text-muted fs-sm me-2">Top</span><i class="btn-scroll-top-icon fi-chevron-up">   </i></a>
    <!-- Vendor scrits: js libraries and plugins-->
    <script src="vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/simplebar/dist/simplebar.min.js"></script>
    <script src="vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>
    <script src="vendor/tiny-slider/dist/min/tiny-slider.js"></script>
    <script src="vendor/nouislider/dist/nouislider.min.js"></script>
    <!-- Main theme script-->
    <script src="js/theme.min.js"></script>
</body>

</html>