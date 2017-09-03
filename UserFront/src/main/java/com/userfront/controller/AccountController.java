package com.userfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@RequestMapping("/primaryaccount")
	public String primaryAccount(){
		return "primaryAccount";
		
	}

	@RequestMapping("/savingsaccount")
	public String savingsAccount(){
		return "savingsAccount";
	}
}
