package cn.bdqn.sys.mapper;

import cn.bdqn.sys.entity.AsKeywords;

import cn.bdqn.sys.vo.procteds;

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
public interface AsKeywordsMapper extends BaseMapper<AsKeywords> {
@Select("select*from `as_keywords`,`as_systemconfig`where as_systemconfig.`id`=as_keywords.`productType` ")	
public List<procteds>priductsList();
}
