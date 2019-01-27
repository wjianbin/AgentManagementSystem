package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.HatArea;
import cn.bdqn.sys.entity.HatCity;
import cn.bdqn.sys.vo.AsCustomsAll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface IAsCustomsService extends IService<AsCustoms> {
	 public IPage<AsCustomsAll> getAllcustoms(AsCustomsAll a,Integer page,Integer pageSize);
	 public AsCustoms getAsCustoms(long customId);
	 public IPage getCustomsall(IPage arg2,String cname);
	 public AsCustoms AsCustoms(String customName);
     public AsCustoms getcustom();
     public AsCustoms custom(long id);
     public void addcustom(HttpServletRequest request,int id,String type);
     public void getprovince(HttpServletRequest request);
     public List<HatCity> getcity(Integer id);
     public List<HatArea> getarea(Integer id);
     
     
     public List<AsCustoms> getUserCustoms(Long userId ,String customName);
}
