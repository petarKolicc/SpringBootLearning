package com.luv2code.springboot.demo.mycoolapi.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello(){
		return "Hello World";
	}

	@Value("${trener.ime}")
	private String coachName;

	@GetMapping("/test5")
	public String sayHello5(){
		return coachName;
	}

	@GetMapping("/test7")
	public String sayHello7(){
		return coachName;
	}


	@GetMapping("/test8")
	public String sayHello8(){
		return coachName;
	}


	@GetMapping("/test6")
	public String sayHello6(){
		return "nema djidjanja djani";
	}




}
