package com.sxt.office.vo;

import com.sxt.office.domain.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @Author tanghua
 * @Date: 2020/5/27 14:30
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends Dept {

    private static final long serialVersionUID = 3575546286426311467L;
    private Integer limit = 10;
    private Integer page = 1;


}
