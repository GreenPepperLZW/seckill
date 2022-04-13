package com.lzw.seckill.controller;

import com.lzw.seckill.result.ResultBean;
import com.lzw.seckill.service.IUserService;
import com.lzw.seckill.vo.req.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 登录
 * @author : lzw
 * @date : 2022/4/11
 * @since : 1.0
 */
@Slf4j
@Controller
@RequestMapping("/login")
@Api(tags = {"用户登录相关接口"})
public class LoginController {

    private final IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转登录页面
     * @return
     */
    @ApiOperation(value = "跳转登录页面")
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/doLogin")
    public ResultBean doLogin(@Valid @ApiParam(value = "请求参数",required = true) LoginVo loginVo) {

        return userService.doLogin(loginVo);
    }

}
