package com.tooltar.controller.web;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.util.Page;

public interface LogControllerI {
	//��ת��־ҳ��
	//��־����չʾ����ϸ���ݲο�����˵��
	//���ж���ҵ���־ò�ӿڲ�ʵ��
	//˵��
	//log���ݿ�����Ϊidֵ�������û�id��ʱ�䣬����˵�������½���������ܲ����������û���log���ȡ��Ϣ
	//��Ҫ����ҳ��ѯ����
	//ÿҳ��ʾ15�����ݶ�
	
	public ModelAndView toLog(Page page);
}
