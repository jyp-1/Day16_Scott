package com.jy.input;

import java.util.Scanner;

import com.jy.dept.DeptDTO;


public class DeptInput {

	private Scanner sc;
	private int deptno;
	private String dname;
	private String loc;

	public DeptInput() {
		sc= new Scanner(System.in);
	}
	
	//메서드명 insert 
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		System.out.println("부서번호");
		int num = sc.nextInt();
		deptDTO.setDeptno(deptno);
		System.out.println("부서이름");
		String name = sc.next();
		deptDTO.setDname(dname);
		System.out.println("부서장소");
		String lo = sc.next();
		deptDTO.setLoc(loc);
		
		return deptDTO;
		
		
		
	}

	public int deptInfo() {
		int info = 0;
		System.out.println("부서번호를 입력하세요");
		info = sc.nextInt();
		return deptInfo();
	}

}
