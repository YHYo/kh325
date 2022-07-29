<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<%
	Member member = (Member)request.getAttribute("member");
	List<String> hobbies = new ArrayList<String>();
	try{
		hobbies = Arrays.asList(member.getHobby().split(","));
	}catch(Exception e){}
%>
    

<style>
section #enroll-container {
	text-align: center;
}

section #enroll-container input {
	margin: 3px;
}

section #enroll-container table {
	margin: 0 auto;
}

section #enroll-container table th {
	padding: 0 10px;
	text-align: right;
}

section #enroll-container table td {
	padding: 0 10px;
	text-align: left;
}
</style>

<section id="content">
	<h3 align="center">회원정보 수정</h3>
	<div id="enroll-container">
		<form name="memberFrm" action="<%=request.getContextPath()%>/member/update" method="POST">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" id="userId" name="userId" readonly="readonly" value="<%=member.getId()%>" />
					</td> 
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName" value="<%=member.getName()%>"  required /></td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td><input type="tel" name="phone" maxlength="11" value="<%=member.getPhone()%>"
						placeholder="(-없이)01012345678"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" placeholder="abc@abc.com" value="<%=member.getEmail()%>" />
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" value="<%=member.getAddress()%>" /></td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
					<label><input type="checkbox" name="hobby" value="운동" 
								<%=hobbies.contains("운동") ? "checked":""%>/>운동</label> 
					<label><input type="checkbox" name="hobby" value="등산" 
								<%=hobbies.contains("등산") ? "checked":""%>/>등산 </label> 
					<label><input type="checkbox" name="hobby" value="독서" 
								<%=hobbies.contains("독서") ? "checked":""%>/>독서</label>
					<label><input type="checkbox" name="hobby" value="게임" 
								<%=hobbies.contains("게임") ? "checked":""%>/>게임</label>
					<label><input type="checkbox" name="hobby" value="여행" 
								<%=hobbies.contains("여행") ? "checked":""%>/>여행</label></td>
				</tr>
			</table>
			<input type="button" id="updatePwd" value="비밀번호변경" />
	        <input type="submit" value="정보수정" />
	        <input type="button" id="deleteMember" value="탈퇴" />
		</form>
	</div>
</section>

<script>
	$(document).ready(() => {
		$("#deleteMember").on("click", (e) => {
			if(confirm("정말로 탈퇴하시겠습니까?!")) {
				location.replace('<%= request.getContextPath() %>/member/delete');
			}
		});
		
		$("#updatePwd").on("click", (e) => {
			// 비밀번호 변경 창을 띄우기
			const url = "<%= request.getContextPath() %>/member/updatePwd";
			const status = "left=500px,top=200px,width=400px,height=210px"
			open(url, "", status);
		});
	});
</script>




<%@ include file="/views/common/footer.jsp" %>
