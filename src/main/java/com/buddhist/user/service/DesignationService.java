package com.buddhist.user.service;

import com.buddhist.user.model.Designation;

import java.util.List;

/*
 * 佛事信息业务层接口
 * */
public interface DesignationService
{
    /*
     * 添加佛事信息
     * */
    void insertDesignation(Designation designation);

    /*
     * 根据id删除佛事信息
     * */
    void deleteDesignationById(Integer id);

    /*
     * 修改佛事信息
     * */
    void updateDesignation(Designation designation);

    /*
     * 根据id查询佛事信息
     * */
    Designation selectDesignationById(Integer id);

    /*
     * 根据佛事分类查询佛事信息
     * */
    List<Designation> selectDesignationByCId(Integer cid);
}
