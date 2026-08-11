<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mnu.exartist.model.*" %>

<%
	List<ArtistRankDTO> list = (List<ArtistRankDTO>)request.getAttribute("list");

%>
<%@ include file="header.jsp" %>	
	
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">참가자 등수 조회</h2>
				<table>
					<tr>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>성별</th>
						<th>총점</th>
						<th>평균</th>
						<th>등수</th>
					</tr>
		<%
			int rank=0;
			for(ArtistRankDTO dto : list){
				rank++;//순위
		%>			
					<tr class="text_center">
						<td><%= dto.getArtist_id() %></td>
						<td><%= dto.getArtist_name() %></td>
						<td><%= dto.getArtist_gender() %></td>
						<td><%= dto.getTot() %></td>
						<td><%= String.format("%.2f",dto.getAve()) %></td>
						<td><%= rank %></td>
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