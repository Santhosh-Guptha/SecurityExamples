package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class MyControllertwo {

	@GetMapping("/home")
	public String home() {
		return "This is my home Page";
		}
	@GetMapping("/login")
	public String login() {
		return "This is my login Page";
		}
	@GetMapping("/register")
	public String register() {
		return "This is my register Page";
		}
}
