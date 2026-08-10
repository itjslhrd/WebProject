<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title" align="center">회원등록</h2>
			<form name="user" method="post" action="/member_register">
				<table>
					<tr>
						<td colspan="2" align="center">회원 기본 정보</td>
					</tr>
					<tr>
						<td>사용자이름</td>
						<td><input type="text" size="20" name="uname"></td>
					</tr>
					<tr>
						<td>사용자아이디</td>
						<td><input type="text" size="20" name="uid"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pass" size="20"></td>
					</tr>
					<tr>
						<td>비밀번호확인</td>
						<td><input type="password" name="passck" size="20"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							<input type="radio" name="gender" value="M">남자
							<input type="radio" name="gender" value="F">여자
						</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td>
							<select name="tel1">
								<option value="010">010</option>
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="032">032</option>
								<option value="042">042</option>
								<option value="052">052</option>
								
							</select>
							-<input type="text" size="4" name="tel2">
							-<input type="text" size="4" name="tel3">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="eml1" size=10>@
							<input type="text" name="eml2" size=10> 
							<select name="emlop" onchange="changeml()">
								<option value="">직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="google.com">google.com</option>
							</select>
					</tr>
					<tr>
						<td>직업</td>
						<td><select name="job" style="width:150px;">
								<option>직업을 선택하세요</option>
								<option value="자영업">자영업</option>
								<option value="공무원">공무원</option>
								<option value="회사원">회사원</option>
								<option value="교.강사">교.강사</option>
								<option value="학생">학생</option>
								<option value="기타">기타</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>관심분야</td>
						<td>
							<input type="checkbox" name="hobby" value="골프">골프
							<input type="checkbox" name="hobby" value="축구">축구
							<input type="checkbox" name="hobby" value="야구">야구
							<input type="checkbox" name="hobby" value="농구">농구
							<input type="checkbox" name="hobby" value="배구">배구					
						</td>			
					</tr>
					<tr>
						<td>기타(한마디)</td>
						<td>
							<textarea name="intro" cols="50" rows="5"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="가입하기" onclick="send()"> 
							<input type="button" value="돌아가기" onclick="rewrite()">
						</td>
					</tr>

					
				</table>
			</form>
			</div>
		</section>
	</div>
	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources 
			Development Service of Korea</p>
		</footer>
	</div>
</body>
</html>
<script>
	function changeml(){
		var eml2Input=document.user.eml2;
		var emlSelect=document.user.emlop;
		
		if(emlSelect.value==""){
			eml2Input.value="";
			eml2Input.readOnly=false;
			eml2Input.focus();
		}
		else{
			eml2Input.value=emlSelect.value;
			eml2Input.readOnly=true;
		}
	}


	function send(){
		if(!user.uname.value){
			alert("사용자이름이 입력되지 않았습니다");
			user.uname.focus();
			return;
		}
		if(!user.uid.value){
			alert("사용자 아이디가 입력되지 않았습니다");
			user.uid.focus();
			return;
		}
		if(!user.pass.value){
			alert("비밀번호가 입력되지 않았습니다");
			user.pass.focus();
			return;
		}
		if(user.pass.value!=user.passck.value){
			alert("비밀번호가 일치하지 않습니다");
			user.passck.focus();
			return;
		}
		if(!user.gender[0].checked && !user.gender[1].checked){
			alert("성별이 선택되지 않았습니다");
			return;
		}
		if(user.tel1.value==""||user.tel2.value==""||user.tel3.value==""){
			alert("연락처가 입력되지 않았습니다");
			user.tel1.focus();
			return;
		}
		
		if(!user.eml1.value||!user.eml2.value){
			alert("이메일이 입력되지 않았습니다");
			return;
		}
		if(user.job.selectedIndex==0){
			alert("직업이 선택되지 않았습니다");
			return;
		}
		for(i=0,flag=0;i<user.hobby.length;i++){
			if(user.hobby[i].checked){
				flag=1;
				break;
			}
		}
		if(flag==0){
			alert("관심분야가 선택되지 않았습니다");
			return;
		}
		if(!user.intro.value){
			alert("기타(한마디)를 작성하지 않았습니다");
			return;
		}
		alert("회원정보가 등록되었습니다");
		user.submit();
	}

	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다.")
		user.uname.focus();
		return;
	}

</script>