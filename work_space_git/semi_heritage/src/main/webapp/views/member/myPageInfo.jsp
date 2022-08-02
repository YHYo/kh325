<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="/views/common/headerLight.jsp" %>

		<div class="container pt-5 pb-lg-4 mt-5 mb-sm-2">
			<!-- Breadcrumb-->
			<nav class="mb-4 pt-md-3" aria-label="Breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="real-estate-home-v1.html">Home</a></li>
					<li class="breadcrumb-item"><a
						href="real-estate-account-info.html">Account</a></li>
					<li class="breadcrumb-item active" aria-current="page">Personal
						Info</li>
				</ol>
			</nav>
			<!-- Page content-->
			<div class="row">

				<!-- Sidebar-->
				<aside class="col-lg-4 col-md-5 pe-xl-4 mb-5">

					<!-- Account nav-->
					<div class="card card-body border-0 shadow-sm pb-1 me-lg-1">
						<div
							class="d-flex d-md-block d-lg-flex align-items-start pt-lg-2 mb-4">
							<img class="rounded-circle"
								src="<%=path%>/resources/img/semi-img/01.info.default.photo.png"
								width="48" alt="Annette Black">
							<div class="pt-md-2 pt-lg-0 ps-3 ps-md-0 ps-lg-3">
								<h2 class="fs-lg mb-0">Annette Black</h2>
								<!-- <span class="star-rating">
                                    <i class="star-rating-icon fi-star-filled active"></i>
                                    <i class="star-rating-icon fi-star-filled active"></i>
                                    <i class="star-rating-icon fi-star-filled active"></i>
                                    <i class="star-rating-icon fi-star-filled active"></i>
                                    <i class="star-rating-icon fi-star-filled active"></i>
                                  </span> -->
								<ul class="list-unstyled fs-sm mt-3 mb-0">
									<li><a class="nav-link fw-normal p-0"
										href="tel:3025550107"><i class="fi-phone opacity-60 me-2"></i>(302)
											555-0107</a></li>
									<li><a class="nav-link fw-normal p-0"
										href="mailto:annette_black@email.com"><i
											class="fi-mail opacity-60 me-2"></i>annette_black@email.com</a></li>
								</ul>
							</div>

							<!-- 프로필 하단 카테고리 시작 -->
							<!-- herf : 게시글 작성 링크 첨부필요 -->
						</div>
						<a class="btn btn-lg w-100 mb-3" href="00.signIn.jsp"
							style="background-color: #8957BD; color: #fff;"><i
							class="fi-plus me-2"></i>게시글 작성하기</a> <a
							class="btn btn-outline-secondary d-block d-md-none w-100 mb-3"
							href="#account-nav" data-bs-toggle="collapse"><i
							class="fi-align-justify me-2"></i>Menu</a>
						<div class="collapse d-md-block mt-3" id="account-nav">
							<div class="card-nav">
								<a class="card-nav-link active" style="color: #8957BD;"
									href="01.myPageInfo.jsp"><i
									class="fi-user opacity-60 me-2"></i>회원정보 수정</a>
								<!-- <a class="card-nav-link" href="real-estate-account-security.html"><i class="fi-lock opacity-60 me-2"></i>Password &amp; Security</a> -->
								<a class="card-nav-link" href="02.myPageCart.jsp"><i
									class="fi-home opacity-60 me-2"></i>장바구니</a> <a
									class="card-nav-link" href="03.myPageLike.jsp"><i
									class="fi-heart opacity-60 me-2"></i>찜 목록</a> <a
									class="card-nav-link" href="04.myPageReview.jsp"><i
									class="fi-star opacity-60 me-2"></i>리뷰</a> <a class="card-nav-link"
									href="05.myPageOrder.jsp"><i
									class="fi-star opacity-60 me-2"></i>구매이력</a>
								<!-- <a class="card-nav-link" href="real-estate-account-notifications.html"><i class="fi-bell opacity-60 me-2"></i>Notifications</a> -->
								<a class="card-nav-link" href="20.myPageStamp.html"><i
									class="fi-help opacity-60 me-2"></i>스탬프</a> <a
									class="card-nav-link" href="00.signIn.jsp"><i
									class="fi-logout opacity-60 me-2"></i>로그아웃</a>
							</div>
						</div>
					</div>
				</aside>
				<!-- 프로필 하단 카테고리 끝 -->

				<!-- Content-->
				<div class="col-lg-8 col-md-7 mb-5">
				<form name="memberInfoFrm" action="<%=request.getContextPath()%>/member/update" method="POST">

					<h1 class="h2">마이페이지</h1>
					<div class="mb-2 pt-1">회원정보를 수정 해주세요</div>
					<div class="progress mb-4" style="height: .25rem;">
						<div class="progress-bar bg-warning" role="progressbar"
							style="width: 50%" aria-valuenow="50" aria-valuemin="0"
							aria-valuemax="100"></div>
					</div>
					<label class="form-label pt-2" for="account-bio"><b>All
							About You</b></label>
					<div class="row pb-2">
						<div class="col-lg-9 col-sm-8 mb-4">
							<textarea class="form-control" id="account-bio" name="introduce"
								rows="6" placeholder="사뿐사뿐에 멋진 소개를 남겨주세요">
