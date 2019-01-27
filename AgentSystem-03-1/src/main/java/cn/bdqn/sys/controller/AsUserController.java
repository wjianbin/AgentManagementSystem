package cn.bdqn.sys.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.entity.AsRole;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsAccountdetailService;
import cn.bdqn.sys.service.IAsKeywordsService;
import cn.bdqn.sys.service.IAsRoleService;
import cn.bdqn.sys.service.IAsSystemconfigService;
import cn.bdqn.sys.service.IAsUserService;
import cn.bdqn.sys.vo.AsAccountAll;
import cn.bdqn.sys.vo.AsAccountdetailAll;

import cn.bdqn.sys.vo.procteds;
import cn.bdqn.utils.ExcelController;
import cn.bdqn.utils.MD5;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Controller

public class AsUserController {
	@Autowired
	private IAsUserService iAsUserService ;
	@Autowired
	private IAsAccountService iAsAccountService ;
	@Autowired
	private IAsAccountdetailService adetailService;
	@Autowired
	private IAsKeywordsService iAsKeywordsService;
	@Autowired
	private IAsUserService userService;
	@Autowired
	private IAsRoleService roleService;
	@Autowired
	private IAsSystemconfigService iAsSystemconfigService;
	@Autowired
	private ExcelController ExcelController;
	@RequestMapping("/updatapassword")
	@ResponseBody
	public String updatapassword(HttpSession session,String userName,String userPassword) {
        	
		AsUser user=(AsUser) session.getAttribute("user");
		String p=MD5.MD5Encode(userPassword);
		if (user.getUserPassword().equals(p)) {
			user.setUserPassword(MD5.MD5Encode(userName));
			iAsUserService.updateById(user);
			return "success";
		}else {
			return "oldpwddif";
		}
	}
	
	
	@RequestMapping("/main.action")
	public String main() {
		
		
		return "viewcustom";
		}
	@RequestMapping("/report.action")
	public String report() {
		
		
		return "report";
		}
	@RequestMapping("/caiwu.action")
	public String caiwu(HttpServletRequest req) {
		
		List<AsSystemconfig> sys = iAsSystemconfigService.list();
		List<AsSystemconfig> list = new ArrayList<AsSystemconfig>();
		for (int i = 0; i < sys.size(); i++) {
			if (sys.get(i).getConfigType() == 1) {
				list.add(sys.get(i));
			}
		}
		
		req.setAttribute("configTypeName", list);
		
		return "caiwu";
		}
	@RequestMapping("/opeaccount")
	@ResponseBody
	public String addAccountdetail(AsAccountdetail accountdetail,HttpSession session) {
		System.out.println(accountdetail);
		boolean flag=adetailService.addAccountdetail(accountdetail);
		if(flag) {
			return "success";
		}
		return null;
	
	}
	   @ResponseBody
		@RequestMapping("/searchuser")
	  
		public List<AsUser> FuzzySearchUserByUserCode(HttpServletRequest sr,AsUser use) {
		  
			List<AsUser> user = userService.FuzzySearchUserByUserCode(use.getUserCode());
			sr.setAttribute("user", user);
			return user;
		}
	@RequestMapping("/userlist.action")
	
	public String userlist(HttpServletRequest req) {
		List<AsRole> roleList = roleService.list();
		req.setAttribute("roleList", roleList);
		
		
		return "/userlist";
		}
	@RequestMapping("/reportcheck.action")
	public String reportcheck(HttpServletRequest req) {
		String pid=req.getParameter("reportType");
		String startTime=req.getParameter("startTime");
		String endTime=req.getParameter("endTime");
		int reportType=Integer.valueOf(pid);
		if(reportType==1) {
			List<AsAccountAll> accountList=iAsAccountService.getAsAccountList();
			req.setAttribute("accountList", accountList);
			}else if(reportType==2||reportType==3){
			List<AsAccountdetailAll> accountDetailList=adetailService.getasAccountdetailList( startTime, endTime );
		    req.setAttribute("accountDetailList", accountDetailList);
		
		}else if(reportType==4) {
			List<procteds>reportProductList=iAsKeywordsService.priductsList();
			System.out.println("&&&"+reportProductList);
			req.setAttribute("reportProductList", reportProductList);
		}
		req.setAttribute("reportType", reportType);
		return "/report";
		}
	


 
 
@RequestMapping("/reportYfkpdf.action")
public void reportYfkpdf(HttpServletResponse response,String reportType) throws NumberFormatException, Exception {
	 ExcelController.getUser(response, Integer.valueOf(reportType));
	
}


 
@RequestMapping("/reportYfke.action")
public void reportYfke(HttpServletRequest request,HttpServletResponse response,String reportType) throws NumberFormatException, Exception {
	ExcelController.downloadPdf(request, response, Integer.valueOf(reportType));
	
}
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(HttpSession session, AsUser user) {
		System.out.println("1111111111"+user.getUserName());
		int flag = userService.addUser(session, user);
		System.out.println(flag);
		if (flag == 1) {
			return "success";
		} else {
			return "repeat";
		}
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(HttpSession session, AsUser user) {
		System.out.println("222222222"+user.getUserName());
		int flag = userService.updateUser(session, user);
		System.out.println(flag);
		if (flag == 1) {
			return "success";
		} else {
			return "repeat";
		}
	}
	
	@RequestMapping("/delUser")
	@ResponseBody
	public String delUser(Long id) {
		System.out.println("&&&&&&&&&&"+id);
		int flag = userService.delUser(id);
		System.out.println(flag);
		if (flag == 1) {
			return "success";
		} else {
			return "repeat";
		}
	}
}
