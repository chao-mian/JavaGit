package com.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.ProductDao;
import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.ProductExample;
import com.shop.domain.ProductExample.Criteria;
import com.shop.mapper.CartMapper;
import com.shop.mapper.ProductMapper;

@Repository("productDao")
public class ProductDaoBean implements ProductDao{

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CartMapper cartMapper;
	@Override
	public List<Product> getHotProduct() {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsHotEqualTo(1);
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Product> getNewProduct() {
		List<Product> list = productMapper.selectNewProduct();
		return list;
	}

	@Override
	public List<Product> getAllProduct() {
		
		ProductExample example = new ProductExample();
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public Product getProductById(Product product) {
		Product product2 = productMapper.selectByPrimaryKey(product.getPid());
		return product2;
	}

	@Override
	public boolean addNewCart(Cart cart) {
		int i = cartMapper.insert(cart);
		if(i==1)return true;
		else return false;
	}

}
