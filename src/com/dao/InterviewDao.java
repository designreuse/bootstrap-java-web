package com.dao;

import java.util.List;

import com.beans.Interview;

public interface InterviewDao {
	//��������
	public boolean createInterview(Interview interview);
	//�޸�����
	public boolean updateInterview(Interview interview);
	//ɾ������
	public boolean deleteInterview(Interview interview);
	//��ѯ����
	public List<Interview> findInterview(Interview interview, boolean condition);
	
}
