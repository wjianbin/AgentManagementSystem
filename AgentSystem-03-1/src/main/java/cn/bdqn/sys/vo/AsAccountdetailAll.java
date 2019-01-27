package cn.bdqn.sys.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import cn.bdqn.sys.entity.AsAccountdetail;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
public class AsAccountdetailAll extends AsAccountdetail implements Serializable{
	  @TableField("userName")
	   private String userName;
}
