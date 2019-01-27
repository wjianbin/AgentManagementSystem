package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.mapper.AsUserMapper;
import cn.bdqn.sys.service.IAsUserService;
import cn.bdqn.utils.MD5;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
public class AsUserServiceImpl extends ServiceImpl<AsUserMapper, AsUser> implements IAsUserService {
@Autowired
private AsUserMapper asUserMapper;
	@Override
	public AsUser login(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		QueryWrapper<AsUser> wrapper=new QueryWrapper<AsUser>();
	    
		wrapper.eq("userCode", userCode);
		wrapper.eq("userPassword", MD5.MD5Encode(userPassword));
		return asUserMapper.selectOne(wrapper);
	}
	@Override
	public List<AsUser> FuzzySearchUserByUserCode(String FuzzyUserCode) {
		if (FuzzyUserCode == "" || FuzzyUserCode == null) {
			return null;
		}
		// TODO Auto-generated method stub
		QueryWrapper<AsUser> mapper = new QueryWrapper<AsUser>();
		mapper.like("userCode", FuzzyUserCode);
		List<AsUser> userList = asUserMapper.selectList(mapper);
		return userList;
	}
	public int updateUser(HttpSession session, AsUser user) {
		// TODO Auto-generated method stub

		AsUser use = (AsUser) session.getAttribute("user");
		user.setCreatedBy(use.getUserCode());
		user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime lastUpdateTime = instant.atZone(zoneId).toLocalDateTime();
		user.setLastUpdateTime(lastUpdateTime);
		return asUserMapper.updateById(user);
	}
	@Override
	public int addUser(HttpSession session, AsUser user) {
		// TODO Auto-generated method stub

		AsUser use = (AsUser) session.getAttribute("user");
		user.setCreatedBy(use.getUserCode());
		user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		user.setCreationTime(localDateTime);
		
		return asUserMapper.insert(user);
	}

	@Override
	public int delUser(Long id) {
		// TODO Auto-generated method stub

		return asUserMapper.deleteById(id);
	}

	@Override
	public int updateUserLastLoginTime(AsUser user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime lastLoginTime = instant.atZone(zoneId).toLocalDateTime();
		user.setLastLoginTime(lastLoginTime);
		return asUserMapper.updateById(user);

	}

}
