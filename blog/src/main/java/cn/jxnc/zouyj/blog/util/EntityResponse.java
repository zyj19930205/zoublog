package cn.jxnc.zouyj.blog.util;

import lombok.Data;

/**
 * 对返回的数据进行封装
 * 添加状态码
 * @author zouyujie
 * @date 2019/9/28 10:50
 */
@Data
public class EntityResponse<T> {
    private static final String CODE_SUCCESS = "success";
    private static final String CODE_FAIL = "fail";

    public EntityResponse(String code) {
        this.code = code;
    }

    public EntityResponse(T data) {
        this.data = data;
    }


    private String code;
    private T data;
    private String msg;

    public EntityResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public EntityResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public EntityResponse() {
    }

    public static EntityResponse success(){
        return new EntityResponse(CODE_SUCCESS);
    }

    public static EntityResponse success(Object data){
        return new EntityResponse(CODE_SUCCESS,data);
    }

    public static EntityResponse fail(String msg){
        return new EntityResponse(CODE_FAIL, msg);
    }

    public static EntityResponse widthCode(String errorCode) {
        return new EntityResponse(errorCode);
    }


}
