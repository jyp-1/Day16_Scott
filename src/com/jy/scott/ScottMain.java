package com.jy.scott;

import com.jy.emp.EmpDAO;
import com.jy.emp.EmpDTO;
import com.jy.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		EmpDAO empDAO =new EmpDAO();				//DAO의 객체
		EmpDTO empDTO = new EmpDTO();				//DTO의 객체 
		EmpView empview = new EmpView();			//VIEW의 객체
		
		empDAO.getSelectList();
		
		/**empDTO =empDAO.getSelectone(7369);			//DAO에 있는 저장값을 바탕으로 사원의 번호를 넣어 DTO에 집어넣을때  
		if(empDTO !=null) {							//결과가 비어있지 않으면 VIEW에 있는 DTO의 값을 보여주고 
			empview.view(empDTO);					//비어있으면 없는 사원번호 라는 문구를 프린트
		}else {
			System.out.println("없는 사원번호");
		}
		
		*/

	}

}
