package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.mapper.AsAccountAllMapper;
import cn.bdqn.sys.mapper.AsAccountMapper;
import cn.bdqn.sys.mapper.AsUserMapper;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.vo.AsAccountAll;
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
public class AsAccountServiceImpl extends ServiceImpl<AsAccountMapper, AsAccount> implements IAsAccountService {
	@Autowired
	private AsAccountMapper asAccountMapper;
	@Autowired
	private AsAccountMapper accountMapper;
	@Autowired
	private AsAccountAllMapper asAccountAllMapper;
	@Override
	public AsAccount getAsAccount(Long userid) {
		QueryWrapper<AsAccount> wrapper=new QueryWrapper<AsAccount>();
		wrapper.eq("userId", userid);
		return asAccountMapper.selectOne(wrapper);
	}
	@Override
	public List<AsAccountAll> getAsAccountList() {
		QueryWrapper<AsAccountAll> wrapper=new QueryWrapper<AsAccountAll>();
		wrapper.eq("roleId", 40);
        return asAccountAllMapper.selectList(wrapper);
	}
	@Override
	public AsAccount showUserAccount(Long userId) {
		// TODO Auto-generated method stub
		QueryWrapper<AsAccount> mapper= new QueryWrapper<AsAccount>();
		mapper.eq("userId", userId);
		return asAccountMapper.selectOne(mapper);

	}
	
	
	
}
