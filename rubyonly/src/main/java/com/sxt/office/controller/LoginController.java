package com.sxt.office.controller;

import com.sxt.office.common.ActiverUser;
import com.sxt.office.common.ResultObj;
import com.sxt.office.common.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tanghua
 * @Date: 2020/5/25 16:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("login")
    public ResultObj login(String loginname, String pwd) {

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);

        try {
            subject.login(token);

            // 获取user
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();

            // 将user存到session去
            WebUtils.getSession().setAttribute("user",activerUser.getUser());

            return ResultObj.LOGIN_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }




    }

}
