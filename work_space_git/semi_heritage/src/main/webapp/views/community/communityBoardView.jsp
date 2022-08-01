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
	String fileName = b.getOriginal_file();
	String fileReName = b.getRenamed_file();
	
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
<style>
	.contentBox {
		width: 100%;
	}
	.replyuNo {
		display:none;
	}
</style>

<!-- Hero-->
<section class="jarallax bg-dark zindex-1 " data-jarallax data-speed="0.5">
    <span class="img-overlay bg-transparent opacity-80" style="background-image: linear-gradient(0deg, rgba(31, 27, 45, .7), rgba(31, 27, 45, .7));"></span>
    <div class="jarallax-img" style="background-image: url(<%=path%>/resources/img/semi-img/community.jpg);"></div>
    <div class="content-overlay container">
        <div class="mt-4 mb-md-1 py-5">
            <div class="col-xl-6 col-lg-8 col-md-10 mx-auto mb-sm-5 mb-4 px-0 text-center">
                <h1 class="display-5 text-light mt-sm-5 my-4">사뿐사뿐<span class="dropdown d-inline-block ms-2"><a
        class="dropdown-toggle text-decoration-none" href="#" role="button" data-bs-toggle="dropdown"
        aria-haspopup="true" aria-expanded="false" >커뮤니티</a><span
        class="dropdown-menu dropdown-menu-end my-1"><a
        class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=T">함께해요</a><a
        class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=H">역사연구소</a><a
        class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=F">자유게시판</a></span></span>
                </h1>
                <p class="fs-lg text-white">문화재 관람 및 행사를 함께하고, 우리의 역사를 함께 연구하고 <br>함께 자유로이 소통하는 공간</p>
            </div>

        </div>
    </div>
    <div class="position-absolute d-none d-xxl-block bottom-0 start-0 w-100 bg-white zindex-1" style="border-top-left-radius: 30px; border-top-right-radius: 30px; height: 30px;"></div>
