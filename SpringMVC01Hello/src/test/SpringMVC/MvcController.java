package test.SpringMVC;

//@ReponseBody
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//负责注册一个bean到Spring上下文
@RequestMapping("/mvc")		//注解为控制器指定可以处理那些URL请求
public class MvcController {

	
	//也可直接用HttpServletRequest request获取参数
	//@ModelAttribute("user") User user
	//ModelMap modelMap
	//	
	@RequestMapping("/hello")
	public String hello(String name,Map<String,Object> map) throws Exception {
		System.out.println(name);
		map.put("result", name+"，我爱你!");
		return "hello";
	}
	
	@RequestMapping("/person")
	public String person(Model model,User user){
		System.out.println(user.getName());
		model.addAttribute("result", "添加成功！");
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
