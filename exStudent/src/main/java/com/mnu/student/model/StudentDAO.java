package com.mnu.student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mnu.student.util.DBManager;

public class StudentDAO {
	//싱글톤
	private StudentDAO() {} // 생성자
	private static StudentDAO instance = new StudentDAO();//객체 생성
	public static StudentDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 학생 등록 메소드
	public int studentWrite(StudentDTO dto) {
		int row=0;
		String sql="insert into tbl_student_201905(syear, sclass, sno, sname, birth, gender, tel1, tel2, tel3) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSyear());
			pstmt.setString(2, dto.getSclass());
			pstmt.setString(3, dto.getSno());
			pstmt.setString(4, dto.getSname());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getTel1());
			pstmt.setString(8, dto.getTel2());
			pstmt.setString(9, dto.getTel3());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	
	// 학생 성적 메소드
	public int scoreWrite(ScoreDTO dto) {
		int row=0;
		String sql="insert into tbl_score_201905(syear, sclass, sno, kor, eng, mat) "
				+ "values(?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSyear());
			pstmt.setString(2, dto.getSclass());
			pstmt.setString(3, dto.getSno());
			pstmt.setInt(4, dto.getKor());
			pstmt.setInt(5, dto.getEng());
			pstmt.setInt(6, dto.getMat());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// 학생 성적 조회(리스트 방식)
	public List<StudentScoreDTO> scoreList() {
		List<StudentScoreDTO> list = new ArrayList();
		String sql="select t1.syear,t1.sclass,t1.sno,sname,gender,kor,eng,mat \r\n"
				+ "        from tbl_student_201905 t1 join tbl_score_201905 t2\r\n"
				+ "                on t1.syear=t2.syear and t1.sclass=t2.sclass and t1.sno=t2.sno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				StudentScoreDTO dto = new StudentScoreDTO();
				dto.setSyear(rs.getString("syear"));
				dto.setSclass(rs.getString("sclass"));
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setGender(rs.getString("gender"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));

				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);//select
		}
		return list;
	}

	// 학생 성적 조회(map 방식)
	public Map<StudentDTO,ScoreDTO> scoreMapList() {
		Map<StudentDTO,ScoreDTO> map = new HashMap();
		String sql="select t1.syear,t1.sclass,t1.sno,sname,gender,kor,eng,mat \r\n"
				+ "        from tbl_student_201905 t1 join tbl_score_201905 t2\r\n"
				+ "                on t1.syear=t2.syear and t1.sclass=t2.sclass and t1.sno=t2.sno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO kDTO = new StudentDTO();
				ScoreDTO  vDTO = new ScoreDTO();
				kDTO.setSyear(rs.getString("syear"));
				kDTO.setSclass(rs.getString("sclass"));
				kDTO.setSno(rs.getString("sno"));
				kDTO.setSname(rs.getString("sname"));
				kDTO.setGender(rs.getString("gender"));
				vDTO.setKor(rs.getInt("kor"));
				vDTO.setEng(rs.getInt("eng"));
				vDTO.setMat(rs.getInt("mat"));

				map.put(kDTO, vDTO);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);//select
		}
		return map;
	}

	//반별통계
	public List<ClassTotalDTO> classTotal(){
		List<ClassTotalDTO> list = new ArrayList();
		String sql="select t1.syear, t1.sclass, tname, sum(kor) tkor,sum(eng) teng, sum(mat) tmat,\r\n"
				+ "        avg(kor) akor, avg(eng) aeng, avg(mat) amat \r\n"
				+ "            from tbl_score_201905 t1 join tbl_dept_201905 t2\r\n"
				+ "                    on t1.syear=t2.syear and t1.sclass=t2.sclass\r\n"
				+ "                            group by t1.syear, t1.sclass, tname";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ClassTotalDTO dto = new ClassTotalDTO();
				dto.setSyear(rs.getString("syear"));
				dto.setSclass(rs.getString("sclass"));
				dto.setTname(rs.getString("tname"));
				dto.setTkor(rs.getInt("tkor"));
				dto.setTeng(rs.getInt("teng"));
				dto.setTmat(rs.getInt("tmat"));
				dto.setAkor(rs.getDouble("akor"));
				dto.setAeng(rs.getDouble("aeng"));
				dto.setAmat(rs.getDouble("amat"));

				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);//select
		}
		return list;
		
	}
}
