package com.buddhist.user.mapper;

import com.buddhist.user.model.Designation;
import com.buddhist.user.model.DesignationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * 佛事内容实体类
 * */
public interface DesignationMapper {
    long countByExample(DesignationExample example);

    int deleteByExample(DesignationExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Designation record);

    int insertSelective(Designation record);

    List<Designation> selectByExample(DesignationExample example);

    Designation selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Designation record, @Param("example") DesignationExample example);

    int updateByExample(@Param("record") Designation record, @Param("example") DesignationExample example);

    int updateByPrimaryKeySelective(Designation record);

    int updateByPrimaryKey(Designation record);
}