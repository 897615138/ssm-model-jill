package jill.payment.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author jill
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String userNickname;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 性别 0=保密/1=男/2=女
     */
    private int userSex;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 头像缩略图地址
     */
    private String userAvatar;

    /**
     * 逻辑删除
     */
    private Boolean userDelete;


}
