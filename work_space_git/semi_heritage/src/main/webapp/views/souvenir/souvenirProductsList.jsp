<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/views/common/headerDark.jsp"%>

<!-- Body-->
        <!-- Navbar-->
        <!-- Page content-->
        <!-- Page container-->
        <div class="container mt-5 mb-md-4 py-5">
            <div class="row py-md-1">

                <!-- Catalog grid view-->
                <!-- Page title-->
                <div class="d-flex align-items-center justify-content-between pb-3 mb-2 mt-5 pt-5" style="padding: 19%;">
                    <h1 class="text-light me-3 mt-1 mb-0">상품 목록</h1>
                    <!-- <div class="text-light">
                        <i class="fi-car fs-lg me-2"></i>
                        <span class="align-middle me-5">249 offers</span>
                    </div> -->
                </div>

                <div class="col-lg-9" style="padding-left: 20%;">
                    <!-- Breadcrumb-->
                    <nav class="mb-3 pt-md-2 pt-lg-1" aria-label="Breadcrumb">
                        <ol class="breadcrumb breadcrumb-light">
                            <li class="breadcrumb-item"><a href="10.souvenirMain.jsp">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">상품 목록</li>
                        </ol>
                    </nav>
                    <!-- Sorting + View-->
                    <div class="d-sm-flex align-items-center justify-content-between pb-4 mb-2">
                        <div class="d-flex align-items-center me-sm-4">
                            <label class="fs-sm text-light me-2 pe-1 mt-1 text-nowrap" for="sorting1">
                                <!-- <i class="fi-checkbox-checked mt-n1 me-2"></i> -->
                                카테고리 선택
                            </label>

                            <div class="d-none d-md-block border-end border-light m-lg-4" style="height: 1.25rem;"></div>
                            <select name="categories" onchange="if(this.value)location.href(this.value);" class="form-select form-select-light form-select-sm me-sm-4">
                                <option id="all" value="11.souvenirProductsListAll.jsp"> 전체</option>
                                <option value="http://www.naver.com">유아/DIY</option>
                                <option value="11.souvenirProductsListOffice.html">사무/문구</option>
                                <option value="">뷰티/미용</option>
                                <option value="">패션/잡화</option>
                                <option value="">생활/데코</option>
                                <option value="">전자/IT</option>
                                </select>
                            
                    </div>
                    <div class="row">

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">

                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="<%=path %>12.souvenirProductsDetail2.jsp"></a>
                                    <div class="position-absolute start-0 top-0 pt-3 ps-3">
                                        <!-- <span class="d-table badge bg-info">Used</span> -->
                                    </div>
                                    
                                    <div class="tns-carousel-inner">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best2.png" alt="Image">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best22.png" alt="Image">
                                    </div>
                                </div>

                                <!-- 상품 박스 설명 시작 -->
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                           
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="<%=path %>12.souvenirProductsDetail2.jsp" style="color: #A08DB4;">일월오봉도 한지조명</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">110,000원</div>
                                    <div class="fs-sm text-light opacity-70">
                                    </div>
                                </div>
                                <!-- 상품 박스 설명 끝 -->

                                <!-- 상품 박스 하단 버튼 시작 -->
                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>02.myPageCart.jsp" class="nav-link-light">장바구니</a></span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>12.souvenirProductsDetail2.jsp" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                                <!-- 상품 박스 하단 버튼 끝 -->

                            </div>
                        </div>

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">
                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="<%=path %>12.souvenirProductsDetail3.jsp"></a>
                                    
                                    <div class="tns-carousel-inner">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best3.png" alt="Image">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best3.png" alt="Image"></div>
                                </div>

                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare2">
                                            <label class="form-check-label fs-sm" for="compare2">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="<%=path %>12.souvenirProductsDetail3.jsp" style="color: #A08DB4;">일월오봉도 부채</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">6,500원</div>
                                    <!-- <div class="fs-sm text-light opacity-70"><i class="fi-map-pin me-1"></i>San Francisco</div> -->
                                </div>


                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <span class="fs-xs text-light">
                                                        <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                        <a href="<%=path %>02.myPageCart.jsp" class="nav-link-light">장바구니</a>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>12.souvenirProductsDetail2.jsp" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">
                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="<%=path %>12.souvenirProductsDetail3.jsp"></a>
                                    
                                    <div class="tns-carousel-inner">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best3.png" alt="Image">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best3.png" alt="Image"></div>
                                </div>

                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                           
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="<%=path %>12.souvenirProductsDetail3.jsp" style="color: #A08DB4;">일월오봉도 부채</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">6,500원</div>
                                  
                                </div>


                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <span class="fs-xs text-light">
                                <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                <a href="<%=path %>02.myPageCart.jsp" class="nav-link-light">장바구니</a>
                            </span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>12.souvenirProductsDetail2.jsp" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Item-->
                        <div class="col-sm-6 mb-4">
                            <div class="card card-light card-hover h-100">

                                <div class="tns-carousel-wrapper card-img-top card-img-hover">
                                    <a class="img-overlay" href="<%=path %>12.souvenirProductsDetail2.jsp"></a>
                                    <div class="position-absolute start-0 top-0 pt-3 ps-3">
                                        <!-- <span class="d-table badge bg-info">Used</span> -->
                                    </div>
                                    
                                    <div class="tns-carousel-inner">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best2.png" alt="Image">
                                        <img src="<%=path %>/resources/img/naim/10.souvir.best22.png" alt="Image">
                                    </div>
                                </div>

                                <!-- 상품 박스 설명 시작 -->
                                <div class="card-body">
                                    <div class="d-flex align-items-center justify-content-between pb-1">
                                        <span class="fs-sm text-light me-3">생활/데코</span>
                                        <div class="form-check form-check-light">
                                            <!-- <input class="form-check-input" type="checkbox" id="compare1"> -->
                                            <!-- <label class="form-check-label fs-sm" for="compare1">Compare</label> -->
                                        </div>
                                    </div>
                                    <h3 class="h6 mb-1">
                                        <a class="nav-link-light" href="<%=path %>12.souvenirProductsDetail2.jsp" style="color: #A08DB4;">일월오봉도 한지조명</a>
                                    </h3>
                                    <div class="text-primary fw-bold mb-1 ms-1">110,000원</div>
                                    <div class="fs-sm text-light opacity-70">
                                    </div>
                                </div>
                                <!-- 상품 박스 설명 끝 -->

                                <!-- 상품 박스 하단 버튼 시작 -->
                                <div class="card-footer border-0 pt-0">
                                    <div class="border-top border-light pt-3">
                                        <div class="row g-2">
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-cart d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>02.myPageCart.jsp" class="nav-link-light">장바구니</a></span>
                                                </div>
                                            </div>
                                            <div class="col me-sm-1">
                                                <div class="bg-dark rounded text-center w-100 h-100 p-2">
                                                    <i class="fi-eye-on d-block h4 text-light mb-0 mx-center"></i>
                                                    <span class="fs-xs text-light"><a href="<%=path %>12.souvenirProductsDetail2.jsp" class="nav-link-light">상세보기</a></span>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <!-- 상품 박스 하단 버튼 끝 -->

                            </div>
                        </div>
                    </div>
                    <!-- Sorting + Pagination-->
                    <div class="d-flex align-items-center justify-content-between py-2">

                        <nav aria-label="Pagination">
                            <ul class="pagination pagination-light mb-0">
                                <li class="page-item d-sm-none text-nowrap"><span class="page-link page-link-static">1 / 5</span></li>
                                <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                                </li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                                <li class="page-item d-none d-sm-block">...</li>
                                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                                <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i class="fi-chevron-right"></i></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Footer-->
    <%@include file="/views/common/footer.jsp"%>
    

   