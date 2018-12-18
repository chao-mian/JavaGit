package com.shop.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.services.CartService;
import com.shop.services.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@RequestMapping("/cart")
	public String showCart(Model model,HttpSession ss) {
		System.out.println("进入cartController！！！！！！！！！！！！");
		User user = (User) ss.getAttribute("user");
		Cart cart = new Cart();
		cart.setUser(user);
		List<Cart> list = cartService.getCartByUid(cart);
		double sum = 0;
		for (Cart cart2 : list) {
			System.out.println(cart2);
			sum+=cart2.getTotal();
		}
		model.addAttribute("cart", list);
		model.addAttribute("sum", sum);
		return "cart";
		
	}
}
