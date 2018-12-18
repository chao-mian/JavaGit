package com.shop.dao;



import com.shop.domain.User;


public interface UserDao{
public User getLoginUser(User user);
public boolean saveNewUser(User user);
public User getUserByUserName(User user);
}
