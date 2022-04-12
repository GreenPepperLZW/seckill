package com.lzw.seckill.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author : lzw
 * @date : 2022/4/12
 * @since : 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> {

    /**
     * 信息码
     */
    private long code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 数据
     */
    private T ojb;

    public static ResultBean success() {
        return new ResultBean(ResultBeanEnum.SUCCESS.getCode(), ResultBeanEnum.SUCCESS.getMsg(),null);
    }

    public static ResultBean success(Object data) {
        return new ResultBean(ResultBeanEnum.SUCCESS.getCode(), ResultBeanEnum.SUCCESS.getMsg(),data);
    }

    public static ResultBean error(ResultBeanEnum resultBeanEnum) {
        return new ResultBean(resultBeanEnum.getCode(), resultBeanEnum.getMsg(),null);
    }

    public static ResultBean error(ResultBeanEnum resultBeanEnum,Object object) {
        return new ResultBean(resultBeanEnum.getCode(), resultBeanEnum.getMsg(),object);
    }

}
