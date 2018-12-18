package com.shop.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.User;
import com.shop.services.UserService;



@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String userLogin(Model model,User user,HttpServletRequest req,
			HttpServletResponse response,
			HttpSession ss) {
		
		System.out.println("进入loginController！！！！！！！！！！！！！！！！！！！！");
		System.out.println(user);
		User user2 = userService.chackLogin(user);
		if(user2!=null) {
			ss.setAttribute("user", user2);
			return "forward:/index";
		}else {
			return "cart";
		}
	}
	
	@RequestMapping("/register")
	public String userRegister(Model model,User user) {
		System.out.println("进入regiserController！！！！！！！！！！！！！！！！！！！！");
		userService.saveNewUser(user);
		return "forward:/login";		
	}
}
