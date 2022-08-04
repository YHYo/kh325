<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="semi.heritage.community.vo.CommunityBoard"%>
<%@page import="semi.heritage.community.vo.CommunityReply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	CommunityBoard board = (CommunityBoard)request.getAttribute("board");
	String type = (String)request.getAttribute("type");

%>

<style>
    /* 테이블 반띵 */
    
    div.left {
        width: 48%;
        float: left;
        position: relative;
    }
    
    div.right {
        width: 48%;
        float: right;
        position: relative;
    }
    
    #out {
        width: 100%;
        text-align: center;
    }
    
    #in {
        display: inline-block;
    }
    
    .align-center {
        text-align: center;
    }
    
    div.mar {
        margin-top: -25px;
        margin-right: 200px;
        margin-bottom: 30px;
        margin-left: 200px;
    }
    
    div.mar2 {
        margin-top: 20px;
        margin-right: 550px;
        margin-bottom: 10px;
        margin-left: 550px; 
    }
    
    .page-loading {
        position: fixed;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 100%;
        -webkit-transition: all .4s .2s ease-in-out;
        transition: all .4s .2s ease-in-out;
        background-color: #fff;
        opacity: 0;
        visibility: hidden;
        z-index: 9999;
    }
    
    .page-loading.active {
        opacity: 1;
        visibility: visible;
    }
    
    .page-loading-inner {
        position: absolute;
        top: 50%;
        left: 0;
        width: 100%;
        text-align: center;
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        -webkit-transition: opacity .2s ease-in-out;
        transition: opacity .2s ease-in-out;
        opacity: 0;
    }
    
    .page-loading.active>.page-loading-inner {
        opacity: 1;
    }
    
    .page-loading-inner>span {
        display: block;
        font-size: 1rem;
        font-weight: normal;
        color: #666276;
        ;
    }
    
    .page-spinner {
        display: inline-block;
        width: 2.75rem;
        height: 2.75rem;
        margin-bottom: .75rem;
        vertical-align: text-bottom;
        border: .15em solid #bbb7c5;
        border-right-color: transparent;
        border-radius: 50%;
        -webkit-animation: spinner .75s linear infinite;
        animation: spinner .75s linear infinite;
    }
    
    @-webkit-keyframes spinner {
        100% {
            -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
        }
    }
    
    @keyframes spinner {
        100% {
            -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
        }
    }
    
</style>

<script type="text/javascript">
	function post_form() {
		document.getElementById('write').submit();
	}
</script>
    
        
    
    
<!-- Header -->
<%@ include file="/views/common/headerLight.jsp" %>

<%

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
                            class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=T">함께해요</a><a
                            class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=H">역사연구소</a><a
                            class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=F">자유게시판</a></span></span>
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
<!-- <section class="container pt-1 mt-1"> -->
</section>
    <!-- Breadcrumb-->
<nav class="mb-2 pt-md-2" aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a>
        </li>
        <li class="breadcrumb-item"><a href="<%=path%>/community/main"> 커뮤니티</a></li>
        <li class="breadcrumb-item active" aria-current="page">글쓰기</li>
    </ol>
</nav>
<br>
<!-- 글쓰기 -->
<!-- Title-->
<div class="mar">
    <div class="mb-4 text-center center-block">
        <h1 class="h2 mb-0">게시글 수정</h1>
    </div>
    <!-- Basic info-->
    <section class="card card-body border-0 shadow-sm p-4 mb-4" id="basic-info">
    <form id="write" action="<%=path%>/community/update" method="POST" enctype="multipart/form-data">
    	<input type="hidden" name="boardNo type" value="<%=board.getNo() %>">
    	
        <div>
            <h2 class="h4 mb-4"><i class="fi-pencil text-primary fs-5 mt-n1 me-2"></i>Write</h2>
            <label class="form-label" for="ap-title">제목<span class="text-danger">*</span></label>
            <input class="form-control" type="text" id="ap-title" name="ap-title" value="<%=board.getTitle() %>>" required>
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
            <textarea class="form-control" id="ap-description" name="ap-description" rows="12" ><%=board.getContent()%></textarea><span class="form-text"></span>

        </div>
        <br>
        
        <!-- 기존 파일 여부 -->
        <%if(board.getOriginal_file() != null && board.getOriginal_file().length() > 0){ %>
    		<input type="hidden" name="original_file" value="<%=board.getOriginal_file()%>"/>
			<input type="hidden" name="renamed_file" value="<%=board.getRenamed_file()%>"/>
    	<%} %>
        
        <!-- 파일첨부 Photos / video-->
        <h2 class="h4 mb-4"><i class="fi-image text-primary fs-5 mt-n1 me-2"></i>Photos / video</h2>
        <div class="alert alert-info mb-4" role="alert">
            <div class="d-flex"><i class="fi-alert-circle me-2 me-sm-3"></i>
                <p class="fs-sm mb-1">파일 첨부는 최대 100MB까지 등록 가능합니다.
                    
            </div>
        </div>
        <input class="file-uploader file-uploader-grid" type="file" name="upfile" multiple data-max-file-size="100MB" accept="image/png, image/jpeg, video/mp4, video/mov" data-label-idle="&lt;div class=&quot;btn btn-primary mb-3&quot;&gt;&lt;i class=&quot;fi-cloud-upload me-1&quot;&gt;&lt;/i&gt;Upload photos / video&lt;/div&gt;&lt;br&gt;or drag them in">
        <!-- Action buttons -->
        <div class="mar2">
            <!-- <section class="mar d-sm-flex justify-content-between pt-4 writebtn"> -->
            	<!-- javascript:history.back(); -->
                <a class="btn btn-primary btn-lg d-block mb-1 writeBtn" href="#" onclick="return post_form()">수정</a>
                <a class="btn btn-primary btn-lg d-block mb-1 writeBtn" href="#" onclick="return post_form()">목록으로</a>
                <!-- <button type="submit">글쓰기</button> -->
            <!-- </section> -->
        </div>
    </form>
    </section>
</div>




<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>