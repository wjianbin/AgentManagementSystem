package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.HatCity;
import cn.bdqn.sys.entity.HatProvince;
import cn.bdqn.sys.mapper.HatProvinceMapper;
import cn.bdqn.sys.service.IHatProvinceService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class HatProvinceServiceImpl extends ServiceImpl<HatProvinceMapper, HatProvince> implements IHatProvinceService {
private HatProvinceMapper hatProvinceMapper;
	@Override
	public HatProvince getHatProvince(String pid) {
		 QueryWrapper<HatProvince> wrapper=new QueryWrapper<HatProvince>();
		    wrapper.eq("provinceID", pid);
		    return hatProvinceMapper.selectOne(wrapper);
	}

}
