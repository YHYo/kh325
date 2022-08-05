<%@page import="semi.heritage.board.vo.HertiageReview"%>
<%@page import="java.util.List"%>
<%@page import="semi.heritage.heritageInfo.vo.HeritageVideo"%>
<%@page import="semi.heritage.heritageInfo.vo.HeritageImage"%>
<%@page import="semi.heritage.heritageInfo.vo.HeritageVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/views/common/headerLight.jsp"%>

<% 
HeritageVO h = (HeritageVO)request.getAttribute("hertiage");
List<HeritageImage> hi = (List<HeritageImage>)request.getAttribute("heritageImage");
String hv = (String)request.getAttribute("heritageVideo");
List<HertiageReview> list =	(List<HertiageReview>)request.getAttribute("list");
int HertiageReview_Count = (Integer)request.getAttribute("HertiageReview_Count");
int CountFavoriteByNo = (Integer)request.getAttribute("CountFavoriteByNo");
%>
        <!-- Page content-->
        <!-- 리뷰남기기 Review modal-->
        <div class="modal fade" id="modal-review" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header d-block position-relative border-0 pb-0 px-sm-5 px-4">
                        <h3 class="modal-title mt-4 text-center">리뷰남기기</h3>
                        <button class="btn-close position-absolute top-0 end-0 mt-3 me-3" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body px-sm-5 px-4">
                        <form class="needs-validation" novalidate>
                            <div class="mb-3">
                                <label class="form-label" for="review-name">Name <span
                                        class='text-danger'>*</span></label>
                                <input class="form-control" type="text" id="review-name" placeholder="Your name" required>
                                <div class="invalid-feedback">Please let us know your name.</div>
                            </div>
                            <div class="mb-3">
                                 <label class="form-label" for="review-email">Email <span
                                        class='text-danger'>*</span></label>
                                <input class="form-control" type="email" id="review-email" placeholder="Your email address" required>
                                <div class="invalid-feedback">Please provide a valid email address.</div>
                            </div>
                            <div class="mb-3">

                                <div class="invalid-feedback">Please rate the property.</div>
                            </div>
                            <div class="mb-4">
                                <label class="form-label" for="review-text">Review <span
                                        class='text-danger'>*</span></label>
                                <textarea class="form-control" id="review-text" rows="5" placeholder="Your review message" required></textarea>
                                <div class="invalid-feedback">Please write your review.</div>
                            </div>
                            <button class="btn btn-primary d-block w-100 mb-4" type="submit">제출하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
<!--         리뷰 더보기 팝업 -->
<div class="modal fade" id="modal-review-more" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header d-block position-relative border-0 pb-0 px-sm-5 px-4">
                        <h3 class="modal-title mt-4 text-center">리뷰(<%=HertiageReview_Count%>개)
                        </h3>
                        <button class="btn-close position-absolute top-0 end-0 mt-3 me-3" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body px-sm-5 px-4" style="overflow: auto; height: 800px">
                        <% for(int i= 0; i< list.size(); i++){
                	   %>
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="<%=path%>/resources/img/semi-img/01.info.default.photo.png" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0"><%=list.get(i).getRev_userEmail() %></h6>
                                </div>
                            </div><span class="text-muted fs-sm"><%=list.get(i).getRevDate()%></span>
                        </div>
                        <p><%=list.get(i).getRevContents()%></p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(5)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(1)</span></button>
                        </div>
                    </div>
                    <%} %>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Page header-->
        <section class="container pt-5 mt-5">
            <!-- Breadcrumb-->
            <nav class="mb-3 pt-md-3" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<%=path%>/index.do">Home</a></li>
                    <li class="breadcrumb-item"><a href="<%=path%>/heritageSearch.do">문화재검색</a></li>
                    <li class="breadcrumb-item active" aria-current="page"><%= h.getCcbaMnm1() + " (" + h.getCcbaMnm2() + ")" %></li>
                </ol>
            </nav>
            <h1 class="h2 mb-2"><%= h.getCcbaMnm1() + " (" + h.getCcbaMnm2() + ")" %></h1>
