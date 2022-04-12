package com.lzw.seckill.service;

import com.lzw.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzw.seckill.result.ResultBean;
import com.lzw.seckill.vo.req.LoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzw
 * @since 2022-04-11
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    ResultBean doLogin(LoginVo loginVo);
}
