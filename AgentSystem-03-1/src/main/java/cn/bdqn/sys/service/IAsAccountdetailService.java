package cn.bdqn.sys.service;

import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.vo.AsAccountdetailAll;

import java.util.List;

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
public interface IAsAccountdetailService extends IService<AsAccountdetail> {
	public IPage getasAccountdetail(IPage arg0,long userId);
	public List<AsAccountdetailAll> getasAccountdetailList(String startTime,String endTime );
	public boolean addAccountdetail(AsAccountdetail accountdetail);
	
	public IPage<AsAccountdetail> getasAccountdetail(IPage<AsAccountdetail> arg0,Long id,Long detailType,String startTime,String endTime);

}
