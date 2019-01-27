package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.Userr;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Tan
 * @since 2019-01-09
 */
public interface UserrServiceName extends IService<Userr> {
	public IPage<Userr> findUser(Userr user,IPage arg0);

}
