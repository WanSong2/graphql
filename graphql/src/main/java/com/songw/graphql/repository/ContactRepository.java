package com.songw.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.songw.graphql.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query(value =  "select * from contact c where c.customer_number = :customerNumber", nativeQuery=true)
	public Contact findByCustomer (@Param("customerNumber") String customerNumber);
	
}
