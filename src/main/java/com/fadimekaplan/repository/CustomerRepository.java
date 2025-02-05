package com.fadimekaplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fadimekaplan.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
 

}