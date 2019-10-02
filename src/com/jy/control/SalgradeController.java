package com.jy.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.jy.Sal.SalDTO;
import com.jy.Sal.SalgradeDAO;
import com.jy.input.SalInput;
import com.jy.view.Salview;

public class SalgradeController {

	private Scanner sc;

	private SalgradeDAO salDAO;

	private Salview salView;

	private SalInput salInput;

	public SalgradeController() {

		sc = new Scanner(System.in);

		salDAO = new SalgradeDAO();

		salView = new Salview();

		salInput = new SalInput();

	}

	public void start() {

		boolean check = true;

		int select = 0;

		while (check) {

			System.out.println("1. salgrade 전체 출력");

			System.out.println("2. salgrade 검색출력");

			System.out.println("3. salgrade 정보입력");

			System.out.println("4. salgrade 정보삭제");

			System.out.println("5. 종  료 ");

			select = sc.nextInt();

			switch (select) {

			case 1:

				ArrayList<SalDTO> ar = salDAO.getSalectList();

				if (ar.size() > 0) {

					salView.view(ar);

				} else {

					salView.view("데이터가 없습니다.");

				}

				break;

			case 2:

				select = salInput.gradeinput();

				SalDTO salgradeDTO = salDAO.getSalgradeOne(select);

				if (salgradeDTO != null) {

					salView.view(salgradeDTO);

				} else {

					salView.view("없는 사원 번호입니다.");

				}
				break;

			case 3:

				SalDTO salgradeDTO2 = salInput.insert();

				select = salDAO.salInsert(salgradeDTO2);

				String s = "Insert Fail";

				if (select > 0) {

					s = "Insert Success";

				}

				salView.view(s);

				break;

			case 4:
					
				break;
				
			default:

				check = !check;

			}

		}

	}
}
