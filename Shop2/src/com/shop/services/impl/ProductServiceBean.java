package com.shop.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductDao;
import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.services.ProductService;

@Service("productService")
public class ProductServiceBean implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getHotProduct() {
		List<Product> list = productDao.getHotProduct();
		for (int i = 9; i < list.size(); i++) {
			list.remove(i);
		}
		return list;
	}

	@Override
	public List<Product> getNewProduct() {
		List<Product> list = productDao.getNewProduct();
		return list;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = productDao.getAllProduct();
		return list;
	}

	@Override
	public Product getProductById(Product product) {
		Product product2 = productDao.getProductById(product);
		return product2;
	}

	@Override
	public boolean addIntoCart(Cart cart) {
		
		cart.setCartid(UUID.randomUUID().toString().trim().replaceAll("-", ""));
		Product product1 = new Product();
		product1.setPid(cart.getPid());
		Product product = getProductById(product1);
		cart.setProduct(product);
		cart.setTotal(product.getShopPrice()*cart.getNum());
		System.out.println("cart中的东西："+cart);
		boolean b = productDao.addNewCart(cart);
		if(b)System.out.println("加入购物车成功");
		else System.out.println("加入购物车失败");
		return false;
	}

}
