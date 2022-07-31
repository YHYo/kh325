<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/views/common/headerLight.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>결제창</title>
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
    <link rel="stylesheet" media="screen" href="vendor/leaflet/dist/leaflet.css" />
    <link rel="stylesheet" media="screen" href="vendor/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css" />
    <link rel="stylesheet" media="screen" href="vendor/filepond/dist/filepond.min.css" />
    <link rel="stylesheet" media="screen" href="vendor/tiny-slider/dist/tiny-slider.css" />
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
        <!-- Navbar-->
        <header class="navbar navbar-expand-lg navbar-dark fixed-top" data-scroll-header>
            <div class="container">
                <a class="navbar-brand me-3 me-xl-4" href="car-finder-home.html"><img class="d-block" src="img/logo/logo-light.svg" width="116" alt="Finder"></a>
                <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="dropdown d-none d-lg-block order-lg-3 my-n2 me-3">
                    <a class="d-block py-2" href="car-finder-account-info.html"><img class="rounded-circle" src="img/avatars/02.jpg" width="40" alt="Robert Fox"></a>
                    <div class="dropdown-menu dropdown-menu-dark dropdown-menu-end">
                        <div class="d-flex align-items-start border-bottom border-light px-3 py-1 mb-2" style="width: 16rem;"><img class="rounded-circle" src="img/avatars/01.jpg" width="48" alt="Robert Fox">
                            <div class="ps-2">
                                <h6 class="fs-base text-light mb-0">Robert Fox</h6><span class="star-rating star-rating-sm"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span>
                                <div class="fs-xs py-2">(302) 555-0107<br>robert_fox@email.com</div>
                            </div>
                        </div><a class="dropdown-item" href="car-finder-account-info.html"><i class="fi-user me-2"></i>Personal Info</a><a class="dropdown-item" href="car-finder-account-security.html"><i class="fi-lock me-2"></i>Password &amp; Security</a>
                        <a class="dropdown-item" href="car-finder-account-cars.html"><i class="fi-car me-2"></i>My Cars</a><a class="dropdown-item" href="car-finder-account-wishlist.html"><i class="fi-heart me-2"></i>Wishlist<span class="badge bg-faded-light ms-2">4</span></a>
                        <a class="dropdown-item" href="car-finder-account-reviews.html"><i class="fi-star me-2"></i>Reviews</a><a class="dropdown-item" href="car-finder-account-notifications.html"><i class="fi-bell me-2"></i>Notifications</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item" href="car-finder-help-center.html">Help</a><a class="dropdown-item" href="signin-dark.html">Sign Out</a>
                    </div>
                </div><a class="btn btn-primary btn-sm ms-2 order-lg-3" href="car-finder-sell-car.html"><i class="fi-plus me-2"></i>Sell car</a>
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
                        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Catalog</a>
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
                        <li class="nav-item dropdown active"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Vendor</a>
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
                        <li class="nav-item dropdown d-lg-none">
                            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><img class="rounded-circle me-2" src="img/avatars/02.jpg" width="30" alt="Robert Fox">Robert Fox</a>
                            <div class="dropdown-menu dropdown-menu-dark">
                                <div class="ps-3"><span class="star-rating star-rating-sm"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span>
                                    <div class="fs-xs py-2">(302) 555-0107<br>robert_fox@email.com</div>
                                </div><a class="dropdown-item" href="car-finder-account-info.html"><i class="fi-user me-2"></i>Personal Info</a><a class="dropdown-item" href="car-finder-account-security.html"><i class="fi-lock me-2"></i>Password &amp; Security</a>
                                <a class="dropdown-item" href="car-finder-account-cars.html"><i class="fi-car me-2"></i>My Cars</a><a class="dropdown-item" href="car-finder-account-wishlist.html"><i class="fi-heart me-2"></i>Wishlist<span class="badge bg-faded-light ms-2">4</span></a>
                                <a class="dropdown-item" href="car-finder-account-reviews.html"><i class="fi-star me-2"></i>Reviews</a><a class="dropdown-item" href="car-finder-account-notifications.html"><i class="fi-bell me-2"></i>Notifications</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="car-finder-help-center.html">Help</a><a class="dropdown-item" href="signin-dark.html">Sign Out</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
        <!-- Page content-->
        <!-- Page container-->
        <div class="container mt-5 mb-md-4 py-5">
            <div class="row">
                <!-- Page content-->
                <div class="col-lg-7">
                    <!-- Breadcrumb-->
                    <nav class="mb-3 pt-md-3" aria-label="Breadcrumb">
                        <ol class="breadcrumb breadcrumb-light">
                            <li class="breadcrumb-item"><a href="10.souvenirMain.html">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">결제 및 주문하기</li>
                        </ol>
                    </nav>
                    <!-- Title-->
                    <div class="mb-4">
                        <h1 class="h2 text-light mb-0">결제 및 주문하기</h1>
                        <div class="progress progress-light d-lg-none mb-4" style="height: .25rem;">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <!-- 기본정보 및 배송지 입력 시작-->
                    <section class="card card-light card-body border-0 shadow-sm p-4 mb-4" id="basic-info">
                        <h4 class="mb-4 mt-2" style="color: #C389FF;">기본정보 및 배송지</h4>
                        <!-- 이름 -->
                        <div class="row">
                            <div class="col-sm-6 mb-3">
                                <label class="form-label text-light mb-2 mt-2 ms-1" for="sc-fn">이름 (받는 사람) <span class="text-danger ms-1"> * </span></label>
                                <input class="form-control form-control-light" type="text" id="sc-fn" value="" placeholder="이름" required>
                            </div>
                            <!-- 주소 -->
                            <div class="row">
                                <div class="col-sm-6 mb-1">
                                    <label class="form-label text-light mb-2 mt-2 ms-1" for="sc-fn"> 주소 </label>
                                    <span class="text-danger ms-1"> * </span>
                                    <div class="d-flex align-items-center mb-1">
                                        <input class="form-control form-control-light me-2 mb-2" style="width: 40%;" type="text" id="sc-zip" value="" placeholder="우편번호">

                                    </div>
                                </div>
                                <div class="mb-3">
                                    <input class="form-control form-control-light" type="text" id="sc-address1" placeholder="기본 주소" value="" required>
                                </div>
                                <div class="mb-3">
                                    <input class="form-control form-control-light" type="text" id="sc-address1" placeholder="상세 주소" value="" required>
                                </div>
                            </div>
                        </div>
                        <!-- 연락처 -->
                        <div class="col-sm-6 mb-3">
                            <label class="form-label text-light mb-2 mt-2 ms-1" for="sc-phone"> 연락처 <span class="text-danger">&nbsp * </span></label>
                            <input class="form-control form-control-light" type="tel" id="sc-phone" data-format="custom" data-delimiter="-" data-blocks="3 4 4" value="" placeholder="000-0000-0000">
                        </div>
                        <!-- 이메일 -->
                        <div class="col-sm-6 mb-3">
                            <label class="form-label text-light mb-2 mt-2 ms-1" for="sc-email"> Email <span class="text-danger">&nbsp * </span></label>
                            <input class="form-control form-control-light" type="text" id="sc-email" value="" placeholder="이메일">
                        </div>

                    </section>
                    <!-- 기본정보 및 배송지 입력 끝-->
                    <!-- 카드정보입력 시작-->
                    <section class="card card-light card-body border-0 shadow-sm p-4 mb-4" id="card">
                        <h2 class="h4 mb-4 mt-2" style="color: #C389FF;">결제카드 정보</h2>
                        <label class="form-label text-light mb-2 ms-1" for="sc-card">카드 정보<span class="text-danger">&nbsp *</span></label>
                        <div class="d-sm-flex mb-2">
                            <select class="form-select form-select-light w-50 me-2 mb-2">
                          <option value="VISA">VISA</option>
                          <option value="MASTER">MASTER</option>
                          <option value="UNION-PAY">UNION-PAY</option>
                        </select>
                            <input class="form-control form-control-light w-100 me-2 mb-2" type="tel" id="sc-card" data-delimiter="-" data-blocks="4 4 4 4" data-format="custom" value="" placeholder="0000-0000-0000-0000" required>
                        </div>

                        <!-- 유효기간 & CVV 시작-->
                        <div class="row">
                            <div class="col-sm-4 mb-3">
                                <label class="form-label text-light mb-2 mt-1 ms-1" for="sc-card">유효기간<span class="text-danger">&nbsp *</span></label>
                                <input class="form-control form-control-light mb-2" style="width: 120%;" type="month" &gt data-delimiter="/" data-blocks="2 2" id="sc-expire" placeholder="MM/YY" required>

                                <label class="form-label text-light mb-2 mt-1 ms-1" for="sc-card">CVV<span class="text-danger">&nbsp *</span></label>
                                <input class="form-control form-control-light mb-3" style="width: 120%;" type="text" maxlength="3" id="sc-cvv" value="" placeholder="3자리" pattern="[0-9]{1}[0-9]{1}[0-9]{1}" required>
                            </div>
                            <!-- 유효기간 & CVV 끝-->
                            <!-- 결제 동의 시작 -->
                            <div class="border-light border-bottom-md"></div>
                            <div class="form-label text-light fw-bold pt-4 pb-2">위의 구매정보 및 당사의 결제정책에 대해 동의하십니까?</div>
                            <div class="form-check form-check-light ms-3">
                                <input class="form-check-input" type="radio" id="sc-dealer" name="sc-seller-type" checked>
                                <label class="form-check-label" for="sc-dealer">동의합니다</label>
                            </div>
                            <div class="form-check form-check-light ms-3 me-3 mb-5">
                                <input class="form-check-input" type="radio" id="sc-individual" name="sc-seller-type">
                                <label class="form-check-label" for="sc-individual">동의하지 않습니다</label>
                            </div>
                            <!-- 결제 동의 끝 -->
                            <div class="d-sm-flex justify-content-end pt-3 pb-1">
                                <a class="btn btn-outline-light btn-lg d-block mb-3 mb-sm-2 me-4" href="02.myPageCart.html" data-bs-toggle="modal">
                                    돌아가기</a>
                                <a class="btn btn-lg d-block mb-2" href="05.myPageOrder.html" style="background-color: #C389FF; color: #fff;">결제하기</a></div>
                        </div>
                    </section>
                </div>
                <!-- Progress of completion-->
                <aside class="col-lg-4 offset-lg-0 d-none d-lg-block pt-4 mt-3 mb-3">
                    <div class="sticky-top pt-5 ms-5">
                        <h5 class="text-light pt-5 mb-2">주문 내역</h5>

                        <ul class="list-unstyled mt-3">

                            <li class="d-flex align-items-start mt-4">
                                <img src="img/naim/10.souvir.best3.png" style="width: 132px; height: 83px">
                                <p class="col-lg-8 nav-link-light ps-1 ms-2" data-scroll data-scroll-offset="20">
                                    일월오봉도 부채</a><br>
                                    <a class="nav-link-light opacity-65" data-scroll data-scroll-offset="20"> 가격 : </a>
                                    <a class="nav-link-light ps-1 opacity-65" data-scroll data-scroll-offset="20"> 6,000원</a>
                            </li>

                            <li class="d-flex align-items-start mt-4">
                                <img src="img/naim/10.souvir.best3.png" style="width: 132px; height: 83px">
                                <p class="col-lg-8 nav-link-light ps-1 ms-2" data-scroll data-scroll-offset="20">
                                    일월오봉도 부채</a><br>
                                    <a class="nav-link-light opacity-65" data-scroll data-scroll-offset="20"> 가격 : </a>
                                    <a class="nav-link-light ps-1 opacity-65" data-scroll data-scroll-offset="20"> 6,000원</a>
                            </li>


                            <!-- 금액 시작 -->
                            <li class="d-flex justify-content-end mt-5 pt-3">
                                <a class="me-2" style="text-decoration: none; color: #898989;">배송비</a>
                                <a class="nav-link-light ps-1 justify-content-end" data-scroll data-scroll-offset="20">3,000원</a>
                            </li>
                            <li class="d-flex justify-content-end">
                                <a class="me-2" style="text-decoration: none; color: #898989;">구매액</a>
                                <a class="nav-link-light ps-1 justify-content-end" data-scroll data-scroll-offset="20">13,000원</a>
                            </li>
                            <div class="border-bottom border-secondary mt-4 mb-4" style="height: .25rem;"></div>
                            <li class="d-flex justify-content-end">
                                <a class="me-2 text-light" style="text-decoration: none;">총 구매액</a>
                                <a class="nav-link-light ps-1 justify-content-end text-light" data-scroll data-scroll-offset="20">16,000원</a>
                            </li>
                        </ul>
                    </div>
                </aside>
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
    <script src="vendor/leaflet/dist/leaflet.js"></script>
    <script src="vendor/filepond-plugin-file-validate-type/dist/filepond-plugin-file-validate-type.min.js"></script>
    <script src="vendor/filepond-plugin-file-validate-size/dist/filepond-plugin-file-validate-size.min.js"></script>
    <script src="vendor/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.js"></script>
    <script src="vendor/filepond-plugin-image-crop/dist/filepond-plugin-image-crop.min.js"></script>
    <script src="vendor/filepond-plugin-image-resize/dist/filepond-plugin-image-resize.min.js"></script>
    <script src="vendor/filepond-plugin-image-transform/dist/filepond-plugin-image-transform.min.js"></script>
    <script src="vendor/filepond/dist/filepond.min.js"></script>
    <script src="vendor/cleave.js/dist/cleave.min.js"></script>
    <script src="vendor/tiny-slider/dist/min/tiny-slider.js"></script>
    <!-- Main theme script-->
    <script src="js/theme.min.js"></script>
</body>

</html>