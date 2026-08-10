<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.time.*" %>
<%@ page import="com.mnu.exshop.model.*" %>    
<%
	MemberDTO mdto = (MemberDTO)request.getAttribute("dto");
	List<CityDTO> list = (List<CityDTO>)request.getAttribute("list");
	
	//전화번호분리
	String tel[] = mdto.getPhone().split("-");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px; }
	.title {text-align:center;padding:22px;}
	.content table{width:500px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
<script>
	function send(){
		if(frm.custno.value==""){
			alert("회원번호가 입력되지 않았습니다");
			frm.custno.focus();
			return;
		}
		if(frm.custname.value==""){
			alert("회원이름이 입력되지 않았습니다");
			frm.custname.focus();
			return;
		}
		if(frm.phone1.value=="" || frm.phone2.value=="" || frm.phone3.value==""){
			alert("전화번호가 입력되지 않았습니다");
			frm.phone1.focus();
			return;			
		}
		// 라디오, 체크박스 유효성 검사
		for(i=0, flag=0; i<frm.gender.length; i++){
			if(frm.gender[i].checked){
				flag=1;
				break;
			}
		}
		if(!flag){
			alert("성별이 체크되지 않았습니다");
			return;						
		}
		//select
		if(frm.grade.selectedIndex==0){
			alert("고객등급이 선택되지 않았습니다");
			frm.grade.focus()
			return;									
		}
		//select
		if(frm.city.selectedIndex==0){
			alert("도시코드가 선택되지 않았습니다");
			frm.city.focus()
			return;									
		}
		alert("회원정보입력이 정상적으로 등록되었습니다");
		frm.submit();
	}
	
	function del(){
		alert("모두삭제합니다");
		frm.reset();
		frm.custname.focus();
	}
</script>

</head>
<body>

	<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">회원정보수정</h2>
					<form name="frm" method="post" action="memberModify">
						<table>
							<tr>
								<th>회원번호</th>
								<td><input type="text" name="custno" value="<%=mdto.getCustno()%>" readonly></td>
							</tr>
							<tr>
								<th>회원성명</th>
								<td><input type="text" name="custname" value="<%=mdto.getCustname()%>" readonly></td>
							</tr>
							<tr>
								<th>회원전화</th>
								<td><input type="text" size="3" name="phone1" value="<%= tel[0] %>">-
									<input type="text" size="4" name="phone2" value="<%= tel[1] %>">-
									<input type="text" size="4" name="phone3" value="<%= tel[2] %>">
								</td>
							</tr>
							<tr>
								<th>회원성별</th>
								<td><input type="radio" name="gender" value="M" <%= mdto.getGender().equals("M") ? "checked" : "" %>>남자
								    <input type="radio" name="gender" value="W" <%= mdto.getGender().equals("F") ? "checked" : "" %>>여자
								</td>
							</tr>
							<tr>
								<th>가입일자</th>
								<td><input type="text" name="joindate" value="<%= mdto.getJoindate() %>"></td>
							</tr>
							<tr>
								<th>가입일자</th>
								<td><input type="date" name="joindate1" value=""></td>
							</tr>
							<tr>
								<th>고객등급</th>
								<td>
									<select name="grade">
										<option>고객등급</option>
										<option value="A" <%= mdto.getGrade().equals("A") ? "selected":"" %>>VIP</option>
										<option value="B" <%= mdto.getGrade().equals("B") ? "selected":"" %>>일반</option>
										<option value="C" <%= mdto.getGrade().equals("C") ? "selected":"" %>>직원</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>도시코드</th>
								<td>
									<select name="city">
										<option>도시코드</option>
									<% for(CityDTO dto : list){ %>	
										<option value="<%= dto.getCity() %>" <%= dto.getCity().equals(mdto.getCity()) ? "selected" : "" %>><%= dto.getCityname() %></option>
									<% } %>	
									</select>								
								</td>
							</tr>
							<tr>
								<td colspan="2" class="btn_group">
									<input type="button" value="수정" onClick="send()">
									<input type="button" value="취소" onClick="history.back()">
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
			Development Serivce of Korea</p>
		</footer>
	</div>

</body>
</html>