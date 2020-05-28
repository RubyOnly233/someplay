package com.sxt.office.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.office.common.DataGridView;
import com.sxt.office.domain.Loginfo;
import com.sxt.office.service.LoginfoService;
import com.sxt.office.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rubyonly
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     *  全查询
     * @return
     */
    @RequestMapping("/loadAllLoginfo")
    private DataGridView loadAllLoginfo(LoginfoVo loginfoVo) {

        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(),loginfoVo.getLimit());

        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());

        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());

        queryWrapper.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());

        queryWrapper.le(loginfoVo.getEndTime() != null, "logintime", loginfoVo.getEndTime());

        queryWrapper.orderByDesc("logintime");

        loginfoService.page(page, queryWrapper);

        return new DataGridView(page.getTotal(),page.getRecords());
    }

}

