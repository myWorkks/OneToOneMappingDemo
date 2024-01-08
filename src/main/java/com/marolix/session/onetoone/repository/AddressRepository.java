package com.marolix.session.onetoone.repository;

import org.springframework.data.repository.CrudRepository;

import com.marolix.session.onetoone.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
