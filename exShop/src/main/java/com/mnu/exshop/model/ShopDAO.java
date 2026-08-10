package com.mnu.exshop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mnu.exshop.util.DBManager;

public class ShopDAO {
	private ShopDAO() {}
	public static ShopDAO instance=new ShopDAO();
	public static ShopDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1. 회원번호 최대 값 검색
	public int custMax() {
		//반환타입
		int row = 0;
		//쿼리
		String sql="select max(custno) from tbl_member";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//2. 도시코드 검색
	public List<CityDTO> cityList(){
		List<CityDTO> list = new ArrayList();
		String sql="select * from tbl_city";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CityDTO dto = new CityDTO();
				dto.setCity(rs.getString("city"));
				dto.setCityname(rs.getString("cityname"));
				
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
