package com.mnu.exshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopMemberEnroll
 */
@WebServlet("/member_register")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uname=request.getParameter("uname");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String gender=request.getParameter("gender");
		String tel=request.getParameter("tel1")+"-"+request.getParameter("tel2")+
				"-"+request.getParameter("tel3");
		String email=request.getParameter("eml1")+"@"+request.getParameter("eml2");
		String job=request.getParameter("job");
		String str[]=request.getParameterValues("hobby");
		
		String hobby= str[0];
		for(int i=0;i<str.length;i++) {
			hobby=hobby+","+str[i];
		}
		
		String intro=request.getParameter("intro");
		
		System.out.println(uname);
		System.out.println(uid);
		System.out.println(pass);
		System.out.println(gender);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(job);
		System.out.println(hobby);
		System.out.println(intro);
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
	}

}
