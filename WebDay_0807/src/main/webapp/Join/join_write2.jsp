<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>

<style type="text/css">
	table{width:600px; border:1px solid black;
           border-collapse: collapse; margin: 0 auto;}
	td{border:1px solid black;padding: 5px;}
	th{border:1px solid black;padding: 5px;}
 	.title{font-size:20px; text-align: center;}
	.btn{text-align: center;}
 	.btn_group{text-align: center;}
 	
</style>

</head>
<body>
	<h2 class="title">회원등록(서블릿)</h2>
	<form name="join" method="post" action="/Join/join_write.do">
		<table>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" placeholder="이름을 입력하세요">
				</td>				
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="M">남자
					<input type="radio" name="gender" value="F">여자				
				</td>				
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="checkbox" name="hobby" value="운동">운동
					<input type="checkbox" name="hobby" value="여행">여행
					<input type="checkbox" name="hobby" value="영화">영화
				</td>				
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="job">
						<option>직업을 선택하세요</option>
						<option value="학생">학생</option>
						<option value="교사">교사</option>
						<option value="군인">군인</option>
						<option value="공무원">공무원</option>
					</select>
				</td>				
			</tr>
			<tr>
				<th>전화</th>
				<td>
					<select name="tel1">
						<option value="010">010</option>
					</select>-
					<input type="text" name="tel2" size=4>-
					<input type="text" name="tel3" size=4>
				</td>				
			</tr>
			<tr>
				<td colspan=2 class="btn_group">
					<input type="button" value="등록" onClick="join_send()">
					<input type="button" value="취소" onClick="history.back()">
				</td>				
			</tr>
			
		</table>
	</form>
</body>
</html>

<script>
	function join_send(){
		//이름(text)
		if(!join.name.value){
			alert("이름을 입력하세요");
			join.name.focus();
			return;
		}
		//성별(radio)
		if(!join.gender[0].checked && !join.gender[1].checked){
			alert("성별을 선택하세요");
			return;			
		}
		//취미(checkbox)
		for(i=0,flag=0; i<join.hobby.length; i++){
			if(join.hobby[i].checked){
				flag=1;
				break;
			}
		}
		if(flag==0){//if(!flag){
			alert("취미는 1개이상 선택하세요");
			return;
		}
		//직업(select)
		if(join.job.selectedIndex==0){
			alert("직업을 선택하세요");
			join.job.focus();
			return;
		}
		//전화번호 2, 3
		
		join.submit();//전송
	}
</script>