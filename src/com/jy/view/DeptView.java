package com.jy.view;

import java.util.List;

import com.jy.dept.DeptDTO;

public class DeptView {
	
	public void view(List<DeptDTO> ar) {			//전체를 꺼낼때
		for(DeptDTO deptDTO : ar) {
			this.view(deptDTO);
			
		}
	}
	
	
	public void view(DeptDTO deptDTO) {						//한 row만 꺼낼때
		System.out.println("--------------------------");
		System.out.println(deptDTO.getDeptno());
		System.out.println(deptDTO.getDname());
		System.out.println(deptDTO.getLoc());
	}
	
	
	public void view(String str) {			//값이 없을떄 
		System.out.println(str);
		
		
	}

}
