package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsFunction;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.mapper.AsFunctionMapper;
import cn.bdqn.sys.service.IAsFunctionService;

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
public class AsFunctionServiceImpl extends ServiceImpl<AsFunctionMapper, AsFunction> implements IAsFunctionService {
	@Autowired
 private AsFunctionMapper asFunctionMapper;
	@Override
	public List<AsFunction> getAllAsFunction() {
		QueryWrapper<AsFunction> wrapper=new QueryWrapper<AsFunction>();
		wrapper.eq("parentId", 0);
		return asFunctionMapper.selectList(wrapper);
	}
	@Override
	public List<AsFunction> getAllAsFunctions(long parentId) {
		QueryWrapper<AsFunction> wrapper=new QueryWrapper<AsFunction>();
		wrapper.eq("parentId", parentId);
		return asFunctionMapper.selectList(wrapper);
		
	}

}
