package com.buddhist.user.service;

import com.buddhist.user.model.Bill;
import com.buddhist.user.model.OrderForm;
import com.github.pagehelper.PageInfo;

/*
 * 账单业务层接口
 * */
public interface BillService
{
    /*
     * 添加账单信息
     * */
    void insertBill(Bill bill);

    /*
     * 根据id删除账单信息
     * */
    void deleteBillById(Integer id);

    /*
     * 修改账单信息
     * */
    void updateBill(Bill bill);

    /*
     * 根据id查找账单信息
     * */
    Bill selectBillById(Integer id);

    /*
     * 根据用户id查找所有账单信息
     * */
    PageInfo<Bill> selectBillByUId(int pageNum, int pageSize, Integer uid);

    /*
     * 根据订单id查找账单信息
     * */
    Bill selectBillByOId(Integer oid);

    /*
     * 根据佛事id查找账单信息
     * */
    Bill selectBillByDId(Integer did);

    /*
     * 交易完成，建立账单信息
     * */
    void buildBill(Bill donorBill, Bill monkBill, OrderForm orderForm);
}
