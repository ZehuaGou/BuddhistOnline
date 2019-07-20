package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.InventoryMapper;
import com.buddhist.user.model.Designation;
import com.buddhist.user.model.Inventory;
import com.buddhist.user.model.InventoryExample;
import com.buddhist.user.model.User;
import com.buddhist.user.service.DesignationService;
import com.buddhist.user.service.InventoryService;
import com.buddhist.user.service.OrderFormService;
import com.buddhist.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 修士或施主发布的清单信息业务层实现类
 * */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService
{
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private DesignationService designationService; //注入佛事内容Service

    @Autowired
    private UserService userService; //注入用户业务层Service

    @Autowired
    private OrderFormService orderFormService; //注入订单业务层Service

    /*
     * 添加清单信息
     * */
    @Override
    public void insertInventory(Inventory inventory)
    {
        //插入与清单关联的佛事内容，并得到佛事内容id
        designationService.insertDesignation(inventory.getDesignation());

        //将佛事内容id放入清单信息中
        inventory.setDid(inventory.getDesignation().getDid());

        //添加此清单信息
        inventoryMapper.insert(inventory);
    }

    /*
     * 根据id删除清单信息以及与之关联的佛事信息
     * */
    @Override
    public void deleteInventoryAndDesignationById(Integer id)
    {
        //查询此id清单信息
        Inventory inventory = selectInventoryById(id);

        //删除和此清单信息关联的佛事信息
        designationService.deleteDesignationById(inventory.getDid());

        //删除此清单信息
        inventoryMapper.deleteByPrimaryKey(id);
    }

    /*
     * 根据id删除清单信息以及与之关联的订单信息和佛事内容信息
     * */
    @Override
    public void deleteInventoryAndOrderFormAndDesignationById(Integer id)
    {
        //查询此id清单信息
        Inventory inventory = selectInventoryById(id);

        //删除和此清单信息相关联的订单信息
        orderFormService.deleteOrderFormByDId(inventory.getDid());

        //删除和此清单信息关联的佛事信息
        designationService.deleteDesignationById(inventory.getDid());

        //删除此清单信息
        inventoryMapper.deleteByPrimaryKey(id);
    }

    /*
     * 修改清单信息
     * */
    @Override
    public void updateInventory(Inventory inventory)
    {
        //根据清单id查询此清单信息
        Inventory inventoryTemp = selectInventoryById(inventory.getIid());
        //得到清单对象中佛事信息对象
        Designation designation = inventory.getDesignation();
        //将清单信息中佛事内容id放入佛事对象中
        designation.setDid(inventoryTemp.getDid());
        //修改佛事内容信息
        designationService.updateDesignation(designation);
        //修改清单信息
        inventoryMapper.updateByPrimaryKeySelective(inventory);
    }

    /*
     * 根据id查询清单信息
     * */
    @Override
    public Inventory selectInventoryById(Integer id)
    {
        InventoryExample example = new InventoryExample();
        InventoryExample.Criteria criteria = example.createCriteria();
        criteria.andIidEqualTo(id);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectByExample(example);

        if (inventoryList.size() > 0)
        {
            Inventory inventory = inventoryList.get(0);
            //根据佛事内容id查询佛事内容信息
            Designation designation = designationService.selectDesignationById(inventory.getDid());
            //将佛事内容对象放入清单对象中
            inventory.setDesignation(designation);

            //根据佛事内容查询发布佛事的用户信息
            User user = userService.selectUserById(inventory.getUid());
            //将用户对象放入清单对象中
            inventory.setUser(user);

            return inventory;
        }

        return null;
    }

    /*
     * 根据用户id查询清单信息
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByUId(int pageNum, int pageSize, Integer uid)
    {

        PageHelper.startPage(pageNum, pageSize, true);

        Inventory inventory = new Inventory();
        inventory.setUid(uid);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(inventory);

        return new PageInfo<>(inventoryList);

    }

    /*
     * 根据佛事id查询清单信息
     * */
    @Override
    public Inventory selectInventoryByDId(Integer did)
    {
        InventoryExample example = new InventoryExample();
        InventoryExample.Criteria criteria = example.createCriteria();
        criteria.andDidEqualTo(did);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectByExample(example);

        if (inventoryList.size() > 0)
        {
            Inventory inventory = inventoryList.get(0);
            //根据佛事内容id查询佛事内容信息
            Designation designation = designationService.selectDesignationById(inventory.getDid());
            //将佛事内容对象放入清单对象中
            inventory.setDesignation(designation);

            //根据用户id查找用户信息
            User user = userService.selectUserById(inventory.getUid());
            //将用户对象放入清单对象中
            inventory.setUser(user);

            return inventory;
        }

        return null;
    }

    /*
     * 根据是否自动指派查询满足条件的清单信息
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByAssign(int pageNum, int pageSize, String assign)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        Inventory inventory = new Inventory();
        inventory.setAssign(assign);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(inventory);

        return new PageInfo<>(inventoryList);

    }

    /*
     * 根据是否已经接单查询满足条件的清单信息
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByReceive(int pageNum, int pageSize, String receive)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        Inventory inventory = new Inventory();
        inventory.setReceive(receive);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(inventory);

        return new PageInfo<>(inventoryList);

    }

    /*
     * 根据用户id以及是否自动指派查询满足条件的清单信息
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByUIdAndAssign(int pageNum, int pageSize, Integer uid, String assign)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        Inventory inventory = new Inventory();
        inventory.setUid(uid);
        inventory.setAssign(assign);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(inventory);

        return new PageInfo<>(inventoryList);

    }

    /*
     * 根据用户id以及是否已经接单查询满足条件的清单信息
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByUIdAndReceive(int pageNum, int pageSize, Integer uid, String receive)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        Inventory inventory = new Inventory();
        inventory.setUid(uid);
        inventory.setReceive(receive);

        //查询满足条件的清单信息
        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(inventory);

        return new PageInfo<>(inventoryList);

    }

    /*
     * 根据发布清单者的身份以及清单类别，是否指定订单进行查询
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByIdentifyAndCIdAndReceive
    (int pageNum, int pageSize, String identify, Integer cid, String receive)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        List<Inventory> inventoryList =
                inventoryMapper.selectInventoryByIdentifyAndCIdAndReceive(identify, cid, receive);

        return new PageInfo<>(inventoryList);
    }

    /*
     * 根据最早时间进行从最早时间到最晚时间排序
     * 把时间最早的清单放在页面最前面
     * */
    @Override
    public PageInfo<Inventory> selectInventoryByEarlyTime(int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        List<Inventory> inventoryList = inventoryMapper.selectInventoryByCondition(null);

        return new PageInfo<>(inventoryList);
    }
}