package jill.util.result;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * RESTFul 响应同一接口
 */
@Data
@ToString
public class ResultEntity<T> implements Serializable {
    private Integer code;// 返回码
    private String message;//返回信息
    private boolean flag;// 业务执行是否成功
    private T data;// 返回数据

    private ResultEntity(ResultCode resultCode, boolean flag, T data) {
        this.code = resultCode.getResponseCode();
        this.message = resultCode.getResponseMsg();
        this.flag = flag;
        this.data = data;
    }

    private ResultEntity(Integer code, String message, boolean flag, T data) {
        this.code = code;
        this.message = message;
        this.flag = flag;
        this.data = data;
    }
    private ResultEntity(ResultCode resultCode,boolean flag) {
        this.code = resultCode.getResponseCode();
        this.message = resultCode.getResponseMsg();
        this.flag = flag;
    }

    /**
     * 业务执行成功,有返回数据
     *
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<T> SUCCESS(ResultCode resultCode) {
        return new ResultEntity(resultCode, true);
    }

    public static <T> ResultEntity<T> SUCCESS(ResultCode resultCode,T data) {
        return new ResultEntity<>(resultCode, true, data);
    }
    /**
     * 业务执行成功,没有返回数据
     *
     * @return 返回
     */
    public static ResultEntity<EmptyObject> SUCCESS() {
        return new ResultEntity<>(ResultCode.SUCCESS, true, EmptyObject.EMPTY);
    }

    /**
     * 执行失败,有返回数据
     *
     * @param data 数据
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<T> FAIL(T data) {
        return new ResultEntity<>(ResultCode.FAIL, false, data);
    }

    /**
     * 执行失败没有返回数据
     *
     * @return 返回
     */
    public static ResultEntity<EmptyObject> FAIL() {
        return new ResultEntity<>(ResultCode.FAIL, false, EmptyObject.EMPTY);
    }

    /**
     * 自定义返回数据,使用枚举
     *
     * @param resultCode 返回码
     * @param flag 标志
     * @param data 数据
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<T> CUSTOM(ResultCode resultCode, boolean flag, T data) {
        return new ResultEntity<>(resultCode, flag, data);
    }

    /**
     * 自定义返回数据
     *
     * @param code 代码
     * @param message 信息
     * @param flag 标志
     * @param data 数据
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<T> CUSTOM(Integer code, String message, boolean flag, T data) {
        return new ResultEntity<>(code, message, flag, data);
    }

    /**
     * 异常返回
     *
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<EmptyObject> SYS_ERROR(String message) {
        return new ResultEntity<>(ResultCode.SYS_ERROR(message), false, EmptyObject.EMPTY);
    }

    /**
     * 异常返回
     * @param IResponseEntity 返回接口
     * @return 返回
     */
    public static ResultEntity<EmptyObject> EXCEPTION(IResponseEntity IResponseEntity){
        return new ResultEntity<>(IResponseEntity.getResponseCode(), IResponseEntity.getResponseMsg(),false,EmptyObject.EMPTY);
    }
}
