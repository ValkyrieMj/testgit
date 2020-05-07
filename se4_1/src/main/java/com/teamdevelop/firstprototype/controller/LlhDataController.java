package com.teamdevelop.firstprototype.controller;

import com.teamdevelop.firstprototype.LiveDataOne;
import com.teamdevelop.firstprototype.RequestData;
import com.teamdevelop.firstprototype.entity.LiveliHoodInfo;
import com.teamdevelop.firstprototype.service.LiveliHoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @classname: LlhDataController
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/5 10:28
 * @description: 处理关于民生数据的请求，根据不同需求返回特定的信息，需求中设定了当前日期为20181030
 *               为了简化开发，直接在系统中设置了默认时间为：20181030
 */

@RestController
public class LlhDataController
{
    @Autowired
    LiveliHoodService liveliHoodService;

    @CrossOrigin

    // 功能一，按日期查询某一日期的民生数据
    @RequestMapping(value = "api/query1")
    public List<Map<String, Object>>question1(@RequestBody RequestData date)
    {
        String dateBegin = date.getDateBegin();
        String dateEnd = date.getDateEnd();


        if( dateBegin == null || dateEnd == null )
            return liveliHoodService.question1("20181030","20181030");
        else
            return liveliHoodService.question1(dateBegin, dateEnd);
    }

    @RequestMapping(value = "api/query2")
    public List<Map<String, Object>>question2(@RequestBody RequestData date)
    {
        String dateBegin = date.getDateBegin();
        String dateEnd = date.getDateEnd();
        if( dateBegin == null || dateEnd == null )
            return liveliHoodService.question2("20181030","20181030");
        else
            return liveliHoodService.question2(dateBegin, dateEnd);
    }

    @RequestMapping(value = "api/query3")
    public List<Map<String, Object>>question3(@RequestBody RequestData date)
    {
        String dateBegin = date.getDateBegin();
        String dateEnd = date.getDateEnd();
        if( dateBegin == null || dateEnd == null )
            return liveliHoodService.question3("20181030","20181030");
        else
            return liveliHoodService.question3(dateBegin,dateEnd);
    }

    @RequestMapping(value = "api/query4")
    public List<Map<String, Object>>question4(@RequestBody RequestData date)
    {
        String dateBegin = date.getDateBegin();
        String dateEnd = date.getDateEnd();


        if( dateBegin == null || dateEnd == null )
            return liveliHoodService.question4("20181030","20181030");
        else
            return liveliHoodService.question4(dateBegin,dateEnd);
    }

    @RequestMapping( value = "/api/alert1" )
    public List<Map<String, Object>> alert1()
    {
        return liveliHoodService.alert1();
    }

    @GetMapping(value = "/api/alert2")
    public List<Map<String, Object>> alert2()
    {
        return liveliHoodService.alert2();
    }

    @PostMapping(value = "api/updateLiveData")
    public int addLiveDataOne(@RequestBody LiveDataOne one)
    {
        if (liveliHoodService.addLiveDataOne(one))
            return 1;
        else
            return 0;
    }

    @PostMapping(value = "api/finishLiveData")
    public String finishLiveData(@RequestBody List<Map<String, String>> datas)
    {
        return liveliHoodService.finishLiveData(datas);
    }
}
