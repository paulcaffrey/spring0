package com.byteslounge.spring.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController {
	AccountManager accountManager = new AccountManager();
	
	@ModelAttribute(value="account")
	public Account addAsdf(@RequestParam("accountId") String accountIde) {
	    return accountManager.findAccount(accountIde);
	}
	
	@RequestMapping(value = "/test",
		method = RequestMethod.GET/*,
		consumes = "application/html"*/)
	public ResponseEntity<String> processXml(@ModelAttribute(value="account") Account account
			//HttpEntity<byte[]> requestEntity) {/*@RequestParam String a) {//*/ //@RequestBody String requestBody
			){
		return new ResponseEntity<String>(
			"Handled http request. Request body was: " 
			+ account, 
			new HttpHeaders(), 
			HttpStatus.OK);
	}
	
	@RequestMapping(value = "/test",
		method = RequestMethod.GET,
		consumes = "application/json")
	public ResponseEntity<String> processJson(@RequestBody String requestBody){
		
		return new ResponseEntity<String>(
			"Handled application/json request. Request body was: " 
			+ requestBody, 
			new HttpHeaders(), 
			HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{userid}", method=RequestMethod.GET)
	public ResponseEntity<String> processJson2(@PathVariable("userid") String userid){
		return new ResponseEntity<String>("the response " + userid, HttpStatus.OK);
		
	}
}
