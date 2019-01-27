package cn.bdqn.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class AsRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 创建时间
     */
    @TableField("creationTime")
    private LocalDateTime creationTime;

    /**
     * 创建者
     */
    @TableField("createdBy")
    private String createdBy;

    /**
     * 最后修改时间
     */
    @TableField("lastUpdateTime")
    private LocalDateTime lastUpdateTime;

    /**
     * 是否启用1为启用0为不启用
     */
    @TableField("isStart")
    private Integer isStart;


}
