package com.marolix.session.onetoone.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.session.onetoone.dto.AddressDTO;
import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "base-url")
public class EmployeeController {
	Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private EmployeeService employeeService;

//	@RequestMapping(method = RequestMethod.GET, value = "/")
	@GetMapping(value = "/")
	public String dummyMethod() {
		return "dummy method invoked";
	}

	@GetMapping(value = "/dummy")
	public String dummyMethod1() {
		return "dummy method invoked1";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get-employees")

	public List<EmployeeDTO> viewEmployees() {
		logger.info("get employees method called");
		return employeeService.allEmployees();

	}

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

	public void addAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter emp Id");
		Long empId = sc.nextLong();
		System.out.println("enter address details");
		System.out.println("enter hno");
		String hno = sc.nextLine();
		System.out.println("enter street");
		String street = sc.nextLine();
		System.out.println("enter city");
		String city = sc.nextLine();
		System.out.println("enter state");
		String state = sc.nextLine();
		System.out.println("enter pincode");
		String pincode = sc.nextLine();

		AddressDTO adto = new AddressDTO(null, hno, street, city, state, pincode);
		String scMsg = employeeService.addAddress(adto, empId);
		System.out.println(scMsg);
	}

	// @request param ->HTTPMessageConverter
	@GetMapping(value = "/sort")
	public List<AddressDTO> sortBYColumn(@RequestParam(name = "col-name", required = true) String colName) {
		logger.info("sort method has been invoked with column name " + colName);

		return employeeService.fetchingBySort(colName);

	}
//url=/page-display/pgSize/5/pgNo/0
	@GetMapping(value = "/page-display/pgSize/{pgSize1}/pgNo/{pgNo}")
	public List<AddressDTO> doPaging(@PathVariable(value = "pgNo") Integer pgNo,
			@PathVariable(name = "pgSize1") Integer pgSize) {
		logger.info(String.format("pagination method has called with pg no %d and page size %d", pgNo, pgSize));
		return employeeService.fetchByPaging(pgNo, pgSize);
	}
}
