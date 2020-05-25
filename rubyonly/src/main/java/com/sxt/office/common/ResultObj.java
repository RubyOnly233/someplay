package com.sxt.office.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tanghua
 * @Date: 2020/1/14 11:40
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Contast.OK, "登录成功");
    public static final ResultObj LOGIN_ERROR_PASS = new ResultObj(Contast.Error, "登录失败，用户名或密码错误");
    public static final ResultObj LOGIN_ERROR_CODE = new ResultObj(Contast.Error, "登录失败，验证码错误");


    public static final ResultObj ADD_SUCCESS = new ResultObj(Contast.OK, "添加成功");
    public static final ResultObj ADD_ERROR = new ResultObj(Contast.Error, "添加失败");

    public static final ResultObj UPDATE_SUCCESS= new ResultObj(Contast.OK, "更新成功");
    public static final ResultObj UPDATE_ERROR = new ResultObj(Contast.Error, "更新失败");

    public static final ResultObj DELETE_SUCCESS = new ResultObj(Contast.OK, "删除成功");
    public static final ResultObj DELETE_ERROR = new ResultObj(Contast.Error, "删除失败");

    public static final ResultObj DISPATCH_SUCCESS= new ResultObj(Contast.OK, "分配成功");
    public static final ResultObj DISPATCH_ERROR = new ResultObj(Contast.Error, "分配失败");


    private Integer code;

    private String msg;
}