</section>
<!-- Page container-->
<div class="container mt-1 mb-md-1 py-1">
    <!-- Breadcrumb-->
    <nav class="mb-1 pt-md-1" aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a></li>
            <li class="breadcrumb-item"><a href="<%=path%>/community/main">커뮤니티</a></li>
            <li class="breadcrumb-item"><a href="<%=path%>/community/list?type=<%=type%>"><%=boardName %></a></li>
            <li class="breadcrumb-item active" aria-current="page"><%=b.getTitle() %></li>
        </ol>
    </nav>
    <br>
    <!-- Post title + meta-->
    <!-- <div class="mar"> -->
    <div class="row">
        <h1 class="h2 mb-4"><%=b.getTitle() %></h1>
        <div class="mb-xxl-n4 pb-0 ">
            <ul class="list-unstyled flex-wrap mb-0 text-nowrap">
                <!--d-flex-->
                <!-- 글쓴이 Author-->
                <div class="mb-4 pb-md-3 left-box">
                    <a class="d-flex align-items-center text-body text-decoration-none" href="#"><img class="rounded-circle" src="img/avatars/sophie.jpg" width="38" alt="프사">
                        <div class="ps-3">
                            <h2 class="h6 mb-1"><%=b.getuName() %></h2>
                        </div>
                    </a>
                </div>
                <div class="d-flex right-box">
                    <li class="me-3"></li>
                    <!-- <li class="me-3 border-end"></li> -->
                    <li class="me-3"><i class="fi-calendar-alt me-2 mt-n1 opacity-60"></i><%=b.getCreate_date() %></li>
                    <!-- <li class="me-3 border-end"></li> -->
                    <li class="me-3"><i class="fi-eye-on me-2 mt-n1 opacity-60"></i><%=b.getReadCount() %></li>
                    <!-- <li class="me-3 border-end"></li> -->
                    <li class="me-3"><a class="nav-link-muted" href="#comments" data-scroll><i class="fi-chat-circle me-2 mt-n1 opacity-60"></i><%=b.getReply_count() %> comments</a></li>
                </div>
            </ul>
        </div>
        <hr><br>
        <div>
            <!-- Post content-->
            <!-- <div class="mb-4 pb-md-3"> -->
            <img class="rounded-3" src="img/spsp/tazza.JPG" alt="Post image">
            <!-- </div> -->
            <br><br><br>
            <div class="contentBox"><%=b.getContent() %></div>
            <!-- <p>명대사가 두고두고 생각이 나네요. 리플로 명대사 놀이나 할까요?</p>
            <p>앞으로 뭐해먹고 사나.. </p>
            <p> 걱정 들때마다 타짜의 쓴 대사들이 생각이 나네요.</p>
            <p>영화 타짜보고싶다. 지금 신화방송 보는중</p>
            <blockquote class="blockquote">
                <p> 먹고 살기 힘들다 고니야 </p>
                <footer class="fs-base">— 타짜 명대사</footer>
            </blockquote>
            <p>나 이대나온 여자야</p>
            <p>묻고 더블로 가!!</p>
            <p>싸늘하다, 가슴에 비수가 날아와 꽃힌다. 하지만 걱정하지마라. </p>
            <p> 손은 눈보다 빠르니까. </p>
            <p> 아귀한테 밑에서 한장, 정마담한테 밑에서 한장, 나한테 한장, 아귀한테 밑에서 한장, 정마담한테 밑에서 한장...!</p> -->
            <br>
        </div>
    </div>
    <br>
    <hr><br>
    <!-- Comments-->
    <div class="mb-4 mb-md-5" id="comments">
        <h3 class="mb-4 pb-2">전체 댓글 <%=b.getReply_count() %>개</h3>
        
        <!-- Comment-->
        <%for(CommunityReply reply: b.getReplies()) { %>
	        <div class="border-bottom pb-4 mb-4">
	            <div class="d-flex justify-content-between align-items-center">
	                <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/naIm.png" width="48" alt="프사">
	                    <div class="ps-2">
	                        <h6 class="fs-base mb-0"><%=reply.getuName() %></h6><span class="text-muted fs-sm"><%=reply.getCreate_date() %></span>
	                    </div>
	                </div>
	                <button class="btn btn-link btn-sm" type="button"><i class="fi-reply fs-lg me-2"></i><span class="fw-normal">Reply</span></button>
	            </div>
				<div class="replyBox"><%=reply.getContent() %></div>
	        </div>
        <%} %>
        <!-- Comment-->

    <!-- Comment form  col-lg-8 col-md-10 px-md-0 px-4 mx-auto  -->
    <div class="card py-md-4 py-3 shadow-sm">
        <div class="card-body ">
            <h3 class="mb-4 pb-sm-2">댓글남기기</h3>
            <form class="needs-validation row gy-md-4 gy-3" action="<%=request.getContextPath()%>/community/reply?type=<%=type %>>" method="post">
                <!-- <div class="col-sm-6">
                    <label class="form-label" for="comment-name">닉네임</label>
                    <input class="form-control form-control-lg" type="text" id="comment-name" placeholder="전소피아" required>
                    <div class="invalid-feedback">Please enter your name.</div>
                </div>
                <div class="col-sm-6">
                    <label class="form-label" for="comment-email">Email</label>
                    <input class="form-control form-control-lg" type="email" id="comment-email" placeholder="pinkychuchu@gmail.com" required>
                    <div class="invalid-feedback">Please provide a valid email address.</div>
                </div> -->
                <div class="col-12">
                    <!-- <label class="form-label" for="comment-text">댓글</label> -->
                    
                    
                    <!-- 로그인한 회원 정보 받아서 리플 작성자로 넣어야 함 -->
                    
                    <!-- <div class="replyuNo"><%-- <%=loginMember.getUno() %> --%>></div> -->
                    <textarea class="form-control form-control-lg" id="comment-text" rows="4" placeholder="댓글을 남겨주세요" required></textarea>
                    <div class="invalid-feedback">댓글을 남겨주세요</div>
                </div>
                <div class="col-12 py-2 right-box">
                    <button class="btn btn-lg btn-primary right-box" type="submit">등록</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>