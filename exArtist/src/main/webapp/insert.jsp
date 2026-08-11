<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>	

<script>
	function send() {

		if (!frm.artist_id.value) {
			alert("참가번호가 입력되지 않았습니다!");
			frm.artist_id.focus();
			return;
		}
		if (!frm.artist_name.value) {
			alert("참가자명이 입력되지 않았습니다!");
			frm.artist_name.focus();
			return ;
		}
		if (!frm.year.value) {
			alert("년도가 입력되지 않았습니다!");
			frm.year.focus()
			return;
		}
		if (!frm.month.value) {
			alert("월이 입력되지 않았습니다!");
			return false;
		}
		if (!frm.day.value) {
			alert("일이 입력되지 않았습니다!");
			return false;
		}
		//성별체크
		if(!frm.artist_gender[0].checked && !frm.artist_gender[1].checked){
			alert("성별이 선택되지 않았습니다!");
			return;			
		}
				
		if (!frm.talent.selectedIndex) {
			alert("특기가 선택되지 않았습니다!");
			frm.talent.focus();
			return ;
		}
		if (!frm.agency.value) {
			alert("소속사가 입력되지 않았습니다!");
			frm.agency.focus();
			return;
		}
		alert("오디션 지원자정보가 등록되었습니다");
		frm.submit();
	}

	function cancel() {
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		frm.artist_id.focus();
		frm.reset();
	}
	
</script>


	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">오디션 등록</h2>
			<form name="frm" method="post" action="artistWrite.do">
				<table>
					<tr>
						<th>참가번호</th> 
						<td><input type="text" name="artist_id"> *참가번호는(A000)4자리입니다</td>
					</tr>
					<tr>
						<th>참가자명</th>
						<td><input type="text" name="artist_name"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>
							<input type="text" name="year" size=5>년
							<input type="text" name="month" size=5>월
							<input type="text" name="day" size=5>일
						</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<input type="radio" name="artist_gender" value="M">남성
							<input type="radio" name="artist_gender" value="W">여성
						</td>
					</tr>
					<tr>
						<th>특기</th>
						<td>
							<select name="talent">
								<option value="0">특기선택</option>
								<option value="1">댄스</option>
								<option value="2">랩</option>
								<option value="3">노래</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>소속사</th>
						<td><input type="text" name="agency"></td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="오디션등록" onClick="send()"> 
							<input type="button" value="다시쓰기" onClick="cancel()">
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