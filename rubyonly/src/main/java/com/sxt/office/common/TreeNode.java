package com.sxt.office.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tanghua
 * @Date: 2020/5/27 9:41
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    private Integer id;
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;

    private List<TreeNode> children = new ArrayList<>();


    /**
     *  左侧菜单栏
     * @param id
     * @param pid
     * @param title
     * @param icon
     * @param href
     * @param spread
     */
    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }
}
