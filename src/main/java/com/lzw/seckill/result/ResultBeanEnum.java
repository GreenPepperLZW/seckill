package com.lzw.seckill.result;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author : lzw
 * @date : 2022/4/12
 * @since : 1.0
 */

@ToString
@AllArgsConstructor
public enum  ResultBeanEnum implements ResultCode{

    // ==================通用==========================
    /**
     * 成功
     */
    SUCCESS(200,"SUCCESS"),

    /**
     * 失败
     */
    ERROR(500,"服务异常"),

    // ==================登录模块==========================
    LOGIN_ERROR(500210,"用户名或免密不正确"),
    MOBILE_ERROR(500211,"手机号格式不正确");

    private final Integer code;
    private final String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
