<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/views/common/headerLight.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>제 2호 상품 상세</title>
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
    <link rel="stylesheet" media="screen" href="vendor/lightgallery/css/lightgallery-bundle.min.css" />
    <!-- Main Theme Styles + Bootstrap-->
    <link rel="stylesheet" media="screen" href="css/theme.min.css">
</head>
<!-- Body-->

<body class="bg-dark">
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
                        <li class="nav-item"><a class="nav-link" href="10.souvenirMain.html">Home</a></li>
                        <li class="nav-item dropdown active"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Catalog</a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                            
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
        <!-- Page content-->
        <div class="container mt-5 mb-md-4 py-5 ps-5">
            <!-- Breadcrumb-->
            <nav class="mb-3 pt-md-3" aria-label="Breadcrumb">
                <ol class="breadcrumb breadcrumb-light">
                    <li class="breadcrumb-item"><a href="10.souvenirMain.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="car-finder-catalog-grid.html">생활/데코</a></li>
                    <li class="breadcrumb-item active" aria-current="page">일월오봉도 한지조명</li>
                </ol>
            </nav>
            <!-- Title + Sharing-->
            <div class="d-sm-flex align-items-end align-items-md-center justify-content-between position-relative mb-4" style="z-index: 1025;">
                <div class="me-3">
                    <h1 class="h2 text-light mb-md-0" style="color: #C389FF;"> 일월오봉도 한지조명</h1>
                    <div class="d-md-none">
                        <div class="d-flex align-items-center mb-3">
                            <div class="h3 mb-0 text-light">110,000원</div>
                            <div class="text-nowrap ps-3"></div>
                        </div>
                        <div class="d-flex flex-wrap align-items-center text-light mb-2">
                            <div class="text-nowrap border-end border-light pe-3 me-3">
                                <i class="fi-list fs-lg opacity-70 me-2"></i>
                                <span class="align-middle">생활/데코</span>
                            </div>
                            <div class="text-nowrap">
                                <i class="fi-list fs-lg opacity-70 me-2"></i>
                                <span class="align-middle">Chicago, IL 60603</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-nowrap pt-3 pt-sm-0">
                  
                    <div class="dropdown d-inline-block" data-bs-toggle="tooltip" title="Share">
                        
                        <div class="dropdown-menu dropdown-menu-dark dropdown-menu-end my-1">
                            
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-7">
                    <!-- Gallery-->
                    <div class="tns-carousel-wrapper">
                        <div class="tns-slides-count text-light">
                            <i class="fi-image fs-lg me-2"></i>
                            <div class="ps-1"><span class="tns-current-slide fs-5 fw-lighter"></span>
                                <span class="fs-5 fw-lighter">/</span>
                                <span class="tns-total-slides fs-5 fw-lighter"></span>
                            </div>
                        </div>
                        <div class="tns-carousel-inner" data-carousel-options="{&quot;navAsThumbnails&quot;: true, &quot;navContainer&quot;: &quot;#thumbnails&quot;, &quot;gutter&quot;: 12, &quot;responsive&quot;: {&quot;0&quot;:{&quot;controls&quot;: false},&quot;500&quot;:{&quot;controls&quot;: true}}}">
                            <div><img class="rounded-3" src="img/naim/12.bigSouvenirProductsDetailThumb1.png" alt="Image"></div>
                            <div><img class="rounded-3" src="img/naim/12.bigSouvenirProductsDetailThumb2.png" alt="Image"></div>
                            <div><img class="rounded-3" src="img/naim/12.bigSouvenirProductsDetailThumb3.png" alt="Image"></div>
                            <div><img class="rounded-3" src="img/naim/12.bigSouvenirProductsDetailThumb4.png" alt="Image"></div>
                            <div><img class="rounded-3" src="img/naim/12.bigSouvenirProductsDetailThumb5.png" alt="Image"></div>
                            
                        </div>
                    </div>
                    <ul class="tns-thumbnails" id="thumbnails">
                        <li class="tns-thumbnail"><img src="img/naim/12.bigSouvenirProductsDetailThumb1.png" alt="Thumbnail"></li>
                        <li class="tns-thumbnail"><img src="img/naim/12.bigSouvenirProductsDetailThumb2.png" alt="Thumbnail"></li>
                        <li class="tns-thumbnail"><img src="img/naim/12.bigSouvenirProductsDetailThumb3.png" alt="Thumbnail"></li>
                        <li class="tns-thumbnail"><img src="img/naim/12.bigSouvenirProductsDetailThumb4.png" alt="Thumbnail"></li>
                        <li class="tns-thumbnail"><img src="img/naim/12.bigSouvenirProductsDetailThumb5.png" alt="Thumbnail"></li>
                        
                    </ul>
                    

                    <!-- 배송 및 교환환불 시작-->
                    <div class="pb-4 mb-3">
                        <h2 class="h4 text-light pt-4 mt-3">배송 정보</h2>
                        <p class="text-light opacity-70 mb-1">
                            <div class="col-11">
                                <ul>
                                    <li>배송 방법 : 로젠택배 (타택배사 발송 불가)</li>
                                    <li>배송 지역 : 전국지역</li>
                                    <li>배송 비용 : 3,000원</li>
                                    <li>배송 기간 : 3일 ~ 7일</li>
                                    <li>무형문화재 작품의 경우 주문 후 제작되므로 7~20일 정도 소요될 수 있습니다.</li>
                                    <li>주문하신 상품에 따라서 상품의 배송이 다소 지연될 수 있습니다.</li>
                                </ul>
                            </div>
                        </p>
                        <div class="collapse" id="seeMoreDescription">
                            <h2 class="h4 text-light pt-4 mt-3">교환 및 반품정보</h2>
                            <p class="text-light opacity-70 mb-1">
                                <div class="col-11">
                                    <ul>
                                        <li><b>교환 및 반품이 불가능한 경우</b>
                                            <p class="mb-2 mt-2"> - 계약내용에 관한 서면을 받은 날부터 7일. 단, 그 서면을 받은 때보다 재화등의 공급이 늦게 이루어진 경우에는 재화등을 공급받거나 재화등의 공급이 시작된 날부터 7일 이내</p>
                                            <p class="mb-2"> - 공급받으신 상품 및 용역의 내용이 표시.광고 내용과 다르거나 계약내용과 다르게 이행된 때에는 당해 재화 등을 공급받은 날 부터 3월이내, 그사실을 알게 된 날 또는 알 수 있었던 날부터 30일이내</p>
                                        </li>
                                        <p></p>
                                        <li><b>교환 및 반품이 불가능한 경우</b>
                                            <p class="mb-2 mt-2"> - 이용자에게 책임 있는 사유로 재화 등이 멸실 또는 훼손된 경우</p>
                                            <p class="mb-2"> - 이용자의 사용 또는 일부 소비에 의하여 재화 등의 가치가 현저히 감소한 경우</p>
                                            <p class="mb-2"> - 개별 주문 생산되는 재화 등 청약철회시 판매자에게 회복할 수 없는 피해가 예상되어 소비자의 사전 동의를 얻은 경우</p>
                                        </li>
                                    </ul>
                                </div>
                            </p>
                        </div>
                        <a class="collapse-label collapsed" href="#seeMoreDescription" data-bs-toggle="collapse" data-bs-label-collapsed="Show more" data-bs-label-expanded="Show less" role="button" aria-expanded="false" aria-controls="seeMoreDescription"></a>
                    </div>
                    <!-- 배송 및 교환환불 끝-->

                    <!-- Post meta-->
                    <div class="d-flex flex-wrap border-top border-light fs-sm text-light pt-4 pb-5 pb-md-2">
                        <div class="border-end border-light pe-3 me-3">
                            <span class="opacity-70">Published: <strong>May 9, 2021</strong></span>
                        </div>
                        <div class="border-end border-light pe-3 me-3">
                            <span class="opacity-70">Product number: <strong>681013232</strong></span>
                        </div>
                        
                    </div>
                </div>
                <!-- Sidebar-->
                <div class="col-md-4 pt-5 pt-md-0" style="margin-top: -6rem;">
                    <div class="sticky-top pt-5">
                        <div class="d-none d-md-block pt-5 ms-4">
                            
                            <div class="h3 text-light" style="padding-top: 1%;">일월오봉도 한지조명</div>
                            <div class="h5 text-danger"> 110,000원</div>
                            <div class="d-flex align-items-center text-light pb-4 mb-2">
                                <div class="text-nowrap border-end border-light pe-3 me-3">
                                    <i class="fi-list fs-lg opacity-70 me-2"></i>
                                    <span class="align-middle">생활/데코</span>
                                </div>
                                <div class="text-nowrap">
                                    <!-- <i class="fi-chevron-right fs-lg opacity-70 me-2"></i> -->
                                    <span class="text-light align-middle">아늑한, 따뜻한</span>

                                    <!-- <a href="#" class="align-middle icon-box card card-light flex-row align-items-center card-hover rounded-pill py-2 ps-2 pe-4">
                                        <div class="icon-box-media bg-faded-light text-light rounded-circle me-2 fs-lg opacity-70">
                                            <i class="fi-map-pin fs-lg opacity-70 me-2"></i>
                                        </div>
                                        <h3 class="icon-box-title fs-sm text-light ps-1 mb-0">Pill icon box</h3>
                                    </a> -->
                                </div>
                            </div>
                        </div>
                        <div style="align-content: center;">
                            
                            <div class="mt-2" style="text-align: center;">
                                <button class="btn btn-outline-light btn-lg mb-4 me-5" type="button" style="padding-left: 25%; padding-right : 25%">
                                  <i class="fi-cart me-2">&nbsp 장바구니</i></button>
                                <br>
                                <a class="btn btn-lg me-5" href="13.souvenirCheckout" data-bs-toggle="collapse" style="background-color: #C389FF; color: #fff; padding-left: 25%; padding-right : 25%;">
                                    <i class="fi-credit-card me-2" style="text-align: center;">&nbsp 구매하기</i></a>
                               
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>

            <!-- 이런상품들은 어때요 시작-->
            <h2 class="h3 text-light pt-5 pb-1 mt-md-4">You may be interested in</h2>
            <h5 class="h5 text-light pb-3">이런 상품들은 어때요?</h2>
                <div class="tns-carousel-wrapper tns-controls-outside-xxl tns-nav-outside tns-carousel-light">
                    <div class="tns-carousel-inner" data-carousel-options="{&quot;items&quot;: 3, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1, &quot;gutter&quot;: 16},&quot;500&quot;:{&quot;items&quot;:2, &quot;gutter&quot;: 18},&quot;900&quot;:{&quot;items&quot;:3, &quot;gutter&quot;: 20}, &quot;1100&quot;:{&quot;gutter&quot;: 24}}}">
                        <div>
                            <div class="card card-light card-hover h-100">
                                <div class="card-img-top card-img-hover">
                                    <a class="img-overlay" href="12.souvenirProductsDetail3.html"></a>
                                    
                                    <img src="img/naim/10.souvir.best3.png" alt="Image">
                                </div>

                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                           
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="12.souvenirProductsDetail3.html" style="color: #A08DB4;">일월오봉도 부채</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">6,500원</div>
                                    
                                </div>

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

                        <div>
                            <div class="card card-light card-hover h-100">
                                <div class="card-img-top card-img-hover">
                                    <a class="img-overlay" href="#"></a>
                                    <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info mb-1">Used</span>
                                        <span class="d-table badge bg-success" data-bs-toggle="popover" data-bs-placement="bottom" data-bs-trigger="hover" data-bs-html="true" data-bs-content="&lt;div class=&quot;d-flex&quot;&gt;&lt;i class=&quot;fi-award mt-1 me-2&quot;&gt;&lt;/i&gt;&lt;div&gt;This car is checked and&lt;br&gt;certified by Finder.&lt;/div&gt;&lt;/div&gt;">Certified</span></div> -->
                                    <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                        <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                    </div><img src="img/car-finder/catalog/05.jpg" alt="Image">
                                </div>
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1"><span class="fs-sm text-light me-3">2018</span>
                                        <div class="form-check form-check-light">
                                            
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1"><a class="nav-link-light" href="#">BMW 640 XI Gran Turismo</a></h3>
                                    <div class="text-primary fw-bold mb-1">$43,500</div>
                                    <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>San Francisco</div>
                                </div>

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
                        <div>
                            <div class="card card-light card-hover h-100">
                                <div class="card-img-top card-img-hover">
                                    <a class="img-overlay" href="#"></a>
                                    <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info">Used</span></div> -->
                                    <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                        <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                    </div><img src="img/car-finder/catalog/04.jpg" alt="Image">
                                </div>
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1"><span class="fs-sm text-light me-3">2019</span>
                                        <div class="form-check form-check-light">
                                            
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1"><a class="nav-link-light" href="#">Nissan 370Z Nismo</a></h3>
                                    <div class="text-primary fw-bold mb-1">$37,900</div>
                                    <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>New York</div>
                                </div>

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
                        <div>
                            <div class="card card-light card-hover h-100">
                                <div class="card-img-top card-img-hover">
                                    <a class="img-overlay" href="#"></a>
                                    <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info">Used</span></div>
                                    <div class="content-overlay end-0 top-0 pt-3 pe-3">
                                        <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle" type="button" data-bs-toggle="tooltip" data-bs-placement="left" title="Add to Wishlist"><i class="fi-heart"></i></button>
                                    </div><img src="img/car-finder/catalog/08.jpg" alt="Image">
                                </div>
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1"><span class="fs-sm text-light me-3">2017</span>
                                        <div class="form-check form-check-light">
                                            <input class="form-check-input" type="checkbox" id="compare4">
                                            <label class="form-check-label fs-sm" for="compare4">Compare</label>
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1"><a class="nav-link-light" href="#">Ford Explorer XLT</a></h3>
                                    <div class="text-primary fw-bold mb-1">$26,950</div>
                                    <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>Kansas</div>
                                </div>
                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-dashboard d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">34K mi</span></div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-gearbox d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">Manual</span></div>
                                            </div>
                                            <div class="col">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2"><i class="fi-petrol d-block h4 text-light mb-0 mx-center"></i><span class="fs-xs text-light">Diesel</span></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </main>
    <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>
    
    <!-- Back to top button--><a class="btn-scroll-top" href="#top" data-scroll><span class="btn-scroll-top-tooltip text-muted fs-sm me-2">Top</span><i class="btn-scroll-top-icon fi-chevron-up">   </i></a>
    <!-- Vendor scrits: js libraries and plugins-->
    <script src="vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/simplebar/dist/simplebar.min.js"></script>
    <script src="vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>
    <script src="vendor/tiny-slider/dist/min/tiny-slider.js"></script>
    <script src="vendor/lightgallery/lightgallery.min.js"></script>
    <script src="vendor/lightgallery/plugins/video/lg-video.min.js"></script>
    <!-- Main theme script-->
    <script src="js/theme.min.js"></script>
</body>

</html>