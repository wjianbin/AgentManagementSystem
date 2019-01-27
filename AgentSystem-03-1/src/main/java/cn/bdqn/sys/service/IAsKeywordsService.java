package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsKeywords;

import cn.bdqn.sys.vo.procteds;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface IAsKeywordsService extends IService<AsKeywords> {
 public AsKeywords getAsKeywords(long customId);
 public int modifysaveportal(AsKeywords asKeywords);
 public List<procteds> priductsList();
 public IPage<AsKeywords> FuzzySearchAsKeywordsList(String keywords,Page<AsKeywords> IPage1);
	public boolean updatekeywordOnCheckStatus(AsKeywords keywords);
	
	public boolean KeywordsRenew(long userId,Integer total,long Kid,int serviceyear,int serviceConfigValue);

	    public boolean checkKeyWords(String keyWordsName);
		public AsKeywords applyKeyWords(AsKeywords keyWords);
		public double getPrice(String p);
		public List<AsKeywords> getKeywords(String keywords);
		public IPage<AsKeywords> getpage(IPage<AsKeywords> page,String keywords);
		public boolean delKeywordsById(Long id);
}
