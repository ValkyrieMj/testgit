package com.teamdevelop.firstprototype.service;

import com.teamdevelop.firstprototype.LiveDataOne;
import com.teamdevelop.firstprototype.addLiveDataMap;
import com.teamdevelop.firstprototype.dao.LiveliHoodDao;
import com.teamdevelop.firstprototype.entity.LiveliHoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: LiveliHoodService
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/4 22:52
 * @description: 民生数据返回和处理,服务层
 */

@Service
public class LiveliHoodService
{
    @Autowired
    LiveliHoodDao LiveliHoodDao;



    public List<Map<String, Object>>question1(String dateBegin, String dateEnd)
    {
        return LiveliHoodDao.question1(dateBegin, dateEnd);
    }

    public List<Map<String, Object>>question2(String dateBegin, String dateEnd)
    {
        return LiveliHoodDao.question2(dateBegin, dateEnd);
    }

    public List<Map<String, Object>>question3(String dateBegin, String dateEnd)
    {
        return LiveliHoodDao.question3(dateBegin, dateEnd);
    }

    public List<Map<String, Object>>question4(String dateBegin, String dateEnd)
    {
        return LiveliHoodDao.question4(dateBegin, dateEnd);
    }

    public List<Map<String, Object>> alert1()
    {
        // List<Map<String, String>> ans = new ArrayList<Map<String, String>>();
        // Map<String, String> message = new HashMap<String, String>();
        return LiveliHoodDao.alert1();
//        String tmp;
//        List<Map< String, AlertObject >> lists = LiveliHoodDao.alert1();
//        for (Map< String, AlertObject> list : lists) {
//            tmp = "2018年10月30日" + list.get("STREET_NAME") + "的" + list.get("COMMUNITY_NAME") + "从" + list.get("EVENT_SRC_NAME")
//                    + "接到" + list.get("SUB_TYPE_NAME") + list.get("EVENT_PROPERTY_NAME") + "，请" + list.get("DISPOSE_UNIT_NAME")
//                    + "尽快前往处理";
//            Map<String, String> message = new HashMap<String, String>();
//            message.put("message", tmp);
//            ans.add(message);
//        }
//        return ans;
    }

    public List<Map<String, Object>> alert2()
    {
        List<Map<String, Object>> lists =  LiveliHoodDao.alert2();
        String str;
        int tot = 0;
        for (int i = 5; i < lists.size(); i++) {
            Map<String, Object> tmp = lists.get(i);
            // System.out.println(tmp.get("COMMUNITY_NAME"));
            BigInteger tmpBig = (BigInteger) tmp.get("total");
            tot += Integer.valueOf(tmpBig.toString());
        }
        for (int i = 5; i < lists.size();)
            lists.remove(i);
        Map<String, Object> tmp = new HashMap<String, Object>();
        tmp.put("COMMUNITY_NAME", "其他19个社区");
        tmp.put("total", tot);
        lists.add(tmp);
        return lists;
    }

    public boolean addLiveDataOne(LiveDataOne one)
    {
        LiveliHoodInfo data = new LiveliHoodInfo();
        addLiveDataMap map = new addLiveDataMap();

        if (one.getCommunity().equals("-") || one.getDispose().equals("-") || one.getEventProperty().equals("-") ||
            one.getEventSrc().equals("-") || one.getEventType().equals("-") || one.getMainType().equals("-") ||
            one.getStreet().equals("-") || one.getSubType().equals("-"))
            return false;
        data.setReportNumber("1");
        data.setCreateTime(one.getTime());
        // System.out.println(one.getTime());
        data.setDistrictName("坪山区");
        data.setDistrictID("1");
        data.setStreetName(one.getStreet());
        data.setStreetID(map.getStreet().get(one.getStreet()));
        data.setCommunityName(one.getCommunity());
        data.setCommunityID(map.getCommunity().get(one.getCommunity()));
        data.setEventTypeName(one.getEventType());
        data.setEventTypeId(map.getEventType().get(one.getEventType()));
        data.setMainTypeName(one.getMainType());
        data.setMainTypeId(map.getMainType().get(one.getMainType()));
        data.setSubTypeName(one.getSubType());
        data.setSubTypeID(map.getSubType().get(one.getSubType()));
        data.setDisposeUnitName(one.getDispose());
        // System.out.println(map.getDispose().get(one.getDispose()));
        data.setDisposeUnitId(map.getDispose().get(one.getDispose()));
        data.setEventSourceName(one.getEventSrc());
        data.setEventSourceId(map.getEventSrc().get(one.getEventSrc()));
        data.setEventPropertyName(one.getEventProperty());
        data.setEventPropertyId(map.getEventProperty().get(one.getEventProperty()));
        data.setOperateNum("1");
        data.setOverTimeArchiveNum("0");
        data.setInTimeToArchiveNum("1");
        data.setInTimeArchiveNum("0");
        data.setEventType("处置中");
        LiveliHoodDao.save(data);
        return true;
    }

    public String finishLiveData(List<Map<String, String>> datas)
    {
        List<LiveliHoodInfo> dataChange = new ArrayList<LiveliHoodInfo>();
        for (Map<String, String> id :datas) {
            LiveliHoodInfo data = LiveliHoodDao.findByRecID(Integer.parseInt(id.get("ID")));
            System.out.println(id.get("ID"));
            if (data == null)
                return "ID error";
            else {
                data.setEventType("按期结办");
                data.setInTimeArchiveNum("1");
                data.setInTimeToArchiveNum("0");
                dataChange.add(data);
            }
        }
        LiveliHoodDao.saveAll(dataChange);
        return "success";
    }
}
