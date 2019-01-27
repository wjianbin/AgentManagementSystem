package cn.bdqn.sys.mapper;

import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.vo.AsAccountAll;
import cn.bdqn.sys.vo.AsAccountdetailAll;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface AsAccountdetailMapper extends BaseMapper<AsAccountdetail> {
	@Select("select*from as_accountdetail inner join as_user on  as_accountdetail.`userId`=as_user.`id`")
	public List<AsAccountdetailAll> showAsAccountdetailAll();
}
