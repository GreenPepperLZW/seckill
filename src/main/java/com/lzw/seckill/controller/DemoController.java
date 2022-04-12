package com.lzw.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : lzw
 * @date : 2022/3/23
 * @since : 1.0
 */
@RequestMapping
@Controller
public class DemoController {

    /**
     * 测试页面跳转
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String test(Model model) {
        model.addAttribute("name", "张三");
        return "hello";
    }

}
