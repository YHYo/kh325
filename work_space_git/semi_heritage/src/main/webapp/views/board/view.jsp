<%@page import="com.kh.mvc.board.model.vo.Reply"%>
<%@page import="com.kh.mvc.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<%
	Board board = (Board)request.getAttribute("board");
	String fileName = board.getOriginal_filename();
	String fileReName = board.getRenamed_filename();
%>

<style>
    section>div#board-write-container{width:600px; margin:0 auto; text-align:center;}
    section>div#board-write-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    div#comment-container button#btn-insert{width:60px;height:50px; color:white; background-color:#3300FF;position:relative;top:-20px;}
    
    /*댓글테이블*/
    table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
</style>



<section id="content">
	<div id='board-write-container'>
		<h2>게시글 조회</h2>
		<!-- 게시판 시작 -->
		<table id='tbl-board'>
			<tr>
				<th>글번호</th>
				<td><%=board.getNo() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=board.getTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=board.getWriter_id() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=board.getReadCount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<%if(fileName != null && fileName.length() > 0){ %>
						<a href="javascript:fileDownload('<%=fileName%>','<%=fileReName%>');">
							<img src="<%= request.getContextPath() %>/resources/images/file.png" width="20" height="20"/>
							<%=fileName%>			
						</a>
					<%} %>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<%if(fileName != null && fileName.length() > 0 
						&& (fileName.contains(".jpg") || fileName.contains(".jpeg") || fileName.contains(".png"))){%>
							<img src="<%=path%>/resources/upload/board/<%=fileReName%>" width="100%"/>
									
					<%} %>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="50" rows="15" readonly="readonly" ><%=board.getContent()%></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<%
						if(loginMember != null){
							if(loginMember.getId().equals(board.getWriter_id()) || loginMember.getRole().equals("ROLE_ADMIN")){
					%>
								<button type="button" onclick="location.href='<%= request.getContextPath() %>/board/update?boardNo=<%=board.getNo()%>'">수정</button>
								<button type="button" id="btnDelete">삭제</button>
					<%			
							}
						}
					%>
					<button type="button" onclick="location.href='<%= request.getContextPath() %>/board/list'">목록으로</button>

				</th>
			</tr>
		</table>
		<!-- 게시판 종료 -->
		
		<!-- 리플 등록 form 시작 -->
		<div id="comment-container">
	    	<div class="comment-editor">
	 			<form action="<%=request.getContextPath()%>/board/reply" method="post">
					<input type="hidden" name="boardNo" value="<%=board.getNo()%>" />
					<input type="hidden" name="writer" value="<%=loginMember != null ? loginMember.getId() : "" %>" />
					<textarea name="content" id="replyContent" cols="55" rows="3"></textarea>
					<button type="submit" id="btn-insert">등록</button>	  	
	 			</form>
	    	</div>
	   	</div>
		<!-- 리플 등록 form 종료 -->
		
		
		<!-- 리플리스트 출력 시작-->
		<table id="tbl-comment">
			<%for(Reply reply: board.getReplies()) { %>
				<tr>
					<td>
						<sub class="comment-writer"><%=reply.getWriter_id() %></sub>
						<sub class="comment-date"><%=reply.getCreate_date() %></sub>	
						<br>
						<%= reply.getContent() %>
					</td>
					<td>
					<%-- form 방식 = 이게 좀더 정석적인 코드 = 익스플로러에서 돌아간다. --%>
						<%if(loginMember != null && loginMember.getId().equals(reply.getWriter_id())){ %>
						<form action="<%=request.getContextPath()%>/board/replydel" method="get">
							<input type="hidden" name="replyNo" value="<%=reply.getNo()%>">			
							<input type="hidden" name="boardNo" value="<%=board.getNo()%>">			
							<button type="submit" class="btn-delete">삭제</button>
						</form>
						<%} %>
						<%--
						<%if(loginMember != null && loginMember.getId().equals(reply.getWriter_id())){ %>
							<button class="btn-delete" onclick="deleteReply(<%=reply.getNo()%>,<%=board.getNo()%>);" >삭제</button>
						<%} %>
						 --%>
					</td>
				</tr>
			<%} %>
		</table>
		<!-- 리플리스트 출력 종료 -->
		
	</div>
</section>



<%@ include file="/views/common/footer.jsp" %>


<script type="text/javascript">
    // get 방식으로 페이지 요청하는 코드
    
	function fileDownload(originName, reName){
		var url = "<%=request.getContextPath()%>/board/fileDown";
		var oName = encodeURIComponent(originName);
		var rName = encodeURIComponent(reName);
		var resquestURL = url + "?originName=" + oName + "&reName=" + rName;
		location.assign(resquestURL);
		alert("파일을 요청하였습니다.");
	}
    
	function deleteReply(replyNo, boardNo){
		var url = '<%=request.getContextPath()%>/board/replydel?replyNo=';
		var requestURL = url + replyNo + '&boardNo=' + boardNo;
		location.replace(requestURL);
	}
	
	// ES6 (e)=> = function(e)
	$(document).ready(() => {
		$("#btnDelete").on("click", (e) => {
			if(confirm("정말로 게시글을 삭제 하시겠습니까?")) {
				location.replace("<%= request.getContextPath() %>/board/delete?boardNo=<%= board.getNo()%>");
			}
		});
		
		$("#replyContent").on("focus", (e) => {
			if(<%= loginMember == null %>) {
				alert("로그인 후 이용해주세요!");
				$("#userId").focus();				
			}
		});
	});
</script>
