package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.mapper.AsSystemconfigMapper;
import cn.bdqn.sys.mapper.AsUserMapper;
import cn.bdqn.sys.service.IAsSystemconfigService;
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
public class AsSystemconfigServiceImpl extends ServiceImpl<AsSystemconfigMapper, AsSystemconfig> implements IAsSystemconfigService {
	@Autowired
	private AsSystemconfigMapper asSystemconfigMapper;
	@Override
	public List<AsSystemconfig> getallasSystemconfig(Integer id) {
		QueryWrapper<AsSystemconfig> wrapper=new QueryWrapper<AsSystemconfig>();
		wrapper.eq("configType", id);
		return asSystemconfigMapper.selectList(wrapper);
	}
	@Override
	public AsSystemconfig getisPeatConfig(AsSystemconfig asSystemconfig) {
		QueryWrapper<AsSystemconfig> wrapper=new QueryWrapper<AsSystemconfig>();
		wrapper.eq("configType", asSystemconfig.getConfigType());
		wrapper.eq("configTypeName", asSystemconfig.getConfigTypeName());
		return asSystemconfigMapper.selectOne(wrapper);
	}
	@Override
	public List<AsSystemconfig> getSystemconfig() {
		QueryWrapper<AsSystemconfig> wrapper=new QueryWrapper<AsSystemconfig>();
		wrapper.eq("configType", 6);
		return asSystemconfigMapper.selectList(wrapper);
	}
	@Override
	public List<AsSystemconfig> AsCustomsList() {
		QueryWrapper<AsSystemconfig> wrapper=new QueryWrapper<AsSystemconfig>();
		wrapper.eq("configType", 5);
		return asSystemconfigMapper.selectList(wrapper);
	}
	
	
	@Override
	public List<AsSystemconfig> getSystemconfigByconfigType(Integer configTypeId) {
		QueryWrapper queryWarpper = new QueryWrapper();
		queryWarpper.eq("configType", 1);
		List list = asSystemconfigMapper.selectList(queryWarpper);
		return list;
	}

}
