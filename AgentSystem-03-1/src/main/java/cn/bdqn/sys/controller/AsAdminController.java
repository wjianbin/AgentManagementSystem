package cn.bdqn.sys.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import cn.bdqn.sys.entity.AsRole;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.service.IAsSystemconfigService;
import cn.bdqn.sys.service.IAsUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Controller

public class AsAdminController {
	@Autowired
	private IAsSystemconfigService iAsSystemconfigService ;
	@Autowired
	private AsRoleController asRoleController;
	
	@RequestMapping("/systemconfig")
	public String getsystemconfig(Integer id,HttpServletRequest req) {
	List<AsSystemconfig> systemConfigList= iAsSystemconfigService.getallasSystemconfig(id);
        req.setAttribute("systemConfigList", systemConfigList);
		req.setAttribute("configType", id);
		return "systemconfig";
	}
	@RequestMapping("/premission.action")
	public String premission(Model model) {

		List<AsRole> roleList1 = asRoleController.showList();
		System.out.println(roleList1);
		model.addAttribute("roleList", roleList1);
		return "premission";
	}
	@RequestMapping("/caiwutype.action")
	public String caiwutype() {
		
		return "redirect:/systemconfig?id=1";
		}
	
	@RequestMapping("/servicetype.action")
	public String servicetype() {
		
		return "redirect:/systemconfig?id=2";
		}
	
	@RequestMapping("/serviceyears.action")
	public String serviceyears() {
		
		return "redirect:/systemconfig?id=3";
		}
	
	@RequestMapping("/appurl.action")
	public String appurl() {
		
		return "redirect:/systemconfig?id=4";
		}
	@RequestMapping("/customtype.action")
	public String customtype() {
		
		return "redirect:/systemconfig?id=5";
		}
	@RequestMapping("/cardtype.action")
	public String cardtype() {
		
		return "redirect:/systemconfig?id=6";
		}
	@RequestMapping("/youhuitype.action")
	public String youhuitype() {
		
		return "redirect:/systemconfig?id=7";
		}
	
}
