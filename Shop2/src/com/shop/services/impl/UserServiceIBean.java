package com.shop.services.impl;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.UserDao;
import com.shop.domain.User;
import com.shop.services.UserService;

@Service
public class UserServiceIBean implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User chackLogin(User user) {
		User user2 = userDao.getLoginUser(user);
		return user2;
	}
	@Override
	public boolean saveNewUser(User user) {
		user.setUid(UUID.randomUUID().toString().trim().replaceAll("-", ""));
		System.out.println(user);
		System.out.println(user.getUid().length());
		boolean b = userDao.saveNewUser(user);
		if(b)System.out.println("插入成功");
		else System.out.println("插入失败");
		return b;
	}

}
