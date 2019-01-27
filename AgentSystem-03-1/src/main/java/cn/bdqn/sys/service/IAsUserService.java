package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsUser;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface IAsUserService extends IService<AsUser> {
 public AsUser login(String userCode , String userPassword);
 public List<AsUser> FuzzySearchUserByUserCode(String FuzzyUserCode);
 public int addUser(HttpSession session, AsUser user);
 public int delUser(Long id);
 public int updateUser(HttpSession session, AsUser user);
 public int updateUserLastLoginTime(AsUser user);
}
