package com.marolix.session.onetoone.service;

import java.io.IOException;
import java.util.List;

import com.marolix.session.onetoone.dto.AddressDTO;
import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.entity.Passport;
import com.marolix.session.onetoone.exception.EmployeeManagementException;

public interface EmployeeService {

	
	public List<EmployeeDTO> allEmployees();
	public String addEmployee(EmployeeDTO dto);

	public String addPossportDetails(Long empid, PassportDTO dto) throws IOException,EmployeeManagementException;

	public String deletePassport(Long passid) throws EmployeeManagementException;

	public String deleteEmployee(Long empid);

	public String addAddress(AddressDTO addressDTO, Long empID);

	public List<AddressDTO> fetchingBySort(String state);
	
	public List<AddressDTO> fetchByPaging(int pgNo,int noOfEntities);
}
