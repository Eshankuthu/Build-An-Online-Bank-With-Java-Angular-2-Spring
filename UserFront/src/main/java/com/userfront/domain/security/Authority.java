package com.userfront.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private final String authority;
	
 public Authority(String authority) {
		this.authority=authority;
		
	}
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
