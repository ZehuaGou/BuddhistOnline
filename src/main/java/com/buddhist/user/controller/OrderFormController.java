package com.buddhist.user.controller;

import com.buddhist.user.model.Inventory;
import com.buddhist.user.model.OrderForm;
import com.buddhist.user.model.User;
import com.buddhist.user.service.InventoryService;
import com.buddhist.user.service.OrderFormService;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orderForm")
public class OrderFormController {
    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private InventoryService inventoryService; //注入订单业务层对象

    /*
     * 跳转到下订单页面
     * */
    @RequestMapping("/jumpAddOrderForm/{iid}")
    public String jumpAddOrderForm(@PathVariable("iid") Integer iid, Model model) {
        Inventory inventory = inventoryService.selectInventoryById(iid);

        model.addAttribute("inventory", inventory);

        return "user/addOrderForm";
    }

    /*
     * 添加订单，并返回我的订单页面
     * */
    @RequestMapping("/addOrderForm")
    public String addOrderForm(OrderForm orderForm) {
        //先更改清单的状态
        Inventory inventory = inventoryService.selectInventoryByDId(orderForm.getDid());
        inventory.setReceiveTime(new Date()); //接受日期

        orderForm.setFinish("N"); //是否完成置为否
        orderForm.setGrade(0); //评价置为0
        orderForm.setFlag("N"); //是否被指定设置为否
        orderForm.setMessage("");
        orderForm.setInventory(inventory);

        orderFormService.insertOrderForm(orderForm);

        return "redirect:/orderForm/jumpOrderFormList/1";
    }

    /*
     * 跳转到我的订单页面
     * */
    @RequestMapping("/jumpOrderFormList/{pageNum}")
    public String jumpOrderFormList
    (HttpSession session, Model model, @PathVariable("pageNum") Integer pageNum) {
        User existUser = (User) session.getAttribute("existUser");
        String identify = existUser.getIdentify();
        int uid = existUser.getUid();

        PageInfo<OrderForm> pageInfo = null;
        List<OrderForm> orderFormList = null;

        //如果登录者身份为修士则调用修士查询方法
        if (identify.equals("X")) {
            pageInfo =
                    orderFormService.selectOrderFormByXIdAndMessageAndFlag
                            (pageNum, 10, uid);
            orderFormList = pageInfo.getList();
        } else if (identify.equals("Y")) {
            //如果登录者身份为施主则调用施主查询方法
            pageInfo =
                    orderFormService.selectOrderFormBySIdAndMessageAndFlag
                            (pageNum, 10, uid);
            orderFormList = pageInfo.getList();
        }

        model.addAttribute("orderFormList", orderFormList);
        model.addAttribute("pageInfo", pageInfo);

        return "user/orderFormList";
    }

    /*
     * 删除订单，并跳转到我的订单页面
     * */
    @RequestMapping("/deleteOrderForm/{oid}")
    public String deleteOrderForm(@PathVariable("oid") Integer oid) {
        orderFormService.deleteOrderForm(oid);

        return "redirect:/orderForm/jumpOrderFormList/1";
    }

    /*
     * 跳转到某一订单详情页
     * */
    @RequestMapping("/jumpOrderFormDetails/{oid}")
    public String jumpOrderFormDetails(@PathVariable("oid") Integer oid, Model model) {
        OrderForm orderForm = orderFormService.selectOrderFormById(oid);
        model.addAttribute("orderForm", orderForm);

        return "user/orderFormDetails";
    }

    /*
     * 确认接受此订单
     * */
    @RequestMapping("/confirmOrderForm")
    @ResponseBody
    public String confirmOrderForm(@RequestBody String returnVal) {
        //将returnVal转化成json类型数据
        JSONObject jsonObject = JSONObject.fromObject(returnVal);

        //取得json数据中orderForm数据
        JSONObject jsonOrderForm = jsonObject.getJSONObject("orderForm");
        OrderForm orderForm = (OrderForm) JSONObject.toBean(jsonOrderForm, OrderForm.class);

        Integer oid = orderForm.getOid();
        String message = orderForm.getMessage();
        Integer did = orderForm.getDid();

        Inventory inventory = inventoryService.selectInventoryByDId(did);

        inventory.setReceive("Y");
        inventory.setConfirmTime(new Date());

        List<OrderForm> orderFormList = orderFormService.selectOrderFormByDId(did);

        //对其余没被指定订单修改回复信息
        for (OrderForm orderFormTemp : orderFormList) {
            orderFormTemp.setMessage(message);
            orderFormTemp.setFlag("Y");
            orderFormService.updateOrderForm(orderFormTemp);
        }

        orderForm.setMessage("");
        orderForm.setInventory(inventory);

        orderFormService.confirmOrderForm(orderForm);

        return "/orderForm/jumpOrderFormDetails/" + oid;
    }

    /*
     * 修改订单详情
     * */
    @RequestMapping("/updateOrderForm")
    @ResponseBody
    public String updateOrderForm(@RequestBody String returnVal) {
        //将returnVal转化成json类型数据
        JSONObject jsonObject = JSONObject.fromObject(returnVal);

        //取得json数据中orderForm数据
        JSONObject jsonOrderForm = jsonObject.getJSONObject("orderForm");
        OrderForm orderForm = (OrderForm) JSONObject.toBean(jsonOrderForm, OrderForm.class);

        orderFormService.updateOrderForm(orderForm);

        Integer oid = orderForm.getOid();

        return "/orderForm/jumpOrderFormDetails/" + oid;
    }
}
