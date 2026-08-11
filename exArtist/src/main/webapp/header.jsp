<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0; padding:0;}
	ul, li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo{color:#fff; text-align:center; background-color:#0040FF;padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden; background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px; height:500px;}
	.title {text-align:center; padding:22px;}
	.content table{width:800px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.content table .white {color:#fff;}
	.content .text_center{text-align:center;}
	
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}	
</style>
</head>
<body>
	<div class="header">
		<h1 class="logo">(과정평가형 정보처리산업기사)오디션 관리 프로그램  Ver2009-06</h1>
		<div class="nav">
			<nav>
				<ul class="navi">
					<li><a href="artistWrite.do">오디션등록</a></li>
					<li><a href="artistList.do">참가자목록조회</a></li>
					<li><a href="artistSearch.do">참가자검색</a></li>
					<li><a href="mentoScore.do">멘토점수조회</a></li>
					<li><a href="mentoScoreSearch.do">채점번호조회</a></li>
					<li><a href="artistRankList.do">참가자등수조회</a></li>
					<li><a href="/">홈으로</a></li>
				</ul>
			</nav>
		</div>	
	</div>
