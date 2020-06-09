package com.sxt.office.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tanghua
 * @Date: 2020/5/27 9:58
 * @Version 1.0
 */
public class TreeNodeBuilder {

    /**
     * 讲左菜单列表变成有层级关系的
     */

    public static List<TreeNode> build(List<TreeNode> treeNodes, Integer topPid) {
        List<TreeNode> nodes = new ArrayList<>();

        for (TreeNode no1 : treeNodes) {

            // 循环第一遍，找出topPid对应的，即 1 = menu 的菜单
            if (no1.getParentId() == topPid) {
                nodes.add(no1);
            }

            // 再次循环，找出对应id下的子节点
            for (TreeNode no2 : treeNodes) {
                if (no1.getId() == no2.getParentId()) {
                    no1.getChildren().add(no2);
                }
            }

        }


        return nodes;

    }
}
