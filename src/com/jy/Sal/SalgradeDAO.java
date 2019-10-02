package com.jy.Sal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jy.utill.DBConnector;

public class SalgradeDAO {

	// delete

	public int saldelete(int grade) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "delete salgrade where grade = ? ";
			st = con.prepareStatement(sql);
			st.setInt(1, grade);
			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	// insert

	public int salInsert(SalDTO salDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into sagrade (grade, losal, hisal) "
					+ "+values (?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, salDTO.getGrade());
			st.setInt(2, salDTO.getLosal());
			st.setInt(3, salDTO.getHisal());

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

	// 전체조회

	public ArrayList<SalDTO> getSalectList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<SalDTO> ar = new ArrayList<SalDTO>();
		try {
			con = DBConnector.getConnect();
			String sql = "select grade, losal, hisal "
					+ "from salgrade";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				SalDTO salDTO = new SalDTO();
				salDTO.setGrade(rs.getInt("grade"));
				salDTO.setHisal(rs.getInt("losal"));
				salDTO.setLosal(rs.getInt("hisal"));
				ar.add(salDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}

	// 검색 조회

	public SalDTO getSalgradeOne(int grade) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		SalDTO salDTO = null;
		try {
			con = DBConnector.getConnect();
			String sql = "select* from salgrade "
					+ "where grade = ? ";

			st = con.prepareStatement(sql);
			st.setInt(1, grade);
			rs = st.executeQuery();
			if (rs.next()) {
				salDTO = new SalDTO();
				salDTO.setGrade(rs.getInt("grade"));
				salDTO.setHisal(rs.getInt("losal"));
				salDTO.setLosal(rs.getInt("hisal"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return salDTO;

	}

}
