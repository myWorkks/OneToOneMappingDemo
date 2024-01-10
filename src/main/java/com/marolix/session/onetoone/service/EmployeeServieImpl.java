package com.marolix.session.onetoone.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import com.marolix.session.onetoone.dto.AddressDTO;
import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.entity.Address;
import com.marolix.session.onetoone.entity.Employee;
import com.marolix.session.onetoone.entity.Passport;
import com.marolix.session.onetoone.repository.AddressRepository;
import com.marolix.session.onetoone.repository.EmployeeRepository;
import com.marolix.session.onetoone.repository.PassportRepository;

@Service(value = "employeeService")
@Transactional
public class EmployeeServieImpl implements EmployeeService {
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PassportRepository passportRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override

	public String addEmployee(EmployeeDTO dto) {
		Employee e = new Employee();// new entity
		e.setEmpName(dto.getEmpName());
		e.setDesignation(dto.getDesignation());
		e.setSalary(dto.getSalaray());

		Long id = employeeRepository.save(e).getEmpId();
		return "employee registered successfully with emp id : " + id;
	}

	@Override
	public String addPossportDetails(Long emp, PassportDTO dto) {
		Optional<Employee> oemp = employeeRepository.findById(emp);
		Employee empd = oemp.orElseThrow(() -> new RuntimeException("no emp found with id " + emp));

		Passport p = new Passport();
		p.setPassportNumber(dto.getPassportNumber());
		empd.setPassport(p);

		long id = employeeRepository.save(empd).getPassport().getPassportId();
		return "employee passprt updated successfully " + id;
	}

	@Override
	public String deletePassport(Long passid) {
		Employee emp = employeeRepository.findByPassportPassportId(passid);
		if (emp == null)
			throw new RuntimeException("mo employee associated with provided passport id " + passid);
		emp.setPassport(null);
		employeeRepository.save(emp);
		Optional<Passport> opt = passportRepository.findById(passid);
		Passport p = opt.orElseThrow(() -> new RuntimeException("no passport found with id " + passid));
		passportRepository.delete(p);
		return "passport deleted susccfully";
	}

	@Override
	public String deleteEmployee(Long empid) {
		Optional<Employee> oemp = employeeRepository.findById(empid);
		Employee empd = oemp.orElseThrow(() -> new RuntimeException("no emp found with id " + empid));

		employeeRepository.delete(empd);
		return "employee deleted successfully wit id " + empid;
	}

	@Override
	public String addAddress(AddressDTO addressDTO, Long empID) {

		Optional<Employee> optEMp = employeeRepository.findById(empID);
		Employee emp = optEMp.orElseThrow(() -> new RuntimeException("No employee found with id " + empID));

		Address address = new Address();
		address.setHno(addressDTO.getHno());
		address.setStreet(addressDTO.getStreet());
		address.setCity(addressDTO.getCity());
		address.setState(addressDTO.getState());
		address.setPincode(addressDTO.getPincode());
		// address.setEmployee(emp);
		// Long adId = addressRepository.save(address).getAddressId();
		List<Address> addlist = new ArrayList<Address>();
		addlist.add(address);
		emp.setAddress(addlist);

		Long adId = employeeRepository.save(emp).getAddress().get(0).getAddressId();
		return "Address added successfully with id " + adId;
	}

	@Override
	public List<AddressDTO> fetchingBySort(String state) {
		logger.info("sert method called in service");
		Sort sort = Sort.by(state).descending().and(Sort.by("pincode").ascending());
		logger.info("after sorting  in service");
		List<Address> addressesAfterSorting = addressRepository.findAll(sort);
//		String hno2, String street2, String city2, String state2, String pincode2
		return addressesAfterSorting.stream().map(a -> new AddressDTO(a.getAddressId().intValue(), a.getHno(),
				a.getStreet(), a.getCity(), a.getState(), a.getPincode())).collect(Collectors.toList());
	}

	@Override
	public List<AddressDTO> fetchByPaging(int pgNo, int noOfEntities) {
		logger.info("service meethod called for pagination");
		Pageable pageable = PageRequest.of(pgNo, noOfEntities);
		logger.info("Pageable object created successfully");
		Page<Address> page = addressRepository.findAll(pageable);
		List<Address> addresses = null;
		if (page.hasContent()) {
			addresses = (page.getContent());
		}
		if (addresses != null)
			return addresses.stream().map(a -> new AddressDTO(a.getAddressId().intValue(), a.getHno(), a.getStreet(),
					a.getCity(), a.getState(), a.getPincode())).collect(Collectors.toList());
		else
			throw new RuntimeException("No addresses found");
	}

	@Override
	public List<EmployeeDTO> allEmployees() {
		Iterable<Employee> allEmployees = employeeRepository.findAll();

		List<EmployeeDTO> empDtos = new ArrayList<EmployeeDTO>();

		allEmployees.forEach(
				e -> empDtos.add(new EmployeeDTO(e.getEmpId(), e.getEmpName(), e.getDesignation(), e.getSalary())));
		if (empDtos.isEmpty())
			throw new RuntimeException("no employees found");
		return empDtos;
	}

}
