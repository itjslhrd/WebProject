<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>	

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">성적 입력</h2>
					<form name="student" method="post" >
						<table>
							<tr>
								<th>학년</th>
								<td>
									<select name="syear" style="width: 70px; text-align:right">
										<option value="1">1학년</option>
										<option value="2">2학년</option>
										<option value="3">3학년</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>반</th>
								<td>
									<select name="sclass" style="width: 70px; text-align:right">
										<option value="01">1반</option>
										<option value="02">2반</option>
										<option value="03">3반</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>번호</th>
								<td>
									<select name="sno" style="width: 70px; text-align:right">
										<option value="01">1번</option>
										<option value="02">2번</option>
										<option value="03">3번</option>
										<option value="04">4번</option>
										<option value="05">5번</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>국어</th>
								<td><input type="text" name="kor"></td>
							</tr>
							<tr>
								<th>영어</th>
								<td><input type="text" name="eng"></td>
							</tr>
							<tr>
								<th>수학</th>
								<td><input type="text" name="mat"></td>
							</tr>
							<tr>
								<td colspan=2 class="btn_group">
									<input type="button" value="성적저장">
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