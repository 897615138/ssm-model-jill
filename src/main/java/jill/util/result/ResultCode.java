package jill.util.result;

/**
 * 状态码、状态信息枚举
 */
public enum ResultCode implements IResponseEntity {

    /**
     * 请求成功
     */
    SUCCESS(1000, "操作成功"),
    /**
     * 登录
     */
    LOGIN_USERNAME_PWD_ERROR(4001, "用户名或密码错误！"),
    LOGIN_USERNAME_NOT_EXIST(4002, "用户名不存在！"),
    LOGIN_SUCCESS(1001,"登陆成功"),
    /**
     * 注册
     */
    REGISTER_USERNAME(1003, "用户名可用"),
    REGISTER_USERNAME_EXIST(4003, "用户名已经存在！"),
    REGISTER_SUCCESS(1004,"注册成功"),
    REGISTER_FAIL(4004,"注册失败"),
    REGISTER_MAIL(1005,"邮箱可用" ),
    REGISTER_MAIL_EXIST(4005,"邮箱重复" ),
    REGISTER_PHONE(1006,"手机号可用" ),
    REGISTER_PHONE_EXIST(4006,"手机号重复" ),
    /**
     * 登录过期，请重新登
     */
    LOGIN_EXPIRES(1111, "登录过期，请重新登录"),
    TOKEN_ERROR(1005,"TOKEN过期,请重新登录"),
    NO_LOGON(1004, "登录错误,请重新登录"),
    SYSTEM_ERROR(9999, "当前网络忙，请稍后再试"),
    FAIL(4000, "业务失败"),


    ;

    private final Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static ResultCode SYS_ERROR(String message) {
        ResultCode resultCode = ResultCode.SYSTEM_ERROR;
        resultCode.message = message;
        return resultCode;
    }

    @Override
    public Integer getResponseCode() {
        return this.code;
    }

    @Override
    public String getResponseMsg() {
        return this.message;
    }
}
