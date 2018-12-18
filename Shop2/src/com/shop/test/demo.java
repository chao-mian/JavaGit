package com.shop.test;

import java.io.IOException;
import java.util.List;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.TbUser;
import com.shop.services.CartService;
import com.shop.services.ProductService;
import com.shop.services.TbUserService;


public class demo {

	@Test
	public void fun() throws IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CartService cartService = (CartService) ac.getBean("cartService");
		Cart cart = new Cart();
		cart.setUid("f55b7d3a352a4f0782c910b2c70f1ea4");
		List<Cart> list = cartService.getCartByUid(cart);
		for (Cart cart2 : list) {
			System.out.println(cart2);
		}
	}
}
