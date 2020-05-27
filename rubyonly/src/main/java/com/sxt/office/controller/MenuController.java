package com.sxt.office.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.office.common.*;
import com.sxt.office.domain.Permission;
import com.sxt.office.domain.User;
import com.sxt.office.service.PermissionService;
import com.sxt.office.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  菜单前端控制器
 * </p>
 *
 * @author rubyonly
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping("loadIndexLeftMenuJson")
    private DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo) {

        // 查询所有菜单
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();

        // 设置只查询menu
        queryWrapper.eq("type", Contast.MENU_TYPE_MENU);  //目录为menu
        queryWrapper.eq("available", Contast.MENU_AVAILABLE_TRUE);  //可用

        //获取用户信息
        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if (user.getType() == Contast.USER_TYPE_SUPER) {

            list = permissionService.list(queryWrapper);

        }else{
            // TODO 根据用户角色ID+权限去查
            list = permissionService.list(queryWrapper);
        }
        // 循环permission表，放到treeNodes 进行处理
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : list) {

            Integer id = permission.getId();
            Integer pid = permission.getPid();
            String title = permission.getTitle();
            String icon = permission.getIcon();
            String href = permission.getHref();
            Boolean spread = permission.getOpen() == Contast.OPEN_TRUE ? true : false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));

        }
        // 将list变成有层级关系的
        List<TreeNode> nodeList = TreeNodeBuilder.build(treeNodes, 1);

        return new DataGridView(nodeList);
    }



}

