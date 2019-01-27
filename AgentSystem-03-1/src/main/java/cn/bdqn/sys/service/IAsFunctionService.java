package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsFunction;

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
public interface IAsFunctionService extends IService<AsFunction> {
  public List<AsFunction>getAllAsFunction();
  public List<AsFunction>getAllAsFunctions(long parentId);
}
