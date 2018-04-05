package com.yhc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhc.entity.User;
import com.yhc.pagehelper.Page;
import com.yhc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/main")
	public String main(){
		System.out.println("~~~~~~~~~~~~~~~~进入主页");
		return "user_login";		
	}
	
	@RequestMapping("/login")
	public String login(User user,HttpSession session){
		if(userService.login(user)!=null){
			session.setAttribute("userName", user.getUserName());
			System.out.println("~~~~~~~~~~~~~~~~登录成功");
			return "forward:/user/findAllUser";	//跳转后可以取得参数
		}
		else{
			System.out.println("~~~~~~~~~~~~~~~~登录失败");
			return "redirect:/index.jsp";	//跳转后无法取得参数
		}
	}
	
	@RequestMapping("/findAllUser")
	public String findAllUser(@RequestParam("pageNum")int pageNum, Model model) {
		System.out.println("~~~~~~~~~~~~~查询allUser开始");	
		
		Page page = new Page();
		page.setPageNum(pageNum);
		List<User> allUser = userService.findAllUser(page);
		System.out.println(page.getTotalPage());
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("allUser", allUser);
		System.out.println("~~~~~~~~~~~~~查询allUser成功");
		return "user_list";
	}

}
