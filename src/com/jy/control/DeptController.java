package com.jy.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jy.dept.DeptDAO;
import com.jy.dept.DeptDTO;
import com.jy.input.DeptInput;
import com.jy.view.DeptView;

public class DeptController {

	private Scanner sc;
	private DeptDAO deptDAO;
	private DeptView deptView;
	private DeptInput deptInput;

	public DeptController() {
		sc = new Scanner(System.in);
		deptDAO = new DeptDAO();
		deptView = new DeptView();
		deptInput = new DeptInput();

	}

	public void start() {
		boolean check = true;
		int select = 0;

		while (check) {
			System.out.println("1. 부서정보전체출력");
			System.out.println("2. 부서검색출력");
			System.out.println("3. 부서 추가");
			System.out.println("4. 종료");

			select = sc.nextInt();

			switch (select) {
			case 1:
				List<DeptDTO> ar = deptDAO.deptSelectlist();
				if (ar.size() > 0) {
					deptView.view(ar);
				} else {
					deptView.view("데이터가 없습니다.");
				}

				break;
			case 2:
				select = deptInput.deptInfo();
				DeptDTO deptDTO = deptDAO.deptSelectone(select);
				if (deptDTO != null) {
					deptView.view(deptDTO);
				} else {
					deptView.view("없는 사원번호입니다.");
				}
				break;
			case 3:
				DeptDTO deptDTO2 = deptInput.insert();
				select = deptDAO.deptInsert(deptDTO2);
				String s = "Insert Fail";
				if(select>0) {
					s= "Insert Success";
				}
				deptView.view(s);
				break;
			default:
				check = !check;

			}
		}

	}

}
