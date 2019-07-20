package com.buddhist.user.controller;

import com.buddhist.user.model.Bill;
import com.buddhist.user.model.User;
import com.buddhist.user.service.BillService;
import com.buddhist.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 控制层对用户操作
 * */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService; //注入用户业务层对象

    @Autowired
    private BillService billService; //注入账单业务层对象

    /*
     * 跳转到注册页面
     * */
    @RequestMapping("/registered")
    public String registered() {
        return "user/registered";
    }

    /*
     * 通过ajax收到值后进行判断手机号是否被注册
     * */
    @RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkPhone(String phone) {
        Map<String, Object> resultMap = new HashMap<>();
        User user = userService.checkPhoneIfExist(phone);
        if (user == null) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "error");
        }

        return resultMap;
    }

    /*
     * 保存用户
     * */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        //注册时间
        user.setrTime(new Date());
        //施修单数
        user.setAcceptOrds(0);
        //施修星级
        user.setGrade(0);
        //施修总金额
        user.setAcceptMoney(new BigDecimal("0"));
        //布施单数
        user.setDonationOrds(0);
        //布施总金额
        user.setDonationMoney(new BigDecimal("0"));
        //添加user
        userService.insertUser(user);

        return "user/login";
    }

    /*
     * 跳转到登录页面
     * */
    @RequestMapping("/jumpLogin")
    public String jumpLogin() {
        return "user/login";
    }

    /*
     * 检查账号密码是否正确，并跳转页面
     * */
    @RequestMapping("/checkUser")
    public String checkUser(User user, HttpSession session, Model model) {
        User existUser = userService.checkPhoneAndPassword(user.getPhone(), user.getPassword());

        if (existUser != null) {
            session.setAttribute("existUser", existUser);
            return "redirect:/index";
        } else {
            model.addAttribute("message", "用户名或密码错误！");
            return "user/login";
        }
    }

    /*
     * 修改用户信息
     * */
    @RequestMapping("editUserInfo")
    public String editUserInfo(User user, HttpSession session) {
        userService.updateUser(user);
        User existUser = userService.selectUserById(user.getUid());
        session.setAttribute("existUser", existUser);

        return "redirect:/user/userInfo";
    }

    /*
     * 修改用户信息时检查手机号是否发生变动，
     * 如果发生了变动，就检查该手机号是否被注册
     * */
    @RequestMapping(value = "checkIfChangePhone", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkIfChangePhone(String phone, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();

        User existUser = (User) session.getAttribute("existUser");

        //如果手机号没改变就不检查该手机号是否被注册
        if (existUser.getPhone().equals(phone)) {
            resultMap.put("result", "success");
        } else {
            //如果手机号发生改变，就检查新手机号是否被注册
            User user = userService.checkPhoneIfExist(phone);

            if (user == null) {
                resultMap.put("result", "success");
            } else {
                resultMap.put("result", "error");
            }
        }

        return resultMap;
    }

    /*
     * 跳转到用户信息页面
     * */
    @RequestMapping("/userInfo/{pageNum}")
    public String userInfo(Model model, HttpSession session,
                           @PathVariable("pageNum") Integer pageNum) {
        User existUser = (User) session.getAttribute("existUser");
        existUser = userService.selectUserById(existUser.getUid());
        session.setAttribute("existUser", existUser);

        PageInfo<Bill> pageInfo =
                billService.selectBillByUId(pageNum, 5, existUser.getUid());

        List<Bill> billList = pageInfo.getList();


        model.addAttribute("billList", billList);
        model.addAttribute("pageInfo", pageInfo);

        return "user/userInfo";
    }

    /*
     * 跳转到修改用户信息页面
     * */
    @RequestMapping("/jumpEditUserInfo")
    public String jumpEditUserInfo() {
        return "user/editUserInfo";
    }

    /*
     * 注销用户
     * */
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request) {
        //注销session
        request.getSession().invalidate();

        return "redirect:/index";
    }

}
