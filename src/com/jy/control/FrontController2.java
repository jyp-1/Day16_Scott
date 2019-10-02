package com.jy.control;

import java.util.Scanner;

public class FrontController2 {
	private Scanner sc;

	public void start() {

		sc = new Scanner(System.in);
		int select = 0;
		boolean check = true;

		while (check) {
			System.out.println("1. 월급정보");
			System.out.println("2. 보너스정보");
			System.out.println("3. 종료");
			select = sc.nextInt();

			switch (select) {
			case 1:
				BonusController bonusController = new BonusController();
				bonusController.start();

				break;

			case 2:
				SalgradeController salgradeController = new SalgradeController();
				salgradeController.start();

				break;

			default:
				check = !check;
			}

		}
	}
}
