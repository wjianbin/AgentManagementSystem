package cn.bdqn.sys.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author zhou
 * @since 2019-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Viewcustoms implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @TableField("companyAddress")
    private String companyAddress;

    private String memo;

    @TableField("agentCode")
    private String agentCode;

    private long acid;
  @TableField("contactName")
    private String contactName;

    @TableField("contactTel")
    private String contactTel;

    @TableField("contactFax")
    private String contactFax;

    @TableField("contactEmail")
    private String contactEmail;

    @TableField("contactRole")
    private String contactRole;
    
    
   

    private String area;

    private String city;

    private String province;

    @TableField("cityID")
    private String cityID;

    @TableField("areaID")
    private String areaID;

    @TableField("provinceID")
    private String provinceID;


}
