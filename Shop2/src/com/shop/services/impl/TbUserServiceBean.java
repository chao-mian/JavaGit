package com.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.TbUserDao;
import com.shop.domain.TbUser;
import com.shop.services.TbUserService;

@Service("tbUserService")
public class TbUserServiceBean implements TbUserService{

	@Autowired
	private TbUserDao tbUserDao;
	@Override
	public List<TbUser> getTbUser() {
		System.out.println("进入TbService");
		List<TbUser> list = tbUserDao.getTbUser();
		return list;
	}

}
