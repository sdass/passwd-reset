package com.subra.passwdreset.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	//public Optional<Customer> findById(Integer id); implicit
	@Query("select c from Customer c where c.email = :pemail ")
	public Optional<Customer> findbyEmail(@Param ("pemail") String pemail);
	
	//1. will check expiration and return id in customer
	@Query("select c from Customer c where lower(c.email) = lower(:pemail) and c.resetToken = :ptoken and c.resetTokenExpire < CURRENT_TIMESTAMP ")
	public Optional<Customer> findbyEmailAndResetToken(@Param("pemail") String pemail, @Param("ptoken") String ptoken);
	
	
	//simplified
	@Query("select c from Customer c where c.resetToken = :ptoken and c.resetTokenExpire < CURRENT_TIMESTAMP ")
	public Optional<Customer> findbyResetToken(@Param("ptoken") String ptoken);
	
	
	//2. this will modify based on token and id. token added to restrict if repository exposed as rest endpoint
	@Query("update Customer c set c.password = :ppassword where c.userId = :pid and c.resetToken = :ptoken and c.resetTokenExpire < CURRENT_TIMESTAMP ")
	public int setNewPassword(@Param("pid") Integer pid, @Param("ppassword") String ppassword,  @Param("ptoken") String ptoken );	

	
}
