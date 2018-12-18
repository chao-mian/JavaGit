package com.shop.dao.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.shop.dao.UserDao;
import com.shop.domain.User;
import com.shop.domain.UserExample;
import com.shop.domain.UserExample.Criteria;
import com.shop.mapper.UserMapper;


@Repository("userDao")
public class UserDaoBean implements UserDao {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getLoginUser(User user) {
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> list = userMapper.selectByExample(example);
		return list.get(0);
		
	}

	@Override
	public boolean saveNewUser(User user) {
		int i = userMapper.insert(user);
		if(i==1)return true;
		else return false;
	}

	@Override
	public User getUserByUserName(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<User> list = userMapper.selectByExample(example);
		return list.get(0);
	}

}
