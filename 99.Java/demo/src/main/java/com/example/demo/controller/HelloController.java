package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "Hello, Spring!");
		return "hello";				// templates directory에 있는 hello.html
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value="name", required=false) String name, Model model) {
		name = (name == null) ? "Default MVC user" : name;
		model.addAttribute("name", name);
		return "hello-mvc"; 		// templates directory에 있는 hello-mvc.html
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam(value="name", required=false) String name) {
		name = (name == null) ? "Default String user" : name;
		return "Hello " + name;		// 문자열이 전달됨
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam(value="name", required=false) String name) {
		name = (name == null) ? "Default JSON user" : name;
		Hello hello = new Hello();
		hello.setName(name);
		return hello;			// JSON으로 전달됨
	}
	
	static class Hello {
		private String name;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
