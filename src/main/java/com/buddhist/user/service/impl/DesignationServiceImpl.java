package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.DesignationMapper;
import com.buddhist.user.model.Classify;
import com.buddhist.user.model.Designation;
import com.buddhist.user.model.DesignationExample;
import com.buddhist.user.service.ClassifyService;
import com.buddhist.user.service.DesignationService;
import com.buddhist.user.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 佛事信息业务层实现类
 * */
@Service("designationService")
public class DesignationServiceImpl implements DesignationService
{
    @Autowired
    private DesignationMapper designationMapper;

    @Autowired
    private ClassifyService classifyService; //注入分类业务层对象

    @Autowired
    private InventoryService inventoryService; //注入清单业务层对象

    /*
     * 添加佛事信息
     * */
    @Override
    public void insertDesignation(Designation designation)
    {
        designationMapper.insert(designation);
    }

    /*
     * 根据id删除佛事信息
     * */
    @Override
    public void deleteDesignationById(Integer id)
    {
        designationMapper.deleteByPrimaryKey(id);
    }

    /*
     * 修改佛事信息
     * */
    @Override
    public void updateDesignation(Designation designation)
    {
        designationMapper.updateByPrimaryKeySelective(designation);
    }

    /*
     * 根据id查询佛事信息
     * */
    @Override
    public Designation selectDesignationById(Integer id)
    {
        DesignationExample example = new DesignationExample();
        DesignationExample.Criteria criteria = example.createCriteria();

        criteria.andDidEqualTo(id);

        List<Designation> designationList = designationMapper.selectByExample(example);

        if (designationList.size() > 0)
        {
            Designation designation = designationList.get(0);

            Classify classify = classifyService.selectClassifyById(designation.getCid());

            designation.setClassify(classify);

            return designation;
        }

        return null;
    }

    /*
     * 根据佛事分类查询佛事信息
     * */
    @Override
    public List<Designation> selectDesignationByCId(Integer cid)
    {
        DesignationExample example = new DesignationExample();
        DesignationExample.Criteria criteria = example.createCriteria();

        criteria.andCidEqualTo(cid);

        List<Designation> designationList = designationMapper.selectByExample(example);

        if (designationList.size() > 0)
        {
            return designationList;
        }

        return null;
    }
}
