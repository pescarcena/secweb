package com.jmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="/user")
public class UserController {
	@RequestMapping(value="/list")
	public void list() {
		System.out.println("xxx");
	}
}