<%-- 								<%= loginMember.getIntroduce() %> --%>
								</textarea>
						</div>
						
						<div class="col-lg-3 col-sm-4 mb-4">
							<input class="file-uploader bg-secondary" type="file"
								accept="image/png, image/jpeg"
								data-label-idle="&lt;i class=&quot;d-inline-block fi-camera-plus fs-2 text-muted mb-2&quot;&gt;&lt;/i&gt;&lt;br&gt;&lt;span class=&quot;fw-bold&quot;&gt;Change picture&lt;/span&gt;"
								data-style-panel-layout="compact"
								data-image-preview-height="160"
								data-image-crop-aspect-ratio="1:1"
								data-image-resize-target-width="200"
								data-image-resize-target-height="200">
						</div>
					</div>
					<div class="border rounded-3 p-3 mb-4" id="personal-info">

						<!-- Name-->
						<div class="border-bottom pb-3 mb-3">
							<div class="d-flex align-items-center justify-content-between">
								<div class="pe-2">
									<label class="form-label fw-bold">이름</label>
									<div id="name-value">
<%-- 									<%= loginMember.getUname() %> --%>
									</div>
								</div>
								<div class="me-n3" data-bs-toggle="tooltip" title="Edit">
									<a class="nav-link py-0" href="#name-collapse"
										data-bs-toggle="collapse"><i class="fi-edit"></i></a>
								</div>
							</div>
							<div class="collapse" id="name-collapse"
								data-bs-parent="#personal-info">
								<input class="form-control mt-3" type="text"
									data-bs-binded-element="#name-value"
									data-bs-unset-value="Not specified" value="Annette Black">
							</div>
						</div>

						<!-- Phone number-->
						<div class="border-bottom pb-3 mb-3">
							<div class="d-flex align-items-center justify-content-between">
								<div class="pe-2">
									<label class="form-label fw-bold">연락처</label>
									<div id="phone-value"><%if(loginMember != null) {%><%= loginMember.getUpn() %><%}%></div>
								</div>
								<div class="me-n3" data-bs-toggle="tooltip" title="Edit">
									<a class="nav-link py-0" href="#phone-collapse"
										data-bs-toggle="collapse"><i class="fi-edit"></i></a>
								</div>
							</div>
							<div class="collapse" id="phone-collapse"
								data-bs-parent="#personal-info">
								<input class="form-control mt-3" type="text"
									data-bs-binded-element="#phone-value"
									data-bs-unset-value="Not specified" value="(302) 555-0107">
							</div>
						</div>

						<!-- Email-->
						<div class="border-bottom pb-3 mb-3">
							<div class="d-flex align-items-center justify-content-between">
								<div class="pe-2">
									<label class="form-label fw-bold">Email</label>
									<div id="email-value"><%if(loginMember != null) {%><%= loginMember.getUemail() %><%} %></div>
								</div>
								<!-- <div class="me-n3" data-bs-toggle="tooltip" title="Edit"><a class="nav-link py-0" href="#email-collapse" data-bs-toggle="collapse"><i class="fi-edit"></i></a></div> -->
							</div>
							<div class="collapse" id="email-collapse"
								data-bs-parent="#personal-info">
								<input class="form-control mt-3" type="email"
									data-bs-binded-element="#email-value"
									data-bs-unset-value="Not specified"
									value="annette_black@email.com">
							</div>
						</div>

						<!-- Company name-->
						<!-- <div class="border-bottom pb-3 mb-3">
                            <div class="d-flex align-items-center justify-content-between">
                                <div class="pe-2">
                                    <label class="form-label fw-bold">Company name</label>
                                    <div id="company-value">Not specified</div>
                                </div>
                                <div class="me-n3" data-bs-toggle="tooltip" title="Edit"><a class="nav-link py-0" href="#company-collapse" data-bs-toggle="collapse"><i class="fi-edit"></i></a></div>
                            </div>
                            <div class="collapse" id="company-collapse" data-bs-parent="#personal-info">
                                <input class="form-control mt-3" type="text" data-bs-binded-element="#company-value" data-bs-unset-value="Not specified" placeholder="Enter company name">
                            </div>
                        </div> -->

						<!-- Address-->
						<div>
							<div class="d-flex align-items-center justify-content-between">
								<div class="pe-2">
									<label class="form-label fw-bold">주소</label>
									<div id="address-value"><%if(loginMember != null) {%><%= loginMember.getUadr() %><%} %></div>
								</div>
								<div class="me-n3" data-bs-toggle="tooltip" title="Edit">
									<a class="nav-link py-0" href="#address-collapse"
										data-bs-toggle="collapse"><i class="fi-edit"></i></a>
								</div>
							</div>
							<div class="collapse" id="address-collapse"
								data-bs-parent="#personal-info">
								<input class="form-control mt-3" type="text"
									data-bs-binded-element="#address-value"
									data-bs-unset-value="Not specified" placeholder="Enter address">
							</div>
						</div>
					</div>

					<!-- Socials-->
					<div class="pt-2">
						<label class="form-label fw-bold mb-3">Socials</label>
					</div>
					<div class="d-flex align-items-center mb-3">
						<div
							class="btn btn-icon btn-light btn-xs shadow-sm rounded-circle pe-none flex-shrink-0 me-3">
							<i class="fi-facebook text-body"></i>
						</div>
						<input class="form-control" type="text"
							placeholder="Your Facebook account"  value="<%if(loginMember != null) {%><%= loginMember.getFacebook() %><% }%>">
					</div>
					<!-- <div class="d-flex align-items-center mb-3">
                        <div class="btn btn-icon btn-light btn-xs shadow-sm rounded-circle pe-none flex-shrink-0 me-3"><i class="fi-linkedin text-body"></i></div>
                        <input class="form-control" type="text" placeholder="Your LinkedIn account"> -->
					<!-- </div> -->
					<div class="d-flex align-items-center mb-3">
						<div
							class="btn btn-icon btn-light btn-xs shadow-sm rounded-circle pe-none flex-shrink-0 me-3">
							<i class="fi-twitter text-body"></i>
						</div>
						<input class="form-control" type="text"
							placeholder="Your Twitter account" value="<%if(loginMember != null) {%><%= loginMember.getTwt() %><%} %>">
							
					</div>
					<div class="collapse" id="showMoreSocials">
						<div class="d-flex align-items-center mb-3">
							<div
								class="btn btn-icon btn-light btn-xs shadow-sm rounded-circle pe-none flex-shrink-0 me-3">
								<i class="fi-instagram text-body"></i>
							</div>
							<input class="form-control" type="text"
								placeholder="Your Instagram account" value="<%if(loginMember != null) {%><%= loginMember.getInsta() %><%} %>">
						</div>
						<!-- <div class="d-flex align-items-center mb-3">
                            <div class="btn btn-icon btn-light btn-xs shadow-sm rounded-circle pe-none flex-shrink-0 me-3"><i class="fi-pinterest text-body"></i></div>
                            <input class="form-control" type="text" placeholder="Your Pinterest account">
                        </div> -->

					</div>
					<a
						class="collapse-label collapsed d-inline-block fs-sm fw-bold text-decoration-none pt-2 pb-3"
						href="#showMoreSocials" style="color: #8957BD;"
						data-bs-toggle="collapse" data-bs-label-collapsed="Show more"
						data-bs-label-expanded="Show less" role="button"
						aria-expanded="false" aria-controls="showMoreSocials"><i
						class="fi-arrow-down me-2" style="color: #8957BD;"></i></a>
					<div
						class="d-flex align-items-center justify-content-between border-top mt-4 pt-4 pb-1">
						<button class="btn px-3 px-sm-4" type="button" onclick="changeSave();" id="changeSave"
							style="background-color: #8957BD; color: #fff;">변경사항
							저장하기</button>
						<button class="btn btn-link btn-sm px-0" type="button" id="deleteMember" 
							onclick="deleteMember">
							<i class="fi-trash me-2"></i>회원탈퇴
						</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	    <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>