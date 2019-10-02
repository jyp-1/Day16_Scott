package com.jy.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jy.utill.DBConnector;

public class DeptDAO {
	
	
	public int deptInsert(DeptDTO deptDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con= DBConnector.getConnect();
			String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			result =st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
	
	
	
	public List<DeptDTO> deptSelectlist() {					//List 는 ArrayList 의 
		ArrayList<DeptDTO> ar= new ArrayList<DeptDTO>();   //ArrayList<DeptDTO> ar=null; 이렇게 쓸 경우 
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from dept order by deptno asc";
			st = con.prepareStatement(sql);
			rs= st.executeQuery();
			
			while(rs.next()) {
				DeptDTO deptDTO = new DeptDTO();			//ar = new ArrayList<DeptDTO>(); 이렇게 되면 한개의 값만 들어간 list를 리턴하게 되버림 
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				ar.add(deptDTO);
				
				
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
		return ar;
	}
	
	
	
	public DeptDTO deptSelectone(int deptno) {
		DeptDTO deptDTO = null;		//미리 오류를 없애기 
		Connection con= null;		//지역변수는 초기화 시켜서 사용
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql ="select * from dept where deptno=? ";
		
			st=con.prepareStatement(sql);
			
			st.setInt(1, deptno);
			
			rs=st.executeQuery();
			
			if(rs.next()) {
				deptDTO = new DeptDTO(); 
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				
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
		
		
		
		
		return deptDTO;
	}

}
