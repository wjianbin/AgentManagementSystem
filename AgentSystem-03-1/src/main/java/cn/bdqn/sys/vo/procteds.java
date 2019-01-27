package cn.bdqn.sys.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
public class procteds implements Serializable{
 @TableField("configTypeName")
 private String configTypeName;
 private Integer number;
 private double price;
}
