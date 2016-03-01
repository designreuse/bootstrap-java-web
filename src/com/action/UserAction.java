package com.action;

import java.io.IOException;

import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.beans.User;
import com.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private User user;
	private UserDaoImpl userManager;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void userActionInit() {
		this.userManager = new UserDaoImpl();
	}
	
	public String Login() throws IOException {
		userActionInit();
		JSONObject json = new JSONObject();
		if(userManager.login(user)) {
			json.put("status", "success");
		} else {
			json.put("status", "failed");
		}
		
		ServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json.toString());
		return null;
	}

	public String Register() throws IOException {
		userActionInit();
		JSONObject json = new JSONObject();
		if(userManager.register(user)) {
			json.put("status", "success");
		} else {
			json.put("status", "failed");
		}
		ServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json.toString());
		return null;
	}
}
