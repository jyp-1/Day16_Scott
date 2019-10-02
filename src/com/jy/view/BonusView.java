package com.jy.view;

import java.util.List;

import com.jy.Bonus.BonusDTO;

public class BonusView {

	public void view(String str) {
		System.out.println(str);
	}

	public void view(BonusDTO bonusDTO) {
		System.out.println("---------------------------");
		System.out.println("Ename :");
		System.out.println("Job : ");
		System.out.println("Sal : ");
		System.out.println("comm : ");
	}

	public void view(List<BonusDTO> ar) {
		for (BonusDTO bonusDTO : ar) {
			this.view(bonusDTO);

		}

	}

}
