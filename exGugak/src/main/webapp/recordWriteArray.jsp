<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>	
<script>
	function send(){
		
		alert("등록합니다");
		
		frm.submit();
	}
</script>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">경연 점수 등록(배열)</h2>
				<form name="frm" method="post" action="recordWriteArray.do">
					<table>
						<tr>
							<th>참가번호</th>
							<td><input type="text" name="entry_no" />예)0001</td>
						</tr>
						<tr>
							<th>심사위원</th>
							<td>심사점수(1~100)</td>
						</tr>
						<tr>
							<th>김심사</th>
							<td><input type="text" name="score" /> 점</td>
						</tr>
						<tr>
							<th>이심사</th>
							<td><input type="text" name="score" /> 점</td>
						</tr>
						<tr>
							<th>박심사</th>
							<td><input type="text" name="score" /> 점</td>
						</tr>
						<tr>
							<th>황심사</th>
							<td><input type="text" name="score" /> 점</td>
						</tr>
						<tr>
							<th>조심사</th>
							<td><input type="text" name="score" /> 점</td>
						</tr>
						<tr>
							<td colspan="2" class="btn_group">
								<input type="button" value="등록" onclick="send()" />
								<input type="reset" value="다시쓰기" onclick="del()" />
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