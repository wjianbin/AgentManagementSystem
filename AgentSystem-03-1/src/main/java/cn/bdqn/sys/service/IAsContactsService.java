package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsContacts;

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
public interface IAsContactsService extends IService<AsContacts> {
 public List<AsContacts> getAsContacts(long customId) ;
}
