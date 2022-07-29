<%@page import="com.kh.common.util.PageInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.mvc.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/views/common/header.jsp" %>

<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>

<style>
	section#board-list-container{width:600px; margin:0 auto; text-align:center;}
	section#board-list-container h2{margin:10px 0;}
	table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} 
	/*글쓰기버튼*/
	input#btn-add{float:right; margin: 0 0 15px;}
	/*페이지바*/
	div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
	
	.input_text{width: calc( 60% - 14px); margin: 6px 7px; height: 30px; text-align:center;
           		  border: 0; font-weight: bold; font-size: 16px; outline: none;}
    .sch_smit{width: 54px; height: 40px; margin: 0; border: 0; 
        		background: #007dd1; color: white; font-weight: bold; border-radius: 1px; cursor: pointer;}
    .sch_smit:hover{background: #007daa;}
</style>


<section id="content">
	<h2 align="center">자유 게시판</h2>
	<% if(loginMember != null) {%>
		<button id="btn-add" onclick="<%=path%>/board/write">글쓰기</button>
	<% } %>
	
	<form action="<%=path%>/board/list" method="get">
		   <div style="text-align: center;">
				<label><input type="radio" name="searchType" value="title" />제목</label>
				<label><input type="radio" name="searchType" value="content" />내용</label>
				<label><input type="radio" name="searchType" value="writer" />작성자</label>
				<br>
				 <span class="blue_window">
                    <input id="searchValue" name="searchValue" type="text" class="input_text" />
                	<button type="submit" class="sch_smit">검색</button>
                </span>
		   </div>
	</form>
	
	<table id="tbl-board">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
		
		<%if(list == null || list.isEmpty()){ %>
		<%--게시글이 없는 상황 --%>
			<tr>
				<td colspan="6">
					조회된 게시글이 없습니다.
				</td>
			</tr>
		<%} else { %>
		<%--게시글 리스트 시작--%>
			<%for(Board b : list){ %>
				<tr>
					<td><%=b.getNo()%></td>
					<td>
						<a href="<%=path+"/board/view?boardNo="+b.getNo()%>"><%=b.getTitle()%></a>
					</td>
					<td><%=b.getWriter_id()%></td>
					<td><%=b.getCreate_date()%></td>
					<td>
						<%if(b.getOriginal_filename() != null){ %>					
							<%-- 첨부파일 존재 --%>
							<img src="<%=path%>/resources/images/file.png" width="20" height="20"/>
						<%} else { %>
							<span> - </span>
						<%} %>
					</td>
					<td><%= b.getReadCount()%></td>
				</tr>
			<%} %>
		<%--게시글 리스트 끝--%>
		<%} %>
	</table>
	
	<%-- 페이지부 시작 --%>
	<div id="pageBar">
		<%-- 처음으로 가기 --%>													
		<button onclick="location.href='<%=path%>/board/list?page=<%=pageInfo.getStartPage()%>'">&lt;&lt;</button>
		<%-- 이전으로 가기 --%>	
		<button onclick="location.href='<%=path%>/board/list?page=<%=pageInfo.getPrvePage()%>'">&lt;</button>

		<!-- 10개 목록 출력하기 -->
		<% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
			<%if(i == pageInfo.getCurrentPage()){ %>
				<button disabled><%=i%></button>
			<%} else {%>
				<button onclick="location.href='<%=path%>/board/list?page=<%=i%>'"><%=i%></button>
			<%} %>
		<%} %>
		<%-- 다음으로 가기 --%>	
		<button onclick="location.href='<%=path%>/board/list?page=<%=pageInfo.getNextPage()%>'">&gt;</button>
		
		<%-- 마지막으로 가기 --%>													
		<button onclick="location.href='<%=path%>/board/list?page=<%=pageInfo.getEndPage()%>'">&gt;&gt;</button>
	</div>
	<%-- 페이지부 종료 --%>
</section>


<%@ include file="/views/common/footer.jsp" %>