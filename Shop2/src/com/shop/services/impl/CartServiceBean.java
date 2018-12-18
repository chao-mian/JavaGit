package com.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CartDao;
import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.services.CartService;
import com.shop.services.ProductService;
@Service("cartService")
public class CartServiceBean implements CartService{

	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductService productService;
	@Override
	public List<Cart> getCartByUid(Cart cart) {
		List<Cart> list = cartDao.getCartByUid(cart);
		Product product = new Product();
		for (Cart cart2 : list) {
			product.setPid(cart2.getPid());
			Product product2 = productService.getProductById(product);
			cart2.setProduct(product2);
		}
		return list;
	}

}
