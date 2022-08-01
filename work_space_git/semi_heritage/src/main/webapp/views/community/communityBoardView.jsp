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

<!-- Page container-->
<div class="container mt-5 mb-md-4 py-5">
    <!-- Breadcrumb-->
    <nav class="mb-3 pt-md-3" aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a></li>
            <li class="breadcrumb-item"><a href="<%=path%>/community/main">커뮤니티</a></li>
            <li class="breadcrumb-item"><a href="<%=path%>/community/list?type=F"><%=boardName %></a></li>
            <li class="breadcrumb-item active" aria-current="page"><%=b.getTitle() %></li>
        </ol>
    </nav>
    <br>
    <!-- Post title + meta-->
    <div class="mar">
        <h1 class="h2 mb-4"><%=b.getTitle() %></h1>
        <div class="mb-4 pb-1">
            <ul class="list-unstyled d-flex flex-wrap mb-0 text-nowrap">
                <!-- <li class="me-3"><i class="fi-calendar-alt me-2 mt-n1 opacity-60"></i>Mar 18</li> -->
                <li class="me-3"><i class="fi-calendar-alt me-2 mt-n1 opacity-60"></i><%=b.getCreate_date() %></li>
                <li class="me-3 border-end"></li>
                <!-- <li class="me-3"><i class="fi-clock me-2 mt-n1 opacity-60"></i>4 min read</li> -->
                <li class="me-3"><i class="fi-clock me-2 mt-n1 opacity-60"></i><%=b.getReadCount() %></li>
                <li class="me-3 border-end"></li>
                <!-- <li class="me-3"><a class="nav-link-muted" href="#comments" data-scroll><i class="fi-chat-circle me-2 mt-n1 opacity-60"></i>3 comments</a></li> -->
                <li class="me-3"><a class="nav-link-muted" href="#comments" data-scroll><i class="fi-chat-circle me-2 mt-n1 opacity-60"></i><%=b.getReply_count() %></a></li>
            </ul>
        </div>
        <!-- Post content-->
        <div class="mb-4 pb-md-3"><img class="rounded-3" src="img/spsp/tazza.JPG" alt="Post image"></div>
        <div class="row">
            <div class="col-lg-2 col-md-1 mb-md-0 mb-4 mt-md-n5">
                <!-- Sharing-->
                <div class="sticky-top py-md-1 mt-md-1">
                    <div class="d-flex flex-md-column align-items-center my-1 mt-md-1 pt-md-1">
                        <div class="d-md-none fw-bold text-nowrap me-0 pe-0">Share:</div>
                        <a class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle mb-md-2 me-md-0 me-2" href="#" data-bs-toggle="tooltip" title="Share with Facebook"><i class="fi-facebook"></i></a>
                        <a class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle mb-md-2 me-md-0 me-2" href="#" data-bs-toggle="tooltip" title="Share with Twitter">
                            <i class="fi-twitter"></i></a>
                        <a class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle mb-md-2 me-md-0 me-2" href="#" data-bs-toggle="tooltip" title="Share with LinkedIn"><i class="fi-linkedin"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-10">
                <!-- Author-->
                <div class="mb-4 pb-md-3">
                    <a class="d-flex align-items-center text-body text-decoration-none" href="#"><img class="rounded-circle" src="img/avatars/sophie.jpg" width="80" alt="Kristin Watson">
                        <div class="ps-3">
                            <h2 class="h6 mb-1"><%=b.getuName() %></h2><span class="fs-sm">일반회원</span>
                        </div>
                    </a>
                </div>
                <!-- Post content-->
                <textarea name="content" cols="50" rows="15" readonly="readonly" ><%=b.getContent() %></textarea>
                <!-- <h6>피곤해 죽겠다 진짜</h6>
                <p>앞으로 뭐해먹고 사냐.. 어느 날 아침, 저는 경복궁 향원정을 가고 싶었죠. 저희집은 흑석동인데 파란 시내버스를 타고 가야한답니다. 1시간쯤은 걸릴 것 같아요. 근데 요즘 비가 계속 와서 힘들 것 같아요. 가을에나 가볼까요? 사랑스런 남친과 함께 가볼까 합니다. 아 자바해야 하는데, 왜이리 하고 싶은 게 많을까요? 작업하면서 보니 사진이 참 이쁘긴 하네요.</p>
                <p>영화 타짜보고싶다. 지금 신화방송 보는중</p>
                <blockquote class="blockquote">
                    <p> 먹고 살기 힘들다 고니야 </p>
                    <footer class="fs-base">— 타짜 명대사</footer>
                </blockquote>
                <p>나 이대나온 여자야</p>
                <p>묻고 더블로 가!!</p>
                <p>싸늘하다, 가슴에 비수가 날아와 꽃힌다. 하지만 걱정하지마라. 손은 눈보다 빠르니까. 아귀한테 밑에서 한장, 정마담한테 밑에서 한장, 나한테 한장, 아귀한테 밑에서 한장, 정마담한테 밑에서 한장...!</p> -->
            </div>
            <!-- 게시판 종료 -->
            <!-- 리플 등록 시작 -->
            <div class="mb-4 mb-md-5" id="comments">
                <h3 class="mb-4 pb-2"><%=b.getReply_count() %> comments</h3>
                <!-- Comment-->
                <div class="border-bottom pb-4 mb-4">
                	<%for(CommunityReply reply: b.getReplies()) { %>
                		<p><%=reply.getContent() %></p>
		                <div class="d-flex justify-content-between align-items-center">
		                    <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/05.jpg" width="48" alt="Daniel Adams">
		                        <div class="ps-2">
		                            <h6 class="fs-base mb-0"><%=reply.getuName() %></h6><span class="text-muted fs-sm"><%=reply.getCreate_date() %></span>
		                        </div>
		                    </div>
		                    
		                    
		                    <%-- <%if(loginMember != null && loginMember.getUno().equals(reply.getuNo())) {%>
			                    <button class="btn btn-link btn-sm" type="button" onclick="deleteReply(<%=reply.getNo()%>,<%=reply.getBoard_no()%>)"><i class="fi-reply fs-lg me-2"></i><span class="fw-normal">삭제</span></button>
		                    <%} %> --%>
		                    
		                    
		                    <button class="btn btn-link btn-sm" type="button"><i class="fi-reply fs-lg me-2"></i><span class="fw-normal">Reply</span></button>
		                </div>
                	<%} %>
                </div>
                
                <div class="border-bottom pb-4 mb-4">
                    <p>Elementum ut quam tincidunt egestas vitae elit, hendrerit. Ullamcorper nulla amet lobortis elit, nibh condimentum enim. Aliquam felis nisl tellus sodales lectus dictum tristique proin vitae. Odio fermentum viverra tortor quis
                        reprehenderit in voluptate velit.</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/05.jpg" width="48" alt="Daniel Adams">
                            <div class="ps-2">
                                <h6 class="fs-base mb-0">Daniel Adams</h6><span class="text-muted fs-sm">3 days ago</span>
                            </div>
                        </div>
                        <button class="btn btn-link btn-sm" type="button"><i class="fi-reply fs-lg me-2"></i><span class="fw-normal">Reply</span></button>
                    </div>
                    <!-- Reply to comment-->
                    <div class="border-start border-4 ps-4 ms-4 mt-4">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                        <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/06.jpg" width="48" alt="Kristin Watsons">
                            <div class="ps-2">
                                <h6 class="fs-base mb-0">Kristin Watsons<span class="badge bg-info rounded-pill fs-xs ms-2">Author</span></h6><span class="text-muted fs-sm">2 days ago</span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Comment-->
                <div class="pb-4">
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim
                        ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/04.jpg" width="48" alt="Darrel Steward">
                            <div class="ps-2">
                                <h6 class="fs-base mb-0">Darrel Steward</h6><span class="text-muted fs-sm">1 week ago</span>
                            </div>
                        </div>
                        <button class="btn btn-link btn-sm" type="button"><i class="fi-reply fs-lg me-2"></i><span class="fw-normal">Reply</span></button>
                    </div>
                </div>
            </div>
            
            
        </div>
    </div>
    <!-- Comment form-->
    <div class="card py-md-4 py-3 shadow-sm">
        <div class="card-body col-lg-8 col-md-10 mx-auto px-md-0 px-4">
            <h3 class="mb-4 pb-sm-2">Leave your comment</h3>
            <form class="needs-validation row gy-md-4 gy-3" novalidate>
                <div class="col-sm-6">
                    <label class="form-label" for="comment-name">Name</label>
                    <input class="form-control form-control-lg" type="text" id="comment-name" value="<%=b.getuName()%>" required readonly>
                    <div class="invalid-feedback">로그인을 해주세요.</div>
                </div>
                <div class="col-sm-6">
                    <label class="form-label" for="comment-email">Email</label>
                    <input class="form-control form-control-lg" type="email" id="comment-email" value=" placeholder="Enter your email" required>
                    <div class="invalid-feedback">Please provide a valid email address.</div>
                </div>
                <div class="col-12">
                    <label class="form-label" for="comment-text">Comment</label>
                    <textarea class="form-control form-control-lg" id="comment-text" rows="4" placeholder="Type comment here" required></textarea>
                    <div class="invalid-feedback">댓글 내용을 작성해주세요.</div>
                </div>
                <div class="col-12 py-2">
                    <button class="btn btn-lg btn-primary" type="submit">댓글 등록</button>
                </div>
            </form>
        </div>
    </div>
</div>





<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>