package com.jy.control;

import java.util.List;
import java.util.Scanner;

import com.jy.Bonus.BonusDAO;
import com.jy.Bonus.BonusDTO;
import com.jy.input.BonusInput;
import com.jy.view.BonusView;

public class BonusController {

	private Scanner sc;
	private BonusDTO bonusDTO;
	private BonusDAO bonusDAO;
	private BonusView bonusView;
	private BonusInput bonusInput;
	private String ename;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDTO = new BonusDTO();
		bonusDAO = new BonusDAO();
		bonusView = new BonusView();
		bonusInput = new BonusInput();

	}

	// start - 컨트롤러
	public void start() {
		boolean check = true;

		while (check) {
			System.out.println("1. 전체조회");
			System.out.println("2. 검색조회");
			System.out.println("3. 정보 추가");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 종료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				
				
				List<BonusDTO> ar = bonusDAO.bonSelectlist();
				if (ar.size() > 0) {
					bonusView.view(ar);
				} else {
					bonusView.view("데이터가 없습니다.");
				}

				break;

			case 2:
				
				String str = bonusInput.bonusInfo();
				BonusDTO bonusDTO2 = bonusDAO.bonSelectone(str);
				if (bonusDTO2 != null) {
					bonusView.view(bonusDTO2);
				} else {
					bonusView.view("없는 사람입니다.");
				}
				break;

			case 3:
				BonusDTO bonusDTO = bonusInput.insert();
				select = bonusDAO.insert(bonusDTO);
				String s = "사원정보 추가 실패";
				if (select > 0) {
					s = "사원추가 성공";
				}
				bonusView.view(s);
				break;

			case 4:
				str = bonusInput.bonusInfo();
				select = bonusDAO.bondelete(str);
				String d = "삭제 실패";
				if (select > 0) {
					d = "삭제 성공";
				}
				bonusView.view(d);

				break;

			default:
				check=!check;

			}

		}

	}

}
