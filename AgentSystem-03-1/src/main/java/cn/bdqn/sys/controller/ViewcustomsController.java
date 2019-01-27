package cn.bdqn.sys.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.Viewcustoms;
import cn.bdqn.sys.entity.contactList;
import cn.bdqn.sys.service.IAsContactsService;
import cn.bdqn.sys.service.IAsCustomsService;
import cn.bdqn.sys.service.IViewcustomsService;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author zhou
 * @since 2019-01-05
 */
@Controller
public class ViewcustomsController {
    @Autowired
    private IViewcustomsService iViewcustomsService;
	@Autowired
	private IAsCustomsService iAsCustomsService;
	@Autowired
	private IAsContactsService iAsContactsService;
	
	@RequestMapping("/viewcustom")
	public String viewCustom(HttpServletRequest rquest,Integer id) {
		iViewcustomsService.viewcustom(rquest, id, "custom", "contactList");
		      return "viewcustom";
	}
	@RequestMapping("/modifycustom.action")
	public String modifycustom(HttpServletRequest rquest,Integer id,String cname) {
		iViewcustomsService.viewcustom(rquest, id, "custom", "contactList");
		iAsCustomsService.addcustom(rquest,5,"customTypeList");
		iAsCustomsService.addcustom(rquest,6,"cardTypeList");
		iViewcustomsService.provinceList(rquest);
		rquest.setAttribute("cityList", iViewcustomsService.cityList(null)) ;
		rquest.setAttribute("areaList", iViewcustomsService.areaList(null)) ;
		rquest.setAttribute("cname", cname);
	   return "modifycustom";
	}
	@RequestMapping("/modifysavecustom")
	public String modifysavecustom(AsCustoms asCustoms,contactList contactList,String cname) {
		         System.out.println("modifysavecustom");
		             String message=iViewcustomsService.update(asCustoms, contactList);
		             return "redirect:/customlist.action";
	}
	
}
