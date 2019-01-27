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
public class AsKeywords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String keywords;

    @TableField("agentId")
    private Long agentId;

    @TableField("agentName")
    private String agentName;

    @TableField("customId")
    private Long customId;

    @TableField("customName")
    private String customName;

    @TableField("preRegFrozenMoney")
    private Double preRegFrozenMoney;

    private Double price;

    @TableField("productType")
    private Integer productType;

    /**
     * 服务年限
     */
    @TableField("serviceYears")
    private Integer serviceYears;

    /**
     * 0未开通 1 开通
     */
    @TableField("openApp")
    private Integer openApp;

    @TableField("appUserName")
    private String appUserName;

    @TableField("appPassword")
    private String appPassword;

    /**
     * 登陆地址
     */
    @TableField("loginUrl")
    private String loginUrl;

    /**
     * ios客户端下载地址
     */
    @TableField("iosDownloadUrl")
    private String iosDownloadUrl;

    /**
     * android客户端下载地址
     */
    @TableField("androidDownloadUrl")
    private String androidDownloadUrl;

    /**
     * IOS二维码下载地址
     */
    @TableField("codeIosUrl")
    private String codeIosUrl;

    /**
     * android二维码下载地址
     */
    @TableField("codeAndroidUrl")
    private String codeAndroidUrl;

    @TableField("preRegDatetime")
    private LocalDateTime preRegDatetime;

    @TableField("preRegPassDatetime")
    private LocalDateTime preRegPassDatetime;

    @TableField("regDatetime")
    private LocalDateTime regDatetime;

    @TableField("regPassDatetime")
    private LocalDateTime regPassDatetime;

    /**
     * 0为不过期，1为预注册过期，2为正式注册过期
     */
    @TableField("isPass")
    private Integer isPass;

    /**
     * 0为已申请 1为审核中 2为已通过 3未通过
     */
    @TableField("checkStatus")
    private Integer checkStatus;

    /**
     * 1为已使用 0为未使用
     */
    @TableField("isUse")
    private Integer isUse;


}
