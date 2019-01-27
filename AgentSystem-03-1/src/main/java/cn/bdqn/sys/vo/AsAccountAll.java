package cn.bdqn.sys.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import cn.bdqn.sys.entity.AsAccount;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
public class AsAccountAll extends AsAccount implements Serializable{
	  @TableField("userName")
	   private String userName;

}
