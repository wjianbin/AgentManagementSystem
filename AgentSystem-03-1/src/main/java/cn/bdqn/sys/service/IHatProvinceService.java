package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.HatProvince;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface IHatProvinceService extends IService<HatProvince> {
	
 public HatProvince getHatProvince(String pid); 
}
