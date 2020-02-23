package com.nepous.provider.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;

@Data
@TableName("pc_uac_user")
public class UacUser {
    private static final long serialVersionUID = 5465775492730080699L;

    public static final String ID = "id";

    public static final String LOGINNAME = "login_name";

    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id ;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 盐,用于shiro加密, 字段停用
     */
    private String salt;

    /**
     * 工号
     */
    private String userCode;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 状态
     */
    private String status;

    private String email;


    /**
     * 用户来源
     */
    private String userSource;

    /**
     * 操作员类型（2000伙伴, 3000客户, 1000运营）
     */
    private String type;

    /**
     * 最后登录IP地址
     */
    private String lastLoginIp;

    /**
     * 最后登录位置
     */
    private String lastLoginLocation;

    /**
     * 描述
     */
    private String remark;

    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 是否更改过密码
     */
    private Short isChangedPwd;

    /**
     * 连续输错密码次数（连续5次输错就冻结帐号）
     */
    private Short pwdErrorCount;

    /**
     * 最后输错密码时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pwdErrorTime;

    /**
     * 用户所属的组织ID
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "用户所属的组织ID")
    private Long groupId;

    @TableField(exist = false)
    @ApiModelProperty(value = "用户所属的组织名称")
    private String groupName;
}
