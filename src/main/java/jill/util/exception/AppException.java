package jill.util.exception;


import jill.util.result.IResponseEntity;

public class AppException extends RuntimeException implements IResponseEntity {
    private static final long serialVersionUID = -45950644483715464L;
    private final Integer code;
    private final String msg;

    /**
     * 异常 封装
     * @param ErrorCodeEnum 错误枚举
     */
    public AppException(IResponseEntity ErrorCodeEnum) {
        super(ErrorCodeEnum.getResponseCode() + ":" + ErrorCodeEnum.getResponseMsg());
        this.code = ErrorCodeEnum.getResponseCode();
        this.msg = ErrorCodeEnum.getResponseMsg();
    }

    /**
     * 自定义 异常描述
     * @param ErrorCodeEnum 错误枚举
     * @param description  描述
     */
    public AppException(IResponseEntity ErrorCodeEnum, String description) {
        super(ErrorCodeEnum.getResponseCode() + ":" + description);
        this.code = ErrorCodeEnum.getResponseCode();
        this.msg = description;
    }

    /**
     * 自定义普通异常
     * @param responseCode 响应码
     * @param responseMsg 相应信息 相应信息
     */
    public AppException(Integer responseCode, String responseMsg) {
        super(responseCode + ":" + responseMsg);
        this.code = responseCode;
        this.msg = responseMsg;
    }

    public Integer getResponseCode() {
        return this.code;
    }

    @Override
    public String getResponseMsg() {
        return this.msg;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getErrorMessage() {
        return this.msg;
    }
}
