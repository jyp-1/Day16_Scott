package com.jy.Bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jy.utill.DBConnector;

public class BonusDAO {

	// bondelete - 정보 삭제

	public int bondelete(String ename) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "delete bonus where ename=?";
			st = con.prepareStatement(sql);
			st.setString(1, ename);
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

	// bonSelectlist -전체조회

	public List<BonusDTO> bonSelectlist() {
		ArrayList<BonusDTO> ar = new ArrayList<BonusDTO>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select * from Bonus";

			st = con.prepareStatement(sql); // 미리보내주기
			rs = st.executeQuery();

			while (rs.next()) {
				BonusDTO bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
				ar.add(bonusDTO);
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

	// bonSelectone - 정보 검색

	public BonusDTO bonSelectone(String ename) {
		BonusDTO bonusDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select sal from bonus where ename=?";
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			rs = st.executeQuery();

			if (rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
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
		return bonusDTO;

	}

	// 정보 입력 insert

	public int insert(BonusDTO bonusDTO) {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into bonus (ename,job,sal,comm) values (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());

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

}
