package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.beans.Interview;
import com.dao.impl.InterviewDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class InterviewAction extends ActionSupport{
	private Interview interview;
	private InterviewDaoImpl interviewMannager;
	private List<Interview> infoList;
	private boolean interCondition;
	
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	
	public boolean isInterCondition() {
		return interCondition;
	}
	public void setInterCondition(boolean interCondition) {
		this.interCondition = interCondition;
	}
	
	public void interviewActionInit() {
		this.interviewMannager = new InterviewDaoImpl();
	}

	public String Create() throws IOException {
		interviewActionInit();
		JSONObject json = new JSONObject();
		if(interviewMannager.createInterview(interview)) {
			json.put("status", "success");
		} else {
			json.put("status", "failed");
		}
		
		ServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json.toString());
		return null;
	}
	
	public String Find() throws IOException {
		interviewActionInit();
		JSONArray json = new JSONArray();
		
		infoList = interviewMannager.findInterview(interview, interCondition);
		
		for(Interview tinte: infoList) {
			JSONObject js = new JSONObject();
			js.put("interview_id", tinte.getInterview_id());
			js.put("interview_title", tinte.getInterview_title());
			js.put("interview_desc", tinte.getInterview_desc());
			js.put("interview_time", tinte.getInterview_time().toString());
			js.put("interview_user", tinte.getInterview_user());
			js.put("interview_place", tinte.getInterview_place());
			js.put("interview_phone", tinte.getInterview_phone());
			json.add(js);
		}
		/*
		 * JSONObject jso = new JSONObject();
		if(infoList.isEmpty()) {
			jso.put("status", "success");
		} else {
			jso.put("status", "failed");
		}*/
		ServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json.toString());
		return null;
	}
	
	public String Update() throws IOException {
		interviewActionInit();
		JSONObject json = new JSONObject();
		if(interviewMannager.updateInterview(interview)) {
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
