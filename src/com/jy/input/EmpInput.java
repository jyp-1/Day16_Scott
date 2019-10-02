package com.jy.input;

import java.sql.Date;
import java.util.Scanner;

import com.jy.emp.EmpDTO;

public class EmpInput {

	private Scanner sc;
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;

	public EmpInput() {
		sc = new Scanner(System.in);

	}

	public EmpDTO insert() {

		EmpDTO empDTO = new EmpDTO();

		System.out.println("사원 번호 입력");
		int num = sc.nextInt();
		empDTO.setEmpno(empno);
		System.out.println("사원 이름 입력");
		String name = sc.next();
		empDTO.setEname(ename);
		System.out.println("직업 입력");
		String j = sc.next();
		empDTO.setJob(job);
		System.out.println("매니저 번호 입력");
		int mn = sc.nextInt();
		empDTO.setMgr(mgr);
		System.out.println("입사 날짜 입력 -> 년/월/일");
		String hd = sc.next();
		empDTO.setHiredate(hiredate);
		System.out.println("월급 입력");
		int m = sc.nextInt();
		empDTO.setSal(sal);
		System.out.println("커미션 입력");
		int co = sc.nextInt();
		empDTO.setComm(comm);
		System.out.println("부서번호 입력");
		int dn = sc.nextInt();
		empDTO.setDeptno(deptno);

		return empDTO;

	}

	// empnoInput
	// 사원번호를 입력하세요
	public int empnoInput() {
		int empno = 0;
		System.out.println("사원번호를 입력하세요");
		empno = sc.nextInt();
		return empno;

	}

}
