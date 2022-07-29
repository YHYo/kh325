<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	boolean duplicated = (boolean)request.getAttribute("duplicated");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div#checkId-container {
		text-align:center;
		padding-top:50px;
	}
	
	span#duplicated {
		color:red;
		font-weight:bolder;
	}
</style>
</head>
<body>
	<div id="checkId-container">
		<% if(duplicated) { %>
			[<span id="duplicated"><%= request.getParameter("userId") %></span>]는 사용중 입니다.
			
			<br><br>
			<!-- 아이디 재입력창 구성 -->
			<form action="<%= request.getContextPath() %>/member/checkId" method="post">
				<input type="text" name="userId" id="newId" placeholder="아이디(4글자이상)" required>
				<input type="submit" id="checkDuplicate" onclick="return validate();" value="중복검사" >
			</form>		
		<% } else { %>
			[<span><%= request.getParameter("userId") %></span>]는 사용 가능합니다.
		
			<br><br>
			
			<input type="button" onclick="setUserId()" value="닫기">		
		<% } %>
	</div>
	<script>
		function validate(){
			let id = document.getElementById("userId").value;
			
			if(id.trim().length < 4){
				alert("아이디는 4글자 이상 입력하세요!");
				document.getElementById("userId").focus();
				return false;
			}
		}
		
		function setUserId() {
			// 입력 된 id를 부모창에 대입
			const id = "<%= request.getParameter("userId") %>";
			
			opener.memberEnrollFrm.newId.value = id;
			opener.memberEnrollFrm.userPwd.focus();
			
			// 팝업창 닫아주기
			close();			
		}	
		
	</script>	
</body>
</html>