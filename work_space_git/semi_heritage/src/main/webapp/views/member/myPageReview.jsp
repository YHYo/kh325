<%@page import="java.util.List"%>
<%@page import="semi.heritage.board.vo.HertiageReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>


<%

List<HertiageReview> hlist = (List<HertiageReview>)request.getAttribute("hlist");
int hreviewCount = (Integer)request.getAttribute("hreviewCount");

%>


        <div class="container pt-5 pb-lg-4 mt-5 mb-sm-2">
            <!-- Breadcrumb-->
            <nav class="mb-4 pt-md-3" aria-label="Breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="real-estate-home-v1.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="real-estate-account-info.html">Account</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Reviews</li>
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
                                <h2 class="fs-lg mb-0"><%=loginMember.getUname()%>님</h2>
                                <!-- <span class="star-rating"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span> -->
                                <ul class="list-unstyled fs-sm mt-3 mb-0">
                                    <li><a class="nav-link fw-normal p-0" href="tel:3025550107"><i class="fi-phone opacity-60 me-2"></i><%=loginMember.getUpw()%></a></li>
                                    <li><a class="nav-link fw-normal p-0" href="mailto:annette_black@email.com"><i class="fi-mail opacity-60 me-2"></i><%=loginMember.getUemail()%></a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="btn btn-lg w-100 mb-3" href="real-estate-add-property.html" style="background-color:#8957BD; color:#fff; text-align: center;"><i class="fi-plus me-2"></i>게시글 작성하기</a>
                        <a class="btn btn-outline-secondary d-block d-md-none w-100 mb-3" href="#account-nav" data-bs-toggle="collapse"><i class="fi-align-justify me-2"></i>Menu</a>
                        <div class="collapse d-md-block mt-3" id="account-nav">
                             <div class="card-nav"><a class="card-nav-link" href="<%=path%>/myPageInfo.do"><i class="fi-user opacity-60 me-2"></i>회원정보 수정</a>
                                <a class="card-nav-link" href="<%=path%>/myPageCart.do" ><i class="fi-home opacity-60 me-2"></i>장바구니</a>
                                <a class="card-nav-link" href="<%=path%>/myPageLike.do"><i class="fi-heart opacity-60 me-2"></i>찜 목록</a>
                                <a class="card-nav-link" href="<%=path%>/myPageReview.do"><i class="fi-star opacity-60 me-2"></i>리뷰</a>
                                <a class="card-nav-link" href="<%=path%>/myPageOrder.do"><i class="fi-star opacity-60 me-2"></i>구매이력</a>
                                <!-- <a class="card-nav-link" href="real-estate-account-notifications.html"><i class="fi-bell opacity-60 me-2"></i>Notifications</a> -->
                                <a class="card-nav-link" href="<%=path%>/views/member/myPageStamp.jsp"><i class="fi-help opacity-60 me-2"></i>스탬프</a>
                                <a class="card-nav-link" onclick="location.href='<%=path%>/logout';"><i class="fi-logout opacity-60 me-2"></i>로그아웃</a></div>
                        </div>
                    </div>
                </aside>
                <!-- 프로필 & 카테고리 끝 -->

                <!-- Content-->
                <div class="col-lg-8 col-md-7 mb-5">
                    <h1 class="h2">리뷰</h1>
                    <p class="pt-1 mb-4">사뿐사뿐에 남긴 리뷰를 확인해보세요</p>
                    <!-- Nav tabs-->
                    <!-- <ul class="nav nav-tabs flex-column flex-sm-row align-items-stretch align-items-sm-start border-bottom mb-4" role="tablist">
                        <li class="nav-item me-sm-3 mb-3"><a class="nav-link text-center active" href="#reviews-about-you" data-bs-toggle="tab" role="tab" aria-controls="reviews-about-you" aria-selected="true">Reviews about you</a></li>
                        <li class="nav-item mb-3"><a class="nav-link text-center" href="#reviews-by-you" data-bs-toggle="tab" role="tab" aria-controls="reviews-by-you" aria-selected="false">Reviews by you</a></li>
                    </ul> -->
                    <!-- Tabs content-->
                    <div class="tab-content pt-2">
                        <!-- Reviews about you tab-->
                        <div class="tab-pane fade show active" id="reviews-about-you" role="tabpanel">
                            <div class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between pb-4 mb-2 mb-md-3">
                                <!-- <h3 class="h4 mb-sm-0"><i class="fi-star-filled mt-n1 me-2 lead align-middle text-warning"></i>4,9 (32 reviews)</h3> -->
                                <div class="d-flex align-items-center">
                                    <!-- <label class="fs-sm me-2 pe-1 text-nowrap" for="review-sorting1">
                                      <i class="fi-arrows-sort text-muted mt-n1 me-2"></i>정렬:</label> -->
                                    <select class="form-se
                                    
                                    lect form-select-sm" id="review-sorting1">
                      <option>최신순</option>
                      <option>오래된순</option>
                      <!-- <option>Popular</option> -->
                      <!-- <option>High rating</option>
                      <option>Low rating</option> -->
                    </select>
                                </div>
                            </div>
                            
                            <!-- Review-->
                            <% for(int i = 0 ; i < hlist.size(); i++) {%>
                            <div class="mb-4 pb-4 border-bottom">
                                <div class="d-flex justify-content-between mb-3">
                                    <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="<%=path %>/resources/img/semi-img/01.info.default.photo.png" width="48" alt="Avatar">
                                        <div class="ps-2">
                                            <h6 class="fs-base mb-0"><%=loginMember.getUname()%>님</h6>
                                            <!-- <span class="star-rating">
                                              <i class="star-rating-icon fi-star-filled active"></i>
                                              <i class="star-rating-icon fi-star-filled active"></i>
                                              <i class="star-rating-icon fi-star-filled active"></i>
                                              <i class="star-rating-icon fi-star-filled active"></i>
                                              <i class="star-rating-icon fi-star-filled active"></i>
                                            </span> -->
                                        </div>
                                    </div><span class="text-muted fs-sm"><%=hlist.get(i).getRevDate()%></span>
                                </div>
                                <p><%=hlist.get(i).getRevContents()%></p>
                                <!-- <div class="d-flex align-items-center">
                                    <button class="btn-like" type="button"><i class="fi-like"></i><span>(3)</span></button>
                                    <div class="border-end me-1">&nbsp;</div>
                                    <button class="btn-dislike" type="button"><i class="fi-dislike"></i><span>(0)</span></button>
                                </div> -->
                            </div>
                            <% } %>

                            <!-- Pagination-->
                            <nav class="mt-2" aria-label="Reviews pagination">
                                <ul class="pagination">
                                    <li class="page-item d-sm-none"><span class="page-link page-link-static">1 / 5</span></li>

                                    <li class="d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                                    </li>
                                    <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item d-none d-sm-block">...</li>
                                    <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                                    <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i class="fi-chevron-right"></i></a></li>
                                </ul>
                            </nav>
                        </div>

                        <!-- Reviews by you tab-->
                        <div class="tab-pane fade" id="reviews-by-you" role="tabpanel">
                            <div class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between pb-4 mb-2 mb-md-3">
                                <h3 class="h4 mb-sm-0"><%=hreviewCount%> reviews</h3>
                                <div class="d-flex align-items-center ms-sm-4">
                                    <label class="fs-sm me-2 pe-1 text-nowrap" for="review-sorting2"><i class="fi-arrows-sort text-muted mt-n1 me-2"></i>Sort by:</label>
                                    <select class="form-select form-select-sm" id="review-sorting2">
                      <option>Newest</option>
                      <option>Oldest</option>
                      <option>Popular</option>
                      <option>High rating</option>
                      <option>Low rating</option>
                    </select>
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