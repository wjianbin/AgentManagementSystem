package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.HatCity;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface IHatCityService extends IService<HatCity> {
 public HatCity get(String cid);
 public List<HatCity>getHatCityList(String pid);
 
}
