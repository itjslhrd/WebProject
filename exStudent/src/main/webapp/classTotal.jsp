<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="header.jsp" %>	

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">반별 통계</h2>
				<table>
					<tr>
						<th>학년</th>
						<th>반</th>
						<th>교사명</th>
						<th>국어총점</th>
						<th>영어총점</th>
						<th>수학총점</th>
						<th>국어평균</th>
						<th>영어평균</th>
						<th>수학평균</th>
					</tr>
			<c:forEach var="dto" items="${list}">		
					<tr>
						<td>${dto.syear}</td>
						<td>${dto.sclass}</td>
						<td>${dto.tname}</td>
						<td>${dto.tkor}</td>
						<td>${dto.teng}</td>
						<td>${dto.tmat}</td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.akor}"/></td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.aeng}"/></td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.amat}"/></td>
					</tr>
			</c:forEach>		
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