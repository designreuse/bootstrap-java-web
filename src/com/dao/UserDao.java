package com.dao;

import com.beans.User;

public interface UserDao{
	//�û�ע��
	public boolean register(User user);
	//�û���¼
	public boolean login(User user);
}
