package com.byteslounge.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	
	private static Map<String, Account> accounts = new HashMap<String, Account> ();
	static {
		Account a1234 = new Account("1234", "Tom Dunne");
		Account a1235 = new Account("1235", "Tom Dunne"); 
		Account a1236 = new Account("1236", "Tom Dunne"); 
		Account a1237 = new Account("1237", "Tom Dunne"); 
		accounts.put("a1234", a1234);
		accounts.put("a1235", a1235);
		accounts.put("a1236", a1236);
		accounts.put("a1237", a1237);
		
	}
	public Account findAccount(String id) {
		Account account = accounts.get(id);
		return account;
	}
}
