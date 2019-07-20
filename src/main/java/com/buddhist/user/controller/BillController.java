package com.buddhist.user.controller;

import com.buddhist.user.model.Bill;
import com.buddhist.user.model.OrderForm;
import com.buddhist.user.model.User;
import com.buddhist.user.service.BillService;
import com.buddhist.user.service.OrderFormService;
import com.buddhist.user.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/bill")
public class BillController
{
    @Autowired
    private BillService billService;

    @Autowired
    private OrderFormService orderFormService; //自动注入订单业务层对象

    @Autowired
    private UserService userService; //自动注入用户业务层对象

    /*
     * 新增账单，并跳转到个人信息页面
     * */
    @RequestMapping("/addBill")
    @ResponseBody
    public String addBill(@RequestBody String returnVal)
    {
        //将returnVal转化成json类型数据
        JSONObject jsonObject = JSONObject.fromObject(returnVal);

        //取得json数据中orderForm数据
        JSONObject jsonOrderForm = jsonObject.getJSONObject("orderForm");
        OrderForm orderFormTemp = (OrderForm) JSONObject.toBean(jsonOrderForm, OrderForm.class);

        //取得json数据中施主账单数据
        JSONObject jsonBill = jsonObject.getJSONObject("bill");
        Bill donorBill = (Bill) JSONObject.toBean(jsonBill, Bill.class);

        Integer oid = orderFormTemp.getOid();
        OrderForm orderForm = orderFormService.selectOrderFormById(oid);

        orderForm.setFinish("Y"); //订单状态设置为完成
        orderForm.setGrade(orderFormTemp.getGrade()); //设置评分
        orderForm.setEvaluate(orderFormTemp.getEvaluate()); //设置评价

        BigDecimal price = orderForm.getInventory().getDesignation().getPrice();
        Integer sid = orderForm.getSid(); //获得施主id
        donorBill.setReality(price); //设置最终交易金额
        donorBill.setPrice(price); //设置单次价格
        donorBill.setIdentify("Y"); //设置身份为施主
        donorBill.setUid(sid); //设置施主id

        Integer did = donorBill.getDid(); //获得佛事信息id
        Integer xid = orderForm.getXid(); //获得修士id
        String explain = donorBill.getExplain(); //获得特殊要求内容

        Bill monkBill = new Bill(); //修士账单
        monkBill.setUid(xid); //设置修士id
        monkBill.setOid(oid); //设置订单id
        monkBill.setDid(did); //设置佛事内容id
        monkBill.setIdentify("X"); //设置修士身份
        monkBill.setPrice(price); //设置单次价格
        monkBill.setReality(price); //设置最终价格
        monkBill.setExplain(explain); //设置特殊要求

        User donorUser = userService.selectUserById(sid); //获得施主用户对象
        User monkUser = userService.selectUserById(xid); //获得修士用户对象

        donorUser.setDonationOrds(donorUser.getDonationOrds() + 1); //施主布施单数加1
        donorUser.setDonationMoney(donorUser.getDonationMoney().add(price)); //设置施主布施总金额

        monkUser.setAcceptOrds(monkUser.getAcceptOrds() + 1); //修士施修单数加1
        monkUser.setAcceptMoney(monkUser.getAcceptMoney().add(price)); //设置修士施修总金额

        int grade = orderForm.getGrade(); //得到此订单打分数据

        monkUser.setGrade(monkUser.getGrade() + grade); //设置修士总评分

        orderForm.setDonorUser(donorUser); //设置施主用户信息
        orderForm.setMonkUser(monkUser); //设置修士用户信息

        billService.buildBill(donorBill, monkBill, orderForm);

        return "/user/userInfo/1";
    }
}