package com.mnu.exgugak.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GugakDAO {
	private GugakDAO() {}
	private static GugakDAO instance = new GugakDAO();
	public static GugakDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//등록 메소드
	
}
