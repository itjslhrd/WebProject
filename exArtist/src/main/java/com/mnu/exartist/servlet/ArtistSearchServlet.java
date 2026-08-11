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
import com.mnu.exartist.model.MentoScoreDTO;

/**
 * Servlet implementation class ArtistSearchServlet
 */
@WebServlet("/artistSearch.do")
public class ArtistSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("artist_id", "");
		
		RequestDispatcher rd = request.getRequestDispatcher("artistSearch.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String artist_id = request.getParameter("artist_id").toUpperCase();
		
		ArtistDAO dao = ArtistDAO.getInstance();
		
		List<MentoScoreDTO> list = dao.artistSearch(artist_id);
		
		request.setAttribute("artist_id", artist_id);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("artistSearch.jsp");
		rd.forward(request, response);
		
	}

}
