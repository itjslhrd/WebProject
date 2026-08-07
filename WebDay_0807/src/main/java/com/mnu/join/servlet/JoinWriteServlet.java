package com.mnu.join.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinWriteServlet
 */
@WebServlet("/Join/join_write.do")
public class JoinWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원가입 폼으로 이동
		RequestDispatcher rd = request.getRequestDispatcher("/Join/join_write2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

		//db 저장
		int row = 0;
		// 변수에 값을 저장하여 다른 JPS 파일로 보내기
		//request 객체에 값 저장
		request.setAttribute("row", row);
		request.setAttribute("name", "홍길동");
		
		RequestDispatcher rd = request.getRequestDispatcher("/Join/join_write_ok.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("/index.jsp");
		
	}

}
