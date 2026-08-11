<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>	

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">학생등록</h2>
					<form>
						<table>
							<tr>
								<th>학년</th>
								<td><input type="text" name="syear" size=1>(예)1</td>
							</tr>
							<tr>
								<th>반</th>
								<td><input type="text" name="sclass" size=2>(예)01</td>
							</tr>
							<tr>
								<th>번호</th>
								<td><input type="text" name="sno" size=2>(예)01</td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" name="sname"></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><input type="text" name="birth">(예)20190301</td>
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<input type="radio" name="gender" value="M">남자
									<input type="radio" name="gender" value="F">여자
								</td>
							</tr>
							<tr>
								<th>전화</th>
								<td>
									<input type="text" name="tel1" size=3>-
									<input type="text" name="tel2" size=4>-
									<input type="text" name="tel3" size=4>
								</td>
							</tr>
							<tr>
								<td colspan=2 class="btn_group">
									<input type="button" value="학생등록">
									<input type="button" value="다시쓰기">
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