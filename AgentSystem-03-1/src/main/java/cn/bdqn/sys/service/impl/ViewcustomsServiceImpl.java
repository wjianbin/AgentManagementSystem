package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsContacts;
import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.Viewcustoms;
import cn.bdqn.sys.entity.contactList;
import cn.bdqn.sys.mapper.ViewcustomsMapper;
import cn.bdqn.sys.service.IAsContactsService;
import cn.bdqn.sys.service.IAsCustomsService;
import cn.bdqn.sys.service.IViewcustomsService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author zhou
 * @since 2019-01-05
 */
@Service
public class ViewcustomsServiceImpl extends ServiceImpl<ViewcustomsMapper, Viewcustoms> implements IViewcustomsService {
     @Autowired
     private ViewcustomsMapper ViewcustomsMapper;
     @Autowired
     private IAsCustomsService iAsCustomsService;
     @Autowired
     private IAsContactsService iAsContactsService;
    
	@Override
	public void viewcustom(HttpServletRequest rquest, Integer id, String custms, String contactList) {
		QueryWrapper<Viewcustoms> queryWrapper=new QueryWrapper();
		queryWrapper.eq("id", id);
		List<Viewcustoms> Viewcustoms=ViewcustomsMapper.selectList(queryWrapper);
		rquest.setAttribute(contactList, Viewcustoms);
		
		if(Viewcustoms.size()>0) {
			rquest.setAttribute(custms, Viewcustoms.get(0));
		}
		
	}
	
	@Override
	public String update(AsCustoms asCustoms, contactList contactList) {
		boolean flag=iAsCustomsService.saveOrUpdate(asCustoms);
		List<AsContacts> list=iAsContactsService.list();
		
		if(null!=contactList.getContactList()) {
			for(int i=0;i<contactList.getContactList().size();i++) {
				contactList.getContactList().get(i).setCustomId(asCustoms.getId());
				
			}
		flag=iAsContactsService.saveOrUpdateBatch(contactList.getContactList());
		}
		if(flag) {
				return "redirect:/customlist";
	    }else {
				return null;
		}
	}
	@Override
	public void provinceList(HttpServletRequest  request) {
		 iAsCustomsService.getprovince(request);
		
	}
	@Override
	public List cityList(Integer father) {
		// TODO Auto-generated method stub
		
		return iAsCustomsService.getcity(father);
	}
	@Override
	public List areaList(Integer father) {
		// TODO Auto-generated method stub
		return iAsCustomsService.getarea(father);
	}
}
