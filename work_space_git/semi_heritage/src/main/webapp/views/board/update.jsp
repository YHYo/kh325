<%@page import="com.kh.mvc.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<%
	// 수정 게시물에 뿌려줄 내용
	Board board = (Board)request.getAttribute("board");
%>


<style>
	div#board-write-container{
		width:600px;
		margin:0 auto;
		text-align:center;}
	div#board-write-container h2{ margin:10px 0;}
	table#tbl-board
	{
		width:500px;
		margin:0 auto;
		border:1px solid black;
		border-collapse:collapse;
	}
	table#tbl-board th
	{
		width:125px;
		border:1px solid;
		padding:5px 0;
		text-align:center;
	}
	table#tbl-board td
	{
		border:1px solid;
		padding:5px 0 5px 10px;
		text-align:left;
	}
</style>


<section id="content">
	<div id='board-write-container'>
		<h2>게시글 수정</h2>
	    <form action="<%= request.getContextPath()%>/board/update" method="POST" enctype="multipart/form-data">
	    	<input type="hidden" name="boardNo" value="<%=board.getNo()%>"/>

	    	<%-- 기존 파일 여부 --%>
	    	<%if(board.getOriginal_filename() != null && board.getOriginal_filename().length() > 0){ %>
	    		<input type="hidden" name="original_filename" value="<%=board.getOriginal_filename()%>"/>
				<input type="hidden" name="renamed_filename" value="<%=board.getRenamed_filename()%>"/>
	    	<%} %>
			<table id='tbl-board'>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title" value="<%=board.getTitle()%>"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="<%= loginMember.getId() %>" readonly></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>
					<% if(board.getOriginal_filename() != null && board.getOriginal_filename().length() > 0) { %>
							<img src="<%=request.getContextPath()%>/resources/images/file.png" width="20" height="20"/>
							<%=board.getOriginal_filename() %>
					<%} %>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="50" rows="15" ><%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="목록으로" onclick="location.replace('<%=request.getContextPath()%>/board/list')">
					</th>
				</tr>
			</table>
		</form>
	</div>
</section>

<%@ include file="/views/common/footer.jsp" %>