package com.marolix.session.onetoone.dto;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
//	MethodArgumentNotValidException v;
	private Long empId;
	@NotNull(message = "please provide employee name")
//	@Pattern(regexp = "[a-zA-z]+ ( [a-zA-z]+)*", message = "please provide a valid name ")
	private String empName;// EmpName
	private String designation;
	//@Min(value = 5000)
	private Float salaray;// salary
	private List<AddressDTO> addressDTO;

	public List<AddressDTO> getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(List<AddressDTO> addressDTO) {
		this.addressDTO = addressDTO;
	}

	public EmployeeDTO(Long empId, String empName, String designation, Float salaray) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.salaray = salaray;
	}

	public EmployeeDTO(String name, String designation2, Float salary) {
		this.empName = name;
		this.designation = designation2;
		this.salaray = salary;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Float getSalaray() {
		return salaray;
	}

	public void setSalaray(Float salaray) {
		this.salaray = salaray;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", salaray="
				+ salaray + ", addressDTO=" + addressDTO + "]";
	}

}
