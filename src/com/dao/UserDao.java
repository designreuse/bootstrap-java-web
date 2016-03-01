package com.dao;

import com.beans.User;

public interface UserDao{
	//用户注册
	public boolean register(User user);
	//用户登录
	public boolean login(User user);
}
