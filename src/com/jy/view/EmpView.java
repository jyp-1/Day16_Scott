package com.jy.view;

import java.util.ArrayList;

import com.jy.emp.EmpDTO;

public class EmpView {
	
	public void view (ArrayList<EmpDTO> ar) {
		for(EmpDTO empDTO:ar) {
			this.view(empDTO);
		}
	}
	
	public void view(EmpDTO empDTO) {						//값이 저장된 DTO를 받아오는 매개변수로 지정
		
		System.out.println(empDTO.getEmpno());					//DTO에서 각각의 정보를 가져옴(GET)
		System.out.println(empDTO.getEname());
		System.out.println(empDTO.getJob());
		System.out.println(empDTO.getMgr());
		System.out.println(empDTO.getHiredate());
		System.out.println(empDTO.getComm());
		System.out.println(empDTO.getDeptno());
		
	}

}
