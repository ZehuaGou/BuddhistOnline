package com.buddhist.user.service.impl;

import com.buddhist.user.mapper.BillMapper;
import com.buddhist.user.model.Bill;
import com.buddhist.user.model.BillExample;
import com.buddhist.user.model.OrderForm;
import com.buddhist.user.service.BillService;
import com.buddhist.user.service.OrderFormService;
import com.buddhist.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 账单业务层实现类
 * */
@Service("billService")
public class BillServiceImpl implements BillService
{
    @Autowired
    private BillMapper billMapper;

    @Autowired
    private OrderFormService orderFormService; //注入订单Service

    @Autowired
    private UserService userService; //注入用户Service

    /*
     * 添加账单信息
     * */
    @Override
    public void insertBill(Bill bill)
    {
        billMapper.insert(bill);
    }

    /*
     * 根据id删除账单信息
     * */
    @Override
    public void deleteBillById(Integer id)
    {
        billMapper.deleteByPrimaryKey(id);
    }

    /*
     * 修改账单信息
     * */
    @Override
    public void updateBill(Bill bill)
    {
        billMapper.updateByPrimaryKeySelective(bill);
    }

    /*
     * 根据id查找账单信息
     * */
    @Override
    public Bill selectBillById(Integer id)
    {
        BillExample example = new BillExample();
        BillExample.Criteria criteria = example.createCriteria();

        criteria.andBidEqualTo(id);

        List<Bill> billList = billMapper.selectByExample(example);

        if (billList.size() > 0)
        {
            Bill bill = billList.get(0);
            OrderForm orderForm = orderFormService.selectOrderFormById(bill.getOid());

            bill.setOrderForm(orderForm);

            return bill;
        }

        return null;
    }

    /*
     * 根据用户id查找所有账单信息
     * */
    @Override
    public PageInfo<Bill> selectBillByUId(int pageNum, int pageSize, Integer uid)
    {
        PageHelper.startPage(pageNum, pageSize, true);

        Bill bill = new Bill();
        bill.setUid(uid);
        List<Bill> billList = billMapper.selectBillByCondition(bill);

        return new PageInfo<>(billList);

    }

    /*
     * 根据订单id查找账单信息
     * */
    @Override
    public Bill selectBillByOId(Integer oid)
    {
        BillExample example = new BillExample();
        BillExample.Criteria criteria = example.createCriteria();

        criteria.andOidEqualTo(oid);

        List<Bill> billList = billMapper.selectByExample(example);

        if (billList.size() > 0)
        {
            Bill bill = billList.get(0);

            bill = selectBillById(bill.getBid());

            return bill;
        }

        return null;
    }

    /*
     * 根据佛事id查找账单信息
     * */
    @Override
    public Bill selectBillByDId(Integer did)
    {
        BillExample example = new BillExample();
        BillExample.Criteria criteria = example.createCriteria();

        criteria.andDidEqualTo(did);

        List<Bill> billList = billMapper.selectByExample(example);

        if (billList.size() > 0)
        {
            Bill bill = billList.get(0);

            bill = selectBillById(bill.getBid());

            return bill;
        }

        return null;
    }

    /*
     * 交易完成，建立账单信息
     * */
    @Override
    public void buildBill(Bill donorBill, Bill monkBill, OrderForm orderForm)
    {
        //将评价，评分，以及已经完成进行修改
        orderFormService.updateOrderForm(orderForm);

        billMapper.insert(donorBill); //添加施主账单
        billMapper.insert(monkBill); //添加修士账单

        userService.updateUser(orderForm.getDonorUser()); //修改施主用户信息
        userService.updateUser(orderForm.getMonkUser()); //修改修士用户信息
    }
}
