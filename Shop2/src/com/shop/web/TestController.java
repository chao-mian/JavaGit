package com.shop.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.TbUser;
import com.shop.services.TbUserService;


@Controller
public class TestController {

	@Autowired
	private TbUserService tbUserService;
	@RequestMapping(value="/test")
	protected String test(Model model) {
		List<TbUser> list = tbUserService.getTbUser();
		for (TbUser tbUser : list) {
		System.out.println(tbUser);	
		}
		model.addAttribute("user", list);
		return "test";
	}
}
