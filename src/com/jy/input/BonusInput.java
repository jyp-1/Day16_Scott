package com.jy.input;

import java.util.Scanner;

import com.jy.Bonus.BonusDTO;

public class BonusInput {
	Scanner sc = null;

	public BonusInput() {

		sc = new Scanner(System.in);

	}

	public BonusDTO insert() {

		BonusDTO bonusDTO = new BonusDTO();
		
		System.out.println("사원이름을 입력");
		String ename = sc.next();
		bonusDTO.setEname(ename);
		
		System.out.println("job을 입력");
		String job = sc.next();
		bonusDTO.setJob(job);
		
		System.out.println("sal을 입력");
		int sal = sc.nextInt();
		bonusDTO.setSal(sal);
		
		System.out.println("comm을 입력");
		int comm = sc.nextInt();
		bonusDTO.setComm(comm);
		
		return bonusDTO;

	}

	public String bonusInfo() {
		String ename = null;
		System.out.println("사원 이름을 입력");
		ename = sc.next();
		
		return ename;
		

	}

}
