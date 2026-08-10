<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int row = (int)request.getAttribute("row");
	
	if(row==1){
%>    
	<script>
		alert("등록되었습니다");
		location.href="/";
	</script>
<%
	}else{
%>	
	<script>
		alert("현재 접속자 폭주로 \n\n잠시후 다시 등록하세여ㅛ");
		history.back();
	</script>
<%
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>