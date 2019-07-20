package com.buddhist.user.controller;

import com.buddhist.user.model.Classify;
import com.buddhist.user.service.ClassifyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/classify")
public class ClassifyController
{
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("/searchTwoType")
    @ResponseBody
    public String searchTwoType(HttpServletResponse response, String type)
    {
        List<Classify> classifyList;

        switch (type)
        {
            case "1":
                classifyList = classifyService.selectClassifyByTypeOne("寺院佛事");
                break;
            case "2":
                classifyList = classifyService.selectClassifyByTypeOne("其他佛事");
                break;
            default:
                classifyList = classifyService.selectClassifyByTypeOne("个人修持佛事");
                break;
        }

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;

        for (Classify classify : classifyList)
        {
            jsonObject = new JSONObject();

            jsonObject.put("cid", classify.getCid());
            jsonObject.put("name", classify.getName());

            jsonArray.add(jsonObject);
        }

        try
        {
            PrintWriter out = response.getWriter();
            out.print(jsonArray.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
