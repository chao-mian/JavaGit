package com.shop.services;

import java.util.List;

import com.shop.domain.Cart;

public interface CartService {
public List<Cart> getCartByUid(Cart cart);
}
