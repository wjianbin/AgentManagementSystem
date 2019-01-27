package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.Viewcustoms;
import cn.bdqn.sys.entity.contactList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author zhou
 * @since 2019-01-05
 */
public interface IViewcustomsService extends IService<Viewcustoms> {
public void viewcustom(HttpServletRequest rquest,Integer id,String custms,String contactList);
public void provinceList(HttpServletRequest  request);
public List cityList(Integer father);
public List areaList(Integer father);
public String update(AsCustoms asCustoms,contactList contactList);

}
