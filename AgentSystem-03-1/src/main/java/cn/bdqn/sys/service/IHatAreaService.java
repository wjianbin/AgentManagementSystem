package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.HatArea;

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
public interface IHatAreaService extends IService<HatArea> {
  public HatArea getHatArea(String aid);
  public List<HatArea>AreaList(String cid);
}
