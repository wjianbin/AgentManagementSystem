package cn.bdqn.sys.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bdqn.sys.entity.AsFunction;
import cn.bdqn.sys.entity.AsRolePremission;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.service.IAsRolePremissionService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Controller

public class AsRolePremissionController {
	@Autowired
	private AsFunctionController AsFunctionController;
	
	@Autowired
	private IAsRolePremissionService IAsRolePremissionService;

	@RequestMapping("/funclist")
	public String funclist(HttpServletRequest request, long roleId) {
		List<AsFunction> funcList = AsFunctionController.functionList();
		List<AsRolePremission> rolrPrem = this.showRolePremissionById(roleId);
		System.out.println("^^^^^"+funcList);
		System.out.println("SSSSS"+rolrPrem);
		request.setAttribute("funcList", funcList);
		request.setAttribute("RolePremission", rolrPrem);
		request.setAttribute("roleId", roleId);
		return "functionlist";
	}

	@ResponseBody
	@RequestMapping("/saverolefunc")
	public String saveRoleFuntion(String[] checkFuncList, String roleId, HttpSession session) {
		AsUser user = (AsUser) session.getAttribute("user");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+roleId);
		long roleId1 = Integer.valueOf(roleId);
		boolean flag = this.AddOrDelete(checkFuncList, roleId1, user);
		System.out.println("$$$");
		System.out.println(flag);
		if (flag) {
			return "success";
		}
		return "error";
	}

	public List<AsRolePremission> showRolePremissionById(long roleId) {
		return IAsRolePremissionService.showRolePremissionById(roleId);
		
	}

	public boolean AddOrDelete(String[] list, long roleId, AsUser user) {
		return IAsRolePremissionService.AddOrDelete(list, roleId, user);

	}
}
