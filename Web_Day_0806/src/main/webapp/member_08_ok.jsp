<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


		//취미
		String hobby[] = request.getParameterValues("hobby");
		//"a/b/c","a,b,c"
		String str=hobby[0];
		for(int i=1; i<hobby.length; i++){
			str = str + "," + hobby[i];
		}
		
		out.print("취미 : " + str);
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