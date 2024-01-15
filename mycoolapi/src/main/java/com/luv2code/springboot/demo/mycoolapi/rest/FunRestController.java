package com.luv2code.springboot.demo.mycoolapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello(){
		return "Hello World";
	}

	@GetMapping("/test")
	public String sayHello2(){
		return "Hello World2";
	}

}
