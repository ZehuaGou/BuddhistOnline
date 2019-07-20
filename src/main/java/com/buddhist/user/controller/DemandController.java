package com.buddhist.user.controller;

import com.buddhist.user.model.Designation;
import com.buddhist.user.model.Inventory;
import com.buddhist.user.model.User;
import com.buddhist.user.service.InventoryService;
import com.github.pagehelper.PageInfo;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
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

/*
 * 控制层对清单需求进行操作
 * */
@Controller
@RequestMapping("/demand")
public class DemandController {
    @Autowired
    private InventoryService inventoryService; //注入清单业务层对象

    /*
     * 跳转到清单列表页面
     * */
    @RequestMapping("/jumpDemandList/{cid}/{pageNum}")
    public String jumpDemandList(HttpSession session, Model model,
                                 @PathVariable("cid") Integer cid,
                                 @PathVariable("pageNum") Integer pageNum) {
        User existUser = (User) session.getAttribute("existUser");

        List<Inventory> inventoryList = null;
        PageInfo<Inventory> pageInfo = null;

        String identify = existUser.getIdentify();

        //如果是修士，就显示用户发布的需求
        if (identify.equals("X")) {
            pageInfo =
                    inventoryService.selectInventoryByIdentifyAndCIdAndReceive(pageNum, 10, "Y", cid, "N");

            inventoryList = pageInfo.getList();
        } else if (identify.equals("Y")) {
            //如果是用户，就显示修士发布的清单需求
            pageInfo =
                    inventoryService.selectInventoryByIdentifyAndCIdAndReceive(pageNum, 10, "X", cid, "N");

            inventoryList = pageInfo.getList();
        }

        model.addAttribute("inventoryList", inventoryList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("cid", cid);


        return "user/demandList";
    }

    /*
     * 跳转到清单详情页面
     * */
    @RequestMapping("/jumpDemandDetails/{iid}")
    public String jumpDemandDetails(@PathVariable("iid") Integer iid, Model model) {
        Inventory inventory = inventoryService.selectInventoryById(iid);

        model.addAttribute("inventory", inventory);

        return "user/demandDetails";
    }

    /*
     * 跳转到发布需求页面
     * */
    @RequestMapping("/jumpAddDemand")
    public String jumpAddDemand() {
        return "user/addDemand";
    }

    /*
     * 通过json传值并保存需求信息
     * */
    @RequestMapping("/addDemand")
    @ResponseBody
    public String addDemand(@RequestBody String returnVal, HttpSession session) {
        //将returnVal转化成json类型数据
        JSONObject jsonObject = JSONObject.fromObject(returnVal);

        //取得json数据中designation数据
        JSONObject jsonDesignation = jsonObject.getJSONObject("designation");
        String[] dateFormats = new String[]{"yyyy-MM-dd HH:mm:ss"};
        //处理时间避免获取当前系统时间——原因JSONObject不能识别“yyyy-MM-dd”的格式
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        Designation designation = (Designation) JSONObject.toBean(jsonDesignation, Designation.class);
        User existUser = (User) session.getAttribute("existUser");

        JSONObject jsonInventory = jsonObject.getJSONObject("inventory");
        Inventory inventory = (Inventory) JSONObject.toBean(jsonInventory, Inventory.class);
        inventory.setUid(existUser.getUid());
        inventory.setReceive("N");
        inventory.setPublishTime(new Date());
        inventory.setDesignation(designation);

        inventoryService.insertInventory(inventory);

        return "/index";
    }

    /*
     * 跳转到我的需求页面
     * */
    @RequestMapping("/jumpMyDemandList/{pageNum}")
    public String jumpMyDemandList(HttpSession session, Model model,
                                   @PathVariable("pageNum") Integer pageNum) {
        User existUser = (User) session.getAttribute("existUser");
        PageInfo<Inventory> pageInfo =
                inventoryService.selectInventoryByUId(pageNum, 10, existUser.getUid());
        List<Inventory> inventoryList = pageInfo.getList();

        model.addAttribute("inventoryList", inventoryList);
        model.addAttribute("pageInfo", pageInfo);

        return "user/myDemandList";
    }

    /*
     * 跳转到登录用户的需求清单详细页面
     * */
    @RequestMapping("/jumpEditDemandDetails/{iid}")
    public String jumpEditDemandDetails(@PathVariable("iid") Integer iid, Model model) {
        Inventory inventory = inventoryService.selectInventoryById(iid);

        model.addAttribute("inventory", inventory);

        return "user/editDemandDetails";
    }

    /*
     * 用户修改需求后提交
     * */
    @RequestMapping("/updateDemand")
    @ResponseBody
    public String updateDemand(@RequestBody String returnVal) {
        //将returnVal转化成json类型数据
        JSONObject jsonObject = JSONObject.fromObject(returnVal);

        //取得json数据中designation数据
        JSONObject jsonDesignation = jsonObject.getJSONObject("designation");
        String[] dateFormats = new String[]{"yyyy-MM-dd HH:mm:ss"};
        //处理时间避免获取当前系统时间——原因JSONObject不能识别“yyyy-MM-dd”的格式
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        Designation designation = (Designation) JSONObject.toBean(jsonDesignation, Designation.class);

        JSONObject jsonInventory = jsonObject.getJSONObject("inventory");
        Inventory inventory = (Inventory) JSONObject.toBean(jsonInventory, Inventory.class);

        inventory.setDesignation(designation);

        inventoryService.updateInventory(inventory);

        return "/demand/jumpMyDemandList/1";
    }

    /*
     * 用户本人删除某一条需求信息
     * */
    @RequestMapping("/deleteMyDemandDetails/{iid}")
    public String deleteMyDemandDetails(@PathVariable("iid") Integer iid) {
        inventoryService.deleteInventoryAndOrderFormAndDesignationById(iid);

        return "redirect:/demand/jumpMyDemandList/1";
    }
}
