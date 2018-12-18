package com.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.TbUserDao;
import com.shop.domain.TbUser;
import com.shop.domain.TbUserExample;
import com.shop.mapper.TbUserMapper;

@Repository("tbUserDao")
public class TbUserDaoBean implements TbUserDao{

	@Autowired
	private TbUserMapper tbUserMapper;
	@Override
	public List<TbUser> getTbUser() {
		System.out.println("进入TbDao");
		TbUserExample example = new TbUserExample();
		List<TbUser> list = tbUserMapper.selectByExample(example);
		return list;
	}

}
