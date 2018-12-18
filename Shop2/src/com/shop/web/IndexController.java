package com.shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.Product;
import com.shop.services.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		System.out.println("进入indexController！！！！！！！！！！！！！！！！！！！！！！！！！！");
		List<Product> hotProductList = productService.getHotProduct();
		List<Product> newProductList = productService.getNewProduct();
		model.addAttribute("hotProductList", hotProductList);
		model.addAttribute("newProductList", newProductList);
		for (Product product : newProductList) {
			System.out.println(product);
		}
		return "index";
		
	}
}
