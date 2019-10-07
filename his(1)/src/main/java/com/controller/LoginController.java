package com.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.bean.User;
import com.model.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("userlogin")
	@ResponseBody
	public String login(User user,HttpSession session){
		User u = userService.selectUser(user);
		if (u == null) {
			return "{\"result\":\"登录失败\"}";
		}else{
			session.setAttribute("loginUser", u);
			return "{\"result\":\""+u.getUsername()+"\"}";
		}
	}
}
