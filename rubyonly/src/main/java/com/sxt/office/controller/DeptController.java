package com.sxt.office.controller;


import com.sxt.office.common.DataGridView;
import com.sxt.office.common.TreeNode;
import com.sxt.office.domain.Dept;
import com.sxt.office.service.DeptService;
import com.sxt.office.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rubyonly
 * @since 2020-06-08
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    /**
     *   加载部门管理左菜单栏
     * @param deptVo
     * @return
     */
    @RequestMapping("loadDeptManagerLeftJson")
    private DataGridView loadDeptManagerLeftJson(DeptVo deptVo) {

        List<Dept> list = deptService.list();

        List<TreeNode> treeNodes = new ArrayList<>();

        for (Dept dept : list) {
            Boolean spread = dept.getOpen() == 1 ? true : false;
            treeNodes.add(new TreeNode(dept.getId(), dept.getPid(), dept.getTitle(), spread));
        }
        DataGridView dataGridView = new DataGridView(treeNodes);


        return dataGridView;
    }

}

