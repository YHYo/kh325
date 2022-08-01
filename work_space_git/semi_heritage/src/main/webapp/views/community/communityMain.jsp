<%@page import="semi.heritage.community.vo.CommunityBoard"%>
<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/headerLight.jsp" %>
<!-- 헤더 -->

<%
	List<CommunityBoard> list1 = (List<CommunityBoard>)request.getAttribute("list1");

%>

<style>
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
</style>
<!-- Hero-->
<section class="jarallax bg-dark zindex-1 py-xxl-5" data-jarallax data-speed="0.5"><span class="img-overlay bg-transparent opacity-80" style="background-image: linear-gradient(0deg, rgba(31, 27, 45, .7), rgba(31, 27, 45, .7));"></span>
    <div class="jarallax-img" style="background-image: url(<%=path%>/resources/img/semi-img/community.jpg);"></div>
    <div class="content-overlay container py-md-5">
        <div class="mt-5 mb-md-5 py-5">
            <div class="col-xl-6 col-lg-8 col-md-10 mx-auto mb-sm-5 mb-4 px-0 text-center">
                <h1 class="display-5 text-light mt-sm-5 my-4">사뿐사뿐<span class="dropdown d-inline-block ms-2"><a
          class="dropdown-toggle text-decoration-none" href="#" role="button" data-bs-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false" >커뮤니티</a><span
          class="dropdown-menu dropdown-menu-end my-1"><a
          class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=T">함께해요</a><a
          class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=H">역사연구소</a><a
          class="dropdown-item fs-base fw-bold" href="<%=path%>/community/list?type=F">자유게시판</a></span></span>
                </h1>
                <p class="fs-lg text-white">문화재 관람 및 행사를 함께하고, 우리의 역사를 함께 연구하고, 함께 자유로이 소통하는 공간</p>
            </div>
            <div class="col-xl-8 col-lg-9 col-md-10 mx-auto px-0">
                <!-- Search form-->
                <form class="form-group d-block d-md-flex position-relative rounded-md-pill mb-2 mb-sm-4 mb-lg-5">
                    <div class="input-group input-group-lg border-end-md"><span class="input-group-text text-muted rounded-pill ps-3"><i class="fi-search"></i></span>
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
        <section class="d-sm-flex justify-content-between pt-2">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">커뮤니티</li>
            </ol>
            <!-- Action buttons -->
            <a class="btn btn-primary btn-lg d-block " href="1boardWriting.html">
                    게시글등록</a>
        </section>
        </div>
    </nav>
    <br>
    <!-- Light table head -->
    <div class="d-sm-flex align-items-center justify-content-between ">
        <h1 class="h2 mb-2"> <i class="fi-friends"></i> 함께해요</h1><a class="btn btn-link fw-normal p-0" href="<%=path%>/community/list?type=T">더보기<i class="fi-arrow-long-right ms-2"></i></a>
    </div>
    </h1>
    <hr>
    <div class="table-responsive">
        <table class="table" id="to_board" cellspacing="0">
            <tbody>
            	<%if(list1 == null || list1.isEmpty()) {%>
            		<%-- 게시글이 없는 상황 --%>
            		<tr>
            			<td colspan="4">
            				조회된 게시글이 없습니다.
            			</td>
            		</tr>
            	<%} else {%>
            		<%-- 게시글 리스트 시작 --%>
            		<%for(CommunityBoard b : list1) {%>
            			<tr>
            				<td>
            					<!-- <a href="<%=path+"/board/view?boardNo="+b.getNo()%>"><%=b.getTitle() %></a> -->
            					<a href="<%=path+"community/view?type=F&boardNo="+b.getNo()%>"><%=b.getTitle() %></a>
            				</td>
            				<td><%=b.getuName() %></td>
            				<%-- 게시판 추천은 없는 것이라서 임의로 작성일 넣음 --%>
            				<td><%=b.getCreate_date() %></td>
            				<td><%=b.getReply_count() %></td>
            			</tr>
            		<%} %>
            	<%} %>
                <!-- <tr>
                    <td>안양->파주 / 1박 2일 함께 가실분?!</td>
                    <td>유나영</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>[16th] 소피의 사뿐사뿐 투어 모집합니다.</td>
                    <td>전소피아</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>(男마감)안동하회마을 게스트하우스 벙개(25세-37세) </td>
                    <td>안동주인장</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>[5번째 독도투어] 함께해요!!</td>
                    <td>나임 킴</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>8월 15일 청와대 함께하실분!!</td>
                    <td>정원일</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>안양->파주 / 1박 2일 함께 가실분?!</td>
                    <td>유나영</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>[16th] 소피의 사뿐사뿐 투어 모집합니다.</td>
                    <td>전소피아</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>(男마감)안동하회마을 게스트하우스 벙개(25세-37세) </td>
                    <td>안동주인장</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>[5번째 독도투어] 함께해요!!</td>
                    <td>나임 킴</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>8월 15일 청와대 함께하실분!!</td>
                    <td>정원일</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr> -->
            </tbody>
        </table>
    </div>
    <br>
    <div class="left table-responsive">
        <div class="d-sm-flex align-items-center justify-content-between ">
            <h1 class="h2 mb-2 "> <i class="fi-search"></i> 역사연구소</h1><a class="btn btn-link fw-normal p-0" href="<%=path%>/community/list?type=H">더보기<i class="fi-arrow-long-right ms-2"></i></a>
        </div>
        </h1>
        <table class="table">
            <thead class="thead-light">
            </thead>
            <tbody>
                <tr>
                    <td>고구려 벽화와 일본벽화 특징</td>
                    <td>하영쓰</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>한국사 1급의 가치에 대해서</td>
                    <td>정온리원</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>독도가 한국땅인 이유</td>
                    <td>수아 정</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>美 뉴욕에서 최초로 선보인 신라금관</td>
                    <td>William</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>마한의 왕족과 귀족들은 사실 고구려로 많이 향했지.</td>
                    <td>서녕채</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="right table-responsive">
        <div class="d-sm-flex align-items-center justify-content-between ">
            <h1 class="h2 mb-2"><i class="fi-chat-right"></i> 자유게시판</h1><a class="btn btn-link fw-normal p-0" href="<%=path%>/community/list?type=F">더보기<i class="fi-arrow-long-right ms-2"></i></a>
        </div>
        <hr>
        <table class="table">
            <thead class="thead-light">
            </thead>
            <tbody>
                <tr>
                    <td>귀여운 달팽이 분양받으실 분?</td>
                    <td>형채군</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>횐님덜,, 거제에서 올라왔읍니다,,,인사박겠읍니다,,,</td>
                    <td>길라임</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>저희집 고양이 좀 보고가세요. </td>
                    <td>소피</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>코딩 참 쉽지 않나요? </td>
                    <td>빛해성</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
                <tr>
                    <td>신입생활 질문드립니다.. </td>
                    <td>미향</td>
                    <td><em class="fi-like"></em>&nbsp;15</td>
                    <td><em class="fi-chat-right">&nbsp;2</td>
                </tr>
            </tbody>
        </table>
    </div>
</section>
<selection> </selection>

</main>
<br><br><br><br> 


<!-- 푸터 -->
<%@ include file="/views/common/footer.jsp" %>