package cn.bdqn.sys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsUserService;




@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private IAsUserService iAsUserService ;
	@Autowired
	private IAsAccountService iAsAccountService ;
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/login")
	public String dologin(String userCode,String userPassword ,HttpSession session) {
	AsUser user=iAsUserService.login(userCode, userPassword);
		if (user!=null) {
		    session.setAttribute("user", user);
			session.setAttribute("userID", user.getId());
			return "redirect:/getlist";
		}else {
			return "login";
		}
	}
	@RequestMapping("/outlogin")
	public String outlogin(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "login";
		
	}
}
