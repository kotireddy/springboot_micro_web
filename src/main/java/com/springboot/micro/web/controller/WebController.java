package com.springboot.micro.web.controller;

import com.springboot.micro.web.bean.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping(value={"/","/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/user")
	public ModelAndView userPage() {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext()
							.getAuthentication().getPrincipal();
		System.out.println(userDetails.getAuthorities());
		return new ModelAndView("user");
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView adminPage() {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		System.out.println(userDetails.getAuthorities());
		return new ModelAndView("admin");
	}
	
}
