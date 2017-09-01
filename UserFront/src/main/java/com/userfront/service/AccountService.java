package com.userfront.service;



import com.userfront.domain.PrimaryAccount;

import com.userfront.domain.SavingsAccount;


public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
   
    
}
