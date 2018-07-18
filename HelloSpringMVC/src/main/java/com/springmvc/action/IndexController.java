package com.springmvc.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.springmvc.model.User;
import com.springmvc.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller	//将一个POJO类声明为处理器
@SessionAttributes("loginUser")	//用于声明Session级别存储的属性，放置在处理器类上，通常列出模型属性对应的名称
public class IndexController {//在请求是/login的时候，将ModelMap中的属性放入Session中，实现多窗口共享数据
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		User u = userService.login(username, password);
		model.addAttribute("loginUser", u);			//向ModelMap视图中添加一个Session级别存储的属性
		return "redirect:/user/users";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/login";
	}
}
