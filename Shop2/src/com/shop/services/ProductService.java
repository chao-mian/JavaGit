package com.shop.services;

import java.util.List;

import com.shop.domain.Cart;
import com.shop.domain.Product;
import com.shop.domain.User;

public interface ProductService {
public List<Product> getHotProduct();
public List<Product> getNewProduct();
public List<Product> getAllProduct();
public Product getProductById(Product product);
public boolean addIntoCart(Cart cart);
}
