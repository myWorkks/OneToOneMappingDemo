package com.marolix.session.onetoone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marolix.session.onetoone.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	public Employee findByPassportPassportId(long id);
}
