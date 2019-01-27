package cn.bdqn.sys.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsAccountdetailService;
import cn.bdqn.sys.service.IAsRoleService;
import cn.bdqn.sys.service.IAsSystemconfigService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */

@Controller
public class AsAccountdetailController {
	@Autowired
	private IAsAccountdetailService adetailService;
	 @Autowired
	    private IAsSystemconfigService systemconfigService;
	@RequestMapping("/accountdetail.action")
	public String showUserAccount(HttpSession session,HttpServletRequest request, Page page1) {
		AsUser user=(AsUser) session.getAttribute("user");
		IPage page = page1;
		page = adetailService.getasAccountdetail(page1, user.getId());
		request.setAttribute("page", page);
		request.setAttribute("pages",page.getPages());
		return "accountdetail";
	}
	
	
	@RequestMapping("/yfk.action")
	public String getykf(HttpServletRequest request, HttpSession session, Page page, Long detailType, String startTime,
			String endTime) {
		AsUser user = (AsUser) session.getAttribute("user");

		page = (Page) adetailService.getasAccountdetail(page, user.getId(), detailType, startTime, endTime);
		List list = systemconfigService.getSystemconfigByconfigType(1);
		request.setAttribute("accountConfigList", list);
		request.setAttribute("page", page);
		request.setAttribute("pages", page.getPages());
		request.setAttribute("detailType", detailType);
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		return "yfk";
	}
}
