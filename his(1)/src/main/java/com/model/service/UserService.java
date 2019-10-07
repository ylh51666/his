package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.bean.User;
import com.model.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User selectUser(User user){
		return userMapper.selectUser(user);
	}
}