<!--             <p class="mb-2 pb-1 fs-lg">Hyangwonjeong Pavilion of Gyeongbokgung Palace</p> -->
            <p class="mb-2 pb-1 fs-lg fi-map-pin"><%= h.getCcbaLcad() %></p>
            <!-- 시작 :좋아요 likes + 리뷰 reviews 아이콘 / 숫자 넣기-->
            <div class="d-flex justify-content-between align-items-center">
                <ul class="d-flex mb-4 list-unstyled">

                </ul>
                <div class="text-nowrap">
                    <input type="hidden" name="hertiageNo" value="<%=h.getNo()%>">
                    <button onclick="location.href='<%=request.getContextPath() %>/favoriteInsert.do?hertiageNo=<%=h.getNo()%>'" class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle ms-2 mb-2" type="submit" data-bs-toggle="tooltip" title="Add to Wishlist"><i class="fi-heart"></i></button>
                    <div class="dropdown d-inline-block" data-bs-toggle="tooltip" title="Share">
                        <button class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle ms-2 mb-2" type="button" data-bs-toggle="dropdown"><i class="fi-share"></i></button>
                        <div class="dropdown-menu dropdown-menu-end my-1">
                            <button class="dropdown-item" type="button"><i
                                    class="fi-facebook fs-base opacity-75 me-2"></i>Facebook</button>
                            <button class="dropdown-item" type="button"><i
                                    class="fi-twitter fs-base opacity-75 me-2"></i>Twitter</button>
                            <button class="dropdown-item" type="button"><i
                                    class="fi-instagram fs-base opacity-75 me-2"></i>Instagram</button>
                        </div>
                    </div>
                </div>
            </div>																
            <!-- 끝 : 좋아요 likes + 리뷰 reviews 아이콘 / 숫자 넣기-->
        </section>
        <!-- Gallery-->
        <section class="container overflow-auto mb-4 pb-3" data-simplebar>
            <div class="row g-2 g-md-3 gallery" data-thumbnails="true" style="min-width: 30rem;">
                <div class="col-8" >
                   <a class="gallery-item rounded rounded-md-3" href="<%if(hi.get(0).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(0).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;&lt;/h6&gt;"><img src="<%if(hi.get(0).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(0).getImageUrl()%><%} %>" alt="Gallery thumbnail" img class="img-contain3"></a> 
                </div>
                <div class="col-4" >
                    <a class="gallery-item rounded rounded-md-3 mb-2 mb-md-3" href="<%if(hi.get(1).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(1).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;&lt;/h6&gt;"><img src="<%if(hi.get(1).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(1).getImageUrl()%><%} %>" alt="Gallery thumbnail" img class="img-contain2"></a>
                    <a class="gallery-item rounded rounded-md-3" href="<%if(hi.get(2).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(2).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt; &lt;/h6&gt;"><img src="<%if(hi.get(2).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(2).getImageUrl()%><%} %>" alt="Gallery thumbnail" img class="img-contain2"></a>
                </div>
                <div class="col-12">
                    <div class="row g-2 g-md-3">
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="<%if(hi.get(3).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(3).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt; &lt;/h6&gt;"><img src="<%if(hi.get(3).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(3).getImageUrl()%><%} %>" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="<%if(hi.get(4).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(4).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt; &lt;/h6&gt;"><img src="<%if(hi.get(4).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(4).getImageUrl()%><%} %>" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="<%if(hi.get(5).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(5).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt; &lt;/h6&gt;"><img src="<%if(hi.get(5).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(5).getImageUrl()%><%} %>" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" style="object-fit: contain" href="<%if(hi.get(6).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(6).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt; &lt;/h6&gt;"><img src="<%if(hi.get(6).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(6).getImageUrl()%><%} %>" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item more-item rounded-1 rounded-md-2" href="<%if(hi.get(7).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(7).getImageUrl()%><%} %>" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bath&lt;/h6&gt;">
                            <img src="<%if(hi.get(7).toString().isEmpty() == true){ %><%=path%>/resources/img/semi-img/noimage_spsp.png<%}else{%><%=hi.get(7).getImageUrl()%><%} %>" img class="img-contain" alt="Gallery thumbnail"><span class="gallery-item-caption fs-base"><span class='d-none d-md-inline'>+ more
                                        photos</span></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Post content-->
        <section class="container mb-5 pb-1">
            <div class="row">
                <div class="col-md-7 mb-md-0 mb-4">
                    <!-- 문화재설명-->
                    <div class="mb-4 pb-md-3">
                        <span>
                            <p class="subtitle text-sm text-primary" style="font-weight:bold">A B O U T</p>
                            <h3 class="h3">문화재설명</h3>
                            <!-- 스크롤 <div style="overflow:scroll; width:800px; height:500px;"> -->

                        </span>
                        <p class="mb-1"><%= h.getContent() %>
                        </p>
<!--                         <div class="collapse" id="seeMoreOverview"> -->
<!--                             <p class="mb-1"> -->
<!--                                 있다. 정자의 평면은 정육각형으로 아래·위층이 똑같은 크기이며, 장대석으로 마무리한 낮은 기단 위에 육각형으로 된 초석을 놓고, 그 위에 일층과 이층을 관통하는 육모기둥을 세웠다. 공포는 이층 기둥 위에 짜여지는데, 기둥 윗몸을 창방(昌枋)으로 결구하고 기둥 위에 주두(柱枓:대접받침)를 놓고 끝이 둥글게 초각(草刻)된 헛첨차를 놓았다. 일출목(一出目)의 행공첨차를 받치고, 다시 소로를 두어 외목도리(外目道里)밑의 장혀를 받친 물익공이다. 일층 평면은 -->
<!--                                 바닥 주위로 평난간을 두른 툇마루를 두었고, 이층 바닥 주위로는 계자난간을 두른 툇마루를 두었다. 천장은 우물천장이며 사방둘레의 모든 칸에는 완자살창틀을 달았다. 처마는 겹처마이며 육모지붕으로, 중앙의 추녀마루들이 모이는 중심점에 절병통(節甁桶)을 얹어 치장하였다. 향원정은 왕과 그 가족들이 휴식을 취하는 공간으로 경복궁 후원의 아름다운 풍광 속에 안겨있는 상징적 대표 건물이다. 육각형 초석, -->
<!--                                 육각형 평면, 육모지붕 등 육각형의 공간을 구성하여 섬세하고 미려하게 다듬은 모든 구성요소들이 절묘한 조화를 이룬 비례감이 뛰어난 정자로 역사적, 예술적, 건축적으로 가치가 높다. -->
<!--                             </p> -->
<!--                         </div> -->
<!--                         <a class="collapse-label collapsed" href="#seeMoreOverview" data-bs-toggle="collapse" data-bs-label-collapsed="더보기" data-bs-label-expanded="접기" role="button" aria-expanded="false" aria-controls="seeMoreOverview"></a> -->
                    </div>
                    <!--스크롤 </div> -->
                    <!-- Post meta-->
                    <div class="mb-lg-5 mb-md-4 pb-lg-2 py-4 border-top">
                    </div>
                    <!-- 시작 : 리뷰 Reviews-->
                    <div class="mb-4 pb-4 border-bottom">
                        <p class="subtitle text-sm text-primary" style="font-weight:bold">R E V I E W S</p>
                        <h3 class="h3 pb-3">리뷰(<%=HertiageReview_Count%>개)
                        </h3>
                        <div class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between">
                            <a class="btn btn-outline-primary mb-sm-0 mb-3" id="review" href="#modal-review" data-bs-toggle="modal"><i class="fi-edit me-1"></i>Add review</a>
                            <div class="d-flex align-items-center ms-sm-4">
                                <label class="me-2 pe-1 text-nowrap" for="reviews-sorting"><i
                                        class="fi-arrows-sort text-muted mt-n1 me-2"></i>Sort by:</label>
                                <select class="form-select" id="reviews-sorting">
                                    <option>Newest</option>
                                    <option>Oldest</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    
                  
                    <!-- Review-->
                    <div style="overflow: hidden; height: 750px">
                   <%if(list != null){ for(int i= 0; i< list.size(); i++){
                	   %>
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="<%=path%>/resources/img/semi-img/01.info.default.photo.png" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0"><%=list.get(i).getRev_userEmail() %></h6>
                                </div>
                            </div><span class="text-muted fs-sm"><%=list.get(i).getRevDate()%></span>
                        </div>
                        <p><%=list.get(i).getRevContents()%></p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(5)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(1)</span></button>
                        </div>
                    </div>
                    <%}} %>
                    
                    </div>
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between">
                            <a class="btn btn-outline-primary mb-sm-0 mb-3" id="review" href="#modal-review-more" data-bs-toggle="modal"><i class="fi-plus me-1"></i>리뷰 더보기</a>
                        </div>
                    </div>
                    <!-- Pagination-->
<!--                     <nav class="mt-2 mb-4" aria-label="Reviews pagination"> -->
<!--                         <ul class="pagination"> -->
<!--                             <li class="page-item d-sm-none"><span class="page-link page-link-static">1 / 5</span></li> -->
<!--                             <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span> -->
<!--                             </li> -->
<!--                             <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li> -->
<!--                             <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li> -->
<!--                             <li class="page-item d-none d-sm-block">...</li> -->
<!--                             <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li> -->
<!--                             <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i -->
<!--                                         class="fi-chevron-right"></i></a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </nav> -->
                </div>
                <!-- Sidebar-->
                <aside class="col-lg-4 col-md-5 ms-lg-auto pb-1">
                    <!-- 문화재정보 INFORMATION      //    아이콘 ?????????????-->
                    <div class="card border-0 shadow mb-5">
                        <div class="card-header py-4 border-0" style="background-color:rgb(245, 245, 245)">
                            <div class="d-flex align-items-center justify-content-between">
                                <div>
                                    <table>
                                        <tr>
                                            <th>
                                                <p class="subtitle text-sm text-primary">I N F O R M A T I O N</p>
                                                <h3>문화재정보</h3>
                                            </th>
                                            <th>
                                                <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fi-info-circle"></i></h1>
                                            </th>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <table class="table text-sm mb-0">
                                <tr>
                                    <th class="ps-0" style="width: 100px">분 류</th>
                                    <td class="pe-0"><%=h.getCcmaName()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="ps-0">수량/면적</th>
                                    <td class="pe-0 "><%=h.getCcbaQuan()%></td>
                                </tr>
                                <tr>
                                    <th class="ps-0">지정일</th>
                                    <td class="pe-0"><%=h.getCcbaAsdt()%></td>
                                </tr>
                                <tr>
                                    <th class="ps-0">소 재 지</th>
                                    <td class="pe-0"><%=h.getCcbaLcad()%></td>
                                </tr>
                                <tr>
                                    <th class="ps-0">시 대</th>
                                    <td class="pe-0"><%=h.getCcceName()%></td>
                                </tr>
                                <tr>
                                    <th class="ps-0">소유자</th>
                                    <td class="pe-md-0"><%=h.getCcbaPoss()%></td>
                                </tr>
                                <tr>
                                    <th class="ps-0">관리자</th>
                                    <td class="pe-0"><%=h.getCcbaAdmin()%></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <!-- 위치 LOCATION (Map)-->
                     <p class="subtitle text-sm text-primary" style="font-weight:bold"> &nbsp;&nbsp;L O C A T I O N
                        </p>
                    <div id="map" style="width:100%;height:350px;"></div>
                     <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe923d0403373a46493e39c5c706eea9"></script>
                    <br>

                    <!-- 동영상 video-->
                    <div class="pt-2">
                        <p class="subtitle text-sm text-primary" style="font-weight:bold"> &nbsp;&nbsp;V I D E O</p>
                        <h3 class="h4 pb-3"><i class="mt-n1 me-2 lead align-middle text-warning" style="font-weight:bold"></i>동영상
                        </h3>
                        <br><br><br><br>
                        <div class="position-relative mb-2">
                            <div class="d-flex w-100 h-100 align-items-center justify-content-center position-absolute top-0 start-0">
                                <video src="<%=hv%>" controls width="400" height="350">
                                    <a class="btn btn-primary stretched-link"
                                        href="http://uci.k-heritage.tv/resolver/I801:1605002-014-V00006@N2R:1"
                                        data-iframe="true" data-bs-toggle="lightbox"><i class="fi-route me-2"></i>Get
                                        directions</a>
                                </video>
                                <!-- <div class="position-relative mb-2"><img class="rounded-3" src="img/real-estate/single/map.jpg" alt="Map">
                              <div class="d-flex w-100 h-100 align-items-center justify-content-center position-absolute top-0 start-0"> -->
                            </div>
                        </div>
                        <br><br><br><br> <br><br><br><br>
                        <div class="text-center">
                            <p>
                                <a style="color:rgb(220, 58, 85)" href="<%=path%>/favoriteInsert.do?hertiageNo=<%=h.getNo()%>">
                                    <i class="fi-heart-filled" style="color:rgb(220, 58, 85)"></i> Like this place</a>
                            </p><span><%=CountFavoriteByNo%>명의 사람들이 이 장소를 찜하였습니다.</span>
                        </div>
                </aside>
                </div>
        </section>
        </div>
    </main>
   
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(<%=h.getLatitude()%>,<%=h.getLongitude()%>), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(<%=h.getLatitude()%>, <%=h.getLongitude()%>); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
<%@include file="/views/common/footer.jsp"%>
 