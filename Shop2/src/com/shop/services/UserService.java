package com.shop.services;

import com.shop.domain.User;

public interface UserService {
public User chackLogin(User user);
public boolean saveNewUser(User user);
}
