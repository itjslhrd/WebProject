<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String hobby = (String)request.getAttribute("hobby");//"운동,여행"
	String job = (String)request.getAttribute("job");
	String tel[]= ((String)request.getAttribute("tel")).split("-");
	
%>    
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
	<h2 class="title">회원수정</h2>
	<form >
		<table>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="<%= name %>" readonly>
				</td>				
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="M" <%= gender.equals("M") ? "checked" : "" %>>남자
				<input type="radio" name="gender" value="F" <%= gender.equals("F") ? "checked" : "" %>>여자				
				</td>				
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="checkbox" name="hobby" value="운동" <%= hobby.contains("운동") ? "checked" : "" %>>운동
					<input type="checkbox" name="hobby" value="여행" <%= hobby.contains("여행") ? "checked" : "" %>>운동
					<input type="checkbox" name="hobby" value="영화" <%= hobby.contains("영화") ? "checked" : "" %>>운동
				</td>				
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="job">
						<option>직업을 선택하세요</option>
						<option value="학생" >학생</option>
						<option value="교사" >교사</option>
						<option value="군인" >군인</option>
						<option value="공무원" >공무원</option>
					</select>
				</td>				
			</tr>
			<tr>
				<th>전화</th>
				<td>
					<select name="tel1">
						<option value="010">010</option>
					</select>-
					<input type="text" name="tel2" value="<%= tel[1] %>" size=4>-
					<input type="text" name="tel3" value="<%= tel[2] %>" size=4>
				</td>				
			</tr>
			<tr>
				<td colspan=2 class="btn_group">
					<input type="button" value="수정" onClick="join_modify()">
					<input type="button" value="취소">
				</td>				
			</tr>
			
		</table>
	</form>
</body>
</html>