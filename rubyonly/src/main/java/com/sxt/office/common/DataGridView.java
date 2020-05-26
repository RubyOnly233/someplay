package com.sxt.office.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author tanghua
 * @Date: 2020/5/26 11:19      JSON数据实体
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGridView {

    private Integer code = 0;
    private String msg = "";
    private Long count = 0L;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}
