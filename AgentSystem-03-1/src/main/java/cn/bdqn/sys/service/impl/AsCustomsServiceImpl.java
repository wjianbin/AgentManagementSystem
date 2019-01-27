package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.entity.HatArea;
import cn.bdqn.sys.entity.HatCity;
import cn.bdqn.sys.mapper.AsCustomsAllMapper;
import cn.bdqn.sys.mapper.AsCustomsMapper;
import cn.bdqn.sys.mapper.AsSystemconfigMapper;
import cn.bdqn.sys.service.IAsCustomsService;
import cn.bdqn.sys.service.IHatAreaService;
import cn.bdqn.sys.service.IHatCityService;
import cn.bdqn.sys.service.IHatProvinceService;
import cn.bdqn.sys.vo.AsCustomsAll;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Service
public class AsCustomsServiceImpl extends ServiceImpl<AsCustomsMapper, AsCustoms> implements IAsCustomsService {
@Autowired
AsCustomsAllMapper asCustomsAllMapper;
@Autowired
IHatProvinceService iHatProvinceService;
@Autowired
IHatCityService iHatCityService;
@Autowired
IHatAreaService iHatAreaService;
@Autowired
private AsCustomsMapper customsMaper;


@Autowired
private AsCustomsMapper asCustomsMapper;
@Autowired
private AsSystemconfigMapper asSystemconfigMapper;

    public IPage<AsCustomsAll> getAllcustoms(AsCustomsAll a,Integer pageNum,Integer pageSize){
    QueryWrapper<AsCustomsAll> wrapper=new QueryWrapper<AsCustomsAll>();
	 Page<AsCustomsAll> p =new Page<AsCustomsAll>(pageNum,pageSize);
     p.setRecords(asCustomsMapper.showAll(p,a));
     if (a.getKeywords()!=null && a.getKeywords()!="") {
    	wrapper.like("keywords", a.getKeywords());
		}
		if (a.getCustomName()!=null && a.getCustomName()!="") {
		wrapper.like("customName", a.getCustomName());
		}
     return asCustomsAllMapper.selectPage(p, wrapper);
}
	@Override
	public AsCustoms getAsCustoms(long customId) {
		QueryWrapper<AsCustoms> wrapper=new QueryWrapper<AsCustoms>();
		wrapper.eq("id", customId);
		return asCustomsMapper.selectOne(wrapper);
	}
	@Override
	public IPage getCustomsall(IPage arg0,String cname) {
		QueryWrapper<AsCustoms> mapper =new QueryWrapper<AsCustoms>();
		if (cname!=null&&cname!="") {
			mapper.like("customName", cname);
		}
		
	   IPage<AsAccountdetail> arg2= asCustomsMapper.selectPage(arg0, mapper);
		return arg2;
	}
	@Override
	public cn.bdqn.sys.entity.AsCustoms AsCustoms(String customName) {
		QueryWrapper<AsCustoms> wrapper=new QueryWrapper<AsCustoms>();
		wrapper.eq("customName", customName);
		return asCustomsMapper.selectOne(wrapper);
	}
	@Override
	public AsCustoms getcustom() {
		QueryWrapper<AsCustoms> wrapper=new QueryWrapper<AsCustoms>();
		
		  wrapper.orderByDesc("id");
		  wrapper.last("limit 1");
		 return asCustomsMapper.selectOne(wrapper);
	}
	@Override
	public AsCustoms custom(long id) {
		QueryWrapper<AsCustoms> wrapper=new QueryWrapper<AsCustoms>();
		 wrapper.eq("id", id);
		 return asCustomsMapper.selectOne(wrapper);
	}
	@Override
		// TODO Auto-generated method stub
	public void addcustom(HttpServletRequest request, int id, String type) {
		QueryWrapper<AsSystemconfig>  warpper=new QueryWrapper<AsSystemconfig>();
    	warpper.eq("configType", id);
    	request.setAttribute(type,asSystemconfigMapper.selectList(warpper));
	}
	@Override
	public void getprovince(HttpServletRequest request) {
		request.setAttribute("provinceList", iHatProvinceService.list());
	}
	public List<HatCity> getcity(Integer id) {
		QueryWrapper<HatCity> warpper=new QueryWrapper<HatCity>();
		if(id!=null) {
			
			warpper.eq("father",id);
		}
		return iHatCityService.list(warpper);
	}
	@Override
	public List<HatArea> getarea(Integer id) {
		QueryWrapper<HatArea> warpper=new QueryWrapper<HatArea>();
		if(id!=null) {
		warpper.eq("father",id);}
		return iHatAreaService.list(warpper);
	}
	
	
	@Override
	public List<AsCustoms> getUserCustoms(Long userId,String customName) {
		QueryWrapper<AsCustoms> queryWrapper=new QueryWrapper<AsCustoms>();
		queryWrapper.eq("agentId", userId);
//		queryWrapper.like("customName", customName);
		return customsMaper.selectList(queryWrapper);
	}
	}
	
	

