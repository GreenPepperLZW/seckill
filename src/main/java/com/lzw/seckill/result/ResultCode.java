package com.lzw.seckill.result;

/**
 * 统一返回消息码对象
 *
 * @author : lzw
 * @date : 2022/4/11
 * @since : 1.0
 */
public interface ResultCode {


    /**
     * 消息码
     * @return
     */
    default int getCode() {
        return 0;
    }

    /**
     * 消息内容
     * @return
     */
    default String getMsg() {
        return "";
    }

}
