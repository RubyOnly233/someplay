package com.sxt.office.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author tanghua
 * @Date: 2020/5/25 15:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/sys")
public class SystemController {


    /**
     *  跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {

        return "system/index/login";
    }


}