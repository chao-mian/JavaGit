package com.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.CartDao;
import com.shop.domain.Cart;
import com.shop.domain.CartExample;
import com.shop.domain.CartExample.Criteria;
import com.shop.mapper.CartMapper;

@Repository("cartDao")
public class CartDaoBean implements CartDao{

	@Autowired
	private CartMapper cartMapper;
	@Override
	public List<Cart> getCartByUid(Cart cart) {
		CartExample example = new CartExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(cart.getUid());
		List<Cart> list = cartMapper.selectByExample(example);
		return list;
	}

}
