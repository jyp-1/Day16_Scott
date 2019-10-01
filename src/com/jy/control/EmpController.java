package com.jy.control;

import java.util.Scanner;

import com.jy.emp.EmpDAO;
import com.jy.emp.EmpDTO;
import com.jy.input.EmpInput;

public class EmpController {

	// start
	// 1. 사원전체 정보 출력
	// 2. 사원검색 출력
	// 3. 종료
	private Scanner sc;

	public void start() {

		sc = new Scanner(System.in);
		int num = 0;
		boolean check = true;

		while (check) {
			System.out.println("1. 사원전체 정보 출력");
			System.out.println("2. 사원검색 출력");
			System.out.println("3. 종료");
		}
		num = sc.nextInt();

		switch (num) {
		case 1: EmpDAO empDAO = new EmpDAO();
				empDAO.getSelectList();

			break;

		case 2: EmpInput ei = new EmpInput();
			

			break;

		default:
		}

	}

	// com.jy.dept.DeptDAO
	// com.jy.dept.DeptDTO
	// com.jy.view.DeptView
	// com.jy.input.DeptInput
	// com.jy.Controll.DeptController

}
