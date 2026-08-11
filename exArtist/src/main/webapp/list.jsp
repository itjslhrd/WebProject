<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mnu.exartist.model.*" %>

<%
	List<ArtistDTO> list = (List<ArtistDTO>)request.getAttribute("list");

%>
<%@ include file="header.jsp" %>	
	
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">참가자 목록 조회</h2>
				<table>
					<tr>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>특기</th>
						<th>소속사</th>
					</tr>
		<%
			
			for(int i=0; i<list.size(); i++){
		%>			
					<tr class="text_center">
						<td><%= list.get(i).getArtist_id() %></td>
						<td><%= list.get(i).getArtist_name() %></td>
						<td><%= list.get(i).getArtist_birth() %></td>
						<td><%= list.get(i).getArtist_gender() %></td>
						<td><%= list.get(i).getTalent() %></td>
						<td><%= list.get(i).getAgency() %></td>
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