package com.yhc.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//获取Action实例
		Object object =ai.getAction();
		if(object == null){
			if(object instanceof PublicAction){
				PublicAction ac =(PublicAction)object;
				//获取用户提交的评论内容
				String content =ac.getContent();
				//判断用户提交的评论内容是否有要过滤的内容
				if(content.contains("讨厌"))
				{
					//以"喜欢"代替要过滤的"讨厌"
					content =content.replaceAll("讨厌", "喜欢");
					//把替代后的评论内容设置为Action的评论内容
					ac.setContent(content);
				}
				//对象不空，继续执行
				return ai.invoke();	
			}else{
				//返回Action中的LOGIN逻辑视图字符串
				return Action.LOGIN; 
			}
		}
		return Action.LOGIN; 
	}	
}
