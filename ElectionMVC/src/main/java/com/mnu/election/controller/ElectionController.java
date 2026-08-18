package com.mnu.election.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.election.service.Action;
import com.mnu.election.service.MemberRankService;
import com.mnu.election.service.MemberListService;
import com.mnu.election.service.VoteListService;
import com.mnu.election.service.VoteWriteService;

/**
 * Servlet implementation class ElectionController
 */
@WebServlet("/Election")
public class ElectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println("요청 파라이터 : " + cmd);
		Action action  = null;
		
		if(cmd.equals("memberList")) {
			action = new MemberListService();
		}else if(cmd.equals("voteWrite")) {
			action = new VoteWriteService();
		}else if(cmd.equals("voteList")) {
			action = new VoteListService();
		}else if(cmd.equals("memberRank")) {
			action = new MemberRankService();
		}
		
		action.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
