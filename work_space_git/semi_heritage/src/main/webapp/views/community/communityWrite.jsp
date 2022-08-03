<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="semi.heritage.community.vo.CommunityBoard"%>
<%@page import="semi.heritage.community.vo.CommunityReply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Header -->
<%@ include file="/views/common/headerLight.jsp" %>

<%
	CommunityBoard b = (CommunityBoard)request.getAttribute("board");

	String type = request.getParameter("type");
	String boardName = "";
	if(type.equals("T")) {
		boardName = "함께해요";
	}
	if(type.equals("H")) {
		boardName = "역사연구소";
	}
	if(type.equals("F")) {
		boardName = "자유게시판";
	}
%>

<!-- Hero-->
<section class="jarallax bg-dark zindex-1 " data-jarallax data-speed="0.5"><span class="img-overlay bg-transparent opacity-80" style="background-image: linear-gradient(0deg, rgba(31, 27, 45, .7), rgba(31, 27, 45, .7));"></span>
<div class="jarallax-img" style="background-image: url(<%=path%>/resources/img/semi-img/community.jpg);"></div>
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
        <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a>
        </li>
        <li class="breadcrumb-item"><a href="1boardMain.html"> 커뮤니티</a></li>
        <li class="breadcrumb-item active" aria-current="page">글쓰기</li>
    </ol>
</nav>
<br>
<!-- 글쓰기 -->
<!-- Title-->
<div class="mar">
    <div class="mb-4 text-center center-block">
        <h1 class="h2 mb-0">글쓰기</h1>
    </div>
    <!-- Basic info-->
    <section class="card card-body border-0 shadow-sm p-4 mb-4" id="basic-info">
    <form action="<%=request.getContextPath()%>/community/write" method="POST" enctype="multipart/form-data">
        <div>
            <h2 class="h4 mb-4"><i class="fi-pencil text-primary fs-5 mt-n1 me-2"></i>Write</h2>
            <label class="form-label" for="ap-title">제목<span class="text-danger">*</span></label>
            <input class="form-control" type="text" id="ap-title" placeholder="제목을 입력하세요" name="ap-title" value="" required>
        </div>
        <br>
        <div>
            <label class="form-label" for="ap-category">게시판선택 <span class="text-danger">*</span></label>
            <select class="form-select" id="ap-category" name="ap-category" required>
                <option value="T">함께해요</option>
                <option value="H">역사연구소</option>
                <option value="F">자유게시판</option>
            </select>
        </div>
        <br>
        <div>
            <label class="form-label" for="ap-category">내용<span class="text-danger">*</span></label>
            <textarea class="form-control" id="ap-description" name="ap-description" rows="12" placeholder="내용을 입력하세요"></textarea><span class="form-text">1500 characters
                    left</span>

        </div>
        <br>
        <!-- 파일첨부 Photos / video-->
        <h2 class="h4 mb-4"><i class="fi-image text-primary fs-5 mt-n1 me-2"></i>Photos / video</h2>
        <div class="alert alert-info mb-4" role="alert">
            <div class="d-flex"><i class="fi-alert-circle me-2 me-sm-3"></i>
                <p class="fs-sm mb-1">최대 사진 크기는 8MBd입니다(jpeg, jpg, png).
                    <br>최대 비디오 크기는 10MB입니다(형식: mp4, mov).</p>
            </div>
        </div>
        <input class="file-uploader file-uploader-grid" type="file" name="upfile" multiple data-max-file-size="10MB" accept="image/png, image/jpeg, video/mp4, video/mov" data-label-idle="&lt;div class=&quot;btn btn-primary mb-3&quot;&gt;&lt;i class=&quot;fi-cloud-upload me-1&quot;&gt;&lt;/i&gt;Upload photos / video&lt;/div&gt;&lt;br&gt;or drag them in">
        <!-- Action buttons -->
        <div class="mar2">
            <section class="mar d-sm-flex justify-content-between pt-4">
                <a class="btn btn-primary btn-lg d-block mb-1" href="javascript:history.back();">글쓰기</a>
            </section>
        </div>
    </form>
    </section>
</div>




<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>