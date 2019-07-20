package com.buddhist.user.mapper;

import com.buddhist.user.model.OrderForm;
import com.buddhist.user.model.OrderFormExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormMapper
{
    long countByExample(OrderFormExample example);

    int deleteByExample(OrderFormExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    List<OrderForm> selectByExample(OrderFormExample example);

    OrderForm selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);

    /*
     * 根据条件传入并进行查询符合条件的订单信息
     * */
    List<OrderForm> selectOrderFormByCondition(OrderForm orderForm);

    /*
     * 根据施主id和被指定与否以及回复是否为空字符串查询所有满足条件的订单信息
     * */
    List<OrderForm> selectOrderFormBySIdAndMessageAndFlag(OrderForm orderForm);
}