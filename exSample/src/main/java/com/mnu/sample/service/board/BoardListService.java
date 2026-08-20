package com.mnu.sample.service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnu.sample.model.BoardDAO;
import com.mnu.sample.model.BoardDTO;
import com.mnu.sample.service.Action;
//게시판 목록
public class BoardListService implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO = BoardDAO.getInstance();
		
		int totcount = bDAO.boardCount();//총 게시글 수
		List<BoardDTO> bList = bDAO.boardList();//전체 글 목록
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("bList", bList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Board/board_list.jsp");
		rd.forward(request, response);

	}

}
