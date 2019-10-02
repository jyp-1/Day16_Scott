package com.jy.scott;

import com.jy.control.FrontController;
import com.jy.dept.DeptDAO;
import com.jy.dept.DeptDTO;
import com.jy.emp.EmpDAO;
import com.jy.emp.EmpDTO;

public class ScottMain {

	public static void main(String[] args) {

		// FrontController frontController = new FrontController();
		// frontController.start();

		/**DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDeptno(98);
		deptDTO.setDname("test");
		deptDTO.setLoc("test");
		int result = deptDAO.deptInsert(deptDTO);
		System.out.println(result);
		if (result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		 */
		
		EmpDAO empDAO = new EmpDAO();
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(7666);
		empDTO.setEname("BOB");
		empDTO.setJob("SALESMAN");
		empDTO.setMgr(7902);
		empDTO.setSal(1300);
		empDTO.setComm(0);
		empDTO.setDeptno(10);
		int result = empDAO.empInsert(empDTO);
		System.out.println(result);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
		
		
		
		
	}

}
