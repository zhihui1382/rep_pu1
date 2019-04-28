package com.tooltar.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.tooltar.bean.ResultRoleBean;
import com.tooltar.bean.RoleBean;
import com.tooltar.bean.UserBean;

public interface RoleControllerI {
	//��ת��ɫ����ҳ��
	public ModelAndView toRole(HttpServletRequest request, HttpServletResponse response);
	//��ӽ�ɫ
	//���ܼ����ݿ�˵��
	//��ӽ�ɫ����Ϊ����ɫ����Ȩ��
	//���ȶ���Ȩ�ޱ�id������message ������
	//��ӽ�ɫʱ����ҳ����ʾȨ�ޱ�������Ϣ����ѡ�����û�ѡ��
	//�����ɫ������ѡ��
	//һ����id������~~~�˴�����Ȩ�ޱ������������ֶΣ��Բ�ͬ�ֶθ�ֵ0or1��0��Ȩ�ޣ�1��Ȩ�ޣ�
	//������id������Ȩ�ޣ����ֶ�ͨ��,���ŷָ�Ȩ�ޱ�id�����а�����id��Ϊ��Ȩ�޲�������
	public Integer addRole(RoleBean role);
	//ɾ����ɫ
	public Integer delRole(Integer id);
	
	//������һЩ���ܺ�ע������
	/*
	 * ����һ������������ʱΪ�����������󣬾���ʵ�ֲ�дֱ������ͨ�����ɣ��Ա����ʹ��
	 * 
	 * ���й�����junit���Բ��������Դ���
	 * 
	 * ����ȥʵ��ҳ���мǣ�
	 * 
	 * log and role �������ӿ��Ѿ��Թ��ܽ��г���˵�����ο������ĵ���ɹ��ܣ��в�������ϵ�ң�
	 * 
	 * ��½ע���޸������ȡ��֤���δ��ɹ���������������~
	 */
	
	//�������ɫ��Ȩ������
	public Integer updRole(RoleBean role);
	
	//�����������ѯ
	public List<ResultRoleBean> selRole(RoleBean role,UserBean user);
		
}
