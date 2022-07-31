<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="semi.heritage.community.vo.communityBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Header -->
<%@ include file="/views/common/headerLight.jsp" %>

<%
	List<communityBoard> list = (List<communityBoard>)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	String searchType = "title";
	String searchValue = "";
	String searchParamValue = request.getParameter("searchValue");
	if(searchParamValue != null && searchParamValue.length() > 0) {
		searchType = request.getParameter("searchType");
		searchValue = request.getParameter("searchValue");
	}
%>
       <!-- Page content-->
        <!-- Hero-->
        <section class="jarallax bg-dark zindex-1 " data-jarallax data-speed="0.5"><span class="img-overlay bg-transparent opacity-80" style="background-image: linear-gradient(0deg, rgba(31, 27, 45, .7), rgba(31, 27, 45, .7));"></span>
            <div class="jarallax-img" style="background-image: url(img/spsp/community.jpg);"></div>
            <div class="content-overlay container ">
                <div class="mt-5 mb-md-5 py-1">
                    <div class="col-xl-6 col-lg-8 col-md-10 mx-auto mb-sm-5 mb-4 px-0 text-center">
                        <h1 class="display-5 text-light mt-sm-5 my-4">사뿐사뿐<span class="dropdown d-inline-block ms-2"><a
                                    class="dropdown-toggle text-decoration-none" href="#" role="button"
                                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="1boardMain.html">커뮤니티</a><span
                                    class="dropdown-menu dropdown-menu-end my-1"><a
                                        class="dropdown-item fs-base fw-bold" href="1boardMainTogether.html">함께해요</a><a
                                        class="dropdown-item fs-base fw-bold" href="1boardMainStudy.html">역사연구소</a><a
                                        class="dropdown-item fs-base fw-bold" href="1boardMainFree.html">자유게시판</a></span></span>
                        </h1>
                        <!-- <p class="fs-lg text-white">문화재 관람 및 행사를 함께하고, 우리의 역사를 함께 연구하고,
                            <br>함께 자유로이 소통하는 공간</p> -->
                    </div>
                    <div class="col-xl-8 col-lg-9 col-md-10 mx-auto px-1">
                        <!-- Search form-->
                        <form class="form-group d-block d-md-flex position-relative rounded-md-pill mb-2 mb-sm-4 mb-lg-5">
                            <div class="input-group input-group-lg border-end-md"><span class="input-group-text text-muted rounded-pill ps-3"><i
                                        class="fi-search"></i></span>
                                <input class="form-control" type="text" placeholder="관심있는 내용을 검색해보세요!">
                            </div>
                            <hr class="d-md-none my-2">
                            <div class="d-sm-flex">
                                <div class="dropdown w-100 mb-sm-0 mb-3" data-bs-toggle="select">
                                    <button class="btn btn-link btn-lg dropdown-toggle ps-2 ps-sm-3" type="button" data-bs-toggle="dropdown"><i class="fi-list me-2"></i><span
                                        class="dropdown-toggle-label">제목+내용</span></button>
                                    <input type="hidden">
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#"><i
                                            class="fi-bed fs-lg opacity-60 me-2"></i><span
                                            class="dropdown-item-label">제목+내용</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                class="fi-bed fs-lg opacity-60 me-2"></i><span
                                                class="dropdown-item-label">제목</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                        class="fi-cafe fs-lg opacity-60 me-2"></i><span
                                                        class="dropdown-item-label">내용</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                        class="fi-shopping-bag fs-lg opacity-60 me-2"></i><span
                                                        class="dropdown-item-label">글쓴이</span></a></li>
                                    </ul>
                                </div>
                                <button class="btn btn-primary btn-lg rounded-pill w-100 w-md-auto ms-sm-3" type="button">Search</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="position-absolute d-none d-xxl-block bottom-0 start-0 w-100 bg-white zindex-1" style="border-top-left-radius: 30px; border-top-right-radius: 30px; height: 30px;"></div>
        </section>
        <!-- Page header-->
        <section class="container pt-1 mt-1">
            <!-- Breadcrumb-->
            <nav class="mb-2 pt-md-2" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a></li>
                    <li class="breadcrumb-item"><a href="1boardMain.html">커뮤니티</a></li>
                    <li class="breadcrumb-item active" aria-current="page">역사연구소</li>
                </ol>
            </nav>
            <br>
            <!-- Light table head -->
            <div class="d-sm-flex align-items-center justify-content-between ">
                <h1 class="h2 mb-2"> <i class="fi-search"></i> 역사연구소</h1>
            </div>
            </h1>
            <div class="table-responsive">
                <table class="table" cellspacing="0" style="text-align:center">
                    <thead class="thead-light">
                        <tr>
                            <th>번호</th>
                            <th>글제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회</th>
                            <th>리플</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>10</td>
                            <td style="text-align:left">고구려 벽화와 일본벽화 특징</td>
                            <td>하영쓰</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td style="text-align:left">한국사 1급의 가치에 대해서</td>
                            <td>정온리원</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td style="text-align:left">美 뉴욕에서 최초로 선보인 신라금관</td>
                            <td>William</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td style="text-align:left">마한의 왕족과 귀족들은 사실 고구려로 많이 향했지.</td>
                            <td>서녕채</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td style="text-align:left">독도가 한국땅인 이유</td>
                            <td>수아 정</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td style="text-align:left">고구려 벽화와 일본벽화 특징</td>
                            <td>하영쓰</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td style="text-align:left">한국사 1급의 가치에 대해서</td>
                            <td>정온리원</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td style="text-align:left">美 뉴욕에서 최초로 선보인 신라금관</td>
                            <td>William</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td style="text-align:left">마한의 왕족과 귀족들은 사실 고구려로 많이 향했지.</td>
                            <td>서녕채</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td style="text-align:left">독도가 한국땅인 이유</td>
                            <td>수아 정</td>
                            <td>22/07/18</td>
                            <td><em class="fi-eye-on"></em>&nbsp;20</td>
                            <td><em class="fi-chat-right"></em>&nbsp;5</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div>
                <!--게시글 하단-->
                <div class="d-flex right-box">
                    <!-- 게시글등록 버튼 Action buttons -->
                    <a class="btn btn-primary btn-lg d-block right" href="1boardWriting.html">
                        게시글등록</a>
                </div>
                <!-- 페이지 번호 Pagination-->
                <div class="d-flex left-box">
                    <nav class="mt-2 mb-4" aria-label="Reviews pagination">
                        <ul class="pagination">
                            <li class="page-item d-sm-none"><span class="page-link page-link-static">1 / 5</span></li>
                            <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                            </li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                            <li class="page-item d-none d-sm-block">...</li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i
                                    class="fi-chevron-right"></i></a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </section>
        <selection> <br><br><br><br><br><br><br><br><br></selection>

    </main>
 

<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>