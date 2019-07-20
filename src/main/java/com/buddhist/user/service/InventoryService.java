package com.buddhist.user.service;

import com.buddhist.user.model.Inventory;
import com.github.pagehelper.PageInfo;

/*
 * 修士或施主发布的清单信息业务层接口
 * */
public interface InventoryService
{
    /*
     * 添加清单信息
     * */
    void insertInventory(Inventory inventory);

    /*
     * 根据id删除清单信息以及与之关联的佛事信息
     * */
    void deleteInventoryAndDesignationById(Integer id);

    /*
     * 根据id删除清单信息以及与之关联的订单信息和佛事内容信息
     * */
    void deleteInventoryAndOrderFormAndDesignationById(Integer id);

    /*
     * 修改清单信息
     * */
    void updateInventory(Inventory inventory);

    /*
     * 根据id查询清单信息
     * */
    Inventory selectInventoryById(Integer id);

    /*
     * 根据用户id查询清单信息
     * */
    PageInfo<Inventory> selectInventoryByUId(int pageNum, int pageSize, Integer uid);

    /*
     * 根据佛事id查询清单信息
     * */
    Inventory selectInventoryByDId(Integer did);

    /*
     * 根据是否自动指派查询满足条件的清单信息
     * */
    PageInfo<Inventory> selectInventoryByAssign(int pageNum, int pageSize, String assign);

    /*
     * 根据是否已经接单查询满足条件的清单信息
     * */
    PageInfo<Inventory> selectInventoryByReceive(int pageNum, int pageSize, String receive);

    /*
     * 根据用户id以及是否自动指派查询满足条件的清单信息
     * */
    PageInfo<Inventory> selectInventoryByUIdAndAssign(int pageNum, int pageSize, Integer uid, String assign);

    /*
     * 根据用户id以及是否已经接单查询满足条件的清单信息
     * */
    PageInfo<Inventory> selectInventoryByUIdAndReceive(int pageNum, int pageSize, Integer uid, String receive);

    /*
    * 根据发布清单者的身份以及清单类别，是否指定订单进行查询
    * */
    PageInfo<Inventory> selectInventoryByIdentifyAndCIdAndReceive
    (int pageNum, int pageSize, String identify, Integer cid, String receive);

    /*
     * 根据最早时间进行从最早时间到最晚时间排序
     * 把时间最早的清单放在页面最前面
     * */
    PageInfo<Inventory> selectInventoryByEarlyTime(int pageNum, int pageSize);
}
