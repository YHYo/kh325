<%@page import="oracle.net.aso.i"%>
<%@page import="semi.heritage.favorite.vo.favoriteMyPageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>
<%-- <%@ include file="/views/common/sidebar.jsp"%> --%>



<%

List<favoriteMyPageVO> fmlist = (List<favoriteMyPageVO>)request.getAttribute("fmlist");


%>
 
 <style>
 .mhj-content {
            text-overflow: ellipsis;
            overflow: hidden;
            display: -webkit-box;
          -webkit-line-clamp: 4;
          -webkit-box-orient: vertical;
          word-wrap:break-word; 
          line-height: 20px;
            width: 450px;
        }
</style>
 
 
 <form action="<%=path%>/myPageLike.do" method="get" >
 <div class="container pt-5 pb-lg-4 mt-5 mb-sm-2">
            <!-- Breadcrumb-->
            <nav class="mb-4 pt-md-3" aria-label="Breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<%=path%>/index.do">Home</a></li>
                    <li class="breadcrumb-item"><a href="<%=path%>/myPageInfo.do">Account</a></li>
                    <li class="breadcrumb-item active" aria-current="page">My Properties</li>
                </ol>
            </nav>
            <!-- Page content-->
            <div class="row">
                <!-- Sidebar-->
                <aside class="col-lg-4 col-md-5 pe-xl-4 mb-5">

                    <!-- 프로필 & 카테고리 시작 -->
                    <div class="card card-body border-0 shadow-sm pb-1 me-lg-1">
                        <div class="d-flex d-md-block d-lg-flex align-items-start pt-lg-2 mb-4"><img class="rounded-circle" src="<%=path%>/resources/img/semi-img/01.info.default.photo.png" width="48" alt=<%=loginMember.getUemail()%>>
                            <div class="pt-md-2 pt-lg-0 ps-3 ps-md-0 ps-lg-3">
                                <h2 class="fs-lg mb-0"><%=loginMember.getUname()%>님</h2>
                                <!-- <span class="star-rating"><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i><i class="star-rating-icon fi-star-filled active"></i></span> -->
                                <ul class="list-unstyled fs-sm mt-3 mb-0">
                                    <li><a class="nav-link fw-normal p-0" href="tel:3025550107"><i class="fi-phone opacity-60 me-2"></i><%=loginMember.getUpw()%></a></li>
                                    <li><a class="nav-link fw-normal p-0" href="mailto:annette_black@email.com"><i class="fi-mail opacity-60 me-2"></i><%=loginMember.getUemail()%></a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="btn btn-lg w-100 mb-3" href="real-estate-add-property.html" style="background-color:#8957BD; color:#fff;"><i class="fi-plus me-2"></i>게시글 작성하기</a>
                        <a class="btn btn-outline-secondary d-block d-md-none w-100 mb-3" href="#account-nav" data-bs-toggle="collapse"><i class="fi-align-justify me-2"></i>Menu</a>
                        <div class="collapse d-md-block mt-3" id="account-nav">
                             <div class="card-nav"><a class="card-nav-link" href="<%=path%>/myPageInfo.do"><i class="fi-user opacity-60 me-2"></i>회원정보 수정</a>
                                <a class="card-nav-link" href="<%=path%>/myPageCart.do" ><i class="fi-home opacity-60 me-2"></i>장바구니</a>
                                <a class="card-nav-link" href="<%=path%>/favoriteMyPage.do"><i class="fi-heart opacity-60 me-2"></i>찜 목록</a>
                                <a class="card-nav-link" href="<%=path%>/HertiageReviewList.do"><i class="fi-star opacity-60 me-2"></i>리뷰</a>
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
                    <div class="d-flex align-items-center justify-content-between mb-4 pb-2">
                        <h1 class="h2 mb-0">찜 목록</h1>
                        <a class="fw-bold text-decoration-none" href="#" style="color: #8957BD;"><i class=" fi-x fs-xs mt-n1 me-2 " style="color: #8957BD; "></i>전체 비우기</a>
                    </div>
                    <!-- Item-->
                    <%for(int i = 0; i < fmlist.size(); i++ ) { %>
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4 ">
                        <div class="card-img-top position-relative " style="background-image: url(<%=fmlist.get(i).getImageUrl()%>); ">
                            <a class="stretched-link " href="real-estate-single-v1.html "></a>
                            <!-- <div class="position-absolute start-0 top-0 pt-3 ps-3 "><span class="d-table badge bg-success mb-1 ">Verified</span><span class="d-table badge bg-info ">New</span></div> -->
                            <div class="position-absolute end-0 top-0 pt-3 pe-3 zindex-5 ">
                                <button class="btn btn-icon btn-light btn-xs text-primary rounded-circle shadow-sm " type="button " data-bs-toggle="tooltip " data-bs-placement="left " title="Remove from Wishlist ">
                                  <i class="fi-heart-filled " style="color: #C389FF;"></i></button>
                            </div>
                        </div>
                        <div class="card-body position-relative pb-3 ">
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #B0C729;"><b><%=fmlist.get(i).getCcmaName()%></b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link " href="real-estate-single-v1.html "><b><%=fmlist.get(i).getCcbaMnm1()%></b></a>
                                <br>
                                <p style="color: #A08DB4; margin-top: -4%; margin-bottom: 1%; font-size: 15px;"><%=fmlist.get(i).getCcbaLcad()%></p>
                            </h3>
                            <label><p class="mb-2 fs-sm text-muted "><%=fmlist.get(i).getContent()%></p></label>
                            <!-- <div class="fw-bold "><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70 "></i>$94,000</div> -->
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm" onclick="changeForm(0)" id="shareTwitter()">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm" onclick="changeForm(1)" id="heritageDetail()">상세보기</span>
                                <i class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm" onclick="changeForm(2)" id="favoriteDelete()">찜 해제</span>
                            </div>
                        </div>
                    </div>
					<% } %>
                </div>
            </div>
        </div>
    </main>
    
    <script  type="text/javascript">
	            
function changeForm(val) {
		if (val == "0") {
			function shareTwitter() {
			    var sendText = <%="문화재"%>; // 전달할 텍스트
			    window.open("https://twitter.com/intent/tweet?text=" + sendText);
			}
		} else if (val == "1") {
			location.href = "<%= request.getContextPath() %>/heritageDeatil.do";
		} else if (val == "2") {
			location.href = "<%= request.getContextPath() %>/favoriteDelete.do";
		} 
	}
</script>
        <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>