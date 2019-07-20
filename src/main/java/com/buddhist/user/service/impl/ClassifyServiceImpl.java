package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.ClassifyMapper;
import com.buddhist.user.model.Classify;
import com.buddhist.user.model.ClassifyExample;
import com.buddhist.user.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 佛事分类业务层实现类
 * */
@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService
{
    @Autowired
    private ClassifyMapper classifyMapper;

    /*
     * 查询所有佛事分类
     * */
    @Override
    public List<Classify> selectAllClassify()
    {
        return classifyMapper.selectByExample(null);
    }

    /*
     * 根据id查询佛事分类信息
     * */
    @Override
    public Classify selectClassifyById(Integer id)
    {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();

        criteria.andCidEqualTo(id);

        List<Classify> classifyList = classifyMapper.selectByExample(example);

        if (classifyList.size() > 0)
        {
            return classifyList.get(0);
        }

        return null;
    }

    /*
     * 根据佛事分类名称查询佛事分类信息
     * */
    @Override
    public Classify selectClassifyByName(String name)
    {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(name);

        List<Classify> classifyList = classifyMapper.selectByExample(example);

        if (classifyList.size() > 0)
        {
            return classifyList.get(0);
        }

        return null;
    }

    /*
     * 根据类别一查询佛事分类信息
     * */
    @Override
    public List<Classify> selectClassifyByTypeOne(String typeOne)
    {
        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();

        criteria.andTypeOneEqualTo(typeOne);

        return classifyMapper.selectByExample(example);
    }
}
