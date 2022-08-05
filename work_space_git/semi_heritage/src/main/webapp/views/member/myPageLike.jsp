<%@page import="oracle.net.aso.i"%>
<%@page import="semi.heritage.favorite.vo.favoriteMyPageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>
<%@ include file="/views/common/sidebar.jsp"%>



<%

List<favoriteMyPageVO> fmlist = (List<favoriteMyPageVO>)request.getAttribute("fmlist");

%>
 <form action="<%=path%>/myPageLike.do" method="get" >
                <!-- Content-->
                <div class="col-lg-8 col-md-7 mb-5">
                    <div class="d-flex align-items-center justify-content-between mb-4 pb-2">
                        <h1 class="h2 mb-0">찜 목록</h1>
                        <a class="fw-bold text-decoration-none" href="#" style="color: #8957BD;"><i class=" fi-x fs-xs mt-n1 me-2 " style="color: #8957BD; "></i>전체 비우기</a>
                    </div>
                    <!-- Item-->
                    <%for(int i = 0; i < fmlist.size(); i++ ) { %>
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4 ">
                        <div class="card-img-top position-relative " style="background-image: url(<%=path %>/resources/img/semi-img/03.like.heritage1.png); ">
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
    
  
        <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>