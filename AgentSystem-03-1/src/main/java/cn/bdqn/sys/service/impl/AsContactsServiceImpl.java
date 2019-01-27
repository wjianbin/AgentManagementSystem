package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsContacts;

import cn.bdqn.sys.mapper.AsContactsMapper;

import cn.bdqn.sys.service.IAsContactsService;

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
public class AsContactsServiceImpl extends ServiceImpl<AsContactsMapper, AsContacts> implements IAsContactsService {
	 @Autowired
	  private  AsContactsMapper asContactsMapper;
	@Override
	public List<AsContacts> getAsContacts(long customId) {
		QueryWrapper<AsContacts> wrapper=new QueryWrapper<AsContacts>();
		wrapper.eq("customId", customId);
		return asContactsMapper.selectList(wrapper);
	}
}
