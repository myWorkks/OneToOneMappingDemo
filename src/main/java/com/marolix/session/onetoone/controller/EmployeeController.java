package com.marolix.session.onetoone.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.session.onetoone.dto.AddressDTO;
import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.exception.EmployeeManagementException;
import com.marolix.session.onetoone.service.EmployeeService;

import jakarta.validation.Valid;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "base-url")
@Validated
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

	@GetMapping(value = "/demo")
	public String demoMethodForMultipleRequestParams(@RequestParam String fName, @RequestParam String lName,
			@RequestParam String email, @RequestParam String phNumber, @RequestParam String street) {

		logger.info("demo method called");
		System.out.println(String.format(
				"printing method paramters --> fName - %s,lNAme -%s, email -%s,phnNumber - %s ,street -%s ", fName,
				lName, email, phNumber, street));
		return "demo method called successfully";
	}

	@GetMapping(value = "/login")
	public String demologin(@RequestParam String userName, @RequestParam String password) {

		logger.info("demo method called");

		return "login get method called successfully "
				+ String.format("printing method paramters --> uNme - %s,pswwd -%s", userName, password);
	}

	@PostMapping(value = "/login")
	public String demoPostlogin(@RequestParam String userName, @RequestParam String password) {

		logger.info("demo method called");

		return "login post method called successfully "
				+ String.format("printing method paramters --> uNme - %s,pswwd -%s", userName, password);
	}

	@PostMapping(value = "/demo")
	public String demoMethodForMultipleRequestParams1(@RequestParam(required = false) String fName,
			@RequestParam(required = false) String lName, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phNumber, @RequestParam(required = false) String street) {

		logger.info("demo method called");
		System.out.println();
		return "post demo method called successfully" + String.format(
				"printing method paramters --> fName - %s,lNAme -%s, email -%s,phnNumber - %s ,street -%s ", fName,
				lName, email, phNumber, street);
	}

	@PostMapping(value = "add-employee")
	public String addEmployee(@Valid @RequestBody EmployeeDTO dto) {
		try {
			logger.info("add employee called in controller");
			logger.info("calling service method with dto " + dto);
			String succ = employeeService.addEmployee(dto);
			return succ;
		} catch (Exception e) {
			if (e instanceof MethodArgumentNotValidException) {
				MethodArgumentNotValidException e1 = (MethodArgumentNotValidException) e;
				String error1 = e1.getBindingResult().getAllErrors().stream()
						.map((ObjectError error) -> error.getDefaultMessage()).collect(Collectors.joining(", "));
				System.out.println(error1);
				return error1;
			} else
				return null;
		}

		// code for reference
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter employee details");
//		System.out.println("enter name");
//		String name = sc.nextLine();
//		System.out.println("enter designation");
//		String designation = sc.next();
//		System.out.println("enter salary");
//		Float salary = sc.nextFloat();
//		EmployeeDTO dto = new EmployeeDTO(name, designation, salary);
	}

	@PutMapping(value = "update-passport")
	public String updatePassportDetails(@Valid @ModelAttribute PassportDTO passportDto, @RequestParam Long empId)
			throws IOException {
		logger.info("update passport method called");
		logger.info("empId->" + empId + "passport details " + passportDto);
		logger.info("printing file name " + passportDto.getPassprtImage().getOriginalFilename());

		try {
			return employeeService.addPossportDetails(empId, passportDto);
		} catch (EmployeeManagementException e) {
			return e.getMessage();

		}

		//
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter passport details");
//		System.out.println("enter number");
//		String name = sc.next();
//
//		PassportDTO p = new PassportDTO();
//		p.setPassportNumber(name);
//		System.out.println("enter empId");
//		long empid = sc.nextLong();
	}

	@DeleteMapping(value = "/del-passport")
	public String deletePassportDetails(@RequestParam Long pid) throws EmployeeManagementException {

		String s = employeeService.deletePassport(pid);
		return s;
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
