package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.OrderFormMapper;
import com.buddhist.user.model.Inventory;
import com.buddhist.user.model.OrderForm;
import com.buddhist.user.model.OrderFormExample;
import com.buddhist.user.model.User;
import com.buddhist.user.service.InventoryService;
import com.buddhist.user.service.OrderFormService;
import com.buddhist.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 订单业务层实现类
 * */
@Service("orderFormService")
public class OrderFormServiceImpl implements OrderFormService
{
    @Autowired
    private OrderFormMapper orderFormMapper;

    @Autowired
    private InventoryService inventoryService; //注入清单信息Service

    @Autowired
    private UserService userService; //注入用户Service

    /*
     * 添加订单信息
     * */
    @Override
    public void insertOrderForm(OrderForm orderForm)
    {
        inventoryService.updateInventory(orderForm.getInventory());

        orderFormMapper.insert(orderForm);
    }

    /*
     * 根据订单id删除订单信息
     * */
    @Override
    public void deleteOrderForm(Integer id)
    {
        orderFormMapper.deleteByPrimaryKey(id);
    }

    /*
     * 根据佛事id删除订单信息
     * */
    @Override
    public void deleteOrderFormByDId(Integer did)
    {
        OrderFormExample example = new OrderFormExample();
        OrderFormExample.Criteria criteria = example.createCriteria();
        criteria.andDidEqualTo(did);

        orderFormMapper.deleteByExample(example);
    }

    /*
     * 修改订单信息
     * */
    @Override
    public void updateOrderForm(OrderForm orderForm)
    {
        orderFormMapper.updateByPrimaryKeySelective(orderForm);
    }

    /*
     * 根据订单id查询订单信息
     * */
    @Override
    public OrderForm selectOrderFormById(Integer id)
    {
        OrderFormExample example = new OrderFormExample();
        OrderFormExample.Criteria criteria = example.createCriteria();

        criteria.andOidEqualTo(id);

        List<OrderForm> orderFormList = orderFormMapper.selectByExample(example);

        if (orderFormList.size() > 0)
        {
            OrderForm orderForm = orderFormList.get(0); //得到订单信息对象

            //得到施主信息对象
            User donorUser = userService.selectUserById(orderForm.getSid());
            //得到修士信息对象
            User monkUser = userService.selectUserById(orderForm.getXid());
            //得到清单信息对象
            Inventory inventory = inventoryService.selectInventoryByDId(orderForm.getDid());

            orderForm.setDonorUser(donorUser);
            orderForm.setMonkUser(monkUser);
            orderForm.setInventory(inventory);

            return orderForm;
        }

        return null;
    }

    /*
     * 根据施主id查询所有订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormBySId(int pageNum, int pageSize, Integer sid)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        OrderForm orderForm = new OrderForm();
        orderForm.setSid(sid);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);


        return new PageInfo<>(orderFormList);

    }

    /*
     * 根据修士id查询所有订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormByXId(int pageNum, int pageSize, Integer xid)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        OrderForm orderForm = new OrderForm();
        orderForm.setXid(xid);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);


        return new PageInfo<>(orderFormList);

    }

    /*
     * 根据佛事id查询所有有关的订单信息
     * */
    @Override
    public List<OrderForm> selectOrderFormByDId(Integer did)
    {
        OrderForm orderForm = new OrderForm();
        orderForm.setDid(did);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);

        if (orderFormList.size() > 0)
        {
            return orderFormList;
        }

        return null;
    }

    /*
     * 根据佛事id查询订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormByDId(int pageNum, int pageSize, Integer did)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        OrderForm orderForm = new OrderForm();
        orderForm.setDid(did);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);


        return new PageInfo<>(orderFormList);
    }

    /*
     * 根据施主id和完成与否查询所有满足条件的订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormBySIdAndFinish
    (int pageNum, int pageSize, Integer sid, String finish)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        OrderForm orderForm = new OrderForm();
        orderForm.setSid(sid);
        orderForm.setFinish(finish);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);


        return new PageInfo<>(orderFormList);
    }

    /*
     * 根据修士id和完成与否查询所有满足条件的订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormByXIdAndFinish
    (int pageNum, int pageSize, Integer xid, String finish)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        OrderForm orderForm = new OrderForm();
        orderForm.setXid(xid);
        orderForm.setFinish(finish);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);

        return new PageInfo<>(orderFormList);
    }

    /*
     * 根据施主id和被指定与否以及回复是否为空字符串查询所有满足条件的订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormBySIdAndMessageAndFlag
    (int pageNum, int pageSize, Integer sid)
    {
        PageHelper.startPage(pageNum, pageSize, true);
        OrderForm orderForm = new OrderForm();
        orderForm.setSid(sid);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormBySIdAndMessageAndFlag(orderForm);

        return new PageInfo<>(orderFormList);
    }

    /*
     * 根据修士id和被指定与否以及回复是否为空字符串查询所有满足条件的订单信息
     * */
    @Override
    public PageInfo<OrderForm> selectOrderFormByXIdAndMessageAndFlag
    (int pageNum, int pageSize, Integer xid)
    {
        PageHelper.startPage(pageNum, pageSize, true);
        OrderForm orderForm = new OrderForm();
        orderForm.setXid(xid);

        List<OrderForm> orderFormList = orderFormMapper.selectOrderFormByCondition(orderForm);

        return new PageInfo<>(orderFormList);
    }

    /*
     * 确认接受此订单
     * */
    @Override
    public void confirmOrderForm(OrderForm orderForm)
    {
        //先修改需求清单接受信息，以及接受时间
        inventoryService.updateInventory(orderForm.getInventory());
        //修改订单此状态
        orderFormMapper.updateByPrimaryKeySelective(orderForm);
    }
}