<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mnu.exartist.model.*" %>

<%
	List<MentoScoreDTO> list = (List<MentoScoreDTO>)request.getAttribute("list");

%>
<%@ include file="header.jsp" %>	
	
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">멘토 점수 목록 조회</h2>
				<table>
					<tr>
						<th>채점번호</th>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>생년월일</th>
						<th>점수</th>
						<th>평점</th>
						<th>메토</th>
					</tr>
		<%
			
			for(MentoScoreDTO dto : list){
				String score="F";
				if(dto.getPoint()>=90)
					score="A";
				else if(dto.getPoint()>=80)
					score="B";
				else if(dto.getPoint()>=70)
					score="C";
				else if(dto.getPoint()>=60)
					score="D";
		%>			
					<tr class="text_center">
						<td><%= dto.getSerial_no() %></td>
						<td><%= dto.getArtist_id() %></td>
						<td><%= dto.getArtist_name() %></td>
						<td><%= dto.getArtist_birth() %></td>
						<td><%= dto.getPoint() %></td>
						<td><%= score %></td>
						<td><%= dto.getMento_name() %></td>
					</tr>
		<%
			}
		%>		
				</table>	
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