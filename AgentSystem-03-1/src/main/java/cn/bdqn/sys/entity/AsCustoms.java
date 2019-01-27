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
public class AsCustoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("agentId")
    private Long agentId;

    @TableField("agentName")
    private String agentName;

    @TableField("customName")
    private String customName;

    @TableField("customType")
    private Integer customType;

    @TableField("customTypeName")
    private String customTypeName;

    @TableField("siteUrl")
    private String siteUrl;

    /**
     * 1为启动 0 为停用
     */
    @TableField("customStatus")
    private Integer customStatus;

    @TableField("bossName")
    private String bossName;

    @TableField("cardType")
    private Integer cardType;

    @TableField("cardTypeName")
    private String cardTypeName;

    @TableField("cardNum")
    private String cardNum;

    @TableField("companyTel")
    private String companyTel;

    @TableField("companyFax")
    private String companyFax;

    @TableField("regDatetime")
    private String regDatetime;

    private String country;

    private String province;

    private String city;

    private String area;

    @TableField("companyAddress")
    private String companyAddress;

    private String memo;

    @TableField("agentCode")
    private String agentCode;


}
