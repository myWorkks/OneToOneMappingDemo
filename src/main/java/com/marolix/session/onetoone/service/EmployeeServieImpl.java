package com.marolix.session.onetoone.service;

import java.util.Optional;

import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marolix.session.onetoone.dto.EmployeeDTO;
import com.marolix.session.onetoone.dto.PassportDTO;
import com.marolix.session.onetoone.entity.Employee;
import com.marolix.session.onetoone.entity.Passport;
import com.marolix.session.onetoone.repository.EmployeeRepository;
import com.marolix.session.onetoone.repository.PassportRepository;

@Service(value = "employeeService")
@Transactional
public class EmployeeServieImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PassportRepository passportRepository;

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
		return "employee deleted successfully wit id "+empid;
	}

}
