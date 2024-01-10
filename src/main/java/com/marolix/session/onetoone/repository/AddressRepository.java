package com.marolix.session.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marolix.session.onetoone.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
