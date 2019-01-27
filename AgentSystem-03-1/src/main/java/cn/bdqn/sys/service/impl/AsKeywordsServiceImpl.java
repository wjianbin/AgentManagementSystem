package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.AsKeywords;
import cn.bdqn.sys.entity.AsSystemconfig;
import cn.bdqn.sys.mapper.AsAccountMapper;
import cn.bdqn.sys.mapper.AsAccountdetailMapper;
import cn.bdqn.sys.mapper.AsFunctionMapper;
import cn.bdqn.sys.mapper.AsKeywordsMapper;
import cn.bdqn.sys.mapper.AsSystemconfigMapper;
import cn.bdqn.sys.mapper.proctedsMapper;
import cn.bdqn.sys.service.IAsKeywordsService;

import cn.bdqn.sys.vo.procteds;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Service
public class AsKeywordsServiceImpl extends ServiceImpl<AsKeywordsMapper, AsKeywords> implements IAsKeywordsService {
	@Autowired
	private AsAccountdetailMapper adeMapper;
	@Autowired
	private AsAccountMapper accMapper;
	@Autowired
  private  AsKeywordsMapper asKeywordsMapper;
  @Autowired
	private AsKeywordsMapper keywordsMapper;
  @Autowired
	private AsSystemconfigMapper asSystemconfigMapper;
  @Autowired
  private proctedsMapper pproctedsMapper;
	@Override
	public AsKeywords getAsKeywords(long customId) {
		QueryWrapper<AsKeywords> wrapper=new QueryWrapper<AsKeywords>();
		wrapper.eq("customId", customId);
		return asKeywordsMapper.selectOne(wrapper);
	}
	@Override
	public int modifysaveportal(AsKeywords asKeywords) {
		QueryWrapper<AsKeywords> wrapper=new QueryWrapper<AsKeywords>();
		    wrapper.eq("id", asKeywords.getId());
		return asKeywordsMapper.updateById(asKeywords);
	}
	@Override
	public List<procteds> priductsList() {
		QueryWrapper<procteds> wrapper=new QueryWrapper<procteds>();
		return pproctedsMapper.selectList(wrapper);
	}
	@Override
	public IPage<AsKeywords> FuzzySearchAsKeywordsList(String keywords, Page<AsKeywords> IPage1) {
		// TODO Auto-generated method stub
		QueryWrapper<AsKeywords> mapper = new QueryWrapper<AsKeywords>();
		if (keywords != null && keywords != "") {
			mapper.like("keywords", keywords);
		}
		return keywordsMapper.selectPage(IPage1, mapper);

	}
	@Override
	public boolean updatekeywordOnCheckStatus(AsKeywords keywords) {
		// TODO Auto-generated method stub
		QueryWrapper<AsKeywords> mapper = new QueryWrapper<AsKeywords>();
		int i = keywordsMapper.updateById(keywords);
		if (i == 1) {
			return true;
		}

		return false;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean KeywordsRenew(long userId, Integer total, long Kid, int serviceyear, int serviceConfigValue) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		// 取出configType的属性和名字
		try {
			QueryWrapper<AsSystemconfig> asSystemMapper = new QueryWrapper<AsSystemconfig>();
			asSystemMapper.eq("configValue", serviceConfigValue);
			AsSystemconfig asSystem = asSystemconfigMapper.selectOne(asSystemMapper);
			// 扣除当前账户的的费用
			QueryWrapper<AsAccount> asAccMapper = new QueryWrapper<AsAccount>();
			asAccMapper.eq("userId", userId);
			AsAccount us = accMapper.selectOne(asAccMapper);
			us.setMoney(us.getMoney() - total);
			int i = accMapper.updateById(us);
			// 生成订单信息
			QueryWrapper<AsAccountdetail> acdetailMapper = new QueryWrapper<AsAccountdetail>();
			AsAccountdetail accountdetail = new AsAccountdetail();
			accountdetail.setUserId(us.getUserId());
			accountdetail.setAccountMoney(us.getMoney());
			accountdetail.setDetailType((long) 9996);
			accountdetail.setDetailTypeName("扣除关键词续费资金");
			accountdetail.setMoney((double) total);
			accountdetail.setAccountMoney(us.getMoney());
			accountdetail.setMemo("Id号："+accountdetail.getDetailType()+"，名称："+accountdetail.getDetailTypeName()+ "，充值金额：" + total + "，userId：" + userId + "，AsKeywordsID：" + Kid);
			// 插入一条账单
			LocalDateTime detailDateTime = instant.atZone(zoneId).toLocalDateTime();
			accountdetail.setDetailDateTime(detailDateTime);
			int j = adeMapper.insert(accountdetail);

			QueryWrapper<AsKeywords> asKeywordMapper = new QueryWrapper<AsKeywords>();
			AsKeywords asKeyword = keywordsMapper.selectById(Kid);
			asKeyword.setAgentId(us.getUserId());
			asKeyword.setPrice((double)total);
			asKeyword.setServiceYears(serviceyear);// 申请使用时间
			asKeyword.setIsPass(0);
			asKeyword.getRegPassDatetime();// 到期时间
			// 在原来的时间上延长2年时间
			asKeyword.setRegPassDatetime(asKeyword.getRegPassDatetime().plusYears(serviceyear));
			int r = keywordsMapper.updateById(asKeyword);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public AsKeywords applyKeyWords(AsKeywords keyWords) {
		keywordsMapper.insert(keyWords);
		return keyWords;
	}

	@Override
	public boolean checkKeyWords(String keyWordsName) {
		QueryWrapper<AsKeywords> queryWrapper = new QueryWrapper<AsKeywords>();
	    queryWrapper.eq("keywords", keyWordsName);
		AsKeywords flag = keywordsMapper.selectOne(queryWrapper);		
		if (flag == null ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getPrice(String p) {
		double price = 0;
			String[] prames = StringUtils.split(p,"-");
			String serviceTypeId = prames[0];
			String serviceYears = prames[1];
			if(serviceTypeId.equals("1")) {
				price = (double)26000 * Integer.valueOf(serviceYears);
				
			}else if(serviceTypeId.equals("2")) {
				price = (double)18000 * Integer.valueOf(serviceYears);
			}
			return price;
	}

	@Override
	public List<AsKeywords> getKeywords(String keywords) {
		QueryWrapper<AsKeywords> queryWrapper = new QueryWrapper<AsKeywords>();
		if(!(null == keywords || keywords.equals(""))) {
			queryWrapper.like("keywords", keywords);
		}
		return keywordsMapper.selectList(queryWrapper);
	}
	@Override
	public IPage<AsKeywords> getpage(IPage<AsKeywords> page,String  keywords) {
		QueryWrapper<AsKeywords> warpper=new QueryWrapper<AsKeywords>();
		if(keywords!=null){
			warpper.like("keywords",keywords);
		}
		IPage<AsKeywords> page1=keywordsMapper.selectPage(page, warpper);
		return page1;
	}

	@Override
	public boolean delKeywordsById(Long id) {
		int i = keywordsMapper.deleteById(id);
		if(i==0) {
			return false;
		}
		return true;
	}


}
