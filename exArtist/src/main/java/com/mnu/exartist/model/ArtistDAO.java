package com.mnu.exartist.model;
import java.sql.*;

public class ArtistDAO {
	private ArtistDAO() {}
	private static ArtistDAO instance = new ArtistDAO();
	public static ArtistDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	
}
