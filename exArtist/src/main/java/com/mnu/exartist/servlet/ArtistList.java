package com.mnu.exartist.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.exartist.model.ArtistDAO;
import com.mnu.exartist.model.ArtistDTO;

/**
 * Servlet implementation class ArtistList
 */
@WebServlet("/artistList.do")
public class ArtistList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtistDAO dao = ArtistDAO.getInstance();
	/*	
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년MM월dd일");
		try {
			String today="20260811";//문자열
			Date date = sdf1.parse(today);
			String date2 = sdf2.format(date);
			System.out.println(date2);
		}catch(Exception e) {}
	*/	
		List<ArtistDTO> list = dao.artistList();
		
		
		request.setAttribute("list", list);
		
		//System.out.print(list.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
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
