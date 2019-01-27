package cn.bdqn.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bdqn.sys.entity.AsSystemconfig;
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
@RequestMapping
public class AsSiteconfigController {
@Autowired
private IAsSystemconfigService iAsSystemconfigService;
    @ResponseBody
	@RequestMapping("/modifyconfig.action")
	public String modifyconfig(AsSystemconfig systemConfig) {
		System.out.println("&&&&&&&77");
		boolean flag = iAsSystemconfigService.updateById(systemConfig);
		if (flag) {
			return "success";
		} else {
			return "repeat";
		}
		}
	@ResponseBody
	@RequestMapping("/addconfig.action")
	public String addconfig(AsSystemconfig systemConfig) {
		System.out.println("%%%%%%%%%");
		boolean flag = iAsSystemconfigService.save(systemConfig);
		if (flag) {
			return "success";
		} else {
			return "repeat";
		}
		}
	@ResponseBody
	@RequestMapping("/deleteconfig.action")
	public String deleteconfig(Long id) {
		boolean flag = iAsSystemconfigService.removeById(id);
		if (flag) {
			return "success";
		} else {
			return "repeat";
		}
		}
	@ResponseBody
	@RequestMapping("/isPeatConfig.action")
	public String isPeatConfig(AsSystemconfig systemConfig) {
		System.out.println("@@@@@@@");
		AsSystemconfig as=iAsSystemconfigService.getisPeatConfig(systemConfig);
		if(null!=as&& systemConfig.getId()!=as.getId()) {
			return "peat";
	  }else {
		    return "nopeat";
	    }
		}
}
