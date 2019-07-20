package com.buddhist.user.service;

import com.buddhist.user.model.Classify;

import java.util.List;

/*
* 佛事分类业务层接口
* */
public interface ClassifyService
{
    /*
    * 查询所有佛事分类
    * */
    List<Classify> selectAllClassify();

    /*
    * 根据id查询佛事分类信息
    * */
    Classify selectClassifyById(Integer id);

    /*
    * 根据佛事分类名称查询佛事分类信息
    * */
    Classify selectClassifyByName(String name);

    /*
     * 根据类别一查询佛事分类信息
     * */
    List<Classify> selectClassifyByTypeOne(String typeOne);
}
