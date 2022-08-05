<%@page import="semi.heritage.souvenir.vo.SouvenirBuyVO"%>
<%@page import= "java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/headerLight.jsp" %>
<%@ include file="/views/common/sidebar.jsp" %>

<%
DecimalFormat df = new DecimalFormat("###,###");
List<SouvenirBuyVO> BuyList = (List<SouvenirBuyVO>)request.getAttribute("BuyList");
// SouvenirCartVO cart = (SouvenirCartVO)request.getAttribute("deleteCart");
%>

<style>
.orderPhoto {
	width: 120px;
	height: 80px;
    border-radius: 30% !important;
}
</style>

<!-- Content-->
<div class="col-lg-8 col-md-7 mb-5">
	<h1 class="h2">구매이력</h1>
	<p class="pt-1 mb-4">사뿐몰에서 구매한 목록을 확인해보세요</p>
	<!-- Nav tabs-->
	<!-- <ul class="nav nav-tabs flex-column flex-sm-row align-items-stretch align-items-sm-start border-bottom mb-4" role="tablist">
                        <li class="nav-item me-sm-3 mb-3"><a class="nav-link text-center active" href="#reviews-about-you" data-bs-toggle="tab" role="tab" aria-controls="reviews-about-you" aria-selected="true">Reviews about you</a></li>
                        <li class="nav-item mb-3"><a class="nav-link text-center" href="#reviews-by-you" data-bs-toggle="tab" role="tab" aria-controls="reviews-by-you" aria-selected="false">Reviews by you</a></li>
                    </ul> -->
	<!-- Tabs content-->
	<div class="tab-content pt-2">
		<!-- Reviews about you tab-->
		<div class="tab-pane fade show active" id="reviews-about-you"
			role="tabpanel">
			<div
				class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between pb-4 mb-2 mb-md-3">
				<!-- <h3 class="h4 mb-sm-0"><i class="fi-star-filled mt-n1 me-2 lead align-middle text-warning"></i>4,9 (32 reviews)</h3> -->
				<div class="d-flex align-items-center">
					<!-- <label class="fs-sm me-2 pe-1 text-nowrap" for="review-sorting1">
                                      <i class="fi-arrows-sort text-muted mt-n1 me-2"></i>정렬:</label> -->
<!-- 					<select class="form-select form-select-sm" id="review-sorting1"> -->
<!-- 						<option>최신순</option> -->
<!-- 						<option>오래된순</option> -->
<!-- 						<option>Popular</option> -->
<!-- 						<option>High rating</option>
<!--                       <option>Low rating</option> -->
<!-- 					</select> -->
				</div>
			</div>

			<!-- 구매내역 시작-->
			<!-- 주문번호 첫번째 시작 -->
			
			
			<div class="mb-4 pb-4">
<!-- 				<i class="fi-chevron-down" style="color: A08DB4;"></i> <a -->
<!-- 					class="btn fw-bold" style="color: #A08DB4;" -->
<!-- 					data-bs-toggle="collapse" href="#collapse1" role="button" -->
<%-- 					aria-expanded="false" aria-controls="collapseExample"> 주문번호:<%=BuyList.get(i).getOrderNum() %></a> --%>
<!-- 				<div class="mt-4 mb-4 collapse" id="collapse1"> -->
					<div class="card card-body">
<%-- 					<%for(int i = 0; i<BuyList.size(); i++){ %> --%>
						<table>
							<thead class="thead-dark">
								<tr class="active" style="font-size: 16px;">
									<th class="fw-bold align-content-center mb-lg-3"
										style="text-align: center;">주문번호</th>
									<th class="fw-bold align-content-center mb-lg-3"
										style="text-align: center;">상품번호</th>
<!-- 									<th class="fw-bold align-content-center" -->
<!-- 										style="text-align: center;">사진</th> -->
									<th class="fw-bold align-content-center"
										style="text-align: center;">상품명</th>
									<th class="fw-bold align-content-center"
										style="text-align: center;">가격</th>

								</tr>
							</thead>
							<tbody>
					<%for(int i = 0; i<BuyList.size(); i++){ %>
								<tr style="font-size: 15px;">
									<th class="fw-bold align-content-center" 
										style="color: #9E9E9E; text-align: center; border-top: 1px solid #efecf3;"><%=BuyList.get(i).getOrderNum() %></th>
									<td class="fw-bold align-content-center"
										style="color: #9E9E9E; text-align: center; border-top: 1px solid #efecf3;"><%=BuyList.get(i).getSouv_pro_no() %></td>
<!-- 									<td class="fw-bold align-content-center" -->
<%-- 										style="color: #9E9E9E; text-align: center; border-top: 1px solid #efecf3;"><img src="<%=BuyList.get(i).getSouv_pro_url() %>" width="50px" height="50px"></td> --%>
									<td class="fw-bold align-content-center"
										style="color: #9E9E9E; text-align: center; border-top: 1px solid #efecf3;"><a
										class="card-nav-link" style="text-decoration: none;"
										href="<%=path+"/souvenirProductsDetail.do?productNo=" + BuyList.get(i).getSouv_pro_no()%>"><%=BuyList.get(i).getSouv_pro_name() %></a></td>
									<td class="fw-bold align-content-center"
										style="color: #9E9E9E; text-align: center; border-top: 1px solid #efecf3;"><%=df.format(BuyList.get(i).getSouv_pro_price())%>원</td>

								</tr>
						<%} %>
							</tbody>
							
						</table>

						<table class="table table-striped">
							<thead>
								<tr>
								<tr></tr>
								<tr></tr>
								<tr></tr>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th class="fw-bold align-content-center"></th>
									<td class="fw-bold align-content-center "></td>
									<td class="fw-bold align-content-center ">배송비(3,000원) 포함 총 가격</td>
									<td class="fw-bold align-content-center "
										style="color: #9E9E9E; column-span: all; text-align: right; padding-right: 7%;"><%=df.format(BuyList.get(0).getBsb_total_price()) %>원</td>

								</tr>
							</tbody>
						</table>
						
					</div>
<!-- 				</div> -->
				
				
				<!-- 주문번호 첫번째 끝 -->

			</div>
		</div>
	</div>
</div>
</main>
<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>