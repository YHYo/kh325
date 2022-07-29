<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

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
		<h2>게시판 작성</h2>
	    <form action="<%= request.getContextPath()%>/board/write" method="POST" enctype="multipart/form-data">
<%--  		<form action="<%= request.getContextPath()%>/board/write" method="POST">  --%>
			<table id='tbl-board'>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="<%= loginMember.getId() %>" readonly></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile"></td>
					<!-- 
					<td><input type="file" name="upfile" multiple="multiple"></td>
					 -->
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="50" rows="15" ></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</th>
				</tr>
			</table>
		</form>
	</div>
</section>

<%@ include file="/views/common/footer.jsp" %>