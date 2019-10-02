package com.jy.scott;

import java.util.List;

import com.jy.control.DeptController;
import com.jy.dept.DeptDAO;
import com.jy.dept.DeptDTO;

public class DeptMain {

	public static void main(String[] args) {
		DeptController deptController = new DeptController();
		deptController.start();
		
		DeptDAO dao = new DeptDAO();

		List<DeptDTO> ar = dao.deptSelectlist();
		for (int i = 0; i < ar.size(); i++) {
			DeptDTO deptDTO = ar.get(i);
		}

	}

}
