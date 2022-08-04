<%@page import="semi.heritage.souvenir.vo.SouvenirCartVO"%>
<%@page import= "java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>
<%@ include file="/views/common/sidebar.jsp" %>

<%
DecimalFormat df = new DecimalFormat("###,###");
List<SouvenirCartVO> list = (List<SouvenirCartVO>)request.getAttribute("list");
SouvenirCartVO cart = (SouvenirCartVO)request.getAttribute("deleteCart");

%>

                <div class="col-lg-8 col-md-7 mb-5">
                    <div class="d-flex align-items-center justify-content-between mb-3">
                        <h1 class="h2 mb-0">장바구니</h1><a class="fw-bold text-decoration-none" href="#"  style="color: #8957BD;">
                        <i class="fi-trash mt-n1 me-2"></i>전체 비우기</a>
<!--                         <input type="hidden" name="uNo"> -->
                    </div>
                    <p class="pt-1 mb-4">사뿐몰에서 담은 상품들을 확인 해보세요</p>
                    <%for(int i = 0; i < list.size(); i++){ %>
                   	<%int deleteSeqNo = list.get(i).getSeqNo(); %>
                    <!-- Item-->
                    <div class="card card-hover card-horizontal border-0 shadow-sm mb-4">
                        <a class="card-img-top" href="real-estate-single-v1.html" style="background-image: url(<%=list.get(i).getSouv_pro_url()%>);">
                        </a>
                        <div class="card-body position-relative pb-3">
                            <div class="dropdown position-absolute zindex-5 top-0 end-0 mt-3 me-3">

                            </div>
                            <h4 class="mb-1 fs-xs fw-normal text-uppercase" style="color: #C389FF;"><b>판매중</b></h4>
                            <h3 class="h6 mb-2 fs-base"><a class="nav-link stretched-link" href="real-estate-single-v1.html">반가사유상 마니어처</a></h3>
                            <p class="mb-2 fs-sm text-muted"><%=list.get(i).getSouv_pro_category()%></p>
                            <div class="fw-bold"><i class="fi-cash mt-n1 me-2 lead align-middle opacity-70"></i><%=df.format(list.get(i).getSouv_pro_price())%>원</div>
                            <div class="d-flex align-items-center justify-content-center justify-content-sm-start border-top pt-3 pb-2 mt-3 text-nowrap">
                                <i class="fi-share text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">공유하기</span>
                                <i class="fi-eye-on text-muted" style="padding-right: 2%;"></i><span class="d-inline-block me-4 fs-sm">상세보기</span>
                                <i id="deleteCart" class="fi-trash text-muted" style="padding-right: 2%;"></i><span class="d-inline-block fs-sm">장바구니 해제</span>
                            </div>
                        </div>
                    </div>
                    <%} %>
                    
                    <button href="<%=path%>/souvenirCheckout.do %>" class="btn mt-4 justify-content-end" style="background-color: #8957BD; color: #fff;">전 제품 결제하기</button>

                </div>
            </div>
        </div>
    </main>
    
   
        <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>