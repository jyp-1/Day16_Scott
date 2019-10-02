package com.jy.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jy.dept.DeptDTO;
import com.jy.emp.EmpDAO;
import com.jy.emp.EmpDTO;
import com.jy.input.EmpInput;
import com.jy.view.EmpView;

public class EmpController {

	// start
	// 1. 사원전체 정보 출력
	// 2. 사원검색 출력
	// 3. 종료
	private Scanner sc;
	private EmpDAO empDAO;
	private EmpView empView;
	private EmpInput empInput;
	private int empno;

	public void start() {

		sc = new Scanner(System.in);
		empDAO = new EmpDAO();
		empView = new EmpView();
		empInput = new EmpInput();
		int select = 0;
		boolean check = true;

		while (check) {
			System.out.println("1. 사원전체 정보 출력");
			System.out.println("2. 사원검색 출력");
			System.out.println("3. 사원정보 입력");
			System.out.println("4. 사원정보 삭제");
			System.out.println("5. 종료");

			select = sc.nextInt();

			switch (select) {
			case 1:
				ArrayList<EmpDTO> ar = empDAO.getSelectList();
				if (ar.size() > 0) {
					empView.view(ar);
				} else {
					empView.view("데이터가 없습니다");
				}

				break;
			case 2:
				select = empInput.empnoInput();
				EmpDTO empDTO = empDAO.getSelectone(select);
				if (empDTO != null) {
					empView.view(empDTO);
				} else {
					empView.view("없는 부서번호입니다.");
				}
				break;

			case 3:
				EmpDTO empDTO2 = empInput.insert();
				select = empDAO.empInsert(empDTO2);
				String s = "사원정보 추가 실패";
				if (select > 0) {
					s = "사원추가 성공";
				}
				empView.view(s);

				break;

			case 4:
				
				select =empDAO.delete(empno);
				String d = "삭제 실패";
				if(select>0) {
					d="삭제 성공";
				}
				empView.view(d);
				
				
				break;

			default:
				check = !check;

			}
		}
	}

	// com.jy.dept.DeptDAO
	// com.jy.dept.DeptDTO
	// com.jy.view.DeptView
	// com.jy.input.DeptInput
	// com.jy.Controll.DeptController

}
