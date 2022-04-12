package com.lzw.seckill.service.impl;

import com.lzw.seckill.pojo.User;
import com.lzw.seckill.mapper.UserMapper;
import com.lzw.seckill.result.ResultBean;
import com.lzw.seckill.result.ResultBeanEnum;
import com.lzw.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.seckill.utils.MdD5Utils;
import com.lzw.seckill.utils.ValidatorUtil;
import com.lzw.seckill.vo.req.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzw
 * @since 2022-04-11
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ResultBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return ResultBean.error(ResultBeanEnum.LOGIN_ERROR);
        }
        // 手机号校验
        if (!ValidatorUtil.isMobile(mobile)) {
            return ResultBean.error(ResultBeanEnum.MOBILE_ERROR);
        }

        User user = userMapper.selectById(mobile);

        if (null == user) {
            return ResultBean.error(ResultBeanEnum.LOGIN_ERROR);
        }

        // 校验密码
        if (!MdD5Utils.formPassToDBPass(password, user.getSlat()).equals(user.getPasword())) {
            return ResultBean.error(ResultBeanEnum.LOGIN_ERROR);
        }
        log.info("用户 【{}】 登录成功",mobile);
        return ResultBean.success();
    }
}
