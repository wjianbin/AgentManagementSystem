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
public class AsFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("functionCode")
    private String functionCode;

    @TableField("functionName")
    private String functionName;

    @TableField("creationTime")
    private LocalDateTime creationTime;

    @TableField("createdBy")
    private String createdBy;

    @TableField("lastUpdateTime")
    private LocalDateTime lastUpdateTime;

    @TableField("funcUrl")
    private String funcUrl;

    /**
     * 1为启用0为不启用
     */
    @TableField("isStart")
    private Integer isStart;

    @TableField("parentId")
    private Integer parentId;


}
