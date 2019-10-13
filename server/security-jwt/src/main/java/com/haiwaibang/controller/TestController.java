package com.haiwaibang.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenguifeng on 2019/1/29.
 */
@RestController
public class TestController {


	@RequestMapping(value = "/tasks/{id}")
	public String task(@PathVariable int id){
		return String.format("task %d", id);
	}

	@RequestMapping(value = "/other")
	public String other(){
		return "other";
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping("/tasks/test1")
	public String test1() {
		return "test1";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/tasks/test2")
	public String test2() {
		return "test1";
	}
}
