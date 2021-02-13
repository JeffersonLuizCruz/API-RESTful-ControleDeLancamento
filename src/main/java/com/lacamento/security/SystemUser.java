package com.lacamento.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.lacamento.model.Access;

public class SystemUser extends User {
	private static final long serialVersionUID = 1L;
	
	private Access user;
	
	public SystemUser(Access user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPassword(), authorities);
		this.user = user;
	}
	
	public Access getUser() {
		return user;
	}



}
