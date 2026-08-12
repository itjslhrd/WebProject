package com.mnu.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.student.model.StudentDAO;
import com.mnu.student.model.StudentDTO;

/**
 * Servlet implementation class StudentWriteServlet
 */
@WebServlet("/studentWrite.do")
public class StudentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("studentWrite2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentDAO studentDAO = StudentDAO.getInstance();
		StudentDTO studentDTO  = new StudentDTO();
		
		studentDTO.setSyear(request.getParameter("syear"));
		studentDTO.setSclass(request.getParameter("sclass"));
		studentDTO.setSno(request.getParameter("sno"));
		studentDTO.setSname(request.getParameter("sname"));
		studentDTO.setBirth(request.getParameter("birth"));
		studentDTO.setGender(request.getParameter("gender"));
		studentDTO.setTel1(request.getParameter("tel1"));
		studentDTO.setTel2(request.getParameter("tel2"));
		studentDTO.setTel3(request.getParameter("tel3"));
		
		int flag = studentDAO.studentWrite(studentDTO);
		
		//실패 또는 성공 메시지 출력
		request.setAttribute("flag", flag);
		
		RequestDispatcher rd = request.getRequestDispatcher("studentWrite_pro.jsp");
		rd.forward(request, response);
		
	}

}
