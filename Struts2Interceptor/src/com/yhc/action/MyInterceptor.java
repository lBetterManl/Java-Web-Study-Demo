package com.yhc.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//��ȡActionʵ��
		Object object =ai.getAction();
		if(object == null){
			if(object instanceof PublicAction){
				PublicAction ac =(PublicAction)object;
				//��ȡ�û��ύ����������
				String content =ac.getContent();
				//�ж��û��ύ�����������Ƿ���Ҫ���˵�����
				if(content.contains("����"))
				{
					//��"ϲ��"����Ҫ���˵�"����"
					content =content.replaceAll("����", "ϲ��");
					//��������������������ΪAction����������
					ac.setContent(content);
				}
				//���󲻿գ�����ִ��
				return ai.invoke();	
			}else{
				//����Action�е�LOGIN�߼���ͼ�ַ���
				return Action.LOGIN; 
			}
		}
		return Action.LOGIN; 
	}	
}
