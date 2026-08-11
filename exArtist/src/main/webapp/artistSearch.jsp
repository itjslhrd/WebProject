<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mnu.exartist.model.*" %>
<%
	String artist_id =(String)request.getAttribute("artist_id");
	List<MentoScoreDTO> list = (List<MentoScoreDTO>)request.getAttribute("list");
%>
<script>
	function send(){
		if(!frm.artist_id.value){
			alert("참가번호를 입력하세요");
			frm.artist_id.focus();
			return;
		}
		frm.submit();
	}
</script>
<%@ include file="header.jsp" %>	
	
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">참가자 검색</h2>
			<form name="frm" method="post" action="artistSearch.do">	
				<table>
					<tr>
						<th>참가번호</th>
						<td>
							<input type="text" name="artist_id" value="<%= artist_id %>">
							<input type="button" value="검색" onClick="send()">
						</td>
					</tr>
				</table>
			</form>	
		<%
			if(!artist_id.equals("")){
		%>		
				<br>
				<table>
					<tr>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>생년월일</th>
						<th>멘토이름</th>
						<th>점수</th>
					</tr>
				<%
					int tot=0;
					for(MentoScoreDTO dto : list){
						tot += dto.getPoint();
				%>
					<tr>
						<th><%= dto.getArtist_id() %></th>
						<th><%= dto.getArtist_name() %></th>
						<th><%= dto.getArtist_birth() %></th>
						<th><%= dto.getMento_name() %></th>
						<th><%= dto.getPoint() %></th>
					</tr>
				<%
					}
				%>	
					<tr>
						<th colspan=4>합계</th>
						<th><%= tot %></th>
					</tr>
					<tr>
						<th colspan=4>평균</th>
						<th><%= String.format("%.2f",(double)tot/list.size()) %></th>
					</tr>
				
				</table>	
		<%
			}
		%>		
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