package cn.bdqn.sys.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsFunction;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsFunctionService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Controller
public class AsFunctionController {
	@Autowired
	private IAsFunctionService iAsFunctionService ;
	@Autowired
	private IAsAccountService iAsAccountService ;
	
	@RequestMapping("/getlist")
	public String getAllIAsFunction(HttpSession session){
	List<AsFunction>functionName=iAsFunctionService.getAllAsFunction();
		session.setAttribute("functionName", functionName);
		int i=0;
		for (AsFunction asFunction : functionName) {
			i++;
			long parentId=asFunction.getId();
			List<AsFunction>subFunctions=iAsFunctionService.getAllAsFunctions(parentId);
			session.setAttribute("subFunctions"+i, subFunctions);
			}
	    long userid=(long) session.getAttribute("userID");
	    AsAccount asAccount	=iAsAccountService.getAsAccount(userid);
		session.setAttribute("asAccount", asAccount);
	    return "redirect:/sys/as-account/showAccount";
	}
	
	public List<AsFunction> functionList(){
		List<AsFunction> functionList = iAsFunctionService.list();
		return functionList;
	}
}
