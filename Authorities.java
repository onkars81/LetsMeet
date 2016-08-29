package com.letsmeet.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Authorities {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="auth_seq")
	@SequenceGenerator(
			name="auth_seq",
			sequenceName="authority_seq",
			allocationSize=1,
			initialValue=1
			)
	int authoritiesid;
	
	String username;
	String authorities;
	
	public Authorities() {
	
	}
	
	
	public int getAuthoritiesid() {
		return authoritiesid;
	}


	public void setAuthoritiesid(int authoritiesid) {
		this.authoritiesid = authoritiesid;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}


	public Authorities(int authoritiesid, String username, String authorities) {
		super();
		this.authoritiesid = authoritiesid;
		this.username = username;
		this.authorities = authorities;
	}
	
	
	
	
	
}
