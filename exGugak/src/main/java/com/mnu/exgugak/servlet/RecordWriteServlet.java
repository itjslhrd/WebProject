package com.mnu.exgugak.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exgugak.model.RecordDTO;

/**
 * Servlet implementation class RecordWriteServlet
 */
@WebServlet("/recordWrite.do")
public class RecordWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("recordWrite.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecordDTO dto = new RecordDTO();
		
		dto.setScore1(Integer.parseInt(request.getParameter("score1")));
		dto.setScore2(Integer.parseInt(request.getParameter("score2")));
		dto.setScore3(Integer.parseInt(request.getParameter("score3")));
		dto.setScore4(Integer.parseInt(request.getParameter("score4")));
		dto.setScore5(Integer.parseInt(request.getParameter("score5")));
		//최대, 최소, 합, 평균
		//int max = dto.getScore1();
		dto.setS_max(dto.getScore1());
		if(dto.getS_max() < dto.getScore2()) {
			dto.setS_max(dto.getScore2());
		}
		if(dto.getS_max() < dto.getScore3()) {
			dto.setS_max(dto.getScore3());
		}
		if(dto.getS_max() < dto.getScore4()) {
			dto.setS_max(dto.getScore4());
		}
		if(dto.getS_max() < dto.getScore5()) {
			dto.setS_max(dto.getScore5());
		}

		dto.setS_min(dto.getScore1());
		if(dto.getS_min() > dto.getScore2()) {
			dto.setS_min(dto.getScore2());
		}
		if(dto.getS_min() > dto.getScore3()) {
			dto.setS_min(dto.getScore3());
		}
		if(dto.getS_min() > dto.getScore4()) {
			dto.setS_min(dto.getScore4());
		}
		if(dto.getS_min() > dto.getScore5()) {
			dto.setS_min(dto.getScore5());
		}
		//최대,최소를 뺀 합계
		dto.setS_tot(dto.getScore1()+dto.getScore2()+dto.getScore3()
				+dto.getScore4()+dto.getScore5()-dto.getS_max()-dto.getS_min());
		dto.setS_ave(dto.getS_tot()/3.);
		
		
		
		//평균
		

	}

}
