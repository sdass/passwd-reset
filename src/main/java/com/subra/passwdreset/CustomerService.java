package com.subra.passwdreset;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subra.passwdreset.model.Customer;
import com.subra.passwdreset.model.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Optional<Customer> findUserByemail(String email){
		
		return customerRepository.findbyEmail(email);
	}
	
	public Optional<Customer> findByUseremailAndresetToken(String email, String resetToken){
		return customerRepository.findbyEmailAndResetToken(email, resetToken); //checks all timestamp
	}

	public Optional<Customer> findByResetToken( String resetToken){
		return customerRepository.findbyResetToken(resetToken); //checks all timestamp
	}
	
	public int setNewPassword(Integer id, String resetToken, String newpasswd){
		return customerRepository.setNewPassword(id, resetToken, newpasswd);
	}
	
	public Customer saveCustomer(Customer c){
		return customerRepository.saveAndFlush(c);
		
	}
	
}
