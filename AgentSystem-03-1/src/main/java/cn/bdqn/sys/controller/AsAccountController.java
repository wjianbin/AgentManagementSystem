package cn.bdqn.sys.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.service.IAsAccountService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/sys/as-account")
public class AsAccountController {
	@Autowired
	private IAsAccountService iAsAccountService ;
	@PostMapping("/getAsAccount")
    public void getAsAccount(HttpSession session) {
		long userid=(long) session.getAttribute("userID");
		AsAccount asAccount	=iAsAccountService.getAsAccount(userid);
    }
	
	@RequestMapping("/showAccount")
	public String showAcount(HttpSession session) {
		long userId=(long) session.getAttribute("userID");
		AsAccount AsAccount= iAsAccountService.showUserAccount(userId);
		session.setAttribute("account", AsAccount);
		return "main";
	}
}
