package cn.bdqn.sys.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsKeywords;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsKeywordsService;
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
public class AsKeywordsController {
	@Autowired
	private IAsKeywordsService asKeywordsService;
	@Autowired
	private IAsKeywordsService keywordsService;
	@Autowired
	private IAsAccountService accountService;
	@Autowired
	private IAsSystemconfigService iAsSystemconfigService;
	@GetMapping("/keyword.action")
	  public String keyword() {
		  return "keyword";
	  }
	
	@RequestMapping("/xufei.action")
	public String xufei(long id, HttpServletRequest req, HttpSession session) {

		AsUser user = (AsUser) session.getAttribute("user");
		AsAccount userAccount = accountService.showUserAccount(user.getId());
		req.setAttribute("account", userAccount);
		
		AsKeywords keyword = asKeywordsService.getById(id);
		req.setAttribute("keyword", keyword);

		List<AsSystemconfig> sys = iAsSystemconfigService.list();
		List<AsSystemconfig> list = new ArrayList<AsSystemconfig>();
		for (int i = 0; i < sys.size(); i++) {
			if (sys.get(i).getConfigType() == 2) {
				list.add(sys.get(i));
			}
		}
		req.setAttribute("configTypeName", list);	
		return "xufei";
	}
	@RequestMapping("/checkkeyword.action")
	public String checkkeyword() {
		
		return "redirect:checkkeywords";
		
	}
	@RequestMapping("/checkkeywords")
	public String checkkeywordByName(String keywords, HttpServletRequest req, Page<AsKeywords> page1) {
		IPage<AsKeywords> page = asKeywordsService.FuzzySearchAsKeywordsList(keywords, page1);
		System.out.println(page);
		req.setAttribute("page", page);
		req.setAttribute("pageCount", page.getPages());
		req.setAttribute("oldkeywords", keywords);
		return "checkkeyword";
	}


	@RequestMapping("/updatekeyword")
	@ResponseBody
	public String updatekeywordOnCheckStatus(AsKeywords keywords) {

		boolean flag = asKeywordsService.updatekeywordOnCheckStatus(keywords);
		if (flag) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("/jisuan")
	@ResponseBody
	public String AutoCalculatedPrice(String p) {
		try {
			int sertype = Integer.parseInt(p.split("-")[0]);
			int year = Integer.parseInt(p.split("-")[1]);
			Integer total = sertype * year;
			return String.valueOf(total);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception";
		}
	}

	@RequestMapping("/keywordsxufei")
	@ResponseBody
	public String keywordsxufeiByKeywordsId(String p, long id, HttpSession session) {
		int sertype = Integer.parseInt(p.split("-")[0]);
		int year = Integer.parseInt(p.split("-")[1]);
		Integer total = sertype * year;

		AsUser user = (AsUser) session.getAttribute("user");
		AsAccount userAccount = accountService.showUserAccount(user.getId());

		if (userAccount.getMoney() < total) {
			return "nomoney";
		}
		AsKeywords keyword = asKeywordsService.getById(id);

		boolean flag = asKeywordsService.KeywordsRenew(user.getId(), total, id, year, sertype);
		if (flag) {
			AsAccount userAcc= accountService.showUserAccount(user.getId());
			return String.valueOf(userAcc.getMoney());
		}
		return "exception";
	}

	
	
	 @RequestMapping("/valikey.action")
	    @ResponseBody
	    public Object checkKeyWords(String keywords) {  
	    	boolean flag = keywordsService.checkKeyWords(keywords);
	    	if(flag) {
	    		 return "success";
	    	}
	        return "failed";	
	    }
	    @ResponseBody
	    @RequestMapping("/submitkeyword.action")
	    public Object applyKeywords(String p,String keywords,String customName,Long customId,HttpSession session,AsKeywords keyword) {	
	    	AsUser user = (AsUser) session.getAttribute("user");
	    	AsAccount account = accountService.showUserAccount(user.getId());
	    	double money = account.getMoney();
	    	double price = keywordsService.getPrice(p);
	    	session.setAttribute("price", price);
	    	String[] prames = StringUtils.split(p,"-");
			String serviceTypeId = prames[0];
			String serviceYears = prames[1];
	    	if(money>price) {
	    		Long AgentId = user.getId();
	    		keyword.setKeywords(keywords);
	    		keyword.setAgentId(AgentId);
	    		keyword.setAgentName(user.getUserName());
	    		keyword.setCustomId(customId);
	    		keyword.setCustomName(customName);
	        	keyword.setPrice(price);
	        	keyword.setIsUse(1);
	        	keyword.setIsPass(2);
//	        	keyword.setRegDatetime(null);
//            	keyword.setRegPassDatetime(keyword.getRegDatetime().plusYears(Integer.valueOf(serviceYears)));
	        	if(serviceTypeId.equals("1")) {
	        		keyword.setPreRegFrozenMoney(26000.00);     		
	        	}else if(serviceTypeId.equals("2")) {
	        		keyword.setPreRegFrozenMoney(18000.00); 
	        	}
	        	keyword.setServiceYears(Integer.valueOf(serviceYears));
	        	keywordsService.applyKeyWords(keyword);
	    		
	    		return "success";
	    		
	    	}else {
	    		return "nomoney";    	
	    		
	    	}
	    }
	    @ResponseBody
	    @RequestMapping("/account.action")
	    public Object getMoneyBalance(AsKeywords keywords,HttpSession session) {
	    	AsUser user = (AsUser) session.getAttribute("user");
	    	AsAccount account = accountService.showUserAccount(user.getId());
	    	double price = (double) session.getAttribute("price");
	    	double money = account.getMoney();
	    	double moneyBalance = money - price;
	    	return moneyBalance;
	    }
	    @ResponseBody
	    @RequestMapping("/jisuan.action")
	    public Object getPrice(String p) {
	    	Object result = keywordsService.getPrice(p);
	    	return result;
	    }
	    @RequestMapping("/keywordmanage.action")
	    public String keywordmanage(HttpServletRequest request,Page<AsKeywords> page,String keywords) {
	    	
	    	IPage<AsKeywords> page1=keywordsService.getpage(page,keywords);
	    	request.setAttribute("page", page);
	    	request.setAttribute("keywords", keywords);
	    	request.setAttribute("pages", page1.getPages());
	    	return "keywordmanage";
	    }
	    @ResponseBody
	    @RequestMapping("/deletekeyword.action")
	    public String delKeywords(Long id) {
	    	boolean flag = keywordsService.delKeywordsById(id);
	    	if(flag) {
	    		return "success";
	    	}
	    	return "failed";
	    }
}
