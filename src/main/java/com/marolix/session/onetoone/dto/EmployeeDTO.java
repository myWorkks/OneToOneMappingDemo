package com.marolix.session.onetoone.dto;

public class EmployeeDTO {
	private Long empId;
	private String empName;
	private String designation;
	private Float salaray;

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
				+ salaray + "]";
	}

}
