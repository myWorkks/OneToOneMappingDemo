package com.marolix.session.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.marolix.session.onetoone.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public Employee findByPassportPassportId(long id);
}
