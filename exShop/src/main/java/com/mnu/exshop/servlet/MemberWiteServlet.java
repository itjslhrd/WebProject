package com.mnu.exshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exshop.model.CityDTO;
import com.mnu.exshop.model.MemberDTO;
import com.mnu.exshop.model.ShopDAO;

/**
 * Servlet implementation class MemberWiteServlet
 */
@WebServlet("/memberWrite")
public class MemberWiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopDAO dao = ShopDAO.getInstance();
		
		int custno = dao.custMax();
		List<CityDTO> list = dao.cityList();
		
		request.setAttribute("custno", custno);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ShopDAO dao = ShopDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		
		dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		dto.setCustname(request.getParameter("custname"));
		dto.setPhone(request.getParameter("phone1")+"-" + 
				request.getParameter("phone2")+"-" +
				request.getParameter("phone3"));
		dto.setGender(request.getParameter("gender"));
		dto.setJoindate(request.getParameter("joindate"));
		dto.setGrade(request.getParameter("grade"));
		dto.setCity(request.getParameter("city"));
		
		//등록 메소드 호출
		int row = dao.memberWrite(dto);
		//인덱스로 바로 이동할 경우
		//response.sendRedirect("/");
		
		// 경고창 별도 생성시
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("insert_pro.jsp");
		rd.forward(request, response);
	}

}
