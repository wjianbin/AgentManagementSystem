package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.vo.AsAccountAll;

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
public interface IAsAccountService extends IService<AsAccount> {
	
  public AsAccount getAsAccount(Long userid);
  public List<AsAccountAll> getAsAccountList();
  public AsAccount showUserAccount(Long userId);
  

}
