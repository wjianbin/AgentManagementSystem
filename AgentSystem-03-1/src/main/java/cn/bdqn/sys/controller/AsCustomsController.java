package cn.bdqn.sys.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.bdqn.sys.entity.AsContacts;
import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.AsKeywords;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.entity.HatArea;
import cn.bdqn.sys.entity.HatCity;
import cn.bdqn.sys.entity.HatProvince;
import cn.bdqn.sys.entity.list;
import cn.bdqn.sys.service.IAsContactsService;
import cn.bdqn.sys.service.IAsCustomsService;
import cn.bdqn.sys.service.IAsKeywordsService;
import cn.bdqn.sys.service.IAsSystemconfigService;
import cn.bdqn.sys.service.IAsUserService;
import cn.bdqn.sys.service.IHatAreaService;
import cn.bdqn.sys.service.IHatCityService;
import cn.bdqn.sys.service.IHatProvinceService;
import cn.bdqn.sys.vo.AsCustomsAll;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */

@Controller
public class AsCustomsController {
	@Autowired
	private IAsCustomsService iAsCustomsService ;
	@Autowired
	private IAsContactsService iAsContactsService;
	@Autowired
	private IAsKeywordsService iAsKeywordsService ;
	@Autowired
	private IHatAreaService iHatAreaService ;
	@Autowired
	private IHatCityService iHatCityService ;
	@Autowired
	private IHatProvinceService iHatProvinceService ;
	@Autowired
	private IAsSystemconfigService iAsSystemconfigService ;
	
	
	@GetMapping("/customlist.action")
	
	
	 public String customlist(HttpServletRequest request, Page page2) {
		String cname=request.getParameter("cname");
		IPage Cuspage = page2;
		Cuspage=iAsCustomsService.getCustomsall(page2, cname);
		request.setAttribute("Cuspage", Cuspage);
		request.setAttribute("pages", Cuspage.getPages());
		return "customlist";
	  }
		@RequestMapping("/myportalmanage.action")
	 public String getcustom(HttpServletRequest req,Integer current,AsCustomsAll a) {
			
			 if (current==null) {
				 current=1;
			}
			
			 IPage<AsCustomsAll> Customspage=iAsCustomsService.getAllcustoms(a, current, 5);
		     req.setAttribute("Customspage", Customspage);
		     req.setAttribute("pageNum", current);
			 req.setAttribute("count", Customspage.getTotal());
			 req.setAttribute("pageCount", Customspage.getPages());
			 return "myportallist";
			  }
	@RequestMapping("/viewportal.action")
	public String checkmyportalmanage(long customId,HttpServletRequest req) {
		List<AsContacts> contactList=iAsContactsService.getAsContacts(customId);
		AsKeywords keywords=iAsKeywordsService.getAsKeywords(customId);
		AsCustoms custom=iAsCustomsService.getAsCustoms(customId);
		req.setAttribute("contactList", contactList);
		req.setAttribute("keywords", keywords);
		req.setAttribute("custom", custom);
	return "viewportal";
	}
	@RequestMapping("/addcustom.action")
	public String addcustom(HttpServletRequest req) {
		List<AsSystemconfig>customTypeList=iAsSystemconfigService.AsCustomsList();
		List<HatProvince> ProvinceList=iHatProvinceService.list();
	    List<AsSystemconfig> cardTypeList=iAsSystemconfigService.getSystemconfig();
		req.setAttribute("customTypeList", customTypeList);
		req.setAttribute("cardTypeList", cardTypeList);
		req.setAttribute("ProvinceList", ProvinceList);
		
		return "addcustom";
		
	}
	
	@RequestMapping("/loadcity.action")
	@ResponseBody
	public List<HatCity> loadcity(String provinceID) {
	List<HatCity> CityList=iHatCityService.getHatCityList(provinceID);

	return CityList;
	}
	
	@RequestMapping("/loadarea.action")
	@ResponseBody
	public List<HatArea>loadarea(String cityID){
		List<HatArea> AreaList=iHatAreaService.AreaList(cityID);
		System.out.println("&&"+AreaList);
		return AreaList;
		
	}
	@RequestMapping("/modifyPortal.action")
	  public String modifyPortal(long customId,HttpServletRequest req) {
		
		List<AsContacts> contactList=iAsContactsService.getAsContacts(customId);
		AsKeywords keywords=iAsKeywordsService.getAsKeywords(customId);
		AsCustoms custom=iAsCustomsService.getAsCustoms(customId);
		req.setAttribute("contactList", contactList);
		req.setAttribute("keywords", keywords);
		req.setAttribute("custom", custom);
		return "modifyportal";
	  }
	
	@RequestMapping("/modifysaveportal.action")
	public String modifysaveportal(AsKeywords keywords) {
		int num=iAsKeywordsService.modifysaveportal(keywords);
	  return "redirect:/myportalmanage.action";
		
	}

	@RequestMapping("/addsavecustom")
	public String addsavecustom(AsCustoms asCustoms,list list,HttpSession session) {
	    AsUser user=(AsUser)session.getAttribute("user");
		asCustoms.setAgentId(user.getId());
		asCustoms.setAgentName(user.getUserName());
		iAsCustomsService.save(asCustoms);
		AsCustoms custom=iAsCustomsService.getcustom();
	    Long id=custom.getId();
	    if(list.getContactList()!=null) {
		for(int i=0;i<list.getContactList().size();i++) {
		list.getContactList().get(i).setCustomId(id);
			
		}
		System.out.println(list.getContactList());
		System.out.println("*******************************");
		iAsContactsService.saveBatch(list.getContactList());
	    }
		return "redirect:/customlist.action";
		
	}
	
	@RequestMapping("/isExitCustomName")
	@ResponseBody
	public String isExitCustomName(String customName) {
	AsCustoms custom=iAsCustomsService.AsCustoms(customName);
	System.out.println("33"+custom);
	if (custom!=null) {
		return "peat";
	}else {
		
		return "nopeat";
	}
}
	
	@RequestMapping("/viewcustom.action")
	  public String viewcustom(long id,HttpServletRequest req) {
	 AsCustoms custom=iAsCustomsService.custom(id);
		req.setAttribute("custom", custom);
	   return "viewcustom";
	  }
	
	@RequestMapping("/modifycustomstatus.action")
	@ResponseBody
	 public String modifycustomstatus(AsCustoms ascustoms) {
		boolean f=iAsCustomsService.updateById(ascustoms);
				if(f) {
				return "success";
			}else {
				return null;
			}
	  }
	
	/*@RequestMapping("/modifycustom.action")
	  public String modifycustom(long id,String cname,HttpServletRequest req) {
		System.out.println("&&&&&&"+id);
		AsCustoms custom =iAsCustomsService.getAsCustoms(id);
		req.setAttribute("custom", custom);
	     return "modifycustom";
	  }
	*/

    @ResponseBody
	@RequestMapping("/searchcustom.action")
    private Object getUserCustoms(HttpSession session,String customName) {
    	AsUser user = (AsUser) session.getAttribute("user");
    	List<AsCustoms> result = iAsCustomsService.getUserCustoms(user.getId(),customName);
    	return result;
    }
}
