package com.buddhist.user.service;

import com.buddhist.user.model.OrderForm;
import com.github.pagehelper.PageInfo;

import java.util.List;

/*
 * 订单业务层接口
 * */
public interface OrderFormService
{
    /*
     * 添加订单信息
     * */
    void insertOrderForm(OrderForm orderForm);

    /*
     * 根据订单id删除订单信息
     * */
    void deleteOrderForm(Integer id);

    /*
     * 根据佛事id删除订单信息
     * */
    void deleteOrderFormByDId(Integer did);

    /*
     * 修改订单信息
     * */
    void updateOrderForm(OrderForm orderForm);

    /*
     * 根据订单id查询订单信息
     * */
    OrderForm selectOrderFormById(Integer id);

    /*
     * 根据施主id查询所有订单信息
     * */
    PageInfo<OrderForm> selectOrderFormBySId(int pageNum, int pageSize, Integer sid);

    /*
     * 根据修士id查询所有订单信息
     * */
    PageInfo<OrderForm> selectOrderFormByXId(int pageNum, int pageSize, Integer xid);

    /*
     * 根据佛事id查询所有有关的订单信息
     * */
    List<OrderForm> selectOrderFormByDId(Integer did);

    /*
     * 根据佛事id分页查询所有有关的订单信息
     * */
    PageInfo<OrderForm> selectOrderFormByDId(int pageNum, int pageSize, Integer did);

    /*
     * 根据施主id和完成与否查询所有满足条件的订单信息
     * */
    PageInfo<OrderForm> selectOrderFormBySIdAndFinish
    (int pageNum, int pageSize, Integer sid, String finish);

    /*
     * 根据修士id和完成与否查询所有满足条件的订单信息
     * */
    PageInfo<OrderForm> selectOrderFormByXIdAndFinish
    (int pageNum, int pageSize, Integer xid, String finish);

    /*
     * 根据施主id和被指定与否以及回复是否为空字符串查询所有满足条件的订单信息
     * */
    PageInfo<OrderForm> selectOrderFormBySIdAndMessageAndFlag
    (int pageNum, int pageSize, Integer sid);

    /*
     * 根据修士id和被指定与否以及回复是否为空字符串查询所有满足条件的订单信息
     * */
    PageInfo<OrderForm> selectOrderFormByXIdAndMessageAndFlag
    (int pageNum, int pageSize, Integer xid);

    /*
    * 确认接受此订单
    * */
    void confirmOrderForm(OrderForm orderForm);
}
