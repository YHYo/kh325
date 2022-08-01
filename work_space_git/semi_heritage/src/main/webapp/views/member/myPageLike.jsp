<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>
 
        <div class="container pt-5 pb-lg-4 mt-5 mb-sm-2">
            <!-- Breadcrumb-->
            <nav class="mb-4 pt-md-3" aria-label="Breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="real-estate-home-v1.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="real-estate-account-info.html">Account</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Wishlist</li>
                </ol>
            </nav>
            <!-- Page content-->
            <div class="row">
                <!-- Sidebar-->
                <aside class="col-lg-4 col-md-5 pe-xl-4 mb-5">

                    <!-- 프로필 & 카테고리 시작 -->
                    <div class="card card-body border-0 shadow-sm pb-1 me-lg-1">
                        <div class="d-flex d-md-block d-lg-flex align-items-start pt-lg-2 mb-4"><img class="rounded-circle" src="<%=path %>/resources/img/naim/01.info.default.photo.png" width="48" alt="Annette Black">
                            <div class="pt-md-2 pt-lg-0 ps-3 ps-md-0 ps-lg-3">
                                <h2 class="fs-lg mb-0">Annette Black</h2>
                                <!-- <span class="star-rating"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span> -->
                                <ul class="list-unstyled fs-sm mt-3 mb-0">
                                    <li><a class="nav-link fw-normal p-0" href="tel:3025550107"><i class="fi-phone opacity-60 me-2"></i>(302) 555-0107</a></li>
                                    <li><a class="nav-link fw-normal p-0" href="mailto:annette_black@email.com"><i class="fi-mail opacity-60 me-2"></i>annette_black@email.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="btn btn-lg w-100 mb-3" href="real-estate-add-property.html" style="background-color:#8957BD; color:#fff;"><i class="fi-plus me-2"></i>게시글 작성하기</a>
                        <a class="btn btn-outline-secondary d-block d-md-none w-100 mb-3" href="#account-nav" data-bs-toggle="collapse"><i class="fi-align-justify me-2"></i>Menu</a>
                        <div class="collapse d-md-block mt-3" id="account-nav">
                            <div class="card-nav"><a class="card-nav-link" href="01.myPageInfo.html"><i class="fi-user opacity-60 me-2"></i>회원정보 수정</a>
                                <!-- <a class="card-nav-link" href="real-estate-account-security.html"><i class="fi-lock opacity-60 me-2"></i>Password &amp; Security</a> -->
                                <a class="card-nav-link" href="02.myPageCart.html"><i class="fi-home opacity-60 me-2"></i>장바구니</a>
                                <a class="card-nav-link active" href="03.myPageLike.html" style="color: #8957BD;"><i class="fi-heart opacity-60 me-2"></i>찜 목록</a>
                                <a class="card-nav-link" href="04.myPageReview.html"><i class="fi-star opacity-60 me-2"></i>리뷰</a>
                                <a class="card-nav-link" href="05.myPageOrder.html"><i class="fi-star opacity-60 me-2"></i>구매이력</a>
                                <!-- <a class="card-nav-link" href="real-estate-account-notifications.html"><i class="fi-bell opacity-60 me-2"></i>Notifications</a> -->
                                <a class="card-nav-link" href="20.myPageStamp.html"><i class="fi-help opacity-60 me-2"></i>스탬프</a>
                                <a class="card-nav-link" href="00.signIn.html"><i class="fi-logout opacity-60 me-2"></i>로그아웃</a></div>
                        </div>
                    </div>
                </aside>
                <!-- 프로필 & 카테고리 끝 -->


                <!-- Content-->
                <div class="col-lg-8 col-md-7 mb-5">
                    <div class="d-flex align-items-center justify-content-between mb-4 pb-2">
                        <h1 class="h2 mb-0">찜 목록</h1>
                        <a class="fw-bold text-decoration-none" href="#" style="color: #8957BD;"><i class=" fi-x fs-xs mt-n1 me-2 " style="color: #8957BD; "></i>전체 비우기</a>
                    </div>
                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4 ">
                        <div class="card-img-top position-relative " style="background-image: url(<%=path %>/resources/img/naim/03.like.heritage1.png); ">
                            <a class="stretched-link " href="real-estate-single-v1.html "></a>
                            <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3 "><span class="d-table badge bg-success mb-1 ">Verified</span><span class="d-table badge bg-info ">New</span></div> -->
                            <div class="position-absolute end-0 top-0 pt-3 pe-3 zindex-5 ">
                                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle shadow-sm " type="button " data-bs-toggle="tooltip " data-bs-placement="left " title="Remove from Wishlist ">
                                  <i class="fi-heart-filled " style="color: #C389FF;"></i></button>
                            </div>
                        </div>
                        <div class="card-body position-relative pb-3 ">
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #B0C729;"><b>보물</b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link " href="real-estate-single-v1.html "><b>향원정</b></a>
                                <br>
                                <p style="color: #A08DB4; margin-top: -4%; margin-bottom: 1%; font-size: 15px;">서울시 종로구 사직로 161</p>
                            </h3>
                            <label><p class="mb-2 fs-sm text-muted ">향원정은 서울특별시 종로구, 경복궁 내에 있는 조선시대의 건축물이다. 2012년 3월 2일 대한민국의 보물 제1759호로 지정되었다. 1885년에 세워진 것으로 추정되며, 고종의 어필로 현판을 제작하였다.</p></label>
                            <!-- <div class="fw-bold "><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70 "></i>$94,000</div> -->
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">찜 해제</span>
                            </div>
                        </div>
                    </div>

                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4 ">
                        <div class="card-img-top position-relative " style="background-image: url(<%=path %>/resources/img/naim/03.like.heritage2.png); ">
                            <a class="stretched-link " href="real-estate-single-v1.html "></a>
                            <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3 "><span class="d-table badge bg-success mb-1 ">Verified</span></div> -->
                            <div class="position-absolute end-0 top-0 pt-3 pe-3 zindex-5 ">
                                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle shadow-sm " type="button " data-bs-toggle="tooltip " data-bs-placement="left " title="Remove from Wishlist ">
                                  <i class="fi-heart-filled" style="color: #C389FF;"></i></button>
                            </div>
                        </div>
                        <div class="card-body position-relative pb-3 ">
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #B0C729;"><b>국보</b></h4>
                            <h3 class="h6 mb-2 fs-base "><a class="nav-link stretched-link " href="real-estate-single-v1.html ">경회루</a> <br>
                                <p style="color: #A08DB4; margin-top: -4%; margin-bottom: 1%; font-size: 15px;">서울시 종로구 사직로 161</p>
                            </h3>

                            <label><p class="mb-2 fs-sm text-muted ">경회루는 경복궁에 있는 누각으로, 조선시대에 연회를 하거나, 외국의 사신을 접견하던 곳으로, 지금의 청와대 영빈관에 해당된다. 1985년 1월 8일 대한민국의 국보 제224호로 지정되었다.</p></label>
                            <!-- <div class="fw-bold "><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70 "></i>$2,400</div> -->
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">찜 해제</span>
                            </div>
                        </div>
                    </div>

                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4 ">
                        <div class="card-img-top position-relative " style="background-image: url(<%=path %>/resources/img/naim/03.like.heritage3.png); ">
                            <a class="stretched-link " href="real-estate-single-v1.html "></a>
                            <div class="position-absolute end-0 top-0 pt-3 pe-3 zindex-5 ">
                                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle shadow-sm " type="button " data-bs-toggle="tooltip " data-bs-placement="left " title="Remove from Wishlist ">
                                  <i class="fi-heart-filled" style="color: #C389FF;"></i></button>
                            </div>
                        </div>
                        <div class="card-body position-relative pb-3 ">
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #B0C729;"><b>정보없음</b></h4>
                            <h3 class="h6 mb-2 fs-base "><a class="nav-link stretched-link " href="real-estate-single-v1.html ">광화문</a><br>
                                <p style="color: #A08DB4; margin-top: -4%; margin-bottom: 1%; font-size: 15px;">서울시 종로구 사직로 161</p>
                            </h3>
                            <p class="mb-2 fs-sm text-muted ">광화문은 경복궁의 남쪽에 있는 정문이다. ‘임금의 큰 덕이 온 나라를 비춘다’는 의미이다. 1395년에 세워졌으며, 2층 누각인 광화문 앞의 양쪽에는 한 쌍의 해치 조각상이 자리잡고 있다. 광화문의 석축부에는 세 개의 홍예문이 있다. </p>
                            <!-- <div class="fw-bold "><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70 "></i>$162,000</div> -->
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">찜 해제</span>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </main>
        <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>