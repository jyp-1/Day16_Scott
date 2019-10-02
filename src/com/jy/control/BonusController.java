package com.jy.control;

import java.util.List;
import java.util.Scanner;

import com.jy.Bonus.BonusDAO;
import com.jy.Bonus.BonusDTO;

public class BonusController {

	private Scanner sc;
	private BonusDTO bonusDTO;
	private BonusDAO bonusDAO;
	// private BonusView bonusView;
	// private BonusInput bonusInput;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDTO = new BonusDTO();
		// bonusView = new BonuView();
		// bonusInput = new BonusInput();

	}

	// start - 컨트롤러
	public void start() {
		boolean check = true;

		while (check) {
			System.out.println("1. 전체 조회");
			System.out.println("2. 검색 조회");
			System.out.println("3. 정보 삭제");
			System.out.println("4. 종료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				List<BonusDTO> ar = bonusDAO.bonSelectlist();
				if(ar.size()>0) {
					//bonusView.view(ar);
				}else {
					//bonusView.view("데이터가 없습니다.");
				}
				
				break;
				
			case 2:
				/**select = bonusInput.bonusinfo();
				 * BonusDTO bonusDTO = BonusDAO.bonSelectone(select);
				 * 
				 * 
				*/
				break;
				
			case 3:
				
				break;
				
			default:

			}

		}

	}

}
