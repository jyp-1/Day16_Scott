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
		BonusDTO bonusDTO=null;
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
		}finally {
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

}
