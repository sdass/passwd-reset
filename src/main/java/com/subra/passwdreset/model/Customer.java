package com.subra.passwdreset.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Entity(name="Customer")
@Entity
@Table(name="prodcustomer")
public class Customer implements Serializable {
	
/*
 	@Query("update customer c set c.password = :ppassword where c.userId = :pid and c.resetToken = :ptoken ")
	public void setNewPassword(@Param("pid") Integer pid, @Param("ptoken") String ptoken, @Param("ppassword") String ppassword );	
	
 */
	private static final long serialVersionUID = -6726088357359592366L;
	@Id
	@Column(name="user_id")
	private Integer userId;

	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private boolean enabled;
	
	@Column(name="created_on")
	private Date createdOn;
	@Column(name="reset_token")
	private String resetToken;
	@Column(name="reset_token_expire")
	private Date resetTokenExpire;
	

	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getResetToken() {
		return resetToken;
	}



	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}



	public Date getResetTokenExpire() {
		return resetTokenExpire;
	}



	public void setResetTokenExpire(Date resetTokenExpire) {
		this.resetTokenExpire = resetTokenExpire;
	}
	
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", email=" + email
				+ ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", enabled=" + enabled
				+ ", createdOn=" + createdOn + ", resetToken=" + resetToken
				+ ", resetTokenExpire=" + resetTokenExpire + "]";
	}

	
}
