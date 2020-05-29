package com.sxt.office.vo;

import com.sxt.office.domain.Notice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author tanghua
 * @Date: 2020/5/27 14:30
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends Notice {

    private static final long serialVersionUID = 3575546286426311467L;
    private Integer limit = 10;
    private Integer page = 1;

    private Integer[] ids;

    /**
     *  开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     *  结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
