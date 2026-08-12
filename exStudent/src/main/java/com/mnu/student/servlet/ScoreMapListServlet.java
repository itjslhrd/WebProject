package com.mnu.student.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.student.model.ScoreDTO;
import com.mnu.student.model.StudentDAO;
import com.mnu.student.model.StudentDTO;
import com.mnu.student.model.StudentScoreDTO;

/**
 * Servlet implementation class ScoreListServlet
 */
@WebServlet("/scoreMapList.do")
public class ScoreMapListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreMapListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentDAO = StudentDAO.getInstance();
		
		Map<StudentDTO,ScoreDTO> map = studentDAO.scoreMapList();
		
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("scoreMapList.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
