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
@WebServlet("/recordWriteArray.do")
public class RecordWriteArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordWriteArrayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("recordWriteArray.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RecordDTO dto = new RecordDTO();
			dto.setEntry_no(request.getParameter("entry_no"));
			
			String strScore[] = request.getParameterValues("score");
			//문자열 배열을 정수 배열로 변환(기본 for, Stream)
			int score[] = new int[strScore.length];
			for(int i=0; i<strScore.length; i++) {
				score[i] = Integer.parseInt(strScore[i]);
			}
			//최대, 최소, 합계
			int max = score[0];
			int min = score[0];
			int tot = score[0];
			for(int i=1; i<score.length;i++) {
				if(max < score[i])
					max = score[i];
				if(min > score[i])
					min = score[i];
				tot += score[i];
			}
			//dto에 가값 세팅
			dto.setScore1(score[0]);
			dto.setScore2(score[1]);
			dto.setScore3(score[2]);
			dto.setScore4(score[3]);
			dto.setScore5(score[4]);
			dto.setS_max(max);
			dto.setS_min(min);
			dto.setS_tot(tot);
			dto.setS_ave(dto.getS_tot()-max-min);
			
			//db 저장
			
			
			
			
			
	}

}
