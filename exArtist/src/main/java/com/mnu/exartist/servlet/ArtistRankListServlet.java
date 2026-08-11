package com.mnu.exartist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exartist.model.ArtistDAO;
import com.mnu.exartist.model.ArtistRankDTO;

/**
 * Servlet implementation class ArtistRankListServlet
 */
@WebServlet("/artistRankList.do")
public class ArtistRankListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistRankListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArtistDAO dao = ArtistDAO.getInstance();
		
		List<ArtistRankDTO> list = dao.artistRankList();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("artistRankList.jsp");
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
