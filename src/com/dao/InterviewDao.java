package com.dao;

import java.util.List;

import com.beans.Interview;

public interface InterviewDao {
	//创造面试
	public boolean createInterview(Interview interview);
	//修改面试
	public boolean updateInterview(Interview interview);
	//删除面试
	public boolean deleteInterview(Interview interview);
	//查询面试
	public List<Interview> findInterview(Interview interview, boolean condition);
	
}
