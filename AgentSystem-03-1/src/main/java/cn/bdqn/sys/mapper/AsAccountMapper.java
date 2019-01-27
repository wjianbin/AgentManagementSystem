package cn.bdqn.sys.mapper;

import cn.bdqn.sys.entity.AsAccount;
import cn.bdqn.sys.vo.AsAccountAll;
import cn.bdqn.sys.vo.AsCustomsAll;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
public interface AsAccountMapper extends BaseMapper<AsAccount> {
	@Select(("select*from as_account inner join as_user on  as_account.`userId`=as_user.`id`"))
	public List<AsAccountAll> showAsAccountAll();
}
