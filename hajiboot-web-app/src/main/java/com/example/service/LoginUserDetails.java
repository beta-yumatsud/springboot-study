package com.example.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class LoginUserDetails extends User {

	private static final long serialVersionUID = 1L;
	private final com.example.domain.User user;
	
	public LoginUserDetails(com.example.domain.User user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
	
}
