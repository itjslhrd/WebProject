<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	request.setCharacterEncoding("utf-8");

	//스크립트 릿 
	//자바코드 
	//요청처리 : request(내장객체) : getParameter(), getParameterValues()
	//응답 : response(내장객체) :  sendRedirect()
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String tel = tel1 + "-" + tel2 + "-" + tel3;
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String email = email1 + "@" + email2;
	
	out.print("이름 : " + name + "<br>");
	out.print("아이디 : " + id + "<br>");
	out.print("비번 : " + passwd + "<br>");
	out.print("전화 : " + tel + "<br>");
	out.print("이메일 : " + email + "<br>");
%>    
