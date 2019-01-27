package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.AsSystemconfig;

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
public interface IAsSystemconfigService extends IService<AsSystemconfig> {
   public List<AsSystemconfig> getallasSystemconfig(Integer id);
   public AsSystemconfig getisPeatConfig(AsSystemconfig asSystemconfig);
   public List<AsSystemconfig> getSystemconfig();
   public List<AsSystemconfig>AsCustomsList();
   
   
   List<AsSystemconfig> getSystemconfigByconfigType(Integer configTypeId);
}
