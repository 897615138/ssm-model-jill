package jill.util.result;

import java.io.Serializable;
import java.util.List;

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

    /**
     * 业务执行成功,有返回数据
     *
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity SUCCESS(ResultCode resultCode) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(resultCode.getResponseCode());
        resultEntity.setMessage(resultCode.getResponseMsg());
        resultEntity.setFlag(true);
        resultEntity.setData(EmptyObject.EMPTY);
        return resultEntity;
    }

    public static <T> ResultEntity<Object> SUCCESS(ResultCode resultCode, T data) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(resultCode.getResponseCode());
        resultEntity.setMessage(resultCode.getResponseMsg());
        resultEntity.setFlag(true);
        resultEntity.setData(data);
        return resultEntity;
    }
    /**
     * 执行失败,有返回数据
     *
     * @param data 数据
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<Object> FAIL(T data) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(ResultCode.FAIL.getResponseCode());
        resultEntity.setMessage(ResultCode.FAIL.getResponseMsg());
        resultEntity.setFlag(false);
        resultEntity.setData(data);
        return resultEntity;
    }

    /**
     * 执行失败没有返回数据
     *
     * @return 返回
     */
    public static ResultEntity<Object> FAIL() {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(ResultCode.FAIL.getResponseCode());
        resultEntity.setMessage(ResultCode.FAIL.getResponseMsg());
        resultEntity.setFlag(false);
        resultEntity.setData(EmptyObject.EMPTY);
        return resultEntity;
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
    public static <T> ResultEntity<Object> CUSTOM(ResultCode resultCode, boolean flag, T data) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(resultCode.getResponseCode());
        resultEntity.setMessage(resultCode.getResponseMsg());
        resultEntity.setFlag(flag);
        resultEntity.setData(data);
        return resultEntity;
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
    public static <T> ResultEntity<Object> CUSTOM(Integer code, String message, boolean flag, T data) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(code);
        resultEntity.setMessage(message);
        resultEntity.setFlag(flag);
        resultEntity.setData(data);
        return resultEntity;
    }

    /**
     * 异常返回
     *
     * @param <T> 泛型
     * @return 返回
     */
    public static <T> ResultEntity<Object> SYS_ERROR(String message) {
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(ResultCode.SYS_ERROR(message).getResponseCode());
        resultEntity.setMessage(ResultCode.SYS_ERROR(message).getResponseMsg());
        resultEntity.setFlag(false);
        resultEntity.setData(EmptyObject.EMPTY);
        return resultEntity;
    }

    /**
     * 异常返回
     * @param IResponseEntity 返回接口
     * @return 返回
     */
    public static ResultEntity<Object> EXCEPTION(IResponseEntity IResponseEntity){
        ResultEntity<Object> resultEntity = new ResultEntity<>();
        resultEntity.setCode(IResponseEntity.getResponseCode());
        resultEntity.setMessage(IResponseEntity.getResponseMsg());
        resultEntity.setFlag(false);
        resultEntity.setData(EmptyObject.EMPTY);
        return resultEntity;
    }
}
