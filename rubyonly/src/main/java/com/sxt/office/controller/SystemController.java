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


    /**
     *  跳转到首页
     * @return
     */
    @RequestMapping("index")
    public String index() {

        return "system/index/index";
    }


    /**
     *  跳转到工作台
     * @return
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager() {

        return "system/index/deskManager";
    }


    /**
     *  跳转到日志页面
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager() {

        return "system/loginfo/loginfoManager";
    }


    /**
     *  跳转到系统公告
     * @return
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager() {

        return "system/notice/noticeManager";
    }

}
