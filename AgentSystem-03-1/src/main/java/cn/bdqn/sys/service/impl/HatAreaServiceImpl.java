package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.entity.HatArea;
import cn.bdqn.sys.mapper.AsUserMapper;
import cn.bdqn.sys.mapper.HatAreaMapper;
import cn.bdqn.sys.service.IHatAreaService;
import cn.bdqn.utils.MD5;

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
public class HatAreaServiceImpl extends ServiceImpl<HatAreaMapper, HatArea> implements IHatAreaService {
	@Autowired
	private HatAreaMapper hatAreaMapper;
	@Override
	public HatArea getHatArea(String aid) {
    QueryWrapper<HatArea> wrapper=new QueryWrapper<HatArea>();
	    wrapper.eq("areaID", aid);
	    return hatAreaMapper.selectOne(wrapper);
	}
	@Override
	public List<HatArea> AreaList(String cid) {
		  QueryWrapper<HatArea> wrapper=new QueryWrapper<HatArea>();
		  System.out.println("&&&"+cid);
		    wrapper.eq("father", cid);
		    return hatAreaMapper.selectList(wrapper);
	}

}
