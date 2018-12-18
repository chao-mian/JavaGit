package com.shop.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String productList(Model model) {
		System.out.println("进入ProductList！！！！！！！！！！！");
		List<Product> list = productService.getAllProduct();
		for (Product product : list) {
			System.out.println(product);
		}
		model.addAttribute("productList", list);
		return "product_list";
	}
	@RequestMapping("/productInfo/{pid}")
	public String productInfo(@PathVariable("pid") String pid,Model model) {
		System.out.println("进入info！！！！！！！！！！！");
		System.out.println("商品编号"+pid);
		Product product = new Product();
		product.setPid(pid);
		Product product2 = productService.getProductById(product);
		System.out.println(product2);
		model.addAttribute("product", product2);
		model.addAttribute("num", 1);
		return "product_info";
		
	}
	@RequestMapping("/addIntoCart")
	public String addIntoCart(Model model,
			@RequestBody Cart cart,
			HttpServletRequest req,
			HttpServletResponse response,
			HttpSession ss) {
		System.out.println("进入AddCar！！！！！！！！！！！");
		System.out.println(cart);
		User user = (User) ss.getAttribute("user");
		System.out.println("session中的user===="+user);
		cart.setUser(user);
		productService.addIntoCart(cart);
		return "test";
	}

}
