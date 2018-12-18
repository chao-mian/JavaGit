package com.shop.dao;

import java.util.List;

import com.shop.domain.Cart;

public interface CartDao {
public List<Cart> getCartByUid(Cart cart);
}
