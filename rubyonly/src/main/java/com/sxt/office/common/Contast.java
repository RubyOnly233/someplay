package com.sxt.office.common;


/**
 * @Author tanghua
 * @Date: 2020/1/14 11:41
 * @Version 1.0
 */
public interface Contast {

    /**
     *  状态码
     */

    public static final Integer OK = 200;
   public static final Integer Error = -1;

    /**
     * 是否可用
     */
   public static final Integer MENU_AVAILABLE_TRUE = 1;
   public static final Integer MENU_AVAILABLE_FALSE = 0;

    /**
     * 菜单管理
     */
   public static final String MENU_TYPE_MENU = "menu";
   public static final String MENU_TYPE_PERMISSION = "permission";

    /**
     * 展开类型
     */
   public static final Integer OPEN_TRUE = 1;
   public static final Integer OPEN_FALSE = 0;


    /**
     * 用户类型
     */
    public static final Integer USER_TYPE_SUPER = 0;
    public static final Integer USER_TYPE_NORMAL = 1;
}
