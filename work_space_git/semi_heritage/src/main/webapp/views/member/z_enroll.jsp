<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="/views/common/header.jsp"%>
    
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
            <h3 align="center">회원 가입 정보</h3>
            <div id="enroll-container">
                <form name="memberEnrollFrm" action="<%=request.getContextPath()%>/member/enroll" method="POST">
                    <table>
                        <tr>
                            <th>아이디</th>
                            <td>
                            	<input type="text" name="newId" id="newId" placeholder="아이디(4글자이상)" required /> 
                            	<input type="button" id="checkDuplicate1" value="중복검사1" />
                             	<input type="button" id="checkDuplicate2" value="중복검사2" />
                             </td>
                        </tr>
                        <tr>
                            <th>패스워드</th>
                            <td><input type="password" name="userPwd" id="pass1" required />
                            </td>
                        </tr>
                        <tr>
                            <th>패스워드 확인</th>
                            <td><input type="password" id="pass2" /></td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td><input type="text" name="userName" required /></td>
                        </tr>
                        <tr>
                            <th>휴대폰</th>
                            <td><input type="tel" name="phone" maxlength="11" placeholder="(-없이)01012345678"></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td><input type="email" name="email" placeholder="abc@abc.com" />
                            </td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td><input type="text" name="address" /></td>
                        </tr>
                        <tr>
                            <th>취미</th>
                            <td>
                            <label>
                            <input type="checkbox" name="hobby" value="운동" />운동</label> <label>
                            <input type="checkbox" name="hobby" value="등산" />등산</label> <label>
                            <input type="checkbox" name="hobby" value="독서" />독서</label> <label>
                            <input type="checkbox" name="hobby" value="게임" />게임</label> <label>
                            <input type="checkbox" name="hobby" value="여행" />여행</label> </td>
                        </tr>
                    </table>

                    <input type="submit" id="enrollSubmit" value="가입" /> <input type="reset" value="취소" />
                </form>
                
                <form name="checkIdForm">
                    <input type="hidden" name="userId">
                </form>
            </div>
        </section>
    
   <%@ include file="/views/common/footer.jsp"%>
   
<script type="text/javascript">
	/*
	ES6에서 도입 함수형 언어 문법, Arrow Function 기법
	 -> ES6 주요 문법 : class(이미 해봄), 상속, 생성자 / 함수형 언어 문법 = 익명클래스
	 
	       기존 문법(ES5)    |     Arrow Function   
	  xx.(function(){...})	     xx.(()=>{...})   // 인자가 없는 경우
	  xx.(function(e){...})	    xx.((e)=>{...})   // 인자가 1개
	 xx.(function(x,y){...})   xx.((x,y)=>{...})   // 인자가 2개
	-----------------------------------------------------------------
	리턴값이 있는 경우
	 xx.(function(x,y){return x+y;}})   xx.((x,y)=>{return x+y})  
	 xx.(function(x,y){return x+y;}})   xx.((x,y)=> x + y;)  
	
	*/
	
	// JQuery 고전문법
	/*	$("#checkDuplicate1").click(function(){
	});
	*/
	
	
	// 동기식=정적 페이지식(get요청)을 통해 중복 ID를 확인하는 방법 - 새로운 창을 통해 확인
	//  - 페이지를 새로고침 하지 않고, 새로운 창(페이지)를 통해 회원가입 여부를 확인하는 방법
	$('#checkDuplicate1').click(()=>{
		let id = $('#newId').val().trim();
		
		if(id.length < 4){
			alert('아이디는 최소 4글자 입니다.');
			return;
		}
		
		// 동기식 확인하는 방법
		let url = '<%=request.getContextPath()%>/member/checkId';
		let title = 'duplicate';
		let status = 'left=500px,top=100px,width=500px,height=300px';

		open('',title,status); // 새로운 창으로 url을 로드하는 방법
		
//		checkIdForm html에서 해당 네임으로 된 form이 존재함
		checkIdForm.target = title;
		checkIdForm.action = url;
		checkIdForm.method = 'post';
		checkIdForm.userId.value = id;
		checkIdForm.submit();
	});
	
	// 동적 페이지(비동기식)을 중복하는 방법 - AJAX ★★★★★
	// - 새로운 페이지를 요청하지 않고, 기존 페이지에서 서버에게 데이터만 전달받아 중복여부를 알려주는 방식
	$('#checkDuplicate2').click(()=>{
		let id = $('#newId').val().trim();
		
		if(id.length < 4){
			alert('아이디는 최소 4글자 입니다.');
			return;
		}
		
		// 비동기식 처리 - AJAX
		const xhr = new XMLHttpRequest();
		xhr.open('get','${pageContext.request.contextPath}/member/checkId2?userId=' + id);
		
		// Callback 함수 셋팅 = 이벤트 함수, 리스너, 핸들러
		xhr.onreadystatechange = ()=>{
			if(xhr.readyState == 4 && xhr.status == 200){
				if(xhr.responseText == 'used'){
					alert('중복된 아이디 입니다.');
					// html을 변경하는 코드를 작성하면 -> 동적페이징이 된다!!
				}else{
					alert('입력하는 아이디는 사용 가능합니다.');					
					// html을 변경하는 코드를 작성하면 -> 동적페이징이 된다!!
				}
			}
		};
		xhr.send();
	});	
</script>
    
    
    
    
    
    
    
    
    