package com.teamdevelop.firstprototype;

import lombok.Data;

import java.util.HashMap;

@Data
public class addLiveDataMap {
    HashMap<String, String> street = new HashMap<String, String>();
    HashMap<String, String> community = new HashMap<String, String>();
    HashMap<String, String> eventType = new HashMap<String, String>();
    HashMap<String, String> mainType = new HashMap<String, String>();
    HashMap<String, String> subType = new HashMap<String, String>();
    HashMap<String, String> dispose = new HashMap<String, String>();
    HashMap<String, String> eventSrc = new HashMap<String, String>();
    HashMap<String, String> eventProperty = new HashMap<String, String>();

    public void completeMap()
    {
        street.put("碧岭街道", "100");
        street.put("坑梓街道", "105");
        street.put("龙田街道", "101");
        street.put("马峦街道", "102");
        street.put("石井街道", "103");
        street.put("坪山街道", "104");
        street.put("-", "-");

        community.put("马峦社区", "10000");
        community.put("金龟社区", "10001");
        community.put("汤坑社区", "10002");
        community.put("江岭社区", "10003");
        community.put("坪环社区", "10004");
        community.put("坪山社区", "10005");
        community.put("沙坣社区", "10006");
        community.put("六联社区", "10007");
        community.put("田头社区", "10008");
        community.put("碧岭社区", "10009");
        community.put("沙湖社区", "10010");
        community.put("田心社区", "10011");
        community.put("六和社区", "10012");
        community.put("竹坑社区", "10013");
        community.put("老坑社区", "10014");
        community.put("坑梓社区", "10015");
        community.put("和平社区", "10016");
        community.put("石井社区", "10017");
        community.put("南布社区", "10018");
        community.put("金沙社区", "10019");
        community.put("龙田社区", "10020");
        community.put("沙田社区", "10021");
        community.put("秀新社区", "10022");
        community.put("-", "-");

        eventType.put("安全隐患", "1");
        eventType.put("治安维稳", "2");
        eventType.put("环保水务", "3");
        eventType.put("规土城建", "4");
        eventType.put("市容环卫", "5");
        eventType.put("市政设施", "6");
        eventType.put("交通运输", "7");
        eventType.put("劳动社保", "8");
        eventType.put("食药市监", "9");
        eventType.put("文体旅游", "10");
        eventType.put("教育卫生", "11");
        eventType.put("组织人事", "12");
        eventType.put("党建群团", "13");
        eventType.put("党纪政纪", "14");
        eventType.put("民政服务", "15");
        eventType.put("统一战线", "16");
        eventType.put("社区管理", "17");
        eventType.put("专业事件采集", "695");
        eventType.put("-", "-");

        mainType.put("车辆乱停放", "179");
        mainType.put("公用部件", "185");
        mainType.put("建设工程质量", "49");
        mainType.put("绿化养护", "176");
        mainType.put("禽畜养殖污染", "138");
        mainType.put("占道经营", "178");
        mainType.put("-", "-");

        subType.put("机动车乱停放", "605");
        subType.put("非机动车乱停放", "606");
        subType.put("下水井盖", "630");
        subType.put("上水井盖", "629");
        subType.put("施工安全隐患", "292");
        subType.put("房屋质量安全隐患", "291");
        subType.put("绿化带养护", "591");
        subType.put("树木养护", "589");
        subType.put("养殖废气", "483");
        subType.put("饲养宠物家禽扰民", "482");
        subType.put("店外经营", "603");
        subType.put("无照经营游商", "602");
        subType.put("-", "-");

        dispose.put("城建办", "9444");
        dispose.put("环境保护和水务局", "1536");
        dispose.put("教育局", "1500");
        dispose.put("民政局", "1510");
        dispose.put("人力资源局", "1529");
        dispose.put("土地整备局", "1655");
        dispose.put("卫生和计划生育局", "1565");
        dispose.put("-", "-");

        eventSrc.put("政府信箱", "104");
        eventSrc.put("美丽深圳", "102");
        eventSrc.put("固化投诉", "106");
        eventSrc.put("12345", "13");
        eventSrc.put("12319", "12");
        eventSrc.put("@坪山", "103");
        eventSrc.put("-", "-");

        eventProperty.put("感谢", "5");
        eventProperty.put("建议", "4");
        eventProperty.put("求决", "1");
        eventProperty.put("投诉", "2");
        eventProperty.put("咨询", "3");
        eventProperty.put("其他", "6");
        eventProperty.put("-", "-");
    }
    public addLiveDataMap()
    {
        completeMap();
    }
}
