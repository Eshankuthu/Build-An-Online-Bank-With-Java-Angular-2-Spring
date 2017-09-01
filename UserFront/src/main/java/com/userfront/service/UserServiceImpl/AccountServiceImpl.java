package com.userfront.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.SavingsAccount;
import com.userfront.service.AccountService;
import com.userfront.service.UserService;

public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	
	@Autowired
	private UserService userservice;
	

	@Override
	public PrimaryAccount createPrimaryAccount() {
		
		PrimaryAccount primaryAccount = new PrimaryAccount();
		
		return null;
	}

	@Override
	public SavingsAccount createSavingsAccount() {
		
		return null;
	}

}
