package com.beans;

import java.sql.Timestamp;

public class Interview {
	private int Interview_id = -1;
	private String Interview_title;
	private String Interview_desc;
	private Timestamp Interview_time;
	private String Interview_user;
	private String Interview_phone;
	private String interview_place;
	
	public String getInterview_title() {
		return Interview_title;
	}
	public void setInterview_title(String interview_title) {
		Interview_title = interview_title;
	}
	public String getInterview_desc() {
		return Interview_desc;
	}
	public void setInterview_desc(String interview_desc) {
		Interview_desc = interview_desc;
	}
	public Timestamp getInterview_time() {
		return Interview_time;
	}
	public void setInterview_time(Timestamp interview_time) {
		Interview_time = interview_time;
	}
	public String getInterview_user() {
		return Interview_user;
	}
	public void setInterview_user(String interview_user) {
		Interview_user = interview_user;
	}
	public String getInterview_phone() {
		return Interview_phone;
	}
	public void setInterview_phone(String interview_phone) {
		Interview_phone = interview_phone;
	}
	public int getInterview_id() {
		return Interview_id;
	}
	public void setInterview_id(int interview_id) {
		Interview_id = interview_id;
	}
	public String getInterview_place() {
		return interview_place;
	}
	public void setInterview_place(String interview_place) {
		this.interview_place = interview_place;
	}
	
}
