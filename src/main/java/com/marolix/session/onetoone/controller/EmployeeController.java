package com.marolix.session.onetoone.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void addEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter name");
		String name = sc.nextLine();
		System.out.println("enter designation");
		String designation = sc.next();
		System.out.println("enter salary");
		Float salary = sc.nextFloat();
		EmployeeDTO dto = new EmployeeDTO(name, designation, salary);
		String succ = employeeService.addEmployee(dto);
		System.out.println(succ);
	}

	public void updatePassportDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter passport details");
		System.out.println("enter number");
		String name = sc.next();

		PassportDTO p = new PassportDTO();
		p.setPassportNumber(name);
		System.out.println("enter empId");
		long empid = sc.nextLong();
		String s = employeeService.addPossportDetails(empid, p);
		System.out.println(s);
	}

	public void deletePassportDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter passport details");
		System.out.println("enter number");
		long pid = sc.nextLong();

		String s = employeeService.deletePassport(pid);
		System.out.println(s);
	}
	
	public void deleteEmployeeDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter empid");
		long pid = sc.nextLong();

		String s = employeeService.deleteEmployee(pid);
		System.out.println(s);
	}

}
