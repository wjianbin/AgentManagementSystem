package cn.bdqn.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AsSystemconfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("configType")
    private Integer configType;

    @TableField("configTypeName")
    private String configTypeName;

    @TableField("configTypeValue")
    private Integer configTypeValue;

    @TableField("configValue")
    private String configValue;

    @TableField("isStart")
    private Integer isStart;


}
