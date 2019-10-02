package com.jy.control;

import java.util.Scanner;

import com.jy.emp.EmpDAO;
import com.jy.input.EmpInput;

public class FrontController {
	private Scanner sc;

	public void start() {

		sc = new Scanner(System.in);
		int select = 0;
		boolean check = true;

		while (check) {
			System.out.println("1. 사원정보");
			System.out.println("2. 부서 정보");
			System.out.println("3. 종료");
			select = sc.nextInt();

			switch (select) {
			case 1:
				EmpController empController = new EmpController();
				empController.start();

				break;

			case 2:
				DeptController deptController = new DeptController();
				deptController.start();

				break;

			default:
				check = !check;
			}

		}
	}
}
