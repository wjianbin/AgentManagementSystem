package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.mapper.AsAccountAllMapper;
import cn.bdqn.sys.mapper.AsAccountMapper;
import cn.bdqn.sys.mapper.AsAccountdetailAllMapper;
import cn.bdqn.sys.mapper.AsAccountdetailMapper;
import cn.bdqn.sys.service.IAsAccountdetailService;
import cn.bdqn.sys.vo.AsAccountdetailAll;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Service

public class AsAccountdetailServiceImpl extends ServiceImpl<AsAccountdetailMapper, AsAccountdetail> implements IAsAccountdetailService {
	@Autowired
	private AsAccountdetailMapper adeMapper;
	@Autowired
	AsAccountMapper accMapper; 
	@Autowired
	private AsAccountdetailAllMapper asAccountdetailAllMapper;
	@Override
	public IPage getasAccountdetail(IPage arg0, long userId) {
		
		// TODO Auto-generated method stub
				QueryWrapper<AsAccountdetail> mapper =new QueryWrapper<AsAccountdetail>();
				mapper.eq("userId", userId);
				IPage<AsAccountdetail> arg1= adeMapper.selectPage(arg0, mapper);
				return arg1;
	}
	@Override
	public List<AsAccountdetailAll> getasAccountdetailList(String startTime,String endTime ) {
		QueryWrapper<AsAccountdetailAll> mapper =new QueryWrapper<AsAccountdetailAll>();
		
		if (startTime!="" && startTime!=null && endTime!="" && endTime!=null) {
		mapper.between("detailDateTime", startTime, endTime);
		}
		mapper.eq("roleId", 40);
	     return asAccountdetailAllMapper.selectList(mapper);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean addAccountdetail(AsAccountdetail accountdetail) {
		QueryWrapper<AsAccount> mapper = new QueryWrapper<AsAccount>();
		mapper.eq("userId", accountdetail.getUserId());
		AsAccount us = accMapper.selectOne(mapper);

		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		accountdetail.setDetailDateTime(localDateTime);

		try {
			us.setMoney(us.getMoney() + (accountdetail.getMoney()));
			accountdetail.setAccountMoney(us.getMoney());

			int j = accMapper.updateById(us);
			int i = adeMapper.insert(accountdetail);
			if (j == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 如果adeMapper()抛了异常,accMapper()会回滚,不影响事物正常执行
			return false;
		}
	}

	
	
	@Override
	public IPage<AsAccountdetail> getasAccountdetail(IPage<AsAccountdetail> arg0, Long id, Long detailType,
		String startTime, String endTime) {
		QueryWrapper<AsAccountdetail>  queryWrapper=new QueryWrapper<AsAccountdetail>();
    	if(null!=id) {
    		queryWrapper.eq("userId", id);
    	}
    	if(null!=detailType) {
    		queryWrapper.eq("detailType", detailType);
    	}
    	if(null!=startTime&&null!=endTime&&startTime!=""&&endTime!="") {
    		queryWrapper.between("detailDateTime", startTime, endTime);
    		
    	}
		  arg0=adeMapper.selectPage(arg0, queryWrapper);
		  return arg0;		
	}

	

}
