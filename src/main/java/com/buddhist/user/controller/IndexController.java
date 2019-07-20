package com.buddhist.user.controller;

import com.buddhist.user.model.Classify;
import com.buddhist.user.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController
{
    @Autowired
    private ClassifyService classifyService;

    /*
     * 进入首页
     * */
    @RequestMapping(value = "/index")
    public String index(Model model)
    {
        //根据一级分类查找相应的所有二级分类
        List<Classify> templeTypeList = classifyService.selectClassifyByTypeOne("寺院佛事");
        List<Classify> personalTypeList = classifyService.selectClassifyByTypeOne("个人修持佛事");
        List<Classify> otherTypeList = classifyService.selectClassifyByTypeOne("其他佛事");

        Map<String, Object> typeListMap = new HashMap<>();

        //将查找到的二级分类存入Map
        typeListMap.put("templeTypeList", templeTypeList);
        typeListMap.put("personalTypeList", personalTypeList);
        typeListMap.put("otherTypeList", otherTypeList);

        model.addAllAttributes(typeListMap);

        return "user/index";
    }
}
