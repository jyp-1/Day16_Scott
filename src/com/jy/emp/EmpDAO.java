package com.jy.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jy.utill.DBConnector;

public class EmpDAO {

	public int delete(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			String sql = "delete emp where empno=?";
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return result;
	}

	// insert

	public int empInsert(EmpDTO empDTO) {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into emp values (?,?,?,?,sysdate,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7, empDTO.getDeptno());

			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	// getSelectList
	// 전체사원정보 - 최신 입사일순

	public ArrayList<EmpDTO> getSelectList() {
		DBConnector db = new DBConnector();

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "select * from emp " + "order by hiredate desc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
				ar.add(empDTO);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;

	}

	// getSelectone
	// 매개변수로 사원번호

	public EmpDTO getSelectone(int empno) {
		DBConnector db = new DBConnector(); // 공통의 정보를 불러오기

		Connection con = null; // 연결
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empDTO = null; // 정보를 옮겨주는 DTO 객체

		try {
			con = DBConnector.getConnect(); // 연결
			String sql = "select * from emp where empno=?"; // sql문
			st = con.prepareStatement(sql);

			st.setInt(1, empno);

			rs = st.executeQuery();

			if (rs.next()) { // 정보를 옮겨주는 DTO에 각 내용을 rs에 저장된 값을 불러와서 적용 시킴
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return empDTO; // 저장된 값이 있는 DTO를 리턴해줌
	}

}
