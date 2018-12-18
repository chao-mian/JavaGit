package com.shop.dao;

import java.util.List;

import com.shop.domain.Cart;
import com.shop.domain.Product;

public interface ProductDao {
public List<Product> getHotProduct();
public List<Product> getNewProduct();
public List<Product> getAllProduct();
public Product getProductById(Product product);
public boolean addNewCart(Cart cart);
}
