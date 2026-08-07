<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String str[] = request.getParameterValues("hobby");
	String job = request.getParameter("job");
	String tel = request.getParameter("tel1")+"-" +
			request.getParameter("tel2")+"-" +
			request.getParameter("tel3");
	
	String hobby=str[0];
	for(int i=1; i<str.length; i++){
		hobby = hobby + "," + str[i];
	}
	//
	// DB 저장
	int row=0; //DB 성공
	if(row==1){
		response.sendRedirect("/index.jsp");
	}else{
%>
	<script>
		alert("회원가입 실패");
		history.back();
	</script>
<% 		
	}

	//성별 변환
	String genderStr="여자";
	if(gender.equals("M"))
		genderStr="남자";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <%= name %> <br>
	성별 : <%= genderStr %> <br>
	성별 : <%= gender.equals("M")? "남자":"여자" %> <br>
	취미 : <%= hobby %> <br>
	직업 : <%= job %> <br>
	전화 : <%= tel %> <br>
	
</body>
</html>