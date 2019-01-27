package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.HatArea;
import cn.bdqn.sys.entity.HatCity;
import cn.bdqn.sys.mapper.HatCityMapper;
import cn.bdqn.sys.service.IHatCityService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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
public class HatCityServiceImpl extends ServiceImpl<HatCityMapper, HatCity> implements IHatCityService {
	@Autowired
private HatCityMapper hatCityMapper;
	@Override
	public HatCity get(String cid) {
		 QueryWrapper<HatCity> wrapper=new QueryWrapper<HatCity>();
		    wrapper.eq("cityID", cid);
		    return hatCityMapper.selectOne(wrapper);
	}
	@Override
	public List<HatCity> getHatCityList(String pid) {
		System.out.println("66666666666666"+pid);
		 QueryWrapper<HatCity> wrapper=new QueryWrapper<HatCity>();
	     wrapper.eq("father", pid);
		  return hatCityMapper.selectList(wrapper);
	}
	

}
