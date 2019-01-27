package cn.bdqn.sys.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import cn.bdqn.sys.entity.AsCustoms;
import cn.bdqn.sys.entity.HatCity;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AsCustomsAll extends  AsCustoms implements Serializable {
	 @TableField("isUse")
	  private Integer isUse;
	
	  private String keywords;
	 @TableField("customId")
	  private Long customId;
	public AsCustomsAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AsCustomsAll(Integer isUse, String keywords, Long customId) {
		super();
		this.isUse = isUse;
		this.keywords = keywords;
		this.customId = customId;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}

}
