package com.sxt.office.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.office.common.DataGridView;
import com.sxt.office.common.ResultObj;
import com.sxt.office.domain.Notice;
import com.sxt.office.service.NoticeService;
import com.sxt.office.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rubyonly
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;


    /**
     *  系统公告全查询
     * @param noticeVo
     * @return
     */
    @RequestMapping("loadAllNotice")
    private DataGridView loadAllNotice(NoticeVo noticeVo) {

        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getContent()), "content", noticeVo.getContent());
        queryWrapper.ge(noticeVo.getStartTime() != null, "createtime", noticeVo.getCreatetime());
        queryWrapper.le(noticeVo.getEndTime() != null, "createtime", noticeVo.getCreatetime());

        queryWrapper.orderByDesc("createtime");

        IPage<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());

        noticeService.page(page,queryWrapper);

        return new DataGridView(page.getTotal(), page.getRecords());
    }


    /**
     *   删除
     * @param id
     * @return
     */
    @RequestMapping("deleteNotice")
    private ResultObj deleteNotice(Integer id) {

        try {

            noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {

            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }


    /**
     *  批量删除
     * @param noticeVo
     * @return
     */
    @RequestMapping("batchDeleteNotice")
    private ResultObj batchDeleteNotice(NoticeVo noticeVo) {

        try {

            ArrayList<Integer> list = new ArrayList();
            for (Integer id : noticeVo.getIds()) {
                list.add(id);
            }
            noticeService.removeByIds(list);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {

            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }

}

