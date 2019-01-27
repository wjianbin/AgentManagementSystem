package cn.bdqn.sys.mapper;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.vo.AsCustomsAll;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

public interface AsCustomsMapper extends BaseMapper<AsCustoms> {
@Select(("select*from as_customs inner join as_keywords on as_customs.id=as_keywords.customId"))
	public List<AsCustomsAll> showAll(Page p,AsCustomsAll a);

}
