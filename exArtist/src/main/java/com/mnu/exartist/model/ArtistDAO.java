package com.mnu.exartist.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exartist.util.DBManager;

public class ArtistDAO {
	private ArtistDAO() {}
	private static ArtistDAO instance = new ArtistDAO();
	public static ArtistDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	//참가자 등록
	public int artistWrite(ArtistDTO dto) {
		int row=0;
		String sql="insert into tbl_artist_201905(artist_id, artist_name, artist_gender, "
				+ "artist_birth, talent,agency) "
				+ " values (?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dto.getArtist_id());
			pstmt.setString(2,  dto.getArtist_name());
			pstmt.setString(3,  dto.getArtist_gender());
			pstmt.setString(4,  dto.getArtist_birth());
			pstmt.setString(5,  dto.getTalent());
			pstmt.setString(6,  dto.getAgency());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	//참가자 목록 조회
	public List<ArtistDTO> artistList(){
		List<ArtistDTO> list = new ArrayList();
		String sql="select * from tbl_artist_201905";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ArtistDTO dto = new ArtistDTO();
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));
				dto.setArtist_gender(rs.getString("artist_gender"));
				dto.setArtist_birth(rs.getString("artist_birth"));
				dto.setTalent(rs.getString("talent"));
				dto.setAgency(rs.getString("agency"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	//멘토점수 목록 조회
	public List<MentoScoreDTO> mentoScoreList(){
		List<MentoScoreDTO> list = new ArrayList();
		String sql="select serial_no, a.artist_id, artist_name, artist_birth, point, mento_name \r\n"
				+ "        from tbl_point_201905 p join tbl_artist_201905 a on p.artist_id=a.artist_id \r\n"
				+ "                join tbl_mento_201905 m on p.mento_id=m.mento_id";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MentoScoreDTO dto = new MentoScoreDTO();
				dto.setSerial_no(rs.getInt("serial_no"));
				dto.setArtist_id(rs.getString("artist_id"));
				dto.setArtist_name(rs.getString("artist_name"));
				dto.setArtist_birth(rs.getString("artist_birth"));
				dto.setPoint(rs.getInt("point"));
				dto.setMento_name(rs.getString("mento_name"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
}
