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
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/memberModify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopDAO dao = ShopDAO.getInstance();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		MemberDTO dto = dao.getMember(custno);
		List<CityDTO> list = dao.cityList();
		
		request.setAttribute("dto", dto);
		request.setAttribute("list", list);//도시코드
		
		RequestDispatcher rd = request.getRequestDispatcher("member_modify.jsp");
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
