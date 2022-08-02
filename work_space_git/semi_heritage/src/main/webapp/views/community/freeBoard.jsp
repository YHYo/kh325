<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="semi.heritage.community.vo.CommunityBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!-- Header -->
<%@ include file="/views/common/headerLight.jsp" %>

<%
	List<CommunityBoard> list = (List<CommunityBoard>)request.getAttribute("list");
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
              <!-- 검색창 Search form-->
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
                                            class=" fs-lg opacity-60 me-2"></i><span
                                            class="dropdown-item-label">제목+내용</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                        class="  fs-lg opacity-60 me-2"></i><span
                                                        class="dropdown-item-label">제목</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                        class=" fs-lg opacity-60 me-2"></i><span
                                                        class="dropdown-item-label">내용</span></a></li>
                                        <li><a class="dropdown-item" href="#"><i
                                                        class="  fs-lg opacity-60 me-2"></i><span
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
                    <li class="breadcrumb-item active" aria-current="page">자유게시판</li>
                </ol>
            </nav>
            <br>
            <!-- Light table head -->
            <div class="d-sm-flex align-items-center justify-content-between ">
                <h1 class="h2 mb-2"> <i class="fi-chat-right"></i> 자유게시판</h1>
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
            	<%if(list == null || list.isEmpty()) {%>
           			<%-- 게시글이 없는 상황 --%>
           			<tr>
           				<td colspan="6">조회된 게시글이 없습니다.</td>
           			</tr> 
           		<%} else {%>
           			<%-- 게시글 리스트 시작 --%>
           			<%for(CommunityBoard b : list) {%>
           				<tr>
           					<td><%=b.getNo() %></td>
           					<td>
           						<a href="<%=path+"/community/view?type=F&boardNo="+b.getNo()%>"><%=b.getTitle() %></a>
           					</td>
           					<td><%=b.getuName() %></td>
           					<td><%=b.getCreate_date() %></td>
           					<td><%=b.getReadCount() %></td>
           					<td><%=b.getReply_count() %></td>
           				</tr>
           			<%} %>
           			<%-- 게시글 리스트 끝 --%>
           		<%} %>
           		
            </tbody>
        </table>
   
	</div>

    <div>
        <!-- 페이지 번호 Pagination-->
        <nav class="mt-2 mb-4" aria-label="Reviews pagination">
            <ul class="pagination">
                <li class="page-item d-sm-none"><span class="page-link page-link-static">1 / 5</span></li>
                
                <%-- 처음으로 가기 --%>
                <li class="page-item"><a class="page-link" href="<%=path%>/community/list?type=F&page=<%=pageInfo.getStartPage()%>" aria-label="Next"><i
                            class="fi-chevrons-left"></i></a>
                </li>
                
                <%-- 이전으로 가기 --%>
                <li class="page-item"><a class="page-link" href="<%=path%>/community/list?type=F&page=<%=pageInfo.getPrvePage()%>" aria-label="Next"><i
                            class="fi-chevron-left"></i></a>
                </li>
                
                <%-- 10개 목록 출력하기 --%>
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++) {%>
					<%if(i == pageInfo.getCurrentPage()) {%>		
		                <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link"><%=i %><span class="visually-hidden">(current)</span></span>
		                </li>
					<%} else {%>		
						<li class="page-item d-none d-sm-block"><a class="page-link" href="<%=path%>/community/list?type=F&page=<%=i%>"><%=i %></a></li>
					<%} %>		
				<%} %>		
				
				<%-- 다음으로 가기 --%>
				<li class="page-item"><a class="page-link" href="<%=path%>/community/list?type=F&page=<%=pageInfo.getNextPage()%>" aria-label="Next"><i
                            class="fi-chevron-right"></i></a>
                </li>
                
				<%-- 마지막으로 가기 --%>
				<li class="page-item"><a class="page-link" href="<%=path%>/community/list?type=F&page=<%=pageInfo.getEndPage()%>" aria-label="Next"><i
                            class="fi-chevrons-right"></i></a>
                </li>
                
                <!-- <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                </li>
                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                <li class="page-item d-none d-sm-block">...</li>
                <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i
                            class="fi-chevron-right"></i></a>
                </li> -->
            </ul>
        </nav>
    </div>
</section>
<selection> <br><br><br><br><br><br><br><br><br></selection>











<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>