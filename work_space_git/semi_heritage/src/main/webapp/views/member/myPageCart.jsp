<%@page import="semi.heritage.souvenir.vo.Souvenir_Cart_VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>

<% 
Souvenir_Cart_VO scv = (Souvenir_Cart_VO)request.getAttribute("scv");
String cartId = session.getId();
%>

<div class="container pt-5 pb-lg-4 mt-5 mb-sm-2">
            <!-- Breadcrumb-->
            <nav class="mb-4 pt-md-3" aria-label="Breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="real-estate-home-v1.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="real-estate-account-info.html">Account</a></li>
                    <li class="breadcrumb-item active" aria-current="page">My Properties</li>
                </ol>
            </nav>
            <!-- Page content-->
            <div class="row">
                <!-- Sidebar-->
                <aside class="col-lg-4 col-md-5 pe-xl-4 mb-5">
                    <!-- 프로필 & 카테고리 시작 -->
                    <div class="card card-body border-0 shadow-sm pb-1 me-lg-1">
                        <div class="d-flex d-md-block d-lg-flex align-items-start pt-lg-2 mb-4"><img class="rounded-circle" src="<%=path %>/resources/img/semi-img/01.info.default.photo.png" width="48" alt="Annette Black">
                            <div class="pt-md-2 pt-lg-0 ps-3 ps-md-0 ps-lg-3">
                                <h2 class="fs-lg mb-0">Annette Black</h2>
                                <!-- <span class="star-rating"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span> -->
                                <ul class="list-unstyled fs-sm mt-3 mb-0">
                                    <li><a class="nav-link fw-normal p-0" href="tel:3025550107"><i class="fi-phone opacity-60 me-2"></i>(302) 555-0107</a></li>
                                    <li><a class="nav-link fw-normal p-0" href="mailto:annette_black@email.com"><i class="fi-mail opacity-60 me-2"></i>annette_black@email.com</a></li>
                                </ul>
                            </div>
                        </div><a class="btn btn-lg w-100 mb-3" href="real-estate-add-property.html" style="background-color: #8957BD; color: #fff;"><i class="fi-plus me-2"></i>게시글 작성하기</a>
                        <a class="btn btn-outline-secondary d-block d-md-none w-100 mb-3" href="#account-nav" data-bs-toggle="collapse"><i class="fi-align-justify me-2"></i>Menu</a>

                        <div class="collapse d-md-block mt-3 a:hover" id="account-nav">
                            <div class="card-nav"><a class="card-nav-link" href="01.myPageInfo.html"><i class="fi-user opacity-60 me-2"></i>회원정보 수정</a>
                                <!-- <a class="card-nav-link" href="real-estate-account-security.html"><i class="fi-lock opacity-60 me-2"></i>Password &amp; Security</a> -->
                                <a class="card-nav-link active" href="02.myPageCart.html" style="color: #8957BD;"><i class="fi-home opacity-60 me-2"></i>장바구니</a>
                                <a class="card-nav-link" href="03.myPageLike.html"><i class="fi-heart opacity-60 me-2"></i>찜 목록</a>
                                <a class="card-nav-link" href="04.myPageReview.html"><i class="fi-star opacity-60 me-2"></i>리뷰</a>
                                <a class="card-nav-link" href="05.myPageOrder.html"><i class="fi-star opacity-60 me-2"></i>구매이력</a>
                                <!-- <a class="card-nav-link" href="real-estate-account-notifications.html"><i class="fi-bell opacity-60 me-2"></i>Notifications</a> -->
                                <a class="card-nav-link" href="20.myPageStamp.html"><i class="fi-help opacity-60 me-2"></i>스탬프</a>
                                <a class="card-nav-link" href="00.signIn.html"><i class="fi-logout opacity-60 me-2"></i>로그아웃</a></div>
                        </div>
                    </div>
                </aside>
                <div class="col-lg-8 col-md-7 mb-5">
                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <h1 class="h2 mb-0">장바구니</h1><a class="fw-bold text-decoration-none" href="#"  style="color: #8957BD;"><i class="fi-trash mt-n1 me-2"></i>전체 비우기</a>
                    </div>
                    <p class="pt-1 mb-4">사뿐몰에서 담은 상품들을 확인 해보세요</p>
                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4">
                        <a class="card-img-top" href="real-estate-single-v1.html" style="background-image: url(<%=path %>/resources/img/semi-img/02.cart.product1.png);">
                            <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3"><span class="d-table badge bg-info">New</span></div> -->
                        </a>
                        <div class="card-body position-relative pb-3">
                            <div class="dropdown position-absolute zindex-5 top-0 end-0 mt-3 me-3">

                            </div>
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #C389FF;"><b>판매중</b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link" href="real-estate-single-v1.html">반가사유상 마니어처</a></h3>
                            <p class="mb-2 fs-sm text-muted">생활/데코</p>
                            <div class="fw-bold"><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70"></i>49,000원</div>
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">장바구니 해제</span>
                            </div>
                        </div>
                    </div>
                    
                    <!--Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4">
                        <a class="card-img-top" href="real-estate-single-v1.html" style="background-image: url(<%=path %>/resources/img/semi-img/02.cart.product2.png);">
                        </a>
                        <div class="card-body position-relative pb-3">
                            <div class="dropdown position-absolute zindex-5 top-0 end-0 mt-3 me-3">
                            </div>
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: grey;"><b>매진</b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link" href="real-estate-single-v1.html">일월오봉도 한지조명</a></h3>
                            <p class="mb-2 fs-sm text-muted">생활/데코</p>
                            <div class="fw-bold" style="text-decoration: line-through;"><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70"></i>110,000원</div>
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">장바구니 해제</span>
                            </div>
                        </div>
                    </div>
                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm">
                        <a class="card-img-top" href="real-estate-single-v1.html" style="background-image: url(<%=path %>/resources/img/semi-img/02.cart.product3.png);">
                        </a>
                        <div class="card-body position-relative pb-3">
                            <div class="dropdown position-absolute zindex-5 top-0 end-0 mt-3 me-3">
                            </div>
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #C389FF;"><b>판매중</b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link" href="real-estate-single-v1.html">경복궁 근정전 단청연필</a></h3>
                            <p class="mb-2 fs-sm text-muted">사무/문구</p>
                            <div class="fw-bold"><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70"></i>10,000원</div>
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">장바구니 해제</span>
                            </div>
                        </div>
                    </div>
                    <button href="13.souvenirCheckout.jsp?cartId=<%=cartId %>" class="btn mt-4 justify-content-end" style="background-color: #8957BD; color: #fff;">전 제품 결제하기</button>
                </div>
            </div>
        </div>
    </main>
    
    <script>
        <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>