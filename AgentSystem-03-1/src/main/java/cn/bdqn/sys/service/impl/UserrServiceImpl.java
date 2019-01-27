package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.Userr;
import cn.bdqn.sys.mapper.UserrMapper;
import cn.bdqn.sys.service.UserrServiceName;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Tan
 * @since 2019-01-09
 */
@Service
public class UserrServiceImpl extends ServiceImpl<UserrMapper, Userr> implements UserrServiceName {


	@Autowired
	private UserrMapper userrMapper;
	
	@Override
	public IPage<Userr> findUser(Userr user, IPage arg0) {
		// TODO Auto-generated method stub
		QueryWrapper<Userr> mapper = new QueryWrapper<Userr>();
		if (user.getUserName() != null) {
			mapper.like("userName",user.getUserName());
			
		}
		if(user.getRoleId() != null) {
			mapper.eq("roleId", user.getRoleId());
			
		}
		if(user.getIsStart() != null) {
			mapper.eq("isStart", user.getIsStart());
		}

		IPage arg1 = userrMapper.selectPage(arg0, mapper);
		return arg1;
	}

}
